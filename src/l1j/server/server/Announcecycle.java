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
package l1j.server.server;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collection;
import javolution.util.FastList;

import l1j.server.Config;
import l1j.server.server.model.L1World;
import l1j.server.server.model.Instance.L1PcInstance;
import l1j.server.server.serverpackets.S_SystemMessage;

public class Announcecycle {
        private static Logger _log = Logger.getLogger(Announcecycle.class.getName());

        private static Announcecycle _instance;

        private List<String> _ingamenews = new FastList<String>();

        private int _ingamenewssize = 0;

        private Announcecycle() {
           loadAnnouncecycle();
        }

        public static Announcecycle getInstance() {
                if (_instance == null) {
                        _instance = new Announcecycle();
                }
                return _instance;
        }

        public void loadAnnouncecycle() {
                _ingamenews.clear();
                File file = new File("data/ingamenews.txt");
                if (file.exists()) {
                   readFromDiskmulti(file);
                   doAnnouncecycle(); 
                } else {
                	System.out.println("data/ingamenews.txt loaded.");
                }
        }

        private void readFromDiskmulti(File file) {
                LineNumberReader lnr = null;
                try {
                        int i=0;
                        String line = null;
                        lnr = new LineNumberReader(new FileReader(file));
                        while ( (line = lnr.readLine()) != null) { 
                                StringTokenizer st = new StringTokenizer(line,"\n\r"); 
                                if (st.hasMoreTokens()) {
                                    String showAnnouncecycle = st.nextToken(); 
                                    _ingamenews.add(showAnnouncecycle);
                                    i++;
                                }
                        }
                        System.out.println("IngameNews: Loaded " + i + " ingamenews.");
                } catch (IOException e1)
                {
                        _log.log(Level.SEVERE, "Error reading ingamenews", e1);
                } finally {
                        try {
                                lnr.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        public void doAnnouncecycle() {
           AnnouncTask rs = new AnnouncTask();
           GeneralThreadPool.getInstance().scheduleAtFixedRate(rs, 60000, (Config.Show_INGAMENEWS_Time * 60000));     
        }

        /** The task launching the function doIngamenewsCycle() */
        class AnnouncTask implements Runnable {
                public void run() {
                        try {
                                ShowAnnounceToAll(_ingamenews.get(_ingamenewssize)); 
                                _ingamenewssize++;
                                if(_ingamenewssize >= _ingamenews.size())
                                  _ingamenewssize = 0;
                        }
                        catch (Exception e) {
                           _log.log(Level.WARNING, "", e);
                        }
                }
        }

        private void ShowAnnounceToAll(String msg) {
                Collection <L1PcInstance> allpc = L1World.getInstance().getAllPlayers();
                for ( L1PcInstance pc : allpc )
                    pc.sendPackets( new S_SystemMessage(msg));
        }
}