import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder answer = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (carry > 0 || i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            carry = sum / 2;
            answer.append(sum % 2);
        }
        return answer.reverse().toString();
        
        // SOLUTION #1
        // BigInteger aBig = new BigInteger(a, 2);
        // BigInteger bBig = new BigInteger(b, 2);
        // return aBig.add(bBig).toString(2);

        // SOLUTION #2
        // int i = a.length() - 1;
        // int j = b.length() - 1;
        // int carry = 0;
        // StringBuilder result = new StringBuilder();

        // while (i >= 0 || j >= 0 || carry > 0) {
        //     int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
        //     int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;
        //     int sum = digitA + digitB + carry;

        //     result.append(sum % 2);
        //     carry = sum / 2;
            
        //     i--;
        //     j--;
        // }
        // return result.reverse().toString();
    }
}
