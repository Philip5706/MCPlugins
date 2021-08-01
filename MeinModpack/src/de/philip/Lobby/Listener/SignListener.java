package de.philip.Lobby.Listener;

import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener {
	
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		if(event.getLine(0).equalsIgnoreCase("[LasertagLobby]")) {
			event.setLine(0, "§aLasertag");
		} else
		if(event.getLine(0).equalsIgnoreCase("[Lobby]")) {
			event.setLine(0, "§aLobby");
		} 
	}
			
	@EventHandler
	public void onPlayerInteractWithSign(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getClickedBlock().getState() instanceof Sign) {
				Sign sign = (Sign) event.getClickedBlock().getState();
				
				if(sign.getLine(0).equalsIgnoreCase("§aLasertag")) {
					
					//Teleportiert dich in die Lasertag Lobby
					player.teleport(Bukkit.getWorld("lasertaglobby").getSpawnLocation());
					
				} else
				if(sign.getLine(0).equalsIgnoreCase("§aLobby")) {
						
					//Teleportiert dich in die Lobby
					player.teleport(Bukkit.getWorld("world").getSpawnLocation());
						
				}
			}
		}
	}

}
