package Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Strings {
    public static void main(String[] args) {

//// Remove Outermost Paranthesis:
//
//        int count=0;
//        for(Character c: str.toCharArray()){
//            if(c=='('){
//                if(count>0) sb.append(c);
//                count++;
//            }else {
//                count--;
//                if(count>0) sb.append(c);
//            }
//        }

////Reverse Words in a String
//        String str="  This is decent ";
//        List<String> wordList=new ArrayList<>();
//        for(int index = 0; index <str.length();){
//
//            while(index <str.length() && str.charAt(index)==' ') index++;
//
//            if(index<str.length()){
//
//                StringBuilder currentword= new StringBuilder();
//                while (index<str.length() && str.charAt(index)!=' '){
//                    currentword.append(str.charAt(index));
//                    index++;
//                }
//
//                wordList.add(currentword.toString());
//            }
//
//        }
//
//        List<String> reversed = wordList.reversed();
//
//        System.out.println(String.join(" ",reversed));

//// Largest Odd Number in a String.
//        String str = "00000";
//        int left = 0, right = str.length() - 1;
//
        // Move right pointer to the last odd digit
//        while (right >= 0 && (str.charAt(right) - '0') % 2 == 0) {
//            right--;
//        }
//
        // If no odd digit exists
//        if (right == -1) {
//            System.out.println("No Substring found");
//        } else {
//            // Skip leading zeros
//            while (left < right && str.charAt(left) == '0') {
//                left++;
//            }
//
//            System.out.println(str.substring(left, right + 1));
//        }

//// Longest Common Prefix
        String[] input = {"interview", "internet", "internal", "interval"};

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
//        String first=input[0], last=input[input.length-1];
//        StringBuilder ans =new StringBuilder();
//
//        for(int i=0;i<Math.min(first.length(),last.length());i++){
//
//            if(first.charAt(i)!=last.charAt(i)) break;
//            ans.append(first.charAt(i));
//        }
//
//        System.out.println(ans.toString());

////Check if one string is rotation of another
        String s = "rotation", goal = "tionrota";
//        if(s.length()!=goal.length()) return;
//
//        for (int i=0;i<s.length();i++){
//            String rotated= s.substring(i) + s.substring(0,i);
//            if (rotated.equals(goal)) break;
//        }

        // Another approach O(n)
//        if(s.length()==goal.length() && (s+s).contains(goal)){
//            System.out.println("yes");
//        }


////Check if two Strings are anagrams of each other and also for unicode character:

//        String s1= "listen", s2= "silent";

//        if(s1.length()!=s2.length()) return;
//        char[] a= s1.toCharArray();
//        char[] b=s2.toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);

//        if(s1.length()!=s2.length()) return;
//        char[] frequency=new char[26];
//
//        for(int i=0;i<s1.length();i++){
//            frequency[s1.charAt(i)-'a']++;
//        }
//        for (int i=0;i<s2.length();i++){
//            frequency[s2.charAt(i)-'a']--;
//        }
//        for(int i=0;i<frequency.length;i++){
//            if(frequency[i]==1) return;
//        }
//        System.out.println("Yes");

//// Isomorphic String:

//        String s1="egg", s2="add";
//
//        if(s1.length()!=s2.length()) return;
//
//        int[] map1= new int[256];
//        int[] map2= new int[256];
//
//        for(int i=0;i<s1.length();i++){
//
//            if(map1[s1.charAt(i)]!=map2[s2.charAt(i)]) return;
//
//            map1[s1.charAt(i)]=i+1;
//            map2[s2.charAt(i)]=i+1;
//        }

//// Sort characters by frequency

//        String str="aazzzbbdcf";
//        HashMap<Character, Integer> map=new HashMap<>();
//
//        for(int i=0;i<str.length();i++){
//            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
//        }
//
//        List<Character> list= new ArrayList<>(map.keySet());
//
//        list.sort((a,b)->{
//            int freqA= map.get(a);
//            int freqB=map.get(b);
//
//            if(freqA!=freqB) return freqB-freqA;
//            return a-b;
//        });
//
//        System.out.println(list);

//// Longest Palindromic Substring:

//        String str="baabd";
//        int length=-1;
//        for(int i=0;i<str.length();i++){
//            for(int j=i;j<str.length();j++){
//                length=Math.max(palindrome(str.substring(i,j+1)),length);
//            }
//        }
//        System.out.println(length);

//        int start=0,end=0;
//
//        for(int centre=0; centre<str.length(); centre++){
//
//            int oddLength=expandFromCentre(str,centre,centre);
//            int evenLength=expandFromCentre(str,centre,centre+1);
//            int maxLen=Math.max(oddLength,evenLength);
//
//            if(maxLen>end-start){
//                start=centre-(maxLen-1)/2;
//                end=centre + (maxLen)/2;
//            }
//        }
//        System.out.println(str.substring(start,end+1));

        String str="aabbb";

        int[] freq=new int[26];
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;

        for(char c:str.toCharArray()){

            int f= ++freq[c-'a'];
            min=Math.min(min,f);
            max=Math.max(max,f);

        }































    }

    private static int expandFromCentre(String str, int left, int right) {

        while ( left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static int palindrome(String str){
        int left=0;
        int right=str.length()-1;
        while (left<right){
            if(str.charAt(left)!=str.charAt(right)) return -1;
            left++;
            right--;
        }
        return str.length();
    }
}
