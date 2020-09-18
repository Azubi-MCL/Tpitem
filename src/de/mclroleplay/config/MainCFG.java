package de.mclroleplay.config;

import org.bukkit.configuration.file.FileConfiguration;

import de.mclroleplay.main.MclTpitem;
import net.md_5.bungee.api.ChatColor;

public class MainCFG {

	private MclTpitem pl;

	public static FileConfiguration config;

	public void loadConfig(MclTpitem pl) {

		this.pl = pl;
		config = pl.getConfig();
	}

	public static String getClockName() {

		String name = config.getString("Uhr Name");
		if (name == null)
			return null;
		return ChatColor.translateAlternateColorCodes('&', name);
	}

	public static boolean isRezeptabfrage() {
		return config.getBoolean("Rezeptabfrage");
	}

	public static String[] getRecipeLines() {
		String lines[] = new String[3];

		for (int i = 0; i < 3; i++) {
			lines[i] = config.getString("Rezept.TpUhr.Zeile " + (i + 1));
		}

		return lines;
	}
}
