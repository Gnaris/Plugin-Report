package fr.gnaris.commands.instruction;

import org.bukkit.entity.Player;

public class Help {
	
	public static void valienthelp(Player sender)
	{	
		sender.sendMessage("§7Voici la liste des commandes :");
		sender.sendMessage("§a/report §f<Message>");
		sender.sendMessage("§a/vr help");
		if(sender.isOp())
		{
			sender.sendMessage("§a/vr add admin §f<Joueur>");
			sender.sendMessage("§a/vr remove admin §f<Joueur>");
		}
		if(AdminConfiguration.isAdmin(sender))
		{
			sender.sendMessage("§a/vr tp §f<Joueur>");
			sender.sendMessage("§a/vr spectate §f<Joueur>");
			sender.sendMessage("§a/vr stop");
		}
	}
}
