class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '-') {
            sign = -1;
            index++;
        } else if (firstChar == '+') {
            index++;
        }

        long result = 0;
        while (index < n) {
            char currentChar = s.charAt(index);
            
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            int digit = currentChar - '0';
            result = result * 10 + digit;

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int) (result * sign);
    }
}
