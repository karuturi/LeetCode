
/**
 * https://leetcode.com/problems/letter-case-permutation/
 */

import java.util.List;
import java.util.ArrayList;

public class Solution784 {

    public static void main(String[] args) {
        System.out.println(new Solution784().letterCasePermutation("3sdc"));
    }

    public List<String> letterCasePermutation(String s) {
        return letterCasePermutation(s, 0);
    }

    public List<String> letterCasePermutation(String s, int start) {
        List<String> permutations = new ArrayList<>();
        if (start >= s.length()) {
            permutations.add("");
            return permutations;
        }

        char c = s.charAt(start);
        List<String> permutationsWithoutc = letterCasePermutation(s, start + 1);
        for (String permutation : permutationsWithoutc) {
            permutations.add(c + permutation);
            if (c >= 'a' && c <= 'z') {
                char capitalC = (char) (c - 'a' + 'A');
                permutations.add(capitalC + permutation);
            } else if (c >= 'A' && c <= 'Z') {
                char smallC = (char) (c + 'a' - 'A');
                permutations.add(smallC + permutation);
            }
        }

        return permutations;
    }
}