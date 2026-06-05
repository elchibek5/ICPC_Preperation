class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 2);
            n = n / 2;
        }

        int ans = 0;
        int power = 0;
        for (int i = 0; i < list.size(); i++) {
            int digit = list.get(i);
            if (digit == 0) {
                digit = 1;
            } else {
                digit = 0;
            }
            int cast = (int) Math.pow(2, power);
            ans += digit * cast;
            power++;
        }

        return ans;
    }
}
