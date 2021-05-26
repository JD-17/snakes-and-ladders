package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import model.GameBoard;

public class Main {
	
	public static GameBoard gb;
	public static boolean bol = true;
	private static BufferedReader br = null;
	public static String[] allSymbolsArray = {"*","!","O","X","%","$","#","+","&"};
	
	public static void main(String[] args) throws IOException {
		collectData(false);
	}
	
	public static String[] inOut(boolean compr) throws IOException {
		if(bol) {
			System.out.println("Digite lo siguiente dividido por un espacio en blanco:\n"+
					"Alto, ancho, n serpientes, n escaleras, n jugadores (Quedarán con simbolos aleatorios)\n"+
					"En caso de querer escoger usted los símbolos, en lugar de digitar el número de jugadores\n"+
					"Puede escoger entre los siguientes {*,!,O,X,%,$,#,+,&}");
			bol = false;
		}else {
			System.out.println("Compruebe los datos, e ingreselos nuevamente");
			if(compr) {
				System.out.println("La cuadricula debe ser más grande; o bien las serpientes y escaleras menos");
			}
		}
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] stArray = br.readLine().split(" ");
		return stArray;
	}
	
	public static void collectData(boolean compr) throws IOException {
		ArrayList<String> allSymbols = new ArrayList<String>(Arrays.asList(allSymbolsArray));
		String[] stArray = inOut(compr);
		String[] symbolsArr;
		int[] intArr = new int[4];
		
		boolean b = true;
		int lastN = 0;
		
		for(int i = 0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(stArray[i]);
		}
		
		/*try {
			randHead = randNum.nextInt((n*m)-1 -m-1)+m+1;
			randTail = randNum.nextInt((m*j) -2)+2;
		}*/
		
		try {
			lastN = Integer.parseInt(stArray[4]);
			if(intArr[0]==0 || intArr[1]==0 || intArr[2]==0 || intArr[3]==0 || lastN==0) {
				System.out.println(" * Asegurate de que ningún valor sea 0\n");
				collectData(false);
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
				collectData(false);
			}
			
		}
	}

}


