/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * http://www.gnu.org/copyleft/gpl.html
 */
package l1j.server.server.command.executor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import l1j.server.database.L1DatabaseFactory;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class L1Search implements L1CommandExecutor {
	private static Logger _log = Logger.getLogger(L1Search.class.getName());

	private L1Search() {
	}

	public static L1CommandExecutor getInstance() {
		return new L1Search();
	}

	@Override
	public void execute(L1PcInstance pc, String cmdName, String arg) {
			try{
				StringTokenizer st = new StringTokenizer(arg);
				String type = "";
				String name = "";
				String add = "";
				boolean simpleS=true;
				int itCount=0;
				while(st.hasMoreTokens()){
					if(itCount==1){
						add="%";
					}
					String tempVar = st.nextToken();
					if(itCount==0 && (tempVar.equals("armor") || tempVar.equals("weapon") || tempVar.equals("misci") ||  tempVar.equals("npc"))){
						simpleS=false;
						type=tempVar;
					}
					else{
						name=name+add+tempVar;
					}
					itCount++;
				}
				if (simpleS==false) {
					find_object(pc, type, name);
				}
				else {
					find_object(pc, name);
				}
			} catch (Exception e) {
				pc.sendPackets(new S_SystemMessage(".find (type[armor,misci,weapon,npc]) searchText"));
			}
		}


	private void find_object(L1PcInstance pc, String type, String name){
		try{
		   String str1 = null;
		   String str2 = null;
		   int bless = 0;
		   int count = 0;
		   java.sql.Connection con = null;
		   con = L1DatabaseFactory.getInstance().getConnection();
		   PreparedStatement statement = null;
		   boolean error = false;

		   pc.sendPackets(new S_SystemMessage(" "));
		   
		   if(type.equals("misci")){
			   statement = con.prepareStatement("select item_id,name,bless from etcitem where name Like '%" + name + "%'");
		   }
		   else if(type.equals("weapon")){
			   statement = con.prepareStatement("select item_id,name,bless from weapon where name Like '%" + name + "%'");
		   }
		   else if(type.equals("armor")){
			   statement = con.prepareStatement("select item_id,name,bless from armor where name Like '%" + name + "%'");
		   }
		   else if(type.equals("poly")){
			   statement = con.prepareStatement("select polyid,name from polymorphs where name Like '%" + name + "%'");
		   }
		   else if(type.equals("npc")){
			   statement = con.prepareStatement("select npcid,name from npc where name Like '%" + name + "%'");
		   }
		   else{
			   error = true;
			   pc.sendPackets(new S_SystemMessage(".find type[armor,misci,weapon,npc] searchText"));
		   }
		   String blessed = null;
		   if(error == false){
			   ResultSet rs = statement.executeQuery();
			   pc.sendPackets(new S_SystemMessage("Searching " + type + " for '" + name.replace("%"," ") + "'"));
			   while (rs.next()){
				   str1 = rs.getString(1);
				   str2 = rs.getString(2);
				   if(type.equals("misci") || type.equals("weapon") || type.equals("armor")){
					   bless = rs.getInt(3);
					   if(bless == 1){
						   blessed = "";
					   }
					   else if(bless == 0){
						   blessed = "\\fR";
					   }
					   else{
						   blessed = "\\fY";
					   }
					   pc.sendPackets(new S_SystemMessage(blessed + "ID: " + str1 + ", " + str2));
				   }
				   else {
					   pc.sendPackets(new S_SystemMessage("ID: " + str1 + ", " + str2));
				   }
				   count++;
			   }
			   rs.close();
			   statement.close();
			   con.close();
			   pc.sendPackets(new S_SystemMessage("Found " + count + " instance(s) that matched " + type + "."));
		   }
		}catch (Exception e){
		}
	}

	private void find_object(L1PcInstance pc, String name){
		try{
		   String str1 = null;
		   String str2 = null;
		   int bless = 0;
		   String blessed = null;
		   
		   java.sql.Connection con = null;
		   con = L1DatabaseFactory.getInstance().getConnection();
		   PreparedStatement statement = null;
		   pc.sendPackets(new S_SystemMessage(" "));
		   pc.sendPackets(new S_SystemMessage("Searching for '" + name.replace("%"," ") + "' in all places:"));
		   statement = con.prepareStatement("select item_id,name,bless from armor where name Like '%" + name + "%'");
		   int count1 = 0;
		   ResultSet rs = statement.executeQuery();
		   while (rs.next()){
			   if(count1==0){
			   pc.sendPackets(new S_SystemMessage("Armors:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   bless = rs.getInt(3);
			   if(bless == 1){
				   blessed = "";
			   }
			   else if(bless == 0){
				   blessed = "\\fR";
			   }
			   else{
				   blessed = "\\fY";
			   }
			   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
			   count1++;
		   }
		   rs.close();
		   statement.close();
		   statement = con.prepareStatement("select item_id,name,bless from weapon where name Like '%" + name + "%'");
		   int count2 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count2==0){
			   pc.sendPackets(new S_SystemMessage("Weapons:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   bless = rs.getInt(3);
			   if(bless == 1){
				   blessed = "";
			   }
			   else if(bless == 0){
				   blessed = "\\fR";
			   }
			   else{
				   blessed = "\\fY";
			   }
			   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
			   count2++;
		   }
		   rs.close();
		   statement.close();
		   statement = con.prepareStatement("select item_id,name,bless from etcitem where name Like '%" + name + "%'");
		   int count3 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count3==0){
				pc.sendPackets(new S_SystemMessage("Etcitems:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   bless = rs.getInt(3);
			   if(bless == 1){
				   blessed = "";
			   }
			   else if(bless == 0){
				   blessed = "\\fR";
			   }
			   else{
				   blessed = "\\fY";
			   }
			   pc.sendPackets(new S_SystemMessage(blessed+"ID: "+ str1 + ", " + str2));
			   count3++;
		   }
		   rs.close();
		   statement.close();
		   statement = con.prepareStatement("select polyid,name from polymorphs where name Like '%" + name + "%'");
		   int count4 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count4==0){
				   pc.sendPackets(new S_SystemMessage("Polymorphs:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   pc.sendPackets(new S_SystemMessage("ID: "+ str1 + ", " + str2));
			   count4++;
		   }
		   rs.close();
		   statement.close();
		   statement = con.prepareStatement("select npcid,name from npc where name Like '%" + name + "%'");
		   int count5 = 0;
		   rs = statement.executeQuery();
		   while (rs.next()){
			   if(count5==0){
			   pc.sendPackets(new S_SystemMessage("NPCs:"));
			   }
			   str1 = rs.getString(1);
			   str2 = rs.getString(2);
			   pc.sendPackets(new S_SystemMessage("ID: "+ str1 + ", " + str2));
			   count5++;
		   }
		   rs.close();
		   statement.close();
		   con.close();

		   pc.sendPackets(new S_SystemMessage("Found:"));
		   String found="";
		   if(count1>0) {
			   found+=count1+" Armors,";
		   }
		   if(count2>0) {
			   found+=count2+" Weapons,";
		   }
		   if(count3>0) {
			   found+=count3+" Etcitems,";
		   }
		   if(count4>0) {
			   found+=count4+" Polymorphs,";
		   }
		   if(count5>0) {
			   found+=count5+" NPCs.";
		   }
		   if(found.length()>0) {
			   found=found.substring(0, found.length()-1)+".";
		   } else {
			   found="Nothing";
		   }
		   pc.sendPackets(new S_SystemMessage(found));
		}catch (Exception e){
		}
	}
}