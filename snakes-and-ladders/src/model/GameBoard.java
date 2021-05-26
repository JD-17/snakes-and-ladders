package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameBoard {
	
	//
	Player[] players;
	Snake[] snakes;
	Ladder[] ladders;
	
	//Attributes
	int n, m, s , e, p, randNumber, randHead, randTail = 0;
	boolean b = true;
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
		snakes = new Snake[s];
		for (int i = 0; i < p; i++) {
			randNumber = randNum.nextInt(8-p+1);
			symbols[i] = allSymbols.get(randNumber);
			allSymbols.remove(randNumber);
			players[i] = new Player(0,i,0,0,symbols[i]);
		}
		for (int i = 0; i < s; i++) {
			randHead = randNum.nextInt((n*m)-1 -m-1)+m+1;
			for(int j = 1; j < n && b; j++) {
				b = false;
				if((randHead / m) >= j) {
					randTail = randNum.nextInt((m*j) -2)+2;
					System.out.println("*****"+j+"  "+m*j);
					b = true;
				}
			}
			
			snakes[i] = new Snake(randHead,randTail);
		}
	}
	public GameBoard(int n, int m, int s, int e, String[] symbols) {
		this.n = n;
		this.m = m;
		this.s = s;
		this.e = e;
		this.symbols = symbols;	
		p = symbols.length;
		for (int i = 0; i < p; i++) {
			players[i] = new Player(0,i,0,0,symbols[i]);
		}
		for (int i = 0; i < s; i++) {
			randHead = randNum.nextInt((n*m)-1 -m-1)+m+1;
			b = true;
			for(int j = 1; j < n && b; j++) {
				b = false;
				if((randHead / m) >= j) {
					randTail = randNum.nextInt((m*j) -2)+2;
					System.out.println("*****"+j+"  "+m*j);
					b = true;
				}
				if(!b) {
					snakes[i] = new Snake(randHead,randTail);
				}
			}
		}
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
	
	public Snake[] getSnakes() {
		return snakes;
	}

}
