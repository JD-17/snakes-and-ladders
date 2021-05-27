package model;

public class Snake {
	
	//Attributes
	int head, tail = 0;
	
	public Snake(int head, int tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public String toString() {
		return ""+head+" and "+tail;
	}
	
	public int getHead() {
		return head;
	}
	
	public int getTail() {
		return tail;
	}
	

}
