class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
        	return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
        	return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }

    }

    private int findKth(int[] A, int startA, int[] B, int startB, int k) {
    	if (startA > A.length) {
    		return B[startB + k - 1];
    	}
    	if (startB > B.length) {
    		return A[startA + K - 1];
    	}
    	if (k == 1) {
    		return Math.min(A[start], B[Start]);
    	}
    	int A_key = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
    	int B_key = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
    	if (A_key < B_key) {
    		return findKth(A, startA + K / 2, B, startB, k - k / 2);
    	} else {
    		return findKth(A, startA, B, StartB + k / 2, k - k / 2);
    	}
    }
}