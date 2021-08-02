package de.philip.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.philip.Main.main;
import de.philip.Utils.WorldUtil;
import net.md_5.bungee.api.ChatColor;

public class CreateWorld implements CommandExecutor{
	
	private main plugin;
	
	public CreateWorld(main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("createworld")) {
				
				if(args.length == 0) {
					p.sendMessage(main.WORLDCREATOR_PREFIX + ChatColor.RED + "Gebe noch Namen, Seed und Welttype an");
				} else {
					String name = args[0];
					
					p.sendMessage(main.WORLDCREATOR_PREFIX + "§aDie Welt wird erstellt");
					WorldUtil.createWorld(name, plugin);
					
					p.sendMessage(main.WORLDCREATOR_PREFIX + "§aDie Welt §6" + name + "§a wurde erstellt");
					
				}
			} else {
				p.sendMessage(main.WORLDCREATOR_PREFIX + "§cBitte nutze §6/createworld <NAME>");
			}
		}	
		return false;
	}
}
//bbb