package de.philip.TikTakToe;

import java.util.Random;

public class Fieldgenerator {

	public static int fieldGeneratorEinfach(char[] field) {
	    Random randomGenerator = new Random();
	    int i=0;
	    boolean ready=true;
		while(ready) {
			i=randomGenerator.nextInt(9);
			if(field[i]==' ') {
				ready =false;
			}
		}
		return i;
	}
	
	public static int fieldGeneratorMittel(char[] field) {
		
		//Überprüfen der Zeilen
		for (int i = 0; i < 3; i++) {
			if(field[0+i*3] == field[1+i*3] && field[2+i*3] == ' ' && field[0+i*3] == 'O') {
				return 2+i*3;
			}
			if(field[0+i*3] == field[2+i*3] && field[1+i*3] == ' ' && field[0+i*3] == 'O') {
				return 1+i*3;
			}
			if(field[1+i*3] == field[2+i*3] && field[0+i*3] == ' ' && field[1+i*3] == 'O') {
				return 0+i*3;
			}
		}
		
		//Überprüfen der Spalten
		for (int i = 0; i < 3; i++) {
			if(field[0+i*1] == field[3+i*1] && field[6+i*1] == ' ' && field[0+i*1] == 'O') {
				return 6+i*1;
			}
			if(field[6+i*1] == field[0+i*1] && field[3+i*1] == ' ' && field[0+i*1] == 'O') {
				return 3+i*1;
			}
			if(field[3+i*1] == field[6+i*1] && field[0+i*1] == ' ' && field[6+i*1] == 'O') {
				return 0+i*1;
			}
		
		}
		
		//Prüfen der Diagonale rinks oben nach rechts unten
		if(field[0] == field[4] && field[8] == ' ' && field[0] == 'O') {
			return 8;
		}
		
		if(field[0] == field[8] && field[4] == ' ' && field[0] == 'O') {
			return 4;
		}
		
		if(field[4] == field[8] && field[0] == ' ' && field[4] == 'O') {
			return 0;
		}
		
		//prüfen der Diagonalen rechts oben nach links unten
		if(field[2] == field[4] && field[6] == ' ' && field[2] == 'O') {
			return 6;
		}
		
		if(field[2] == field[6] && field[4] == ' ' && field[2] == 'O') {
			return 4;
		}
		
		if(field[6] == field[4] && field[2] == ' ' && field[6] == 'O') {
			return 2;
		}
		
		//Überprüfen der Zeilen
		for (int i = 0; i < 3; i++) {
			if(field[0+i*3] == field[1+i*3] && field[2+i*3] == ' ' && field[0+i*3] == 'X') {
				return 2+i*3;
			}
			if(field[0+i*3] == field[2+i*3] && field[1+i*3] == ' ' && field[0+i*3] == 'X') {
				return 1+i*3;
			}
			if(field[1+i*3] == field[2+i*3] && field[0+i*3] == ' ' && field[1+i*3] == 'X') {
				return 0+i*3;
			}
		}
		
		//Überprüfen der Spalten
		for (int i = 0; i < 3; i++) {
			if(field[0+i*1] == field[3+i*1] && field[6+i*1] == ' ' && field[0+i*1] == 'X') {
				return 6+i*1;
			}
			if(field[6+i*1] == field[0+i*1] && field[3+i*1] == ' ' && field[0+i*1] == 'X') {
				return 3+i*1;
			}
			if(field[3+i*1] == field[6+i*1] && field[0+i*1] == ' ' && field[6+i*1] == 'X') {
				return 0+i*1;
			}
		
		}
		
		//Prüfen der Diagonale rinks oben nach rechts unten
		if(field[0] == field[4] && field[8] == ' ' && field[0] == 'X') {
			return 8;
		}
		
		if(field[0] == field[8] && field[4] == ' ' && field[0] == 'X') {
			return 4;
		}
		
		if(field[4] == field[8] && field[0] == ' ' && field[4] == 'X') {
			return 0;
		}
		
		//prüfen der Diagonalen rechts oben nach links unten
		if(field[2] == field[4] && field[6] == ' ' && field[2] == 'X') {
			return 6;
		}
		
		if(field[2] == field[6] && field[4] == ' ' && field[2] == 'X') {
			return 4;
		}
		
		if(field[6] == field[4] && field[2] == ' ' && field[6] == 'X') {
			return 2;
		}
		
		return fieldGeneratorEinfach(field);
	}
}
