package de.philip.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import de.philip.Command.CreateWorld;
import de.philip.Command.DelWorld;
import de.philip.Command.TeleportWorld;
import net.md_5.bungee.api.ChatColor;

public class main extends JavaPlugin {
	
	public static main plugin;
	private ArrayList<String> MAPS = new ArrayList<>(getConfig().getStringList("Worlds"));

	public static final String WORLDCREATOR_PREFIX = ChatColor.BLUE + "[WorldCreator] §r";
		
	public void onEnable() {
		plugin = this;
//		PluginManager pluginManager = Bukkit.getPluginManager();
				
		getCommand("createworld").setExecutor(new CreateWorld(this));
		getCommand("delworld").setExecutor(new DelWorld(this));
		getCommand("tpworld").setExecutor(new TeleportWorld(this));

		loadConfig();
		
		for(int i = 0; i < MAPS.size(); i++) {
			WorldCreator w = WorldCreator.name(MAPS.get(i));
			Bukkit.createWorld(w);
			Bukkit.getWorlds().add(Bukkit.getWorld(MAPS.get(i)));
		}
	}
	
	@Override
	public void onDisable() {

	}
	
	public void loadConfig() {
		getConfig().options().header("Hier werden alle Welten gespeichert");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public main getPlugin() {
		return plugin;
	}
	
	public ArrayList<String> getMAPS() {
		return MAPS;
	}
	
	public void setMAPS(ArrayList<String> mAPS) {
		MAPS = mAPS;
	}

}
