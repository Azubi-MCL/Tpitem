package de.mclroleplay.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.mclroleplay.main.MclTpitem;

public class SpawnsCFG {

	private static File file;
	private static FileConfiguration config;

	// Spawns load
	public static void loadYml() {

		file = new File(MclTpitem.getPlugin(MclTpitem.class).getDataFolder(), "spawns.yml");
		config = YamlConfiguration.loadConfiguration(file);
		sv();

	}

	// Speichert config
	public static void sv() {

		try {

			config.save(file);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	// Ruft spawn locations ab
	public static Location getClockSpawn(int slot, String invtest) {

		ConfigurationSection cs = config.getConfigurationSection("spawns");

		if (invtest.equals(MainCFG.getInfName())) {

			if (config.contains("spawns") && cs.getKeys(false) != null) {

				for (int i = 0; i < cs.getKeys(false).size(); i++) {
					if (i == slot) {

						String wName = config.getString("spawns." + cs.getKeys(false).toArray()[i] + ".world");
						World world = Bukkit.getWorld(wName);

						int x = config.getInt("spawns." + cs.getKeys(false).toArray()[i] + ".x");
						int y = config.getInt("spawns." + cs.getKeys(false).toArray()[i] + ".y");
						int z = config.getInt("spawns." + cs.getKeys(false).toArray()[i] + ".z");

						Location loc = new Location(world, x, y, z);

						return loc;
					}
				}
			}
		}

		return null;
	}

	// Ruft spawn namen ab
	public static List<String> getSpawns() {

		List<String> spawns = new ArrayList<String>();

		ConfigurationSection cs = config.getConfigurationSection("spawns");

		if (cs != null && cs.getKeys(false) != null) {

			for (String spawn : cs.getKeys(false)) {
				spawns.add(spawn);
			}
		}
		return spawns;
	}

	// Spawns setzen
	public static void setSpawn(String name, Location loc) {

		String prefix = "spawns." + name;
		config.set(prefix + ".world", loc.getWorld().getName());
		config.set(prefix + ".x", loc.getBlockX());
		config.set(prefix + ".y", loc.getBlockY());
		config.set(prefix + ".z", loc.getBlockZ());

		sv();
	}
	
	public  static void removeSpawn(String sname) {
		
		String name = config.getString("spawns." + sname);
		System.out.println("spawns." + name);
		
		config.set("spawns." + name , null);
		
		sv();		
	
	}
}