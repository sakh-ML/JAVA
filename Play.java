import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Play{
	public static void main(String[] args){
		//System.out.println("Hey");
		//Animal a1 = new Animal();
		//a1.run();
		//System.out.println(a1.speak());
		//Dog d1 = new Dog();
		//d1.run();
		//System.out.println(d1.speak());

		Set<Integer> nums = new HashSet<>();
		nums.add(5);
		nums.add(3);
		nums.add(1);
		nums.add(2);
		nums.add(4);
		//3System.out.println(findMaxInSet(nums));
		int[] testArray = {5,3,8,10,2,6,31};
		mergeSort(testArray);
		for(int n : testArray){
			System.out.println(n);
		}

	}

	public static void mergeSort(int[] arr){
		int size = arr.length;
		int left = 0;
		int right = size - 1;
		mergeSort(arr, left, right);
	}

	public static void mergeSort(int[] arr, int left, int right){

		int middle = (left + right) / 2;
		if(left < right){
			mergeSort(arr, left,middle);
			mergeSort(arr, middle + 1, right);
			mergeTwoArrays(arr, left, middle, right);
		}
	}

	public static void mergeTwoArrays(int[] array, int left, int middle, int right){
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for(int i = 0; i < leftArraySize; ++i){
			leftArray[i] = array[left + i];
		}

		for(int i = 0; i < rightArraySize; ++i){
			rightArray[i] = array[middle + 1 + i];
		}

		int leftArrayIndex =  0;
		int rightArrayIndex = 0;
		int arrayIndexUeberschreiben = left;

		while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize){
			if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]){
				array[arrayIndexUeberschreiben] = leftArray[leftArrayIndex];
				++leftArrayIndex;
			}
			else{
				array[arrayIndexUeberschreiben] = rightArray[rightArrayIndex];
				++rightArrayIndex;
			}
			++arrayIndexUeberschreiben;
		}

		while(leftArrayIndex < leftArraySize){
			array[arrayIndexUeberschreiben] = leftArray[leftArrayIndex];
			++arrayIndexUeberschreiben;
			++leftArrayIndex;
		}

		while(rightArrayIndex < rightArraySize){
			array[arrayIndexUeberschreiben] = rightArray[rightArrayIndex];
			++arrayIndexUeberschreiben;
			++rightArrayIndex;
		}
	}
















	/*

	public static void mergeArray(int[] arr){
		int size = arr.length;
		int left = 0;
		int right = size - 1;
		mergeSort(arr,left,right);
	}

	public static void mergeSort(int[] array, int left, int right){

		int middle = (left + right) / 2;
		if(left < right){
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			mergeTwoArrays(array, left, middle, right);

		}
	}

	public static void mergeTwoArrays(int[] array, int left, int middle, int right){
		int sizeFirstArray = middle - left + 1;
		int sizeSecondArray = right - middle;

		int[] leftArray = new int[sizeFirstArray];
		int[] rightArray = new int[sizeSecondArray];

		for(int i = 0; i < sizeFirstArray; ++i){
			leftArray[i] = array[left + i];
		}

		for(int j = 0; j < sizeSecondArray; ++j){
			rightArray[j] = array[middle + j + 1];
		}

		//jetzt beide left und right aray zusammenfügen
		int i = 0;
		int j = 0;
		int k = left;
		while(i < sizeFirstArray && j < sizeSecondArray){
			if(leftArray[i] <= rightArray[j]){
				array[k] = leftArray[i];
				++i;
			}
			else{
				array[k] = rightArray[j];
				++j;
			}
			++k;
		}

		if(i < sizeFirstArray){
			while(i < sizeFirstArray){
				array[k] = leftArray[i];
				++i;
				++k;
			}
		}

		if(j < sizeSecondArray){
			while(j < sizeSecondArray){
				array[k] = rightArray[j];
				++j;
				++k;
			}
		}
	}
*/
	public static int findMaxInSet(Set<Integer> nums){

		if (nums.isEmpty() || nums == null){
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for(int n : nums){
			if(n > max){
				max = n;
			}
		}
		return max;
	}
}


class Dog extends Animal{}

class Animal implements CanRun, CanSpeak{
	@Override
	public String speak(){
		return "Animal is making sound";
	}

	@Override
	public void run() {
		System.out.println("Animal is running");
	}
}

interface CanSpeak{
	public String speak();
}

interface CanRun{
	public void run();
}