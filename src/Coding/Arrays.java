package Coding;

import java.util.HashMap;

public class Arrays {
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

////Find longest subarray with sum = 0 (same as sum K where K=0).
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

//// 2 Sum: (Hashing and Two Pointer): for two pointer we need to sort the element
//
//        int [] arr={1,2,3,4,5,6,0};
//        int target=20;
//        int[] ans={-1,-1};
//        HashMap<Integer,Integer> map=new HashMap<>();
//
//        for(int i=0;i<arr.length;i++){
//            int num=arr[i];
//            if(map.containsKey(target-num)){
//                ans[0]=map.get(target-num);
//                ans[1]=i;
//            }
//
//            map.put(num,i);
//
//        }
//        System.out.println(Arrays.toString(ans));

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
//        int sum=0;
//
//        for(int i=0;i<arr.length;i++){
//
//            sum+=arr[i];
//
//// Updating the max sum:
//            if(sum>max_sum){
//                max_sum=sum;
//            }
//
//// If sum < 0: discard the sum calculated, becuase this gonna decrease the sum. so we didn't need it.
//            if(sum<0){
//                sum=0;
//            }
//// For empty subarray:
//            if(max_sum<0){
//                max_sum=0;
//            }
//
//        }
//
//        System.out.println(max_sum);
        int[] arr={1,2,3,4,5,1,0,0,0,0};
        int k=6, maxlen=0,len=0,sum=0,j=0;
        for (int i=0;i<arr.length;i++){

            sum+=arr[i];

            if(sum==k){
                maxlen=Math.max(maxlen,i-j+1);
            }

            while (sum>k){
                sum-=arr[j];
                j++;
            }

        }

        System.out.println(maxlen);


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

    }
}
