package de.philip.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.philip.Utils.WorldUtil;
import de.philip.Main.main;

public class DelWorld implements CommandExecutor{
	
	private main plugin;
	
	public DelWorld(main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
		
			if(cmd.getName().equalsIgnoreCase("delworld")) {
				
				if(args.length == 0) {
					p.sendMessage(main.WORLDCREATOR_PREFIX + "§cGebe noch einen Namen an");
				} else {
					String name = args[0];
			
					if(plugin.getMAPS().contains(name)) {
					
						WorldUtil.deleteWorld(name, plugin);
				
						p.sendMessage(main.WORLDCREATOR_PREFIX + "§aDu hast die Welt §6" + name + "§a gelöscht");
					} else {
					p.sendMessage(main.WORLDCREATOR_PREFIX + "§cDiese Welt wurde nicht gefunden");
					}
				}
			} else {
				p.sendMessage(main.WORLDCREATOR_PREFIX + "§Bitte nutze §6/delworld <NAME>");
			}
		}	
		return false;
	}
	
	public main getPlugin() {
		return plugin;
	}
}
