package de.philip.TikTakToe.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.philip.Lobby.Inventory.Navigator;

public class TikTakToe implements Listener{
	
	public static Material pm = Material.RED_CONCRETE;
	public static ItemStack playerMaterial = new ItemStack(Material.RED_CONCRETE);
	public static Material cm = Material.BLUE_CONCRETE;
	public static ItemStack computerMaterial = new ItemStack(cm);
	public static ItemStack zurück = new ItemStack(Material.RED_DYE);
	public static ItemStack aufgeben = new ItemStack(Material.GREEN_DYE);
	public static Material platzhalter = Material.BLACK_STAINED_GLASS_PANE;
	public static ItemStack black_glass = new ItemStack(platzhalter);
	public static String TikTakToeEinfach = "§a§lTikTakToe Einfach";
	public static String TikTakToeMittel = "§e§lTikTakToe Mittel";
	public static String TikTakToeSchwer = "§c§lTikTakToe Schwer";
	public String TikTakToeMP = "§lTikTakToe Multiplayer";
	public static String TikTakToeSchwierigkeitsgrad = "§b§lSchwierigkeitsgrad auswählen";
	public String AufSpielerWarten = "§lAuf Spieler warten...";
	
	public void openTikTakToeEinfach(Player player) {
		Inventory tiktaktoeinv = Bukkit.createInventory(null, 9*3, TikTakToeEinfach);
		
		ItemMeta black_glassMeta = black_glass.getItemMeta();
		black_glassMeta.setDisplayName(" ");
		black_glass.setItemMeta(black_glassMeta);
		
		ItemMeta aufgebenMeta = aufgeben.getItemMeta();
		aufgebenMeta.setDisplayName("§aAufgeben");
		aufgeben.setItemMeta(aufgebenMeta);
		
		ItemMeta zurückMeta = zurück.getItemMeta();
		zurückMeta.setDisplayName("§cZurück");
		zurück.setItemMeta(zurückMeta);
				
		tiktaktoeinv.setItem(0, black_glass);
		tiktaktoeinv.setItem(1, black_glass);
		tiktaktoeinv.setItem(2, black_glass);
		tiktaktoeinv.setItem(6, black_glass);
		tiktaktoeinv.setItem(7, black_glass);
		tiktaktoeinv.setItem(8, black_glass);
		tiktaktoeinv.setItem(9, black_glass);
		tiktaktoeinv.setItem(10, black_glass);
		tiktaktoeinv.setItem(11, black_glass);
		tiktaktoeinv.setItem(15, black_glass);
		tiktaktoeinv.setItem(16, black_glass);
		tiktaktoeinv.setItem(17, black_glass);
		tiktaktoeinv.setItem(18, aufgeben);
		tiktaktoeinv.setItem(19, black_glass);
		tiktaktoeinv.setItem(20, black_glass);
		tiktaktoeinv.setItem(24, black_glass);
		tiktaktoeinv.setItem(25, black_glass);
		tiktaktoeinv.setItem(26, zurück);
		player.openInventory(tiktaktoeinv);

	}
	
	public void openTikTakToeMittel(Player player) {
		Inventory tiktaktoeinv = Bukkit.createInventory(null, 9*3, TikTakToeMittel);
		
		ItemMeta black_glassMeta = black_glass.getItemMeta();
		black_glassMeta.setDisplayName(" ");
		black_glass.setItemMeta(black_glassMeta);
		
		ItemMeta green_dyeMeta = aufgeben.getItemMeta();
		green_dyeMeta.setDisplayName("§aAufgaben");
		aufgeben.setItemMeta(green_dyeMeta);
		
		ItemMeta red_dyeMeta = zurück.getItemMeta();
		red_dyeMeta.setDisplayName("§cZurück");
		zurück.setItemMeta(red_dyeMeta);
		
		tiktaktoeinv.setItem(0, black_glass);
		tiktaktoeinv.setItem(1, black_glass);
		tiktaktoeinv.setItem(2, black_glass);
		tiktaktoeinv.setItem(6, black_glass);
		tiktaktoeinv.setItem(7, black_glass);
		tiktaktoeinv.setItem(8, black_glass);
		tiktaktoeinv.setItem(9, black_glass);
		tiktaktoeinv.setItem(10, black_glass);
		tiktaktoeinv.setItem(11, black_glass);
		tiktaktoeinv.setItem(15, black_glass);
		tiktaktoeinv.setItem(16, black_glass);
		tiktaktoeinv.setItem(17, black_glass);
		tiktaktoeinv.setItem(18, aufgeben);
		tiktaktoeinv.setItem(19, black_glass);
		tiktaktoeinv.setItem(20, black_glass);
		tiktaktoeinv.setItem(24, black_glass);
		tiktaktoeinv.setItem(25, black_glass);
		tiktaktoeinv.setItem(26, zurück);
		player.openInventory(tiktaktoeinv);
		
	}
	
	public void openTikTakToeSchwer(Player player) {
		Inventory tiktaktoeinv = Bukkit.createInventory(null, 9*3, TikTakToeSchwer);
		
		ItemMeta black_glassMeta = black_glass.getItemMeta();
		black_glassMeta.setDisplayName(" ");
		black_glass.setItemMeta(black_glassMeta);
				
		ItemMeta red_dyeMeta = zurück.getItemMeta();
		red_dyeMeta.setDisplayName("§cZurück");
		zurück.setItemMeta(red_dyeMeta);
		
		ItemMeta green_dyeeMeta = aufgeben.getItemMeta();
		green_dyeeMeta.setDisplayName("§aAufgeben");
		aufgeben.setItemMeta(green_dyeeMeta);
		
		tiktaktoeinv.setItem(0, black_glass);
		tiktaktoeinv.setItem(1, black_glass);
		tiktaktoeinv.setItem(2, black_glass);
		tiktaktoeinv.setItem(6, black_glass);
		tiktaktoeinv.setItem(7, black_glass);
		tiktaktoeinv.setItem(8, black_glass);
		tiktaktoeinv.setItem(9, black_glass);
		tiktaktoeinv.setItem(10, black_glass);
		tiktaktoeinv.setItem(11, black_glass);
		tiktaktoeinv.setItem(15, black_glass);
		tiktaktoeinv.setItem(16, black_glass);
		tiktaktoeinv.setItem(17, black_glass);
		tiktaktoeinv.setItem(18, aufgeben);
		tiktaktoeinv.setItem(19, black_glass);
		tiktaktoeinv.setItem(20, black_glass);		
		tiktaktoeinv.setItem(24, black_glass);
		tiktaktoeinv.setItem(25, black_glass);
		tiktaktoeinv.setItem(26, zurück);
		player.openInventory(tiktaktoeinv);
		
	}

	public static void openTikTakToeSchwierigkeitsAuswahl(Player player) {
		Inventory tiktaktoeschwierigketsgrad = Bukkit.createInventory(null, 9*3, TikTakToeSchwierigkeitsgrad);
		
		ItemStack green_wool = new ItemStack(Material.GREEN_WOOL);		
		ItemMeta green_woolMeta = green_wool.getItemMeta();
		green_woolMeta.setDisplayName("§aEinfach");
		green_wool.setItemMeta(green_woolMeta);
		
		ItemStack yellow_wool = new ItemStack(Material.YELLOW_WOOL);		
		ItemMeta yellow_woolMeta = yellow_wool.getItemMeta();
		yellow_woolMeta.setDisplayName("§eMittel");
		yellow_wool.setItemMeta(yellow_woolMeta);

		ItemStack red_wool = new ItemStack(Material.RED_WOOL);		
		ItemMeta red_woolMeta = red_wool.getItemMeta();
		red_woolMeta.setDisplayName("§cSchwer");
		red_wool.setItemMeta(red_woolMeta);
		
		ItemMeta zurückMeta = zurück.getItemMeta();
		zurückMeta.setDisplayName("§cZurück");
		zurück.setItemMeta(zurückMeta);
		
		tiktaktoeschwierigketsgrad.setItem(10, green_wool);
		tiktaktoeschwierigketsgrad.setItem(13, yellow_wool);
		tiktaktoeschwierigketsgrad.setItem(16, red_wool);
		tiktaktoeschwierigketsgrad.setItem(22, zurück);
		player.openInventory(tiktaktoeschwierigketsgrad);

	}
	
	@EventHandler
	public void handleTikTakToeSchwierigkeit(InventoryClickEvent cevent) {
		if(!(cevent.getWhoClicked() instanceof Player)) return;
		Player player = (Player) cevent.getWhoClicked();
		if(cevent.getView().getTitle().equals(TikTakToeSchwierigkeitsgrad)) {
			cevent.setCancelled(true);
				switch(cevent.getCurrentItem().getType()) {
				case GREEN_WOOL:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					openTikTakToeEinfach(player);
					
					break;
				case RED_WOOL:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					openTikTakToeSchwer(player);

					break;
				case YELLOW_WOOL:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					openTikTakToeMittel(player);

					break;
				case RED_DYE:
					
					if(!(cevent.isLeftClick())) return;
					player.closeInventory();
					Navigator.openGUI(player);
					
				default:
				
					break;
				}
		}
	}


	@EventHandler
	public void handleTikTakToeSchwerSpielen(InventoryClickEvent cevent) {
		
		if(!(cevent.getWhoClicked() instanceof Player)) return;
		Player player = (Player) cevent.getWhoClicked();
		if(cevent.getView().getTitle().equals(TikTakToeSchwer)) {
			cevent.setCancelled(true);

			if(cevent.getCurrentItem() == null) {
				int slotnumber = cevent.getSlot();
				ItemStack clickItem = new ItemStack(Material.RED_CONCRETE);
				cevent.getInventory().setItem(slotnumber, clickItem);
			}
				
				switch(cevent.getCurrentItem().getType()) {
					case RED_DYE:
						
						if(!(cevent.isLeftClick())) return;
						player.closeInventory();
						openTikTakToeSchwierigkeitsAuswahl(player);
					
						break;
					case GREEN_DYE:
						
						if(!(cevent.isLeftClick())) return;
						player.closeInventory();
					
						break;
					default:
					
						break;
				
				}
		}
	}
}
