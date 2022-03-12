package fr.gnaris.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gnaris.commands.instruction.PlayerCommands;
import fr.gnaris.config.Config;

public class ReportCommands implements CommandExecutor {
	
	private Player sender;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) 
		{
			this.sender = (Player) sender;
			if(label.equalsIgnoreCase("report"))
			{
				if(args.length >= Config.GetInt("number_char_min_for_send_report"))
				{
					PlayerCommands.Report(args, this.sender);
				}
				else if(args.length == 0)
				{
					this.sender.sendMessage("§c/report <message>");
				}
				else 
				{
					this.sender.sendMessage("§cVotre message est trop court !");
				}
			}
		}
		return false;
	}
}
