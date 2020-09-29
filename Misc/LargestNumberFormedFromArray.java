/*Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.*/

class Solution {
    public String largestNumber(int[] nums) 
    {
        if(nums.length == 0) return "0";
        String[] s = new String[nums.length];
        for(int i = 0; i<nums.length; i++)
        {
            s[i]=Integer.toString(nums[i]);
        }
        //sort array according to our required answer.
        Arrays.sort(s, new Comparator<String>(){
           public int compare(String a, String b)
           {
               String o1 = a+b;
               String o2 = b+a;
               return o2.compareTo(o1); //compare which is bigger                                           330 or 303
           }
        });
        
        //after sorting if first num is 0, just return 0
        if(s[0].equals("0")) return "0";
        String answer = "";
        for(int i = 0; i<s.length; i++)
        {
            answer+=s[i];
        }
        return answer;
    }
}