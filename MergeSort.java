package arrayProblems;

public class MergeSort {

	public static void divideAndMergeSortedArray(int[] arrA, int begin, int finish) {

		int mid = (begin + finish) / 2;
		int i = begin;
		int j = mid + 1;
		int[] result = new int[arrA.length];
		int k = begin;

		while (i <= mid && j <= finish) {

			if (arrA[i] < arrA[j]) {
				result[k++] = arrA[i++];
			} else if (arrA[i] > arrA[j]) {
				result[k++] = arrA[j++];
			} else {
				result[k++] = arrA[i++];
				result[k++] = arrA[j++];
			}
		}

		if (i > mid) {
			while (j <= finish) {
				result[k++] = arrA[j++];
			}
		} else if (j > finish) {
			while (i <= mid) {
				result[k++] = arrA[i++];
			}
		}

		// copying the elements from result to A

		for (int l = begin; l <= finish; l++)
			arrA[l] = result[l];
	}

	public static void mergeSort(int[] A, int start, int end) {

		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		mergeSort(A, start, mid);
		mergeSort(A, mid + 1, end);

		divideAndMergeSortedArray(A, start, end);

	}



}
