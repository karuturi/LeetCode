/**
 * https://leetcode.com/problems/combinations/
 */

import java.util.List;
import java.util.LinkedList;

public class Solution77 {
    public static void main(String[] args) {
        System.out.println(new Solution77().combine(3, 0));
    }

    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new LinkedList<>();

		if(n == 0 ) {
			combinations.add(new LinkedList<Integer>());
			return combinations;
		}

		List<List<Integer>> combinationsWithoutN = combine(n-1, k);
		for(List<Integer> combinationWithoutN: combinationsWithoutN ) {
            LinkedList<Integer> combinationWithN = new LinkedList<>(combinationWithoutN);
            combinationWithN.add(n);
			combinations.add(combinationWithN);
		}
		combinations.addAll(combinationsWithoutN);
		return combinations;
		
	}


}
