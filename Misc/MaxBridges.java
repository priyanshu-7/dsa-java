/*
Max Bridges 
Problem Statement:

Given two sets, we have to build bridges using the b1, b2 points.
* However no two bridges should cross each other.
* Maximise number of bridges which can be built.
eg -> {(6, 2), (4, 3), (2, 6), (1, 5)}

1 2 3 4 5 6
(1 -- 5) and (2 -- 6)
1 2 3 4 5 6

Solution:
1) Sort the array in increasing order of first value of pair. If values are same then consider the second value.
2) Find LIS of sorted pair array according to second values (LIS because the values won't cross each other then). Also since first values are sorted, they won't cross each other as well
*/


import java.util.*;
class Pair 
{
    int bridge1;
    int bridge2;
    Pair(int b1, int b2)
    {
        bridge1 = b1;
        bridge2 = b2;
    }
}
class myComp implements Comparator<Pair>
{
   //Sort the pairs according to first value (if same then sort according to second value)
    public int compare(Pair p1, Pair p2)
    {
        if(p1.bridge1-p2.bridge1 == 0)
        {
            return p1.bridge2-p2.bridge2;
        }
        return p1.bridge1-p2.bridge1;
    }
}
class Playground 
{
    public static void main(String[ ] args) 
    {
        System.out.println(maxBridges());
    }
    static int maxBridges()
    {
        Pair pair[] = {new Pair(1, 5), new Pair(2, 6), new Pair(4, 3), new Pair(6, 2)};
        Arrays.sort(pair, new myComp());
        int temp[] = new int[pair.length];
        for(int i = 0; i<pair.length; i++)
        {
            temp[i] = pair[i].bridge2;
        }
        return LIS(temp);
    }
    //Find longest increasing subsequence using DP
    static int LIS(int arr[])
    {
        if(arr.length<1) return 0;
        int lis[] = new int[arr.length];
        lis[0] = 1;
        for(int i = 1; i<arr.length; i++)
        {
            lis[i] = 1;
            for(int j = 0; j<i; j++)
            {
                if(arr[j]<arr[i])
                {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        int res = lis[0];
        for(int i = 0; i<lis.length; i++)
        {
            res = Math.max(res, lis[i]);
        }
        return res;
    }
}