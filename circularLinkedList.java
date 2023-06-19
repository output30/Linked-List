package ch6;
import java.util.*;
class CNode{
	public int data;
	public CNode next;
	CNode(int d){
		this.data=d;
		this.next=null;
	}
}
public class CircularLinkedList {
	static Scanner sc = new Scanner(System.in);
	public static CNode head;
	public static CNode tail;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter no of nodes to be created");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
		insend();
	}
		//search();
		//insloc();
		//insloc1();
		//delbeg();
		delend();
	}
       public static void delend() {
    	   CNode temp=head;
    	   while(temp.next!=tail) {
    		   temp=temp.next;
    	   }
    	   temp.next=head;
    	   display();
	}
	public static void delbeg() {
    	   head=head.next;
    	   tail.next=head;
	}
//	public static void insloc1() {
//		System.out.println("Enter data of the node");
//		int d=sc.nextInt();
//		CNode p =new CNode(d);
//		p.next=tail.next;
//		tail.next=p;
//	}
	public static void insloc() {
		int pos=search();
		int c=1;
		System.out.println("Enter data of the node");
		int d=sc.nextInt();
		CNode p =new CNode(d);
		CNode temp=tail.next;
		do {
			c++;
			temp=temp.next;
		}while(c<pos);
		p.next=temp.next;
		temp.next=p;
	}
	public static int search() {
		System.out.println("Enter key to search");
		int d=sc.nextInt();
		CNode temp=tail.next;
		if(tail==null) {
			System.out.println("list is empty");
		}
		int c=1;
		do {
			if(temp.data==d) {
				return c;
			}
			else {
				c++;
			}
			temp=temp.next;
		}while(temp!=tail.next);
		return 0;
	}
	public static void display() {
		CNode temp=tail.next;
		if(tail==null) {
			System.out.println("list is empty");
		}
		do {
			System.out.println(temp.data+" ");
			temp=temp.next;
		}while(temp!=tail.next);
	}
	public static void insbeg() {
		System.out.println("Enter data of the node");
		int d=sc.nextInt();
		CNode p =new CNode(d);
		if(tail==null) {
			head=tail=p;
			p.next=tail;
		}
		else {
			p.next=tail.next;
			tail.next=p;
			
		}
	}
	public static void insend(){    
		System.out.println("Enter data of the node");
		int d=sc.nextInt();
        CNode p = new CNode(d);        
        if(head == null) {    
            head = p;    
            tail = p;    
            p.next = head;    
        }    
        else {    
            tail.next = p;    
            tail = p;    
            tail.next = head;    
        }    
    }    

}

