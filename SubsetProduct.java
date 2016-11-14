import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Christina on 3/2/16.
 */
public class SubsetProduct {
    //BFS
    public List<Integer> subsetProduct(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                ret.add(nums[i] * ret.get(j));
            }
            ret.add(nums[i]);
        }
        //remove the duplicated ones
        return new ArrayList<>(new HashSet<>(ret));
    }

    //DFS
    public List<Integer> subsetProduct1(int[] nums) {
        return dfs(nums, 0);
    }

    private List<Integer> dfs(int[] nums, int start) {
        if (start >= nums.length) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        List<Integer> next = dfs(nums, start + 1);
        for (int n : next) {
            ret.add(nums[start] * n);
        }
        ret.addAll(next);
        ret.add(nums[start]);
        return new ArrayList<>(new HashSet<>(ret));
    }
    
    public List<Integer> helper(int[] nums)
    {
    	List<Integer> list = new ArrayList<>();
    	helper(nums,list,0,nums[0]);
    	return new ArrayList<>(new HashSet<>(list));
    }
    
    private void helper(int[] nums, List<Integer> list, int index,int product)
    {
    	if(index<nums.length)    	list.add(product);

    	for(int i = index; i < nums.length;i++)
    	{
    		product = product* nums[i];
    		helper(nums,list,i+1,product);
    		product=product/nums[i];
    	}
    	
    }


    public static void main(String[] args) {
        SubsetProduct a = new SubsetProduct();
        System.out.println(a.subsetProduct(new int[]{2,3,4}));
        System.out.println(a.subsetProduct1(new int[]{1, 2, 3}));
        System.out.println(a.subsetProduct(new int[]{1, 2, 3, 5}));
        System.out.println(a.subsetProduct1(new int[]{1, 2, 3, 5}));
        System.out.println(a.helper(new int[]{2,3,4}));
    }
}
