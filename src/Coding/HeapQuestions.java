package Coding;


import java.util.*;

public class HeapQuestions {
    public static void main(String[] args) {

/*
    A Priority Queue is an abstract data type, which is commonly implemented using a Heap.
    A Heap is a data structure / algorithmic idea that is implemented using an array representation of a Complete Binary Tree.

    A Priority Queue is a special type of queue where each element is assigned a priority. Instead of being processed in the order they arrive (like a normal queue),
    the element with the highest priority is always processed first. If two elements have the same priority, they are handled based on their insertion order.

    Binary tree: A Binary Tree is a hierarchical data structure in which each node has at most two children, called the left child and the right child.

    Complete Binary Tree: A Complete Binary Tree is a binary tree in which all levels are completely filled except possibly the last level, and all nodes in the
                          last level are filled from left to right. No node can have a right child without having a left child.

        1     CBT               1     CBT                       1       Not a CBT
       / \                     / \                             / \
      2   3                   2   3                           2   3
     / \ / \                 / \ / \                              /
    4  5 6  7               4  5 6                                4

    Full Binary tree:

    Heap: A Heap is a special tree-based data structure that satisfies two properties:

    1️⃣ Complete Binary Tree Property
    2️⃣ Heap Order Property

    In CBT non-leaf node lies:  0 to n/2 - 1
    In CBT leaf node lies:      n/2 to n-1

    Heap Property: Binary Heap is either a Min Heap or Max Heap. Property of the Binary Heap decides whether it is Min Heap or Max Heap.

    Min Heap property: For every node in a binary heap, if the parent node value is less than its right and left child’s value then Binary Heap is known as Min Heap.
    Max Heap property: For every node in a binary heap, if the parent node value is greater than its right and left child’s value then Binary Heap is known as Max Heap.


    Representation of the Binary Heap:

    Node index: i
    Left child Index: 2*i+1
    Right Child Index: 2*i+2

    Child’s Index: i
    Parent’s Index: (i-1)/2

    Operations Associated with Min Heap:

    | Operation                                   | Complexity   | Why                            |
    | ------------------------------------------- | ------------ | ------------------------------ |
    | Insert (offer / add)                        | O(log n)     | Heapify-up along heap height   |
    | Delete (poll / extractMin / extractMax)     | O(log n)     | Heapify-down along heap height |
    | Peek (getMin / getMax)                      | O(1)         | Root access                    |
    | Build Heap (from array)                     | O(n)         | Bottom-up heapify              |
    | Search (arbitrary element)                  | O(n)         | Heap not ordered like BST      |
    | Change key (increase/decrease priority)     | O(log n)     | Heapify up or down             |
    | Check empty                                 | O(1)         |                                |
    | Get size                                    | O(1)         |                                |

    1️⃣Insertion: in a heap is done by first placing the new element at the next available position to maintain the complete binary tree property. After insertion,
    the heap order property may be violated, so the element is moved upward by repeatedly comparing it with its parent and swapping if necessary.
    This process is called heapify-up or percolate-up and continues until the heap property is restored or the element becomes the root. Insertion in a heap takes
    O(log n) time.

            //TC: log(n)
            public void insert(int key) {
                if(size==capacity) return;

                heap[size]=key;
                int i=size;
                size++;

                // Heapify up
                while (i!=0 && heap[parent(i)]>heap[i]){
                    swap(i,parent(i));
                    i=parent(i);
                }
            }

    2️⃣ Deletion: in a heap always removes the root element, which is the minimum element in a min heap or the maximum element in a max heap. To delete the root,
    the last element of the heap is moved to the root position, and the heap size is reduced. Since this may violate the heap order property, the element is moved
    downward by comparing it with its children and swapping with the appropriate child. This process is called heapify-down or percolate-down and continues until the
    heap property is restored. Deletion in a heap also takes O(log n) time. extractMin/extractmax

        public void extractMin() {

                if (size <= 0) return;

                if (size == 1) {
                    size--;
                    return;
                }

                // Move last element to root
                heap[0] = heap[size - 1];
                size--;

                int i = 0;

                while (true) {
                    int left = 2 * i + 1;
                    int right = 2 * i + 2;
                    int smallest = i;

                    if (left < size && heap[left] < heap[smallest]) {
                        smallest = left;
                    }

                    if (right < size && heap[right] < heap[smallest]) {
                        smallest = right;
                    }

                    // heap property satisfied
                    if (smallest == i) {
                        break;
                    }

                    swap(i, smallest);
                    i = smallest;
                }
            }

    Deletion in a heap always starts from the root because the heap is designed to efficiently support access and removal of only one special element the minimum in
    a min heap or the maximum in a max heap—and this element is always stored at the root. Unlike a binary search tree, a heap does not maintain any ordering among
    sibling or subtree elements, so only the root is guaranteed to be the correct element to delete in constant time. If deletion were attempted at any other position,
    the element would first need to be searched for, which takes O(n) time, defeating the purpose of using a heap. Therefore, heaps restrict deletion to the root,
    allowing the operation to be completed efficiently by replacing the root with the last element and restoring the heap property using heapify-down in O(log n) time.

    Check whether the given heap is Min-Heap or not:Since we're checking whether the array represents a min heap, we need to ensure that every parent node is less
    than or equal to both of its children. That's the key rule for min heaps. We don’t have to check every element in the array. Leaf nodes don’t have children,
    so they can’t violate the heap property. In an array of size n, leaf nodes start from index n/2, so the only nodes we actually need to check are from
    index 0 to n/2 - 1. These are the non-leaf nodes. For each of these, we compute their children’s indices and compare values. If any parent node is found to be
    greater than one of its children,we can immediately return false because the heap rule is broken. If all the parent nodes satisfy the condition, then the array is a valid min heap.

*/

/* Implement Min Heap:

        class PriorityQueueUsingHeap {

            private int[] heap;
            private int size;
            private int capacity;

            public PriorityQueueUsingHeap(int capacity) {
                this.capacity = capacity;
                heap = new int[capacity];
                size = 0;
            }

            private int parent(int i) { return (i - 1) / 2; }
            private int left(int i)   { return 2 * i + 1; }
            private int right(int i)  { return 2 * i + 2; }

            private void swap(int i, int j) {
                int temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
            }

            // Insert element
            public void insert(int val) {
                if (size == capacity) {
                    System.out.println("Heap is full");
                    return;
                }

                heap[size] = val;
                int i = size;
                size++;

                // Heapify up
                while (i != 0 && heap[parent(i)] > heap[i]) {
                    swap(i, parent(i));
                    i = parent(i);
                }
            }

            // Remove highest priority element (minimum)
            public int poll() {
                if (isEmpty()) {
                    System.out.println("Heap is empty");
                    return -1;
                }

                int root = heap[0];

                heap[0] = heap[size - 1];
                size--;

                minHeapify(0);

                return root;
            }

            // Heapify down
            private void minHeapify(int i) {

                while (true) {
                    int smallest = i;
                    int l = left(i);
                    int r = right(i);

                    if (l < size && heap[l] < heap[smallest]) {
                        smallest = l;
                    }

                    if (r < size && heap[r] < heap[smallest]) {
                        smallest = r;
                    }

                    if (smallest == i) break;

                    swap(i, smallest);
                    i = smallest;
                }
            }

            public int peek() {
                if (isEmpty()) return -1;
                return heap[0];
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public int size() {
                return size;
            }
        }

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

 */

/*
        Check if an array represents a min heap:

        Solution: In this we have to check every Parent node must be greater than both of its children.

        int[] arr={10,20,30,21,23,3,33};

        int n=arr.length;
        for(int i=0;i<=(n/2)-1;i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[i] > arr[left]) return;
            if (right < n && arr[i] > arr[right]) return;

        }
        Optimal:    TC:O(n/2) SC:O(1)

 */

/*
        Convert an array to min-heap:
        int[] arr = {54, 53, 55, 52, 50};
        int n = arr.length;

        // Build Min Heap-- O(n) how
        for (int i = (n / 2) - 1; i >= 0; i--) {
            minHeapify(arr, i, n);
        }

        private static void minHeapify(int[] arr, int i, int size) {

            while (true) {

                int smallest = i;
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < size && arr[left] < arr[smallest]) {
                    smallest = left;
                }

                if (right < size && arr[right] < arr[smallest]) {
                    smallest = right;
                }

                if (smallest == i) {
                    break;
                }

                swap(arr, i, smallest);
                i = smallest;
            }
        }

 */


/*
        Convert min Heap to max Heap:

        Solution: “Min Heap can be converted to Max Heap in O(n) time by applying max-heapify from the last non-leaf node.”
        Optimal:    TC:O(n) SC:O(n)

 */

/*

    Pattern: TOP-K / ORDER STATISTICS (Heap of size K):
    In this we will store element top-k elements in heap:

*/

/*
    Kth largest/smallest element in an array:

    Solution: In this we maintain a heap of top k element.

        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 3;

        public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minheap=new PriorityQueue<>();

        for(int num:nums){
            minheap.add(num);
            if(minheap.size()>k){
                minheap.poll();
            }
        }

        return minheap.peek();
    }

    Brute force: TC:O(nlogn) SC:O(1) By sorting
    Optimal:    TC:O(k log k + (n − k) log k) = O(n log k) SC:O(n)

 */

/*
    Kth largest element in a stream of running integers:

    Implement a class KthLargest to find the kth largest number in a stream. It should have the following methods:

    KthLargest(int k, int [] nums) Initializes the object with the integer k and the initial stream of numbers in nums
    int add(int val) Appends the integer val to the stream and returns the kth largest element in the stream.

    Note that it is the kth largest element in the sorted order, not the kth distinct element.


    class KthLargest {

        List<Integer> stream;
        int k;

    public KthLargest(int k, int[] nums) {

            stream=new ArrayList<Integer>();
            this.k=k;

            for(int num:nums){
                stream.add(num);
            }

            Collections.sort(stream);

    }

        public int add(int val) {
           int index = getIndex(val);
            // Add val to correct position
            stream.add(index, val);
            return stream.get(stream.size() - k);
    }

        private int getIndex(int val) {
            int left = 0;
            int right = stream.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int midElement = stream.get(mid);
                if (midElement == val) return mid;
                if (midElement > val) {
                    // Go to left half
                    right = mid - 1;
                } else {
                    // Go to right half
                    left = mid + 1;
                }
            }

        return left;
    }
}

        Brute Force: TC:O(N⋅(M+N+log(M+N))) SC:O(M+N)


    class KthLargest {

        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            this.k = k;

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            // Add to our minHeap if we haven't processed k elements yet
            // or if val is greater than the top element (the k-th largest)
            if (minHeap.size() < k || minHeap.peek() < val) {
                minHeap.add(val);
                if (minHeap.size() > k) {
                    minHeap.remove();
                }
            }
            return minHeap.peek();
        }
    }

        TC: O((M+N)⋅logk). SC: O(k)

*/

/*
    K most frequent elements: Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.

        int[] nums={1,2,3,1,1,2,2,5,4,4,4,4}; int k=2;

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> freqMap=new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    Brute force: TC:O(nlogn) SC:O(n+k)

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        for (int key : freqMap.keySet()) {
            minHeap.add(new int[]{key, freqMap.get(key)});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll()[0];
        }

    Optimal: TC:O(nlogk) SC:O(n)

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int idx = 0;

        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        System.out.println(result);
        TC:O(n) SC:O(n)

        Bucket Sort is considered the best theoretical approach for the K most frequent elements problem because it achieves linear time complexity O(n)
        by avoiding heap operations. After counting frequencies using a HashMap, elements are placed into buckets indexed by frequency, and we directly
        scan the buckets from highest to lowest frequency to get the answer. However, despite its optimal time complexity, Bucket Sort is not always preferred
        in practice because it requires extra space proportional to the input size (O(n) buckets), even when the number of distinct elements is small.
        This can lead to higher memory usage and less flexibility, especially when frequencies are sparse or input size is large. In contrast, the HashMap + Heap
        approach runs in O(n log k) time but uses less additional space, is easier to implement, and works efficiently for most real-world constraints.
        Therefore, Bucket Sort is “best theoretical” in terms of time complexity, but HashMap + Heap is often more practical and scalable in interviews and
        production systems.
        “Bucket sort gives O(n) time but higher space usage, so heap-based solutions are usually preferred in practice.”


 */

/*  Reduce Array Size to The Half:

    You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
    Return the minimum size of the set so that at least half of the integers of the array are removed.
    Input: arr = [3,3,3,3,5,5,5,2,2,7]
    Output: 2

    public int minSetSize(int[] arr) {

        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

    In this if we do not sort the element collection then we have to repeatedly find the maximum element
    which will take K2 complexity that will be brute force and sorting is optimization.

        Collections.sort(list, (a, b) ->
                Integer.compare(b.getValue(), a.getValue()));

        int removed = 0;
        int target = n / 2;
        int minimum = 0;
        int i = 0;

        while (removed < target) {
            removed += list.get(i).getValue();
            i++;
            minimum++;
        }
    }

    TC:  O(n+ klogk) SC: O(n)

    public static int minSetSize(int[] arr) {
        int n = arr.length;

        // 1) Frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2) Buckets where index = frequency
        List<Integer>[] buckets = new ArrayList[n + 1];
        for (int f : freq.values()) {
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(f); // store frequency (key not needed)
        }

        // 3) Greedy removal from highest frequency
        int removed = 0;
        int target = n / 2;
        int count = 0;

        for (int f = n; f >= 1 && removed < target; f--) {
            if (buckets[f] != null) {
                for (int ignored : buckets[f]) { // iterate entries
                    removed += f;
                    count++;
                    if (removed >= target) break;
                }
            }
        }

        return count;
    }
    Time: O(n)    Space: O(n) (map + buckets)

 */

/*  Sort K sorted array:

    You are given an array of integers where the array is k-sorted, meaning that each element is at most k positions away from its correct position in the fully
    sorted array. Your task is to sort the array efficiently.

        int[] arr = {6, 5, 3, 2, 8, 10, 9};  int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            result.add(minHeap.poll()); // removes smallest from heap
            minHeap.add(arr[i]);        // inserts next array element
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        System.out.println(result);

        Brute force: TC:O(nlogn) SC:O(1)
        Optimal:    TC:O(nlogk) SC:O(n)

*/

/*  Merge M sorted Lists:

    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.

        Node list1 = new Node(1);list1.next = new Node(4);list1.next.next = new Node(5);
        Node list2 = new Node(1);list2.next = new Node(3);list2.next.next = new Node(4);
        Node list3 = new Node(2);list3.next = new Node(6);

        Node[] lists = new Node[]{list1, list2, list3};

        public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];
            while (temp!=null){
                result.add((Integer) temp.val);
                temp=temp.next;
            }
        }

        Collections.sort(result);
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;

        for (int i=0;i<result.size();i++){
            ListNode resnode=new ListNode(result.get(i));
            tail.next=resnode;
            tail=tail.next;
        }
        return dummy.next;

    }
    Brute force: TC:O(nlogn) SC:O(n)


        PriorityQueue<Node<Integer>> pq=new PriorityQueue<>(
                (a,b)-> Integer.compare(a.data,b.data)
        );
        for(int i=0;i<lists.length;i++){
            pq.add(lists[i]);
        }
        Node<Integer> dummy=new Node<>(-1);
        Node<Integer> tail=dummy;

        while (!pq.isEmpty()){

            Node<Integer> smallest=pq.poll();
            tail.next=smallest;
            tail=tail.next;

            if(smallest.next!=null){
                pq.add(smallest.next);
            }
        }

        Optimal:    TC:O(nlogk) SC:O(n)

        public static List<Integer> merge(int[][] arrays) {

            PriorityQueue<Node> pq = new PriorityQueue<>(
                    (a, b) -> a.value - b.value
            );

            List<Integer> result = new ArrayList<>();

            // Push first element of each array
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].length > 0) {
                    pq.add(new Node(arrays[i][0], i, 0));
                }
            }

            while (!pq.isEmpty()) {

                Node current = pq.poll();
                result.add(current.value);

                int nextCol = current.col + 1;
                if (nextCol < arrays[current.row].length) {
                    pq.add(new Node(
                            arrays[current.row][nextCol],
                            current.row,
                            nextCol
                    ));
                }
            }

            return result;
        }
 */

/* Task Scheduler:

    You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle
    or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

    Return the minimum number of CPU intervals required to complete all tasks.

    Example 1:

    Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8

    Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

    After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval,
    neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

        Brute force: TC:O(n2) SC:O(n)

        char[] tasks={'A','A','A','B','B','B'};
        int n=2;

        int[] taskFrequency=new int[26];

        for(char c:tasks){
            taskFrequency[c-'A']++;
        }

        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());

        for(int freq:taskFrequency){
            if(freq>0) maxheap.add(freq);
        }
        int time=0;
        while (!maxheap.isEmpty()){

            int cycle=n+1;
            List<Integer> taskpickedbutnotcompleted=new ArrayList<>();

            while (cycle>0 && !maxheap.isEmpty()){

                int curr=maxheap.poll();
                curr--;
                if(curr>0) taskpickedbutnotcompleted.add(curr);

                time++;
                cycle--;
            }

            for(int rem:taskpickedbutnotcompleted){
                maxheap.add(rem);
            }

            if(!maxheap.isEmpty()){
                time+=cycle;
            }
        }
        System.out.println(time);

        public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        int f = 0; // max frequency

        for (char c : tasks) {
            freq[c - 'A']++;
            f = Math.max(f, freq[c - 'A']);
        }

        int X = 0;
        for (int count : freq) {
            if (count == f) {
                X++;
            }
        }

        int totalJobs = tasks.length;
        return Math.max((f - 1) * (n + 1) + X, totalJobs);
    }
        Optimal:    TC:O(n) SC:O(1)

 */

/*  Hands of Straights:

    Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

    Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards,
    or false otherwise.

    Example 1:

    Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
    Output: true
    Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        List<Integer> list = new ArrayList<>();
        for (int num : hand) {
            list.add(num);
        }

        Collections.sort(list);

        while (!list.isEmpty()) {
            int start = list.get(0);

            for (int i = 0; i < groupSize; i++) {
                if (!list.contains(start + i)) {
                    return false;
                }
                list.remove(Integer.valueOf(start + i));
            }
        }
        return true;
        }
----->Brute force: TC:O(n2) SC:O(n)

        public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            int start = map.firstKey(); // smallest available card

            for (int i = 0; i < groupSize; i++) {
                int card = start + i;

                if (!map.containsKey(card)) {
                    return false;
                }

                map.put(card, map.get(card) - 1);
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }
        return true;
    }

        n = number of cards
        m = number of unique cards
        Building TreeMap: O(n log m)
        Each card processed once: O(n log m)

 Optimal:    TC:O(n log m) SC:O(m)

 */

//// Design Twitter:

//Brute force: TC:O(n2) SC:O(1)
// Optimal:    TC:O(n) SC:O(n)

/*  Connect n ropes with minimal cost:

    Given an array arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths.
        int[] ropes = {4, 3, 2, 6};

 Brute Force Approach:
 Try all possible ways of connecting ropes by choosing every possible pair recursively.
 Time Complexity: O(n!)  (factorial, due to all possible merge orderings)
 Space Complexity: O(n)  (recursion stack)

         public int minCost(int[] ropes) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int r : ropes) {
            pq.add(r);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;
            totalCost += cost;

            pq.add(cost);
        }

        return totalCost;

        Always connect the two smallest ropes first. Smaller ropes contribute less to future costs, Greedy choice guarantees minimum total cost.

// Insert into heap | O(log n)       |
// Remove from heap | O(log n)       |
// Total operations | n − 1 merges   |

Optimal:    TC:O(n log n) SC:O(n)
 */

/* Maximum Sum Combination:
        int[] nums1 = {7, 3};
        int[] nums2 = {1, 6};
        int k = 2;

        List<Integer> ans=new ArrayList<>();
        for(int num1:nums1){
            for(int num2:nums2){
                ans.add(num1+num2);
            }
        }
        Collections.sort(ans,Collections.reverseOrder());
        System.out.println(ans.subList(0,k));

Brute force: TC:O(nm + nmlognm) == n2 SC:O(nm)

import java.util.*;

class Solution {
    public List<Integer> kMaxSumCombinations(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<int[]> maxHeap =new PriorityQueue<>((a, b) -> b[0] - a[0]);

        Set<String> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        maxHeap.add(new int[]{nums1[n - 1] + nums2[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        while (k-- > 0 && !maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();
            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];

            ans.add(sum);

            // Move left in nums1
            if (i - 1 >= 0) {
                String key = (i - 1) + "," + j;
                if (!visited.contains(key)) {
                    maxHeap.add(new int[]{nums1[i - 1] + nums2[j], i - 1, j});
                    visited.add(key);
                }
            }

            // Move left in nums2
            if (j - 1 >= 0) {
                String key = i + "," + (j - 1);
                if (!visited.contains(key)) {
                    maxHeap.add(new int[]{nums1[i] + nums2[j - 1], i, j - 1});
                    visited.add(key);
                }
            }
        }

        return ans;
    }
}
 Optimal:    TC:O(O(n log n + k log k)) SC:O(k)

 */

/*
    Find Median from Data Stream: : Implement a class that finds the median from a data stream. The median is the middle value in an ordered integer list.
    If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

        class MedianFinder {
            private List<Integer> list;

            public MedianFinder() {
                list=new ArrayList<>();
            }

            public void addNum(int num) {
                list.add(num);
            }

            public double findMedian() {
                Collections.sort(list);
                int n=list.size();
                if(n%2==0){
                    return (list.get(n/2)+list.get((n/2)-1))/2.0;
                }
                return list.get(n/2);
            }
        }

------------>Brute force: TC:O(nlogn) SC:O(1)

        Since the input stream is unsorted, sorting the entire data after every insertion would be inefficient. To avoid repeated sorting, we use heaps, which help us
        maintain order dynamically. To find the median, we only need the middle element(s) of the sorted data. Therefore, we divide the data into two halves:

        Left half → stores the smaller elements
        Right half → stores the larger elements

        The maximum element of the left half and the minimum element of the right half are the only values required to compute the median.
        We use:
            a Max Heap for the left half
            a Min Heap for the right half

        By keeping the size difference between the heaps at most 1, we can compute the median in O(1) time.


        class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // left half
    private PriorityQueue<Integer> minHeap; // right half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: always push to maxHeap
        maxHeap.offer(num);

        // Step 2: balance by moving largest of left to right
        minHeap.offer(maxHeap.poll());

        // Step 3: ensure maxHeap has equal or 1 more element
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // no elements present
        if (maxHeap.isEmpty()) {
            // You can also throw exception if interviewer prefers
            return 0.0;
        }

        //only one element present
        if (maxHeap.size() == 1 && minHeap.isEmpty()) {
            return maxHeap.peek();
        }

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

 Optimal:    Add num: TC:O(logn), median:O(1), SC:O(n)

 */

/*  Total Cost to Hire K Workers:

    int[] costs = {17,12,10,2,7,2,11,20,8};
    int k = 3;
    int candidates = 4;

    public long totalCost(int[] costs, int k, int candidates) {
        List<Integer> list=new ArrayList<>();
        for(int cost:costs) list.add(cost);
        int total=0;

        for(int hire=0;hire<k;hire++){

            int n=list.size();
            int mincost=Integer.MAX_VALUE;
            int minindex=-1;

            for (int i=0;i<Math.min(candidates,n);i++){
                if(list.get(i)<mincost){
                    mincost=list.get(i);
                    minindex=i;
                }
            }

            for (int i=Math.max(0,n-candidates);i<n;i++){
                if(list.get(i)<mincost){
                    mincost=list.get(i);
                    minindex=i;
                }
            }

            total+=mincost;
            list.remove(minindex);

        }
        return total;
    }
    Brute Force: TC: O(n2) SC:O(n)

    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int n = costs.length;
        int left = 0;
        int right = n - 1;

        // Fill left heap
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }

        // Fill right heap
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }

        long total = 0;

        // Hire k workers
        for (int hired = 0; hired < k; hired++) {

            // Decide from which heap to hire
            if (rightHeap.isEmpty() ||
                (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {

                total += leftHeap.poll();

                // Refill left heap if possible
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }

            } else {
                total += rightHeap.poll();

                // Refill right heap if possible
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return total;
    }
    Optimal: TC: O(nlogn) SC: O(n)

 */


    }}
