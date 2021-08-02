package de.philip.Utils;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;

import de.philip.Main.main;

public class WorldUtil {
				
	public static void createWorld(String name, main plugin) {
		plugin.getMAPS().add(name);
		
		plugin.getConfig().set("Worlds", plugin.getMAPS());
		plugin.saveConfig();
		
		WorldCreator wc = new WorldCreator(name);
		Bukkit.createWorld(wc);
		Bukkit.getWorlds().add(Bukkit.getWorld(name));
	}
	
	public static void deleteWorld(String name, main plugin) {
		
		Bukkit.getWorld(name).getWorldFolder().delete();
		
//		World delete = Bukkit.getWorld(name);
//		File deleteFolder = delete.getWorldFolder();
//		
//		deleteWorld(deleteFolder);
		
//		File directoryToBeDeleted = new File(name);
//	    File[] allContents = directoryToBeDeleted.listFiles();
//	    if (allContents != null) {
//	        for (File file : allContents) {
//	            deleteWorld(file.getAbsolutePath(), plugin);
//	        }
//	    }
	    
		plugin.getMAPS().remove(name);
		plugin.getPlugin().getConfig().set("Worlds", plugin.getMAPS());
		plugin.getPlugin().saveConfig();
		
//	    return directoryToBeDeleted.delete();
	}
	
}
