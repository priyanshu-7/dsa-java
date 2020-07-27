import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.*;

public class String
{	
	boolean anagramCheck(String s1, String s2)
	{
		if(s1.length()!=s2.length())
		{
			return false;
		}
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		//add chars of str1 to map1
		for(int i = 0; i<s1.length(); i++)
		{
			char ch = s1.charAt(i);
			if(map1.containsKey(ch))
			{
				map1.put(ch, map1.get(ch)+1);
			}
			else 
			{
				map1.put(ch, 1);
			}
		}
		//add chars of str2 to map2
		for(int i = 0; i<s2.length(); i++)
		{
			char ch = s2.charAt(i);
			if(map2.containsKey(ch))
			{
				map2.put(ch, map2.get(ch)+1);
			}
			else 
			{
				map2.put(ch, 1);
			}
		}
		return map1.equals(map2); //two maps are equal if all the keys/value pairs are same.
	}
	
	//check which is the first repeating character
	void firstRepeatingCharacter(String s)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<s.length(); i++)
		{
			if(map.containsKey(s.charAt(i)))
			{
				System.out.println(s.charAt(i));
				break;
			}
			else
			{
				map.put(s.charAt(i), 1);
			}
		}
	}
	//iterate the string from right to left, create an array to keep track of all repeating chars create a var to keep track of last repeating char
	Character leftmostRepeatingCharacter(String s)
	{
		char leftmostRepeating = ' ';
		boolean arr[] = new boolean[27];
		for(int i = s.length()-1; i>=0; i--)
		{
			char ch = s.charAt(i);
			if(arr[ch-97] == true)
			{
				leftmostRepeating = ch;
			}
			arr[ch-97] = true;
		}
		return(leftmostRepeating);
	}
	//logic same as above
	Character leftmostNonRepeatingCharacter(String s)
	{
		int count[] = new int[26];
	      for(int i = 0; i<S.length(); i++)
	      {
		  char ch = S.charAt(i);
		  count[ch-97]++;
	      }
	      for(int i = 0; i<S.length(); i++)
	      {
		  char ch = S.charAt(i);
		  if(count[ch-97] == 1)
		  {
		      return ch;
		  }
	      }
	      return '$'; //no repeating char
	}
	void naivePatternSearch(String txt, String pat)
	{
		int m = pat.length();
		int n = txt.length();
		for(int i = 0; i<n-m; i++)
		{
			for(int j = 0; j<m; j++)
			{
				if(pat.charAt(j)!=txt.charAt(i+j))
				{
					break;
				}
				if(j == m-1)
				{
					System.out.println(i); //starting index of pattern
				}
			}
		}
	}
	
	//check if str1 can be achieved by rotating str2 to two places (GFG solution)
	static boolean isRotated(String str1, String str2) 
    { 
        if (str1.length() != str2.length()) 
            return false; 
       
        String clock_rot = ""; 
        String anticlock_rot = ""; 
        int len = str2.length(); 
       
        // Initialize string as anti-clockwise rotation 
        anticlock_rot = anticlock_rot + 
                        str2.substring(len-2, len) + 
                        str2.substring(0, len-2) ; 
       
        // Initialize string as clock wise rotation 
        clock_rot = clock_rot + 
                    str2.substring(2) + 
                    str2.substring(0, 2) ; 
       
        // check if any of them is equal to string1 
        return (str1.equals(clock_rot) || 
                str1.equals(anticlock_rot)); 
    } 
	
	//check if a string contains an anagram eg -> froggy, frog -> forg is an anagram of frog.
	boolean isAnagramReverse(String txt, String pat)
	{
		int CT[] = new int[256];
		int CP[] = new int[256];
		//Handling first pat.length() chars in both txt and pat
		for(int i = 0; i<pat.length(); i++)
		{
			CT[txt.charAt(i)]++;
			CP[pat.charAt(i)]++;
		}
		//handling next remaining chars
		for(int i = pat.length(); i<txt.length(); i++)
		{
			if(Arrays.equals(CT, CP))
			{
				return true;
			}
			CT[txt.charAt(i)]++; //add new char to window
			CT[txt.charAt(i-pat.length())]--; //remove first char from last window from count
		}
		return false;
	}
	//reverse words in a string
	String reverseWordsInAString(String s)
	{
		String answer = ""; 
		String test[] = s.split(" ");
		for(int i = 0; i<test.length; i++)
		{
			//we can avoid using StringBuffer by simply reversing characters of a particular word using two pointer method
			StringBuffer buf = new StringBuffer(test[i]);
			buf = buf.reverse();
			test[i] = buf.toString();
			answer+=test[i]+" ";
		}
		s = answer.substring(0, answer.length()-1); //remove extra space at the end and copy to original string
		return s;
	}
	void regex(String s)
	{
		System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)  
		System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)  
		System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)  
		System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)  
		System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)  
		System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)  
		System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once) 
		System.out.println("metacharacters d....");//d means digit  
		System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)  
		System.out.println(Pattern.matches("\\d", "1"));//true (digit and comes once)  
		System.out.println(Pattern.matches("\\d", "4443"));//false (digit but comes more than once)  
		System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char)  
		System.out.println("metacharacters D...."); //D means non-digit  
		System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)  
		System.out.println(Pattern.matches("\\D", "1"));//false (digit)  
		System.out.println(Pattern.matches("\\D", "4443"));//false (digit)  
		System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)  
		System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once)  
		System.out.println("metacharacters D with quantifier....");  
		System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)  
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true  
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)  
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true  
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched)  
		//starts with 7, 8 or 9 then remaining 9 chars are b/w 0 to 9
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true  
		System.out.println(Pattern.matches("[789][0-9]{9}", "9953038949"));//true  
		System.out.println(Pattern.matches("[789][0-9]{9}", "99530389490"));//false (11 characters)  
		System.out.println(Pattern.matches("[789][0-9]{9}", "6953038949"));//false (starts from 6)  
		System.out.println(Pattern.matches("[789][0-9]{9}", "8853038949"));//true  
		System.out.println("by metacharacters ...");  
		System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true  
		System.out.println(Pattern.matches("[789]{1}\\d{9}", "3853038949"));//false (starts from 3)  
		System.out.println(s.replaceAll("\\D", "")); //remove all non digits
		System.out.println(s.replaceAll("\\d", "")); //remove all digits
		System.out.println(s.replaceAll("[^a-zA-Z]+", "")); //remove all non digits (including special chars)
		System.out.println(s.replaceAll("[^a-zA-Z0-9]+", "")); //remove all non-alphanumeric (including special chars)
	}
	//string (sum up all numbers in a string eg - 1003jfufii2ks24sg2 => 1003+2+24+2
	int sumFromString(String s)
	{
		int sum = 0;
		s = s.replaceAll("[a-zA-Z]", " "); //replace all chars with space
		s = s.replaceAll("\\s{1,}", " ").trim();  //replace >1 space with single space
		String arr[] = s.split(" ");
		for(int i = 0; i<arr.length; i++)
		{
		    sum = sum+Integer.parseInt(arr[i]);
		}
		return sum;
	}
	
	
	//pangram check (a string which contains all a-z alphabets)
	public static boolean checkPangram  (String s)
   	 {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z]", ""); //remove all non-alphabets from string
        int freq[] = new int[26];
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == ' ')
            {
                continue;
            }
            freq[ch-97]++;
        }
        for(int i = 0; i<freq.length; i++)
        {
            if(freq[i]<1)
            {
                return false;
            }
        }
        return true;
   	 }
	//O(n^2) for longest substring with distinct chars
	int longestDistinct(String str)
    {
        int result = 0;
        for(int i = 0; i<str.length(); i++)
        {
            boolean visited[] = new boolean[256];
            for(int j = i; j<str.length(); j++)
            {
                if(visited[str.charAt(j)] == true)
                {
                    break;
                }
                else 
                {
	                visited[str.charAt(j)] = true;
	                result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }
	//remove common chars from two strings and concat
	String removeCommonChars(String s1,String s2){
        
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i<s1.length(); i++)
        {
            set.add(s1.charAt(i));
        }
        for(int i = 0; i<s2.length(); i++)
        {
            if(set.contains(s2.charAt(i)))
            {
                char ch = s2.charAt(i);
                s1 = s1.replace(ch, '\0'); 
                s2 = s2.replace(ch, '\0');
            }
        }
        return s1+s2;
    }
}
	public static void main(String args[])
	{
		Flat f = new Flat();
	}
}