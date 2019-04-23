package test_2018;

import java.util.Arrays;

public class ArrayTester{
	
	public static int[] getColumn(int[][] arr2D, int c){
		int[] arr = new int[arr2D.length];
		for(int row = 0; row < arr2D.length; row++)
			arr[row] = arr2D[row][c];
		return arr;
	}
	
	public static boolean hasAllValue(int[] arr1, int[] arr2){
		int[] buffer = Arrays.copyOf(arr2, arr2.length);
		Arrays.sort(buffer);
		for(int v1 : arr1){
			for(int index = 0; index < buffer.length; index++){
				int v2 = buffer[index];
				if(v2 == v1){
					break;
				}else if(v2 > v1 || index + 1 == buffer.length){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean containsDuplicates(int[] arr){
		for(int index = 0; index < arr.length; index++){
			for(int innerIndex = index + 1; innerIndex < arr.length; innerIndex++){
				if(arr[index] == arr[innerIndex]){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isLatin(int[][] square){
		if(containsDuplicates(square[0]))
			return false;
		for(int row = 1; row < square.length; row++){
			if(!hasAllValue(square[0], square[row])){
				return false;
			}
		}
		for(int col = 0; col < square.length; col++){
			if(!hasAllValue(square[0], getColumn(square, col))){
				return false;
			}
		}
		return true;
	}
}
