package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameBoard {
	
	//
	Player[] players;
	
	//Attributes
	int n, m, s , e, p, randIndex = 0;
	private String[] allSymbolsArray = {"*","!","O","X","%","$","#","+","&"};
	private ArrayList<String> allSymbols = new ArrayList<String>(Arrays.asList(allSymbolsArray));
	String[] symbols; 
	Random randNum = new Random();
	
	/*
	 * n and m are width and height
	 * s and e are number of snakes and ladders
	 * p is the number of players */
	
	public GameBoard(int n, int m, int s, int e, int p) {
		this.n = n;
		this.m = m;
		this.s = s;
		this.e = e;
		this.p = p;
		symbols = new String[p];
		players = new Player[p];
		for (int i = 0; i < p; i++) {
			randIndex = randNum.nextInt(8-p+1);
			symbols[i] = allSymbols.get(randIndex);
			allSymbols.remove(randIndex);
			players[i] = new Player(0,i,0,0,symbols[i]);
		}
	}
	public GameBoard(int n, int m, int s, int e, String[] symbols) {
		this.n = n;
		this.m = m;
		this.s = s;
		this.e = e;
		this.symbols = symbols;	
		p = symbols.length;
	}
	
	public int getN() {
		return n;
	}
	
	public int getM() {
		return m;
	}
	
	public int getS() {
		return s;
	}
	
	public int getE() {
		return e;
	}
	
	public int getP() {
		return p;
	}
	

}
