package de.mclroleplay.config;

import org.bukkit.configuration.file.FileConfiguration;

import de.mclroleplay.main.MclTpitem;
import net.md_5.bungee.api.ChatColor;

public class MainCFG {

	@SuppressWarnings("unused")
	private MclTpitem pl;
	public static FileConfiguration config;

	// Config load
	public void loadConfig(MclTpitem pl) {

		this.pl = pl;
		config = pl.getConfig();
		pl.saveDefaultConfig();

	}

	// Name der Uhr 
	public static String getClockName() {

		String name = config.getString("Uhr Name");
		
		if (name == null)
		
			return null;
		
		return ChatColor.translateAlternateColorCodes('&', name);

	}

	// Boolean Rezeptabfrage
	public static boolean isRezeptabfrage() {
		
		return config.getBoolean("Rezeptabfrage");
		
	}

	// Rezept anordnung
	public static String[] getRecipeLines() {
		
		String lines[] = new String[3];

		for (int i = 0; i < 3; i++) {
			lines[i] = config.getString("Rezept.TpUhr.Zeile " + (i + 1));
		}

		return lines;
		
	}

	// Gui größe
	public static String gui() {

		return config.getString("Gui scale");

	}

	// Inventar Name
	public static String getInfName() {

		String name = config.getString("Hud Name");

		if (name == null)

			return null;

		return ChatColor.translateAlternateColorCodes('&', name);

	}
	
	// Clock anzahl beim Craften
	public static int getClockAnzahl() {
		
		return config.getInt("Clock anzahl");
		
	}

}
