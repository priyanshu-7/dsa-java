class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
       if(s.length() == 0) return 0;
       if(s.trim().length() == 0) return 1;
       int max = 1;
       for(int i = 0; i<s.length(); i++)
       {
           HashMap<Character, Boolean> map = new HashMap<>();
           map.put(s.charAt(i), true);
           for(int j = i+1; j<s.length(); j++)
           {
               char ch = s.charAt(j);
               if(map.containsKey(ch) && map.get(ch) == true)
               {
                   break;
               }
               else 
               {
                   map.put(ch, true);
                   max = Math.max(max, j-i+1); //get size of current window   
               }
           }
       }
       return max;
    }
}