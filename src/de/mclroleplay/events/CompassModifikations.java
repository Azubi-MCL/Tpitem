package de.mclroleplay.events;

import java.awt.event.ItemEvent;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.mclroleplay.main.MclTpitem;

public class CompassModifikations implements Listener {
	
	public void onUse(Player p, InventoryClickEvent e, ItemEvent c, MclTpitem plugin) {
		// TODO Auto-generated method stub
		//
		Inventory i = Bukkit.getServer().createInventory(null, 6*9, "§4Städte");
		ItemStack c1 = new ItemStack(Material.ACACIA_DOOR);
		ItemMeta m = c1.getItemMeta();
		m.setDisplayName("§cNürnberg");
		c1.setItemMeta(m);
		i.setItem(22, c1);
		p.openInventory(i);	
		

	}
	
	
	
	/*
	  private void onUse() {
		// TODO Auto-generated method stub


		List<Town> towns = TownyAPI.getInstance().getDataSource().getTowns();
		
		for (Town town : towns) {
            try {
				
            	town.getSpawn().getBlock().getLocation();
				
			} catch (TownyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//if (condition) {
		
			
			
			if (condition) {
			
				Player spieler = (Player);
				
				ItemStack gegenstand = spieler.getInventory().getItemInMainHand();
	            
				ItemMeta metaData = gegenstand.getItemMeta();
	            
				
	            
				if (metaData.getDisplayName().equals("Städtecompass")) {
	   
					//onCommpassEvent();
	            	MclCartography.getPlugin(MclCartography.class).getServer().createInventory(null, 6*9, "§4Inventar");
	            	
					
				}
			}
			
		//}
	}
	
	
	
	
	
	@EventHandler
	public static void onCommpassEvent()  {
		
		List<Town> towns = TownyAPI.getInstance().getDataSource().getTowns();
		
		for (Town town : towns) {
            try {
				
            	town.getSpawn().getBlock().getLocation();
				
			} catch (TownyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		
		
			
		
		
		
		
		
	
		

	
	}
	*/

}
