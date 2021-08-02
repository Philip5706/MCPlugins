package de.philip.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.philip.Main.main;
import de.philip.Utils.WorldUtil;
import net.md_5.bungee.api.ChatColor;

public class WorldCommand implements CommandExecutor{
	
	private main plugin;
	
	public WorldCommand(main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("world")) {
				
				if(args.length == 0) {
					
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED +  "/world <CREATE/DELETE/TP> <NAME>");
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED +  "/world <LIST>");
					
				} else if(args[0].equalsIgnoreCase("create")) {
					
					String name = args[1];
					
					if(!plugin.getMAPS().contains(name)) {
						
						p.sendMessage(main.WORLDCREATOR_PREFIX + "§aDie Welt wird erstellt");
						
						WorldUtil.createWorld(name, plugin);
						
						p.sendMessage(main.WORLDCREATOR_PREFIX + "§aDie Welt §6" + name + "§a wurde erstellt");
						
					}
					
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED + "Die Welt existiert bereits");
					
				} else if(args[0].equalsIgnoreCase("delete")) {
					
					String name = args[1];
					
					if(plugin.getMAPS().contains(name)) {
					
						WorldUtil.deleteWorld(name, plugin);
				
						p.sendMessage(main.WORLDCREATOR_PREFIX + "§aDu hast die Welt §6" + name + "§a gelöscht");
					} else {
						p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED + "Die Welt " + ChatColor.YELLOW + name + ChatColor.RED + " wurde nicht gefunden");
				
					}
				
				} else if(args[0].equalsIgnoreCase("tp")) {
					
					String name = args[1];
					
					if(!plugin.getMAPS().contains(name)) {
						p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED + "Diese Welt existiert nicht");
						return false;
					}
					
					p.teleport(Bukkit.getWorld(name).getSpawnLocation());
										
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.GREEN + "Du wurdest in die Welt §6" + name + "§a teleportiert");
					
				} else if(args[0].equalsIgnoreCase("list")) {
					
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.YELLOW + plugin.getMAPS());
					
				}
					
			}
			
		}	
		return false;
	}
	
}
