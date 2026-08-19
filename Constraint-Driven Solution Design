class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        int countA = 0, countB = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }
        }
        
        for (int i = mid; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countB++;
            }
        }
        
        return countA == countB;
    }
}
