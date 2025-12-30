package Coding;

import java.util.ArrayList;
import java.util.List;

public class RecurssionsQuestions {

    public static void main(String[] args) {

//// Print numbers from 1 to n times:
//        int n=5;
//        printNumbers(1,n);

//// Print numbers 1 to n times using backtracking:
//        int n=5;
//        printNumbersusingbacktracking(n,n);

/* Subsequence:

//// Print all Subsequences:

        int[] arr={1,2,3};
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> ds =new ArrayList<>();
        int n=arr.length;
        subsequence(0,arr,ds,result);

        subsequence(int index, int[] nums,
        List<Integer> ds,
        List<List<Integer>> result) {

            if (index == nums.length) {
                result.add(new ArrayList<>(ds));
                return;
            }

            ds.add(nums[index]);
            subsequence(index + 1, nums, ds, result);

            ds.remove(ds.size() - 1);
            subsequence(index + 1, nums, ds, result);
        }

//// Print all subsequence sum = K:

        int[] arr={1,2,1,3,1};
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> ds =new ArrayList<>();
        int sum=0;
        int k=3;
        subsequencewhosesumisk(0, arr, ds, result, sum, k);

        void subsequencewhosesumisk(int index, int[] arr, List<Integer> ds,
                                    List<List<Integer>> result, int sum, int k) {

        if(index==arr.length){
            if(sum==k){
                result.add(new ArrayList<>(ds));
            }
            return ;
        }

        ds.add(arr[index]);
        sum+=arr[index];
        subsequencewhosesumisk(index+1,arr,ds, result, sum,k);

        ds.remove(ds.size()-1);
        sum-=arr[index];
        subsequencewhosesumisk(index+1,arr,ds, result, sum,k);
    }

////Count subsequences with sum = K:

        countSubseq(int[] arr, int index, int sum, int k) {
        if (index == arr.length) {
                if(sum==k) return 1;
                return 0;
            }

        int pick    = countSubseq(arr, index + 1, sum + arr[index], k);
        int notPick = countSubseq(arr, index + 1, sum, k);

        return pick + notPick;
}

 */

/* Theory:

    In the **subsequence (pick / not-pick) pattern**, we **must return when `index == arr.length`** because of how the recursion is structured. In this pattern,
    a subset (or subsequence) is considered **complete only when we have made a decision (pick or not pick) for every index**. Until we reach `index == n`, the algorithm
    does not know whether the current selection is final or not. For example, with `{1,2,3}`, the path that forms `[1]` is *not complete* when we are at index `1`,
    because we still have to decide whether to pick or skip `2` and `3`. Only when we reach `index == 3` do we know that the subset is finalized—this specific path
    results in `[1]`, `[1,2]`, or `[1,2,3]` depending on earlier choices. Therefore, the base condition `if (index == arr.length)` is required, and we return after
    adding the subset to prevent the recursion from going beyond the array bounds.

   In contrast, in the **forward recursion (subset/combination) pattern**, every recursion state already represents a **complete and valid subset**. When we form `[1]`,
   that subset is already final and valid, and it may further grow into `[1,2]` and then `[1,2,3]`. That is why we add the subset immediately and **do not return**—because
   the loop itself controls further exploration. So the key difference is this: **subsequence recursion returns at `index == n` because completion is defined by reaching the
   end of the array**, whereas **forward recursion does not return early because completion is defined by the current state itself**.

   Subsequence recursion is **index-based**, meaning it makes pick/not-pick decisions for every position and considers a subset complete only when `index == n`.
   This works perfectly when all elements are **unique**, because each index path maps to a unique subset. However, when **duplicate values** exist
   (for example `{1,2,2,3}`), index-based recursion treats identical values at different indices as different choices and therefore generates **duplicate subsets**,
   with no clean way to skip them. Subset problems, on the other hand, are **value-based** and require **unique combinations**, which is why they are solved using
   **forward recursion with a loop**. Forward recursion treats every recursion state as a complete subset (like `[1]`, `[1,2]`, `[1,2,3]`), allows growth into larger
   subsets, and—most importantly—enables **duplicate skipping at the same recursion level** using sorting and checks like `i > start`. That is why, although subsequence
   recursion can generate subsets for unique inputs, subset problems in practice and interviews are solved using forward recursion to correctly handle duplicates and
   ensure uniqueness.

   In the **subsequence (index-based pick/not-pick) approach**, for every element we always make **two decisions**—pick or not pick—so the recursion tree has **2ⁿ paths**.
   This means that even if the problem only asks for combinations of a fixed size or a fixed sum, the algorithm **still traverses the entire array in every path** and
   explores all possibilities. For example, when `n = 10` and we want only combinations of size `k = 3`, the subsequence approach explores **2¹⁰ = 1024 paths**, but only
   **120** of those paths (`C(10,3)`) are actually valid answers; the remaining **904 paths are useless work** that get explored and then discarded.

   In contrast, the **subset / combination (value-based, start-index) approach** builds solutions by **choosing only valid next elements** using a loop and a start index.
   There is **no explicit “not pick” branch**—skipping happens implicitly by moving the loop forward. Recursion happens **only after a pick**, and it naturally stops when
   no more choices are possible. Using the same example (`n = 10, k = 3`), this approach explores **only the ~120 valid combinations**, and every recursive path
   corresponds to a meaningful partial or complete answer. As a result, the subset approach avoids unnecessary traversal and does **almost no wasted work**, which is why
   it is considered more optimal and is preferred in interviews.

   The subset (for-loop) backtracking approach does not truly generate subsequences because it never makes an explicit pick or skip decision at each index. It only decides which element to pick next, with skipping happening implicitly, whereas subsequence generation requires an independent binary decision for every index to ensure all index-based paths are explored. Therefore, while the subset approach may produce the same collection of element groups, only the pick / not-pick recursion correctly models and guarantees generation of all subsequences.

 */

/*
    Subsets: A subset is any selection of elements taken from a set, without caring about order, and it represents a unique collection of elements.

    Array =     [1, 2, 2, 4]
    Subsequence: [], [1], [2], [2], [4], [1,2], [1,2], [1,4], [2,2], [2,4], [2,4], [1,2,2], [1,2,4], [1,2,4], [2,2,4], [1,2,2,4]
    Subsets:     {}, {1}, {2}, {4}, {1,2}, {1,4}, {2,2}, {2,4}, {1,2,2}, {1,2,4}, {2,2,4}, {1,2,2,4}

    All subsets are subsequences, but NOT all subsequences are subsets.Subsequence is an ordered version of a subset.
    Every subset can be represented as a subsequence, but not every subsequence represents a unique subset.

    A subset is an unordered selection of elements, while a subsequence is an ordered selection that preserves the original
    array order. Every subset can be represented as at least one subsequence by choosing elements in increasing index order.
    However, when the array contains duplicate elements, multiple subsequences may correspond to the same subset, which is why
    not all subsequences represent unique subsets.

////Print all Subsets:

    // Print all Subsequence code will also work to print all subsets but when the array contain unique character. But if not then, we have to make result set type
    // which will store unique elements. or else choose below method.

    int[] nums = {1, 2, 3};
    Arrays.sort(nums); // in case of duplicate elements
    List<List<Integer>> result = new ArrayList<>();
    generateSubsetsWithDup(nums, 0, new ArrayList<>(), result);

    static void generateSubsetsWithDup(int[] nums, int start,
                                   List<Integer> ds,
                                   List<List<Integer>> result) {

    result.add(new ArrayList<>(ds));

    for (int i = start; i < nums.length; i++) {

        // skip duplicate elements
        if (i > start && nums[i] == nums[i - 1]) continue;

        ds.add(nums[i]);
        generateSubsetsWithDup(nums, i + 1, ds, result);
        ds.remove(ds.size() - 1);
    }
}

//Steps:
        Choose the first element
        Go deeper and choose the next element
        Continue until no more choices
        Backtrack (remove last element)
        Choose the next possible element at the same level

        choose → recurse → backtrack → choose next

        “In subset also we choose first element, then choose another, and so on; then when we backtrack we remove the element and choose the next one.”


//// Subset Sum |: Given an array print all the sum of the subset generated from it, in the increasing order.

        static void subsetSumK(int[] nums, int start,
                       List<Integer> ds,
                       int currentSum, int K,
                       List<List<Integer>> result) {

        if (currentSum == K) {
            result.add(new ArrayList<>(ds));
            // do NOT return; (to allow other combinations)
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) continue;

            if (currentSum + nums[i] > K) break; // pruning (only if sorted)

            ds.add(nums[i]);
            subsetSumK(nums, i + 1, ds, currentSum + nums[i], K, result);
            ds.remove(ds.size() - 1);
        }
    }

//// Count Subsets with Sum = K:

        static int countSubsetSumK(int[] nums, int start, int currentSum, int K) {

            int count = (currentSum == K) ? 1 : 0;

            for (int i = start; i < nums.length; i++) {

                if (i > start && nums[i] == nums[i - 1]) continue;

                if (currentSum + nums[i] > K) break;

                count += countSubsetSumK(nums, i + 1,currentSum + nums[i], K);
        }
        return count;
}

//// Subsets of Size = K:

        static void subsetsSizeK(int[] nums, int start,List<Integer> ds, int K, List<List<Integer>> result) {

            if (ds.size() == K) {
                result.add(new ArrayList<>(ds));
                return;
            }

            for (int i = start; i < nums.length; i++) {

                if (i > start && nums[i] == nums[i - 1]) continue;

                ds.add(nums[i]);
                subsetsSizeK(nums, i + 1, ds, K, result);
                ds.remove(ds.size() - 1);
            }
        }

    When generating subsets using **forward recursion**, the decision to **return or not return** depends entirely on the **goal of the recursion**.
    In the problem of **generating all subsets**, every recursive state itself represents a valid subset, so we add the current subset and continue exploring further
    instead of returning. For example, with input `{1,2,3}`, the subset `[1]` is valid, but it can still grow into `[1,2]` and then `[1,2,3]`, so returning at
    `[1]` would incorrectly miss valid subsets. That is why in the subset-generation code we simply do `result.add(ds)` and keep recursing. In contrast,
    for **constrained problems** like *subsets of size = K* or *subset sum = K*, once a constraint is met or violated, going deeper cannot produce valid results.
    For instance, if K = 2, the subset `[1,2]` is valid, but extending it to `[1,2,3]` breaks the size constraint, so we add `[1,2]` and immediately return.
    Similarly, in subset sum problems, once the sum equals K or exceeds K, deeper recursion is useless, so we return to prune that branch. In **counting problems**,
    returning is also necessary because the function must propagate a numeric result upward. In short, with examples like `[1] → [1,2] → [1,2,3]`, we do **not return**
    in plain subset generation because subsets can always grow into other valid subsets, but we **do return** in size- or sum-constrained problems because further
    growth can no longer produce valid answers.

 */

/* Combinations:

    Combinations are selected subsets of elements that satisfy specific constraints (such as sum = K, size = K, etc.).
    Combination problems are subset problems with additional constraints such as sum, size, or repetition rules.

////Combination: Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

        List<List<Integer>> result = new ArrayList<>();
        int n=4;
        int k=2;
        backtrack(1, n, k, new ArrayList<>(), result);

        void backtrack(int index, int n, int k, ArrayList<Integer> ds, List<List<Integer>> result) {

            if(ds.size()==k){
                result.add(new ArrayList<>(ds));
                return;
            }

            for(int i=index;i<=n;i++){
                ds.add(i);
                backtrack(i+1,n,k,ds,result);
                ds.remove(ds.size()-1);
            }
        }

//// Combination Sum:

    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
    The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] candidates, int target,
                           List<Integer> ds,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {

            ds.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i], ds, result);
            ds.remove(ds.size() - 1);
        }
    }

////Combination Sum II:

    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
    Note: The solution set must not contain duplicate combinations.

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); ///////////////////////////////////////// MUST sort
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, int target,
                           List<Integer> ds,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            ds.add(nums[i]);
            backtrack(i + 1, nums, target - nums[i], ds, result);
            ds.remove(ds.size() - 1);
        }
    }

    // Break is used with sorted elements only: suppose input is not sorted and arr={10,1,2,3} and target is 6. then we will never be able to explore 1 2 3.
    // Why break is unsafe without sorting:
    // break means: “Stop checking all remaining elements in this loop.”
    // That is only correct if you are 100% sure that: all next elements >= current element
    // That is only true for a sorted array.

    // Important:
    // Use break when the LOOP cannot produce valid answers anymore. So in loop there is no option for further exploration
    // Use return when the CURRENT RECURSION STATE is invalid. but in these we have option for further explroation after removing the current element when return happens

    //“I use return to prune an invalid recursion state and let backtracking explore other choices."
    //"I use break when the remaining loop values cannot produce valid results due to sorted order.”

//// Combination sum III:

    “Add element → enter recursion → validate state → explore OR exit”

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start,
                           int k,
                           int remainingSum,
                           List<Integer> ds,
                           List<List<Integer>> result) {

        // valid combination
        if (ds.size() == k && remainingSum == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        // invalid state → prune recursion
        if (ds.size() > k || remainingSum < 0) return;

        // combination (subset-style) loop
        for (int i = start; i <= 9; i++) {
            ds.add(i);
            backtrack(i + 1, k, remainingSum - i, ds, result);
            ds.remove(ds.size() - 1); // backtrack
        }
    }

//// Letter Combinations of a Phone Number:

    class Solution {

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index,
                           String digits,
                           StringBuilder path,
                           List<String> result) {

        // base case
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(index + 1, digits, path, result);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}

    In the **Letter Combinations of a Phone Number** problem, the input string (like `"23"`) is processed by **dividing it level by level using an index**, not by choosing or skipping digits. Each recursion level fixes **one digit** (first `2`, then `3`) and expands the current partial string by appending **all letters mapped to that digit**. The recursive call moves to the next index, effectively passing the **remaining input** to the next level. In this way, combinations are built as a **Cartesian product** of the letter sets for each digit, where every position must contribute exactly one character. This is neither a subset nor a permutation problem; it is a **level-wise combination construction**, where recursion depth equals the number of digits and all valid combinations are formed by systematically combining choices from each digit in order.

*/

/* Permutations:

////Print all permutations:

    class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);               // 1️⃣ sort
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums,
                           boolean[] used,
                           List<Integer> ds,
                           List<List<Integer>> result) {

        // base case
        if (ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            // 🔥 skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            ds.add(nums[i]);

            backtrack(nums, used, ds, result);

            ds.remove(ds.size() - 1);
            used[i] = false;
        }
    }
}
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
        “If this number is the same as the previous one,and the previous one hasn’t been used yet, then using this one now would create a duplicate permutation.”
        “Among equal numbers, don’t pick the later one unless the earlier one is already used.”

    class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> result) {

        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            result.add(perm);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(index + 1, nums, result);
            swap(nums, index, i); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}






*/


    }}




//    private static void printNumbersusingbacktracking(int i, int n) {
//        if(i<1){
//            return;
//        }
//        printNumbersusingbacktracking(i-1,n);
//        System.out.println(i);
//
//    }
//
//    private static void printNumbers(int i, int n) {
//        if(i>n){
//            return;
//        }
//        System.out.println(i);
//        printNumbers(i+1,n);
//    }


