package de.philip.TikTakToe;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.philip.Main.Main;
import de.philip.TikTakToe.Inventory.TikTakToe;

public class TikTakToeHandler implements Listener {
	
	private int taskID;
	
	@EventHandler
	public void TikTakToeHandlerEinfach(InventoryClickEvent event) {
			
	if(event.getView().getTitle().equals(TikTakToe.TikTakToeEinfach)) {
	if(event.getWhoClicked() instanceof Player) {
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		//L‰sst den Spieler sein Item setzen
		if(event.getCurrentItem() == null) {
			ItemStack playerItem = TikTakToe.playerMaterial;
			ItemMeta playerMaterialMeta = TikTakToe.playerMaterial.getItemMeta();
			playerMaterialMeta.setDisplayName("ßcRot");
			TikTakToe.playerMaterial.setItemMeta(playerMaterialMeta);
			int slotnumber = event.getSlot();
			event.getInventory().setItem(slotnumber, playerItem);
		
		}else 
		
		if(event.getCurrentItem().getType() == Material.RED_DYE) {
			
			if(event.isLeftClick()) {
			player.closeInventory();
			TikTakToe.openTikTakToeSchwierigkeitsAuswahl(player);
			}
			
		}else 
			
		if(event.getCurrentItem().getType() == Material.GREEN_DYE) {
			
			if(event.isLeftClick()) {
			player.closeInventory();
			}
			
		}else return;
		
		//Ananlysiert Feld als Buchstaben Array
		char[] field = Analyzer.analyzeField(event.getInventory());
		//‹berpr¸ft Buchstabenfeld auf Sieger
		int winner = checkEnd(field);
		//Spieler gewinnt
		if(winner == 1) {
			
			//Startet einen Countdown von 1 Sekunde um dann das Inv zu schlieﬂen
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 1;

				@Override
				public void run() {
					switch (countdown) {
					case 0:			
						player.closeInventory();
						player.sendMessage("ßaßlDu hast gegen den Computer gewonnen :)");
						PotionEffect gewonnen = new PotionEffect(PotionEffectType.SPEED, 200, 49);
						PotionEffect gewonnen2 = new PotionEffect(PotionEffectType.JUMP, 200, 9);
						player.addPotionEffect(gewonnen);
						player.addPotionEffect(gewonnen2);
						Bukkit.getScheduler().cancelTask(taskID);
						
						return;

					default:
						break;

					}
					countdown--;
				}
			}, 0, 20);

			
			return;
		//Unentschieden
		}else if(winner == 0) {
			
			//Startet einen Countdown von 1 Sekunde um dann das Inv zu schlieﬂen
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 1;

				@Override
				public void run() {
					switch (countdown) {
					case 0:			
						player.closeInventory();
						player.sendMessage("ß6ßlDu hast gegen den Computer unentschieden gespielt :|");
						Bukkit.getScheduler().cancelTask(taskID);
						return;

					default:
						break;

					}
					countdown--;
				}
			}, 0, 20);
			
			return;
		}
		
		
		//Ermittelt Zufallsposition in Buchstaben Array
		int position = Fieldgenerator.fieldGeneratorEinfach(field);
		//Position umwandeln in Inventarplatz
		int[] numbers = new int[]{3,4,5,12,13,14,21,22,23};
		//Item setzen ins Inventar
		ItemStack computerItem = TikTakToe.computerMaterial;
		ItemMeta computerItemMeta = TikTakToe.computerMaterial.getItemMeta();
		computerItemMeta.setDisplayName("ß9Blau");
		TikTakToe.computerMaterial.setItemMeta(computerItemMeta);
		event.getInventory().setItem(numbers[position], computerItem);
		//Hat der Computer gewonnen?
		field = Analyzer.analyzeField(event.getInventory());
		winner = checkEnd(field);
		//Computer gewinnt
		if(winner == -1) {
			
			//Startet einen Countdown von 1 Sekunde um dann das Inv zu schlieﬂen
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 1;

				@Override
				public void run() {
					switch (countdown) {
					case 0:			
						player.closeInventory();
						player.sendMessage("ßcßlDu hast gegen den Computer verloren :(");
						PotionEffect verloren = new PotionEffect(PotionEffectType.BLINDNESS, 200, 49);
						PotionEffect verloren2 = new PotionEffect(PotionEffectType.CONFUSION, 200, 49);
						player.addPotionEffect(verloren);
						player.addPotionEffect(verloren2);
						Bukkit.getScheduler().cancelTask(taskID);
						return;

					default:
						break;

					}
					countdown--;
				}
			}, 0, 20);
			
			return;
		}
		}
	}
	}
	
	@EventHandler
	public void TikTakToeHandlerMittel(InventoryClickEvent event) {
			
	if(event.getView().getTitle().equals(TikTakToe.TikTakToeMittel)) {
	if(event.getWhoClicked() instanceof Player) {
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		//L‰sst den Spieler sein Item setzen
		if(event.getCurrentItem() == null) {
			ItemMeta playerMaterialMeta = TikTakToe.playerMaterial.getItemMeta();
			playerMaterialMeta.setDisplayName("ßcRot");
			TikTakToe.playerMaterial.setItemMeta(playerMaterialMeta);
			int slotnumber = event.getSlot();
			event.getInventory().setItem(slotnumber, TikTakToe.playerMaterial);
		
		}else 
		
		if(event.getCurrentItem().getType() == Material.RED_DYE) {
			
			if(event.isLeftClick()) {
			player.closeInventory();
			TikTakToe.openTikTakToeSchwierigkeitsAuswahl(player);
			}
			
		}else 
			
		if(event.getCurrentItem().getType() == Material.GREEN_DYE) {
			
			if(event.isLeftClick()) {
			player.closeInventory();
			}
			
		}else return;
		
		//Ananlysiert Feld als Buchstaben Array
		char[] field = Analyzer.analyzeField(event.getInventory());
		//‹berpr¸ft Buchstabenfeld auf Sieger
		int winner = checkEnd(field);
		//Spieler gewinnt
		if(winner == 1) {
			
			//Startet einen Countdown von 1 Sekunde um dann das Inv zu schlieﬂen
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 1;

				@Override
				public void run() {
					switch (countdown) {
					case 0:			
						player.closeInventory();
						player.sendMessage("ßaßlDu hast gegen den Computer gewonnen :)");
						PotionEffect gewonnen = new PotionEffect(PotionEffectType.SPEED, 200, 49);
						PotionEffect gewonnen2 = new PotionEffect(PotionEffectType.JUMP, 200, 9);
						player.addPotionEffect(gewonnen);
						player.addPotionEffect(gewonnen2);
						Bukkit.getScheduler().cancelTask(taskID);
						
						return;

					default:
						break;

					}
					countdown--;
				}
			}, 0, 20);

			
			return;
		//Unentschieden
		}else if(winner == 0) {
			
			//Startet einen Countdown von 1 Sekunde um dann das Inv zu schlieﬂen
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 1;

				@Override
				public void run() {
					switch (countdown) {
					case 0:			
						player.closeInventory();
						player.sendMessage("ß6ßlDu hast gegen den Computer unentschieden gespielt :|");
						Bukkit.getScheduler().cancelTask(taskID);
						return;

					default:
						break;

					}
					countdown--;
				}
			}, 0, 20);
			
			return;
		}
		
		
		//Ermittelt Zufallsposition in Buchstaben Array
		int position = Fieldgenerator.fieldGeneratorMittel(field);
		//Position umwandeln in Inventarplatz
		int[] numbers = new int[]{3,4,5,12,13,14,21,22,23};
		//Item setzen ins Inventar
		ItemStack computerItem = TikTakToe.computerMaterial;
		ItemMeta computerItemMeta = TikTakToe.computerMaterial.getItemMeta();
		computerItemMeta.setDisplayName("ß9Blau");
		TikTakToe.computerMaterial.setItemMeta(computerItemMeta);
		event.getInventory().setItem(numbers[position], computerItem);
		//Hat der Computer gewonnen?
		field = Analyzer.analyzeField(event.getInventory());
		winner = checkEnd(field);
		//Computer gewinnt
		if(winner == -1) {
			
			//Startet einen Countdown von 1 Sekunde um dann das Inv zu schlieﬂen
			taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				int countdown = 1;

				@Override
				public void run() {
					switch (countdown) {
					case 0:			
						player.closeInventory();
						player.sendMessage("ßcßlDu hast gegen den Computer verloren :(");
						PotionEffect verloren = new PotionEffect(PotionEffectType.BLINDNESS, 200, 49);
						PotionEffect verloren2 = new PotionEffect(PotionEffectType.CONFUSION, 200, 49);
						player.addPotionEffect(verloren);
						player.addPotionEffect(verloren2);
						Bukkit.getScheduler().cancelTask(taskID);
						return;

					default:
						break;

					}
					countdown--;
				}
			}, 0, 20);
			
			return;
		}
		}
	}
	}
	
	public static int checkEnd(char[] Field) {
		
		if (Field[0] == Field[1] && Field[0] == Field[2] && Field[0] == 'X' ||
				Field[3] == Field[4] && Field[3] == Field[5] && Field[3] == 'X' ||
				Field[6] == Field[7] && Field[6] == Field[8] && Field[6] == 'X' ||
				Field[0] == Field[3] && Field[0] == Field[3] && Field[0] == 'X' ||
				Field[1] == Field[4] && Field[1] == Field[7] && Field[4] == 'X' ||
				Field[2] == Field[5] && Field[2] == Field[8] && Field[5] == 'X' ||
				Field[0] == Field[4] && Field[0] == Field[8] && Field[0] == 'X' ||
				Field[2] == Field[4] && Field[6] == Field[4] && Field[2] == 'X') {
				return 1; //1 heiﬂt Spieler hat gewonnen
			}else
		if (Field[0] == Field[1] && Field[0] == Field[2] && Field[0] == 'O' ||
				Field[3] == Field[4] && Field[3] == Field[5] && Field[3] == 'O' ||
				Field[6] == Field[7] && Field[6] == Field[8] && Field[6] == 'O' ||
				Field[0] == Field[3] && Field[0] == Field[3] && Field[0] == 'O' ||
				Field[1] == Field[4] && Field[1] == Field[7] && Field[4] == 'O' ||
				Field[2] == Field[5] && Field[2] == Field[8] && Field[5] == 'O' ||
				Field[0] == Field[4] && Field[0] == Field[8] && Field[0] == 'O' ||
				Field[2] == Field[4] && Field[6] == Field[4] && Field[2] == 'O') {
				return -1; //-1 heiﬂt Com hat gewonnen
		}
		else {
		int count = 0;
		for(char c : Field) {
			if(c == ' ') {
				count++;
			}
		}
		if(count==0) {
			return 0;//0 heiﬂt Unentschieden
		}
		else return 42;
		}
	}
	
}
