package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import ui.Main;

public class GameBoard {
	
	//
	Player[] players;
	Snake[] snakes;
	Ladder[] ladders;
	
	//Attributes
	int n, m, s , e, p, randNumber, randHead, randTail = 0;
	boolean comprRand = true;
	ArrayList<Integer> headsAndTails = new ArrayList<>(); 
	
	private String[] allSymbolsArray = {"*","!","O","X","%","$","#","+","&"};
	private ArrayList<String> allSymbols = new ArrayList<String>(Arrays.asList(allSymbolsArray));
	String[] symbols; 
	Random randNum = new Random();
	
	/*
	 * n and m are width and height
	 * s and e are number of snakes and ladders
	 * p is the number of players */
	
	//Constructores
	public GameBoard(int n, int m, int s, int e, int p) throws IOException {
		this.n = n;
		this.m = m;
		this.s = s;
		this.e = e;
		this.p = p;
		symbols = new String[p];
		players = new Player[p];
		snakes = new Snake[s];
		for (int i = 0; i < p; i++) {
			randNumber = randNum.nextInt(8-p+1);
			symbols[i] = allSymbols.get(randNumber);
			allSymbols.remove(randNumber);
			players[i] = new Player(0,i,0,0,symbols[i]);
		}
		try {
			randomHeadTail();
			
		}catch(IllegalArgumentException x) {
			Main.collectData(comprRand);
		}
		
	}
	
	public GameBoard(int n, int m, int s, int e, String[] symbols) throws IOException {
		this.n = n;
		this.m = m;
		this.s = s;
		this.e = e;
		this.symbols = symbols;	
		p = symbols.length;
		players = new Player[p];
		snakes = new Snake[s];
		
		for (int i = 0; i < p; i++) {
			players[i] = new Player(0,i,0,0,this.symbols[i]);
		}
		try {
			randomHeadTail();
			
		}catch(IllegalArgumentException x) {
			Main.collectData(comprRand);
		}
	}
	
	//to choose random heads and tails
	public void randomHeadTail() throws IOException {
		for (int i = 0; i < s; i++) {
			headsAndTails.add(randHead);
			while(headsAndTails.contains(randHead)) {
				if(s+e >(n/2)*m) {
					Main.collectData(comprRand);
				}
				randHead = randNum.nextInt((n*m)-1 -m-1)+m+1;
			}
			
			for(int j = 1; j < n ; j++) {
				
				if((randHead*1.0 / m) > j) {
					headsAndTails.add(randTail);
					while(headsAndTails.contains(randTail)) {
						randTail = randNum.nextInt((m*j) -2)+2;
					}
				}
			}
			
			snakes[i] = new Snake(randHead,randTail);
		}
		
	}
	
	//
	public Snake[] getSnakes() {
		return snakes;
	}
	
	//Getters
	public int getNRows() {
		return n;
	}
	
	public int getNColumns() {
		return m;
	}
	
	public int getNSnakes() {
		return s;
	}
	
	public int getNLadders() {
		return e;
	}
	
	public int getNPlayers() {
		return p;
	}

}
