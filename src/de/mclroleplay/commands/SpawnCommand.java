package de.mclroleplay.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mclroleplay.config.MainCFG;
import de.mclroleplay.config.SpawnsCFG;
import de.mclroleplay.main.MclTpitem;
import de.mclroleplay.rpengine.config.Messages;
import de.mclroleplay.rpengine.config.PlayersCFG;

public class SpawnCommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

		Player p = (Player) cs;

		if (cs instanceof Player) {
			// spawn setzen
			if (PlayersCFG.getJobNames(p).contains("Magier")) {
				
				try {

					String name = args[0];
					
					if (MclTpitem.economy == null) {
						
						Messages.sendMessage(p, "no_eco_service");
						return true;
						
					}
					
					if (!MclTpitem.economy.has(p, MainCFG.getSpawnCost())) {
						Messages.sendMessage(p, "no_money");
						return true;
					}

					MclTpitem.economy.withdrawPlayer(p, MainCFG.getSpawnCost());

					SpawnsCFG.setSpawn(name, p.getLocation());
					
					Bukkit.broadcastMessage("§2Magierer Haus " + "§3" + name + " §2wurde gesetzt");

					return true;					

				} catch (Exception e) {

					Bukkit.broadcastMessage("§cDu must einen Spawn Namen eingeben");

					return false;

				}
				
			}else {
				
				Bukkit.broadcastMessage("§cDu must ein Magier sein");
				
			}

		} else {

			cs.sendMessage("§4Du must ein Spieler sein");

		}

		return true;

	}
}