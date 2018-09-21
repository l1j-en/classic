package l1j.server.ssh.command;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import l1j.server.server.datatables.CastleTable;
import l1j.server.server.templates.L1Castle;

class GetSiegeTimes implements Commands {
	@Override
	public String execute(String args) {
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
			List<L1Castle> castles = Arrays.asList(CastleTable.getInstance().getCastleTableList());
			// order the castles alphabetically
			Collections.sort(castles, new Comparator<L1Castle>() {
				@Override public int compare(L1Castle c1, L1Castle c2) {
		            return c1.getName().compareTo(c2.getName()) ;
		        }
			});
			
			StringBuilder json = new StringBuilder("[\n");
			
			String separator = "";
			for(L1Castle castle: castles) {
				//TODO -- There is probably a better way to check if the castle is active
				if(castle.getWarTime().get(Calendar.YEAR) > 2008) {
					json.append(separator + "{\"name\":\"" + castle.getName() + "\", \"war_time\": \"" + 
							format.format(castle.getWarTime().getTime()) + "\"}");
					separator = ",\n";
				}
			}

			return json.toString() + "\n]";
		} catch(Exception ex) {
			return "getsiegetimes";
		}
	}

	public String formatMessage(String args) {
                return "GetSiegeTimes";
        }
}