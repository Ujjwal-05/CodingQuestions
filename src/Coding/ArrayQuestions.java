package Coding;

//Find pairs with given sum in sorted array:

import java.util.*;
import java.util.stream.Collectors;

class Pair{
    double distance;
    int index;

    public Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Meeting{
    int start;
    int end;
    int position;

    public Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }

}

//class ListNode{
//    int val;
//    ListNode next;
//
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//    public ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//
//    ListNode createnodes(List<int> nums) {
//
//        if (nums.isEmpty()) return null;
//
//        ListNode head = new ListNode(nums.get(0));
//        ListNode temp = head;
//
//        for (int i = 1; i < nums.size(); i++) {
//            temp.next = new ListNode(nums.get(i));
//            temp = temp.next;
//        }
//
//        return head;
//    }
//}

public class ArrayQuestions {

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

    public static void main(String[] args) {
        System.out.println("Happy Coding");
/*
 Pattern: Simple Traversal / Math / Logic:

////Reverse a number or Check palindrome.

        int num=121;
        int reversed=0, temphead=num;

        while(temphead>0){
            reversed=reversed*10 + temphead%10;
            temphead/=10;
        }

//// Check num is Armstrong or not:

        static boolean isArmstrong(int num) {
            int original = num;
            int digits = String.valueOf(num).length();
            int sum = 0;

            while (num > 0) {
                int rem = num % 10;
                sum += (int) Math.pow(rem, digits);
                num /= 10;
            }
            return sum == original;
        }

////Second-Largest element in the array:

        int [] arr= {10,8,5,4,3,9};
        int largest=Integer.MIN_VALUE;
        int second_larget=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                second_larget=largest;
                largest=arr[i];
            } else if (arr[i]<largest && arr[i]>second_larget){
                second_larget=arr[i];
            }
        }

//// Remove duplicates from the sorted/unsorted array.
        int [] arr= {1,2,2,2,2,2,3,3,3,4,5,5};
        int left=0;

        for(int right=1;right<arr.length;right++){
            if(arr[left]!=arr[right]){
                left++;
                arr[left]=arr[right];;
            }
        }

//// Find the missing number in array:

    public int missingNumber(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

//// Left rotate array by d place:

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;

        for(int i=1;i<=k;i++){
            int temp=nums[n-1];

            for(int j=n-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0]=temp;

        }

    }
        int [] a={1,2,3,4,5};
        int k =3;

        Reverse(a,0,k-1);
        Reverse(a,k,a.length-1);
        Reverse(a,0,a.length-1);

        static void Reverse(int[] a, int start, int end) {
            while (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }

////Find the number that appears once, and other numbers twice.

        int[] arr={1,1,2,2,3,3,4,4,5,5,6};
        int res=0;

        for (int num:arr){
            res=res^num;
        }
        return res;

//// Moves zero to end and preserve the order:
        int [] arr={0,5,5,1,0,0,0,1,2,3,0,0,4,5,0,0};

        public void moveZeroes(int[] nums) {

            int n = nums.length;
            int j = -1;

            // STEP 1: Find the index of first zero
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    j = i;
                    break;
                }
            }

            // If no zero found, array already valid
            if (j == -1) return;

            // STEP 2: Move non-zero elements forward
            for (int i = j + 1; i < n; i++) {
                if (nums[i] != 0) {
                    // swap nums[i] and nums[j]
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    j++;
                }
            }
    }

////Leader in array problem:

     public static void printLeaders(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n - 1];

        // Rightmost element is always a leader
        System.out.print(maxFromRight + " ");

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
    }


//// Rearrange Array elements by sign.

    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positive and negative
     for (int num : nums) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int[] result = new int[nums.length];

        int posIdx = 0, negIdx = 0;
        int i = 0;

        // Fill alternately
        while (posIdx < pos.size() && negIdx < neg.size()) {
            if (i % 2 == 0)
                result[i++] = pos.get(posIdx++);
            else
                result[i++] = neg.get(negIdx++);
        }

        // Remaining positives
        while (posIdx < pos.size())
            result[i++] = pos.get(posIdx++);

        // Remaining negatives
        while (negIdx < neg.size())
            result[i++] = neg.get(negIdx++);

        return result;
}

        int[] arr = { -7, -1, 5, -3, 6, 4};
        int[] res = new int[arr.length];

        int pos=0,neg=1;

        for(int num:arr){
            if(num>0){
                res[pos]=num;
                pos+=2;
            }
            else {
                res[neg]=num;
                neg+=2;
            }

        }

////Distinct element in UnSorted/Sorted array.

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 2, 4, 3, 1};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isDistinct = true;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDistinct = false;
                    break;
                }
            }

            if (isDistinct) {
                System.out.print(arr[i] + " ");
            }
        }
    }

     public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int n = arr.length;

        // First element is always distinct
        System.out.print(arr[0] + " ");

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }

     public static void main(String[] args) {
        int[] arr = {4, 2, 1, 2, 4, 3, 1};

        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (!seen.contains(num)) {
                System.out.print(num + " ");
                seen.add(num);
            }
        }
    }

////Print duplicate elements in Sorted:

    public static List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > 1 && !duplicates.contains(arr[i])) {
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }

      public static List<Integer> findDuplicatesSorted(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {

            // duplicate found
            if (arr[i] == arr[i + 1]) {

                if (duplicates.isEmpty() || duplicates.get(duplicates.size() - 1) != arr[i]) {
                    duplicates.add(arr[i]);
                }
            }
        }
        return duplicates;
    }

////Print duplicate elements in Unsorted:

     public static List<Integer> findDuplicates(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > 1 && !duplicates.contains(arr[i])) {
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }

     public static List<Integer> findDuplicatesUnsorted(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : arr) {
            // if already seen → duplicate
            if (!seen.add(num)) {
                // add only once
                if (!duplicates.contains(num)) {
                    duplicates.add(num);
                }
            }
        }
        return duplicates;
    }

////Find pairs with given sum in sorted array:

    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] res=new int[2];

        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){

                if(numbers[i]+numbers[j]==target){
                    res[0]=i+1;
                    res[1]=j+1;
                    break;
                }
            }
        }
        return res;
    }

    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] res=new int[2];
        int left=0, right=n-1;

        while(left<right){
            int sum=numbers[left] + numbers[right];

            if(sum==target){
                res[0]=left+1;
                res[1]=right+1;
                break;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }

////Find Unique pairs with given sum in Unsorted array:

        public List<List<Integer>> findPairs(int[] nums, int target) {
        int n = nums.length;

        Set<String> uniquePairs = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[i] + nums[j] == target) {

                    int a = Math.min(nums[i], nums[j]);
                    int b = Math.max(nums[i], nums[j]);

                    String key = a + "," + b;

                    if (!uniquePairs.contains(key)) {
                        result.add(Arrays.asList(a, b));
                        uniquePairs.add(key);
                    }
                }
            }
        }

        return result;
    }
        TC:O(n2) SC:O(n)

        int arr[] = {1,1,2,2,3,4,4,5,6,7,8,0,9};  int k = 9;

        Set<Integer> set = new HashSet<>();
        Set<String> printed = new HashSet<>();

        for (int num : arr) {
            int complement = k - num;

            if (set.contains(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);

                if (printed.add(a + "," + b)) {
                    System.out.println(a + " " + b);
                }
            }

            set.add(num);
        }


//// Find common element in two/three sorted array:

        int[] a ={1,2,3,4,5};
        int[] b ={2,3,4,5,6};
        int[] c ={3,4,5,6,7};

        int i=0,j=0,k=0;

        while (i<a.length && j<b.length && k<c.length){

            if(a[i]==b[j] && b[j]==c[k]){
                System.out.println(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i]<b[j]) {i++;}
            else if (b[j]<c[k]) {j++;}
            else {k++;}

            }

//// Find common element in three  unsorted array:

        int[] a={2,8,7,5,4,6,6};
        int[] b={5,2,7,3,9,1,5};
        int[] c={1,7,2,5,6,4,5};

        Set<Integer> set1=new HashSet<>();
        for(int num: a){
            set1.add(num);
        }

        Set<Integer> set2=new HashSet<>();
        for(int num: b){
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        Set<Integer> set3=new HashSet<>();
        for(int num: c){
            if(set2.contains(num)){
                set3.add(num);
            }

        }

        for(int nums: set3 ){
            System.out.println(nums);
        }

//// Given an array of 0 and 1, arrange them left side array contain 0 and right side 1:

Brute Force: Traversal and count ones and zeroes O(2n)

        int[] a={0,1,1,0,0,0,1,0,1,1,0};
        int left=0, right=a.length-1;

        while(left<right){

            while(a[left]==0 && left<right){
                left++;
            }
            while (a[right]==1 && left<right){
                right--;
            }

            if(left<right) {
                int temphead = a[left];
                a[left] = a[right];
                a[right] = temphead;

                left++;
                right--;
            }
        }





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

//0 1 2 3 4 5 6
//1 2 3 4 5 6 0
//2 3 4 5 6 0 1
//3 4 5 6 0 1 2
//4 5 6 0 1 2 3
//5 6 0 1 2 3 4
//6 0 1 2 3 4 5
//0 1 2 3 4 5 6







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
//        class  ListNode{
//            int key;
//            int value;
//            ListNode next;
//            ListNode prev;
//
//            // Constructor to initialize node
//            public ListNode(int _key,int _value){
//                this.key=_key;
//                this.value=_value;
//            }
//        }
//
//        class LRUCache {
//
//            private int capacity;
//            private HashMap<Integer, ListNode> map;
//            private ListNode head, tail;
//
//            public LRUCache(int capacity) {
//                this.capacity=capacity;
//                map=new HashMap<>();
//
//                head=new ListNode(-1,-1);
//                tail=new ListNode(-1,-1);
//                head.next=tail;
//                tail.prev=head;
//            }
//
//            public int get(int _key) {
//
//                if(!map.containsKey(_key)) return -1;
//
//                ListNode resNode=map.get(_key);
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
//                    ListNode oldNode=map.get(_key);
//                    deleteNode(oldNode);
//                    map.remove(_key);
//                }
//
//                // If capacity reached
//                if(map.size()==capacity){
//                    ListNode lru=tail.prev;
//                    map.remove(lru.key);
//                    deleteNode(lru);
//                }
//
//                ListNode newNode=new ListNode(_key,_value);
//                insertAfterHead(newNode);
//                map.put(_key,newNode);
//            }
//
//            private void insertAfterHead(ListNode temp) {
//                temp.next=head.next;
//                temp.prev=head;
//                head.next.prev=temp;
//                head.next=temp;
//            }
//
//            private void deleteNode(ListNode temp) {
//                temp.prev.next=temp.next;
//                temp.next.prev=temp.prev;
//            }
//
//        }


////LFU Cache:


//Greedy Algorithm:

////Assign Cookies:
        int[] student={1,3,2,2,4,6};
        int[] cookie={1,2,3,3};

//        boolean[] used = new boolean[cookie.length];
//        int count = 0;
//
//        // Try to assign a cookie to each student
//        for (int i = 0; i < student.length; i++) {
//            for (int j = 0; j < cookie.length; j++) {
//
//                // If cookie not used and can satisfy student
//                if (!used[j] && cookie[j] >= student[i]) {
//                    used[j] = true;   // mark cookie as used
//                    count++;          // one student satisfied
//                    break;            // move to next student
//                }
//            }
//        }

//Brute force: TC:O(m*n) SC:O(1)

//        Arrays.sort(student);
//        Arrays.sort(cookie);
//
//        int i=0,j=0,count=0;
//
//        while (i<student.length && j<cookie.length){
//            if (cookie[j]>=student[i]){
//                count++;
//                i++;
//                j++;
//            }else {
//                j++;
//            }
//        }
//        System.out.println(count);

// Optimal:    TC:O(nlon+mlogm) SC:O(1)

//// Fractional Knapsack Problem:

        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        int W = 50;

For the Fractional Knapsack problem, a brute-force approach is not meaningful because items can be divided into fractions. The problem satisfies the greedy-choice
property, so the optimal solution is always obtained by selecting items in decreasing order of value-to-weight ratio. Unlike 0/1 Knapsack, there is no exponential
subset-based solution here — greedy is both optimal and efficient.”
 
//Brute force: TC:O(n2logn) SC:O(1)

//        Arrays.sort(items, (a, b) ->
//                Double.compare(
//                        (double) b.value / b.weight,   // descending
//                        (double) a.value / a.weight
//                )
//        );
//
//        double cost = 0.0;
//        int i = 0;
//
//        while (W > 0 && i < items.length) {
//
//            if (items[i].weight <= W) {
//                // take full item
//                W -= items[i].weight;
//                cost += items[i].value;
//            } else {
//                // take fraction
//                cost += ((double) items[i].value / items[i].weight) * W;
//                W = 0;
//            }
//            i++;
//        }
//
//        System.out.println(cost);

// Optimal:    TC:O(nlogn) SC:O(1)

////Find minimum number of coins:
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int V = 70;

//Brute force: TC:O(n2) SC:O(1)

//        int i = coins.length - 1;
//        int count = 0;
//
//        while (V > 0 && i >= 0) {
//            if (coins[i] <= V) {
//                int num = V / coins[i];   // number of coins
//                count += num;
//                V = V % coins[i];         // remaining value
//            }
//            i--;
//        }
//        System.out.println("Minimum coins required: " + count);

//“This is a greedy algorithm where we always choose the largest denomination possible.
//It works because the coin system is canonical, meaning greedy always gives the optimal solution.”

// Optimal:    TC:O(n) SC:O(1)

////Lemonade Change problem:

//        public static boolean lemonadeChange(int[] bills) {
//
//            int five = 0; // count of $5 bills
//            int ten = 0;  // count of $10 bills
//
//            for (int bill : bills) {
//
//                if (bill == 5) {
//                    // no change needed
//                    five++;
//                }
//                else if (bill == 10) {
//                    // need one $5 as change
//                    if (five == 0) return false;
//
//                    five--;
//                    ten++;
//                }
//                else { // bill == 20
//
//                    // prefer $10 + $5
//                    if (ten > 0 && five > 0) {
//                        ten--;
//                        five--;
//                    }
//                    // otherwise use 3 × $5
//                    else if (five >= 3) {
//                        five -= 3;
//                    }
//                    else {
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }

//Brute force: TC:O() SC:O()
// Optimal:    TC:O(n) SC:O(n)

////Valid Parenthesis Checker..


//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)




Jump Game: Given an array where each element represents the maximum number of steps, you can jump forward from that element, return true if we can reach the last index
           starting from the first index. Otherwise, return false.
           Example 1:
           Input:nums = [2, 3, 1, 0, 4]
           Output: True

           Explanation:
           We start at index 0, with value 2 this means we can jump to index 1 or 2.
           From index 1, with value 3, we can jump to index 2, 3, or 4. However, if we jump to index 2 with value 1, we can only jump to index 3.
           So we jump to index 1 then index 4 reaching the end of the array.
           Hence, we return true.

           Example 2:
            Input:nums = [3, 2, 1, 0, 4]
            Output: False
            Explanation:
            We start at index 0, with value 3 which means we can jump to index 1, 2, or 3.
            From index 1, with value 2 we can only jump to index 2 or 3.
            From index 2, with value 1 we can only jump to index 3.
            From index 3, with value 0 we cannot jump any further.
            Hence, from all possibilities, we are unable to jump to the last index so we return false.

 

//        int[] nums = {2, 3, 1, 0, 4};
//
//        int maxindex=0;
//        for(int i=0;i<nums.length;i++){
//
//            if(i>maxindex){
//                System.out.println("Can't be reached");
//                return;
//            }
//
//            maxindex=Math.max(maxindex,i+nums[i]);
//
//            if(maxindex>=nums.length-1){
//                System.out.println("Reached");
//                return;
//            }
//        }

//Brute force: TC:O() SC:O()
// Optimal:    TC:O(n) SC:O(1)

////Jump Game 2:
        // Range problem:

//        int[] nums = {2, 3, 1, 1, 4};
//        int jumps = 0;
//        int l = 0, r = 0;
//        int lastIndex = nums.length - 1;
//
//        while (r < lastIndex) {
//
//            int farthest = 0;
//
//            for (int i = l; i <= r; i++) {
//                farthest = Math.max(farthest, i + nums[i]);
//            }
//            jumps++;
//
//            if (farthest >= lastIndex) {
//                break;
//            }
//
//            l = r + 1;
//            r = farthest;
//        }
//        System.out.println(jumps);

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(1)


//// Candy:

//        int[] ratings = {1, 2, 3, 2, 1};
//        int n=ratings.length;
//        int[] left= new int[n];
//        int[] rigth=new int[n];
//
//        left[0]=1;
//        rigth[n-1]=1;
//
//        for(int i=1;i<n;i++){
//            if(ratings[i]>ratings[i-1]){
//                left[i]=left[i-1]+1;
//            }else {
//                left[i]=1;
//            }
//        }
//        for(int i=n-2;i>=0;i--){
//            if(ratings[i]>ratings[i+1]){
//                rigth[i]=rigth[i+1]+1;
//            }else {
//                rigth[i]=1;
//            }
//        }
//
//        int candies=0;
//        for(int i=0;i<n;i++){
//            candies+=Math.max(left[i],rigth[i]);
//        }
//
//        System.out.println(candies);

//Brute force: TC:O(3n) SC:O(2n)
// in this we can remove right array then TC:O(2n) SC:O(n)

// Optimal:    TC:O(4n) SC:O(2n) Curve approach needs to be solved

//// Job Sequencing Problem:


The Job Sequencing Problem is a classic greedy scheduling problem, but it is NOT an interval-overlap problem like meetings or platforms. Here, each job has a
 deadline and a profit, and each job takes exactly one unit of time. The goal is to maximize total profit by scheduling jobs so that at most one job is done at
  any time, and each job finishes on or before its deadline.
 

//        int[][] jobs = {
//                {1, 4, 20},
//                {2, 1, 10},
//                {3, 1, 40},
//                {4, 1, 30}
//        };
//
//        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
//
//        int maxdeadline = 0;
//        for (int[] job : jobs) {
//            maxdeadline = Math.max(maxdeadline, job[1]);
//        }
//
//        int[] completedjobs = new int[maxdeadline + 1];
//        Arrays.fill(completedjobs, -1);
//
//        int totalprofit = 0;
//        int jobcount = 0;
//
//        for (int i = 0; i < jobs.length; i++) {
//
//            int jobId = jobs[i][0];
//            int deadline = jobs[i][1];
//            int profit = jobs[i][2];
//
//            // IMPORTANT: go only till deadline
//            for (int j = deadline; j > 0; j--) {
//
//                if (completedjobs[j] == -1) {
//                    completedjobs[j] = jobId;
//                    totalprofit += profit;
//                    jobcount++;
//                    break; // VERY IMPORTANT
//                }
//            }
//        }

// N=jobs.length, M=completedjobs.length
//Brute force: TC:O() SC:O()
// Optimal:    TC:O( O(N log N) + O(N * M),) SC:O(M)



----------------------------------------------------------------INTERVAL: An interval represents a continuous range of values.------------------------------------------------

(5, 10) → all numbers between 5 and 10
[3, 7] → all numbers from 3 to 7 including both

| Notation | Meaning                                |
| -------- | -------------------------------------- |
| `(a, b)` | open interval → excludes `a` and `b`   |
| `[a, b]` | closed interval → includes `a` and `b` |
| `[a, b)` | left closed, right open                |
| `(a, b]` | left open, right closed                |

📌 Intersection of Intervals: Two intervals intersect if they share at least one common point.

                                        40                                         100
A                                       |-------------------------------------------|

B1(30,50)                       |------------|
B2(50,70)                                    |-------------------|
B3(70,120)                                                       |----------------------------------|
B4(30,120)                      |-------------------------------------------------------------------|
B5(10,30)         |-------------|
B6(120,140)                                                                                         |-------------|
We can check whether the particular interval is intersecting other interval or not by using below code for all the above 4 possible condition:

        if (A.start <= B.end && B.start <= A.end)

📌 Disjoint (Non-Overlapping) Intervals: Intervals that do not intersect at all.
    Example: B5,B6

        if (A.end < B.start || B.end < A.start)

📌 Subinterval: Interval B is a subinterval of A if, Every point of B lies inside A.
    Example: B2
        A.start ≤ B.start AND B.end ≤ A.end

        Two intervals overlap if:

📌 Overlapping Intervals: A overlaps B if A and B intersect, but neither A is a subinterval of B nor B is a subinterval of A.

    Example: B1,B3

    boolean overlap =
    (aStart <= bEnd && bStart <= aEnd) &&   // intersect
    !(aStart <= bStart && aEnd >= bEnd) &&  // A does NOT contain B
    !(bStart <= aStart && bEnd >= aEnd);    // B does NOT contain A

    -----In most DSA problems, overlap simply means intersection. The above one is maths definition---------

        But for DSA we prefer below one: That includes:

            partial overlap
            full containment (subintervals)

Touching Intervals:
Overlapping Subintervals:

        A  = (5, 15)   // parent / container interval
        B1 = (6, 10)   // subinterval of A
        B2 = (8, 12)   // subinterval of A

        To say B1 and B2 are overlapping subintervals of A, ALL of the following must be true:

            B1 and B2 are both subintervals of A
            B1 and B2 intersect with each other

            The overlap happens inside A

            So the overlap is not defined by A,
            it is defined by the relationship between B1 and B2, within A.

        Conditions to Define Overlapping Subintervals:

            1️⃣ Both are subintervals of A:

                    boolean B1_in_A = (aStart <= b1Start && b1End <= aEnd);
                    boolean B2_in_A = (aStart <= b2Start && b2End <= aEnd);

            2️⃣ B1 and B2 intersect (overlap with each other):

                    boolean B1_B2_intersect =(b1Start <= b2End && b2Start <= b1End);

    In interval problems, the choice of sorting depends entirely on what decision your algorithm is making. If the task is to merge or extend intervals—such as in
    *Merge Intervals*, *Insert Interval*, or *Interval Intersection*—you should sort by start time, because merging is based on checking whether the next interval
    starts before the current one ends (`current.start ≤ previous.end`). Sorting by start guarantees that all overlapping intervals appear consecutively, allowing
    a safe linear merge. On the other hand, if the task is to choose or select intervals—for example, finding the maximum number of meetings, minimum removals, or
    minimum arrows to burst balloons—you should sort by end time, because selecting the interval that finishes earliest leaves maximum room for future intervals.
    A simple hint to remember is: “Merging → watch the start, Choosing → watch the end.”



 Merge intervals:

    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that
    cover all the intervals in the input.
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    If the intervals are sorted on start, then we can check merge condition with A.end>=B.start

 

//        int[][] intervals = { {1, 3}, {2, 6}, {1,9}, {0,100} , {8, 10}, {15, 18} };

//        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//        List<int[]> result=new ArrayList<>();
//
//        for(int i=0;i<intervals.length;i++){
//            int start=intervals[i][0];
//            int end=intervals[i][1];
//
//            if(!result.isEmpty() && result.getLast()[1]>=end){
//                continue;
//            }
//
//            for(int j=i+1;j<intervals.length;j++){
//                if(end>=intervals[j][0]){
//                    end=Math.max(end,intervals[j][1]);
//                }
//            }
//
//            result.add(new int[]{start,end});
//        }
//
//        System.out.println(Arrays.deepToString( // 2d Array
//                result.toArray(new int[result.size()][]))
//        );

//Brute force: TC:O(n2) SC:O(n)

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
//            while(j<intervals.length && end>=intervals[j][0]){
//                end=Math.max(end,intervals[j][1]);
//                j++;
//            }
//            ans.add(Arrays.asList(start,end));
//            i=j;
//        }
//
//        System.out.println(ans);

//Brute force: TC:O(nlogn) SC:O(n)

  Insert Interval:

    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals
    is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals
    (merge overlapping intervals if necessary).Return intervals after the insertion.
    Note that you don't need to modify intervals in-place. You can make a new array and return it.

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

 

//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};

//        List<int[]> list=new ArrayList<>();
//        for(int[] arr:intervals){
//            list.add(arr);
//        }
//        list.add(newInterval);
//        Collections.sort(list,(a,b)->a[0]-b[0]);
//
//        List<int[]> result=new ArrayList<>();
//
//        int n=list.size();
//        int i=0;
//
//        while (i<n){
//            int start=list.get(i)[0];
//            int end=list.get(i)[1];
//
//            int j=i+1;
//
//            while (j<n && end>=list.get(j)[0]){
//                end=Math.max(end,list.get(j)[1]);
//                j++;
//            }
//
//            result.add(new int[]{start,end});
//            i=j;
//        }
//
//        System.out.println(
//                Arrays.deepToString(result.toArray(new int[result.size()][]))
//        );

//Brute force: TC:O(n + nlogn + n) SC:O(n)


        This is an Interval Traversal + Merge problem. We divide the process into 3 logical phases:
        Intervals completely before newInterval.Intervals overlapping with newInterval.Intervals completely after newInterval.


//        List<int[]> result = new ArrayList<>();
//        int n = intervals.length;
//        int i = 0;
//
//        int start = newInterval[0];
//        int end = newInterval[1];
//
//        // 1️⃣ Add intervals before newInterval
//        while (i < n && intervals[i][1] < start) {
//            result.add(intervals[i]);
//            i++;
//        }
//
//        // 2️⃣ Merge overlapping intervals
//        while (i < n && end>=intervals[i][0]) {
//            start = Math.min(start, intervals[i][0]);
//            end = Math.max(end, intervals[i][1]);
//            i++;
//        }
//
//        result.add(new int[]{start, end});
//
//        // 3️⃣ Add remaining intervals
//        while (i < n) {
//            result.add(intervals[i]);
//            i++;
//        }

// Optimal:    TC:O(n) SC:O(1)

 N meetings in one room:

    There is one meeting room in a firm. You are given two arrays, start and end each of size N. For an index ‘i’, start[i] denotes the starting time of the ith meeting
    while end[i] will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room
    at a particular time. Print the order in which these meetings will be performed.

    Solution:Maximum number of meetings that can be held in ONE room such that no meetings overlap.

    In this type of questions we have to avoid overlaps.How can We Avoid Overlaps in Problems?

    Step 1️⃣ First Question You MUST Ask: Is overlap allowed or not?
           If the problem says:
           one room, one machine, one resource, cannot run simultaneously
           non-overlapping
           👉 Overlaps must be avoided

     What Does “Avoid Overlap” Mean (Formally)?

     Step 2️⃣ Two intervals A and B do NOT overlap if:
            end(A) ≤ start(B)

    Step  3️⃣ Universal Strategy to Avoid Overlaps:

            Always Free the Resource as Early as Possible
            That means: Pick the interval that ends first

    Step 4️⃣ General Greedy Pattern (Works Everywhere)
            Algorithm Skeleton:

            Convert input to intervals (start, end)
            Sort intervals by end time
            Pick the first interval
            For every next interval:
            If start ≥ lastEnd
            select it
            update lastEnd

    Step 5️⃣ Why This Greedy Choice Works (Intuition):

            If you pick a long interval early: You block many future intervals.
            If you pick a short interval:  You leave space for more intervals.

    | Problem                | What “Avoid Overlap” Means |
    | ---------------------- | -------------------------- |
    | N meetings in one room | One meeting at a time      |
    | CPU job scheduling     | One job on CPU             |
    | Task scheduling        | One task per slot          |
    | Movie watching         | One movie at a time        |
    | Classroom allocation   | One class per room         |

📌 Although both problems involve time intervals, their brute-force complexities differ because the **nature of the task is different**. In **N Meetings in One Room**,
   the goal is to **select an optimal subset of meetings** such that none overlap, which means each meeting represents a decision (take or not take). Without sorting
   or greedy reasoning, being fully correct requires trying **all possible subsets**, leading to an **exponential brute-force complexity of O(2ⁿ · n)**. In contrast,
   the **Minimum Platforms Required** problem does not involve selecting or rejecting trains; all trains must be accommodated, and the task is simply to **count how many
   trains overlap at any given time**. This can be done by comparing each train with every other train, resulting in a **quadratic brute-force complexity of O(n²)**.
   The key reason for the difference is that the meetings problem is a **combinatorial selection problem**, while the platforms problem is a **pure overlap-counting
   problem**.

   Meetings problem: “Which meetings should I attend?”
   Platforms problem: “How many people are inside the room at the same time?”

   Although both problems involve intervals, the meeting scheduling problem is a subset selection problem that leads to an exponential brute-force solution,
   whereas the minimum platforms problem only requires counting overlapping intervals, which results in a quadratic brute-force solution.


 

//Brute force: TC:O(2^n) SC:O(n)
//Brute force: TC:O(n2) SC:O(n) DP

//        int[] start = {1, 3, 0, 5, 8, 5};
//        int[] end   = {2, 4, 6, 7, 9, 9};
//
//        List<int[]> meetings = new ArrayList<>();
//
//        for (int i = 0; i < start.length; i++) {
//            meetings.add(new int[]{start[i], end[i], i + 1});
//        }
//
//        // Sort by end time
//        meetings.sort((a, b) -> a[1] - b[1]);
//
//        List<Integer> result = new ArrayList<>();
//
//        int lastEnd = -1;   // or Integer.MIN_VALUE
//
//        for (int i = 0; i < meetings.size(); i++) {
//            if (meetings.get(i)[0] > lastEnd) {
//                result.add(meetings.get(i)[2]);
//                lastEnd = meetings.get(i)[1];
//            }
//        }
//
//        System.out.println(result);
// Optimal:    TC:O(nlogn + n) SC:O(n)

 Non-overlapping Intervals:

    Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the
    intervals non-overlapping.

    Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

    Example 1:

    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
    Output: 1
    Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

    Note:Intervals which only touch at a point are also considered as non-overlapping. For example, [1, 3] and [3, 4] are non-overlapping.

 

//        int[][] intervals = { {1, 3}, {2, 4}, {3, 5}, {1, 2} };

//        int n = intervals.length;
//        boolean[] removed = new boolean[n];
//        int removals = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (removed[i]) continue;
//
//            for (int j = i + 1; j < n; j++) {
//                if (removed[j]) continue;
//
//                // overlap check (touching is allowed)
//                if (intervals[i][0] < intervals[j][1] &&
//                        intervals[j][0] < intervals[i][1]) {
//
//                    // remove the interval with larger end
//                    if (intervals[i][1] <= intervals[j][1]) {
//                        removed[j] = true;
//                    } else {
//                        removed[i] = true;
//                        break;
//                    }
//                    removals++;
//                }
//            }

//Brute force: TC:O(n2) SC:O(n)


//        if (intervals.length == 0) return;
//
//        // sort by end time
//        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
//
//        int removals = 0;
//        int lastEnd = intervals[0][1];
//
//        for (int i = 1; i < intervals.length; i++) {
//
//            // overlap (touching allowed)
//            if (intervals[i][0] < lastEnd) {
//                removals++;
//            } else {
//                lastEnd = intervals[i][1];
//            }
//        }

// Optimal:    TC:O(n) SC:O(1)

 Minimum number of platforms required for a railway station:

    Given the arrival and departure times of all trains reaching a particular railway station, determine the minimum number of platforms required so that no train
    is kept waiting. Consider all trains arrive and depart on the same day. In any particular instance, the same platform cannot be used for both the departure of
    one train and the arrival of another train, requiring the use of different platforms in such cases.

    Note: Time intervals are in the 24-hour format (HHMM), where the first two characters represent hour (between 00 to 23 ) and the last two characters represent
    minutes (this will be <= 59 and >= 0). Leading zeros for hours less than 10 are optional (e.g., 0900 is the same as 900).

    Example 1

    Input: Arrival =   [900, 940, 950, 1100, 1500, 1800] ,
            Departure = [910, 1200, 1120, 1130, 1900, 2000]

    Output: 3

    Explanation : The first, second, fifth number train can use the platform 1.The third and sixth train can use the platform 2.
    The fourth train will use platform 3. So totally we need 3 different platforms for the railway station so that no train is kept waiting.

    In the minimum number of platform problem, one platform can serve only one train at a time. So if we fix a particular train, that train occupies a platform from
    its arrival time to its departure time. While this train is present, any other train that arrives before it departs will need a different platform.
    Therefore, for each train, we need to count how many other trains have arrival times that lie between its arrival and departure interval. This is exactly an
    interval intersection (overlap) problem. If two trains’ time intervals intersect, they cannot share the same platform. The minimum number of platforms required
    is simply the maximum number of overlapping intervals at any point in time.

 

//        int[] arr = {900, 945, 955, 1100, 1500, 1800};
//        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
//        int n = arr.length;

//        int maxPlatforms = 0;
//        for(int i=0;i<n;i++){
//            int platformneeded=1;
//
//            for(int j=i+1;j<n;j++){
//
//                if(dep[i]>=arr[j] && dep[j]>=arr[i]){
//                    platformneeded++;
//                }
//            }
//            maxPlatforms=Math.max(maxPlatforms,platformneeded);
//        }

//Brute force: TC:O(n2) SC:O(1)
        
 The optimal approach to find the minimum number of platforms required at a railway station is based on counting how many trains are present at the station at the same
  time. Each train is treated as an interval defined by its arrival and departure times. We first sort the arrival times and departure times separately so that events
  can be processed in chronological order of time.How in real world arrival departure happening. Then, using two pointers, we sweep through time: whenever the next
   arrival time is earlier than the next departure time,
  it means a new train has arrived while no platform has yet been freed, so we increase the platform count; otherwise, a train has departed and a platform becomes
  available, so we decrease the count. While doing this, we continuously track the maximum number of platforms in use at any moment, because that maximum represents
   the minimum number of platforms required to handle all trains without delay. This approach runs in (O(n \log n)) time due to sorting and efficiently captures the
    peak overlap of train intervals.
                

//        Arrays.sort(arr);
//        Arrays.sort(dep);
//        int i=0,j=0;
//        int platforms=0;
//        int maxplatforms=0;
//
//        while (i<n && j<n){
//
//            if(dep[j]>=arr[i]){
//                platforms++;
//                maxplatforms=Math.max(maxplatforms,platforms);
//                i++;
//            }else {
//                platforms--;
//                j++;
//            }
//        }

// Optimal:    TC:O(2nlogn + n) SC:O(1)

*/

    }}






