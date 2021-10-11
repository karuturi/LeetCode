import java.util.List;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Solution46 {
    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, nums.length -1);
    }
    
    public List<List<Integer>> permute(int[] nums, int end) {
		List<List<Integer>> permutations = new LinkedList<>();
		if(end == 0 ) {
            int n = nums[end];
            List<Integer> permutation = new LinkedList<>();
            permutation.add(n);
			permutations.add(permutation);
			return permutations;
		}
		List<List<Integer>> permutationsWithoutN = permute(nums, end - 1);
		int n = nums[end];
		for(List<Integer> permutation: permutationsWithoutN ) {
			for(int i=0; i<= permutation.size(); i++) {
				LinkedList<Integer> permutationWithN = new LinkedList<Integer>(permutation);
				permutationWithN.add(i, n);
				permutations.add(permutationWithN);
			}
		}

		return permutations;
	}
}
