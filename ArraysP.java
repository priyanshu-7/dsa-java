import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ArraysP
{
	//for every element print the ceiling on its left
	void printCeil(int[] arr)
	{
	TreeSet<Integer> set = new TreeSet<>();
        for(int num:arr)
        {
            if(set.ceiling(num)!=null)
            {
                System.out.println(set.ceiling(num));
            }
            else 
            {
                System.out.println(-1);
            }
            set.add(num);
        }
	}
	//Left rotate by d elements.
	void leftRotate(int[] arr, int n, int d)
	{
		reverse(arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
	}
	void reverse(int [] arr, int start, int stop)
	{
		while(start<stop)
		{
			int temp = arr[start];
			arr[start] = arr[stop];
			arr[stop] = temp;
			start++;
			stop--;
		}
	}
	void maximumDifference(int arr[])
	{
		int max = 0;
		for(int i = 0; i<arr.length; i++)
		{
			int current = arr[i];
			for(int j = 0; j<arr.length; j++)
			{
				if(arr[j]-current>max && j>i && arr[j]!=current)
				{
					max = arr[j]-current;
				}
			}
		}
		System.out.println("Max diff " + max);
	}
	//Majority element is an element that appears more than n/2 times in an array of size n
	void majorityElement(int arr[])
	{
		int n = arr.length;
		int appearsTime = n/2;
		for(int i = 0; i<n; i++)
		{
			int count = 0;
			for(int j = 0; j<n; j++)
			{
				if(arr[i] == arr[j])
				{
					count++;
				}
			}
			if(count == appearsTime)
			{
				System.out.println(arr[i]);
				break;
			}
		}
	}
	int stockBuyAndSell(int prices[])
	{
		int profit = 0;
		for(int i = 1; i<prices.length; i++)
		{
			if(prices[i]>prices[i-1])
			{
				profit+=prices[i]-prices[i-1];
			}
		}
		return profit;
	}
	void trappingRainWater(int arr[])
	{
		//the first and the last bar should not be smaller of each other otherwise water will overflow
		int threshold = arr[0];
		int sum = 0;
		for(int i = 1; i<arr.length;i++)
		{
			int diff = threshold-arr[i];
			if(diff>0)
			{
				sum += diff;
			}

		}
		System.out.println(sum);
	}

	void current_leader(int[] arr)
	{
		//Current leader (elements on the right are always greater), last element is always leader
		int curr_leader = arr[arr.length-1];
		System.out.println(curr_leader);
		for(int i = arr.length-2; i>=0; i--)
		{
			if(arr[i]>curr_leader)
			{
				curr_leader = arr[i];
				System.out.println(curr_leader);
			}
		}
	}

	int maxConsecutiveOnes(int[] arr)
	{
		int max = 0;
		{
			for(int i = 0; i<arr.length; i++)
			{
				int count = 0;
				for(int j = i; j<arr.length; j++)
				{
					if(arr[j] == 1)
					{
						count++;
					}
					else
					{
						break;
					}
					max = Math.max(count, max);
				}
			}
		}
		return max;
	}

	int kadaneAlgo(int[] arr) //maximum sum subarry (contiguous)
	{
		int res = arr[0];
		int maxSum = arr[0];
		for(int i = 0; i<arr.length; i++)
		{
			maxSum = Math.max(arr[i]+maxSum, arr[i]);
			res = Math.max(res, maxSum);
		}
		return res;
	}
	//to tackle subarray kind of problems in a naive manner.
	int maxEvenOdd(int[] arr) //count maximum alternating even, odd elements in a subarray (naive)
	{
		int max = 0;
		for(int i = 0; i<arr.length; i++)
		{
				int current = 1; //1st element always counted
				for(int j = i+1; j<arr.length; j++)
				{
					if((arr[j]%2 == 0 && arr[j-1]%2!=0) || (arr[j]%2!=0 && arr[j-1]%2 == 0))
					{
						current+=1;
					}
					else
					{
						break;
					}
					max = Math.max(current, max);
				}
		}
		return max;
	}
	//Given a sorted array of 0s and 1st, count total occurrences of 1 in O(log N), can be done with bsearch
	int countOnes(int arr[])
	{
		int start = arr[0];
		int stop = arr.length-1;
		while(start<=stop)
		{
			int mid = (start+stop)/2;
			if(mid == 0)
			{
				start = mid+1;
			}
			else if(mid == 0 || arr[mid-1]!=arr[mid])
			{
				return arr.length-mid; //return total count of 1 (length of array - index of first occurrence of 1)
			}
			else
			{
				stop = mid-1;
			}
		}
		return 0;
	}
	//find peak element using Binary search
	int findPeakElement(int arr[])
	{
		int start = 0;
		int end = arr.length-1;
		while(start<=end)
		{
			int mid = (start+end)/2;
			//if there is only 1 element in array or if mid element is greater than right and left element
			if(mid == 0 || arr[mid]>arr[mid-1] && mid == arr.length-1 || arr[mid]>arr[mid+1])
			{
				return mid;
			}
			//if left element is greater than the current middle element, then there must be a peak in the left part of array
			if(mid>0 && arr[mid-1]>=arr[mid])
			{
				end = mid-1;
			}
			//check in the right part of the array
			else
			{
				start = mid+1;
			}
		}
		return -1; //no peak
	}
	boolean findPairSum(int arr[], int start, int end, int x) //two pointer technique
	{
		while(start!=end)
		{
			if(arr[start]+arr[end] == x)
			{
				return true;
			}
			else if(x>arr[start]+arr[end])
			{
				start++;
			}
			else if(arr[start]+arr[end]<x)
			{
				end++;
			}
		}
		return false;
	}
	//common elements in 2 arrays
	void intersection(int arr1[], int arr2[])
	{
		HashSet<Integer> set = new HashSet<>();
        for(int num: arr1)
        {
        	if(!set.contains(num))
        	{
        		set.add(num);
        	}
        }
        for(int num: arr2)
        {
        	if(set.contains(num))
        	{
        		System.out.println(num);
        	}
        }
	}
	void union(int arr1[], int arr2[])
	{
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for(int num: arr1)
		{
			set.add(num);
		}
		for(int num: arr2)
		{
			set.add(num);
		}
		System.out.println(set);

	}

	//o(m+n) solution
	int[] mergeSortedArrays(int arr1[], int arr2[])
	{
		int m = arr1.length;
		int n = arr2.length;
		int arr3[] = new int[m+n];
		int i = 0, j = 0, k = 0;
		while(i<m && j<n) //while index ptr i is less than size(arr1) and ptr j less than size(arr2)
		{
			if(arr1[i] < arr2[j]) //if arr1<arr2, insert arr1 element to arr3
			{
				arr3[k] = arr1[i];
				i++; //increment ptr of arr1
				k++;
			}
			else //else if arr2<arr1, insert arr2 element to arr3
			{
				arr3[k] = arr2[j];
				j++; //increment ptr of arr2
				k++;
			}
		}
		//to insert remaining elements.
		while(i<m) //if arr2 is exhausted of elements, insert remaining elements of arr1
		{
			arr3[k++] = arr1[i++];
		}
		while(j<n) //if arr1 is exhausted of elements, insert remaining elements of arr2
		{
			arr3[k++] = arr2[j++];
		}
		return arr3;
	}
	//logic: x-arr[i] = sum (x-arr[i] = remaining pair sum), so if that pair is found then we have the triplet.
	boolean findTriplet(int arr[], int x)
	{
		for(int i = 0; i<arr.length-1; i++)
		{
			if(findPairSum(arr, i, arr.length-1, x-arr[i]) == true)
			{
				return true;
			}
		}
		return false;
	}
	boolean searchInSortedRotatedArray(int arr[], int x)
	{
		int start = 0;
		int end = arr.length-1;
		while(start<=end)
		{
			//normal bsearch
			int mid = (start+end)/2;
			if(mid == x)
			{
				return true;
			}
			//left half is sorted
			if(arr[start]<arr[mid])
			{

				//if x lies in the current range
				if(x>=arr[start] && x<arr[mid])
				{
					end = mid-1; //check in the left side of the array
				}
				else
				{
					start = mid+1; //else move to the right side of the array
				}
			}
			//right half is sorted
			if(arr[end]>arr[mid])
			{
				//if x lies in the right half
				if(x>arr[mid] && x<=arr[end])
				{
					start = mid+1;
				}
				else
				{
					end = mid-1;
				}
			}

		}
		return false;
	}
	boolean binarySearch(int arr[], int x)
	{
		Arrays.sort(arr);
		int start = 0;
		int stop = arr.length-1;
		while(start<=stop)
		{
			int mid = (start+stop)/2;
			if(arr[mid] == x)
			{
				System.out.println("Found at index: " + mid);
				return true;
			}
			else if(x>arr[mid])
			{
				start = mid+1;
			}
			else
			{
				stop = mid-1;
			}
		}
		return false;
	}
	/*best window sliding technique*/
	//Algo: get sum of first k elements, keep removing elements from start and keep adding k+1th elements
	int windowSlidingSum(int arr[], int k)
	{
		int currentSum = 0;
		int maxSum = 0;
		//sum of first window
		for(int i = 0; i<k; i++)
		{
			currentSum += arr[i];
		}
		//arr[i] is first element of new window
		//arr[i-k] is first element of last window
		for(int i = k; i<arr.length; i++)
		{
			currentSum += arr[i]-arr[i-k];
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
	void nbonacciSequence(int n, int m)
	{
		int series[] = new int[m];
		series[n-1] = 1;
		//add last M terms and add a new element to array
		for (int i = n; i < m; i++)
            for (int j = i - n; j < i; j++)
            	series[i] += series[j];
		for(int num:series)
		{
			System.out.println(num);
		}
	}

	//check if array contains a subarry with sum = x
	int subArraySum(int arr[], int n, int sum)
	{
		int curr_sum = arr[0], start = 0;

		// Pick a starting point
		for (int i = 1; i <= n; i++)
		{
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i-1)
			{
				curr_sum = curr_sum - arr[start];
				start++;
			}
			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum)
			{
				int p = i-1;
				System.out.println("Sum found between indexes " + start
						+ " and " + p);
				return 1;
			}
			// Add this element to curr_sum
			if (i < n)
			curr_sum = curr_sum + arr[i];
		}
		System.out.println("No subarray found");
		return 0;
	}
	int lomutoPartition(int arr[])
	{
		int l, h, pivot;
		l = 0;
		h = arr.length-1;
		pivot = arr[h];
		int i = l-1;
		for(int j = 0; j<h; j++)
		{
			if(arr[j]<pivot)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		return i+1; //index of partition
	}
	//kth smallest element using Lomuto partition
	int kthSmallest(int arr[], int k)
	{
		int l = 0, r = arr.length-1;
		while(l<=r)
		{
			int p = lomutoPartition(arr);
			if(p == k-1)
			{
				return p;
			}
			else if(p>k-1) //p is greater than k-1, go to left side
			{
				r = p-1;
			}
			else
			{
				l = p+1;
			}
		}
		return -1;
	}

	//print snake pattern in matrix
	void snakePattern()
	{
        int arr[][] = {
                        {1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9},
                       {10, 11, 12}
        };
        for(int i = 0; i<arr.length; i++) //access rows [use arr.length]
        {
            if(i == 0 || i%2==0) //for 0th and even rows
            {
                for(int j = 0; j<arr[i].length; j++) //access columns [use arr[i].length]
                {
                    System.out.print (arr[i][j] + " ");
                }
            }
            if(i%2!=0) //for odd rows
            {
                for(int j = arr[i].length-1; j>=0; j--)
                {
                    System.out.print (arr[i][j] + " ");
                }
            }
            System.out.println(); //new line
        }
	}
	//print only boundary elements in a matrix
	void boundaryElements()
	{
		  int m = 4;
	        int n = 4;
	        int arr[][] = { {1, 2, 3, 90},
	                        {4, 5, 6, 91},
	                        {7, 8, 9, 92},
	                        {71, 287, 18, 21}
	                        };
	        for(int j = 0; j<n; j++)
	        {
	            System.out.println(arr[0][j]);
	        }
	        for(int i = 1; i<m; i++)
	        {
	            System.out.println(arr[i][n-1]);
	        }
	        for(int j = n-2; j>=0; j--)
	        {
	            System.out.println(arr[m-1][j]);
	        }
	        for(int i = m-2; i>=1; i--)
	        {
	            System.out.println(arr[i][0]);
	        }
	}
	//transpose of a nxn matrix
	void transpose()
	{
		int m = 4;
        int n = 4;
        int arr[][] = { {1, 2, 3, 90},
                        {4, 5, 6, 91},
                        {7, 8, 9, 92},
                        {71, 287, 18, 21}
                        };
        for(int i = 0; i<m; i++)
        {
        	for(int j = i+1; j<n; j++)
        	{
        		int temp = arr[i][j];
        		arr[i][j] = arr[j][i];
        		temp = arr[j][i];
        	}
        }
        for(int i = 0; i<m; i++)
        {
        	for(int j = 0; j<n; j++)
        	{
        		System.out.print(arr[i][j] + " ");
        	}
        	System.out.println();
        }
	}
	//search in row and columnwise sorted array
	void searchSortedArray() {
        int arr[][] = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}};

        int k = 29;
        int rows = 4;
        int columns = 4;
        int i = 0;
        int j = columns-1;
        while(i<rows && j>=0)
        {
            if(arr[i][j] == k) //return index if element is found.
            {
                System.out.println("Found at " + i + "," + j);
                return;
            }
            else if(k>arr[i][j]) //go down if element is greater.
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        System.out.println("Not found");
    }
	int maxEvenOddON(int[] arr) //max EvenOdd subarray O(n) solution
	{
		int max = 0, curr = 1;
		for(int i = 1; i<arr.length; i++)
		{
			if((arr[i]%2==0 && arr[i-1]%2!=0) || (arr[i]%2!=0 && arr[i-1]%2==0))
			{
				curr++;
				max = Math.max(curr, max);
			}
			else
			{
				curr = 1;
			}
		}
		return max;
	}
	public static void main(String args[])
	{

	}
}
