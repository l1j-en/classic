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
package l1j.server.server.controllers;

import java.lang.reflect.Constructor;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import l1j.server.server.GeneralThreadPool;
import l1j.server.server.datatables.NpcTable;
import l1j.server.server.encryptions.IdFactory;
import l1j.server.server.model.L1Location;
import l1j.server.server.model.L1Object;
import l1j.server.server.model.L1Teleport;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1NpcInstance;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_ServerMessage;
import l1j.server.server.templates.L1Npc;
/**
 * Crack of time Controller
 */
public class CrackOfTimeController extends TimerTask {
        private final static Logger _log = Logger.getLogger(CrackOfTimeController.class.getName());
        private Timer _timeHandler = new Timer(true);
        private boolean _isOver = false;
        private int _startTime = 0;

        private static final int _delayTime = 5 * 600;
        private static final int _upTime = 19 * 60 * 60 * 1000 / 2;
        private static final int _downTime = 13 * 60 * 60 * 1000 / 2;
        
        private static final int[][] _crack = {
           { 32639, 32876, 780 },
           // { 32794, 32751, 783 }
        };

        private static final int[][] _cracklocactions = {
            { 32722, 32688, 4 }, { 32842, 32637, 4 }, { 32861, 32703, 4 },
            { 32934, 33413, 4 }, { 32970, 33242, 4 }, { 32920, 33160, 4 },
            { 34268, 33178, 4 }, { 34243, 33286, 4 }, { 34278, 33362, 4 }
        };

        private static CrackOfTimeController _instance;

        public static CrackOfTimeController getStart() {
                if (_instance == null) {
                    _instance = new CrackOfTimeController();
                }
                return _instance;
        }

        public void startCrackTime(){
             CrackOfTimeController.getStart();
        }

        private CrackOfTimeController() {
             _timeHandler.schedule(this, 500, 500);
             GeneralThreadPool.getInstance().execute(this);
        }
       
        private int _gatetime = 0;
        private boolean _gateopen = false;

        public void setMap784getaopen(boolean map784gateopen) {
            _gateopen = map784gateopen;
        }

        public boolean map784gateopen() {
            return _gateopen;
        }
        
        @Override
        public void run() {
                if (_isOver) {
                        try {
                                L1World.getInstance().broadcastPacketToAll(new S_ServerMessage(1468));
                                clear();
                                Thread.sleep(_downTime);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
                
                _startTime ++;
                _gatetime ++;

                int map784gatetimer = (150 * 600);
                if (_startTime == _delayTime) {
                    spawnCrack();
                }
                if (_startTime == _upTime) {
                    L1World.getInstance().broadcastPacketToAll(new S_ServerMessage(1467));
                }
                if (_startTime >= (_delayTime + _upTime)) {
                    _isOver = true;
                }
                if (_gatetime >= (_delayTime + map784gatetimer)) {
                    _gateopen = true;
                }
        }

        private void clear() {
            _startTime = 0;
            _isOver = false;
            _gatetime = 0;
            _gateopen = false;
        }

        private void spawnCrack() {
        	Random random = new Random();
                L1Location crack = null;
                L1Location crack_loc = null;
                
                // For the moment, only open portals to Thebes, since Tikal hasn't been
                // populated yet.
                int rnd1 = 0;
                // int rnd1 = random.nextInt(2);
                int rnd2 = random.nextInt(9);
                
                crack = new L1Location(_crack[rnd1][0], _crack[rnd1][1], _crack[rnd1][2]);
                crack_loc = new L1Location(_cracklocactions[rnd2][0], 
                		_cracklocactions[rnd2][1], _cracklocactions[rnd2][2]);
                L1World.getInstance().broadcastPacketToAll(new S_ServerMessage(1469));
                createCrack(crack.getX(), crack.getY(), (short) crack.getMapId(), crack_loc.getX(), 
                		crack_loc.getY(), (short) crack_loc.getMapId());
                createCrack(crack_loc.getX(), crack_loc.getY(), (short) crack_loc.getMapId(), 
                		crack.getX(), crack.getY(), (short) crack.getMapId());
        }

        private void createCrack(int x, int y, short mapId, int to_x, int to_y, short to_mapId) {
                try {
                        L1Npc l1npc = NpcTable.getInstance().getTemplate(90011);

                        if (l1npc == null) {
                            return;
                        }

                        String s = l1npc.getImpl();
                        Constructor<?> constructor = Class.forName("l1j.server.server.model.Instance." + 
                        		s + "Instance").getConstructors()[0];
                        Object aobj[] = { l1npc };
                        L1NpcInstance npc = (L1NpcInstance) constructor.newInstance(aobj);

                        npc.setId(IdFactory.getInstance().nextId());
                        npc.setX(x);
                        npc.setY(y);
                        npc.setMap(mapId);
                        npc.setHomeX(npc.getX());
                        npc.setHomeY(npc.getY());
                        npc.setHeading(0);

                        L1World.getInstance().storeObject(npc);
                        L1World.getInstance().addVisibleObject(npc);

                        Teleport teleport = new Teleport(npc, to_x, to_y, to_mapId);
                        GeneralThreadPool.getInstance().execute(teleport);
                } catch (Exception e) {
                        _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
                }
        }

        class Teleport implements Runnable {
                private L1NpcInstance _npc = null;
                private int _to_x = 0;
                private int _to_y = 0;
                private short _to_mapId = 0;

                public Teleport(L1NpcInstance npc, int to_x, int to_y, short to_mapId) {
                        _npc = npc;
                        _to_x = to_x;
                        _to_y = to_y;
                        _to_mapId = to_mapId;
                }

                public void run() {
                        try {
                                Thread.sleep(1000);
                                for (;;) {
                                        if (_npc._destroyed) {
                                            return;
                                        }

                                        for (L1Object obj : L1World.getInstance().getVisiblePoint(_npc.getLocation(), 1)) {
                                                if (obj instanceof L1PcInstance) {
                                                        L1PcInstance target = (L1PcInstance) obj;
                                                        L1Location tmp_loc = new L1Location(_to_x, _to_y, _to_mapId);
                                                        L1Location rnd_loc = tmp_loc.randomLocation(1, 5, false);
                                                        L1Teleport.teleport(target, rnd_loc.getX(), rnd_loc.getY(), 
                                                        		(short) rnd_loc.getMapId(), target.getHeading(), true);
                                                }
                                        }
                                        Thread.sleep(1000);
                                }
                        } catch (Exception e) {
                                _log.log(Level.SEVERE, e.getLocalizedMessage(), e);
                        }
                }
        }
}