package l1j.server.server.network;

import java.io.IOException;

/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import l1j.server.server.encryptions.ClientIdExistsException;
import l1j.server.server.encryptions.LineageEncryption;

public class PacketDecoder extends ByteToMessageDecoder {

	private static final byte[] FIRST_PACKET = { // 3.0 English KeyPacket
	(byte) 0x41, (byte) 0x5A, (byte) 0x9B, (byte) 0x01, (byte) 0xB6,
			(byte) 0x81, (byte) 0x01, (byte) 0x09, (byte) 0xBD, (byte) 0xCC,
			(byte) 0xC0 };
	
	
	@Override
	public void channelActive(final ChannelHandlerContext ctx) {
		System.out.println("New Connection2!");
		Client client = null;
		try {
			client = new Client(ctx.channel());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//client.channel = ctx.channel();
		NetworkServer.getInstance().getClients().put(ctx.channel().id(), client);
		
		long seed = 0x7C98BDFA; // 3.0 English Packet Seed
		byte Bogus = (byte) (FIRST_PACKET.length + 7);
		ctx.write(Bogus & 0xFF);
		ctx.write(Bogus >> 8 & 0xFF);

		ctx.write(0x7D); // 3.0 English Version Check.
		ctx.write((byte) (seed & 0xFF));
		ctx.write((byte) (seed >> 8 & 0xFF));
		ctx.write((byte) (seed >> 16 & 0xFF));
		ctx.write((byte) (seed >> 24 & 0xFF));
		ctx.write(FIRST_PACKET);
		ctx.flush();
		
		try {
			client.set_clkey(LineageEncryption.initKeys(ctx.channel().id(), seed));
		} catch (ClientIdExistsException e) {
		}
	}
	
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		System.out.println("readable " + in.readableBytes());
		int dataLength = 0;
		if (in.readableBytes() >= 2) {
			int hiByte = in.getByte(in.readerIndex()) & 0xff;
			int loByte = in.getByte(in.readerIndex() + 1) & 0xff;
			System.out.println("hi " + hiByte);
			System.out.println("lo " + loByte);
			dataLength = (loByte * 256 + hiByte) - 2;
		}
		System.out.println(dataLength);

		if (in.readableBytes() >= dataLength + 2) {
			byte[] frame = new byte[dataLength];
			in.getBytes(in.readerIndex() + 2, frame, 0, dataLength);
			in.readerIndex(in.readerIndex() + dataLength + 2);
			return frame;
		}
		return null;
	}

	@Override
	protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		Object decoded = decode(ctx, in);
		if (decoded != null) {
			out.add(decoded);
		}
	}

}
