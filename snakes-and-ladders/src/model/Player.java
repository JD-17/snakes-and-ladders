package model;

public class Player {
	
	//Attributes
	int movements, turn, box, diceSc = 0;
	char symbol = 'a';
	
	public Player(int movements, int turn, int box, int diceSc, char symbol) {
		this.movements = movements;
		this.turn = turn;
		this.box = box;
		this.diceSc = diceSc;
		this.symbol = symbol;
	}
	
	//Getters
	
	public int getMovements() {
		return movements;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public int getBox() {
		return box;
	}
	
	public int getDiceSc() {
		return diceSc;
	}
	
	public char getSymbol() {
		return symbol;
	}
	

}
