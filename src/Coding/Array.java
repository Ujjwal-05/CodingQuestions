package Coding;

import java.util.*;

public class Array {
    public static void main(String[] args) {
        System.out.println("Hello");

////Reverse a number or Check palindrome.
//        int num=121;
//        int reversed=0, temp=num;
//
//        while(temp>0){
//            reversed=reversed*10 + temp%10;
//            temp/=10;
//        }
//
//        System.out.println(reversed==num);

//// Armstrong:
//
//        static boolean isArmstrong(int num) {
//            int original = num;
//            int digits = (int) Math.floor(Math.log10(num)) + 1;
//            int sum = 0;
//
//            while (num > 0) {
//                int rem = num % 10;
//                sum += (int) Math.pow(rem, digits);
//                num /= 10;
//            }
//
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
//
//        System.out.println(second_larget);

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
//
//        System.out.println(left);
//        System.out.println(Arrays.toString(arr));

//// Left rotate array by d place:
//        int [] a={1,2,3,4,5};
//        int k =3;
//
//        Reverse(a,0,k-1);
//        Reverse(a,k,a.length-1);
//        Reverse(a,0,a.length-1);
//
//        System.out.println(Arrays.toString(a));

//// Moves zero to end:
///
//        int [] arr={0,0,0,1,2,3,0,0,4,5,0,0};
//
//        //Doesn't maintain insertion order:
//
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
//
//        System.out.println(Arrays.toString(arr));
//
//        //Maintain insertion order:
//
//         arr=new int[]{1,1,1,0,0,0,2,3,4,5,0,0,0};
//        int largest=0,secondlargest=0;
//        int i=0;
//
//        for(int j=0;j<arr.length;j++){
//            if(arr[j]!=0){
//                int temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//                i++;
//            }
//        }

//        System.out.println(Arrays.toString(arr));

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
//
//        System.out.println(union);

////Find the number that appears once, and other numbers twice.
//
//        int[] arr={1,1,2,2,3,3,4,4,5,5,6};
//        int res=0;
//
//        for (int num:arr){
//            res=res^num;
//        }
//
//        System.out.println(res);

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
//
//
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
//
//        int[] arr = { -2, 1, -3, 4, -1, -2, 1, 5, -4};
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
//
//        }

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
//                min_prod=max_prod;
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

//// Longest Substring Without Repeating Characters:
//        String str = "takeUforward";
//        int maxlen=0,len=0;

//        for(int i=0;i<str.length();i++){
//            HashSet<Character> set =new HashSet<>();
//            for(int j=i;j<str.length();j++){
//
//                if(set.contains(str.charAt(j))) break;
//
//                set.add(str.charAt(j));
//                maxlen=Math.max(maxlen,j-i+1);
//
//            }
//        }

//        int left=0;
//        HashMap<Character,Integer> map=new HashMap<>();
//
//        for(int right=0;right<str.length();right++){
//            char c=str.charAt(right);
//            if(map.containsKey(c) && map.get(c)>=left){
//                left=map.get(c)+1;
//            }
//
//            map.put(c,right);
//            maxlen=Math.max(maxlen,right-left+1);
//
//        }
//
//        System.out.println(maxlen);

//// Maximum Consecutive ones |||:

//        int nums[] = {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1};
//        int k = 3,maxLen=0,n=nums.length;

//        for (int i = 0; i < n; i++) {
//            int zeroes = 0;
//
//            for (int j = i; j < n; j++) {
//                if (nums[j] == 0) zeroes++;
//
//                if (zeroes > k) break; // window invalid
//
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
//
//        System.out.println(maxLen);

////Fruit Into Baskets or Also known as: Longest Subarray with at most 2 distinct elements:
//        int nums[]={1,1,0,2,2,1,1,2,2,0,0,1};
//        int k=2,n=nums.length, maxlen=0,left=0;
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

////longest repeating character replacement:: Length of the longest substring where you can make all characters equal after at most k replacements.

//        String str="ABBCCD";
//        int k=2,maxlen=0;

//        for(int i=0;i<str.length();i++){
//            int[] freq=new int[26];
//            int maximum=0;
//            for(int j=i;j<str.length();j++){
//
//                freq[str.charAt(j)-'A']++;
//                maximum=Math.max(maximum,freq[str.charAt(j)-'A']);
//                int windowsize=j-i+1;
//                if(windowsize-maximum<=k){
//                    maxlen=Math.max(maxlen,windowsize);
//                }
//
//            }
//        }

//        while (right < str.length()) {
//
//            // Increment the frequency of current character
//            freq[s.charAt(right) - 'A']++;
//
//            // Update maxCount with the max frequency seen so far
//            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
//
//            // If the current window needs more than k replacements, move left
//            while ((right - left + 1) - maxCount > k) {
//                freq[s.charAt(left) - 'A']--;
//                left++;
//            }
//
//            // Update the maximum window length
//            maxLength = Math.max(maxLength, right - left + 1);
//
//            // Move right pointer forward
//            right++;
//        }

////Binary subarray with sum: You are given a binary array nums (containing only 0s and 1s) and an integer goal.Return the number of non-empty subarrays of
//nums that sum to goal. A subarray is a contiguous part of the array.

//        int[] nums = {1, 0, 0, 1, 1, 0};
//        int goal = 2, count=0;
//
//        for(int i=0;i<nums.length;i++){
//            int sum=0;
//            for(int j=i;j<nums.length;j++){
//                sum+=nums[j];
//                if(sum==goal) count++;
//       }}
//        System.out.println(count);

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
//
//        System.out.println(count);

////Count number of nice subarrays:

//        int [] nums={1,1,2,1,1};
//        int k=3,count=0,odd=0,left=0;

//        for(int i=0;i<nums.length;i++){
//            int odd=0;
//            for(int j=i;j<nums.length;j++){
//
//                if(nums[j]%2==1) odd++;
//                if(odd==k) count++;
//                if(odd>k) break;
//            }
//        }
//        System.out.println(count);

//        for(int num:nums){
//
//            if(num%2==1) odd++;
//
//            while (odd>k){
//                if(nums[left]%2==1) odd--;
//                left++;
//            }
//
//            if(odd==k){
//                count++;
//            }
//
//        }
//        System.out.println(count);

////Number of substring containing all three characters:

//        String str="ccabcc";
//        int count=0;
//        for(int i=0;i<str.length();i++){
//            int [] freq=new int[3];
//            for(int j=i;j<str.length();j++){
//                freq[str.charAt(j)-'a']++;
//                if(freq[0]>=1 && freq[1]>=1 && freq[2]>=1) count++;
//                }
//            }

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

////Maximum point you can obtain from cards:

//        int[] cards = {5, 4, 1, 8, 7, 1, 3};
//        int k = 3, temp=k,sum=0,left=0,right=cards.length-1;

//// Longest Substring with At Most K Distinct Characters:
//        String str="aababbcaacc";
//        int k = 2,maxlen=0;

//        for(int i=0;i<str.length();i++){
//            HashMap<Character,Integer> map=new HashMap<>();
//            for (int j=i;j<str.length();j++){
//                Character c=str.charAt(j);
//                map.put(c,map.getOrDefault(c,0)+1);
//                if(map.size()<=k){
//                    maxlen=Math.max(maxlen,j-i+1);
//                }
//                else {
//                    break;
//                }
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

//// Subarray with k different integers:
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2,count=0;

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
//        System.out.println(count);

//            int left = 0, count = 0;
//            HashMap<Integer, Integer> map = new HashMap<>();
//
//            for (int right = 0; right < nums.length; right++) {
//
//                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
//
//                // Shrink window until it has at most K distinct numbers
//                while (map.size() > K) {
//                    map.put(nums[left], map.get(nums[left]) - 1);
//                    if (map.get(nums[left]) == 0) {
//                        map.remove(nums[left]);  // distinct count decreases
//                    }
//                    left++;
//                }
//                count += right - left + 1;
//            }

//// Minimum Window Substring:

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

//        String s = "ADOBECODEBAANC";
//        String t = "ABCA";
//
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




























    }
















        }








////Java programme to print distinct element in Sorted array: First element is always distinct in an array.
//
//        int arr[] = {1, 1, 2, 3, 4, 4, 5, 6, 6};
//
//        Arrays.stream(arr).distinct().forEach(System.out::println);
//
//        System.out.println(arr[0]);
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i - 1] != arr[i]) {
//                System.out.println(arr[i]);
//            }
//        }

////Java programme to print distinct element in UnSorted array.
//
//        int arr[]= {1,5,3,10,10,2,2,5};
//
//        Arrays.stream(arr).distinct().sorted().forEach(System.out::println);
//
//        HashSet<Integer> set= new HashSet<>();
//
//        for(int a:arr){
//
//            if(set.add(a)){
//                System.out.println(set);
//            }
//        }


////Print duplicate elements in Sorted array:
//
//        int arr[]={1,2,2,2,3,3,4,5,5,6};
//
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i]==arr[i+1]){
//
//                if(i==0 || arr[i]!=arr[i-1]) {
//                    System.out.println(arr[i]);
//                }
//            }
//        }


////Print duplicate elements in Unsorted array:
//
//        int arr[]= {10,10,1,2,3,4,5,5,5,6,6,1};
//
//        HashMap<Integer,Integer> map=new HashMap<>();
//
//        for(int num:arr){
//            map.put(num, map.getOrDefault(num,0)+1);
//        }
//
//        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//            if (entry.getValue()>1){
//                System.out.println(entry.getKey());
//            }
//        }

////Find pairs with given sum in sorted array:
//
//        int arr[] = {1,1,2,2,3,4,4,5,6,7,8};
//        int k = 9;
//        int left = 0, right = arr.length - 1;
//
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
//
//        int arr[] = {1,1,2,2,3,4,4,5,6,7,8,0,9};
//        int k = 9;
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

// Remove duplicates from Sorted array:

//}

