import java.util.*;

public class Hashing
{
	boolean pairWithGivenSum(int arr[], int sum)
	{
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i<arr.length; i++)
		{
			if(set.contains(sum-arr[i]))
			{
				return true;
			}
			set.add(arr[i]);
		}
		return false;
	}
	boolean subarrayWithZeroSum(int arr[])
	{
		//using prefix sum and hashset
		HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		for(int i = 0; i<arr.length; i++)
		{
			sum = sum+arr[i];
			if(sum == 0)
			{
				return true;
			}
			if(set.contains(sum))
			{
				return true;
			}
			set.add(sum);
		}
		return false;
	}
	boolean subarrayWithGivenSum(int arr[], int sum)
	{
		int prefix_sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<arr.length; i++)
		{
			prefix_sum = prefix_sum + arr[i];
			if(prefix_sum == sum)
			{
				return true;
			}
			if(set.contains(prefix_sum-sum))
			{
				return true;
			}
			set.add(prefix_sum);
		}
		return false;
	}
	//returns the length of the longest subarray summing to sum
	int longestSubarrayWithGivenSum(int arr[], int sum)
	{
		int result = 0;
		int prefix_sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length; i++)
		{
			prefix_sum = prefix_sum+arr[i];
			if(prefix_sum == sum)
			{
				result = i+1;
			}
			if(!map.containsKey(prefix_sum)) //do not add if already present in the list (since we need the longest subarray)
			{
				map.put(prefix_sum, i);
			}
			if(map.containsKey(prefix_sum-sum))
			{
				result = Math.max(result, i-map.get(prefix_sum-sum));
			}
		}
		return result;
	}
	//check if two arrays are equal.
	boolean check(long arr[],long brr[])
	{
	    if(arr.length!=brr.length)
	    {
	        return false;
	    }
	    HashSet<Long> seta = new HashSet<Long>();
	    HashSet<Long> setb = new HashSet<Long>();
	    for(long num:arr)
	    {
	        seta.add(num);
	    }
	    for(long num:brr)
	    {
	        setb.add(num);
	    }
	    return seta.equals(setb);
	}
	int NumberofElementsInIntersection (int a[], int b[])
	{
	    int count = 0;
	    HashSet<Integer> set = new HashSet<>();
	    for(int num:a)
	    {
	        set.add(num);
	    }
	    HashSet<Integer> checkCounted = new HashSet<>(); //to keep note of already checked elements
	    for(int num:b)
	    {
	        if(set.contains(num) && !checkCounted.contains(num))
	        {
	            count++;
	        }
	        checkCounted.add(num);
	    }
	    return count;
	}
	//longest consecutive subsequence eg -> {1, 4, 2, 5, 3, 9, 8, 11}, op - 12345 (length: 5)
	int findLongestConseqSubseq(int arr[])
	{
	  int count = 0;
        int result = 0;
       Arrays.sort(arr);
       HashSet<Integer> set = new HashSet<Integer>();
       for(int num:arr)
       {
           if(set.contains(num))
           {
               continue; //move on to the next number to avoid duplicates
           }
           if(set.contains(num-1))
           {
               count++;
           }
           else
           {
               count = 0;
           }
           set.add(num);
           result = Math.max(result, count);
       }
       return result+1;
	}
	//longest subarray with equal number of 0s and 1s
	//change 0s and 1s and find longest subarray with 0 sum
	int longestSubarrayWithEqual01(int arr[])
	{
		for(int i = 0; i<arr.length; i++)
		{
			if(arr[i] == 0)
			{
				arr[i] = -1;
			}
		}
		return longestSubarrayWithGivenSum(arr, 0);
	}
	void distinctElementsInEachWindow()
	{
		int arr[] = {1, 1, 1, 2, 5, 6};
        int k = 2;
        for(int i = 0;  i<arr.length-k+1; i++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int j = i; j<i+k; j++)
            {
                if(map.containsKey(arr[j]))
                {
                    map.put(arr[j], map.get(arr[j])+1);
                }
                else
                {
                    map.put(arr[j], 1);
                    count++;
                }
            }
            System.out.println("Distinct elements in current window "+ count);
            System.out.println(map);
        }
	}
	void findPairsOfPositiveNegativeElements(int arr[], int n)
    {
        ArrayList<Integer> list = new ArrayList();
        HashSet<Integer> set = new HashSet<>();
    	for(int num:arr)
    	{
    		//check if the set contains invert of the current element
    	    if(set.contains((num*-1)))
    	    {
    	    	//negative element should come first
    	        if(num<0)
    	        {
        	        list.add(num);
        	        list.add(num*-1);
    	        }
    	        else
    	        {
    	            list.add(num*-1);
    	            list.add(num);
    	        }
    	    }
    	    set.add(num);
    	}
    	System.out.println(list);
    }
	//remove adjacent dups aaaebbbfcccdg -> efg or use hashset
	void removeAdjacentDuplicates(String s)
	{
        String res = "";
        res+=s.charAt(0);
        for(int i = 1; i<s.length()-1; i++)
        {
            char ch = s.charAt(i);
            if(ch!=s.charAt(i+1) && ch!=s.charAt(i-1))
            {
                res+=ch;
            }
        }
        //handling the last char
        if(s.charAt(s.length()-2)!=s.charAt(s.length()-1))
        {
            res+=s.charAt(s.length()-1);
        }
        System.out.println(res);
    }

	//string (sum up all numbers in a string eg - 1003jfufii2ks24sg2 => 1003+2+24+2
	int sumFromString(String s)
	{
        int sum = 0;
        s = s.replaceAll("[a-zA-Z]", " "); //replace all chars with space
        s = s.replaceAll("\\s{1,}", " ").trim();  //replace >1 space with single space
        //.trim() to remove extra space eg -> hello4me ->  4
        String arr[] = s.split(" ");
        for(int i = 0; i<arr.length; i++)
        {
            sum = sum+Integer.parseInt(arr[i]);
        }
        return sum;
	}
	void relativeSorting()
	{
		//sort arr1 according to arr2;
		int A1[] = {2,1,2,5,7,1,9,3,6,8,8};
	    int A2[] = {99,22,444,56};
	    ArrayList<Integer> arr = new ArrayList();
	   TreeMap<Integer, Integer> map = new TreeMap<>(); //treemap stores keys in sorted manner
	   for(int num: A1)
	   {
	       if(map.containsKey(num))
	       {
	           map.put(num, map.get(num)+1);
	       }
	       else
	       {
	           map.put(num, 1);
	       }
	   }
	   for(int num: A2)
	   {
	       if(map.containsKey(num))
	       {
	           for(int i = 0; i<map.get(num); i++)
	            {
	                arr.add(num);
	            }
	            map.remove(num);
	       }
	    }
	    for(Map.Entry<Integer, Integer> itr : map.entrySet())
		{
		    for(int i = 0; i<itr.getValue(); i++)
			arr.add(itr.getKey());
		}
		for(int i = 0; i<arr.size(); i++)
		{
		    System.out.print(arr.get(i) + " ");
		}
	}
	void sortByFrequeuncy(int arr[])
	{
	        ArrayList<Integer> arrList = new ArrayList();
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int num:arr)
	        {
	            if(map.containsKey(num))
	            {
	                map.put(num, map.get(num)+1);
	            }
	            else
	            {
	                map.put(num, 1);
	            }
	        }
	    LinkedHashMap<Integer, Integer> sortedByValueDesc = new LinkedHashMap<>();
	     map.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	    .forEachOrdered(x -> sortedByValueDesc.put(x.getKey(), x.getValue()));

	    for(Map.Entry<Integer, Integer> itr : sortedByValueDesc.entrySet())
			{
			    for(int i = 0; i<itr.getValue(); i++)
			    {
			        arrList.add(itr.getKey());
			    }
			}
			 System.out.println(arrList);

	    }
	public static void main(String args[])
	{

	   }
}
