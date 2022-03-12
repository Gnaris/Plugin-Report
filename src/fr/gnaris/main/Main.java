package fr.gnaris.main;

import org.bukkit.plugin.java.JavaPlugin;

import fr.gnaris.commands.AdministratorCommands;
import fr.gnaris.commands.ReportCommands;
import fr.gnaris.commands.instruction.AdminConfiguration;
import fr.gnaris.config.Config;
import fr.gnaris.cooldown.Cooldown;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		this.saveDefaultConfig();
		this.reloadConfig();
		
		Config.Init(this);
		Cooldown.init();
		AdminConfiguration.Init();
		
		getCommand("report").setExecutor(new ReportCommands());
		getCommand("vr").setExecutor(new AdministratorCommands());
		
		System.out.println("[VALIENT REPORT] has been turn on");
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("[VALIENT REPORT] has been turn off");
	}
}
