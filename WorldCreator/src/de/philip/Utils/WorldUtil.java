package de.philip.Utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import de.philip.Main.main;

public class WorldUtil {
				
	public static void createWorld(String name, main plugin) {
		
		plugin.getMAPS().add(name);
		
		plugin.getConfig().set("Worlds", plugin.getMAPS());
		plugin.saveConfig();
		
		WorldCreator w = WorldCreator.name(name);
		Bukkit.createWorld(w);
		Bukkit.getWorlds().add(Bukkit.getWorld(name));
	}
	
	public static boolean deleteWorld(String name, main plugin) {
		
		File directoryToBeDeleted = new File(name);
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	            deleteWorld(file.getAbsolutePath(), plugin);
	        }
	    }
	    
		plugin.getMAPS().remove(name);
		plugin.getPlugin().getConfig().set("Worlds", plugin.getMAPS());
		plugin.getPlugin().saveConfig();
		
	    return directoryToBeDeleted.delete();
	}
	
}
