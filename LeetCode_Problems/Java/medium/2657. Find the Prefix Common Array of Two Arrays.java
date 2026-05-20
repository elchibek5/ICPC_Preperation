class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];

        HashSet<Integer> seen = new HashSet<>();
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                count++;
            } else {
                if (seen.contains(A[i])) {
                    count++;
                } else {
                    seen.add(A[i]);
                }

                if (seen.contains(B[i])) {
                    count++;
                } else {
                    seen.add(B[i]);
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}   
