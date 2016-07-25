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

	public static void main(String args[]) {

		int[] arrA = { 1, 3, 5, 7, 9, 11 };
		int[] arrB = { 2, 4, 6, 8, 10, 13 };
		int[] arrD = { 1, 3, 14, 2, 12, 100, 23, 85, 68 };

		mergeSort(arrD, 0, arrD.length - 1);

		// divideAndMergeSortedArray(arrD, 0, arrD.length - 1);
		// int[] arrC = mergeTwoSortedArrays(arrA, arrB);

		// for (int i = 0; i < arrC.length; i++)
		// System.out.print(arrC[i] + " ");

		System.out.println();

		for (int i = 0; i < arrD.length; i++)
			System.out.print(arrD[i] + " ");

	}

}
