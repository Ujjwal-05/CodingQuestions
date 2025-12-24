package Coding;

public class BinarySearchQuestions {
    public static void main(String[] args) {

/*
    In binary search, left and right represent a moving search window, and when the loop ends (`left > right`), a fixed relationship
    always holds: left points to the correct insertion position**, while **`right` points to the last index smaller than that position**.
    This is why left is returned when the problem asks for an insertion index, lower bound, first element greater than or equal to a target,
    or the ceiling of a number. On the other hand, right is returned when the problem asks for the last element less than or equal to a target,
    the last element strictly smaller than a target, or the floor of a number. In short, after binary search finishes, left represents the
    “future” position where the element should go, and right represents the “past” position that has already been passed, and choosing which
    one to return depends entirely on what the problem is asking for.

 */

    }
}
