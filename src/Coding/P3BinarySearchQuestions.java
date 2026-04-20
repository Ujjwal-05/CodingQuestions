package Coding;

public class P3BinarySearchQuestions {
    public static void main(String[] args) {
/*
        In binary search, left and right represent a moving search window, and when the loop ends (`left > right`), a fixed relationship always holds: left points to the correct insertion position**, while **`right` points to the last index smaller than that position**.This is why left is returned when the problem asks for an insertion index, lower bound, first element greater than or equal to a target, or the ceiling of a number. On the other hand, right is returned when the problem asks for the last element less than or equal to a target, the last element strictly smaller than a target, or the floor of a number. In short, after binary search finishes, left represents the “future” position where the element should go, and right represents the “past” position that has already been passed, and choosing which one to return depends entirely on what the problem is asking for.




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

*/
    }
}
