
class ListNode {
	int data;
	ListNode next;

	ListNode(int d) {
		data = d;
		next = null;
	}
}

public class InsertIntoCircularLinkedList {
	ListNode head, last;

	public InsertIntoCircularLinkedList() {
		int a[] = { 7, 2, 1, 4,5,6,8 };
		createList(a);

	}

	private void createList(int a[]) {
		for (int i = 0; i < a.length; i++) {
			ListNode n = new ListNode(a[i]);
			sortedInsert(n);
		}

	}

	private void sortedInsert(ListNode n) {
		ListNode current = head;
		if (current == null) {
			n.next = n;
			head = n;
			printList();
		} else if (n.data < current.data) {
			while (current.next != head) {
				current = current.next;
			}
			n.next = head;
			current.next = n;
			head = n;
		} else {
			while(current.next!=head){
				if(current.next.data<n.data){
					current=current.next;
				}else{
					break;
				}
			}
			n.next=current.next;
			current.next=n;
		}
		printList();

	}

	private void printList() {
		ListNode h = head;
		do {
			System.out.print(h.data + " ");
			h = h.next;
		} while (h != head);
		System.out.println();
	}

}
