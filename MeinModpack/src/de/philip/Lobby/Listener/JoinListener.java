package de.philip.Lobby.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.philip.Lobby.Inventory.Navigator;
import de.philip.Lobby.Scoreboard.Scoreboard;
import de.philip.Lobby.Util.Tageszeit;
import net.md_5.bungee.api.ChatColor;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		event.setJoinMessage("§7(§a+§7) " + player.getName());
				
		ItemStack navigator = Navigator.navigator;
		ItemMeta navigatorMeta = navigator.getItemMeta();
		navigatorMeta.setDisplayName(ChatColor.AQUA + "Navigator");
		navigator.setItemMeta(navigatorMeta);
		player.getInventory().setItem(0, navigator);
		
		ItemStack uhrzeit = Tageszeit.uhrzeit;
		ItemMeta uhrzeitMeta = uhrzeit.getItemMeta();
		uhrzeitMeta.setDisplayName(ChatColor.AQUA + "Tageszeit");
		uhrzeit.setItemMeta(uhrzeitMeta);
		player.getInventory().setItem(8, uhrzeit);
		
		new Scoreboard(player);
						
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		event.setQuitMessage("§7(§c-§7) " + player.getName());
		
		
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event) {

	
	}
}
