package model;

public class GameBoard {
	
	//Attributes
	int n, m, s , e, p = 0;
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
