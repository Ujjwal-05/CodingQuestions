package Coding;

public class P2StringQuestions {
    public static void main(String[] args) {

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

//// Longest Common Prefix:
//        String[] input = {"interview", "internet", "internal", "interval"};

//        if (input == null || input.length == 0) return;
//        String prefix = input[0];
//        if (prefix == null) return;
//
//        for(int i=1;i<input.length;i++){
//
//            while (!input[i].startsWith(prefix)){
//                prefix=prefix.substring(0,prefix.length()-1);
//            }
//
//            if(prefix.isEmpty()){
//                System.out.println("No Prefix Found");
//                return;
//            }
//        }
//        System.out.println("LCP is " + prefix);

//        Arrays.sort(input);
//        String first=input[0];
//        String last=input[input.length-1];
//        StringBuilder ans =new StringBuilder();
//
//        for(int i=0;i<Math.min(first.length(),last.length());i++){
//
//            if(first.charAt(i)!=last.charAt(i)) break;
//            ans.append(first.charAt(i));
//        }
//
//        System.out.println(ans.toString());



//// str.substring(beginIndex), str.substring(beginIndex, endIndex);



    }
}
