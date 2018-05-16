import java.util.Scanner;
import java.util.Stack;
class Node {
	int data;
	Node lc,rc;
	
	public Node(int data){
		this.data = data;
		lc = rc = null;
	}
}

public class HW3 {
	public static Node root;
	private static Scanner sc;
	
	public HW3() {
		HW3.root = null;
	}
	
	public int countLeaves(Node n){
		if(n==null)
			return 0;
		if(n.lc == null && n.rc == null)
			return 1;
		else
			return countLeaves(n.lc) + countLeaves(n.rc);
	}
	
	public void printPreorder(){
		if (root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(s.empty() == false){
			Node n = s.peek();
			System.out.print(n.data+ " ");
			s.pop();
			if(n.rc != null)
				s.push(n.rc);
			if(n.lc != null)
				s.push(n.lc);
		}
	}
	
	public void insert(int x){
		Node n = new Node (x);
		if (root == null){
			root = n;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(x < current.data){
				current = current.lc;
				if(current == null){
					parent.lc = n;
					return;
				}
			}
			else {
				current = current.rc;
				if(current == null){
					if(current == null){
						parent.rc = n;
						return;
					}
				}
			}
		}
	}
	
	public int countInterval(Node root){
		if(root == null)
			return 0;
		int count = countInterval(root.lc) + countInterval(root.rc);
		if(root.data <=10 && root.data >=-10)
			return count + 1;
		else
			return count;
	}
	
	public static void main(String[] args) {
		HW3 tree = new HW3();
		sc = new Scanner(System.in);
		
		System.out.println("Binary Search Tree");
		
		boolean created = false;
		boolean running = true;
		int selection = 0;
		int add;
		
		while(running){
			if(!created){
				System.out.println("Enter first element:");
				try{
					add = sc.nextInt();
				}
				catch(Exception e){
					System.out.println("Error: must enter integer");
					sc.nextLine();
					continue;
				}
				tree.insert(add);
				created = true;
			}	
			if(created){
				System.out.println("Pick your option:");
				System.out.println("1) Add element");
				System.out.println("2) PreOrder uutput");
				System.out.println("3) Print leaves amount");
				System.out.println("4) Find elements between [-10;10]");
				System.out.println("0) Exit");
				
				try{
					selection = sc.nextInt();	
				}
				catch (Exception e){
					System.out.println("Error: must enter integer");
				}
				
				switch(selection){
				
				case 1:
					System.out.println("Enter new node: ");
					int value = 0;
					try {
						value = sc.nextInt();
					} catch (Exception e) {
						System.out.println("Error: must enter integer");
						sc.nextLine();
						break;
					}
					tree.insert(value);
					break;
				
				case 2:
					System.out.println("Nodes:");
					System.out.println();
					tree.printPreorder();
					System.out.println();
					System.out.println();
					break;
					
				case 3:
					 System.out.println();
	                 System.out.println("Leaves: " + tree.countLeaves(root));
	                 System.out.println();
	                 break;
	             
				case 4:
					System.out.println();
					System.out.println("Elements between [-10;10]: " + tree.countInterval(root));
					System.out.println();
					break;
				
				case 0:
					running = false;
					System.out.println("Finished!");
					break;
					
				default:
					break;
				}
			}	
		}
	}
}
