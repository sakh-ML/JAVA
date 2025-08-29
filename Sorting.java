import java.util.Arrays;

public class Sorting{
	public static void main(String[] args){

		/*
		System.out.println("Hey");
		MergeSort<Integer> ms = new MergeSort<>();
		Integer[] nums = {3,1,7,2};
		ms.merge(nums);
		for(int n : nums){
			System.out.print(n + " ");
		}
		 */
	}
}

class MergeSort <T extends Comparable<T>> {
	public void merge(T[] array){
		int size = array.length;
		int left = 0;
		int right = size - 1;
		mergeSort(array, left, right);
	}

	private void mergeSort(T[] array, int left, int right){
		int middle = (left + right) / 2;

		if(left < right){
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			mergeTwoArrays(array, left, middle, right);
		}
	}

	private void mergeTwoArrays(T[] array, int left, int middle, int right){

		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;
		T[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
		T[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int orginalArrayIndex = left;

		while(leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize){
			if(leftArray[leftArrayIndex].compareTo(rightArray[rightArrayIndex]) <= 0){
				array[orginalArrayIndex] = leftArray[leftArrayIndex];
				++leftArrayIndex;
			}
			else{
				array[orginalArrayIndex] = rightArray[rightArrayIndex];
				++rightArrayIndex;
			}
			++orginalArrayIndex;
		}

		while(leftArrayIndex < leftArraySize){
			array[orginalArrayIndex] = leftArray[leftArrayIndex];
			++leftArrayIndex;
			++orginalArrayIndex;
		}

		while(rightArrayIndex < rightArraySize){
			array[orginalArrayIndex] = rightArray[rightArrayIndex];
			++rightArrayIndex;
			++orginalArrayIndex;
		}
	}
}