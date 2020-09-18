package de.mclroleplay.events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.mclroleplay.config.SpawnsCFG;

public class ClockModifikations implements Listener {

	public static String invName = "§4Teleporter";

	// Gui Erstellung
	public static Inventory invCreate() {

		// inv größe per config
		Inventory i = Bukkit.getServer().createInventory(null, 6 * 9, invName);

		List<String> spawns = SpawnsCFG.getSpawns();

		int slot = 9;

		for (int j = 0; j < spawns.size(); j++) {

			slot += 1;

			ItemStack tName = new ItemStack(Material.FILLED_MAP);
			ItemMeta me = tName.getItemMeta();
			me.setDisplayName("§c" + spawns.get(j));
			tName.setItemMeta(me);
			i.setItem(slot, tName);

		}

		return i;

	}

	@EventHandler
	public static void eventCanceld(InventoryClickEvent e) {

		// Event set Cancelled
		if (e.getView().getTitle().equals(invName)) {

			if (e.getRawSlot() < e.getInventory().getSize()) {

				e.setCancelled(true);

			}

		}

	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		int slot = e.getSlot();
		slot -= 10;

		Location loc = SpawnsCFG.getClockSpawn(slot);

		// System.out.println("DEBUG #01");

		if (loc != null) {

			// System.out.println("DEBUG #02");

			Player p = (Player) e.getWhoClicked();
//			System.out.println(loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + ", " + loc.getWorld().getName());
			p.teleport(loc);
			p.closeInventory();
		}

	}

	@EventHandler
	public void onUse(PlayerInteractEvent pie) {

		Player p = pie.getPlayer();
	
		try {

		if (pie.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cCityclock")) {

			p.openInventory(ClockModifikations.invCreate());

		
		}
			
		} catch (Exception e) {

			// TODO: handle exception
	
		}
	}
}

