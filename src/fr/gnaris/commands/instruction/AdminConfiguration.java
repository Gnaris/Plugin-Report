package fr.gnaris.commands.instruction;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import fr.gnaris.config.Config;

public class AdminConfiguration {
	
	public static Map<String, String> adminlists;
	
	public static void Init()
	{
		for(String name : Config.ListKey("administrator"))
		{
			adminlists = new HashMap<>();
			adminlists.put(name, Config.GetString("administrator."+name+".UUID"));
		}
	}
	
	public static void AddAdmin(Player sender, Player target) 
	{
		if(target != null)
		{
			String UUID = target.getUniqueId().toString();
			String ConfigUUID = Config.GetString("administrator." + target.getName() + ".UUID");
			if(ConfigUUID == null)
			{
			// ADD ADMIN IN CONFIG.YML
				Config.main.getConfig().set("administrator." + target.getName() + ".UUID", UUID);
				Config.main.saveConfig();
				adminlists.put(target.getName(), UUID);
				sender.sendMessage("§aLe joueur §e" + target.getName() + " §aa bien été ajouté dans la liste !");
			}
			else
			{
				sender.sendMessage("§cCe joueur est déjà admin !");
			}
		}
		else
		{
			sender.sendMessage("§cJoueur inexistant");
		}
	}
	
	public static void RemoveAdmin(Player sender, Player target) 
	{		
		if(target != null)
		{
			String ConfigUUID = Config.GetString("administrator." + target.getName() + ".UUID");
			if(ConfigUUID != null)
			{
				// REMOVE ADMIN IN CONFIG.YML
				Config.main.getConfig().set("administrator."+ target.getName() + ".UUID", null);
				Config.main.getConfig().getConfigurationSection("administrator").set(target.getName(), null);;
				Config.main.saveConfig();
				sender.sendMessage("§aLe joueur §e" + target.getName() + " §aa bien été supprimé de la liste !");
				adminlists.remove(target.getName());
			}
			else
			{
				sender.sendMessage("§cCe joueur n'est pas admin !");
			}
		}
		else
		{
			sender.sendMessage("§cJoueur inexistant");
		}
	}
	
	public static boolean isAdmin(Player sender) 
	{
		boolean response = false;
		if(adminlists.containsKey(sender.getName()))
		{
			response = true;
		}
		return response;
	}
}
