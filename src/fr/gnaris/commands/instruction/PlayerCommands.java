package fr.gnaris.commands.instruction;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.gnaris.config.Config;
import fr.gnaris.cooldown.Cooldown;
import fr.gnaris.message.ReportMessage;

public class PlayerCommands {
	
	public static void Report(String[] args, Player sender) 
	{
		if(Cooldown.CheckCooldownRandomTeam(sender))
		{
			StringBuilder builder = new StringBuilder();
			for(String arg : args) 
			{
				builder.append(arg+ " ");
			}
			for(String name : Config.ListKey("administrator")) 
			{
				Player target = Bukkit.getPlayerExact(name);
				if(target != null)
				{
					ReportMessage.NotifyToAdmin(target, sender, builder.toString());
					Cooldown.SetCooldownRandomTeam(sender);
				}
			}
			sender.sendMessage("§c[Valient Report] §a Votre message est : "+ "§7" + builder.toString());
		}
		else
		{
			sender.sendMessage("§cPatientez " + ((Cooldown.cooldownReport.get(sender.getUniqueId()) + Cooldown.cooldownReportTime) - (System.currentTimeMillis() / 1000)) + " secondes avant de refaire la commande");
		}
	}

	public static void Help(Player sender)
	{	
		sender.sendMessage("§7Voici la liste des commandes :");
		sender.sendMessage("§a/report §f<Message>");
		sender.sendMessage("§a/vr help");
		if(sender.isOp())
		{
			sender.sendMessage("§a/vr add admin §f<Joueur>");
			sender.sendMessage("§a/vr remove admi)n §f<Joueur>");
		}
		if(AdminConfiguration.isAdmin(sender) || sender.isOp())
		{
			sender.sendMessage("§a/vr tp §f<Joueur>");
			sender.sendMessage("§a/vr spectate §f<Joueur>");
			sender.sendMessage("§a/vr stop");
		}
	}
}