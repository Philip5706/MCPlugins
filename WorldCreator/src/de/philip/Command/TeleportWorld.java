package de.philip.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.philip.Main.main;
import net.md_5.bungee.api.ChatColor;

public class TeleportWorld implements CommandExecutor{
	
	private main plugin;
	
	public TeleportWorld(main plugin) {
		this.plugin = plugin;
	}

//heheh
//	hihihih
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("tpworld")) {
				
				if(args.length == 0) {
					p.sendMessage(main.WORLDCREATOR_PREFIX + "§cGebe noch Namen an");
				} else {
					String name = args[0];
					
					if(!plugin.getMAPS().contains(name)) {
						p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED + "Diese Welt existiert nicht");
						return false;
					}
					
					p.teleport(Bukkit.getWorld(name).getSpawnLocation());
										
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.GREEN + "Du wurdest in die Welt §6" + name + "§a teleportiert");
					
				}
				
			} else {
				p.sendMessage(main.WORLDCREATOR_PREFIX + "§cBitte nutze §6/tpworld <NAME>");
			}
		}	
		return false;
	}
	
}
