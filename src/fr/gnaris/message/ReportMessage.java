package fr.gnaris.message;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ReportMessage{
	
	public static void NotifyToAdmin(Player target, Player player, String msg) {
		TextComponent teleport = new TextComponentBuilder()
				.setMessageClick("Se teleporter à "+ player.getName())
				.setColor(ChatColor.GOLD)
				.setCommand("/vr tp " + player.getName())
				.setMessageHover("Cliquer ici pour se téléporter sur " +player.getName())
				.setClickEvent(ClickEvent.Action.RUN_COMMAND)
				.build();
		TextComponent mp = new TextComponentBuilder()
				.setMessageClick("Mp à "+ player.getName())
				.setColor(ChatColor.BLUE)
				.setCommand("/tell " + player.getName())
				.setMessageHover("Cliquer ici pour mp "+ player.getName())
				.setClickEvent(ClickEvent.Action.SUGGEST_COMMAND)
				.build();
		TextComponent tpinvisible = new TextComponentBuilder()
				.setMessageClick("Se téléporter en tant que spectateur sur "+ player.getName())
				.setColor(ChatColor.GRAY)
				.setCommand("/vr spectate " + player.getName())
				.setMessageHover("Cliquer ici pour se téléporter en spectacteur sur " + player.getName())
				.setClickEvent(ClickEvent.Action.RUN_COMMAND)
				.build();
		target.sendMessage("§c=====================================================");
		target.sendMessage("     §4[Valient Report] §cLe joueur §a" + player.getName() + " §c a besoin d'aide !");
		target.sendMessage("");
		target.sendMessage("   §b§n§lMessage§r : §r§7"+ msg);
		target.sendMessage("");
		target.spigot().sendMessage(teleport);
		target.spigot().sendMessage(mp);
		target.spigot().sendMessage(tpinvisible);
		target.sendMessage("§c=====================================================");
	}
}