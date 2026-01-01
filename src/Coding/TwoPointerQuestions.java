package Coding;

public class TwoPointerQuestions {
    public static void main(String[] args) {
/*
////Find the union of the 2 sorted array and result should be sorted:

        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};

        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            } else {
                // arr1[i] == arr2[j], add one of them
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

        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0, -1); // handle subarray starting at index 0

        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] == 0 ? -1 : 1);

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            }
            map.putIfAbsent(sum, i);
        }

////Largest Subarray with Equal Number of 0s, 1s, and 2s.
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
////Maximum Product sub array.
        int[] arr = {2, -1, 2, -1, 6, 4};

        int min_prod=arr[0];
        int max_prod=arr[0];
        int ans=arr[0];

        for( i=1;i<arr.length;i++){
            int curr=arr[i];
            if(curr<0){
                int temp=max_prod;
                max_prod=min_prod;
                min_prod=temp;
            }

            max_prod=Math.max(curr,max_prod*curr);
            min_prod=Math.min(curr,min_prod*curr);

            ans=Math.max(max_prod,ans);
        }

        System.out.println(ans);

//// Maximum subarray Sum:
        int[] arr = { -2, -1, 3, 4, -1, 2,-1};

        int max_sum=Integer.MIN_VALUE;
        int sum=0,j=0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];

            if(sum>max_sum){
                max_sum=sum;
                length=i-j+1;
            }

            if(sum<0){
                sum=0;
                j=i+1;
            }
        }
        System.out.println(max_sum);

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

////Product of Array Except Self.
        int[] nums = {1, 2, 3, 4,5};

        int res[] =new int[nums.length];
        res[0]=1;
        // prefix
        for(int i=1;i<nums.length;i++){
            res[i]=res[i-1]*nums[i-1];
        }

        int suffix=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=suffix;
            suffix*=nums[i];
        }

        System.out.println(java.util.Arrays.toString(res));

////find the length of the longest consecutive elements sequence.
        int[] arr = {100, 4, 200, 1, 3, 2, 2};
        int maxlen = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        for (int num : set) {
            if (!set.contains(num - 1)) { // start of a sequence
                int curr = num;
                int len = 1; // reset for each new sequence

                while (set.contains(++curr)) {
                    len++;
                }

                maxlen = Math.max(maxlen, len);
            }
        }

        System.out.println(maxlen);

////  Return an element that occurs more than N/2 times:

        int count=0, max_element=-1;

        for (int i=0;i<arr.length;i++){
            if(count==0){
                count=1;
                max_element=arr[i];
            } else if (max_element==arr[i]) {
                count++;
            }else {
                count--;
            }

        }

        int count1=0;
        for(int num:arr){
            if(num==max_element){
                count1++;
            }
        }

        if(count1>Math.floor(arr.length/2)){
            System.out.println(max_element);
        }else {
            System.out.println(-1);
        }

////Return an element that occurs more than N/3 times:
        int[] arr={2,1,1,3,1,4,5,6};

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);

            if(map.get(num)>arr.length/3){
                ans.add(num);
            }

            if(ans.size()==2) break;
        }

        int e1=-1, e2=-1, cnt1=0, cnt2=0;

        for(int num:arr){
            if(cnt1==0 && num!=e2){
                e1=num;
                cnt1++;
            } else if (cnt2==0 && num!=e1) {
                e2=num;
                cnt2++;
            } else if (num==e1) cnt1++;
            else if (num==e2) cnt2++;
            else {
                cnt1--;
                cnt2--;
        }
        }
        // Step 2: Verify actual counts
        cnt1 = 0;
        cnt2 = 0;
        for (int num : arr) {
            if (num == e1) cnt1++;
            else if (num == e2) cnt2++;
        }


          // Step 3: Collect results
        List<Integer> res = new ArrayList<>();
        if (cnt1 > arr.length / 3) res.add(e1);
        if (cnt2 > arr.length / 3) res.add(e2);

////Sort an array of 0s, 1s and 2s:

        int[] arr={1,0,2,2,2,1,1,1,0,0,0,1,1,1,2,2,2,2};
        int low=0, mid=0,high=arr.length-1;
        while (mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            }else {
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }


//// Two Sum: Given an unsorted array of integers arr[] and an integer target, find any pair of elements whose sum equals target.

        int[] arr = {2, 7, 11, 15};
        int k = 9;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int rem = k - num;

            if (map.containsKey(rem)) {
                count += map.get(rem);  // count all occurrences
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//// 3 Sum Problem: Find three numbers in an array whose sum equals a given target:
        int[] arr = {-1, 0, 1, 2, -1, -4};
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


////Merge two sorted array Without Extra Space:

     int n = firstArray.length;
        int m = secondArray.length;

        // Traverse second array from right to left
        for (int indexB = m - 1; indexB >= 0; indexB--) {

            // If the current element of secondArray is
            // smaller than the largest element of firstArray
            if (firstArray[n - 1] > secondArray[indexB]) {

                // Store last element of firstArray
                int lastElement = firstArray[n - 1];

                int indexA = n - 2;

                // Shift elements in firstArray to make space
                while (indexA >= 0 && firstArray[indexA] > secondArray[indexB]) {
                    firstArray[indexA + 1] = firstArray[indexA];
                    indexA--;
                }

                // Insert element from secondArray into correct position
                firstArray[indexA + 1] = secondArray[indexB];

                // Move last element of firstArray to secondArray
                secondArray[indexB] = lastElement;
            }
        }


        int[] arr1 = {1, 3, 5, 7}; int[] arr2 = {2, 4, 6, 8};

        int n = arr1.length;
        int m = arr2.length;

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n) {
            result[k++] = arr1[i++];
        }

        while (j < m) {
            result[k++] = arr2[j++];
        }

        // After this copy the result back into array:












////Next Permutation:


//// Remove Outermost Parenthesis:
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


    }
}
