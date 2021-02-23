package meli.ejerc;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	// Retorna una cadena compuesta por n caracteres c
	// Ejemplo: replicate('x',5) ==> 'xxxxx'
	public static String replicate(char c, int n) {
		String rep = "";
		for (int i = 0; i < n; i++) {
			rep += c;
		}

		return rep;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Ejemplo lpad("5",3,'0') ==> "005"
	public static String lpad(String s, int n, char c) {

		if(s.length()==n){
			return s;
		}

		return replicate(c, n - s.length()) + s;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres

	public static String[] toStringArray(int arr[]) {
		String[] strArray = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			strArray[i] = Integer.toString(arr[i]);
		}

		return strArray;
	}

	// construye un int[] conteniendo los elementos de String[] arr
	// representados como cadenas de caracteres
	public static int[] toIntArray(String[] arr) {
	    int[] newArray = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
		    newArray[i] = Integer.parseInt(arr[i]);
		}
		return newArray;
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String[] arr) {
		int max = 0;
		for (String s : arr) {
			if (s.length() > max)
				max = s.length();
		}
		return max;
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String[] arr, char c) {
	    int max = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
				arr[i] = StringUtil.lpad(arr[i], max, c);
		}
	}

	// inicializar las 10 Listas
	public static void initLists(List<String>[] listas ){
		for (int i = 0; i < listas.length; i++) {
			listas[i] = new ArrayList<>();
		}
	}

	// construir array a partir de las listas
	public static void buildArray(String[] strArray, List<String>[] listas) {
		int index = 0;
		for (List<String> l : listas) {
			if (l.size() != 0) {
				for (String s : l) {
					strArray[index] = s;
					index++;
				}
			}
		}
	}
}
