package de.philip.TikTakToe;

import org.bukkit.inventory.Inventory;

public class Analyzer {
	
	public static char[] analyzeField(Inventory inv) {
		int[] numbers = new int[] {3,4,5,12,13,14,21,22,23};
		char[] field = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		
		for(int i : numbers) {
			if(inv.getItem(i)!=null) {
			switch(inv.getItem(i).getType()) {
			case RED_CONCRETE: 
				field[getIndex(numbers, i)] = 'X';
				break;
			case BLUE_CONCRETE: 
				field[getIndex(numbers, i)] = 'O';
				break;
			default: 
				break;
			}
		}}
		return field;
	}
	
	public static int getIndex(int[] num, int value) {
		for(int i = 0; i < num.length; i++) {
			if (num[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
