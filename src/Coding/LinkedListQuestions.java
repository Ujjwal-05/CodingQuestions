package Coding;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
    public ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}

public class LinkedListQuestions {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);

/*
        loop runs: Number of iterations = (last valid value − first value + 1)

        // Traversal
        head.next!=null:        last node
        head.next.next!=null:   Second last node
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }

        “Write the while condition based on the deepest .next you will touch inside the loop.”
        “Because inside the loop I access X.next.next, I must ensure both X and X.next are not null before entering the loop.”

        // Slow and Fast Pointer:
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //Reversal:
        public static ListNode reverselinkedlist(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while (curr!=null){
            ListNode front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
        }

        //Odd and even index:

        ListNode curr = head;   // odd index node
        ListNode curr = head.next;   // even index node

        while (curr != null) {
            System.out.println(curr.val);
            if (curr.next == null) break;
            curr = curr.next.next;
        }

        // Converting list value to num in reverse order like if list is 123 then output will 321:
        long num1 = 0, num2 = 0;
        long place = 1;

        while (l1 != null) {
            num1 += l1.val * place;
            place *= 10;
            l1 = l1.next;
        }
 */

/* Middle of linked list:

        ListNode slow=head;
        ListNode fast=head;         for 2nd middle in even length case
        ListNode fast=head.next;    for 1st middle in even length case

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
 */

/* Reverse a Linked List:

        ListNode prev=null;
        ListNode curr=head;

        while (curr!=null){

            ListNode front= curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }

 */

/*  Detect a Cycle in a Linked List:

    In Floyd’s Cycle Detection (Tortoise–Hare) algorithm, we move one pointer one step at a time and the other two steps at a time to create a speed difference that
    helps detect the presence of a loop efficiently. If there is no cycle in the linked list, the fast pointer, because it moves twice as quickly, will eventually reach
    the end of the list and become null, confirming that the list is linear. However, if a cycle exists, both pointers will eventually meet because once they are inside
    the loop, the fast pointer keeps closing the gap between itself and the slow pointer.
    Assume at some point inside the cycle the fast pointer is k nodes ahead of the slow pointer. Since the fast pointer moves two steps and the slow pointer moves one step
    in each iteration, the net reduction in the gap is one node per iteration. So the difference reduces from k to k-1, k-2, and so on, until it becomes zero.
    At that moment, both pointers land on the same node, meaning they collide, and this collision conclusively indicates that a cycle exists in the linked list.

    Brute Force: Use Set

        public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)  return false;

        ListNode slow = head;       // moves 1 step
        ListNode fast = head;       // moves 2 steps

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1
            fast = fast.next.next;      // move fast by 2

            if (slow == fast){
                return true;

            }
        }
        return false;
    }
 */

/*  Merge Two Sorted Linked list in one sorted list:

        ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }


            // Attach leftover part
            if (l1 != null) temp.next = l1;
            else temp.next = l2;

            return dummy.next;
        }
 */

/*  Starting point of loop in a Linked List:

    From the above algo we can say that slow and fast pointer will meet definitely but we can't say that it will meet at starting point.
    In this when the slow pointer reaches the starting point of the loop, the fast pointer is positioned at a point that is twice the distance travelled by the slow pointer.
    This is because the hare moves at double the speed of the tortoise. If slow has travelled distance L1 then fast has travelled 2 x L1. Now that slow and fast have
    entered the loop, the distance fast will have to cover to catch up to slow is the total length of loop minus L1. Let this distance be d.
    Distance travelled by slow = L1 Distance travelled by fast = 2 * L1 Total length of loop = L1 + d. In this configuration, the fast pointer advances toward the slow
    pointer with two jumps per step, while the slow pointer moves away with one jump per step. As a result, the gap between them decreases by 1 with each step.
    Given that the initial gap is d, it takes exactly d steps for them to meet.
    Total length of loop = L1 + d Distance between slow and fast = d

    During these d steps, the slow pointer effectively travels d steps from the starting point within the loop and fast travels 2 x d and they meet at a specific point.
    Based on our previous calculations, the total length of the loop is L1 + d. And since the distance covered by the slow pointer within the loop is d,
    the remaining distance within the loop is equal to L1. Therefore, it is proven that the distance between the starting point of the loop and the point where
    the two pointers meet is indeed equal to the distance between the starting point and head of the linked list.

    Brute force: Use set

         ListNode detectCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {

                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    slow = head;

                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }

                    return slow;
                }
            }
            return null;
        }

/*   Length of Loop in LL:

        public int lengthOfLoop(ListNode head) {
            HashMap<ListNode, Integer> visitedNodes = new HashMap<>();

            ListNode temp = head;
            int timer = 0;

            while (temp != null) {

                if (visitedNodes.containsKey(temp)) {
                    int loopLength = timer - visitedNodes.get(temp);
                    return loopLength;
                }

                visitedNodes.put(temp, timer);
                temp = temp.next;
                timer++;
            }

            return 0;
        }
    Brute Force: TC:O(n) SC:(n)

    public int lengthOfLoop(ListNode head) {

        if (head == null || head.next == null) return ;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return countLength(slow);
                }
            }
            return;
        }

         int countLength(ListNode meetingPoint) {
            ListNode curr = meetingPoint;
            int count = 1;

            // traverse cycle until we come back to the same node
            while (curr.next != meetingPoint) {
                curr = curr.next;
                count++;
            }
            return count;
        }

 */

/*  Check if the given Linked List is Palindrome:

        Stack<Integer> st = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            st.push((Integer) curr.val);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.val != st.pop()) {
                System.out.println("Not a Palindrome");
                break;
            }
            curr = curr.next;
        }

    public boolean isPalindrome(ListNode head) {

        if(head.next==null) return true;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode firsthalf=head;
        ListNode secondhalfhead=reverselinkedlist(slow);
        ListNode secondhalf=secondhalfhead;

        while (secondhalf!=null){
            if(firsthalf.val!=secondhalf.val){
                return false;
            }
            firsthalf=firsthalf.next;
            secondhalf=secondhalf.next;
        }
        reverselinkedlist(secondhalfhead);
        return true;
    }

    public static ListNode reverselinkedlist(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while (curr!=null){
            ListNode front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }

        return prev;
    }

 */

/*  Segregate odd and even nodes in LL:

    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
    The first node is considered odd, and the second node is even, and so on.
    Note that the relative order inside both the even and odd groups should remain as it was in the input.

        public ListNode oddEvenList(ListNode head) {

            if(head==null) return null;
            if(head.next== null || head.next.next== null) return head;

            ListNode curr=head;
            List<Integer> list=new ArrayList<>();

            while(curr!=null){
                list.add(curr.val);
                if(curr.next==null) break;
                curr=curr.next.next;
            }

            curr=head.next;
            while(curr!=null){
                list.add(curr.val);
                if(curr.next==null) break;
                curr=curr.next.next;
            }

            curr=head;
            while (curr!=null){
                curr.val=list.removeFirst();
                curr=curr.next;
            }

            return head;
        }

        public ListNode oddEvenList(ListNode head) {

        if(head==null) return null;
        if(head.next== null || head.next.next== null) return head;

        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenhead=even;

        while (even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenhead;

        return head;
        }
 */
/*  Remove Nth node from the back of the LL:

        public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (length == n) {
            return head.next;
        }

        curr = head;
        ListNode prev = null;

        for (int i = 0; i < length - n; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp=head;
        for(int i=0;i<n;i++){
            temp=temp.next;
        }

        if (temp == null) {
            return head.next;
        }

        ListNode curr = head;
        ListNode prev = null;


        while(temp!=null){
            prev=curr;
            curr=curr.next;
            temp=temp.next;
        }

        prev.next = curr.next;

        return head;
    }

 */

/*  Delete the Middle Node of the Linked List:

    public ListNode deleteMiddle(ListNode head) {

        if(head.next==null) return null;

        int length=0;
        ListNode curr=head;

        while(curr!=null){
            length++;
            curr=curr.next;
        }

        int n=length/2;

        ListNode prev=null;
        curr=head;
        for(int i=0;i<n;i++){
            prev=curr;
            curr=curr.next;
        }

        prev.next=curr.next;
        return head;
    }

    public ListNode deleteMiddle(ListNode head) {

        if(head.next==null) return null;

        ListNode prev=head;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
 */

/*  Sort LL:

        public ListNode sortLL(ListNode head) {

            ArrayList<Integer> arr = new ArrayList<>();
            ListNode temp = head;

            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }

            Collections.sort(arr);

            temp = head;
            for (int i = 0; i < arr.size(); i++) {
                temp.val = arr.get(i);
                temp = temp.next;
            }
            return head;

            public ListNode sortLL(ListNode head) {

                if (head == null || head.next == null) {
                    return head;
                }

                ListNode middle = findMiddle(head);

                ListNode right = middle.next;
                middle.next = null;
                ListNode left = head;

                left = sortLL(left);
                right = sortLL(right);

                return mergeTwoSortedLinkedLists(left, right);
            }
        }

            ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
                ListNode dummyNode = new ListNode(-1, null);
                ListNode temp = dummyNode;

                while (list1 != null && list2 != null) {
                    if (list1.val <= list2.val) {
                        temp.next = list1;
                        list1 = list1.next;
                    } else {
                        temp.next = list2;
                        list2 = list2.next;
                    }
                    temp = temp.next;
                }

                if (list1 != null) {
                    temp.next = list1;
                } else {
                    temp.next = list2;
                }
                return dummyNode.next;
            }

            public ListNode findMiddle(ListNode head) {
                // If list empty or single node
                if (head == null || head.next == null) {
                    return head;
                }

                // Slow and fast pointers
                ListNode slow = head;
                ListNode fast = head.next;

                // Move fast twice as fast as slow
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }

                // Return middle node
                return slow;
            }
 */

/*  Sort a LL of 0's 1's and 2's by changing links

public ListNode sort012(ListNode head) {

        if (head == null || head.next == null) return head;

        // Dummy heads
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead  = new ListNode(-1);
        ListNode twoHead  = new ListNode(-1);

        // Tails
        ListNode zeroTail = zeroHead;
        ListNode oneTail  = oneHead;
        ListNode twoTail  = twoHead;

        ListNode curr = head;

        // Step 1: Distribute nodes
        while (curr != null) {
            ListNode nextNode = curr.next; // save next
            curr.next = null;              // detach

            if (curr.val == 0) {
                zeroTail.next = curr;
                zeroTail = curr;
            } else if (curr.val == 1) {
                oneTail.next = curr;
                oneTail = curr;
            } else {
                twoTail.next = curr;
                twoTail = curr;
            }

            curr = nextNode;
        }

        // Step 2: Connect lists
        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }

        oneTail.next = twoHead.next;
        twoTail.next = null;

        // Step 3: Return new head
        return zeroHead.next;
    }

 */

/*   Find intersection of Two Linked Lists:

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null)
                return null;

            ListNode a = headA;
            ListNode b = headB;

            // Traverse until both pointers meet
            while (a != b) {

                // If pointer a reaches the end of list A, move it to the head of list B
                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;   // otherwise move to next node
                }

                // If pointer b reaches the end of list B, move it to the head of list A
                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;   // otherwise move to next node
                }
            }

            // At this point, a == b
            // If intersection exists, it is the intersection node
            // If no intersection, both are null
            return a;
        }

 */

/*   Add 1 to a number represented by LL

        if (head == null)
            return null;

        long num = 0;
        ListNode curr = head;

        while (curr != null) {
            num = num * 10 + curr.val;
            curr = curr.next;
        }

        num = num + 1;
        String s = String.valueOf(num);

        curr = head;
        int i = 0;

        ListNode tail = null;

        while (curr != null && i < s.length()) {
            curr.val = s.charAt(i) - '0';
            tail = curr;
            curr = curr.next;
            i++;
        }

        while (i < s.length()) {
            ListNode newNode = new ListNode(s.charAt(i) - '0');
            tail.next = newNode;
            tail = newNode;
            i++;
        }
        return head;
    }

    public ListNode addOne(ListNode head) {
        if (head == null) return null;

        head = reverse(head);

        ListNode curr = head;
        int carry = 1;

        while (curr != null) {

            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            if (carry == 0) {
                break;
            }

            if (curr.next == null && carry > 0) {
                curr.next = new ListNode(carry);
                carry = 0;
                break;
            }
            curr = curr.next;
        }

        return reverse(head);
    }

 */

////Use && when you need pairs of nodes:
////Use || when you need to process all nodes, even if one list ends before the other:

/*Add 2 numbers in LL:

        Brute Force:A brute-force approach is to convert both linked lists into numbers, add them, and then convert the sum back into a linked list.

        Why it fails:
        If the problem represents digits using a linked list, it is a strong signal that numeric conversion is not intended.
        The list can contain up to 100 digits, which will overflow any int or long type.

        Conclusion:
        Brute force helps in understanding the problem but cannot be used as the final solution.

        Optimal Approach:
        To handle large numbers safely, we add digits node by node with carry, exactly like manual addition, without converting the list into a number.

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long num1 = 0, num2 = 0;
        long place = 1;

        while (l1 != null) {
            num1 += l1.val * place;
            place *= 10;
            l1 = l1.next;
        }

        place = 1;

        while (l2 != null) {
            num2 += l2.val * place;
            place *= 10;
            l2 = l2.next;
        }

        long sum = num1 + num2;
        if (sum == 0) return new ListNode(0);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (sum > 0) {
            curr.next = new ListNode((int)(sum % 10));
            curr = curr.next;
            sum /= 10;
        }
        return dummy.next;
    }

Brute Force: Not for long integers

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list1=l1;
        ListNode list2=l2;
        ListNode head=null;
        ListNode curr=null;
        int carry=0;


        while(list1!=null || list2!=null || carry!=0){

            int sum=0;

            if(list1!=null){
                sum+=list1.val;
                list1=list1.next;
            }

            if(list2!=null){
                sum+=list2.val;
                list2=list2.next;
            }

            sum+=carry;
            carry=sum/10;

            ListNode newnode=new ListNode(sum%10);

            if(head==null){
                head=newnode;
                curr=head;
            }else{
                curr.next=newnode;
                curr=curr.next;
            }
        }
        return head;
    }

 */

/*
        Rotate a Linked List: Given the head of a singly linked list containing integers, shift the elements of the linked list to the right by k places
        and return the head of the modified list. Do not change the values of the nodes, only change the links between nodes.

        public ListNode rotateRight(ListNode head, int k) {

            if(head==null || head.next==null || k==0) return head;
            ListNode curr=head;

            int n=0;
            while (curr!=null){
            n++;
            curr=curr.next;
            }
            k=k%n;

            for (int i=0;i<k;i++){

            ListNode prev=null;
            curr=head;

            while (curr.next!=null){
                prev=curr;
                curr=curr.next;
            }

            curr.next=head;
            head=curr;
            prev.next=null;
        }
        return head;
    }
    Brute Force: O(n*k)

    public ListNode rotateRight(ListNode head, int k) {

    if (head == null || head.next == null || k == 0) return head;

            ListNode temp = head;
            int length = 1;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }

            k = k % length;
            if (k == 0) return head;

            ListNode fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }

            ListNode slow = head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            fast.next = head;     // make circular
            head = slow.next;     // new head
            slow.next = null;     // break the circle

            return head;
    }

 */



////Flattening a Linked List:

//        if (head == null) return ;
//
//        // Step 1: add all nodes to list
//        ArrayList<Integer> list = new ArrayList<>();
//
//        ListNode temp = head;
//        while (temp != null) {
//            ListNode b = temp;
//            while (b != null) {
//                list.add(b.val);
//                b = b.bottom;
//            }
//            temp = temp.next;
//        }
//
//        // Step 2: sort values
//        Collections.sort(list);
//
//        // Step 3: build new linked list using bottom pointers
//        ListNode newHead = new ListNode(list.get(0));
//        ListNode curr = newHead;
//
//        for (int i = 1; i < list.size(); i++) {
//            curr.bottom = new ListNode(list.get(i));
//            curr = curr.bottom;
//        }

//        class Solution {
//            // Merge two sorted bottom-linked lists
//            ListNode merge(ListNode a, ListNode b) {
//                if (a == null) return b;
//                if (b == null) return a;
//
//                ListNode result;
//
//                if (a.val < b.val) {
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
//            ListNode flatten(ListNode root) {
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


/*  Reverse Linked List in groups of Size K:

            ListNode kReverse(ListNode head, int k) {
            if (head == null || k <= 1) return head;

            ListNode temp = head;
            ListNode prevLast = null;

            while (temp != null) {

                ListNode kthNode = getKthNode(temp, k);
                if (kthNode == null) {
                    // remaining nodes < k → no reverse
                    if (prevLast != null) prevLast.next = temp;
                    break;
                }

                ListNode nextNode = kthNode.next;
                kthNode.next = null; // detach segment

                // reverse the extracted segment
                ListNode reversedHead = reverseLinkedList(temp);

                // connect previous segment
                if (temp == head) {
                    head = reversedHead;
                } else {
                    prevLast.next = reversedHead;
                }

                // temp becomes last of reversed segment
                prevLast = temp;

                // move ahead
                temp = nextNode;
            }

            return head;
        }

        //returns the k-th node from temp (1-based)
        ListNode getKthNode(ListNode temp, int k) {
            k = k - 1; // we already treat temp as 1st node
            while (temp != null && k > 0) {
                temp = temp.next;
                k--;
            }
            return temp;   // may return null if < k nodes remain
        }

        // reverse entire linked list (standard)
        ListNode reverseLinkedList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev; // new head of reversed segment
        }
 */

/*  Delete Nodes From Linked List Present in Array:

    public ListNode modifiedList(int[] nums, ListNode head) {

        if (head == null) return null;

        // Dummy node to handle head deletion
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            boolean found = false;

            // Linear search in nums array
            for (int num : nums) {
                if (curr.val == num) {
                    found = true;
                    break;
                }
            }

            if (found) {
                // Delete curr
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    } O(n*k)

     public ListNode modifiedList(int[] nums, ListNode head) {

        if (head == null) return null;

        // Step 1: Store array values in HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Use dummy node to handle head deletion
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        // Step 3: Traverse and delete nodes
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;   // delete
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    } TC:O(n) SC:O(k)


 */
    }
}
