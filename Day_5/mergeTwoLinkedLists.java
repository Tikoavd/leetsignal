// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
ListNode<Integer> ptr1 = l1;
ListNode<Integer> ptr2 = l2;
ListNode<Integer> myList = new ListNode<Integer>(0);
ListNode<Integer> retList = myList;

while(!(ptr1 == null && ptr2 == null)) {
    if(ptr2 == null) {
        myList.next = ptr1;
        break;
    }
    if(ptr1 == null){
        myList.next = ptr2;
        break;
    }
    
    if(ptr2.value < ptr1.value) {
        myList.next = ptr2;
        ptr2 = ptr2.next;
        }
    else {
        myList.next = ptr1;
        ptr1 = ptr1.next;
    }
    myList = myList.next;    
}
return retList.next;
}
