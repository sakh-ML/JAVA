

public class MinDDL{

	public static void main(String[] args){

		System.out.println("Hey");
		Node node1 = new Node(5);
		Node node2 = new Node(17);

		DDL myDoubleLinkedList = new DDL();
		myDoubleLinkedList.addLast(5);
		myDoubleLinkedList.addLast(10);
		myDoubleLinkedList.addLast(15);
		myDoubleLinkedList.addLast(3);
		myDoubleLinkedList.addLast(2);
		myDoubleLinkedList.removeLast();
		myDoubleLinkedList.removeLast();

		myDoubleLinkedList.printList();
		System.out.println(myDoubleLinkedList.size);
	}
}

class DDL{

	Node head = new Node();
	Node tail = new Node();
	int size;

	public DDL(){
		this.head = null;
		this.tail = null;
	}

	public void addLast(int data){

		Node newNode = new Node(data);

		if(this.head == null){
			this.head = newNode;
			this.tail = newNode;
		}

		else{
			newNode.prev = this.tail;
			newNode.next = null;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		++size;
	}

	public void addFirst(int data){

		Node newNode = new Node(data);

		if(this.tail == null){
			this.head = newNode;
			this.tail = newNode;
		}

		else{
			newNode.next = this.head;
			newNode.prev = null;
			this.head.prev = newNode;
			this.head = newNode;
		}
		++size;
	}

	public void printList(){
		Node current = new Node();
		for(current = this.head; current != null; current = current.next){
			System.out.println(current);
		}
	}

	public void removeLast(){

		if(tail == null){
			return;
		}

		if(size == 1){
			head = null;
			tail = null;
			size = 0;
			return;
		}
		else{
			Node newLast = this.tail.prev;
			newLast.next = null;
			this.tail = newLast;
			--size;
		}
	}

	public void removeFirst(){
		if(head == null){
			return;
		}

		if(size == 1){
			head = null;
			tail = null;
			size = 0;
			return;
		}
		else{
			Node newFirst = this.head.next;
			newFirst.prev = null;
			this.head = newFirst;
			--size;
		}
	}

	public boolean searchForObject(int dataToSearch){
		Node current = new Node();
		for(current = this.head; current != null; current = current.next){
			if(current.data == dataToSearch){
				return true;
			}
		}
		return false;
	}

}


class Node{
	
	Node prev;
	int data;
	Node next;

	public Node(){
		this.prev = null;
		this.data = 0;
		this.next = null;
	}

	public Node(int data){
		this.prev = null;
		this.data = data;
		this.next = null;
	}

	@Override
	public String toString(){
		return "Data: " + this.data;
	}
}


