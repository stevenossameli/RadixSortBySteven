package meli.ejerc;

import java.util.ArrayList;
import java.util.List;

/*
Coded By Steven Ossa
*/

public class RadixSortEjerc {


    public static void radixSort(int[] arr) {

        // Paso 1
        // Convertir String[] en int[]
        String[] strArray = StringUtil.toStringArray(arr);

        // Paso 2
        // Completa los elemento del arr agregando caracteres c
        // a la izquierda, dejando a todos con la longitud del mayor
        StringUtil.lNormalize(strArray, '0');

        //Paso 3, crear 10 listas vacías
        List<String>[] listas = new ArrayList[10];

        //instancia cada elemento de las listas
        StringUtil.initLists(listas);

        // Paso 4, recorremos el array verificando el ultimo dígito agregándolo a la lista Li
        int max = StringUtil.maxLength(strArray) - 1;
        while(max >= 0){
            for (String s :
                    strArray) {
                int index = Integer.parseInt(String.valueOf(s.charAt(max)));
                listas[index].add(s);
            }

            //Paso 5, generamos el String[] a partir de los elementos de las listas Li
            StringUtil.buildArray(strArray, listas);
            StringUtil.initLists(listas); // reiniciamos las listas para la prox iteración

            //pasos 6 y 7, se itera n veces hasta ordenar el arreglo
            max--;
        }


        // Convertimos el String[] en int[]
         StringUtil.toIntArray(strArray, arr);

    }

    public static void main(String[] args) {

        int[] arr = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
    }
}
