package de.mclroleplay.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class SpawnRemoveCommand implements CommandExecutor {

	public static File file;
	public static FileConfiguration config;

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

//		String e1 = args[0];
//		if (SpawnsCFG.getSpawns().contains(e1)) {
//			
//			
//		}
		return false;

		// ConfigurationSection s = spawns.getConfigurationSection("spawns");
		/*
		 * if (s.getKeys(false).contains(ein)) { s.getKeys(false).remove("test"); try {
		 * spawns.save(savespawns); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } }
		 * 
		 * return true; }
		 */

	}
}