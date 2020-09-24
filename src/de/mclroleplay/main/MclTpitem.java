package de.mclroleplay.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.mclroleplay.commands.SpawnCommand;
import de.mclroleplay.commands.SpawnRemoveCommand;
import de.mclroleplay.commands.TpInventoryCommand;
import de.mclroleplay.config.MainCFG;
import de.mclroleplay.config.SpawnsCFG;
import de.mclroleplay.events.ClockModifikations;
import de.mclroleplay.recipes.Clock;

public class MclTpitem extends JavaPlugin {

	public static PluginDescriptionFile pdf;
	public static File file;
	public static FileConfiguration config;

	@Override
	public void onEnable() {
		super.onEnable();

		// Enable info
		pdf = this.getDescription();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + pdf.getName() + " " + pdf.getVersion() + " has been enabled.");

		// Save configs
		new MainCFG().loadConfig(this);
		SpawnsCFG.loadYml();

		// Class run
		Clock.clockrecipe(this);

		// Events
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new ClockModifikations(), this);

		// Commands
		this.getCommand("minv").setExecutor(new TpInventoryCommand());
		this.getCommand("mspawn").setExecutor(new SpawnCommand());
		this.getCommand("mremove").setExecutor(new SpawnRemoveCommand());

	}

	@Override
	public void onDisable() {
		super.onDisable();

		// Disable info
		getServer().getConsoleSender()
				.sendMessage(ChatColor.RED + pdf.getName() + " " + pdf.getVersion() + " has been diabled.");

	}

}
