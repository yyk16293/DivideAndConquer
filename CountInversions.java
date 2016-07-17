package arrayProblems;

public class CountInversions {

	public static long divideAndMergeSortedArray(int[] arrA, int begin, int finish) {

		int mid = (begin) + (finish - begin) / 2;
		int i = begin;
		int j = mid + 1;
		int[] result = new int[arrA.length];
		int k = begin;
		long countInversions = 0;

		while (i <= mid && j <= finish) {

			if (arrA[i] < arrA[j]) {
				result[k++] = arrA[i++];
			} else if (arrA[i] > arrA[j]) {
				result[k++] = arrA[j++];
				countInversions += (mid - i + 1);
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

		return countInversions;

	}

	public static long mergeSort(int[] A, int start, int end) {

		if (start >= end) {
			return 0;
		}

		int mid = start + (end - start) / 2;
		long leftCount = mergeSort(A, start, mid);
		long rightCount = mergeSort(A, mid + 1, end);

		long splitCount = divideAndMergeSortedArray(A, start, end);

		return leftCount + splitCount + rightCount;

	}

	public static void main(String args[]) {

		int[] arrA = { 1, 2, 3, 4, 5, 6 };
		System.out.println(mergeSort(arrA, 0, arrA.length - 1));
	}

}
