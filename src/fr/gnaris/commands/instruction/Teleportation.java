package fr.gnaris.commands.instruction;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.gnaris.config.Config;

public class Teleportation {
	
	public static void Tp(Player sender, Player target) 
	{	
		if(target != null)
		{
			sender.teleport(target.getLocation());
				for(String admins : Config.ListKey("administrator"))
				{
					Player admin = Bukkit.getPlayerExact(admins);
					if(admin != null) 
					{
						if(admin.getName() != sender.getName()) 
						{
							admin.sendMessage("§7[Valient Report] " + sender.getName() + " est partie aider " + target.getName());
						}
					}
			}
		}
	}
	
	public static void TpInvisible(Player sender, Player target) 
	{	
		if(target != null)
		{
			sender.setGameMode(GameMode.SPECTATOR);
			sender.teleport(target.getLocation());
			sender.sendMessage("§aPour redevenir comme avant faites §e/vr stop");
			for(String admins : Config.ListKey("administrator"))
			{
				Player admin = Bukkit.getPlayerExact(admins);
				if(admin != null)
				{
					if(admin.getName() != sender.getName()) 
					{
						admin.sendMessage("§7[Valient Report] " + sender.getName() + " s'est mis en spectateur sur " + target.getName());
					}
				}
			}
		}
		else
		{
		sender.sendMessage(Config.GetString("§cCe joueur n'existe pas !"));
		}
	}
	
	public static void Stop(Player sender) 
	{	
		if(sender.getGameMode() == GameMode.SPECTATOR)
		{
			if(sender.isOp())
			{
				sender.setGameMode(GameMode.CREATIVE);
			}
			else
			{
				sender.setGameMode(GameMode.SURVIVAL);
			}
			sender.sendMessage("§aVous êtes redevenu normal !");
		}
		else 
		{
			sender.sendMessage("§cVous n'êtes pas en mode spectateur !");
		}
	}
}
