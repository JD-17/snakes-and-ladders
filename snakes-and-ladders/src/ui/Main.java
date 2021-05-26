package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import model.GameBoard;

public class Main {
	
	public static GameBoard gb;
	private static BufferedReader br = null;
	public static String[] allSymbolsArray = {"*","!","O","X","%","$","#","+","&"};
	
	public static void main(String[] args) throws IOException {
		collectData();
		if(gb != null) {
			
		}
		
	}
	
	public static String[] inOut() throws IOException {
		System.out.println("Digite lo siguiente dividido por un espacio en blanco:\n"+
							"Alto, ancho, n serpientes, n escaleras, n jugadores (Quedarán con simbolos aleatorios)\n"+
							"En caso de querer escoger usted los símbolos, en lugar de digitar el número de jugadores\n"+
							"Puede escoger entre los siguientes {*,!,O,X,%,$,#,+,&}");
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] stArray = br.readLine().split(" ");
		return stArray;
	}
	
	public static void collectData() throws IOException {
		ArrayList<String> allSymbols = new ArrayList<String>(Arrays.asList(allSymbolsArray));
		String[] stArray = inOut();
		String[] symbolsArr;
		int[] intArr = new int[4];
		
		boolean b = true;
		int lastN = 0;
		
		for(int i = 0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(stArray[i]);
		}
		
		try {
			lastN = Integer.parseInt(stArray[4]);
			if(intArr[0]==0 || intArr[1]==0 || intArr[2]==0 || intArr[3]==0 || lastN==0) {
				System.out.println(" * Asegurate de que ningún valor sea 0\n");
				collectData();
			}
			gb = new GameBoard(intArr[0], intArr[1], intArr[2], intArr[3], lastN);
			
		} catch (NumberFormatException e) {
			symbolsArr = stArray[4].split("");
			for(int i = 0; i<symbolsArr.length && b ;i++) {
				b = false;
				
				for(int j = 0; j<allSymbols.size() && !b ;j++) {
					if(symbolsArr[i].equals(allSymbols.get(j))){
						b = true;
						allSymbols.remove(j);
					}
				}
			}
			
			if(b) {
				gb = new GameBoard(intArr[0], intArr[1], intArr[2], intArr[3],symbolsArr);
			}else {
				System.out.println(" * Caracter invalido o repetido\n");
				collectData();
			}
			
		}
		System.out.println(gb.getSnakes()[0].toString());
		System.out.println(gb.getSnakes()[1].toString());
		System.out.println(gb.getSnakes()[2].toString());
	}

}


