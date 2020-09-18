package de.mclroleplay.recipes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import de.mclroleplay.config.MainCFG;
import de.mclroleplay.main.MclTpitem;

public class Clock {
	
	@SuppressWarnings("deprecation")
	public static void clockrecipe(MclTpitem plugin) {
		
		Byte durabilty = 1;
		
		ItemStack cityclock = new ItemStack(Material.CLOCK);
		
		ItemMeta cityclockMeta = cityclock.getItemMeta();
		
		String clockName = MainCFG.getClockName();
		
		cityclockMeta.setDisplayName(clockName);
		cityclockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cityclockMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		cityclock.setItemMeta(cityclockMeta);
		cityclock.addUnsafeEnchantment(Enchantment.LOYALTY, 1);
		cityclock.setDurability(durabilty);
		//ItemUtil item1 = new ItemUtil(Material.DIAMOND_PICKAXE).setDurability((short)10); 
		
		ShapedRecipe clockRezept = new ShapedRecipe(cityclock);
		
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
		String msg = config.getString("r");
		msg = msg.replace("[P]", p.getName());
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	    */
	}
	
}
