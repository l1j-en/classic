/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l1j.server.accountmanager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javolution.util.FastList;
import l1j.server.Database.L1DatabaseFactory;
import l1j.server.config.Config;
import l1j.server.server.encryptions.Base64;

public class SQLAccountManager
{
    private static String _mode = "";
	private static String _ip = "";
	private static String _lastactive = "";
	private static String _password = "";
	private static String _banned = "";
	private static String _host = "";
	private static String _access_level = "";
	private static String _login = "";
    
    public static void main(String[] args) throws SQLException, IOException, NoSuchAlgorithmException
    {
        Config.load();
        System.out.println("Please choose an option:");
        System.out.println("");
        System.out.println("1 - Create new account or update existing one (change pass and access level).");
        System.out.println("2 - Change access level.");
        System.out.println("3 - Delete existing account.");
        System.out.println("4 - List accounts & access levels.");
        System.out.println("5 - Exit.");
        LineNumberReader _in = new LineNumberReader(new InputStreamReader(System.in));
        while (!(_mode.equals("1") || _mode.equals("2") || _mode.equals("3")
                || _mode.equals("4") || _mode.equals("5")) )
        {
            System.out.print("Your choice: ");
            _mode = _in.readLine();
        }
        
        if (_mode.equals("1") || _mode.equals("2") || _mode.equals("3"))
        {
            if (_mode.equals("1") || _mode.equals("2"))
                while (_login.length() == 0)
                {
                    System.out.print("Username: ");
                    _login = _in.readLine().toLowerCase();
                }
            else if (_mode.equals("3"))
                while (_login.length() == 0)
                {
                    System.out.print("Account name: ");
                    _login = _in.readLine().toLowerCase();
                }
            
            if (_mode.equals("1"))
                while (_password.length() == 0)
                {
                    System.out.print("Password: ");
                    _password = _in.readLine();
                }
            
            if (_mode.equals("1") || _mode.equals("2"))
                while (_access_level.length() == 0)
                {
                    System.out.print("Access level: ");
                    _access_level = _in.readLine();
                }
            
        }
        
        if (_mode.equals("1"))
            // Add or Update
            addOrUpdateAccount(_login, _password, _lastactive, _access_level, _ip, _host, _banned);
        else if(_mode.equals("2"))
            // Change Level
            changeAccountLevel(_login,_access_level);
        else if(_mode.equals("3")) {
            // Delete
            System.out.print("Do you really want to delete this account ? Y/N : ");
            String yesno = _in.readLine();
            if (yesno.equalsIgnoreCase("Y"))
                deleteAccount(_login);
            else
                System.out.println("Deletion cancelled");
            
        } else if(_mode.equals("4")) {
            // List
            _mode="";
            System.out.println("");
            System.out.println("Please choose a listing mode:");
            System.out.println("");
            System.out.println("1 - Banned accounts only (access_Level < 0)");
            System.out.println("2 - GM/privileged accounts (access_Level > 0)");
            System.out.println("3 - Regular accounts only (access_Level = 0)");
            System.out.println("4 - List all");
            while (!(_mode.equals("1") || _mode.equals("2") || _mode.equals("3") || _mode.equals("4")))
            {
                System.out.print("Your choice: ");
                _mode = _in.readLine();
            }
            System.out.println("");
            printAccInfo(_mode);
        }
        return;
    }
    
    private static void printAccInfo(String m) throws SQLException
    {
        int count = 0;
        java.sql.Connection con = null;
        con = L1DatabaseFactory.getInstance().getConnection();
        String q = "SELECT login, access_level FROM accounts ";
        if (m.equals("1"))
            q=q.concat("WHERE access_level<0");
        else if (m.equals("2"))
            q=q.concat("WHERE access_level>0");
        else if (m.equals("3"))
            q=q.concat("WHERE access_level=0");
        q=q.concat(" ORDER BY login ASC");

        PreparedStatement statement = con.prepareStatement(q);
        ResultSet rset = statement.executeQuery();
        while (rset.next())
        {
            System.out.println(rset.getString("login")	+ " -> " + rset.getInt("access_level"));
            count++;
        }
        rset.close();
        statement.close();
        System.out.println("Displayed accounts: " + count + ".");
    }
    
    private static void addOrUpdateAccount(String account,String password, String level, String _access_level2, String _ip2, String _host2, String _banned2) throws IOException, SQLException, NoSuchAlgorithmException
    {
        // Encode Password
        MessageDigest md = MessageDigest.getInstance("SHA");
        byte[] newpass;
        newpass = password.getBytes("UTF-8");
        newpass = md.digest(newpass);
        
        // Add to Base
        java.sql.Connection con = null;
        con = L1DatabaseFactory.getInstance().getConnection();
        PreparedStatement statement = con.prepareStatement("REPLACE	accounts (login, password, lastactive, access_level, ip, host, banned) VALUES (?,?,?,?,?,?,?)");
        statement.setString(1, account);
        statement.setString(2, Base64.encodeBytes(newpass));
        statement.setString(3, level);
        statement.executeUpdate();
        statement.close();
    }
    
    private static void changeAccountLevel(String login, String access_Level) throws SQLException
    {
        java.sql.Connection con = null;
        con = L1DatabaseFactory.getInstance().getConnection();
        
        // Check Account Exist
        PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM accounts WHERE login=?;");
        statement.setString(1, login);
        ResultSet rset = statement.executeQuery();
        if(rset.next()==false) {
            System.out.println("False");
            
        } else if(rset.getInt(1)>0) {
            
            // Exist
            
            // Update
            statement = con.prepareStatement("UPDATE accounts SET access_Level=? WHERE login=?;");
            statement.setEscapeProcessing(true);
            statement.setString(1, access_Level);
            statement.setString(2, login);
            statement.executeUpdate();
            
            System.out.println("Account " + login + " has been updated.");
        } else {
            // Not Exist
            System.out.println("Account " + login + " does not exist.");
        }
        rset.close();
        
        // Close Connection
        statement.close();
    }
    
    private static void deleteAccount(String account) throws SQLException
    {
        java.sql.Connection con = null;
        con = L1DatabaseFactory.getInstance().getConnection();
        
        // Check Account Exist
        PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM accounts WHERE login=?;");
        statement.setString(1, account);
        ResultSet rset = statement.executeQuery();
        if(rset.next()==false)
        {
            System.out.println("False");
            rset.close();
        }
        else if(rset.getInt(1)>0) 
        {
            rset.close();
            // Account exist
            
            // Get Accounts ID
            ResultSet rcln;
            statement = con.prepareStatement("SELECT char_id, char_name, ClanID FROM characters WHERE account_name=?;");
            statement.setEscapeProcessing(true);
            statement.setString(1, account);
            rset = statement.executeQuery();
            
            FastList<String> objIds = new FastList<String>();
            FastList<String> charNames = new FastList<String>();
            FastList<String> clanIds = new FastList<String>();
            
            while (rset.next())
            {
                objIds.add(rset.getString("char_id"));
                charNames.add(rset.getString("char_name"));
                clanIds.add(rset.getString("clan_id"));
            }
            rset.close();
            
            for (int index = 0; index < objIds.size(); index++)
            {
                System.out.println("Deleting character " + charNames.get(index) + ".");
                
                // Check If clan leader Remove Clan and remove all from it
                statement.close();
                statement = con.prepareStatement("SELECT COUNT(*) FROM clan_data WHERE leader_id=?;");
                statement.setString(1, clanIds.get(index));
                rcln = statement.executeQuery();
                rcln.next();
                if(rcln.getInt(1)>0) 
                {
                    rcln.close();
                    // Clan Leader
                    
                    // Get Clan Name
                    statement.close();
                    statement = con.prepareStatement("SELECT clan_name FROM clan_data WHERE leader_id=?;");
                    statement.setString(1, clanIds.get(index));
                    rcln = statement.executeQuery();
                    rcln.next();
                       
                    System.out.println("Deleting clan " + rcln.getString("clan_name") + ".");
                    
                    rcln.close();
                    
                    // Remove All From clan
                    statement.close();
                    statement = con.prepareStatement("UPDATE characters SET clan_id=0 WHERE clan _id=?;");
                    statement.setString(1, clanIds.get(index));
                    statement.executeUpdate();
                    // Delete Clan
                    statement.close();
                    statement = con.prepareStatement("DELETE FROM clan_data WHERE clan_id=?;");
                    statement.setString(1, clanIds.get(index));
                    statement.executeUpdate();                           
                }
                else
                    rcln.close();
                
                // skills
                statement.close();
                statement = con.prepareStatement("DELETE FROM character_skills WHERE char_obj_id=?;");
                statement.setString(1, objIds.get(index));
                statement.executeUpdate();
          
                // items
                statement.close();
                statement = con.prepareStatement("DELETE FROM vharacter_items WHERE char_id=?;");
                statement.setString(1, objIds.get(index));
                statement.executeUpdate();
                       
                // quests
                statement.close();
                statement = con.prepareStatement("DELETE FROM character_quests WHERE char_id=?;");
                statement.setString(1, objIds.get(index));
                statement.executeUpdate();
                
                // friends
                statement.close();
                statement = con.prepareStatement("DELETE FROM character_buddys WHERE char_id=?;");
                statement.setString(1, objIds.get(index));
                statement.executeUpdate();
                
                // characters
                statement.close();
                statement = con.prepareStatement("DELETE FROM characters WHERE objid=?;");
                statement.setString(1, objIds.get(index));
                statement.executeUpdate();

            }
            
            // Delete Account
            statement.close();
            statement = con.prepareStatement("DELETE FROM accounts WHERE login=?;");
            statement.setEscapeProcessing(true);
            statement.setString(1, account);
            statement.executeUpdate();
            
            System.out.println("Account " + account + " has been deleted.");
        } else {
            // Not Exist
            System.out.println("Account " + account + " does not exist.");
        }
        
        // Close Connection
        statement.close();
        con.close();
    }
    
}
