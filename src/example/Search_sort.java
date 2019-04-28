package example;

import java.util.Arrays;

public class Search_sort{
	
	public static int linearSearch(int[] arr, int x){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == x)
				return i;
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> int binarySearch(E[] arr, E x){
		return binarySearch(arr, 0, arr.length - 1, x);
	}
	
	public static <E extends Comparable<E>> int binarySearch(E[] arr, int left, int right, E x){
		if(right >= left){
			int mid    = left + (right - left) / 2;
			int result = arr[mid].compareTo(x);
			if(result == 0){
				// If the element is present at the
				// middle itself
				return mid;
			}else if(result > 0){
				// If element is smaller than mid, then
				// it can only be present in left subarray
				return binarySearch(arr, left, mid - 1, x);
			}else{
				// Else the element can only be present
				// in right subarray
				return binarySearch(arr, mid + 1, right, x);
			}
		}
		// We reach here when element is not present
		// in array
		return -1;
	}
	
	private static <E extends Comparable<E>> void insertion_sort(E[] data){
		// start sorting, iterate througe the whole collection, starts from index 1
		for(int index = 1; index < data.length; index++){
			E value = data[index];
			// find the desired index for current value
			int desiredIndex = index;
			for(int inner_index = index - 1; inner_index >= 0; inner_index--){
				if(value.compareTo(data[inner_index]) < 0){
					// if smaller means needs continue to check
					desiredIndex = inner_index;
				}else{
					// if bigger or equals to means has found
					break;
				}
			}
			// move it to the desired index
			if(desiredIndex != index){
				System.arraycopy(data, desiredIndex, data, desiredIndex + 1, index - desiredIndex);
				data[desiredIndex] = value;
			}
		}
	}
	
	private static <E extends Comparable<E>> void selection_sort(E[] data){
		// start sorting, iterate through the whole collection
		for(int index = 0; index < data.length; index++){
			// starts to find the local min, and move it to index
			int localMinIndex = index;
			for(int inner_index = index + 1; inner_index < data.length; inner_index++){
				// if smaller than localMin, then set the localMin to be current inner_index
				if(data[inner_index].compareTo(data[localMinIndex]) < 0){
					localMinIndex = inner_index;
				}
			}
			// move localMin to index
			swap(data, localMinIndex, index);
		}
	}
	
	public static <E extends Comparable<E>> void swap(E[] data, int index_1, int index_2){
		if(index_1 == index_2)
			return;
		E e = data[index_1];
		data[index_1] = data[index_2];
		data[index_2] = e;
	}
	
	private static <E extends Comparable<E>> void merge_sort(E[] data){
		merge_sort_split(data, 0, data.length - 1);
	}
	
	/**
	 * divide all data from leftBounds to rightBounds in half
	 *
	 * @param data        the data
	 * @param leftBounds  left bounds
	 * @param rightBounds right bounds
	 */
	private static <E extends Comparable<E>> void merge_sort_split(E[] data, int leftBounds, int rightBounds){
		// if left bounds is equals or bigger than right bounds means the left and right collapsed
		// (no value left between left and right)
		if(leftBounds >= rightBounds)
			return;
		// calculate the middle
		int middle = (leftBounds + rightBounds) / 2;
		// continue to split the to left part and right part
		merge_sort_split(data, leftBounds, middle);
		merge_sort_split(data, middle + 1, rightBounds);
		// if spitted, starts merging
		merge_sort_merge(data, leftBounds, middle, rightBounds);
	}
	
	/**
	 * merge [left...mid] and [mid+1...right]
	 *
	 * @param data        the data set
	 * @param leftBounds  the left bounds
	 * @param mid         the middle point
	 * @param rightBounds the right bounds
	 */
	private static <E extends Comparable<E>> void merge_sort_merge(E[] data, int leftBounds, int mid, int rightBounds){
		E[] subData = Arrays.copyOfRange(data, leftBounds, rightBounds + 1);
		// init, left_pointer points to left start, right_pointer points right start
		int left_pointer  = leftBounds;
		int right_pointer = mid + 1;
		// iterate through the whole collection
		for(int index = leftBounds; index <= rightBounds; index++){
			if(left_pointer > mid){
				// if all left has been processed
				data[index] = subData[right_pointer - leftBounds];
				right_pointer++;
			}else if(right_pointer > rightBounds){
				// if all right has been processed
				data[index] = subData[left_pointer - leftBounds];
				left_pointer++;
			}else if(subData[left_pointer - leftBounds].compareTo(subData[right_pointer - leftBounds]) < 0){
				// if left data < right data then let left data add
				data[index] = subData[left_pointer - leftBounds];
				left_pointer++;
			}else{
				// if left data >= right data then let right data add
				data[index] = subData[right_pointer - leftBounds];
				right_pointer++;
			}
		}
	}
}
