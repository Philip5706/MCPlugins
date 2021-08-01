package de.philip.Main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.philip.Lobby.Inventory.Navigator;
import de.philip.Lobby.Listener.JoinListener;
import de.philip.Lobby.Listener.SignListener;
import de.philip.Lobby.Util.Tageszeit;
import de.philip.TikTakToe.TikTakToeHandler;
import de.philip.TikTakToe.Inventory.TikTakToe;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public static final String 	LASERTAG_PREFIX = "§c[Lasertag] §r";
	
	public void onEnable() {
		plugin = this;
		PluginManager pluginManager = Bukkit.getPluginManager();
				
		pluginManager.registerEvents(new TikTakToe(), this);
		pluginManager.registerEvents(new TikTakToeHandler(), this);
		pluginManager.registerEvents(new Navigator(), this);
		pluginManager.registerEvents(new Tageszeit(), this);
		pluginManager.registerEvents(new JoinListener(), this);
		pluginManager.registerEvents(new SignListener(), this);
	}
	
	@Override
	public void onDisable() {

	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
