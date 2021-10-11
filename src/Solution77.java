/**
 * https://leetcode.com/problems/combinations/
 */

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Solution77 {
    public static void main(String[] args) {
        // System.out.println(new Solution77().combine(20, 16));
        System.out.println(new Solution77().combine(3, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

		int[] combination = new int[k];
		for (int i = 0; i < k; i++) {
			combination[i] = i;
		}

		while (combination[k - 1] < n) {
			List<Integer> comblist = new ArrayList<Integer>();
			for(int i=0; i<combination.length; i++) {
				comblist.add(combination[i]+1);
			}
			combinations.add(comblist);
			int t = k - 1;
			while (t != 0 && combination[t] == n - k + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < k; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		return combinations;        
    }

    // public List<List<Integer>> combine(int n, int k) {
    //     List<List<Integer>> allcombinations = combineLesstThanK(n, k);
        
    //     allcombinations.removeIf(combination -> combination.size() != k);
    //     return allcombinations;
    // }

    public List<List<Integer>> combineLesstThanK(int n, int k) {
		List<List<Integer>> combinations = new LinkedList<>();

		if(n == 0 || k==0 ) {
			combinations.add(new LinkedList<Integer>());
			return combinations;
		}

		List<List<Integer>> combinationsWithoutN = combineLesstThanK(n-1, k);
		for(List<Integer> combinationWithoutN: combinationsWithoutN ) {
            int size = combinationWithoutN.size();
            if(size < k ) {
                LinkedList<Integer> combinationWithN = new LinkedList<>(combinationWithoutN);
                combinationWithN.add(n);
                combinations.add(combinationWithN);
                combinations.add(combinationWithoutN);
            } else if (size == k) {
                combinations.add(combinationWithoutN);
            }
		}
		return combinations;
		
	}


}
