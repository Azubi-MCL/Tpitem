package de.mclroleplay.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.mclroleplay.rpengine.config.PlayersCFG;

public class SpawnRemoveCommand implements CommandExecutor {

	public static File file;
	public static FileConfiguration config;

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

		Player p = (Player) cs;

		if (cs instanceof Player) {
			
			if (PlayersCFG.getJobNames(p).contains("Magier")) {
				p.sendMessage("§4Dieser Befehl ist noch nicht verfügbar");

				return false;
				
			}else {
				cs.sendMessage("§cDu must ein Magier sein");
			}
			
		} else {

			cs.sendMessage("§4Du must ein Spieler sein");

		}
//		String sname = args[0];
//
//		SpawnsCFG.removeSpawn(sname);

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