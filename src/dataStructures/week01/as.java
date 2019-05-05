package dataStructures.week01;

public class as {
	public static void main(String[] args) {
		int[] a = {5,56,315,3,1};
		System.out.println(binarySearch(a, 1));
	}

	private static int binarySearch(int[] a,int key) {
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
}
