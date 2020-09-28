package de.mclroleplay.recipes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import de.mclroleplay.config.MainCFG;
import de.mclroleplay.main.MclTpitem;

public class Clock {

	// Clock Rezept
	@SuppressWarnings("deprecation")
	public static void clockrecipe(MclTpitem plugin) {

		ShapedRecipe clockRezept = new ShapedRecipe(clockCreate());

		if (MainCFG.isRezeptabfrage() == true) {

			String lines[] = MainCFG.getRecipeLines();
			clockRezept.shape(lines[0], lines[1], lines[2]);

		} else {

			clockRezept.shape(" [ ", "R0 ", " [ ");

		}

		clockRezept.setIngredient('0', Material.CLOCK);
		clockRezept.setIngredient('[', Material.MAP);
		clockRezept.setIngredient('R', Material.REDSTONE);

		MclTpitem.getPlugin(MclTpitem.class).getServer().addRecipe(clockRezept);

		/*
		 * String msg = config.getString("r"); msg = msg.replace("[P]", p.getName());
		 * p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
		 */
	}

	// Clock erstelung
	public static ItemStack clockCreate() {

		ItemStack cityclock = new ItemStack(Material.CLOCK, MainCFG.getClockAnzahl());

		ItemMeta cityclockMeta = cityclock.getItemMeta();

		String clockName = MainCFG.getClockName();

		cityclockMeta.setDisplayName(clockName);
		cityclockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cityclockMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		cityclock.setItemMeta(cityclockMeta);
		cityclock.addUnsafeEnchantment(Enchantment.LOYALTY, 1);
		return cityclock;
	}

	public static Boolean isClock(ItemStack i) {
		ItemStack cityclock = clockCreate();

		if (i.getItemMeta() == cityclock.getItemMeta()) {

			if (i.getType() == cityclock.getType()) {

				return true;
			}
		}

		return false;
	}

	// clock entfernen nach benutzung
	public static void clockRemoveMain(Player p) {

		ItemStack mainhand = p.getInventory().getItemInMainHand();
		ItemStack offhand = p.getInventory().getItemInOffHand();
		try {

			if (mainhand.getItemMeta().getDisplayName().equalsIgnoreCase(MainCFG.getClockName())) {

				if (mainhand.getAmount() > 1) {

					mainhand.setAmount(mainhand.getAmount() - 1);
					p.getInventory().setItemInMainHand(mainhand);

				} else {

					p.getInventory().setItemInMainHand(null);

				}
				p.updateInventory();
			} else if (offhand.getItemMeta().getDisplayName().equalsIgnoreCase(MainCFG.getClockName())) {

				if (offhand.getAmount() > 1) {

					offhand.setAmount(offhand.getAmount() - 1);
					p.getInventory().setItemInOffHand(offhand);

				} else {

					p.getInventory().setItemInOffHand(null);

				}

				p.updateInventory();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}