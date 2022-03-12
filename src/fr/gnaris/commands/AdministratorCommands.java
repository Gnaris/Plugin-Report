package fr.gnaris.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.gnaris.commands.instruction.AdminConfiguration;
import fr.gnaris.commands.instruction.PlayerCommands;
import fr.gnaris.commands.instruction.Teleportation;

public class AdministratorCommands implements CommandExecutor {
	
	private Player sender;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			this.sender = (Player) sender;
			if(label.equals("vr"))
			{
				if(args.length == 0) return false;
				if(AdminConfiguration.isAdmin(this.sender) || this.sender.isOp())
				{
					if(args.length == 3)
					{
						if(this.sender.isOp())
						{
							if(args[0].equalsIgnoreCase("add") && args[1].equalsIgnoreCase("admin")) 
							{
								AdminConfiguration.AddAdmin(this.sender, Bukkit.getPlayer(args[2]));
							}
							else if(args[0].equalsIgnoreCase("remove") && args[1].equalsIgnoreCase("admin"))
							{
								AdminConfiguration.RemoveAdmin(this.sender, Bukkit.getPlayer(args[2]));
							}
						}
					}
					else if(args.length == 2)
					{
						if(args[0].equalsIgnoreCase("tp"))
						{
							Teleportation.Tp(this.sender, Bukkit.getPlayer(args[1]));
						}
						else if(args[0].equalsIgnoreCase("spectate"))
						{
							Teleportation.TpInvisible(this.sender, Bukkit.getPlayer(args[1]));
						}
					}
					else if(args.length == 1)
					{
						if(args[0].equalsIgnoreCase("stop"))
						{
							Teleportation.Stop(this.sender);
						}
					}
				}
				
				if(args[0].equalsIgnoreCase("help"))
				{
					PlayerCommands.Help(this.sender);
				}
			}
			else 
			{
				this.sender.sendMessage("§cVous n'avez pas les permissions pour faire ceci");
			}
		}
		return false;
	}
}
