package Coding;

import java.util.HashSet;

public class P1TwoPointerQuestions {
    public static void main(String[] args) {

/*
////Find the union of the 2 sorted array and result should be sorted:

        public static int[] bruteForceUnionOfArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] temp = new int[n + m];
        int k = 0;

        for (int i = 0; i < n; i++) {
            boolean exists = false;

            for (int j = 0; j < k; j++) {
                if (temp[j] == arr1[i]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                temp[k++] = arr1[i];
            }
        }

        // Add elements from arr2
        for (int i = 0; i < m; i++) {
            boolean exists = false;

            for (int j = 0; j < k; j++) {
                if (temp[j] == arr2[i]) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                temp[k++] = arr2[i];
            }
        }

        Arrays.sort(temp, 0, k);
        return Arrays.copyOf(temp, k);
    }

    TC=(n2 + m(n+m))=(n+m)2

    public static ArrayList<Integer> unionUsingSet(int[] arr1, int[] arr2) {

    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < arr1.length; i++) {
        set.add(arr1[i]);
    }

    for (int i = 0; i < arr2.length; i++) {
        set.add(arr2[i]);
    }

    ArrayList<Integer> union = new ArrayList<>(set);
    Collections.sort(union);
    return union;
}

// TC: O(n + m + k log k)
// SC: O(n + m)

public static ArrayList<Integer> optimalUnionOfArrays(int[] arr1, int[] arr2) {

        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        else if (arr1[i] > arr2[j]) {
            if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        else {
            if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
            j++;
        }
    }

    while (i < arr1.length) {
        if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
            union.add(arr1[i]);
        }
        i++;
    }

    while (j < arr2.length) {
        if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
            union.add(arr2[j]);
        }
        j++;
    }

    return union;
}
    TC: (n+m)

////Longest Subarray with given Sum K(Positives)

        int[] a = {2,3,5,0,0,0,9,0};
        int k = 10;
        int i=0,j=0,sum=0,length=0;
        while (j<a.length){
            sum+=a[j];

            while (sum>k && i<j){
                sum-=a[i];
                i++;
            }
            if(sum==k){
                length=Math.max(length,j-i+1);
            }
            j++;
        }

////Longest Subarray with given Sum K(Positives+Negatives):

        int[] arr = {2, 3, -4, 5, 0, 4, -2, 2};
        int k = 10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);   // important

        int sum = 0;
        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                length = Math.max(length, i - map.get(sum - k));
            }

            map.putIfAbsent(sum, i);
        }

        System.out.println(length);

////Longest Subarray with Equal Number of 0s and 1s.
        int[] arr = {0, 1, 0, 1, 1, 0, 0};

        public static int longestSubarrayWithEqualZeroOneBruteForce(int[] arr) {

           int maxLen = 0;

            for (int i = 0; i < arr.length; i++) {

            int count0 = 0, count1 = 0;

            for (int j = i; j < arr.length; j++) {

                if (arr[j] == 0) count0++;
                else count1++;

                if (count0 == count1) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
}

// TC: O(n^2)
// SC: O(1)

        public static int longestSubarrayWithEqualZeroOne(int[] arr) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int maxLen = 0;

            map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) sum += -1;
            else sum += 1;

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            }

            map.putIfAbsent(sum, i); // no need for else
        }

        return maxLen;
}

// TC: O(n)
// SC: O(n)

////Largest Subarray with Equal Number of 0s, 1s, and 2s.

        public static int longestSubarrayWithEqual012BruteForce(int[] arr) {

            int maxLen = 0;
            for (int i = 0; i < arr.length; i++) {
            int c0 = 0, c1 = 0, c2 = 0;
            for (int j = i; j < arr.length; j++) {

                if (arr[j] == 0) c0++;
                else if (arr[j] == 1) c1++;
                else c2++;

                if (c0 == c1 && c1 == c2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

// TC: O(n^2)
// SC: O(1)

        int c0=0,c1=0,c2=0, d10=0,d20=0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0",-1);
        for (i = 0; i < arr.length; i++) {
            if(arr[i]==0) c0++;
            else if (arr[i]==1) c1++;
            else c2++;

            d10=c1-c0;
            d20=c2-c0;

            String key= d10 + "#" + d20;

            if(map.containsKey(key)){
                length=Math.max(length,i-map.get(key));
            }
            map.putIfAbsent(key,i);
        }

//// Longest Substring Without Repeating Characters: Given a string, S. Find the length of the longest substring without repeating characters.

        String str = "takeUforward";

        public static int longestSubstringBrute(String str) {

            int maxlen = 0;

            for (int i = 0; i < str.length(); i++) {

                HashSet<Character> set = new HashSet<>();

                for (int j = i; j < str.length(); j++) {

                    char c = str.charAt(j);

                    if (set.contains(c)) break;

                    set.add(c);

                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }

            return maxlen;
        }

        // TC: O(n^2)
        // SC: O(n)

        public static int longestSubstringOptimal(String str) {

            HashSet<Character> set = new HashSet<>();

            int left = 0, maxlen = 0;

            for (int right = 0; right < str.length(); right++) {

                while (set.contains(str.charAt(right))) {
                    set.remove(str.charAt(left));
                    left++;
                }

                set.add(str.charAt(right));
                maxlen = Math.max(maxlen, right - left + 1);
            }

            return maxlen;
        }

        // TC: O(n)
        // SC: O(n)

////Longest repeating character replacement: Length of the longest substring where you can make all characters equal after at most k replacements.

        String str="ABBC";
        int k=2;

        public static int characterReplacementBrute(String str, int k) {

            int maxlen = 0;

            for (int i = 0; i < str.length(); i++) {

                int[] freq = new int[26];
                int maximum = 0;

                for (int j = i; j < str.length(); j++) {

                    char c = str.charAt(j);

                    freq[c - 'A']++;

                    maximum = Math.max(maximum, freq[c - 'A']);

                    int windowSize = j - i + 1;

                    if (windowSize - maximum <= k) {
                        maxlen = Math.max(maxlen, windowSize);
                    }
                }
            }

            return maxlen;
        }

        // TC: O(n^2)
        // SC: O(1)

        public static int characterReplacement(String str, int k) {

            int[] freq = new int[26];
            int left = 0, right = 0;
            int maxCount = 0, maxLength = 0;

            while (right < str.length()) {

                freq[str.charAt(right) - 'A']++;

                maxCount = Math.max(maxCount, freq[str.charAt(right) - 'A']);

                while ((right - left + 1) - maxCount > k) {
                    freq[str.charAt(left) - 'A']--;
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);

                right++;
            }

            return maxLength;
        }

        // TC: O(n)
        // SC: O(1)

//// Longest Substring with At Most K Distinct Characters: Find the length of the longest substring with at most k distinct characters.

        String str="aababbcaacc"; int k = 2;

        public static int longestKDistinctBrute(String str, int k) {

            int maxlen = 0;

            for (int i = 0; i < str.length(); i++) {

                HashSet<Character> set = new HashSet<>();

                for (int j = i; j < str.length(); j++) {

                    char c = str.charAt(j);
                    set.add(c);

                    if (set.size() > k) break;

                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }

            return maxlen;
        }

        // TC: O(n^2)
        // SC: O(n)

        public static int longestKDistinctOptimal(String str, int k) {

            int maxlen = 0;
            int left = 0;

            HashMap<Character, Integer> map = new HashMap<>();

            for (int right = 0; right < str.length(); right++) {

                char c = str.charAt(right);
                map.put(c, map.getOrDefault(c, 0) + 1);

                while (map.size() > k) {

                    char leftChar = str.charAt(left);
                    map.put(leftChar, map.get(leftChar) - 1);

                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }

                    left++;
                }

                maxlen = Math.max(maxlen, right - left + 1);
            }

            return maxlen;
        }

        // TC: O(n)
        // SC: O(k) ≈ O(n)

        public static int longestKDistinctOptimal(String str, int k) {

            int[] freq = new int[128]; // ASCII
            int left = 0, maxlen = 0, distinct = 0;

            for (int right = 0; right < str.length(); right++) {

                char c = str.charAt(right);

                if (freq[c] == 0) distinct++;

                freq[c]++;

                while (distinct > k) {

                    char leftChar = str.charAt(left);

                    freq[leftChar]--;

                    if (freq[leftChar] == 0) distinct--;

                    left++;
                }

                maxlen = Math.max(maxlen, right - left + 1);
            }

            return maxlen;
        }

        // TC: O(n)
        // SC: O(1)

//// Minimum Window Substring: Given two strings s and t. Find the smallest window substring of s that includes all characters in t (including duplicates), order doesn't matter in the window. Return the empty string "" if no such substring exists.

        String s = "ADOBECODEBAANC";
        String t = "ABCA";

        static int minWindowLength(String str, String target) {
            int minlength = Integer.MAX_VALUE;

            for (int start = 0; start < str.length(); start++) {

                for (int end = start; end < str.length(); end++) {

                    int length = end - start + 1;

                    if (target.length() > length) continue;
                    if (length >= minlength) continue;

                    String s = str.substring(start, end + 1);

                    if (isValidWindow(s, target)) {
                        minlength = length;
                    }
                }
            }

            return minlength == Integer.MAX_VALUE ? -1 : minlength;
        }

        static boolean isValidWindow(String s, String target) {

            int[] freq = new int[128];

            for (char c : target.toCharArray()) {
                freq[c]++;
            }

            int required = target.length(); // total chars needed

            for (char c : s.toCharArray()) {
                if (freq[c] > 0) {
                    required--;
                }
                freq[c]--;
            }

            return required == 0;
        }

        TC: O(n3)

        public static int minWindowLengthBrute(String s, String t) {

            int minlength = Integer.MAX_VALUE;
            int[] hash = new int[256];

            for (int i = 0; i < t.length(); i++) {
                hash[t.charAt(i)]++;
            }

            for (int i = 0; i < s.length(); i++) {

                int[] frequency = hash.clone();
                int count = t.length();

                for (int j = i; j < s.length(); j++) {

                    char c = s.charAt(j);
                    if (frequency[c] > 0) count--;
                    frequency[c]--;

                    if (count == 0) {
                        minlength = Math.min(minlength, j - i + 1);
                        break;
                    }
                }
            }
            return minlength == Integer.MAX_VALUE ? -1 : minlength;
        }

        // TC: O(n^2)
        // SC: O(1)

        public static int minWindowLengthOptimal(String s, String t) {

            int[] hash = new int[256];

            for (char c : t.toCharArray()) {
                hash[c]++;
            }

            int left = 0, right = 0;
            int count = t.length();

            int minLen = Integer.MAX_VALUE;

            while (right < s.length()) {

                if (hash[s.charAt(right)] > 0) {
                    count--;
                }

                hash[s.charAt(right)]--;

                while (count == 0) {

                    minLen = Math.min(minLen, right - left + 1);

                    hash[s.charAt(left)]++;

                    if (hash[s.charAt(left)] > 0) {
                        count++;
                    }

                    left++;
                }

                right++;
            }

            return minLen == Integer.MAX_VALUE ? -1 : minLen;
        }

        // TC: O(n)
        // SC: O(1)

////Minimum window subsequence:

"A subsequence is formed by removing some or no characters from the original string without changing the order of the remaining characters. This means skipping is allowed, but the relative order must be preserved. For instance, from "abcde", valid subsequences include "a", "ace" (skipping b and d), "bd", "abc", and "abcde", while "aed" is invalid because it changes the order of characters."

"Now consider the strings s1 = "geeksforgeeks" and s2 = "eksrg". The output "eksforg" is a subsequence of s1 that contains all characters of s2 in the same order. Additionally, it is constructed to be as long as possible while still maintaining s2 as a subsequence within it."

"For each character, we decide whether to include or exclude it, leading to 2 choices per character. Hence total subsequences are 2ⁿ."

        public String minWindowImprovedBrute(String s1, String s2) {
            int n = s1.length();
            int minLen = Integer.MAX_VALUE;
            String result = "";

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {

                    int windowLen = j - i + 1;

                    // Skip invalid windows
                    if (windowLen >= minLen) continue;
                    if (windowLen < s2.length()) continue;

                    String sub = s1.substring(i, j + 1);

                    if (isSubsequence(sub, s2)) {
                        minLen = windowLen;
                        result = sub;
                        break; // minimal for this i
                    }
                }
            }

            return result;
        }

        private boolean isSubsequence(String s1, String s2) {
            int i = 0, j = 0;

            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == s2.length();
        }

        TC: O(N3)

        static String minWindow(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            if (m == 0 || n == 0 || m > n) return "";

            String ans = "";
            int minLen = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == s2.charAt(0)) {

                    int p1 = i, p2 = 0;

                    // Forward scan
                    while (p1 < n && p2 < m) {
                        if (s1.charAt(p1) == s2.charAt(p2)) p2++;
                        p1++;
                    }

                    if (p2 == m) {
                        int end = p1 - 1;
                        p2 = m - 1;

                        // Backward shrink
                        while (end >= 0) {
                            if (s1.charAt(end) == s2.charAt(p2)) p2--;
                            if (p2 < 0) break;
                            end--;
                        }

                        int start = end;
                        int len = p1 - start;

                        if (len < minLen) {
                            minLen = len;
                            ans = s1.substring(start, start + len);
                        }
                    }
                }
            }

            return ans;
        }

        //TC: O(n × m)

// DP Solution:

////Longest Palindromic Substring[Do it without DP]: Given a string s, return the longest palindromic substring in s.

"A string of length n has n(n+1)/2 substrings because for each starting index, we can form substrings up to the end, forming an arithmetic series. and to check whether the string is palindrome or not it takes n/2 comaprison"

        public static String longestPalindromeBrute(String s) {

            int n = s.length();
            String result = "";

            for (int i = 0; i < n; i++) {

                for (int j = i; j < n; j++) {

                    String sub = s.substring(i, j + 1);

                    if (isPalindrome(sub)) {

                        if (sub.length() > result.length()) {
                            result = sub;
                        }
                    }
                }
            }

            return result;
        }

        private static boolean isPalindrome(String str) {

            int left = 0;
            int right = str.length() - 1;

            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }

            return true;
        }

        // TC: O(n^3)
        // SC: O(1)

        public static String getLongestPal(String s) {

            int n = s.length();

            int start = 0;
            int maxLen = 1;

            for (int i = 0; i < n; i++) {

                // run twice: odd (j=0), even (j=1)
                for (int j = 0; j <= 1; j++) {

                    int low = i;
                    int high = i + j;

                    // expand while palindrome
                    while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {

                        int currLen = high - low + 1;

                        if (currLen > maxLen) {
                            start = low;
                            maxLen = currLen;
                        }

                        low--;
                        high++;
                    }
                }
            }

            return s.substring(start, start + maxLen);
        }

        // TC: O(n^2)
        // SC: O(1)

"In the expand-around-center approach, we use two types of centers because palindromes can be either odd-length or even-length. An odd-length palindrome has a single central character (like `"aba"`), so we expand around one index. However, an even-length palindrome does not have a single middle character; instead, its center lies between two characters (like `"baab"`), so we must expand between adjacent indices. If we only consider one center, we would miss all even-length palindromes. Therefore, by checking both cases—one center (`i, i`) and two centers (`i, i+1`)—we ensure that all possible palindromic substrings are covered."

"In the center expansion algorithm for finding the longest palindromic substring, instead of checking all possible substrings, we treat each index (and gap between indices) as a potential center and expand outward to check for palindromes. A string of length n has n possible odd-length centers (each character) and n−1 even-length centers (between adjacent characters), giving a total of 2n−1 centers. For each center, we expand outward while the characters match, and in the worst case, this expansion can take up to n/2 comparisons. Therefore, the total time complexity becomes:  (2n − 1) × (n/2) ≈ O(n²).  " +

"The space complexity is O(1) since no extra space is used apart from variables."

// Manchers Algorithm:


//// Longest Common Prefix:
        String[] input = {"interview", "internet", "internal", "interval"};

        public static String longestCommonPrefix(String[] strs) {

            if (strs == null || strs.length == 0) return "";

            String first = strs[0];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < first.length(); i++) {

                char ch = first.charAt(i);

                // compare this character with all other strings
                for (int j = 1; j < strs.length; j++) {

                    // if index out of bound OR mismatch
                    if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                        return result.toString();
                    }
                }

                result.append(ch);
            }

            return result.toString();
        }

        // TC: O(n * m)
        // n = number of strings
        // m = length of shortest string
        // SC: O(1)  (excluding output)

        public static String longestCommonPrefixBetter(String[] strs) {

            if (strs == null || strs.length == 0) return "";

            Arrays.sort(strs); //Yes, string sorting in Java is lexicographical (dictionary order).

            String first = strs[0];
            String last = strs[strs.length - 1];

            int i = 0;

            while (i < first.length() && i < last.length() &&
                    first.charAt(i) == last.charAt(i)) {
                i++;
            }

            return first.substring(0, i);
        }

//        Total = (number of comparisons) × (cost per comparison)= (n log n) × m

        public static String longestCommonPrefixOptimal(String[] strs) {

            if (strs == null || strs.length == 0) return "";

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {

                while (!strs[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);

                    if (prefix.isEmpty()) return "";
                }
            }

            return prefix;
        }

        // TC: O(n * m)
        // SC: O(1)

"In this code, n and m represent two different dimensions of the input. n is the number of strings in the array strs, i.e., strs.length. The outer loop runs from 1 to n - 1, so we compare the prefix with each string one by one. m is the length of the prefix (or effectively the length of the shortest string). In the worst case, the prefix can be as long as the first string initially, and during comparisons we may check up to m characters when using startsWith() and when shrinking the prefix using substring().  So the time complexity O(n × m) comes from the fact that for each of the n strings, we may compare up to m characters while matching and shrinking the prefix."


"Both approaches(brute force and optimal) have O(n*m) time complexity, but the optimal one reduces the prefix size dynamically, making it faster in practice due to fewer comparisons.”

" I’ll start with a brute force column-wise comparison( vertical scanning) in O(n*m).Then I can optimize using sorting, but the best practical approach is horizontal scanning where I iteratively reduce the prefix.”

"Vertical scanning and horizontal scanning are two different approaches to solve the Longest Common Prefix problem. In vertical scanning, we compare characters column by column, meaning we fix an index and check that character across all strings at the same position. If any mismatch occurs or a string ends, we stop and return the prefix found so far. This approach treats the input like a table and scans it vertically. In contrast, horizontal scanning works by taking the first string as an initial prefix and then comparing it with each subsequent string one by one, gradually shrinking the prefix until it matches all strings. So instead of checking all strings at a fixed index, it reduces the prefix step-by-step across the array. Although both approaches have the same time complexity of O(n × m), horizontal scanning is often more efficient in practice because the prefix keeps shrinking, reducing the number of comparisons needed for later strings."

////Maximum Product sub array.

        public int maxProduct(int[] nums) {

            int ans = nums[0];
            int curr_max = nums[0];
            int curr_min = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            if (curr < 0) {
                int temp = curr_max;
                curr_max = curr_min;
                curr_min = temp;
            }

            curr_max = Math.max(curr, curr * curr_max);
            curr_min = Math.min(curr, curr * curr_min);
            ans = Math.max(ans, curr_max);
        }
        return ans;
    }

// TC: O(n)
// SC: O(1)

//// Maximum subarray Sum:

        public static int maxSubarraySum(int[] arr) {

            int i = 0, j = 0;
            int sum = 0;
            int max_sum = Integer.MIN_VALUE;

            while (j < arr.length) {

            sum += arr[j];

            if (sum > max_sum) {
                max_sum = sum;
            }

            if (sum < 0) {
                sum = 0;
                i = j + 1;
            }

            j++;
        }

        return max_sum;
    }

// TC: O(n)
// SC: O(1)

//// Stock buy or sell
        int[] arr = { 7, 1, 5, 3, 6, 4};
        int min=arr[0];
        int profit=0, current_profit=0;

        for(int i=1;i<arr.length;i++) {

            current_profit=arr[i]-min;

            profit=Math.max(current_profit,profit);

            if(min>arr[i]){
                min=arr[i];
            }
        }

//// Stock buy or sell II:

"Your approach fails because it treats the problem like a subarray accumulation, while the actual problem requires state-based decisions (buy/sell/skip)."

for (i = 0 → n) {
    buyPrice = arr[i];

    for (j = i+1 → n) {
        if (arr[j] > buyPrice) {
            profit += arr[j] - buyPrice;
        }
        buyPrice = arr[j];
    }
}

"Whenever a problem involves making choices at each step and future depends on current decisions, we model it using recursion."

public static int maxProfitBruteForce(int[] prices) {
    return helper(prices, 0);
}

private static int helper(int[] prices, int index) {

    if (index >= prices.length) return 0;

    int maxProfit = 0;

    for (int buy = index; buy < prices.length; buy++) {

        int profit = 0;

        for (int sell = buy + 1; sell < prices.length; sell++) {

            if (prices[sell] > prices[buy]) {

                int currentProfit = prices[sell] - prices[buy]
                                  + helper(prices, sell + 1);

                profit = Math.max(profit, currentProfit);
            }
        }

        maxProfit = Math.max(maxProfit, profit);
    }

    return maxProfit;
}

// TC: Exponential (≈ O(2^n))
// SC: O(n) (recursion stack)


public int maxProfit(int[] prices) {
        int n = prices.length;
        int lMin = prices[0];
        int lMax = prices[0];
        int res = 0;

        int i = 0;
        while (i < n - 1) {

            while (i < n - 1 && prices[i] >= prices[i + 1]) { i++; }
            lMin = prices[i];

            while (i < n - 1 && prices[i] <= prices[i + 1]) { i++; }
            lMax = prices[i];

            res += (lMax - lMin);
        }

        return res;
    }

////Product of Array Except Self Without division.

        int[] arr = {10, 3, 5, 6, 2};

        public static int[] productExceptSelfBruteForce(int[] arr) {

            int n = arr.length;
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {

                int product = 1;

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        product *= arr[j];
                    }
                }

                result[i] = product;
            }

            return result;
        }

        TC: O(N2) O(1)

        public static int[] productExceptSelfBetter(int[] arr) {

            int n = arr.length;

            int[] prefix = new int[n];
            int[] suffix = new int[n];
            int[] result = new int[n];

            // prefix[i] = product of all elements before i
            prefix[0] = 1;
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] * arr[i - 1];
            }

            // suffix[i] = product of all elements after i
            suffix[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * arr[i + 1];
            }

            // result[i] = prefix[i] * suffix[i]
            for (int i = 0; i < n; i++) {
                result[i] = prefix[i] * suffix[i];
            }

            return result;
        }

        TC: O(n) SC: O(n)

        public static int[] productExceptSelfOptimal(int[] arr) {

            int n = arr.length;
            int[] result = new int[n];

            // Step 1: store prefix products directly in result
            result[0] = 1;
            for (int i = 1; i < n; i++) {
                result[i] = result[i - 1] * arr[i - 1];
            }

            // Step 2: multiply with suffix product (using variable)
            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                result[i] = result[i] * suffix;
                suffix *= arr[i];
            }

            return result;
        }

        TC: O(n) SC: O(1)

//// find the length of the longest consecutive elements sequence.
        int[] arr = {100, 4, 200, 1, 3, 2, 2};

        public int longestConsecutive(int[] arr) {

            if (arr.length==0) return 0;

            int max_length = 1; // handle single element case

            for (int i = 0; i < arr.length; i++) {

                int curr = arr[i];
                int currlength = 1;

                boolean found = true;

                while (found) {

                    found = false;

                    for (int j = 0; j < arr.length; j++) {

                        if (arr[j] == curr + 1) {
                            curr = curr + 1;
                            currlength++;
                            found = true;
                            break; // important
                        }
                    }
                }

                max_length = Math.max(max_length, currlength);
            }

            return max_length;
        }

        TC: O(N2)

        public int longestConsecutive(int[] arr) {

            if (arr.length == 0) return 0;

            Arrays.sort(arr);

            int max_length = 1;
            int curr_length = 1;

            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i] == arr[i + 1]) continue;

                if (arr[i] + 1 == arr[i + 1]) {
                    curr_length++;
                    max_length = Math.max(max_length, curr_length);
                } else {
                    curr_length = 1;
                }
            }

            return max_length;
        }
    }

    // TC: O(n log n)
    // SC: O(1) (ignoring sorting space)


    public int longestConsecutive(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {

            // start only if it's the beginning of sequence
            if (!set.contains(num - 1)) {

                int curr = num;
                int length = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }

    // TC: O(n)
    // SC: O(n)

////  Return an element that occurs more than N/2 times:

        int nums = [2,2,1,1,1,2,2];

    public int majorityElement(int[] nums) {

        int majorityElement = 0;
        int maximumCount = 0;

        for (int i = 0; i < nums.length; i++) {

            int currentCount = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] == nums[i]) {
                    currentCount++;
                }
            }

            if (currentCount > maximumCount) {
                majorityElement = nums[i];
                maximumCount = currentCount;
            }
        }

        return majorityElement;
    }

    // TC: O(n^2)
    // SC: O(1)

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // not needed as majority always exists
    }

    // TC: O(n)
    // SC: O(n)

    int majorityElement(int[] arr) {

        int n = arr.length;
        int candidate = -1;
        int count = 0;

        // Find a candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            else if (num == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        // Validate the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // If count is greater than n / 2, return
        // the candidate; otherwise, return -1
        if (count > n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    // TC: O(n)
    // SC: O(1)


    The algorithm is based on the idea that if an element occurs more than n/2 times, then all the remaining elements together must occur less than n/2 times.

    While traversing the array, we maintain a candidate and a vote count:

    If the current element matches the candidate, we increment the vote count.
    If it does not match, we decrement the vote count.
    When the vote count becomes 0, it means the current candidate cannot be the majority element, so we select a new candidate.

    By the end of the first traversal, the remaining candidate is the potential majority element (if there is a majority element, then this elements has to be the one). A second traversal is required to verify whether it actually appears more than n/2 times.



////Return an element that occurs more than N/3 times:
        int[] arr={2,1,1,3,1,4,5,6};

    static ArrayList<Integer> findMajority(int[] arr) {

        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int count = 0;

            // Count frequency of arr[i]
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // Check if > n/3
            if (count > n / 3 && !res.contains(arr[i])) {
                res.add(arr[i]);
            }

            // At most 2 elements possible
            if (res.size() == 2) break;
        }

        return res;
    }

    // TC: O(n^2)
    // SC: O(1) (excluding output)

    import java.util.*;

    public class Solution {

        public static ArrayList<Integer> majorityElementNby3(int[] arr) {

            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> ans = new ArrayList<>();

            for (int num : arr) {

                map.put(num, map.getOrDefault(num, 0) + 1);

                if (map.get(num) > arr.length / 3 && !ans.contains(num)) {
                    ans.add(num);
                }

                if (ans.size() == 2) break;
            }

            return ans;
        }
    }

    // TC: O(n)
    // SC: O(n)

    import java.util.*;

    public class Solution {

        public static List<Integer> majorityElementNby3(int[] arr) {

            int e1 = -1, e2 = -1;
            int cnt1 = 0, cnt2 = 0;

            // Step 1: Find potential candidates
            for (int num : arr) {

                if (cnt1 == 0 && num != e2) {
                    e1 = num;
                    cnt1++;
                }
                else if (cnt2 == 0 && num != e1) {
                    e2 = num;
                    cnt2++;
                }
                else if (num == e1) {
                    cnt1++;
                }
                else if (num == e2) {
                    cnt2++;
                }
                else {
                    cnt1--;
                    cnt2--;
                }
            }

            // Step 2: Verify counts
            cnt1 = 0;
            cnt2 = 0;

            for (int num : arr) {
                if (num == e1) cnt1++;
                else if (num == e2) cnt2++;
            }

            // Step 3: Collect result
            List<Integer> res = new ArrayList<>();

            if (cnt1 > arr.length / 3) res.add(e1);
            if (cnt2 > arr.length / 3) res.add(e2);

            return res;
        }
    }

    // TC: O(n)
    // SC: O(1)

////Sort an array of 0s, 1s and 2s:

        int[] arr={1,0,2,2,2,1,1,1,0,0,0,1,1,1,2,2,2,2};

        Naive: Sorting NlogN
        Two Pass: O(2n)

// Dutch National Flag Algorithm (Sort 0s, 1s, 2s)

    public void sortColors(int[] arr) {

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    // TC: O(n)
    // SC: O(1)


//// Two Sum: Given an array and target, find any pair of elements whose sum equals target.

        Naive Approach: O(N2)
        Better Approach: Sorting and two-pointer

        public static int countPairs(int[] arr, int k) {

            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;

            for (int num : arr) {

                int rem = k - num;

                if (map.containsKey(rem)) {
                    count += map.get(rem); // count all previous occurrences
                }

                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(n)

//// 3 Sum Problem: Find three numbers in an array whose sum equals a given target:
        int[] arr = {-1, 0, 1, 2, -1, -4};

    public List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                for (int k = j + 1; k < arr.length; k++) {

                    if (arr[i] + arr[j] + arr[k] == 0) {
                        list.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }

        return list;
    }

    // TC: O(n^3)
    // SC: O(1) (excluding output)

    public List<List<Integer>> threeSum(int[] arr) {

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < arr.length; j++) {

                int third = -(arr[i] + arr[j]);

                if (set.contains(third)) {

                    List<Integer> triplet = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(triplet); // avoid duplicates
                    result.add(triplet);
                }

                set.add(arr[j]);
            }
        }

        return new ArrayList<>(result);
    }

    // TC: O(n^2)
    // SC: O(n)


        int k=0;
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(arr);
        // [-4, -1, -1, 0, 1, 2]
        for(int i=0;i<arr.length-2;i++){

            if(i>0 && arr[i]==arr[i-1]) continue;

            int left=i+1;
            int right=arr.length-1;

            while (left<right){
                int sum=arr[i] + arr[left] +arr[right];

                if(sum==k){
                    res.add(Arrays.asList(arr[i],arr[left],arr[right]));

                    while (left<right && arr[left]==arr[left+1]) left++;
                    while (left<right && arr[right]==arr[right-1]) right--;

                    left++;
                    right--;
                } else if (sum>k) {
                    right--;
                }else {
                    left++;
                }
            }

            public List<List<Integer>> threeSum(int[] arr) {

                List<List<Integer>> res = new ArrayList<>();
                Arrays.sort(arr);

                for (int i = 0; i < arr.length - 2; i++) {

                    // skip duplicates for i
                    if (i > 0 && arr[i] == arr[i - 1]) continue;

                    int left = i + 1;
                    int right = arr.length - 1;

                    while (left < right) {

                        int sum = arr[i] + arr[left] + arr[right];

                        if (sum == 0) {

                            res.add(Arrays.asList(arr[i], arr[left], arr[right]));

                            // skip duplicates for left
                            while (left < right && arr[left] == arr[left + 1]) left++;

                            // skip duplicates for right
                            while (left < right && arr[right] == arr[right - 1]) right--;

                            left++;
                            right--;
                        }
                        else if (sum < 0) {
                            left++;
                        }
                        else {
                            right--;
                        }
                    }
                }

                return res;
            }

    // TC: O(n^2)
    // SC: O(1) (excluding output)


////Merge two sorted array Without Extra Space return o/p in one input array:

        int[] arr1 = {1, 3, 5, 7}; int[] arr2 = {2, 4, 6, 8};

        public void merge(int[] nums1, int m, int[] nums2, int n) {

            // copy nums2 into nums1
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }

            // sort whole array
            Arrays.sort(nums1);
        }

        // TC: O((m+n) log(m+n))
        // SC: O(1)

        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = m - 1;          // last valid in nums1
            int j = n - 1;          // last in nums2
            int k = m + n - 1;      // last position in nums1

            while (i >= 0 && j >= 0) {

                if (nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }

            // fill remaining nums2
            while (j >= 0) {
                nums1[k--] = nums2[j--];
            }
        }

        // TC: O(m + n)
        // SC: O(1)

////Merge two sorted array Without Extra Space return o/p in both the array:

        static void mergeArrays(int[] firstArray, int[] secondArray) {

            int n = firstArray.length;
            int m = secondArray.length;

            for (int i = m - 1; i >= 0; i--) {

                // if last element of firstArray is greater than secondarray last element
                if (firstArray[n - 1] > secondArray[i]) {

                    int last = firstArray[n - 1];
                    int j = n - 2;

                    // shift elements in firstArray
                    while (j >= 0 && firstArray[j] > secondArray[i]) {
                        firstArray[j + 1] = firstArray[j];
                        j--;
                    }

                    // place element correctly
                    firstArray[j + 1] = secondArray[i];

                    // move last element to secondArray
                    secondArray[i] = last;
                }
            }
        }

        // TC: O(n * m)
        // SC: O(1)

        public void merge(int[] a, int[] b) {

            int i = a.length - 1;
            int j = 0;

            // Swap elements
            while (i >= 0 && j < b.length) {

                if (a[i] > b[j]) {
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;

                    i--;
                    j++;
                } else {
                    break;
                }
            }

            Arrays.sort(a);
            Arrays.sort(b);
        }

        TC: O((m+n) + m*log(m) + n*log(n))
        SC: O(1)

        public void merge(int[] a, int[] b) {

            int n = a.length;
            int m = b.length;

            int gap = (n + m + 1) / 2;

            while (gap > 0) {

                int i = 0;
                int j = gap;

                while (j < n + m) {

                    // Case 1: both pointers in a[]
                    if (i < n && j < n) {
                        if (a[i] > a[j]) {
                            int temp = a[i];
                            a[i] = a[j];
                            a[j] = temp;
                        }
                    }
                    // Case 2: i in a[], j in b[]
                    else if (i < n && j >= n) {
                        if (a[i] > b[j - n]) {
                            int temp = a[i];
                            a[i] = b[j - n];
                            b[j - n] = temp;
                        }
                    }
                    // Case 3: both in b[]
                    else {
                        if (b[i - n] > b[j - n]) {
                            int temp = b[i - n];
                            b[i - n] = b[j - n];
                            b[j - n] = temp;
                        }
                    }

                    i++;
                    j++;
                }

                if (gap == 1) break;
                gap = (gap + 1) / 2;
            }
        }

        TC: O((m + n) log(m + n))
        SC: O(1)

////Next Permutation:

        Naive Approach: "In the naive approach, we generate all possible permutations of the given array, sort them in lexicographical order, and then find the next permutation of the current array."

        Generate All permutation:   N!*N
        Sorting all permutations:   O(n × n! log(n!))
        Search:	                    O(n × n!)
        Space:                      O(n!)

        The optimal solution for the Next Permutation problem is based on the idea of finding the next lexicographically greater arrangement of the given array without generating all permutations. The key observation is that permutations follow a specific order, and we want to make the smallest possible change to get the next larger permutation. To achieve this, we start scanning the array from the right and look for the first position where the order breaks, i.e., an index i such that nums[i] < nums[i+1]. This point is called the breakpoint, and it indicates that the sequence to the right of it is in decreasing order and cannot be rearranged to form a larger permutation on its own. Once we find this breakpoint, we then search the right side of the array to find the smallest element that is greater than nums[i], ensuring that the increase is minimal. We swap this element with nums[i]. After the swap, the right portion of the array is still in decreasing order, so to make the overall permutation just slightly larger, we reverse this suffix to convert it into the smallest possible order (ascending). This guarantees that we get the next immediate permutation.

        For example, consider the array [1, 2, 3, 6, 5, 4]. Scanning from the right, we find that 3 < 6, so index of 3 is the breakpoint. Then we look for the smallest element greater than 3 on the right side, which is 4, and swap them to get [1, 2, 4, 6, 5, 3]. Finally, we reverse the suffix after the breakpoint, resulting in [1, 2, 4, 3, 5, 6], which is the next permutation. If no such breakpoint exists (e.g., [3,2,1]), it means the array is the largest permutation, and we simply reverse the entire array to get the smallest permutation. This approach works in O(n) time and uses O(1) space, making it highly efficient compared to the brute force method.

        static void nextPermutation(int[] arr)
        {

            int n = arr.length;

            // Find the pivot index
            int pivot = -1;
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] < arr[i + 1]) {
                    pivot = i;
                    break;
                }
            }

            // If pivot point does not exist,
            // reverse the whole array
            if (pivot == -1) {
                reverse(arr, 0, n - 1);
                return ;
            }

            // Find the element from the right
            // that is greater than pivot
            for (int i = n - 1; i > pivot; i--) {
                if (arr[i] > arr[pivot]) {
                    swap(arr, i, pivot);
                    break;
                }
            }

            // Reverse the elements from pivot + 1 to the end
            reverse(arr, pivot + 1, n - 1);
        }

        // Helper method to reverse array
        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                swap(arr, start++, end--);
            }
        }

        // Helper method to swap two elements
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        TC: O(N) O(1)

//// Maximum Consecutive ones: Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

        int nums[] = {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0};
        int k = 3;

        public int longestOnes(int[] nums, int k) {

            int maxLen = 0;

            for (int i = 0; i < nums.length; i++) {

                int zeros = 0;

                for (int j = i; j < nums.length; j++) {

                    if (nums[j] == 0) zeros++;

                    if (zeros > k) break;

                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }

            return maxLen;
        }

        // TC: O(n^2)
        // SC: O(1)

        public int longestOnes(int[] nums, int k) {

            int maxLen = 0;
            int left=0;
            int zeroes=0;

            for (int right = 0; right < nums.length; right++) {

                if(arr[right]==0){
                    zeroes++;
                }

                while (zeroes>k){

                    if(arr[left]==0){
                        zeroes--;
                    }
                    left++;
                }

                maxLen=Math.max(maxLen,right-left+1);
            }
            return maxLen;
        }

        TC: O(n) SC: O(1)

////Fruit Into Baskets or Also known as: Longest Subarray with at most 2 distinct elements:

        int nums[]={1,1,0,2,2,1,1,2,2,0,0,1}; int k=2;

        public int totalFruitBrute(int[] fruits) {

            int n = fruits.length;
            int maxLen = 0;

            for (int i = 0; i < n; i++) {

                HashSet<Integer> set = new HashSet<>();

                for (int j = i; j < n; j++) {

                    set.add(fruits[j]);

                    if (set.size() > 2) break;

                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }

            return maxLen;
        }

        // TC: O(n^2)
        // SC: O(1)  (at most 2 elements in set)

        public int totalFruit(int[] fruits) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int left = 0, maxLen = 0;

            for (int right = 0; right < fruits.length; right++) {

                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

                while (map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);

                    if (map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }

        // TC: O(n)
        // SC: O(1)  (at most 2 elements in map)

////Maximum point you can obtain from cards: Given N cards arranged in a row, each card has an associated score denoted by the cardScore array. Choose exactly k cards.     In each step, a card can be chosen either from the beginning or the end of the row. The score is the sum of the scores of the chosen cards.

        int[] cards = {5, 4, 1, 8, 7, 1, 3};
        int k = 3;

        public int maxScoreBrute(int[] cardScore, int k) {

            int n = cardScore.length;
            int maxSum = 0;

            for (int front = 0; front <= k; front++) {

                int back = k - front;
                int sum = 0;

                // pick from front
                for (int i = 0; i < front; i++) {
                    sum += cardScore[i];
                }

                // pick from back
                for (int i = 0; i < back; i++) {
                    sum += cardScore[n - 1 - i];
                }

                maxSum = Math.max(maxSum, sum);
            }

            return maxSum;
        }

        // TC: O(k^2)
        // SC: O(1)

        public int maxScoreOptimal(int[] cardScore, int k) {

            int n = cardScore.length;

            // total sum of first k elements
            int currentSum = 0;
            for (int i = 0; i < k; i++) {
                currentSum += cardScore[i];
            }

            int maxSum = currentSum;

            int left = k - 1;
            int right = n - 1;

            // slide window: remove from front, add from back
            while (left >= 0) {

                currentSum -= cardScore[left];
                currentSum += cardScore[right];

                maxSum = Math.max(maxSum, currentSum);

                left--;
                right--;
            }

            return maxSum;
        }

        // TC: O(k)
        // SC: O(1)

//// Count of Subarrays with sum equals k in a given Binary Array:

        Naive: TC: O(n^2)  SC: O(1)

        public int countSubarraysOptimal(int[] arr, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0, count = 0;

            map.put(0, 1);

            for (int num : arr) {

                sum += num;

                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(n)

        public int countSubarraysBetter(int[] arr, int k) {
            return atMost(arr, k) - atMost(arr, k - 1);
        }

        private int atMost(int[] arr, int k) {

            int left = 0, sum = 0, count = 0;

            for (int right = 0; right < arr.length; right++) {

                sum += arr[right];

                while (sum > k) {
                    sum -= arr[left];
                    left++;
                }

                count += (right - left + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(1)

        Exactly(k) = atMost(k) - atMost(k-1)

"The atMost(k) trick doesn’t work with negative numbers because sliding window requires monotonic behavior, so we use prefix sum with hashmap instead."

        //// Count Subarrays with Given Sum K (Only Positives exclude zero):

        Naive: TC: O(n^2)  SC: O(1)

        public int countSubarraysOptimal(int[] arr, int k) {

            int left = 0, sum = 0, count = 0;

            for (int right = 0; right < arr.length; right++) {

                sum += arr[right];

                while (sum > k) {
                    sum -= arr[left];
                    left++;
                }

                if (sum == k) {
                    count++;
                }
            }

            return count;
        }

        // TC: O(n)
        // SC: O(1)

//// Count Subarrays with Given Sum K (Positives + Negatives).

        int arr[] = [10, 2, -2, -20, 10], k = -10

        public int countSubarraysBrute(int[] arr, int k) {

            int n = arr.length;
            int count = 0;

            for (int i = 0; i < n; i++) {

                int sum = 0;

                for (int j = i; j < n; j++) {

                    sum += arr[j];

                    if (sum == k) {
                        count++;
                    }
                }
            }

            return count;
        }

        // TC: O(n^2)
        // SC: O(1)

        public int countSubarraysOptimal(int[] arr, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0, count = 0;
            map.put(0, 1);

            for (int num : arr) {

                sum += num;

                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(n)


////Count number of nice subarrays: An array is called nice if and only if it contains k odd numbers. Find the number of nice subarrays in the given array nums.

        int [] nums={1,1,2,1,1,1}; int k=3;

        public int countNiceSubarraysBrute(int[] nums, int k) {

            int n = nums.length;
            int count = 0;

            for (int i = 0; i < n; i++) {

                int oddCount = 0;

                for (int j = i; j < n; j++) {

                    if (nums[j] % 2 != 0) {
                        oddCount++;
                    }

                    if (oddCount > k) break;   // 🔥 optimization

                    if (oddCount == k) {
                        count++;
                    }
                }
            }

            return count;
        }

        // TC: O(n^2) (but faster in practice)
        // SC: O(1)

        public int numberOfSubarraysHashMap(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0, count = 0;

            map.put(0, 1);

            for (int num : nums) {

                // convert odd to 1
                if (num % 2 != 0) {
                    sum += 1;
                }

                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(n)

        public int numberOfSubarraysOptimal(int[] nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
        }

        private int atMost(int[] nums, int k) {

            int left = 0, count = 0, oddCount = 0;

            for (int right = 0; right < nums.length; right++) {

                if (nums[right] % 2 != 0) {
                    oddCount++;
                }

                while (oddCount > k) {
                    if (nums[left] % 2 != 0) {
                        oddCount--;
                    }
                    left++;
                }

                count += (right - left + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(1)

//// Subarray with k different integers: Return the number of good subarrays of nums. A good subarray is defined as a contiguous subarray of nums that contains exactly k distinct integers. A subarray is a contiguous part of the array.

        int[] nums = {1, 2, 1, 2, 3}; int k = 2;

        Naive: O(N2) TC:O(N)

        public int subarraysWithKDistinct(int[] nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
        }

        private int atMost(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int left = 0, count = 0;

            for (int right = 0; right < nums.length; right++) {

                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

                while (map.size() > k) {
                    map.put(nums[left], map.get(nums[left]) - 1);

                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }

                count += (right - left + 1);
            }

            return count;
        }

        TC: O(N) SC: O(N)

////Count the number of subarrays whose product is less than equal to k.

        int arr[] = { 1, 2, 3, 4 };
        int k = 10;

        public int countSubarraysProductBrute(int[] nums, int k) {

            int n = nums.length;
            int count = 0;

            for (int i = 0; i < n; i++) {

                int product = 1;

                for (int j = i; j < n; j++) {

                    product *= nums[j];

                    if (product <= k) {
                        count++;
                    } else {
                        break; // optimization (only positive numbers)
                    }
                }
            }

            return count;
        }

        // TC: O(n^2)
        // SC: O(1)

        "We use sliding window maintaining product ≤ k and count all valid subarrays ending at each index, achieving O(n) time."

        public int countSubarraysProductOptimal(int[] nums, int k) {

            if (k <= 1) return 0; // important edge case

            int left = 0;
            int product = 1;
            int count = 0;

            for (int right = 0; right < nums.length; right++) {

                product *= nums[right];

                while (product > k) {
                    product /= nums[left];
                    left++;
                }

                count += (right - left + 1);
            }

            return count;
        }

        // TC: O(n)
        // SC: O(1)

//// Count Number of Substrings contain exactly k distinct characters.

        String str = "pqpqs";
        int k = 2;

        o/p--> "pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"


        public static int countKDistinctBrute(String str, int k) {

            int count = 0;

            for (int i = 0; i < str.length(); i++) {

                HashSet<Character> set = new HashSet<>();

                for (int j = i; j < str.length(); j++) {

                    char c = str.charAt(j);
                    set.add(c);

                    if (set.size() == k) {
                        count++;
                    }
                    else if (set.size() > k) {
                        break;
                    }
                }
            }

            return count;
        }

        // TC: O(n^2)
        // SC: O(n)

        exactly(k) = atMost(k) - atMost(k - 1)

        public static int atMostK(String str, int k) {

            int[] freq = new int[128]; // ASCII
            int left = 0, count = 0, distinct = 0;

            for (int right = 0; right < str.length(); right++) {

                char c = str.charAt(right);

                if (freq[c] == 0) distinct++;
                freq[c]++;

                while (distinct > k) {
                    char leftChar = str.charAt(left);

                    freq[leftChar]--;
                    if (freq[leftChar] == 0) distinct--;

                    left++;
                }

                // count substrings ending at right
                count += (right - left + 1);
            }

            return count;
        }

        public static int countKDistinctOptimal(String str, int k) {

            return atMostK(str, k) - atMostK(str, k - 1);
        }

        // TC: O(n)
        // SC: O(1)

////Number of substring containing all three characters: Given a string s consisting only of characters 'a', 'b', 'c'. Find the number of substrings that contain at least one occurrence of all these characters 'a', 'b', 'c'.

        String str="ccabcc";

        public static int countSubstringsBrute(String str) {

            int count = 0;

            for (int i = 0; i < str.length(); i++) {

                int[] freq = new int[3]; // a, b, c

                for (int j = i; j < str.length(); j++) {

                    freq[str.charAt(j) - 'a']++;

                    if (freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1) {
                        count++;
                    }
                }
            }

            return count;
        }

        // TC: O(n^2)
        // SC: O(1)

        public static int countSubstringsOptimal(String str) {

            int count = 0;
            int[] freq = new int[3];

            int n = str.length();
            int left = 0;

            for (int right = 0; right < n; right++) {

                freq[str.charAt(right) - 'a']++;

                while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                    count += (n - right);

                    freq[str.charAt(left) - 'a']--;
                    left++;
                }
            }

            return count;
        }

        // TC: O(n)
        // SC: O(1)

////Sum of Beauty of all substring: The beauty of a string is defined as the difference between the frequency of the most frequent character and the least frequent character (excluding characters that do not appear) in that string.

        String s="aabcbaa";

        public static int beautySumBrute(String s) {

            int sum = 0;

            for (int i = 0; i < s.length(); i++) {

                for (int j = i; j < s.length(); j++) {

                    int[] freq = new int[26]; // recreated every time ❌

                    // recompute freq from i → j
                    for (int k = i; k <= j; k++) {
                        freq[s.charAt(k) - 'a']++;
                    }

                    int maxFreq = 0;
                    int minFreq = Integer.MAX_VALUE;

                    for (int x = 0; x < 26; x++) {
                        if (freq[x] > 0) {
                            maxFreq = Math.max(maxFreq, freq[x]);
                            minFreq = Math.min(minFreq, freq[x]);
                        }
                    }

                    sum += (maxFreq - minFreq);
                }
            }

            return sum;
        }

        // TC: O(n^3)
        // SC: O(1)

        public static int beautySum(String s) {

            int sum = 0;

            for (int i = 0; i < s.length(); i++) {

                int[] frequency = new int[26];

                for (int j = i; j < s.length(); j++) {

                    frequency[s.charAt(j) - 'a']++;

                    int maximum = 0;
                    int minimum = Integer.MAX_VALUE;

                    // check all characters
                    for (int k = 0; k < 26; k++) {

                        if (frequency[k] > 0) {
                            maximum = Math.max(maximum, frequency[k]);
                            minimum = Math.min(minimum, frequency[k]);
                        }
                    }

                    sum += (maximum - minimum);
                }
            }

            return sum;
        }

        // TC: O(n^2)
        // SC: O(1)


*/
    }

}
