package de.mclroleplay.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mclroleplay.config.SpawnsCFG;

public class SpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

		Player p = (Player) cs;

		if (cs instanceof Player) {
			// spawn setzen
			try {

				String name = args[0];
				SpawnsCFG.setSpawn(name, p.getLocation());

				Bukkit.broadcastMessage("§2Magierer Haus " + "§3" + name + " §2wurde gesetzt");

				return true;

			} catch (Exception e) {

				Bukkit.broadcastMessage("§cDu must einen Spawn Namen eingeben");

				return false;

			}

		} else {

			cs.sendMessage("§4Du must ein Spieler sein");

		}

		return true;

	}

}