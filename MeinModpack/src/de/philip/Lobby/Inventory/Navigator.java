package de.philip.Lobby.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.philip.Lobby.Util.Tageszeit;
import de.philip.TikTakToe.Inventory.TikTakToe;

public class Navigator implements Listener{
		
	public static String Navigator = "§b§lNavigator";
	public static ItemStack nether_star = new ItemStack(Material.NETHER_STAR);
	public static ItemStack diamond_hoe = new ItemStack(Material.DIAMOND_HOE);	
	public static Material nav = Material.COMPASS;
	public static ItemStack navigator = new ItemStack(nav);		

	public static void openGUI(Player player) {
		
		ItemMeta nether_starMeta = nether_star.getItemMeta();
		nether_starMeta.setDisplayName("§eTikTakToe");
		nether_star.setItemMeta(nether_starMeta);
		
		ItemMeta diamond_hoeMeta = diamond_hoe.getItemMeta();
		diamond_hoeMeta.setDisplayName("§eLasertag");
		diamond_hoe.setItemMeta(diamond_hoeMeta);
		
		Inventory navigatorinv = Bukkit.createInventory(null, 9*5, Navigator);
		navigatorinv.setItem(20, nether_star);
		navigatorinv.setItem(24, diamond_hoe);
		player.openInventory(navigatorinv);
		

	
	}
	
	@EventHandler
	public void join(InventoryClickEvent event) {

		if(event.getCurrentItem().getType() == nav) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().equals(Navigator)) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void handleNavigatorOpen(PlayerInteractEvent ievent) {
		if(ievent.getItem().getType() == Material.COMPASS) {
			if(ievent.getAction() == Action.RIGHT_CLICK_AIR || ievent.getAction() == Action.RIGHT_CLICK_BLOCK)
				openGUI(ievent.getPlayer());
		}else{
			if(ievent.getItem().getType() == Material.CLOCK) {
			if(ievent.getAction() == Action.RIGHT_CLICK_AIR || ievent.getAction() == Action.RIGHT_CLICK_BLOCK)
				Tageszeit.openUhrzeitMenu(ievent.getPlayer());
			
			}
		}
	}
	
	@EventHandler	
	public void handleNavigatorClick(InventoryClickEvent cevent) {
		if(!(cevent.getWhoClicked() instanceof Player)) return;
		Player player = (Player) cevent.getWhoClicked();
		if(cevent.getView().getTitle().equals(Navigator)) {
			cevent.setCancelled(true);
				switch(cevent.getCurrentItem().getType()) {
				case NETHER_STAR:
					
					if(!(cevent.isLeftClick())) return;
						player.closeInventory();
						TikTakToe.openTikTakToeSchwierigkeitsAuswahl(player);

					break;
				case DIAMOND_HOE:
					
					if(!(cevent.isLeftClick())) return;
						player.closeInventory();
						player.teleport(Bukkit.getWorld("lasertaglobby").getSpawnLocation());
					
					break;
				default:

						break;
					
				}
		}
	}
}