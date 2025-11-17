package Coding;

import java.util.ArrayList;
import java.util.Arrays;
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

        String s1= "listen", s2= "silent";

//        char[] a= s1.toCharArray();
//        char[] b=s2.toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);

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



//        System.out.println(Arrays.equals(a,b));










    }
}
