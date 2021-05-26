package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import model.GameBoard;

public class Main {
	
	public static GameBoard gb;
	static BufferedReader br = null;
	//char[] symbols = {'*','!','O','X','%','$','#','+','&'};
	static String[] symbolsArr= {"*","!","O","X","%","$","#","+","&"};
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> symbols = new ArrayList<String>(Arrays.asList(symbolsArr));
		
		String[] stArr = recolectData();
		String[] symbArr;
		
		boolean b=false;
		
		int[] intArr = new int[4];
		for(int i = 0; i<intArr.length; i++) {
			intArr[i]=Integer.parseInt(stArr[i]);
		}
		
		int x=0;
		
		try {
			x=Integer.parseInt(stArr[4]);
			gb = new GameBoard(intArr[0], intArr[1], intArr[2], intArr[3],x);
		}catch (NumberFormatException i) {
			symbArr = stArr[4].split("");
			for(int j = 0; j<symbArr.length && b ;j++) {
				b=false;
				
				for(int d=0; d<symbols.size() && !b ;d++) {
			
					if(symbArr[j]==symbols.get(d)){
						b=true;
						symbols.remove(d);
					}
				}
			
			}
			
			if(b) {
				gb = new GameBoard(intArr[0], intArr[1], intArr[2], intArr[3],symbArr);
			}else {
				System.out.println("No puedes utilizar este caracter, o utilizaste caracteres repetidos");
			}
			
		}
	}

	public Main() throws IOException {
		
		
	}
	
	public static String[] recolectData() throws IOException {
		System.out.println("Digite lo siguiente dividido por un espacio en blanco:\n"+
							"Alto, ancho, n serpientes, n escaleras, n jugadores (Quedaran con un simbolo aleatorio)\n"+
							"En caso de querer escoger usted los símbolos, en lugar de digitar el número de jugadores\n"+
							"Puede escoger entre los siguientes {*,!,O,X,%,$,#,+, &}");
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] stArray = br.readLine().split(" ");
		return stArray;
	}

}


