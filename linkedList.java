import java.util.Scanner;
class Node{
	public int data;
	public Node next;
	Node(int d){
		data=d;
		next=null;
	}
}

public class LinkedList {
	static Scanner sc = new Scanner(System.in);
	public static Node head;
	public int size=0;
	public static void main(String[] args) {
		create(head);
		display(head);
		//create(head2);
		//display(head2);
		//insertBegin();
		//insertEnd();
		//search();
		//insertLoc();
		//int p=size(head);
		//sortedinsert();
		//deletebegin();
		//deleteend();
		//display(head);
		//deleteNodebyKey();
		//delloc();
		//reverse(head);
		//copylist();
		//comparision(head,head2);
	}
	public static void comparision(Node head, Node head2) {
		int h1=size(head);int h2=size(head2);
		if(h1!=h2) {
			System.out.println("size mismatch");
		}
		boolean p=false;
		if(h1==h2) {
			int temp=head.data;
			int temp1=head2.data;
			
			if(temp==temp1) {
				head=head.next;
				head2=head2.next;
				p=true;
			}
		}
		if(p) {
			System.out.println("Both linked list are same");
		}
		
	}
	public static Node copylist() {
		Node newhead=null;
		Node newtail=null;
		Node temp=null;
		Node curr=head;
		if(curr==null) {
			return null;	
		}
		newhead=new Node(curr.data);
		newtail=newhead;
		curr=curr.next;
		while(curr!=null) {
			temp=new Node(curr.data);
			newtail.next=temp;
			newtail=temp;
			curr=curr.next;
		}
		System.out.println();
		display(newhead);
		return newhead;
	}
	public static Node reverse(Node temp) {
		if( size(temp) >= 2) {
			Node p=null;
			Node q=head;
			Node r=head.next;
			q.next=null;
			while(r!=null) {
				p=q;
				q=r;
				r=r.next;
				q.next=p;
			}
			head=q;
		}
		System.out.println();
		display(head);
		return null;
	}
	public static void delloc() {
		 System.out.println();
		    Node temp=head;
			System.out.println("Enter location");
			int loc = sc.nextInt();
			int c=size(head);
			if(loc<=c+1) {
				if(temp==null) {
					System.out.println("underflow");
				}
				else if(loc==1){
					deletebegin();
				}
				else if(loc==c) {
					deleteend();
				}
				else {
					
					int cnt=1;
					 
					while(cnt<loc-1) {
						cnt++;
						temp=temp.next;
					}
					temp.next=temp.next.next;
				}
			}
			display(head);
		}
	public static void deleteNodebyKey() {
		System.out.println("Enter the key value");
		int key=sc.nextInt();
		Node prev=null;
		Node curr=head;
		if(curr==null) {
			return;
		}
		while(curr!=null) {
			if(curr.data==key) {
				if(curr==head) {
					head=head.next;
					curr=head;
				}
				else {
					prev.next=curr.next;
					curr=curr.next;
				}
			}
			else {
				prev=curr;
				curr=curr.next;
			}
		}
		display(head);
	}
	public static void deleteend() {
		if(head.next==null){
			head=head.next;
		}
		else {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			temp.next=null;
		}
		System.out.println();
//		display(head);
	}
	public static void deletebegin() {
		System.out.println(); 
		if(head==null) {
			System.out.println("Deletion not possible as there are no linked list");
			return;
		}
		head=head.next;
	}
	public static void sortedinsert() {
		System.out.println();
		System.out.println("Enter the data of the node");
		int d=sc.nextInt();
		Node p=new Node(d);
		Node temp=head;
		if(temp.next==null||temp.data>=p.data) {
			p.next=temp;
			temp=p;
		}
		else {
			while(temp.next!=null && temp.next.data<p.data) {
				temp=temp.next;
			}
			p.next=temp.next;
			temp.next=p;
	}
}
	public static int search(int key) {
//		System.out.println("Enter the element data you want to search");
//		int key=sc.nextInt();
		Node temp=head;
		int pos=1;
		int f=0;
		while(temp!=null) {
			if(temp.data==key) {
				System.out.println(key+" is present in the linked list at "+pos);
				 f=1;
			}
				temp=temp.next;
				pos++;
		}
		if(f==0) {
			System.out.println(key+" is not present");
		}
		return pos;
	}
	public static void insertLoc() {
		
		System.out.println("Enter the location where you want to insert");
		int loc=sc.nextInt();
		int c=size(head);
		if(loc<=c+1) {
			if(loc==1) {System.out.println("Enter data");
			int d=sc.nextInt();
				insertBegin();
			}
			else if(loc==c+1) {
				insertEnd();
			}
			else {
				System.out.println("Enter data");
				int d=sc.nextInt();
				Node p= new Node(d);
				System.out.println("enter data");
				Node q= head;
				int cnt=1;
				while(cnt<loc-1) {
					cnt++;
					q=q.next;
				}
				p.next=q.next;
				q.next=p;
			}
		}
	}
	public static int size(Node temp) {
		// TODO Auto-generated method stub
		int count=0;
		while(temp!=null) {
				count++;
				temp=temp.next;
		}
	return count;
}
	public static void insertBegin() {
		System.out.println("Enter data");
		int d=sc.nextInt();
		Node p =new Node(d);
		p.next=head;
		head=p;
	}
	public static void insertEnd() {
		System.out.println("Enter data");
		int d=sc.nextInt();
		Node p=new Node(d);
		Node q =head;
		if(q==null) {
			q=p;
		}
		while(q.next != null) {
			q=q.next;
		}
			q.next=p;
	}
	public static void display(Node temp) {
		Node head=temp;
			while(head!=null) {
				System.out.print(head.data+" ");
				head=head.next;
			}
	}
	public static void create(Node head) {
		System.out.println("Enter data part");
		int d=sc.nextInt();
		Node p=new Node(d);
		p.next=null;
		head=p;
		System.out.println("Want to create more node y/n ?");
		char ch=sc.next().charAt(0);
		while(ch !='n') {
			System.out.println("Enter data part");
			int e=sc.nextInt();
			Node q=new Node(e);
			q.next=null;
			p.next=q;
			p=q;
			System.out.println("Want to create more node y/n ?");
			ch=sc.next().charAt(0);
		}
	}
	
	
	
}
