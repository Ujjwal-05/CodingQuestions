package Coding;

import java.util.Arrays;

//Find pairs with given sum in sorted array:
public class Array {
    public static void main(String[] args) {
        System.out.println("Happy Coding");

////Reverse a number or Check palindrome.
//        int num=121;
//        int reversed=0, temp=num;
//
//        while(temp>0){
//            reversed=reversed*10 + temp%10;
//            temp/=10;
//        }

//// Armstrong:
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


//// Moves zero to end:
//        int [] arr={0,5,0,1,2,3,0,0,4,5,0,0};

//        int left=0, right=arr.length-1;
//        while (left<right){
//            if( arr[left]==0 && arr[right]!=0){
//                int temp=arr[left];
//                arr[left]=arr[right];
//                arr[right]=temp;
//                left++;
//                right--;
//            } else if ( arr[left]!=0 ) {
//                left++;
//            } else if ( arr[right]==0){
//                right--;
//            }
//        }

// Maintain insertion order:
//        int[] arr = {2, 0, 0, 2, 1, 0, 2, 3, 4, 5, 0};
//
//        int i = 0;
//        for (int j = 0; j < arr.length; j++) {
//            if (arr[j] != 0) {
//                // Only swap if i and j are different
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//            }
//        }

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

////Find the number that appears once, and other numbers twice.
//
//        int[] arr={1,1,2,2,3,3,4,4,5,5,6};
//        int res=0;
//
//        for (int num:arr){
//            res=res^num;
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

////Find pairs with given sum in Unsorted array:
//        int arr[] = {1,1,2,2,3,4,4,5,6,7,8,0,9};  int k = 9;
//
//        Set<Integer> set=new HashSet<>();
//
//        for (int num:arr){
//            int compliment=k-num;
//
//            if(set.contains(compliment)){
//                System.out.println(num +"  "+ compliment);
//            }
//
//            set.add(num);
//
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
//                int temp = a[left];
//                a[left] = a[right];
//                a[right] = temp;
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
//
////        int[] arr={2, 3, -4, 5, 0, 4, -2, 2};
//        int i=0,j=0,sum=0,length=0;
//        HashMap<Integer,Integer> hashMap=new HashMap<>();
//
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

//// Count Subarrays with Given Sum K (Positives + Negatives).
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

////Longest Subarray with Equal Number of 0s and 1s.
//        map.put(0, -1); // handle subarray starting at index 0
//
//        for (int i = 0; i < arr.length; i++) {
//            sum += (arr[i] == 0 ? -1 : 1);
//
//            if (map.containsKey(sum)) {
//                int len = i - map.get(sum);
//                maxLen = Math.max(maxLen, len);
//            }
//
//            // only store the first occurrence of this prefix sum
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
//
//            map.putIfAbsent(key,i);
//
//        }

//// Two Sum: (Hashing and Two Pointer): for two pointer we need to sort the element
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//
//        for (int num : arr) {
//            int rem = k - num;
//
//            // If complement exists, add its frequency to count
//            if (map.containsKey(rem)) {
//                count += map.get(rem);
//            }
//
//            // Update frequency of current number
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        return count;
//    }

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
//                int temp=arr[mid];
//                arr[mid]=arr[high];
//                arr[high]=temp;
//                high--;
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));

////  Return an element that occurs more than N/2 times:
//
//        int[] arr={2,3,5,0,0,0,0,0};
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
//        int[] arr = {1, 2, 2, 3, 2, 1, 1};
//        int k=arr.length-1;
//
//        for(int  num:arr){
//            if(cnt1==0 && num!=e2){
//                cnt1=1;
//                e1=num;
//            } else if (cnt2==0 && num!=e1) {
//                cnt2=1;
//                e2=num;
//            } else if (num==e1) {
//                cnt1++;
//            } else if (num==e2) {
//                cnt2++;
//            }else {
//                cnt1--;
//                cnt2--;
//            }
//        }

//// Most frequent Element:
//
//        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4};
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int maxFreq = 0;
//        int mostFreqElement = arr[0];
//
//        for (int num : arr) {
//            int count = map.getOrDefault(num, 0) + 1;
//            map.put(num, count);
//
//            if (count > maxFreq) {
//                maxFreq = count;
//                mostFreqElement = num;
//            }
//        }
//
//        System.out.println(mostFreqElement);

////Maximum subarray Sum( find the contiguous subarray (containing at least one number) which has the largest sum):

//        int[] arr = { -2, -1, -3, -4, -1, -2,-1, -5, -4};
//        int max_sum=Integer.MIN_VALUE;
//        int sum=0,j=0;
//        for(int i=0;i<arr.length;i++) {
//            sum += arr[i];
//
//            if(sum>max_sum){
//                max_sum=sum;
////                length=i-j+1;
//            }
//
//            if(sum<0){
//                sum=0;
//                j=i+1;
//            }
//
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
//        sum=1;
//        max_sum=1;
//        for(int num:arr){
//            sum*=num;
//            max_sum=Math.max(sum,max_sum);
//            if(sum<=0){
//                sum=1;
//            }
//        }

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
//        // res: 1,
//        int res[] =new int[nums.length];
//
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

//        Return an element that occurs more than N/3 times:
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
//
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


//// Count number of subarrays whose product is less than equal to k;
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
        int piles[] = {7, 15, 6, 3}; int h = 8;

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
        int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
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

////Capacity to Ship Packages within D Days:
        int[] weights = {5,4,5,2,3,4,5,6}; int d = 5;

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


//// Aggressive Cows: maxofmin
        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;



 }
}




