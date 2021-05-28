package model;

import java.util.ArrayList;

public class Snake {
	
	//Attributes
	//int head, tail, numb = 0;
	ArrayList<Integer> heads = new ArrayList<>();
	ArrayList<Integer> tails = new ArrayList<>();
	
	public Snake(int head, int tail) {
		heads.add(head);
		tails.add(tail);
		
		selectionSort();
	}
	
	public void selectionSort(){  
		for(int i = 0; i < tails.size() ; i++){
			int index = i; 
            
            for(int j = i + 1; j < tails.size(); j++){  
                if (tails.get(j) < tails.get(index)){  
                    index = j;
                }  
            }  
            int temp = tails.get(index);  
            int temp2 = heads.get(index);
            tails.set(index, tails.get(i));
            heads.set(index, heads.get(i));
            tails.set(i, temp);
            heads.set(i, temp2);
        }  
    }  
	
	public String toString(int n) {
		return ""+heads.get(n)+" and "+tails.get(n);
	}
	
	public int getHead() {
		return heads.get(0);
	}
	
	public int getTail() {
		return tails.get(0);
	}
	

}
