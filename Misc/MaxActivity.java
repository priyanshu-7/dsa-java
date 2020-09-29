import java.util.*;
class Activity
{
    int start;
    int finish;
    Activity(int s, int f)
    {
        start = s;
        finish = f;
    }
}


class myComparator implements Comparator<Activity> //custom comparator
    {
        public int compare(Activity a1, Activity a2)
        {
            return a1.finish-a2.finish; //sort by finish time (ascending)
        }
    }

class MaxActivity
{
    public static void main(String[ ] args) 
    {
        MaxActivity p = new MaxActivity();
        Activity arr[] = {new Activity(12, 25), new Activity(10, 20), new Activity(20, 30)};
        System.out.println(p.maxActivity(arr));
    }
    int maxActivity(Activity arr[])
    {
        Arrays.sort(arr, new myComparator()); 
        int res = 1;
        int prev = 0;
        for(int curr = 1; curr<arr.length; curr++)
        {
            if(arr[curr].start>=arr[prev].finish)
            {
                res++;
                prev = curr;
            }
        }
        return res;
    }
}