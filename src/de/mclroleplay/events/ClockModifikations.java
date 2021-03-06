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
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.mclroleplay.config.MainCFG;
import de.mclroleplay.config.SpawnsCFG;
import de.mclroleplay.recipes.Clock;

public class ClockModifikations implements Listener {

	public static String invName = MainCFG.getInfName();

	JavaPlugin pl;

	public ClockModifikations(JavaPlugin pl) {
		this.pl = pl;
	}

	// Gui Erstellung
	public static Inventory invCreate() {

		Inventory i = Bukkit.getServer().createInventory(null, 6 * 9, invName);

		List<String> spawns = SpawnsCFG.getSpawns();

		int slot = 9;

		for (int j = 0; j < spawns.size(); j++) {

			slot += 1;

			ItemStack tName = new ItemStack(Material.FILLED_MAP);
			ItemMeta me = tName.getItemMeta();
			me.setDisplayName("�c" + spawns.get(j));
			tName.setItemMeta(me);
			i.setItem(slot, tName);

		}

		return i;

	}

	// Klicken sperren
	@EventHandler
	public static void eventCanceld(InventoryClickEvent e) {

		// Event set Cancelled
		if (e.getView().getTitle().equals(invName)) {

			if (e.getRawSlot() < e.getInventory().getSize()) {

				e.setCancelled(true);

			}

		}

	}

	// Teleportieren beim Clicken
	@EventHandler
	public void onClick(InventoryClickEvent e) {

		String invtest = e.getView().getTitle();

		int slot = e.getSlot();
		slot -= 10;

		Location loc = SpawnsCFG.getClockSpawn(slot, invtest);

		if (loc != null) {

			Player p = (Player) e.getWhoClicked();

			teleport(p, loc);

			p.closeInventory();
			Clock.clockRemoveMain(p);

		}
	}

//	/**
//	 * 
//	 * Diese Methode versucht den Spieler �ber Essentials zu teleportieren (damit
//	 * k�nnen beispielsweise die Essentials Cooldowns verwendet werden). Wenn das
//	 * nicht klappt findet ein normaler Teleport statt.
//	 * 
//	 * @author SkyLightEffect
//	 * @param p   Der Spieler, der teleportiert werden soll
//	 * @param loc Die Zielposition
//	 */
//	
	private void teleport(Player p, Location loc) {

		p.sendMessage("�eDu wirst in �c7 Sekunden �eTeleportiert");
		
		pl.getServer().getScheduler().runTaskLater(pl, new Runnable() {
			
			@Override
			public void run() {
				
				p.teleport(loc);

				p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1000, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
				
			}

		}, 7 * 20L);

	}

	// Item Benutzung
	@EventHandler
	public void onUse(PlayerInteractEvent pie) {

		Player p = pie.getPlayer();

		ItemStack item = pie.getItem();
		EquipmentSlot main = pie.getHand();

		if (main == EquipmentSlot.HAND) {
			if (item != null) {

				if (item.getItemMeta().getDisplayName().equalsIgnoreCase(MainCFG.getClockName())) {

					p.openInventory(ClockModifikations.invCreate());

				}
			}
		}

	}
}
