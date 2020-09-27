package de.mclroleplay.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mclroleplay.events.ClockModifikations;

public class TpInventoryCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

		Player p = (Player) cs;
		
		if (p.hasPermission("group.admin")) {
			
			if (!(cs instanceof Player)) {

				cs.sendMessage("§4Du must ein Spieler sein");
				return true;

			} else {

				p.openInventory(ClockModifikations.invCreate());
				return true;

			}
		}else {
			
			cs.sendMessage("§4du hast keine Berechtigung diesen Befehl zu verwenden");
			
		}
		return false;
	}
}
