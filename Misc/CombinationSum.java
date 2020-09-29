import java.util.*;
class Playground {
    public static void main(String[ ] args) 
    {
        Playground p = new Playground();
        int arr[] = {1, 2, 3};
        int target = 7;
        System.out.println(p.subsets(arr, target));
    }
    public List<List<Integer>> subsets(int nums[], int target)
    {
        List<List<Integer>> subset = new ArrayList<>();
        dfs(subset, 0, nums, new ArrayList(), target);
        return subset;
    }
    public void dfs(List<List<Integer>> subset, int index, int nums[], List<Integer>current, int target)
    {
        if(target<0)
        {
            return;
        }
        else if(target == 0)
        {
            subset.add(new ArrayList(current));
            return;
        }
        else 
        {
            for(int i = index; i<nums.length; i++)
            {
                current.add(nums[i]);
                dfs(subset, i, nums, current, target-nums[i]);
                current.remove(current.size()-1);
            }
        }
    }
}