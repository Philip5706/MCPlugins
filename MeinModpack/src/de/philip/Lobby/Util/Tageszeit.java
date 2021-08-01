package de.philip.Lobby.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tageszeit implements Listener{
	
	public static Material uhr = Material.CLOCK;
	public static ItemStack uhrzeit = new ItemStack(uhr);
	public static String uhrzeitMenu = "§e§lUhrzeit";

	public static void openUhrzeitMenu(Player player) {
		Inventory uhrzeit = Bukkit.createInventory(null, 9*3, uhrzeitMenu);
		
		ItemStack OAK_BUTTON = new ItemStack(Material.OAK_BUTTON);		
		ItemMeta OAK_BUTTONMeta = OAK_BUTTON.getItemMeta();
		OAK_BUTTONMeta.setDisplayName("§aMorgen");
		OAK_BUTTON.setItemMeta(OAK_BUTTONMeta);
		
		ItemStack ACACIA_BUTTON = new ItemStack(Material.ACACIA_BUTTON);		
		ItemMeta ACACIA_BUTTONMeta = ACACIA_BUTTON.getItemMeta();
		ACACIA_BUTTONMeta.setDisplayName("§aMittag");
		ACACIA_BUTTON.setItemMeta(ACACIA_BUTTONMeta);

		ItemStack DARK_OAK_BUTTON = new ItemStack(Material.DARK_OAK_BUTTON);		
		ItemMeta DARK_OAK_BUTTONMeta = DARK_OAK_BUTTON.getItemMeta();
		DARK_OAK_BUTTONMeta.setDisplayName("§aAbend");
		DARK_OAK_BUTTON.setItemMeta(DARK_OAK_BUTTONMeta);
		
		ItemStack CRIMSON_BUTTON = new ItemStack(Material.CRIMSON_BUTTON);		
		ItemMeta CRIMSON_BUTTONMeta = CRIMSON_BUTTON.getItemMeta();
		CRIMSON_BUTTONMeta.setDisplayName("§aMitternacht");
		CRIMSON_BUTTON.setItemMeta(CRIMSON_BUTTONMeta);
		
		ItemStack zurück = new ItemStack(Material.RED_DYE);
		ItemMeta zurückMeta = zurück.getItemMeta();
		zurückMeta.setDisplayName("§cAbbrechen");
		zurück.setItemMeta(zurückMeta);
		
		uhrzeit.setItem(10, OAK_BUTTON);
		uhrzeit.setItem(12, ACACIA_BUTTON);
		uhrzeit.setItem(14, DARK_OAK_BUTTON);
		uhrzeit.setItem(16, CRIMSON_BUTTON);
		uhrzeit.setItem(22, zurück);
		player.openInventory(uhrzeit);

	}
	
	@EventHandler
	public void join(InventoryClickEvent event) {

		if(event.getCurrentItem().getType() == uhr) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(uhrzeitMenu)) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void handleUhrzeit(InventoryClickEvent cevent) {
		if(!(cevent.getWhoClicked() instanceof Player)) return;
		Player player = (Player) cevent.getWhoClicked();
		if(!(cevent.getView().getTitle().equals(uhrzeitMenu))) return;
			cevent.setCancelled(true);
				
			switch(cevent.getCurrentItem().getType()) {
				case OAK_BUTTON:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					for (World world : Bukkit.getWorlds()) {
						world.setTime(0);
						}
					player.sendMessage("§aDu hast die Zeit auf §6Morgen §agestellt");
					
					break;
				case ACACIA_BUTTON:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					for (World world : Bukkit.getWorlds()) {
						world.setTime(6000);
						}
					player.sendMessage("§aDu hast die Zeit auf §6Mittag §agestellt");
					
					break;
				case CRIMSON_BUTTON:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					for (World world : Bukkit.getWorlds()) {
						world.setTime(18000);
						}
					player.sendMessage("§aDu hast die Zeit auf §6Mitternacht §agestellt");
					
					break;
				case DARK_OAK_BUTTON:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					for (World world : Bukkit.getWorlds()) {
						world.setTime(13000);
						}
					player.sendMessage("§aDu hast die Zeit auf §6Abend §agestellt");
					
					break;
				case RED_DYE:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					
					break;
				default:
				
					break;
			
		}
	}
}
