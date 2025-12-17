package Coding;

//Find pairs with given sum in sorted array:

import java.util.*;

class Pair{
    double distance;
    int index;

    public Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}

class Node<T>{
    T data;
    Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    Node<T> createnodes(List<T> nums) {

        if (nums.isEmpty()) return null;

        Node<T> head = new Node<>(nums.get(0));
        Node<T> temp = head;

        for (int i = 1; i < nums.size(); i++) {
            temp.next = new Node<>(nums.get(i));
            temp = temp.next;
        }

        return head;
    }
}

public class Array {
    public static boolean canPlace ( int[] stalls, int cows, int d){

        int count = 1;
        int lastposition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastposition >= d) {
                count++;
                lastposition = stalls[i];
            }
            if (count >= cows) return true;
        }
        return false;
    }

    public static Node reverselinkedlist(Node head){
        Node prev=null;
        Node curr=head;

        while (curr!=null){
            Node front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }

        return prev;
    }


    public static void main(String[] args) {
        System.out.println("Happy Coding");

////Reverse a number or Check palindrome.
//        int num=121;
//        int reversed=0, temphead=num;
//
//        while(temphead>0){
//            reversed=reversed*10 + temphead%10;
//            temphead/=10;
//        }

//// Check num is Armstrong or not:
//        static boolean isArmstrong(int num) {
//            int original = num;
//            int digits = String.valueOf(num).length();
//            int sum = 0;
//
//            while (num > 0) {
//                int rem = num % 10;
//                sum += (int) Math.pow(rem, digits);
//                num /= 10;
//            }
//            return sum == original;
//        }

////Second Largest element in the from the array:
//        int [] arr= {10,8,5,4,3,9};
//        int largest=Integer.MIN_VALUE;
//        int second_larget=Integer.MIN_VALUE;
//
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>largest){
//                second_larget=largest;
//                largest=arr[i];
//            } else if (arr[i]<largest && arr[i]>second_larget){
//                second_larget=arr[i];
//            }
//        }

//// Find the duplicate elemet in the array:
//// Remove duplicates from the sorted array:
//        int [] arr= {1,2,2,2,2,2,3,3,3,4,5,5};
//        int left=0;
//
//        for(int right=1;right<arr.length;right++){
//            if(arr[left]!=arr[right]){
//                left++;
//                arr[left]=arr[right];;
//            }
//        }

//// Find the missing number in array:
//// Left rotate array by d place:
//        int [] a={1,2,3,4,5};
//        int k =3;
//
//        Reverse(a,0,k-1);
//        Reverse(a,k,a.length-1);
//        Reverse(a,0,a.length-1);

//        static void Reverse(int[] a, int start, int end) {
//            while (start < end) {
//                int temp = a[start];
//                a[start] = a[end];
//                a[end] = temp;
//                start++;
//                end--;
//            }
//        }

////Find the number that appears once, and other numbers twice.
//
//        int[] arr={1,1,2,2,3,3,4,4,5,5,6};
//        int res=0;
//
//        for (int num:arr){
//            res=res^num;
//        }

//// Moves zero to end and preserve the order:
//        int [] arr={0,5,5,1,0,0,0,1,2,3,0,0,4,5,0,0};
//
//        int left=-1;
//        for(int right=0;right<arr.length;right++){
//
//            if(arr[right]==0){
//                if(left==-1) {
//                    left = right;
//                }
//            }else {
//                if(left!=-1){
//                    arr[left]=arr[right];
//                    arr[right]=0;
//                    left++;
//                }
//            }
//        }

////Leader in array problem:

////// Rearrange Array elements by sign.
//        int[] arr = { -7, -1, 5, -3, 6, 4};
//        int[] res = new int[arr.length];
//
//        int pos=0,neg=1;
//
//        for(int num:arr){
//            if(num>0){
//                res[pos]=num;
//                pos+=2;
//            }
//            else {
//                res[neg]=num;
//                neg+=2;
//            }
//
//        }

////Java programme to print distinct element in UnSorted/Sorted array.
////Print duplicate elements in Sorted/Unsorted array:

////Find pairs with given sum in sorted array:
//        int arr[] = {1,1,2,2,3,4,4,5,6,7,8}; int k = 9;

//        int left = 0, right = arr.length - 1;
//        while (left < right) {
//            int sum = arr[left] + arr[right];
//
//            if (sum == k) {
//                System.out.println(arr[left] + " " + arr[right]);
//
//                // Skip duplicates for left
//                int currentLeft = arr[left];
//                while (left < right && arr[left] == currentLeft) left++;
//
//                // Skip duplicates for right
//                int currentRight = arr[right];
//                while (left < right && arr[right] == currentRight) right--;
//
//            } else if (sum > k) {
//                right--;
//            } else {
//                left++;
//            }
//        }

////Find Unique pairs with given sum in Unsorted array:
//        int arr[] = {1,1,2,2,3,4,4,5,6,7,8,0,9};  int k = 9;

//        Set<Integer> set = new HashSet<>();
//        Set<String> printed = new HashSet<>();
//
//        for (int num : arr) {
//            int complement = k - num;
//
//            if (set.contains(complement)) {
//                int a = Math.min(num, complement);
//                int b = Math.max(num, complement);
//
//                if (printed.add(a + "," + b)) {
//                    System.out.println(a + " " + b);
//                }
//            }
//
//            set.add(num);
//        }


//// Find common element in three or two sorted array:
//        int[] a ={1,2,3,4,5};
//        int[] b ={2,3,4,5,6};
//        int[] c ={3,4,5,6,7};
//
//        int i=0,j=0,k=0;
//
//        while (i<a.length && j<b.length && k<c.length){
//
//            if(a[i]==b[j] && b[j]==c[k]){
//                System.out.println(a[i]);
//                i++;
//                j++;
//                k++;
//            } else if (a[i]<b[j]) {i++;}
//            else if (b[j]<c[k]) {j++;}
//            else {k++;}
//
//            }

//// Find common element in three  unsorted array:
//
//        int[] a={2,8,7,5,4,6,6};
//        int[] b={5,2,7,3,9,1,5};
//        int[] c={1,7,2,5,6,4,5};
//
//        Set<Integer> set1=new HashSet<>();
//        for(int num: a){
//            set1.add(num);
//        }
//
//        Set<Integer> set2=new HashSet<>();
//        for(int num: b){
//            if(set1.contains(num)){
//                set2.add(num);
//            }
//        }
//
//        Set<Integer> set3=new HashSet<>();
//        for(int num: c){
//            if(set2.contains(num)){
//                set3.add(num);
//            }
//
//        }
//
//        for(int nums: set3 ){
//            System.out.println(nums);
//        }

//// Delete an element from array via position:
//        int[] a={1,2,3,4,5};
//        int k=5;
//
//        for(int i=k-1;i<a.length-1;i++){
//            a[i]=a[i+1];
//        }
//
//        a[a.length-1]=-1;
//
//        for(int nums: a){
//            System.out.println(nums);
//        }

//// Given an array of 0 and 1, arrange them left side array contain 0 and right side 1:
//
//        int[] a={0,1,1,0,0,0,1,0,1,1,0};
//        int left=0, right=a.length-1;
//
//        while(left<right){
//
//            while(a[left]==0 && left<right){
//                left++;
//            }
//            while (a[right]==1 && left<right){
//                right--;
//            }
//
//            if(left<right) {
//                int temphead = a[left];
//                a[left] = a[right];
//                a[right] = temphead;
//
//                left++;
//                right--;
//            }
//
//        }
//        for (int nums: a){
//            System.out.print(nums);
//        }
//
//        System.out.println();

////Find the union of the 2 sorted array and result should be sorted:
//
//        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
//
//        ArrayList<Integer> union = new ArrayList<>();
//        int i = 0, j = 0;
//
//        while (i < arr1.length && j < arr2.length) {
//            if (arr1[i] < arr2[j]) {
//                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
//                    union.add(arr1[i]);
//                }
//                i++;
//            } else if (arr1[i] > arr2[j]) {
//                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
//                    union.add(arr2[j]);
//                }
//                j++;
//            } else {
//                // arr1[i] == arr2[j], add one of them
//                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
//                    union.add(arr1[i]);
//                }
//                i++;
//                j++;
//            }
//        }
//
//        while (i < arr1.length) {
//            if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
//                union.add(arr1[i]);
//            }
//            i++;
//        }
//
//        while (j < arr2.length) {
//            if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
//                union.add(arr2[j]);
//            }
//            j++;
//        }

////Longest Subarray with given Sum K(Positives)
//
//        int[] a = {2,3,5,0,0,0,9,0};
//        int k = 10;
//        int i=0,j=0,sum=0,length=0;
//        while (j<a.length){
//            sum+=a[j];
//
//            while (sum>k && i<j){
//                sum-=a[i];
//                i++;
//            }
//            if(sum==k){
//                length=Math.max(length,j-i+1);
//            }
//            j++;
//        }

////Longest Subarray with given Sum K(Positives+Negatives):
//        int[] arr={2, 3, -4, 5, 0, 4, -2, 2}; int k=10;

//        int i=0,j=0,sum=0,length=0;
//        HashMap<Integer,Integer> hashMap=new HashMap<>();
//        hashMap.put(0, -1);
//        for(i=0;i<a.length;i++){
//            sum+=a[j];
//
//            if(hashMap.containsKey(sum-k)){
//                int len= i-hashMap.get(sum-k);
//                length=Math.max(len,length);
//            }
//
//            if (sum == k) {
//                length = Math.max(length, i + 1);
//            }
//
//            hashMap.putIfAbsent(sum, i);

////Longest Subarray with Equal Number of 0s and 1s.
//        int[] arr = {0, 1, 0, 1, 1, 0, 0};

//        int maxLen = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int zero = 0;
//            int one = 0;
//
//            for (int j = i; j < arr.length; j++) {
//                if (arr[j] == 0) zero++;
//                else one++;
//
//                if (zero == one) {
//                    maxLen = Math.max(maxLen, j - i + 1);
//                }
//            }
//        }

//        HashMap<Integer,Integer> map=new HashMap<>();
//        int sum=0;
//        map.put(0, -1); // handle subarray starting at index 0
//
//        for (int i = 0; i < arr.length; i++) {
//            sum += (arr[i] == 0 ? -1 : 1);
//
//            if (map.containsKey(sum)) {
//                int len = i - map.get(sum);
//                maxLen = Math.max(maxLen, len);
//            }
//            map.putIfAbsent(sum, i);
//        }

////Largest Subarray with Equal Number of 0s, 1s, and 2s.
//        int c0=0,c1=0,c2=0, d10=0,d20=0;
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("0#0",-1);
//        for (i = 0; i < arr.length; i++) {
//            if(arr[i]==0) c0++;
//            else if (arr[i]==1) c1++;
//            else c2++;
//
//            d10=c1-c0;
//            d20=c2-c0;
//
//            String key= d10 + "#" + d20;
//
//            if(map.containsKey(key)){
//                length=Math.max(length,i-map.get(key));
//            }
//            map.putIfAbsent(key,i);
//        }

//// Two Sum: Given an unsorted array of integers arr[] and an integer target, find any pair of elements whose sum equals target.

//        int[] arr = {2, 7, 11, 15};
//        int k = 9;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//
//        for (int num : arr) {
//            int rem = k - num;
//
//            if (map.containsKey(rem)) {
//                count += map.get(rem);  // count all occurrences
//            }
//
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        System.out.println("Total pairs = " + count);


////Sort an array of 0s, 1s and 2s:
//
//        int[] arr={1,0,2,2,2,1,1,1,0,0,0,1,1,1,2,2,2,2};
//        int low=0, mid=0,high=arr.length-1;
//        while (mid<=high){
//            if(arr[mid]==0){
//                int temp=arr[low];
//                arr[low]=arr[mid];
//                arr[mid]=temp;
//                low++;
//                mid++;
//            } else if (arr[mid]==1) {
//                mid++;
//            }else {
//                int temphead=arr[mid];
//                arr[mid]=arr[high];
//                arr[high]=temphead;
//                high--;
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));

////  Return an element that occurs more than N/2 times:
//        int[] arr={2,3,5,0,0,0,0,0};
//        int n = arr.length;
//
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//
//            // Count occurrences of arr[i]
//            for (int j = 0; j < n; j++) {
//                if (arr[j] == arr[i]) {
//                    count++;
//                }
//            }
//
//            // Check if it occurs more than N/2 times
//            if (count > n / 2) {
//        System.out.println(arr[i]);
//            }
//        }

//        int count=0, max_element=-1;
//
//        for (int i=0;i<arr.length;i++){
//            if(count==0){
//                count=1;
//                max_element=arr[i];
//            } else if (max_element==arr[i]) {
//                count++;
//            }else {
//                count--;
//            }
//
//        }
//
//        int count1=0;
//        for(int num:arr){
//            if(num==max_element){
//                count1++;
//            }
//        }
//
//        if(count1>Math.floor(arr.length/2)){
//            System.out.println(max_element);
//        }else {
//
//            System.out.println(-1);
//
//        }

////Return an element that occurs more than N/3 times:
//        int[] arr={2,1,1,3,1,4,5,6};

//        Set<Integer> ans= new HashSet<>();
//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int num : arr){
//            map.put(num,map.getOrDefault(num,0)+1);
//
//            if(map.get(num)>arr.length/3){
//                ans.add(num);
//            }
//
//            if(ans.size()==2) break;
//        }

//        int e1=-1, e2=-1, cnt1=0, cnt2=0;
//
//        for(int num:arr){
//            if(cnt1==0 && num!=e2){
//                e1=num;
//                cnt1++;
//            } else if (cnt2==0 && num!=e1) {
//                e2=num;
//                cnt2++;
//            } else if (num==e1) cnt1++;
//            else if (num==e2) cnt2++;
//            else {
//                cnt1--;
//                cnt2--;
//        }
//        }
//        // Step 2: Verify actual counts
//        cnt1 = 0;
//        cnt2 = 0;
//        for (int num : arr) {
//            if (num == e1) cnt1++;
//            else if (num == e2) cnt2++;
//        }
//

//// Step 3: Collect results
//        List<Integer> res = new ArrayList<>();
//        if (cnt1 > arr.length / 3) res.add(e1);
//        if (cnt2 > arr.length / 3) res.add(e2);
//
//
//        System.out.println(res);

////Maximum subarray Sum( find the contiguous subarray (containing at least one number) which has the largest sum):
//        int[] arr = { -2, -1, 3, 4, -1, 2,-1};

//        int max_sum=Integer.MIN_VALUE;
//        int sum=0,j=0;
//        for(int i=0;i<arr.length;i++) {
//            sum += arr[i];
//
//            if(sum>max_sum){
//                max_sum=sum;
//                length=i-j+1;
//            }
//
//            if(sum<0){
//                sum=0;
//                j=i+1;
//            }
//        }
//        System.out.println(max_sum);

//// Stock buy or sell
//        int[] arr = { 7, 1, 5, 3, 6, 4};
//        int min=arr[0];
//        int profit=0, current_profit=0;
//
//        for(int i=1;i<arr.length;i++) {
//
//            current_profit=arr[i]-min;
//
//            profit=Math.max(current_profit,profit);
//
//            if(min>arr[i]){
//                min=arr[i];
//            }
//        }
//

////Maximum Product sub array. with (+ve,0)/ (+ve,-ve,0):
//        int[] arr = {2, -1, 2, -1, 6, 4};

//        int min_prod=arr[0];
//        int max_prod=arr[0];
//        int ans=arr[0];
//
//        for( i=1;i<arr.length;i++){
//            int curr=arr[i];
//            if(curr<0){
//                int temp=max_prod;
//                max_prod=min_prod;
//                min_prod=temp;
//            }
//
//            max_prod=Math.max(curr,max_prod*curr);
//            min_prod=Math.min(curr,min_prod*curr);
//
//            ans=Math.max(max_prod,ans);
//        }
//
//        System.out.println(ans);


////Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//        int[] arr = {100, 4, 200, 1, 3, 2, 2};
//        int maxlen = 0;
//
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : arr) set.add(num);
//
//        for (int num : set) {
//            if (!set.contains(num - 1)) { // start of a sequence
//                int curr = num;
//                int len = 1; // reset for each new sequence
//
//                while (set.contains(++curr)) {
//                    len++;
//                }
//
//                maxlen = Math.max(maxlen, len);
//            }
//        }
//
//        System.out.println(maxlen);

////Product of Array Except Self.
//        int[] nums = {1, 2, 3, 4,5};

//        int res[] =new int[nums.length];
//        res[0]=1;
//        // prefix
//        for(int i=1;i<nums.length;i++){
//            res[i]=res[i-1]*nums[i-1];
//        }
//
//        int suffix=1;
//        for(int i=nums.length-1;i>=0;i--){
//            res[i]*=suffix;
//            suffix*=nums[i];
//        }
//
//        System.out.println(java.util.Arrays.toString(res));

////Next Permutation:

//// 3 Sum Problem: Find three numbers in an array whose sum equals a given target:
//        int[] arr = {-1, 0, 1, 2, -1, -4};
//        int k=0;
//        List<List<Integer>> res= new ArrayList<>();
//        Arrays.sort(arr);
//        // [-4, -1, -1, 0, 1, 2]
//        for(int i=0;i<arr.length-2;i++){
//
//            if(i>0 && arr[i]==arr[i-1]) continue;
//
//            int left=i+1;
//            int right=arr.length-1;
//
//            while (left<right){
//                int sum=arr[i] + arr[left] +arr[right];
//
//                if(sum==k){
//                    res.add(Arrays.asList(arr[i],arr[left],arr[right]));
//
//                    while (left<right && arr[left]==arr[left+1]) left++;
//                    while (left<right && arr[right]==arr[right-1]) right--;
//
//                    left++;
//                    right--;
//                } else if (sum>k) {
//                    right--;
//                }else {
//                    left++;
//                }
//            }
//            System.out.println(res);

//// Merge Overlapping intervals:
//        int[][] intervals = {
//                {1, 3}, {2, 6},{1,9},{0,100} ,{8, 10}, {15, 18}
//        };
//        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
//        System.out.println(Arrays.deepToString(intervals));
//
//        int i=0;
//        List<List<Integer>> ans=new ArrayList<>();
//
//        while (i<intervals.length){
//            int start=intervals[i][0];
//            int end=intervals[i][1];
//
//            int j=i+1;
//
//            while(j<intervals.length && intervals[j][0]<=end){
//                end=Math.max(end,intervals[j][1]);
//                j++;
//            }
//            ans.add(Arrays.asList(start,end));
//            i=j;
//        }
//
//        System.out.println(ans);

////Merge two sorted array Without Extra Space:
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
//        int index = 0;
//        List<String> ans = new ArrayList<>();
//
//        while (index < str.length()) {
//            // skip spaces
//            while (index < str.length() && str.charAt(index) == ' ') index++;
//
//            // collect word
//            StringBuilder currentWord = new StringBuilder();
//            while (index < str.length() && str.charAt(index) != ' ') {
//                currentWord.append(str.charAt(index));
//                index++;
//            }
//
//            if (currentWord.length() > 0) {
//                ans.add(currentWord.toString());
//            }
//        }
//
//        // reverse list
//        Collections.reverse(ans);
//
//        System.out.println(String.join(" ", ans));

//// Largest Odd Number in a String:
//        String str = "1245788";
//        int left = 0, right = str.length() - 1;
//
        // Move right pointer to the last odd digit
//        while (right >= 0 && (str.charAt(right) - '0') % 2 == 0) {
//            right--;
//        }
//
//        // If no odd digit exists
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

////Sort Characters by frequency: You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.
/// If two or more characters have same frequency then arrange them in alphabetic order.
//        String str="raaaajj";

//        Map<Character, Integer> freq = new HashMap<>();
//        for (char c : str.toCharArray()) {
//            freq.put(c, freq.getOrDefault(c, 0) + 1);
//        }
//
//        List<Character> result = new ArrayList<>(freq.keySet());
//
//        result.sort((a, b) -> {
//            if (!freq.get(a).equals(freq.get(b))) {
//                return freq.get(b) - freq.get(a); // higher freq first
//            }
//            return a - b; // lexicographical order when freq is same
//        });
//
//        System.out.println(result);

////Implement Atoi:

////Sum of Beauty of all substring: The beauty of a string is defined as the difference between the frequency of the most frequent character and
////the least frequent character (excluding characters that do not appear) in that string.
//        String s="aabcbaa";
//
//        int n = s.length(), sum = 0;
//        for (int i = 0; i < n; i++) {
//            Map<Character, Integer> freq = new HashMap<>();
//
//            for (int j = i; j < n; j++) {
//                // Increase character frequency
//                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
//
//                int maxi = Integer.MIN_VALUE;
//                int mini = Integer.MAX_VALUE;
//
//                // Calculate max and min frequency
//                for (int val : freq.values()) {
//                    mini = Math.min(mini, val);
//                    maxi = Math.max(maxi, val);
//                }
//                sum += (maxi - mini);
//            }
//        }

//// str.substring(beginIndex), str.substring(beginIndex, endIndex);
////Check if one string is rotation of another
//        String s = "rotation", goal = "tionrota";
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

//        char[] a= s1.toCharArray();
//        char[] b=s2.toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);
//        System.out.println(Arrays.equals(a,b));

//        char[] frequency=new char[26];
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

//// Longest Substring Without Repeating Characters: Given a string, S. Find the length of the longest substring
//// without repeating characters.
//        String str = "takeUforward";

//        int maxlen=0;
//        for(int i=0;i<str.length();i++){
//            HashSet<Character> set=new HashSet<>();
//            for(int j=i;j<str.length();j++){
//                Character c=str.charAt(j);
//                if(set.contains(c)) break;
//                set.add(c);
//                maxlen=Math.max(maxlength,j-i+1);
//            }
//        }

//        int left=0,maxlen=0;
//        HashMap<Character,Integer> map=new HashMap<>();
//        for(int right=0;right<str.length();right++){
//            Character c=str.charAt(right);
//            if(map.containsKey(c) && map.get(c)>=left){
//                int lastseenindex=map.get(c);
//                left=lastseenindex+1;
//            }
//            map.put(c,right);
//            maxlen=Math.max(maxlen,right-left+1);
//        }

//// Maximum Consecutive ones: Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
//// if you can flip at most k 0's.
//        int nums[] = {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1}; int k = 3;

//        int maxLen=0,n=nums.length;
//        for (int i = 0; i < n; i++) {
//            int zeroes = 0;
//            for (int j = i; j < n; j++) {
//                if (nums[j] == 0) zeroes++;
//                if (zeroes > k) break; // window invalid
//                maxLen = Math.max(maxLen, j - i + 1);
//            }
//        }

//        int zeroes=0,left=0;
//        for(int right=0;right<n;right++){
//
//            if(nums[right]==0) zeroes++;
//
//            if(zeroes>k){
//                if(nums[left]==0) zeroes--;
//                left++;
//            }
//
//            maxLen=Math.max(maxLen,right-left+1);
//        }

////Fruit Into Baskets or Also known as: Longest Subarray with at most 2 distinct elements:
//        int nums[]={1,1,0,2,2,1,1,2,2,0,0,1}; int k=2;

//        int maxlen=0;
//        for(int i=0;i<n;i++){
//            HashSet<Integer> set=new HashSet<>();
//            for(int j=i;j<n;j++){
//                set.add(nums[j]);
//                if(set.size()>k) break;
//                maxlen=Math.max(maxlen,j-i+1);
//            }
//        }

//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int right=0;right<n;right++){
//            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
//
//            while (map.size()>k){
//                map.put(nums[left],map.get(nums[left])-1);
//                if(map.get(nums[left])==0){
//                    map.remove(nums[left]);
//                }
//                left++;
//            }
//
//            maxlen=Math.max(maxlen,right-left+1);
//        }
//        System.out.println(maxlen);

////Longest repeating character replacement: Length of the longest substring where you can make all characters equal after
////at most k replacements.
//      String str="ABBC"; int k=2;

//        int maxlen=0;
//        for(int i=0;i<str.length();i++){
//            int[] freq=new int[26];
//            int maximum=0;
//            for(int j=i;j<str.length();j++){
//                Character c=str.charAt(j);
//                freq[c-'A']++;
//                maximum=Math.max(maximum,freq[c-'A']);
//                int windowsize=j-i+1;
//                if(windowsize-maximum<=k){
//                    maxlen=Math.max(maxlen,j-i+1);
//                }
//            }
//        }

//        while (right < str.length()) {
//
//            freq[s.charAt(right) - 'A']++;
//            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
//            while ((right - left + 1) - maxCount > k) {
//                freq[s.charAt(left) - 'A']--;
//                left++;
//            }
//
//            maxLength = Math.max(maxLength, right - left + 1);
//            right++;
//        }

////Maximum point you can obtain from cards: Given N cards arranged in a row, each card has an associated score denoted by the
////cardScore array. Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row.
////The score is the sum of the scores of the chosen cards.
//        int[] cards = {5, 4, 1, 8, 7, 1, 3}; int k = 3;

//        int n=cards.length-1, maxsum=0;
//        for(int front=0;front<=k;front++){
//            int back=k-front;
//            int sum=0;
//
//            for(int i=0;i<front;i++) sum+=cards[i];
//            for(int i=0;i<back;i++) sum+=cards[n-1-i];
//
//            maxsum=Math.max(maxsum,sum);
//        }

//        int total=0,n=cards.length;
//        for(int i=0;i<k;i++){
//            total+=cards[i];
//        }
//        int maximum=total;
//        for(int i=0;i<k;i++){
//
//            total-=cards[k-1-i];
//            total+=cards[n-1-i];
//
//            maximum=Math.max(maximum,total);
//        }

//// Longest Substring with At Most K Distinct Characters: Given a string s and an integer k.Find the length of the longest
//// substring with at most k distinct characters
//        String str="aababbcaacc"; int k = 2;

//        int maxlen=0;
//        for(int i=0;i<str.length();i++){
//            HashSet<Character> set=new HashSet<>();
//            for (int j=i;j<str.length();j++){
//                Character c=str.charAt(j);
//                set.add(c);
//
//                if(set.size()>k) break;
//
//                maxlen=Math.max(maxlen,j-i+1);
//            }
//        }

//        int left=0; //aababbcaacc
//        HashMap<Character,Integer> map=new HashMap<>();
//        for(int right=0;right<str.length();right++){
//            map.put(str.charAt(right),map.getOrDefault(str.charAt(right),0)+1);
//
//            while (map.size()>k){
//                map.put(str.charAt(left),map.get(str.charAt(left))-1);
//                if(map.get(left)==0){
//                    map.remove(str.charAt(left));
//                }
//                left++;
//            }
//
//            maxlen=Math.max(maxlen,right-left+1);     }

////Number of substring containing all three characters: Given a string s consisting only of characters 'a', 'b', 'c'.
////Find the number of substrings that contain at least one occurrence of all these characters 'a', 'b', 'c'.
//        String str="ccabcc";

//        int count=0;
//        for(int i=0;i<str.length();i++){
//            int [] freq=new int[3];
//            for(int j=i;j<str.length();j++){
//                freq[str.charAt(j)-'a']++;
//                if(freq[0]>=1 && freq[1]>=1 && freq[2]>=1){
//                    count++;
//                }
//            }
//        }

//        int [] freq=new int[3];
//        int n=str.length(),left=0;
//        for(int right=0;right<str.length();right++){
//
//            freq[str.charAt(right)-'a']++;
//
//            while (freq[0]>0 && freq[1]>0 && freq[2]>0){
//                count+=n-right;
//                freq[str.charAt(left) - 'a']--;
//                left++;
//            }}

//// Count Subarrays with Given Sum K (Positives + Negatives).
        // 5,0,0,1,4
//        int length=0;
//        HashMap<Integer,Integer> map=new HashMap<>();
//        map.put(0,1);
//
//        for(i=0;i<a.length;i++){
//            sum+=a[i];
//
//            if(map.containsKey(sum-k)){
//                length+=map.get(sum-k);
//            }
//
//            map.put(sum,map.getOrDefault(sum,0)+1);
//        }

////Binary subarray with sum: You are given a binary array nums (containing only 0s and 1s) and an integer goal.Return the
//// number of non-empty subarrays of nums that sum to goal. A subarray is a contiguous part of the array.
//        int[] nums = {1, 0, 0, 1, 1, 0}; int goal = 2;

//        int count=0;
//        for(int i=0;i<nums.length;i++){
//            int sum=0;
//            for(int j=i;j<nums.length;j++){
//                sum+=nums[j];
//                if(sum==goal) count++;
//       }}

//        int right=0,left=0,sum=0;
//        HashMap<Integer,Integer> map=new HashMap<>();
//        map.put(0,1);
//        while (right<nums.length){
//            sum+=nums[right];
//
//            int rem=sum-goal;
//
//            if(map.containsKey(rem)){
//                count+=map.get(rem);
//            }
//            map.put(sum,map.getOrDefault(sum,0)+1);
//            right++;
//        }

////Count number of nice subarrays: An array is called nice if and only if it contains k odd numbers. Find the number of nice subarrays
////in the given array nums. A subarray is continuous part of the array.
//        int [] nums={1,1,2,1,1,1}; int k=3;

//        int count=0;
//        for(int i=0;i<nums.length;i++){
//            int odd=0;
//            for(int j=i;j<nums.length;j++){
//
//                if(nums[j]%2==1) odd++;
//                if(odd==k) count++;
//                if(odd>k) break;
//            }
//        }

//        int oddCount=0,count=0;
//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int num:nums){
//            if(num%2==1) oddCount++;
//            int rem=oddCount-k;
//
//            if(map.containsKey(rem)){
//                count+=map.get(rem);
//            }
//
//            map.put(oddCount,map.getOrDefault(oddCount,0)+1);
//        }

//// Count Substring with At Most K Distinct Characters:
//        public static int countAtMostKDistinct(String s, int k) {
//            int left = 0, count = 0;
//            Map<Character, Integer> map = new HashMap<>();
//
//            for (int right = 0; right < s.length(); right++) {
//
//                char c = s.charAt(right);
//                map.put(c, map.getOrDefault(c, 0) + 1);
//
//                // shrink window if more than k distinct
//                while (map.size() > k) {
//                    char leftChar = s.charAt(left);
//                    map.put(leftChar, map.get(leftChar) - 1);
//                    if (map.get(leftChar) == 0) {
//                        map.remove(leftChar);
//                    }
//                    left++;
//                }
//
//                // all windows ending at 'right' contribute (right - left + 1) substrings
//                count += right - left + 1;
//            }
//
//            return count;


//// Subarray with k different integers: Return the number of good subarrays of nums. A good subarray is defined as a contiguous subarray
///  of nums that contains exactly k distinct integers. A subarray is a contiguous part of the array.
//        int[] nums = {1, 2, 1, 2, 3}; int k = 2;

//        int count=0;
//        for(int i=0;i<nums.length;i++){
//            HashSet<Integer> set=new HashSet<>();
//            for(int j=i;j<nums.length;j++){
//                set.add(nums[j]);
//                if(set.size()>k) break;
//                if(set.size()==k){
//                    count++;
//                }
//            }
//        }

//        public static int subarraysWithKDistinct(int[] nums, int k) {
//            return atMost(nums, k) - atMost(nums, k - 1);
//        }
//
//        private static int atMost(int[] nums, int K) {
//            int left = 0, count = 0;
//            HashMap<Integer, Integer> map = new HashMap<>();
//
//            for (int right = 0; right < nums.length; right++) {
//                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
//
//                while (map.size() > K) {
//                    map.put(nums[left], map.get(nums[left]) - 1);
//                    if (map.get(nums[left]) == 0) {
//                        map.remove(nums[left]);
//                    }
//                    left++;
//                }
//                count += right - left + 1;
//            }
//            return count;
//        }

////Count Number of Substrings: You are given a string s and a positive integer k. Return the number of substrings that contain exactly k distinct characters.
//        public static int substringsWithKDistinct(String s, int k) {
//            return atMostK(s, k) - atMostK(s, k - 1);
//        }
//
//        private static int atMostK(String s, int k) {
//            int left = 0, count = 0;
//            Map<Character, Integer> map = new HashMap<>();
//
//            for (int right = 0; right < s.length(); right++) {
//
//                char c = s.charAt(right);
//                map.put(c, map.getOrDefault(c, 0) + 1);
//
//                // shrink window until we have ≤ k distinct chars
//                while (map.size() > k) {
//                    char leftChar = s.charAt(left);
//                    map.put(leftChar, map.get(leftChar) - 1);
//                    if (map.get(leftChar) == 0) map.remove(leftChar);
//                    left++;
//                }
//
//                // all substrings ending at `right` with start in [left..right] are valid
//                count += right - left + 1;
//            }
//
//            return count;
//        }

//// Count number of subarrays whose product is less than equal to k:
//        int[] nums={10,5,2,6}; int k=100;
//        if (k <= 0) return;
//
//        int left = 0;
//        long prod = 1;
//        int count = 0;
//
//        for (int right = 0; right < nums.length; right++) {
//            prod *= nums[right];
//
//            while (prod > k && left <= right) {
//                prod /= nums[left];
//                left++;
//            }
//
//            count += (right - left + 1);
//        }


//// Minimum Window Substring: Given two strings s and t. Find the smallest window substring of s that includes all characters in t
//// (including duplicates), order doesn't matter in the window. Return the empty string "" if no such substring exists.

//        String s = "ADOBECODEBAANC";
//        String t = "ABCA";
//        int minlength=Integer.MAX_VALUE, start_index=-1;
//
//        int[] hash=new int[256];
//        for(int i=0;i<t.length();i++){
//            hash[t.charAt(i)]++;
//        }
//
//        for(int i=0;i<s.length();i++){
//            int[] frequency= hash.clone();
//            int matchedCount=0;
//            for(int j=i;j<s.length();j++){
//                Character c=s.charAt(j);
//
//                if(frequency[c]>0) matchedCount++;
//
//                frequency[c]--;
//
//                if(matchedCount==t.length()){
//                    if(minlength>j-i+1){
//                        start_index=i;
//                        minlength=j-i+1;
//                    }
//                    break;
//                }
//            }
//        }
//
//        if(start_index==-1) System.out.println("");
//        System.out.println(s.substring(start_index,start_index+minlength));

//        int[] hash = new int[256];
//        for (int i = 0; i < t.length(); i++) {
//            hash[t.charAt(i)]++;
//        }
//
//        int left = 0, start = -1;
//        int minlength = Integer.MAX_VALUE;
//        int matchedCount = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//
//            char c = s.charAt(right);
//
//            if (hash[c] > 0) matchedCount++; // needed char matched
//            hash[c]--; // consume
//
//            // window valid
//            while (matchedCount == t.length()) {
//
//                // update minimum
//                if (right - left + 1 < minlength) {
//                    minlength = right - left + 1;
//                    start = left;
//                }
//
//                char leftChar = s.charAt(left);
//
//                // if removing it makes us lose a needed char
//                if (hash[leftChar] >= 0) matchedCount--;
//
//                hash[leftChar]++;  // release
//                left++;
//            }
//        }
//
//        if (start == -1) {
//            System.out.println(""); // no valid window
//        } else {
//            System.out.println(s.substring(start, start + minlength));
//        }
//    }
//}

////Minimum window subsequence:

//        private static boolean isSubsequence(String s1, String s2) {
//            int i = 0, j = 0;
//            while (i < s1.length() && j < s2.length()) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    j++;
//                }
//                i++;
//            }
//            return j == s2.length();
//        }

//        String s1="abcde";
//        String s2="abd";
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//
//                int windowLen = j - i + 1;
//
//                // 1️⃣ If window is already bigger than best, skip
//                if (windowLen >= minLen) continue;
//
//                // 2️⃣ If window is smaller than s2, skip
//                if (windowLen < s2.length()) continue;
//
//                String sub = s1.substring(i, j + 1);
//
//                // 3️⃣ Check subsequence
//                if (isSubsequence(sub, s2)) {
//                    minLen = windowLen;
//                    result = sub;
//                    break; // leftmost minimal window for this i
//                }
//            }
//        }
//
//        return result;
//    }

////Longest Palindromic Substring[Do it without DP]: Given a string s, return the longest palindromic substring in s.


//0 1 2 3 4 5 6
//1 2 3 4 5 6 0
//2 3 4 5 6 0 1
//3 4 5 6 0 1 2
//4 5 6 0 1 2 3
//5 6 0 1 2 3 4
//6 0 1 2 3 4 5
//0 1 2 3 4 5 6

//// Binary Search to find X in sorted array:
//        int[] a = {3, 4, 5, 7, 9, 12, 16, 17}; int target = 6;
//
//        int low =0,high=a.length-1;
//
//        while (low <=high){
//            int mid=(low +high)/2;
//            if(target==a[mid]){
//                System.out.println(target);
//                return;
//            } else if (target>a[mid]) {
//                low=mid+1;
//            }else {
//                high=mid-1;
//            }
//        }

//// Lower Bound: The smallest index in a sorted array where the value at that index is greater than or equal to a given key.
//// Upper Bound: The smallest index in a sorted array where the value at that index is greater than the given key.
//        int[] arr = {3, 4, 5, 7, 9, 12, 16, 17}; int target = 1;
//        int low=0,high=arr.length-1,ans=arr.length;

//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(arr[mid]>=target){
//                ans=mid;
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }

//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(arr[mid]>target){
//                ans=mid;
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }


//// Search Insert Position: You are given a sorted array arr of distinct values and a target value x. You need to search
//// for the index of the target value in the array.
//        int[] arr = {3, 4, 5, 7, 9, 12, 16, 17}; int target = 100;
//
//        int low=0,high=arr.length-1,ans=arr.length;
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if (arr[mid] >= target) {
//                // Potential answer found, try to go left
//                ans = mid;
//                high = mid - 1;
//            } else {
//                // Go right
//                low = mid + 1;
//            }
//        }

//// Find the first or last occurrence of a given number in a sorted array:
//        int[] arr = {3, 4, 5, 7, 7, 7, 7, 9, 12, 16, 17}; int target = 9;
//
//        int low=0,high=arr.length-1,ans=arr.length;
//        int first=-1,last=-1;
//        while (low<=high) {
//            int mid = (low + high) / 2;
//
//            if(arr[mid]==target){
//                first=mid;
//                high=mid-1;
//            } else if (arr[mid]>target) {
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }
//
//        low=0;high=arr.length-1;
//        while (low<=high) {
//            int mid = (low + high) / 2;
//
//            if(arr[mid]==target){
//                last=mid;
//                low=mid+1;
//            } else if (arr[mid]>target) {
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }

//// Search Element in a Rotated Sorted Array:
        // In rotated sorted array we are not sure which half is sorted so we have to find which half is sorted out of two:
        // But it is sure that one half will always be sorted.
//        int[] arr = {4, 5, 6, 7, 0, 1, 2}; int k = 0;
//        int low=0,high= arr.length-1, ans=-1;
//
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(arr[mid]==k){
//                ans=mid;
//                break;
//            } else if (arr[low]<=arr[mid]) {  // left half part sorted
//                if(arr[low]<=k && k<=arr[mid]){
//                    high=mid-1;
//                }else {
//                    low=mid+1;
//                }
//            }else {     // Right half is sorted
//                if(arr[mid]<=k && k<=arr[high]){
//                    low=mid+1;
//                }else {
//                    high=mid-1;
//                }
//            }
//        }
//        System.out.println(ans);

//// Search Element in Rotated Sorted Array II: contain duplicate values:
//        When the array contains duplicates, the usual method of identifying the sorted half in a rotated sorted array no longer works.
//        Normally, we compare arr[low],arr[mid], and arr[high] to decide whether the left or right half is sorted. This logic fails when
//        arr[low] == arr[mid] == arr[high], because all three values are identical, making it impossible to determine which side is sorted
//        and where the pivot might be hidden. If arr[mid] is not equal to the target, then arr[low] and arr[high] also cannot be the target
//        because they have the same value as arr[mid]. This means the search boundaries are not helpful and only block progress. Therefore,
//        in this situation, we trim the search space by doing low++ and high--. This removes the duplicate values at both ends, allowing the
//        binary search to continue and eventually expose a portion of the array where the sorted-half logic can correctly determine the direction of search again.

//        int[] arr = {3,1,3 ,3,3,3}; int k = 3;
//        int low=0,high= arr.length-1, ans=-1;
//        while (low<=high) {
//            int mid = (low + high) / 2;
//            if (arr[mid] == k){
//            ans=mid;
//              break;
//            }
//
//            // Handle duplicates: cannot determine sorted side
//            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
//                low++;
//                high--;
//                continue;
//            }
//
//            if (arr[low] <= arr[mid]) {
//                if (arr[low] <= k && k <= arr[mid]) {
//                    high = mid - 1; // Search left
//                } else {
//                    low = mid + 1;  // Search right
//                }
//            } else {
//                if (arr[mid] <= k && k <= arr[high]) {
//                    low = mid + 1;  // Search right
//                } else {
//                    high = mid - 1; // Search left
//                }
//            }
//        }

//// Minimum in Rotated Sorted Array: contain distinct values:
//In a rotated sorted array with distinct values, we follow the same principle used in binary search: at every step we process the middle, decide which half
// cannot contain the answer, and **eliminate that half. Since in a rotated array one half is always sorted, we use that to guide elimination.
// If the left half is sorted (nums[low] <= nums[mid]), then the minimum cannot be inside this sorted portion except possibly at nums[low], so we record nums[low]
// as a candidate and discard the entire left half, continuing on the right. If instead the right half is sorted (nums[mid] <= nums[high]), then the minimum cannot
// be anywhere in that sorted right portion except possibly at nums[mid], so we record nums[mid] as a candidate and discard the entire right half, continuing on the left.
// By consistently identifying the sorted half, picking its smallest element, and removing it—just like binary search eliminates one side after processing—we
// narrow the search to the unsorted (rotated) portion, which always contains the true minimum.
//        int arr[]={4,5,6,7,0,0,1,2,3};
//
//        int low=0,high=arr.length-1, min=Integer.MAX_VALUE;
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(arr[low]<=arr[mid]){
//                min=Math.min(min,arr[low]);
//                low=mid+1;
//            }else {
//                min=Math.min(min,arr[mid]);
//                high=mid-1;
//            }
//        }

//// Find out how many times the array has been rotated: FIND THE MINIMUM ELEMENT INDEX:
//        int arr[]={4,5,6,0,0,1,2,3};
//
//        int low=0,high=arr.length-1, min=Integer.MAX_VALUE,index=-1;
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(arr[low]<=arr[mid]){
//                if(arr[low]<min){
//                    index=low;
//                    min=arr[low];
//                }
//                low=mid+1;
//            }else {
//                if(arr[mid]<min){
//                    index=mid;
//                    min=arr[mid];
//                }
//                high=mid-1;
//            }
//        }
//        System.out.println(index);

////Search Single Element in a sorted array
//        int[] arr = {1,1,2,3,3,4,4,8,8};
//
//        int singleNonDuplicate(int[] arr) {
//            int n = arr.length;
//            // Edge cases
//            if (n == 1) return arr[0];
//            if (arr[0] != arr[1]) return arr[0];
//            if (arr[n - 1] != arr[n - 2]) return arr[n - 1];
//
//            int low = 1, high = n - 2; // exclude boundaries already checked
//            while (low <= high) {
//                int mid = (low + high) / 2;
//                // If mid itself is the unique
//                if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
//                    return arr[mid];
//                }
//                // Use pairing check: mid^1 flips last bit (even->mid+1, odd->mid-1)
//                if (arr[mid] == arr[mid ^ 1]) {
//                    // pairing intact -> unique is to the right
//                    low = mid + 1;
//                } else {
//                    // pairing broken -> unique is to the left
//                    high = mid - 1;
//                }
//            }
//            // Theoretically unreachable if input guarantees exactly one single element
//            return -1;
//        }

////Peak element in Array:

//A peak element is one that is strictly greater than its neighbors, and because the array can contain many ups and downs,
// we can use binary search to find a peak efficiently. At any index mid, there are two important observations:
// If arr[mid] < arr[mid + 1], then we are on an ascending slope, meaning a peak must exist somewhere to the right,
// so we shift low = mid + 1. If arr[mid] > arr[mid + 1], then we are on a descending slope, meaning a peak must exist
// on the left, so we move high = mid. The reason this works is that whenever the slope ascends, it must eventually fall at
// some point, creating a peak, and similarly on a descent, the peak lies behind us. By continuously eliminating half of the
// array based on the slope we observe at mid, we narrow down the search window until low == high, which must be a peak index.
// This gives us an O(log n) time solution using binary search instead of scanning linearly.
//       int arr[] = {1,2,3,4,5,6,7,8,5,1};
//
//       int n=arr.length, peak=-1;
//       if(n==1) System.out.println(arr[0]);
//       if(arr[0]>arr[1]) System.out.println(arr[0]);
//       if(arr[n-1]>arr[n-2]) System.out.println(arr[n-1]);
//
//       int low=1, high=n-2;
//       while (low<=high){
//           int mid=(low+high)/2;
//
//           if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
//               peak=arr[mid];
//               break;
//           }
//           else if (arr[mid-1] < arr[mid]) {
//               low=mid+1;
//           }else {
//               high=mid-1;
//           }
//       }
//        System.out.println(peak);

////Finding Sqrt of a number using Binary Search:
//        int num=36;
//
//        if(num<2) return;
//        int low=1, high=num/2, ans=-1;
//
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(mid*mid== num){
//                ans=mid;
//            } else if (mid*mid <num) {
//                ans=mid;
//                low=mid+1;
//            }else {
//                high=mid-1;
//            }
//        }
//        System.out.println(ans);

////Find the Nth root of a number using binary search: Find x where x^4 = 16 x^n=m
//        int n=4,m=16;
//        int low=1,high=m;
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            int ans=1;
//            for (int i=0;i<n;i++){
//                ans=ans*mid;
//                if(ans>m) break;
//            }
//
//            if(ans==m) System.out.println(mid);;
//
//            if(ans>m){
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }
//        System.out.println(-1);

////Koko Eating Bananas:
//        int piles[] = {7, 15, 6, 3}; int h = 8;

//        int maxPile= Arrays.stream(piles).max().getAsInt();
//        for(int i=1;i<=maxPile;i++){
//            int total=0;
//
//            for(int pile:piles){
//                total+=Math.ceilDiv(pile,i);
//            }
//
//            if(total<=h){
//                System.out.println(i);
//                break;
//            }
//        }

//        int low=1,high=Arrays.stream(piles).max().getAsInt();
//        int ans=-1;
//
//        while (low<=high){
//            int mid=(low+high)/2;
//            int total=0;
//
//            for(int pile:piles){
//                total+=Math.ceilDiv(pile,mid);
//            }
//
//            if(total<=h){
//                ans=mid;
//                high=mid-1;
//            } else {
//                low=mid+1;
//            }
//
//        }
//        System.out.println(ans);

//// Minimum days to make M bouquets:
//        int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
//        int minimum_flower = 3;
//        int bouquets  = 2;
//
//        if(bloomDays.length<minimum_flower*bouquets ) return;
//
//        int mindays= Arrays.stream(bloomDays).min().getAsInt();
//        int maxdays=Arrays.stream(bloomDays).max().getAsInt();
//
//        for(int days=mindays;days<=maxdays;days++){
//            int count=0,total=0;
//            for(int bloomday:bloomDays){
//                if(days>=bloomday){
//                    count++;
//                    if(count==minimum_flower){
//                        total++;
//                        count=0;
//                    }
//                }else {
//                    count=0;
//                }
//            }
//            if(total>=bouquets){
//                System.out.println(days);
//                break;
//            }
//        }

//        int m = 3;int k  = 2;
//        if(bloomDays.length<m*k ) return;
//        int low= Arrays.stream(bloomDays).min().getAsInt();
//        int high=Arrays.stream(bloomDays).max().getAsInt();
//        int ans=0;
//
//        while (low<=high){
//            int mid=(low+high)/2;
//            int total=0, count=0;
//
//            for(int days:bloomDays){
//                if(mid>=days){
//                    count++;
//                    if(count==m){
//                        total++;
//                        count=0;
//                    }
//                }else {
//                    count=0;
//                }
//            }
//            if(total>=k) {
//                ans=mid;
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//
//        }
//        System.out.println(ans);

////Find the smallest Divisor:

////Capacity to Ship Packages within D Days:
//        int[] weights = {5,4,5,2,3,4,5,6}; int d = 5;

//        int min_capacity=Arrays.stream(weights).max().getAsInt();
//        int max_capacity=Arrays.stream(weights).sum();
//
//        for(int i=min_capacity;i<=max_capacity;i++){
//            int capacity=i;
//            int right=0,days=0;
//            while (right<weights.length){
//
//                if(capacity>=weights[right]){
//                    capacity=capacity-weights[right];
//                    right++;
//                }else {
//                    capacity=i;
//                    days++;
//                }
//            }
//              days + 1: You increment days++ only when you start a NEW day. But after you finish the entire array,
//              the current day is not counted yet, because the last partial day never triggered the else block.
//            if(days+1<=d){
//                System.out.println(i);
//                break;
//            }
//        }         //(high-low)*N

//        int low=Arrays.stream(weights).max().getAsInt();
//        int high=Arrays.stream(weights).sum();
//        int ans=0;
//        while (low<=high) {
//            int mid = (low + high) / 2;
//
//            int capacity = mid;
//            int right = 0, days = 0;
//            while (right < weights.length) {
//                if (capacity >= weights[right]) {
//                    capacity = capacity - weights[right];
//                    right++;
//                } else {
//                    capacity = mid;
//                    days++;
//                }
//            }
//
//            if(days+1<=d){
//                ans=mid;
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }    // O(log(high-low)*N)

//// Difference between maxofmin vs minofmax Approach:
//Both problems use Binary Search on Answer, but the direction, logic, and monotonic behaviour are opposite.
//        Aggressive Cows → max of minimum
//        If you can place all cows with distance = X,
//        You can also place them with any distance < X
//        But NOT with distance > X
//        if(canPlace(X)):
//        low = X + 1     // try larger distance
//        else:
//        high = X - 1    // reduce distance
//        Final Answer: ans = largest X that works

//        Allocate Minimum Pages: min of maximum
//        If it is possible to allocate with maxPages = X,
//        It is also possible with any X > X (looser constraint)
//        But NOT with X < X
//        if(canAllocate(X)):
//        ans = X
//        high = X - 1    // try smaller max pages
//        else:
//        low = X + 1     // need more pages allowed
//        Final Answer: ans = smallest X that works

//        Why the search direction flips?
//        Aggressive Cows: If X is possible, try bigger low = mid + 1
//        If distance X works → we try bigger
//        increasing is good → move right
//        Allocate Books: If X is possible, try smaller high = mid - 1
//        If pages X works → we try smaller
//        decreasing is good → move left

//        Both Aggressive Cows and Allocate Minimum Pages use the same technique—Binary Search on Answer + a feasibility check—but they work in opposite directions
//        because the optimization goals are different. Aggressive Cows is a max-of-min problem: we want to maximize the minimum distance between any two cows.
//        If a distance X is feasible (we can place all cows greedily), then every distance < X is also feasible, but distances > X may not be.
//        This monotonic behavior pushes the search upwards, so when placement works, we move low = mid + 1 to try a larger distance;
//        the final answer is the largest feasible X. In contrast, Allocate Minimum Pages is a min-of-max problem: we want to minimize the maximum pages given to a student.
//        If a maximum limit X is feasible (books can be allocated contiguously within X pages), then any limit > X is also feasible, but limits < X may fail.
//        This monotonic behavior pushes the search downwards, so when allocation works, we move high = mid - 1 to try reducing the limit;
//        the final answer is the smallest feasible X. In short, Aggressive Cows increases the answer when feasible (maximize a minimum), whereas Allocate Pages
//        decreases the answer when feasible (minimize a maximum)—same binary-search pattern, opposite search direction due to opposite optimization goals.

//        Min-of-max → low = max element, high = sum
//        Max-of-min → low = 1, high = maximum gap

//        Min-of-Max:
//        low  = minimum possible maximum = max(arr)
//        high = overall maximum = sum(arr)

//        Max-of-Min:
//        low  = minimum possible minimum = 1
//        high = maximum possible minimum = max(arr) - min(arr)

//// Aggressive Cows: maxofmin You are given the task of assigning stalls to 'k' cows such that
//// the minimum distance between any two of them is the maximum possible. Find the maximum possible minimum distance.

//        int[] stalls = {1, 2, 8, 4, 9}; int cows = 3;
//        Arrays.sort(stalls);
//
//        int min=1; int max=stalls[stalls.length-1];
//        int ans=-1;
//
//        for(int i=min;i<=max;i++){
//
//            if(canPlace(stalls, cows, i)){
//                ans=i;
//            }
//        }
//        System.out.println(ans);

//        int low=1, high=stalls[stalls.length-1];
//        Arrays.sort(stalls);
//        int ans=-1;
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            if(canPlace(stalls,cows,mid)){
//                ans=mid;
//                low=mid+1;
//            }else {
//                high=mid-1;
//            }
//        }

//// Book Allocation Problem: Allocate Minimum Number of Pages: minofmax You have to allocate the book to ‘m’ students such that
////the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1
//        int[] arr = {25, 46, 28, 49, 24}; int n = 5; int m = 4;

//        int min=Arrays.stream(arr).max().getAsInt();
//        int max=Arrays.stream(arr).sum();
//        for(int i=min;i<=max;i++){
//            int right=0;
//            int pages=i;
//            int students_who_got_book=0;
//
//            while (right<arr.length){
//                if(pages>=arr[right]){
//                    pages-=arr[right];
//                    right++;
//                }else {
//                    students_who_got_book++;
//                    pages=i;
//                }
//            }
//
//            if(students_who_got_book+1==m){
//                System.out.println(i);
//                break;
//            }
//        }

//        int low=Arrays.stream(arr).max().getAsInt();
//        int high=Arrays.stream(arr).sum();
//        int ans=0;
//        while (low<=high){
//            int mid=(low+high)/2;
//
//            int right=0;
//            int pages=mid;
//            int students_who_got_book=0;
//
//            while (right<arr.length){
//                if(pages>=arr[right]){
//                    pages-=arr[right];
//                    right++;
//                }else {
//                    students_who_got_book++;
//                    pages=mid;
//                }
//            }
//
//            if(students_who_got_book+1<=m){
//                ans=mid;
//                high=mid-1;
//            }else {
//                low=mid+1;
//            }
//        }
//
//        System.out.println(ans);

////Split Array - Largest Sum:
//      int  arr[] = {7,2,5,10,8}; int k = 2;
//
//        int low = Arrays.stream(arr).max().getAsInt();   // minimum possible max sum
//        int high = Arrays.stream(arr).sum();             // maximum possible max sum
//
//        for(int i=low;i<=high;i++){
//            int right=0;
//            int currsum=i;
//            int subarrays=0;
//            while (right<arr.length){
//
//                if(currsum>=arr[right]){
//                    currsum-=arr[right];
//                    right++;
//                }else {
//                    currsum=i;
//                    subarrays++;
//                }
//            }
//
//            if(subarrays+1==k){
//                System.out.println(i);
//                break;
//            }
//        }

//        int low = Arrays.stream(arr).max().getAsInt();  // smallest possible max subarray sum
//        int high = Arrays.stream(arr).sum();            // largest possible max subarray sum
//        int ans = -1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//
//            int subarrays = 1;
//            int currentSum = 0;
//            for (int num : arr) {
//                if (currentSum + num <= mid) {
//                    currentSum += num;      // continue adding to current subarray
//                } else {
//                    subarrays++;            // need new subarray
//                    currentSum = num;
//                }
//            }
//
//            if (subarrays <= k) {
//                ans = mid;          // mid works → try smaller max sum
//                high = mid - 1;
//            } else {
//                low = mid + 1;      // mid too small → need bigger max sum
//            }
//        }
//        System.out.println(ans);

//// Painter's Partition:

//// Minimise the Maximum Distance between Gas Stations:
//        int[] arr = {1, 2, 3, 4, 5}; int k = 4;

//        int[] sections = new int[arr.length - 1];
//
//        for (int gasstation = 1; gasstation <= k; gasstation++) {
//
//            double maxsectionlength = -1;
//            int maxsectionlengthindex = -1;
//            for (int i = 0; i < arr.length - 1; i++) {
//
//                double difference = arr[i + 1] - arr[i];
//                double sectionlength = difference / (sections[i] + 1.0);
//
//                if (maxsectionlength < sectionlength) {
//                    maxsectionlength = sectionlength;
//                    maxsectionlengthindex = i;
//                }
//            }
//
//            sections[maxsectionlengthindex]++;
//        }
//
//        double ans = -1;
//        for (int i = 0; i < arr.length - 1; i++) {
//            double difference = arr[i + 1] - arr[i];
//            double currsectionlength = difference / (sections[i] + 1.0);
//            ans = Math.max(ans, currsectionlength);
//        }
//        System.out.println(ans);  // O(n*k)

////        PriorityQueue<Integer> pq=new PriorityQueue<>();
////
////        pq.add(1);      // Adds the element into the priority queue.
////        pq.add(2);
////        pq.add(3);
////
////        System.out.println(pq.peek());  // returns the first element
////        System.out.println(pq.poll());  // returns and remove element
////
////        pq.offer(1);
////        System.out.println(pq);

//        int[] sections = new int[arr.length - 1];
//        PriorityQueue<Pair> pq =new PriorityQueue<>(
//                (a,b)->Double.compare(b.distance,a.distance)
//        );
//
//        for(int i=0;i< arr.length-1;i++){
//            pq.add(new Pair(arr[i+1]-arr[i],i));
//        }
//
//        for(int gasstation=1;gasstation<=k;gasstation++){
//
//            Pair top=pq.poll();
//            int index= top.index;
//            sections[index]++;
//
//            double totaldistance =arr[index+1] - arr[index];
//            double newdistance= totaldistance/(sections[index] + 1.0);
//            pq.add(new Pair(newdistance,index));
//        }
//
//        System.out.println(pq.peek().distance);

//// Median of 2 sorted arrays:
//        int[] a = {2,4,6};  int[] b = {1,3,5};

//        List<Integer> list=new ArrayList<>();
//        int i=0,j=0;
//
//        while (i<a.length && j<b.length){
//
//            if(a[i]<b[j]){
//                list.add(a[i++]);
//            }else {
//                list.add(b[j++]);
//            }
//        }
//
//        while (i<a.length){ list.add(a[i++]);}
//        while (j<b.length){ list.add(b[j++]);}
//
//        int size=list.size();
//
//        if(size%2==0){
//            System.out.println((list.get(size/2)+list.get((size/2)-1))/2.0);
//        }else {
//            System.out.println(list.get(size/2));
//        }

//        int size=a.length + b.length;
//
//        int index2=size/2;
//        int index1=index2-1;
//
//        int e1=-1,e2=-1, elementcount=0;
//        int i=0,j=0;
//
//        while (i<a.length && j<b.length){
//            if(a[i]<b[j]){
//                if(elementcount==index1) e1=a[i];
//                if(elementcount==index2) e2=a[i];
//                i++;
//            }else {
//                if(elementcount==index1) e1=b[j];
//                if(elementcount==index2) e2=b[j];
//                j++;
//            }
//            elementcount++;
//        }
//
//        while (i<a.length){
//            if(elementcount==index1) e1=a[i];
//            if(elementcount==index2) e2=a[i];
//            i++;
//            elementcount++;
//        }
//
//        while (j<b.length){
//            if(elementcount==index1) e1=b[j];
//            if(elementcount==index2) e2=b[j];
//            j++;
//            elementcount++;
//        }
//
//        if(size%2==1){
//            System.out.println( e2 );
//        }else {
//            System.out.println((e1+e2)/2.0);
//        }

////Binary search approach:

//// Kth element of 2 sorted arrays:

////LinkedList:

        Node<Integer> obj = new Node<>(0, null); // dummy object to call method
        List<Integer> listnodes = Arrays.asList(2, 3, 4, 5, 6);
        Node<Integer> head = obj.createnodes(listnodes);
        Node<Integer> head2 = obj.createnodes(listnodes);


// Insertion at Head:
        Node newnode=new Node<>(1);
        newnode.next=head;
        head=newnode;

//// Deletion at end:
//        Node curr=head;
//        while (curr.next.next!=null){
//            curr=curr.next;
//        }
//        curr.next=null;

//// Length of the linked list and find an element:
//        Node curr=head;
//        int length=0, element=6;
//        while (curr!=null){
//            if(curr.data==Integer.valueOf(element)) {
//                System.out.println("Element Found:" + element);
//            }
//            length++;
//            curr=curr.next;
//        }
//        System.out.println("Lenght of List:" + length);

//// Middle of linked list:

//        Node slow=head;
//        Node fast=head; for 2nd middle in even length case
//        Node fast=head.next; for 1st middle in even length case
//
//        while (fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//
//        System.out.println(slow.data);

////Reverse a Linked List:

//        Node prev=null;
//        Node curr=head;
//
//        while (curr!=null){
//
//            Node front= curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=front;
//        }

////Detect a Cycle/loop in a Linked List:

////In Floyd’s Cycle Detection (Tortoise–Hare) algorithm, we move one pointer one step at a time and the other two steps at a time to create a speed difference that
//// helps detect the presence of a loop efficiently. If there is no cycle in the linked list, the fast pointer, because it moves twice as quickly, will eventually reach
//// the end of the list and become null, confirming that the list is linear. However, if a cycle exists, both pointers will eventually meet because once they are inside
//// the loop, the fast pointer keeps closing the gap between itself and the slow pointer.
//// Assume at some point inside the cycle the fast pointer is k nodes ahead of the slow pointer. Since the fast pointer moves two steps and the slow pointer moves one step
//// in each iteration, the net reduction in the gap is one node per iteration. So the difference reduces from k to k-1, k-2, and so on, until it becomes zero.
//// At that moment, both pointers land on the same node, meaning they collide, and this collision conclusively indicates that a cycle exists in the linked list.

//        public ListNode detectCycle(ListNode head) {
//            Set<ListNode> visited = new HashSet<>();
//            while (head != null) {
//                if (visited.contains(head)) {
//                    return head;
//                }
//                visited.add(head);
//                head = head.next;
//            }
//            return null;

//        if (head == null || head.next == null)  return;
//
//        Node slow = head;       // moves 1 step
//        Node fast = head;       // moves 2 steps
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;           // move slow by 1
//            fast = fast.next.next;      // move fast by 2
//
//            if (slow == fast)           // cycle detected
//                System.out.println("Yes");
//        }

//// Starting point of loop in a Linked List: Brute force same as detect loop:

// You may be curious about the proof for this algorithm, and it hinges on the idea that the point where the slow and fast pointers converge
// can be leveraged to determine the starting point of the loop. In the "tortoise and hare" algorithm for detecting loops in a linked list, when the slow pointer
// (tortoise) reaches the starting point of the loop, the fast pointer (hare) is positioned at a point that is twice the distance travelled by the slow pointer.
// This is because the hare moves at double the speed of the tortoise. If slow has travelled distance L1 then fast has travelled 2 x L1. Now that slow and fast have
// entered the loop, the distance fast will have to cover to catch up to slow is the total length of loop minus L1. Let this distance be d.
// Distance travelled by slow = L1 Distance travelled by fast = 2 * L1 Total length of loop = L1 + d. In this configuration, the fast pointer advances toward the slow
// pointer with two jumps per step, while the slow pointer moves away with one jump per step. As a result, the gap between them decreases by 1 with each step.
// Given that the initial gap is d, it takes exactly d steps for them to meet.
//// Total length of loop = L1 + d Distance between slow and fast = d
//During these d steps, the slow pointer effectively travels d steps from the starting point within the loop and fast travels 2 x d and they meet at a specific point.
// Based on our previous calculations, the total length of the loop is L1 + d. And since the distance covered by the slow pointer within the loop is d,
// the remaining distance within the loop is equal to L1. Therefore, it is proven that the distance between the starting point of the loop and the point where
// the two pointers meet is indeed equal to the distance between the starting point and head of the linked list.

//         Node detectCycle(Node head) {
//
//            Node slow = head;
//            Node fast = head;
//
//            while (fast != null && fast.next != null) {
//
//                slow = slow.next;
//                fast = fast.next.next;
//
//                if (slow == fast) {
//                    slow = head;
//
//                    while (slow != fast) {
//                        slow = slow.next;
//                        fast = fast.next;
//                    }
//
//                    return slow;
//                }
//            }
//            return null;
//        }

//// Length of Loop in LL:

//        public int lengthOfLoop(Node head) {
//            HashMap<Node, Integer> visitedNodes = new HashMap<>();
//
//            Node temp = head;
//            int timer = 0;
//
//            while (temp != null) {
//
//                if (visitedNodes.containsKey(temp)) {
//                    int loopLength = timer - visitedNodes.get(temp);
//                    return loopLength;
//                }
//
//                visitedNodes.put(temp, timer);
//                temp = temp.next;
//                timer++;
//            }
//
//            return 0;
//        }

//        public int lengthOfLoop(Node head) {
//            if (head == null || head.next == null) return ;
//
//            Node slow = head;
//            Node fast = head;
//
//            while (fast != null && fast.next != null) {
//                slow = slow.next;
//                fast = fast.next.next;
//
//                if (slow == fast) {
//                    return countLength(slow);
//                }
//            }
//            return;
//        }
//
//         int countLength(Node meetingPoint) {
//            Node curr = meetingPoint;
//            int count = 1;
//
//            // traverse cycle until we come back to the same node
//            while (curr.next != meetingPoint) {
//                curr = curr.next;
//                count++;
//            }
//            return count;
//        }

//// Check if the given Linked List is Palindrome:

//        Stack<Integer> st = new Stack<>();
//        Node curr = head;
//
//        while (curr != null) {
//            st.push((Integer) curr.data);
//            curr = curr.next;
//        }
//
//        curr = head;
//        while (curr != null) {
//            if (curr.data != st.pop()) {
//                System.out.println("Not a Palindrome");
//                break;
//            }
//            curr = curr.next;
//        }
//        System.out.println("It's a Palindrome");

//        Node slow=head;
//        Node fast=head;
//
//        while (fast!=null && fast.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//
//        Node firsthalf=head;
//        Node secondhalfhead=reverselinkedlist(slow);
//        Node secondhalf=secondhalfhead;
//
//        while (secondhalf!=null){
//            if(firsthalf.data!=secondhalf.data){
//                System.out.println("Not a Palindrome");
//                return;
//            }
//            firsthalf=firsthalf.next;
//            secondhalf=secondhalf.next;
//        }
//        reverselinkedlist(secondhalfhead);
//
//        System.out.println("Its a plaindrome");

//// Segrregate odd and even nodes in LL:

//        if (head == null) return;
//
//        ArrayList<Integer> list = new ArrayList<>();
//        Node curr = head;
//
//        while (curr != null) {
//            list.add((Integer) curr.data);
//            curr = curr.next;
//        }
//
//        curr = head;
//
//        for (int i = 0; i < list.size(); i += 2) {
//            curr.data = list.get(i);
//            curr = curr.next;
//        }
//
//        for (int i = 1; i < list.size(); i += 2) {
//            curr.data = list.get(i);
//            curr = curr.next;
//        }

//        Node odd=head;
//        Node even=head.next;
//        Node evenhead=even;
//
//        while (even!=null && even.next!=null){
//            odd.next=even.next;
//            odd=odd.next;
//
//            even.next=odd.next;
//            even=even.next;
//        }
//        odd.next=evenhead;
//

////Delete the Middle Node of the Linked List:
//        public ListNode deleteMiddle(ListNode head) {
//            if (head == null || head.next == null)
//                return null;  // list becomes empty
//
//            ListNode slow = head;
//            ListNode fast = head;
//            ListNode prev = null;
//
//            // Move slow by 1, fast by 2
//            while (fast != null && fast.next != null) {
//                prev = slow;
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//
//            // Now slow is middle, prev is before middle
//            prev.next = slow.next;
//
//            return head;
//        }

//// Sort LL:

//        public Node sortLL(Node head) {
//            // List to store node values
//            ArrayList<Integer> arr = new ArrayList<>();
//
//            // Pointer to traverse the list
//            Node temp = head;
//
//            // Traverse and push values into list
//            while (temp != null) {
//                arr.add(temp.data);
//                temp = temp.next;
//            }
//
//            // Sort the list
//            Collections.sort(arr);
//
//            // Reassign sorted values to list nodes
//            temp = head;
//            for (int i = 0; i < arr.size(); i++) {
//                temp.data = arr.get(i);
//                temp = temp.next;
//            }
//
//            // Return head of sorted list
//            return head;


//            Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
//                Node dummyNode = new Node(-1, null);
//                Node temp = dummyNode;
//
//                while (list1 != null && list2 != null) {
//                    if (list1.data <= list2.data) {
//                        temp.next = list1;
//                        list1 = list1.next;
//                    } else {
//                        temp.next = list2;
//                        list2 = list2.next;
//                    }
//                    temp = temp.next;
//                }
//
//                if (list1 != null) {
//                    temp.next = list1;
//                } else {
//                    temp.next = list2;
//                }
//                return dummyNode.next;
//            }
//
//            public Node findMiddle(Node head) {
//                // If list empty or single node
//                if (head == null || head.next == null) {
//                    return head;
//                }
//
//                // Slow and fast pointers
//                Node slow = head;
//                Node fast = head.next;
//
//                // Move fast twice as fast as slow
//                while (fast != null && fast.next != null) {
//                    slow = slow.next;
//                    fast = fast.next.next;
//                }
//
//                // Return middle node
//                return slow;
//            }
//
//            // Function to perform merge sort
//            public Node sortLL(Node head) {
//                // Base case: empty or single node
//                if (head == null || head.next == null) {
//                    return head;
//                }
//
//                // Find middle node
//                Node middle = findMiddle(head);
//
//                // Split into two halves
//                Node right = middle.next;
//                middle.next = null;
//                Node left = head;
//
//                // Recursively sort both halves
//                left = sortLL(left);
//                right = sortLL(right);
//
//                // Merge sorted halves
//                return mergeTwoSortedLinkedLists(left, right);
//            }
//        }

////Sort a LL of 0's 1's and 2's by changing links

//        Node zerohead= new Node(-1);
//        Node onehead= new Node(-1);
//        Node twohead= new Node(-1);
//
//        Node zerotail=zerohead;
//        Node onetail=onehead;
//        Node twotail=twohead;
//
//        Node temp=head;
//
//        while (temp!=null){
//            Node nextnode=temp.next;
//            temp.next=null;
//
//            if((int)temp.data==0){
//                zerotail.next=temp;
//                zerotail=zerotail.next;
//            } else if ((int) temp.data==1) {
//                onetail.next=temp;
//                onetail=onetail.next;
//            }else {
//                twotail.next=temp;
//                twotail=twotail.next;
//            }
//
//            temp=nextnode;
//        }
//
//        zerotail.next=(onehead.next!=null)?onehead.next:twohead.next;
//        onetail.next=twohead.next;
//        twotail.next=null;
//
//        return (zerohead.next != null)
//                ? zerohead.next
//                : (onehead.next != null ? onehead.next : twohead.next);

//// Find intersection of Two Linked Lists:

//public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//    HashSet<ListNode> set = new HashSet<>();
//
//    while (headA != null) {
//        set.add(headA);
//        headA = headA.next;
//    }
//
//    while (headB != null) {
//        if (set.contains(headB))
//            return headB;
//        headB = headB.next;
//    }
//
//    return null;
//}

//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//            if (headA == null || headB == null)
//                return null;
//
//            ListNode a = headA;
//            ListNode b = headB;
//
//            // Traverse until both pointers meet
//            while (a != b) {
//
//                // If pointer a reaches the end of list A, move it to the head of list B
//                if (a == null) {
//                    a = headB;
//                } else {
//                    a = a.next;   // otherwise move to next node
//                }
//
//                // If pointer b reaches the end of list B, move it to the head of list A
//                if (b == null) {
//                    b = headA;
//                } else {
//                    b = b.next;   // otherwise move to next node
//                }
//            }
//
//            // At this point, a == b
//            // If intersection exists, it is the intersection node
//            // If no intersection, both are null
//            return a;
//        }


//// Add 1 to a number represented by LL

//        if (head == null)
//            return null;
//
//        long num = 0;
//        ListNode curr = head;
//
//        // Step 1: Convert list to number
//        while (curr != null) {
//            num = num * 10 + curr.data;
//            curr = curr.next;
//        }
//
//        // Step 2: Add 1
//        num = num + 1;
//
//        // Step 3: Convert updated number to string
//        String s = String.valueOf(num);
//
//        // Step 4: Rewrite digits from the front
//        curr = head;
//        int i = 0;
//
//        // Track tail node to append later
//        ListNode tail = null;
//
//        while (curr != null && i < s.length()) {
//            curr.data = s.charAt(i) - '0';
//            tail = curr;
//            curr = curr.next;
//            i++;
//        }
//
//        // Step 5: Append remaining digits (if any)
//        while (i < s.length()) {
//            ListNode newNode = new ListNode(s.charAt(i) - '0');
//            tail.next = newNode;
//            tail = newNode;
//            i++;
//        }
//
//        return head;

//            public ListNode addOne(ListNode head) {
//                if (head == null)
//                    return null;
//
//                // Step 1: Reverse the list
//                head = reverse(head);
//
//                ListNode curr = head;
//                int carry = 1; // since we add 1
//
//                // Step 2: Add 1 and propagate carry
//                while (curr != null) {
//                    int sum = curr.data + carry;
//                    curr.data = sum % 10;
//                    carry = sum / 10;
//
//                    // If no carry left, break
//                    if (carry == 0)
//                        break;
//
//                    // If next is null and carry exists, add node
//                    if (curr.next == null && carry > 0) {
//                        curr.next = new ListNode(carry);
//                        carry = 0;
//                    }
//
//                    curr = curr.next;
//                }
//
//                // Step 3: Reverse back to original order
//                head = reverse(head);
//
//                return head;
//            }
//
//            private ListNode reverse(ListNode head) {
//                ListNode prev = null;
//                ListNode curr = head;
//
//                while (curr != null) {
//                    ListNode next = curr.next;
//                    curr.next = prev;
//                    prev = curr;
//                    curr = next;
//                }
//
//                return prev;
//            }
//        }

////Use && when you need pairs of nodes:
////Use || when you need to process all nodes, even if one list ends before the other:

 ////Add 2 numbers in LL:

//       Node l1=head,l2=head2;
//       int carry=0;
//       Node newHead=null, curr=null;
//
//       while (l1!=null || l2!=null || carry>0){
//           int sum=carry;
//           if(l1!=null){
//               sum= sum +(int) l1.data;
//               l1=l1.next;
//           }
//
//           if(l2!=null){
//               sum= sum +(int) l2.data;
//               l2=l2.next;
//           }
//
//           carry=sum/10;
//
//           Node newNode=new Node<>(sum%10);
//
//           if(newHead==null){
//               newHead=newNode;
//               curr=newNode;
//           }else {
//               curr.next = newNode;
//               curr = curr.next;
//           }
//
//       }

//// While(temp!=null) till null
//// While(temp.next!=null) till last
//// While(temp.next.next!=null) till second last

////Rotate a Linked List: Given the head of a singly linked list containing integers, shift the elements of the linked list to the right by k places and return the head of the modified list.
////Do not change the values of the nodes, only change the links between nodes.

//        int k=3;
//        if(head==null || head.next==null || k==0) return;
//
//        for (int i=1;i<=k;i++){
//
//            Node prev=null;
//            Node curr=head;
//
//            while (curr.next!=null){
//                prev=curr;
//                curr=curr.next;
//            }
//
//            curr.next=head;
//            head=curr;
//            prev.next=null;
//        }           // O(n*k)

//        int k=10;
//        if(head==null || head.next==null || k==0) return;
//
//        Node temp=head;
//        int length=1;
//        while (temp.next!=null){
//            temp=temp.next;
//            length++;
//        }
//
//        k=k%length;
//
//        Node fast=head;
//
//        //move fast pointer k steps
//        for(int i=0;i<k;i++){
//            fast=fast.next;
//        }
//
//        Node slow=head;
//
//        // move slow and fast together
//        while (fast.next!=null){
//            fast=fast.next;
//            slow=slow.next;
//        }
//
//        fast.next=head;
//        head=slow.next;
//        slow.next=null;

////Merge Two Sorted Linked list in one sorted list:

//        Node mergeTwoLists(Node l1, Node l2) {
//        Node dummy = new Node(-1);
//        Node temp = dummy;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                temp.next = l1;
//                l1 = l1.next;
//            } else {
//                temp.next = l2;
//                l2 = l2.next;
//            }
//            temp = temp.next;
//        }
//
//
//            // Attach leftover part
//            if (l1 != null) temp.next = l1;
//            else temp.next = l2;
//
//            return dummy.next;
//        }

////Flattening a Linked List:

//        if (head == null) return ;
//
//        // Step 1: add all nodes to list
//        ArrayList<Integer> list = new ArrayList<>();
//
//        Node temp = head;
//        while (temp != null) {
//            Node b = temp;
//            while (b != null) {
//                list.add(b.data);
//                b = b.bottom;
//            }
//            temp = temp.next;
//        }
//
//        // Step 2: sort values
//        Collections.sort(list);
//
//        // Step 3: build new linked list using bottom pointers
//        Node newHead = new Node(list.get(0));
//        Node curr = newHead;
//
//        for (int i = 1; i < list.size(); i++) {
//            curr.bottom = new Node(list.get(i));
//            curr = curr.bottom;
//        }

//        class Solution {
//            // Merge two sorted bottom-linked lists
//            Node merge(Node a, Node b) {
//                if (a == null) return b;
//                if (b == null) return a;
//
//                Node result;
//
//                if (a.data < b.data) {
//                    result = a;
//                    result.bottom = merge(a.bottom, b);
//                } else {
//                    result = b;
//                    result.bottom = merge(a, b.bottom);
//                }
//
//                result.next = null;  // very important!
//                return result;
//            }
//
//            // Main flatten function
//            Node flatten(Node root) {
//                if (root == null || root.next == null)
//                    return root;
//
//                // Flatten the right side
//                root.next = flatten(root.next);
//
//                // Merge root list with flattened right list
//                root = merge(root, root.next);
//
//                return root;
//            }
//        }


////Reverse Linked List in groups of Size K:

// returns the k-th node from temp (1-based)
//        Node getKthNode(Node temp, int k) {
//            k = k - 1; // we already treat temp as 1st node
//            while (temp != null && k > 0) {
//                temp = temp.next;
//                k--;
//            }
//            return temp;   // may return null if < k nodes remain
//        }

//        // reverse entire linked list (standard)
//        Node reverseLinkedList(Node head) {
//            Node prev = null;
//            Node curr = head;
//
//            while (curr != null) {
//                Node next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//            return prev; // new head of reversed segment
//        }
//
//        // main K-group reverse
//        Node kReverse(Node head, int k) {
//            if (head == null || k <= 1) return head;
//
//            Node temp = head;
//            Node prevLast = null;
//
//            while (temp != null) {
//
//                Node kthNode = getKthNode(temp, k);
//                if (kthNode == null) {
//                    // remaining nodes < k → no reverse
//                    if (prevLast != null) prevLast.next = temp;
//                    break;
//                }
//
//                Node nextNode = kthNode.next;
//                kthNode.next = null; // detach segment
//
//                // reverse the extracted segment
//                Node reversedHead = reverseLinkedList(temp);
//
//                // connect previous segment
//                if (temp == head) {
//                    head = reversedHead;
//                } else {
//                    prevLast.next = reversedHead;
//                }
//
//                // temp becomes last of reversed segment
//                prevLast = temp;
//
//                // move ahead
//                temp = nextNode;
//            }
//
//            return head;
//        }

//
//        Node temphead =head;
//        while (temphead !=null){
//            System.out.print(temphead.data + " ");
//            temphead = temphead.next;
//        }

////Stack and Queue:

////Check for balanced paranthesis:

//        String s = "{[()]}}";
//        Stack<Character> st = new Stack<>();
//
//        for (char ch : s.toCharArray()) {
//
//            if (ch == '(' || ch == '{' || ch == '[') {
//                st.push(ch);
//            }
//            else if (ch == ')' || ch == '}' || ch == ']') {
//
//                if (st.isEmpty()) return; // No matching opening
//
//                char top = st.pop();
//
//                // Check matches
//                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
//                    return;
//                }
//            }
//        }
//        // Step 3: Stack must be empty
//        System.out.println(st.isEmpty());

////Next Greater Element Using Stack:

//        Integer arr[] = {6, 8, 0, 1, 3};
//        Stack<Integer> stack=new Stack<Integer>();
//        Integer ans[]=new Integer[arr.length];
//
//        for(int i=arr.length-1;i>=0;i--){
//
//            while (!stack.isEmpty() && stack.peek()<=arr[i]){
//                    stack.pop();
//            }
//
//            if(stack.isEmpty()){
//                ans[i]=-1;
//            }else {
//                ans[i]=stack.peek();
//            }
//
//            stack.push(arr[i]);
//
//        }
//
//        System.out.println(Arrays.toString(ans));

//Brute force: O(n2)
// Optimal: O(2n) O(n)

////Next Greater Element 2:
//        int arr[] = {6, 8, 0, 1, 3};

//        int n = arr.length;
//        int[] nge = new int[n];
//
//        for (int i = 0; i < n; i++) {
//
//            nge[i] = -1;
//
//            for (int j = i + 1; j < i + n; j++) {
//
//                int idx = j % n;   // circular index
//
//                if (arr[idx] > arr[i]) {
//                    nge[i] = arr[idx];
//                    break;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(nge));

//        public int[] nextGreaterElements(int[] arr) {
//            int n = arr.length;
//            int[] nge = new int[n];
//            Stack<Integer> st = new Stack<>();
//
//            // Loop 2N - 1 down to 0
//            for (int i = 2 * n - 1; i >= 0; i--) {
//
//                int idx = i % n;  // circular index
//
//                // Maintain decreasing stack
//                while (!st.isEmpty() && st.peek() <= arr[idx]) {
//                    st.pop();
//                }
//
//                if (i < n) {
//                    nge[idx] = st.isEmpty() ? -1 : st.peek();
//                }
//
//                st.push(arr[idx]);
//            }
//            return nge;
//        }

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(4n) SC:O(2n)

//// Previous Smaller Element:
//        public int[] previousSmallerBrute(int[] arr) {
//            int n = arr.length;
//            int[] pse = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                pse[i] = -1;
//                for (int j = i - 1; j >= 0; j--) {
//                    if (arr[j] < arr[i]) {
//                        pse[i] = arr[j];
//                        break;
//                    }
//                }
//            }
//            return pse;
//        }

//        public int[] previousSmallerElement(int[] arr) {
//            int n = arr.length;
//            int[] pse = new int[n];
//            Stack<Integer> st = new Stack<>();
//
//            for (int i = 0; i < n; i++) {
//
//                // Pop all greater/equal elements (they cannot be previous smaller)
//                while (!st.isEmpty() && st.peek() >= arr[i]) {
//                    st.pop();
//                }
//
//                // If empty → no smaller element on the left
//                pse[i] = st.isEmpty() ? -1 : st.peek();
//
//                // Push current element into stack
//                st.push(arr[i]);
//            }
//
//            return pse;
//        }

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////Stock Span Problem: https://leetcode.com/problems/online-stock-span/description/
//     int[]  price = {100, 80, 60, 70, 60, 75, 85};
//     int ans[]=new int[price.length];

//     for(int i=price.length-1;i>=0;i--){
//         int days=1;
//         for(int j=i-1; j>=0; j--){
//             if(price[i]<price[j]){
//                 break;
//             }
//             days++;
//         }
//         ans[i]=days;
//     }
//        System.out.println(Arrays.toString(ans));

//        Stack<Integer> stack=new Stack<>();
//
//        for(int i=0;i<price.length;i++){
//
//            while (!stack.isEmpty() && price[stack.peek()]<=price[i]){
//                stack.pop();
//            }
//            ans[i]=stack.isEmpty()?i+1:i-stack.peek();
//            stack.push(i);
//        }
//        System.out.println(Arrays.toString(ans));

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////Daily Temperatures: Given an array of integer temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after
////the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] ans = new int[temperatures.length];
//        Stack<Integer> stack=new Stack<>();
//        for(int i=temperatures.length-1;i>=0;i--){
//
//            while (!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
//                stack.pop();
//            }
//            ans[i]=stack.isEmpty()?0:stack.peek()-i;
//            stack.push(i);
//        }
//        System.out.println(Arrays.toString(ans));

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////Trapping Rainwater:

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////Sum of Subarray Minimum:
//        int[] arr={3,1,2,5};
//        int ans=0;

//        for(int i=0;i<arr.length;i++){
//            int min=Integer.MAX_VALUE;
//            for (int j=i;j<arr.length;j++){
//                if(min>arr[j]){
//                    min=arr[j];
//                }
//                ans+=min;
//            }
//        }
//        System.out.println(ans);

//        int sumSubarrayMins(int[] arr){
//        int n=arr.length;
//        int MOD = 1_000_000_007;
//        int[] pse = new int[n];
//        int[] nse = new int[n];
//
//        Stack<Integer> stack = new Stack<>();
//
//        // 🔹 Previous Smaller Element (strict)
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
//                stack.pop();
//            }
//            pse[i] = stack.isEmpty() ? -1 : stack.peek();
//            stack.push(i);
//        }
//
//        stack.clear();
//
//        // 🔹 Next Smaller Element (non-strict)
//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
//                stack.pop();
//            }
//            nse[i] = stack.isEmpty() ? n : stack.peek();
//            stack.push(i);
//        }
//
//        // 🔹 Calculate answer
//        long ans = 0;
//        for (int i = 0; i < n; i++) {
//            long left = i - pse[i];
//            long right = nse[i] - i;
//            ans = (ans + arr[i] * left * right) % MOD;
//        }
//
//        return (int) ans;
//        }

////We intentionally do NOT use >= in Previous Smaller Element (PSE) because:To avoid double counting when duplicate
////values exist

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(5n) SC:O(n)

////Sum of Subarray Maximum:

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////Asteroid Collision: Simulation pattern means:We imitate the real-world process step by step exactly as it happens.

//        int [] asteroids={7, -8, 5, 10, -5, -10, 15, -3, 7};
//        Stack<Integer> stack = new Stack<>();
//
//        for (int ast : asteroids) {
//
//            // Case 1: moving right → always safe
//            if (ast > 0) {
//                stack.push(ast);
//            }
//            // Case 2: moving left → possible collision
//            else {
//                // destroy smaller right-moving asteroids
//                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast)) {
//                    stack.pop();
//                }
//
//                // equal size → both destroyed
//                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == Math.abs(ast)) {
//                    stack.pop();
//                }
//                // current asteroid survives
//                else if (stack.isEmpty() || stack.peek() < 0) {
//                    stack.push(ast);
//                }
//            }

//Brute force: TC:O(2n) SC:O(n)
// Optimal:    TC:O() SC:O()

//// Sum of Subarray Ranges:

//        int [] nums = {1, 2, 3};
//        int n = nums.length;
//        long sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            int min = nums[i];
//            int max = nums[i];
//
//            for (int j = i; j < n; j++) {
//                min = Math.min(min, nums[j]);
//                max = Math.max(max, nums[j]);
//                sum += (max - min);
//            }
//        }


////Optimal: Sum of subarray ranges = (sum of all subarray maximums) − (sum of all subarray minimums)
// **Intuition (in one paragraph):**
//Instead of calculating the maximum and minimum for every subarray separately, we reverse the perspective and focus on
// **each element’s contribution** to the final answer. Any element participates in many subarrays—sometimes as the **minimum**,
// sometimes as the **maximum**. The total sum of subarray ranges can therefore be written as
// **(sum of all subarray maximums − sum of all subarray minimums)**. For a given element, if we know how far it can
// extend to the left and right before encountering a smaller element (for minimum) or a greater element (for maximum),
// then every choice of a start on the left and an end on the right forms a subarray where that element is the min or max.
// The number of such subarrays is simply the product of those left and right distances. **Monotonic stacks** allow us to
// find these nearest smaller/greater boundaries efficiently in linear time, ensuring each element’s contribution is counted
// exactly once.

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//// Remove K Digits: Given a string nums representing a non-negative integer, and an integer k,
//// find the smallest possible integer after removing k digits from num.

//**Intuition (in one paragraph):**
//The goal in *Remove K Digits* is to make the number as small as possible while removing exactly `k` digits,
// so we should eliminate digits that cause the number to be larger **earlier** in the sequence.
// A larger digit placed before a smaller one increases the value more than a larger digit placed later,
// so whenever we see a digit that is **smaller than the previous digit**, it is beneficial to remove that previous larger
// digit if we still have removals left. This leads to a greedy process where we scan the number from left to right and maintain
// a **monotonic increasing stack** of digits; whenever the current digit is smaller than the stack’s top and `k > 0`,
// we pop the stack to reduce the number. After processing all digits, if removals are still left, we remove digits from the
// end (the least significant side). Finally, we strip leading zeros because they do not contribute to the numeric value.

//**Example intuition (in one paragraph):**
// For `num = "1432219"` and `k = 3`, we scan digits from left to right and keep a stack that stays increasing,
// because a larger digit placed before a smaller one makes the number bigger. When we see `3` after `4`, removing `4` is
// beneficial since it reduces the number at a higher place value; similarly, when `2` appears after `3`, we remove `3`,
// and later when `1` appears after `2`, we remove `2`, using up all three removals. At each step, we only remove a previous
// digit if it is larger than the current one and we still have removals left. The remaining digits in the stack (`1,2,1,9`)
// form the smallest possible number after exactly three deletions, giving the final result `"1219"`.

//        public String removeKdigits(String nums, int k) {
//            // Stack to store digits
//            Stack<Character> st = new Stack<>();
//
//            // Traverse the given string
//            for (int i = 0; i < nums.length(); i++) {
//                char digit = nums.charAt(i); // Current digit
//
//                // Pop last digits if a smaller digit is found and k > 0
//                while (!st.isEmpty() && k > 0 && st.peek() > digit) {
//                    st.pop(); // Remove the last digit
//                    k--; // Decrement k by 1
//                }
//
//                // Push the current digit
//                st.push(digit);
//            }
//
//            // If more digits can be removed
//            while (k > 0) {
//                st.pop(); // Pop the last added digits
//                k--; // Decrement k by 1
//            }
//
//            // Handle edge case: if stack is empty
//            if (st.isEmpty()) return "0";
//
//            // StringBuilder to store the result
//            StringBuilder res = new StringBuilder();
//
//            // Add digits from stack to result
//            while (!st.isEmpty()) {
//                res.append(st.pop());
//            }
//
//            // Trim the leading zeros
//            while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
//                res.deleteCharAt(res.length() - 1);
//            }
//
//            // Reverse the string to get the correct number
//            res.reverse();
//
//            // If result is empty, return "0"
//            if (res.length() == 0) return "0";
//
//            // Return the result as a string
//            return res.toString();
//        }
//    }

//Brute force: TC:O(2^n) SC:O(n)
// Optimal:    TC:O(n) SC:O(n)

//// Largest rectangle in a histogram:
//        int[] heights = {2, 1, 5, 6, 2, 3, 1};
//        int n = heights.length;

//        int area=0;
//        for(int i=0;i<n;i++){
//            int minheight=Integer.MAX_VALUE;
//            for(int j=i;j<n;j++){
//                minheight = Math.min(minheight, heights[j]);
//                area=Math.max(area,(j-i+1)*minheight);
//            }
//        }
//        System.out.println(area);

//        int[] pse = new int[n]; // previous smaller boundary
//        int[] nse = new int[n]; // next smaller boundary
//
//        Stack<Integer> stack = new Stack<>();
//
//        // 1. Previous Smaller Element (left boundary)
//        for (int i = 0; i < n; i++) {
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            }
//            pse[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
//            stack.push(i);
//        }
//
//        stack.clear();
//
//        // 2. Next Smaller Element (right boundary)
//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                stack.pop();
//            }
//            nse[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
//            stack.push(i);
//        }
//
//        // 3. Compute maximum area
//        int maxArea = 0;
//        for (int i = 0; i < n; i++) {
//            int width = nse[i] - pse[i] + 1;
//            maxArea = Math.max(maxArea, heights[i] * width);
//        }
//        System.out.println(maxArea);

//        Stack<Integer> stack = new Stack<>();
//        int maxArea = 0;
//
//        // traverse all bars + one extra iteration (sentinel)
//        for (int i = 0; i <= n; i++) {
//
//            int currHeight = (i == n) ? 0 : heights[i];
//
//            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
//
//                int height = heights[stack.pop()];
//
//                int right = i; // current index is the first smaller on right
//                int left = stack.isEmpty() ? -1 : stack.peek();
//
//                int width = right - left - 1;
//                maxArea = Math.max(maxArea, height * width);
//            }
//
//            stack.push(i);
//        }
//        System.out.println(maxArea);

//Brute force: TC:O(n2) SC:O(1)
// Optimal: TC:O(5n) SC:O(3n)
// Optimal: TC:O(n) SC:O(n)

//// Maximal Rectangles:

//        class Solution {
//
//            public int maximalRectangle(char[][] matrix) {
//                if (matrix.length == 0) return 0;
//
//                int rows = matrix.length;
//                int cols = matrix[0].length;
//                int[] heights = new int[cols];
//                int maxArea = 0;
//
//                for (int r = 0; r < rows; r++) {
//
//                    // Build histogram for current row
//                    for (int c = 0; c < cols; c++) {
//                        if (matrix[r][c] == '1')
//                            heights[c] += 1;
//                        else
//                            heights[c] = 0;
//                    }
//
//                    // Compute largest rectangle in histogram
//                    maxArea = Math.max(maxArea, largestRectangleArea(heights));
//                }
//
//                return maxArea;
//            }
//
//            // Single-pass Largest Rectangle in Histogram
//            private int largestRectangleArea(int[] heights) {
//                Stack<Integer> stack = new Stack<>();
//                int maxArea = 0;
//                int n = heights.length;
//
//                for (int i = 0; i <= n; i++) {
//                    int currHeight = (i == n) ? 0 : heights[i];
//
//                    while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
//                        int height = heights[stack.pop()];
//                        int right = i;
//                        int left = stack.isEmpty() ? -1 : stack.peek();
//                        int width = right - left - 1;
//                        maxArea = Math.max(maxArea, height * width);
//                    }
//                    stack.push(i);
//                }
//                return maxArea;
//            }
//        }

//Brute force: TC:O() SC:O()
// Optimal:    TC:O(N*M) + O(2*M) SC:O(N*M)

//// Sliding Window Maximum: Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array
////to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window..

// In the *Sliding Window Maximum* problem, we need the maximum element for every window of size `k` while moving the window one step at a time, and recalculating
// the maximum from scratch would be inefficient. The key idea is to use a **deque (double-ended queue)** to store indices of elements in such a way that their values
// are always in **decreasing order from front to back**. As we move forward, we remove elements from the **back** of the deque that are smaller than the current element,
// because they can never become the maximum in the presence of this larger element. We also remove elements from the **front** if they fall outside the current window
// range. This way, the front of the deque always holds the index of the **maximum element of the current window**, allowing us to get the answer in constant time per
// window while each element is added and removed at most once, achieving an overall linear time complexity.

//    int[]  arr = {4,0,-1,3,5,3,6,8}; int k = 3;
//        int n=arr.length;
//        int ans[]=new int[n-k+1];

//        for(int i=0;i<=n-k;i++){
//            int max=Integer.MIN_VALUE;
//
//            for (int j=i;j<=k+i-1;j++){
//                max=Math.max(max,arr[j]);
//            }
//            ans[i]=max;
//        }
//        System.out.println(Arrays.toString(ans));

//        Deque<Integer> dq=new ArrayDeque<>();
//        for(int i=0;i<n;i++){
//            while (!dq.isEmpty() && dq.peekFirst()<=i-k){
//                dq.pollFirst();
//            }
//            while (!dq.isEmpty() && dq.peekLast()<arr[i]){
//                dq.pollLast();
//            }
//            dq.offerLast(i);
//            if(i>=k-1){
//                ans[i-k+1]=arr[dq.peekFirst()];
//
//            }
//        }
//        System.out.println(Arrays.toString(ans));

//Brute force: TC:O(n*k) SC:O(1)
// Optimal:    TC:O(n) SC:O(k)

////Celebrity Problem: A celebrity is a person who is known by everyone else at the party but does not know anyone in return.
////Given a square matrix M of size N x N where M[i][j] is 1 if person i knows person j, and 0 otherwise, determine if there is a celebrity at the party.
////Return the index of the celebrity or -1 if no such person exists.

//A celebrity must satisfy two conditions: they do not know anyone else, and everyone else knows them. So, we treat each person as a potential candidate and verify
// these two rules by scanning their entire row and column in the matrix. If we find even one person whom the candidate knows, or one person who does not know the
// candidate, that candidate is immediately rejected. If a person passes both checks, they are the celebrity. If no one satisfies these conditions after checking
// all people, then there is no celebrity at the party.

        int[][] M = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };

//        int n = M.length; // rows
//        int m=M[0].length; // column
//
//        for (int i = 0; i < n; i++) {
//
//            boolean isCelebrity = true;
//
//            // Check row: celebrity knows no one
//            for (int j = 0; j < n; j++) {
//                if (i != j && M[i][j] == 1) {
//                    isCelebrity = false;
//                    break;
//                }
//            }
//
//            // Check column: everyone knows celebrity
//            for (int j = 0; j < n && isCelebrity; j++) {
//                if (i != j && M[j][i] == 0) {
//                    isCelebrity = false;
//                    break;
//                }
//            }
//
//            if (isCelebrity) {
//                System.out.println("Celebrity index: " + i);
//                return;
//            }
//        }
//        System.out.println("No celebrity found");

//        int n = M.length;
//        int left = 0;
//        int right = n - 1;
//
//        // Step 1: Find potential celebrity
//        while (left < right) {
//            if (M[left][right] == 1) {
//                left++;      // left knows right → left not celebrity
//            } else {
//                right--;     // left doesn't know right → right not celebrity
//            }
//        }
//
//        int candidate = left;
//
//        // Step 2: Verify candidate
//        for (int i = 0; i < n; i++) {
//            if (i != candidate) {
//                // celebrity should not know anyone
//                // everyone should know celebrity
//                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
//                    System.out.println("No celebrity found");
//                    return;
//                }
//            }
//        }
//
//        System.out.println("Celebrity is: " + candidate);


//Brute force: TC:O(m*n) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//// LRU Cache:

//        // Doubly linked list node class
//        class  Node{
//            int key;
//            int value;
//            Node next;
//            Node prev;
//
//            // Constructor to initialize node
//            public Node(int _key,int _value){
//                this.key=_key;
//                this.value=_value;
//            }
//        }
//
//        class LRUCache {
//
//            private int capacity;
//            private HashMap<Integer, Node> map;
//            private Node head, tail;
//
//            public LRUCache(int capacity) {
//                this.capacity=capacity;
//                map=new HashMap<>();
//
//                head=new Node(-1,-1);
//                tail=new Node(-1,-1);
//                head.next=tail;
//                tail.prev=head;
//            }
//
//            public int get(int _key) {
//
//                if(!map.containsKey(_key)) return -1;
//
//                Node resNode=map.get(_key);
//
//                //map.remove(_key);
//
//                deleteNode(resNode);
//                insertAfterHead(resNode);
//
//                //map.put(_key,head.next);
//
//                return resNode.value;
//            }
//
//            public void put(int _key, int _value) {
//
//                if(map.containsKey(_key)){
//                    Node oldNode=map.get(_key);
//                    deleteNode(oldNode);
//                    map.remove(_key);
//                }
//
//                // If capacity reached
//                if(map.size()==capacity){
//                    Node lru=tail.prev;
//                    map.remove(lru.key);
//                    deleteNode(lru);
//                }
//
//                Node newNode=new Node(_key,_value);
//                insertAfterHead(newNode);
//                map.put(_key,newNode);
//            }
//
//            private void insertAfterHead(Node temp) {
//                temp.next=head.next;
//                temp.prev=head;
//                head.next.prev=temp;
//                head.next=temp;
//            }
//
//            private void deleteNode(Node temp) {
//                temp.prev.next=temp.next;
//                temp.next.prev=temp.prev;
//            }
//
//        }


////LFU Cache:

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(4n) SC:O(2n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(4n) SC:O(2n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(4n) SC:O(2n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(4n) SC:O(2n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(4n) SC:O(2n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

////

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)


    }}





