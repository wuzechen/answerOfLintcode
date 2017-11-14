public class Solution {
    /*
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        
        //check edge
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        if (Math.abs(dividend) > Integer.MAX_VALUE) {
            System.out.println("" + Math.abs(dividend));
            return Integer.MAX_VALUE;
        }
        
        
        int result = 0;
        long longDividend = Math.abs((long)dividend);
        long longDivisor= Math.abs((long)divisor);
        boolean mFlag = false;
        
        if (dividend < 0) {
            mFlag = true;
        }
        
        if (divisor < 0) {
            if (mFlag) {
                mFlag = false;
            } else {
                mFlag = true;
            }
        }
        
        // split the long range to the less half
        while (longDividend >= longDivisor) {
            int count = 0;
            while (longDividend >= longDivisor << (count)) {
                count++;
            }
            longDividend -= longDivisor << (count - 1);
            result += 1 << (count - 1);
        }
        
        if (mFlag) {
            result = -result;
        }
        
        return result;
    }
}