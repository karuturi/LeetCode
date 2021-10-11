/**
 * https://leetcode.com/problems/combinations/
 */

import java.util.List;
import java.util.LinkedList;

public class Solution77 {
    public static void main(String[] args) {
        System.out.println(new Solution77().combine(3, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allcombinations = combineLesstThanK(n, k);
        
        allcombinations.removeIf(combination -> combination.size() != k);
        return allcombinations;
    }

    public List<List<Integer>> combineLesstThanK(int n, int k) {
		List<List<Integer>> combinations = new LinkedList<>();

		if(n == 0 || k==0 ) {
			combinations.add(new LinkedList<Integer>());
			return combinations;
		}

		List<List<Integer>> combinationsWithoutN = combineLesstThanK(n-1, k);
		for(List<Integer> combinationWithoutN: combinationsWithoutN ) {
            if(combinationWithoutN.size() < k) {
                LinkedList<Integer> combinationWithN = new LinkedList<>(combinationWithoutN);
                combinationWithN.add(n);
                combinations.add(combinationWithN);
                combinations.add(combinationWithoutN);
            } else if (combinationWithoutN.size() == k) {
                combinations.add(combinationWithoutN);
            }
		}
		return combinations;
		
	}


}
