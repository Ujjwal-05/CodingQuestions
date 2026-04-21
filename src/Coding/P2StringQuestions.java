package Coding;

public class P2StringQuestions {

    public static void main(String[] args) {
/*
//// Remove Outermost Parenthesis:

        public String removeOuterParentheses(String s) {

            StringBuilder result = new StringBuilder();
            int count = 0;

            for (char ch : s.toCharArray()) {

                if (ch == '(') {
                    if (count > 0) {
                        result.append(ch); // not outermost
                    }
                    count++;
                } else { // ')'
                    count--;
                    if (count > 0) {
                        result.append(ch); // not outermost
                    }
                }
            }

            return result.toString();
        }

        // TC: O(n)
        // SC: O(n)

////Reverse Words in a String:

        String str="  This is decent ";

        public String reverseWordsNaive(String s) {

            String[] words = s.trim().split("\\s+");
            String result = "";

            for (int i = words.length - 1; i >= 0; i--) {
                result += words[i] + " ";
            }

            return result.trim();
        }

        // TC: O(n^2)  (due to string concatenation)
        // SC: O(n)

        String s = "apple.orange.banana";
        String[] parts = s.split("\\.");

        String s = "apple,orange;banana.grape";
        String[] parts = s.split("[,.;]");

        String s = "apple@orange#banana$grape"; // Split on ANY Special Character
        String[] parts = s.split("[^a-zA-Z0-9]+");

        String s = "hello@123#world!";  //      Split on All Non-Alphabet Characters
        String[] parts = s.split("[^a-zA-Z]+");

        public String reverseWordsNoStack(String s) {

            String[] words = s.trim().split("\\s+");
            StringBuilder result = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                result.append(words[i]).append(" ");
            }

            return result.toString().trim();
        }

        // TC: O(n)
        // SC: O(n)

        public String reverseWordsTwoPointer(String s) {

            StringBuilder result = new StringBuilder();
            int i = s.length() - 1;

            while (i >= 0) {

                while (i >= 0 && s.charAt(i) == ' ') i--;

                if (i < 0) break;

                int j = i;

                while (i >= 0 && s.charAt(i) != ' ') i--;


                result.append(s.substring(i + 1, j + 1)).append(" ");
            }

            return result.toString().trim();
        }

        // TC: O(n)
        // SC: O(1)

//// Largest Odd Number in a String:

        public String largestOddNumber(String num) {

            for (int i = num.length() - 1; i >= 0; i--) {

                int digit = num.charAt(i) - '0';

                if (digit % 2 != 0) {
                    return num.substring(0, i + 1);
                }
            }

            return ""; // no odd number found
        }

        // TC: O(n)
        // SC: O(1)

////Sort Characters by frequency: You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters. If two or more characters have same frequency then arrange them in alphabetic order.

        String str="raaaajj";

        public String frequencySortBrute(String s) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Character> list = new ArrayList<>(map.keySet());

            // brute force sorting
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {

                    char a = list.get(i);
                    char b = list.get(j);

                    if (map.get(b) > map.get(a) ||
                            (map.get(b).equals(map.get(a)) && b < a)) {

                        // swap
                        list.set(i, b);
                        list.set(j, a);
                    }
                }
            }

            return list.toString();
        }

        // TC: O(n + m^2)
        // SC: O(n)

        public String frequencySortBetter(String s) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Character> list = new ArrayList<>(map.keySet());

            Collections.sort(list, (a, b) -> {
                if (map.get(b).equals(map.get(a))) {
                    return a - b; // alphabetical
                }
                return map.get(b) - map.get(a); // frequency desc
            });

            return list.toString();
        }

        // TC: O(n + m log m)
        // SC: O(n)

        public String frequencySortOptimal(String s) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // bucket array
            List<Character>[] bucket = new List[s.length() + 1];

            for (char ch : map.keySet()) {
                int freq = map.get(ch);

                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<>();
                }

                bucket[freq].add(ch);
            }

            StringBuilder res = new StringBuilder();

            // traverse from high freq → low
            for (int i = bucket.length - 1; i >= 0; i--) {

                if (bucket[i] != null) {

                    // 🔥 sort alphabetically for same freq
                    Collections.sort(bucket[i]);

                    for (char ch : bucket[i]) {
                        for (int j = 0; j < i; j++) {
                            res.append(ch);
                        }
                    }
                }
            }

            return res.toString();
        }

        // TC: O(n)
        // SC: O(n)

////Check if one string is rotation of another

        s.substring(startIndex)
        s.substring(startIndex, endIndex)
        s.charAt(index)

        String s = "rotation", goal = "tionrota";


        public boolean rotateString(String s, String goal) {

            if (s.length() != goal.length()) return false;

            String str = s;

            for (int i = 0; i < s.length(); i++) {

                if (str.equals(goal)) return true;

                // rotate by 1
                str = str.substring(1) + str.charAt(0);
            }

            return false;
        }

        // TC: O(n^2)
        // SC: O(n)

        "A rotation is formed by repeatedly moving the first character to the end, generating n possible strings."

        public boolean rotateStringOptimal(String s, String goal) {

            return s.length() == goal.length() && (s + s).contains(goal);
        }

        // TC: O(n)
        // SC: O(n)

    The idea is that when a string is concatenated with itself, all possible rotations of the string will naturally appear as substrings within this concatenated string.

////Check if two Strings are anagrams of each other and also for unicode character:

        Two strings are called anagrams if:
        They contain the same characters with the same frequency, but possibly in a different order

        Arrays.equals() is used to compare two arrays: It returns true if both arrays: Have the same length and Contain same elements in same order. works for int[], char[], String[], arrays.

        String s1= "listen", s2= "silent";

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.equals(a, b));

        Sorting → O(n log n)
        Comparison → O(n)
        Total → O(n log n)

        public boolean isAnagram(String s1, String s2) {

            if (s1.length() != s2.length()) return false;

            int[] freq = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                freq[s1.charAt(i) - 'a']++;
                freq[s2.charAt(i) - 'a']--;
            }

            for (int f : freq) {
                if (f != 0) return false;
            }

            return true;
        }

        Unicode is a standard that assigns a unique number (code) to every character in every language.


        public boolean isAnagramUnicode(String s1, String s2) {

            if (s1.length() != s2.length()) return false;

            HashMap<Character, Integer> map = new HashMap<>();

            for (char ch : s1.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (char ch : s2.toCharArray()) {
                if (!map.containsKey(ch)) return false;

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }

            return map.isEmpty();
        }

        // TC: O(n)
        // SC: O(n)

        "For Unicode strings, we should use a HashMap instead of a fixed array since character range is large and may include multi-byte characters."

//// Isomorphic Strings:

        String s1="paper" , s2="title";
        String s1="badc"  , s2="baba";

        public static boolean areIsomorphic(String s1, String s2) {

            if (s1.length() != s2.length()) return false;

            int n = s1.length();

            for (int i = 0; i < n; i++) {

                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                for (int j = 0; j < n; j++) {

                    if (s1.charAt(j) == c1 && s2.charAt(j) != c2) {
                        return false;
                    }

                    if (s2.charAt(j) == c2 && s1.charAt(j) != c1) {
                        return false;
                    }
                }
            }
            return true;
        }

        //Time: O(n²)
        //Space: O(1)

//// To solve the Isomorphic Strings problem, the main idea is to check whether there exists a consistent one-to-one mapping between characters of the two strings. Instead of focusing on frequency or sorting, we focus on how each character in the first string maps to a character in the second string. First, we check if both strings have the same length; if not, they cannot be isomorphic. Then, we iterate through both strings simultaneously and try to build a mapping from characters of the first string to the second. While doing this, we must ensure two things: (1) a character in the first string always maps to the same character in the second string (consistency), and (2) no two different characters from the first string map to the same character in the second string (one-to-one mapping). This can be efficiently handled using two hash maps (or arrays) to track mappings in both directions. If at any point the mapping breaks these rules, we return false; otherwise, if we finish traversal without conflicts, the strings are isomorphic.

        public static boolean isIsomorphicOptimal(String s1, String s2) {

            if (s1.length() != s2.length()) return false;

            HashMap<Character, Character> map1 = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {

                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                if (map1.containsKey(c1) && map1.get(c1) != c2)
                    return false;

                if (map2.containsKey(c2) && map2.get(c2) != c1)
                    return false;

                map1.put(c1, c2);
                map2.put(c2, c1);
            }

            return true;
        }

//        Time: O(n)
//        Space = O(n) in general BUT becomes O(1) if character set is fixed

////String Compression:

//// This problem uses a two-pointer approach where one pointer (read) scans the array to count consecutive repeating characters, while another pointer (write) updates the array in place with the compressed result. For each group of identical characters, we write the character once and then, if the count is greater than one, we write the digits of the count individually. Since counts like 12 need to be stored as '1' and '2', we convert the count to a string and write each digit. This ensures the compression happens in-place using constant extra space, and the final length is tracked using the write pointer.

        public static int compressBrute(char[] chars) {

            StringBuilder sb = new StringBuilder();

            int i = 0;

            while (i < chars.length) {

                char current = chars[i];
                int count = 0;

                // count frequency
                while (i < chars.length && chars[i] == current) {
                    count++;
                    i++;
                }

                sb.append(current);

                if (count > 1) {
                    sb.append(count);
                }
            }

            // copy back to original array
            for (int k = 0; k < sb.length(); k++) {
                chars[k] = sb.charAt(k);
            }

            return sb.length();
        }

        // TC: O(n)
        // SC: O(n)

        public static int compress(char[] chars) {

            int write = 0;
            int read = 0;

            while (read < chars.length) {

                char current = chars[read];
                int count = 0;

                // count same characters
                while (read < chars.length && chars[read] == current) {
                    read++;
                    count++;
                }

                // write character
                chars[write++] = current;

                // write count if > 1
                if (count > 1) {
                    String cnt = String.valueOf(count);

                    for (char c : cnt.toCharArray()) {
                        chars[write++] = c;
                    }
                }
            }

            return write;

            // TC: O(n)
            // SC: O(1)
        }


////Count and Say:

 In the count-and-say problem, each step applies run-length encoding on the previous string, where consecutive characters are grouped and represented as count + character. For a single iteration, the logic runs in O(n) time because we traverse the string once using a pointer, even though there is a nested loop—the pointer moves forward and each character is processed only once. The resulting string in one iteration can grow up to 2n in the worst case (when all characters are different, like "abcd" → "1a1b1c1d"). However, the overall algorithm is not O(n) because we repeat this process n times, and the string length keeps increasing at each step. So the total time complexity depends on the sum of lengths of all generated strings, not just the initial size.

In theory, we use a safe upper bound of O(n · 2ⁿ) time and O(2ⁿ) space, assuming the string could double every iteration. But in reality, the sequence doesn’t grow that fast—it follows a known growth rate called Conway’s constant (~1.303), so the length of the nth string is closer to (1.303)ⁿ. That means the practical complexity is better and often expressed as O(Lₙ), where Lₙ is the length of the final string.

The O(n · 2ⁿ) comes from taking a safe worst-case upper bound on how the string length could grow across iterations.

In one iteration of run-length encoding, if the input string has length L, the output can be at most 2L. This happens in the worst case when all characters are different (for example, "abcd" → "1a1b1c1d"), so every character expands into two characters. Now, if you imagine this worst case happening at every step (even though it doesn’t in reality), the string length would double each time: L₁ = 1, L₂ ≤ 2, L₃ ≤ 4, L₄ ≤ 8 … so in general Lₙ ≤ 2ⁿ.

Since each iteration processes the entire current string, the work done at iteration i is proportional to Lᵢ, and the total time is: L₁ + L₂ + L₃ + ... + Lₙ

If we plug in the worst-case doubling: 1 + 2 + 4 + 8 + ... + 2ⁿ ≈ 2ⁿ

So strictly speaking, the total work is O(2ⁿ). Sometimes people write it as O(n · 2ⁿ) as a looser upper bound (since there are n iterations), but the tighter bound is O(2ⁿ).


        public static String countAndSayBrute(int n) {

            if (n == 1) return "1";

            String result = "1";

            for (int i = 2; i <= n; i++) {

                String next = "";

                for (int j = 0; j < result.length(); j++) {

                    char ch = result.charAt(j);
                    int count = 1;

                    // count consecutive characters using inner loop
                    while (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                        count++;
                        j++;
                    }

                    next = next + count + ch;  // ❌ string concatenation (costly)
                }

                result = next;
            }

            return result;

            // TC: O(Ln^2)
            // SC: O(Ln)
        }

        public static String countAndSay(int n) {

            String result = "1";

            for (int i = 1; i < n; i++) {

                StringBuilder next = new StringBuilder();

                int j = 0;

                while (j < result.length()) {

                    char ch = result.charAt(j);
                    int count = 0;

                    // count consecutive characters
                    while (j < result.length() && result.charAt(j) == ch) {
                        count++;
                        j++;
                    }

                    next.append(count);
                    next.append(ch);
                }

                result = next.toString();
            }

            return result;

            // TC: O(Ln)  ~ O(2^n) worst-case
            // SC: O(Ln)
        }

//// Integer to roman:

        int num=1994;

        public static String intToRoman(int num) {

            int[] base = {1000, 900, 500, 400, 100, 90, 50, 40,
                    10, 9, 5, 4, 1};

            String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                    "X", "IX", "V", "IV", "I"};

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < base.length; i++) {

                int q = num / base[i];   // how many times this value fits

                for (int j = 0; j < q; j++) {
                    sb.append(sym[i]);
                }

                num = num % base[i];     // reduce number
            }

            return sb.toString();

            // TC: O(1)
            // SC: O(1)
        }

////Check If Two String Arrays are Equivalent:

        word1 = ["ab", "c"], word2 = ["a", "bc"]

        public static boolean arrayStringsAreEqualBrute(String[] word1, String[] word2) {

            String s1 = "";
            String s2 = "";

            for (String w : word1) s1 += w;
            for (String w : word2) s2 += w;

            return s1.equals(s2);

            // TC: O(n + m)
            // SC: O(n + m)
        }

        public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

            int i = 0, j = 0; // pointers for arrays
            int p1 = 0, p2 = 0; // pointers inside strings

            while (i < word1.length && j < word2.length) {

                if (word1[i].charAt(p1) != word2[j].charAt(p2)) {
                    return false;
                }

                p1++;
                p2++;

                if (p1 == word1[i].length()) {
                    i++;
                    p1 = 0;
                }

                if (p2 == word2[j].length()) {
                    j++;
                    p2 = 0;
                }
            }

            return i == word1.length && j == word2.length;

            // TC: O(n + m)
            // SC: O(1)
        }

////OrderlyQueue:


"When we are allowed to swap any two characters, we can generate any permutation of the string, which means we can always reach the sorted (lexicographically smallest) string. However, in this problem, we are only allowed to move one of the first k characters to the end. The key observation is that when k ≥ 2, this operation gives us enough flexibility to simulate swaps between characters. For example, starting with "ceabd", we can perform a sequence of allowed operations like:
ceabd → cabde → abdec → bdeca → decab → ecabd,

which effectively moves 'e' in front of 'c', similar to swapping them. Since we can simulate such movements repeatedly, we can eventually rearrange the string into any desired order. Therefore, when k ≥ 2, we can achieve any permutation, including the sorted string.

k = 1 → only rotations → find minimum rotation
k ≥ 2 → can simulate swaps → sort string

“For k ≥ 2, we can simulate swaps using allowed operations, so any permutation is possible, hence sorting gives the answer.”
"

"The key insight is that when k == 1, you are only allowed to rotate the string, so you must check all possible rotations and pick the lexicographically smallest one. However, when k >= 2, you gain enough flexibility to rearrange the string in any order, which means the smallest possible string is simply the sorted version of the characters. This observation removes the need for simulation and leads to an optimal and clean solution."

        String s="baaca";

        public static String orderlyQueue(String s, int k) {

            // Case 1: Only rotations allowed
            if (k == 1) {

            String ans = s;

            for (int i = 1; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i);

                if (rotated.compareTo(ans) < 0) {
                    ans = rotated;
                }
            }

            return ans;
        }

        // Case 2: k >= 2 → full rearrangement possible
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);

        // TC: O(n^2) for k = 1, O(n log n) for k >= 2
        // SC: O(n)
}

Booth’s algorithm is specifically designed to find the smallest possible string that can be formed by rotating the given string. A rotation means taking some prefix of the string and moving it to the end. Instead of generating all rotations and comparing them (which takes O(n²)), Booth’s algorithm efficiently determines the starting index of the smallest rotation by skipping unnecessary comparisons, achieving this in O(n) time.

        public static String booth(String s) {

           String str = s + s;
            int n = s.length();

            int i = 0, j = 1, k = 0;

            while (i < n && j < n && k < n) {

                if (str.charAt(i + k) == str.charAt(j + k)) {
                    k++;
                }
                else if (str.charAt(i + k) > str.charAt(j + k)) {
                    i = i + k + 1;
                    if (i == j) i++;
                    k = 0;
                }
                else {
                    j = j + k + 1;
                    if (i == j) j++;
                    k = 0;
                }
            }

            int start = Math.min(i, j);
            return str.substring(start, start + n);

            // TC: O(n)
            // SC: O(n)
}

        public static String orderlyQueue(String s, int k) {

            // Case 1: k == 1 → use Booth (minimum rotation)
            if (k == 1) {
                return booth(s);
            }

            // Case 2: k >= 2 → sort

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);

        }

       // TC: O(n) for k=1, O(n log n) for k>=2
       // SC: O(n)

////Make String good:

     public String makeGood(String s) {

        String result = "";

        int i = 0;
        int j = -1;

        while (i < s.length()) {

            if (result.isEmpty() || Math.abs(result.charAt(j) - s.charAt(i)) != 32) {
                result += s.charAt(i);   // ❌ creates new string
                j++;
            } else {
                if (j > -1) {
                    result = result.substring(0, j); // ❌ creates new string
                }
                j--;
            }
            i++;
        }

        return result;

        // TC: O(n^2)
        // SC: O(n)
    }

    public String makeGood(String s) {

        StringBuilder stack = new StringBuilder();

           for (char ch : s.toCharArray()) {

            int n = stack.length();

            if (n > 0 && Math.abs(stack.charAt(n - 1) - ch) == 32) {
                stack.deleteCharAt(n - 1); // pop
            } else {
                stack.append(ch); // push
            }
        }

        return stack.toString();

        // TC: O(n)
        // SC: O(n)
}

"Instead of using a string, we use a StringBuilder to simulate a stack efficiently. We iterate through the input string, and for each character, we check the top of the stack (last character of StringBuilder). If they form a bad pair (difference of 32), we remove the top element; otherwise, we add the current character. This way, each character is processed once, and all operations (append/delete) are efficient, resulting in linear time complexity."

"The indexOf() method in Java is used to find the first occurrence of a character or substring inside a string. It returns the index (position) where the character or substring is found, and if it is not present, it returns -1."

//// Determine if Two Strings Are Close:

"The key intuition behind this problem is to understand what the allowed operations actually change and what they preserve. Since you can **swap any two characters**, the order of characters becomes irrelevant—you can rearrange the string however you want. The second operation allows you to **swap all occurrences of one character with another existing character**, which means you can redistribute frequencies among characters but only within the set of characters already present; you cannot introduce a new character. So, the problem reduces to checking two things: both strings must have the **same set of unique characters**, and the **frequencies of characters must match when considered as a group**, not tied to specific characters. For example, consider `word1 = "aabccc"` and `word2 = "bbbaac"`. In `word1`, the counts are `a=2, b=1, c=3` → frequencies `[2,1,3]`, and in `word2`, the counts are `b=3, a=2, c=1` → frequencies `[3,2,1]`. Even though different characters have different counts, if we sort both frequency lists we get `[1,2,3]` for both. Also, both strings use the same characters `{a, b, c}`. Because we can swap character identities (like turning all `a` into `b`, etc.), we can rearrange these counts to match, so the strings are considered **close**.

“Since swaps remove order dependency and character transformations allow frequency reassignment, we just need to check that both strings have the same character set and the same sorted frequency distribution.”
"

In brute force, we try to simulate all possible transformations using the allowed operations—swapping characters and transforming character types. This means generating all permutations and mappings, which leads to exponential complexity and is not feasible in practice. This approach only helps to understand that the problem is about transformations, not positions.


public static boolean closeStringsBetter(String w1, String w2) {

    if (w1.length() != w2.length()) return false;

    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();

    for (char c : w1.toCharArray()) {
        map1.put(c, map1.getOrDefault(c, 0) + 1);
    }

    for (char c : w2.toCharArray()) {
        map2.put(c, map2.getOrDefault(c, 0) + 1);
    }

    // check same character set
    if (!map1.keySet().equals(map2.keySet())) return false;

    // compare frequencies
    List<Integer> f1 = new ArrayList<>(map1.values());
    List<Integer> f2 = new ArrayList<>(map2.values());

    Collections.sort(f1);
    Collections.sort(f2);

    return f1.equals(f2);

    // TC: O(n log n)
    // SC: O(n)
}

public static boolean closeStrings(String w1, String w2) {

    if (w1.length() != w2.length()) return false;

    int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    for (char c : w1.toCharArray()) {
        freq1[c - 'a']++;
    }

    for (char c : w2.toCharArray()) {
        freq2[c - 'a']++;
    }

    // check same character set
    for (int i = 0; i < 26; i++) {
        if ((freq1[i] == 0 && freq2[i] != 0) ||
            (freq1[i] != 0 && freq2[i] == 0)) {
            return false;
        }
    }

    Arrays.sort(freq1);
    Arrays.sort(freq2);

    return Arrays.equals(freq1, freq2);

    // TC: O(n + 26 log 26) ≈ O(n)
    // SC: O(1)
}

"The Better approach (using HashMap) is written in a general way, assuming characters could be anything (not just lowercase English letters). Because of that, the number of unique characters can go up to n in worst case, so storing frequencies takes O(n) space, and sorting the frequency list also takes O(n log n) time. However, in this specific problem, we are guaranteed that the string contains only lowercase English letters (a–z), which means there are at most 26 unique characters. Because of this constraint, both the space and sorting cost become constant, and the complexity effectively reduces."

" IF different characters are allowed"

If different characters are allowed, then you can think of characters as just labels that can be renamed freely. So instead of focusing on which character is which, you only care about how many times each character appears. Imagine you have buckets with some number of balls (frequencies). You don’t care about the names of the buckets—you can rename them—but the number of balls in each bucket must match. So if both strings have the same frequency pattern (like one has counts [1,2,3] and the other also has [1,2,3]), then you can always rename characters to make them equal. But if the frequency patterns are different (like [2,2] vs [1,3]), then no amount of renaming will help.

“Ignore characters, only match frequency counts.”


"


*/
    }
}
