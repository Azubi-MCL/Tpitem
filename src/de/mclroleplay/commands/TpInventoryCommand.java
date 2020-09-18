package de.mclroleplay.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.mclroleplay.events.ClockModifikations;

public class TpInventoryCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

		if (!(cs instanceof Player)) {

			cs.sendMessage("§4Du must ein Spieler sein");
			return true;

		} else {

			Player p = (Player) cs;
			p.openInventory(ClockModifikations.invCreate());
			return true;

		}

	}

}
