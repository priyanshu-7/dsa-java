class Solution {
    public boolean isSubsequence(String s, String t) {
        int originalLen = t.length();
        int subLen = s.length();
        int i = 0, j = 0;
        while(i<originalLen && j<subLen) {
            if(t.charAt(i) == s.charAt(j)) {
                i++; 
                j++;
            } else {
                i++;
            }
        }
        return (subLen == j);
    }
}