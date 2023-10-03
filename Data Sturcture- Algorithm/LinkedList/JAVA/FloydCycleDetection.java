/*

Let us assume that we have a Singly Linked List as follows:

1 --> 2 --> 3 --> 4
            ^     |
            |     |
            |     v
            6 <-- 5
            
As we can see, there is a loop that exists within this singly linked list. 

One way of detecting this loop is to use a HashMap.
You keep on traversing through the list and keep on adding each element in the HashMap.
HashMap has a useful property: you cannot add a duplicate element.
This means if a node cannot be added to the HashMap, it implies that the node is already present there, and thus the cycle is detected.

However, using a HashMap takes up space in the memory. In this case, both the time complexity and the space complexity becomes O(n).

This is where Floyd's Cycle Detection comes handy.

Floyd's Cycle Detection is an algorithm that basically provides a way to detect a loop without using HashMap. Therefore, the space complexity becomes O(1), while time complexity is O(n).

Floyd's Cycle Detection uses 2 pointers to traverse through the list- a fast pointer and a slow pointer. Both the fast and the slow pointers start at the head(the starting node). The difference lies in the fact that a slow pointer moves one step at a time, and a fast pointer moves two steps at a time.
This means that by the time the slow pointer reaches the loop, the fast pointer is already inside the loop.
There has to be an instance when both the fast and slow pointers point to the same node other than head. This is when the loop is detected. 

If the fast pointer reaches null(the value that is pointed to by the last node), then it means that there is no cycle in the list.

Below is the code snippet to implement Floyd's Cycle Detection
*/
public class FloydCycleDetection {
  private ListNode head;

  private class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
      this.data = data;
      this.next = null;
    }
  }

  public boolean detectLoop() // Detecting whether there is a loop using Floyd's Cycle Detection
  {
    ListNode fastPointer = head;
    ListNode slowPointer = head;
    while (fastPointer != slowPointer && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
      if (slowPointer == fastPointer)
        return true;
    }
    return false;
  }// End of detectLoop()

  public ListNode startingNodeOfLoop() // Returning the starting node of the loop
  {
    ListNode fastPointer = head;
    ListNode slowPointer = head;
    while (fastPointer != slowPointer && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
      if (slowPointer == fastPointer) {
        ListNode temp = head;
        while (temp != slowPointer) {
          temp = temp.next;
          slowPointer = slowPointer.next;
        }
        return temp; // starting node of loop
      }
    }
    return null;
  }// End of startingNodeOfLoop()

}
