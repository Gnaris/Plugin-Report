package fr.gnaris.cooldown;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.gnaris.config.Config;

public class Cooldown {
	
	public static Map<UUID, Long> cooldownReport;
	public static int cooldownReportTime;
	
	public static void init()
	{
		cooldownReport = new HashMap<>();
		cooldownReportTime = Config.GetInt("cooldown_of_report");
	}
	
	public static void SetCooldownRandomTeam(Player sender)
	{
		cooldownReport.put(sender.getUniqueId(), System.currentTimeMillis() / 1000);
	}
	
	public static boolean CheckCooldownRandomTeam(Player sender)
	{
		boolean response = false;
		
		if(!cooldownReport.containsKey(sender.getUniqueId()) || ((cooldownReport.get(sender.getUniqueId()) + cooldownReportTime) <= (System.currentTimeMillis() / 1000))) 
		{
			response = true;
		}
		return response;
	}
}
