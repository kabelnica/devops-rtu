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
		
		//Izvada informāciju par autoru
		System.out.println("Binārais meklēšanas koks");
		System.out.println("Kaspars Ābelnīca RDBI0-2 161RDB025");
		
		boolean created = false;
		boolean running = true;
		int selection = 0;
		int add;
		
		while(running){
			if(!created){
				System.out.println("Lai izveidotu koku, ievadiet pirmo elementu:");
				try{
					add = sc.nextInt();
				}
				catch(Exception e){
					System.out.println("Kļūda: jāievada vesels skaitlis");
					sc.nextLine();
					continue;
				}
				tree.insert(add);
				created = true;
			}	
			if(created){
				System.out.println("Izvēlieties operāciju:");
				System.out.println("1) Pievienot elementu");
				System.out.println("2) Izvadīt koka virsotnes preorderiāli");
				System.out.println("3) Izvadīt koka lapu skaitu");
				System.out.println("4) Atrast elementus, kas pieder intervālam [-10;10]");
				System.out.println("0) Iziet");
				
				try{
					selection = sc.nextInt();	
				}
				catch (Exception e){
					System.out.println("Kļūda: jāievada vesels skaitlis");
				}
				
				switch(selection){
				
				case 1:
					System.out.println("Ievadiet jaunā mezgla vērtību: ");
					int value = 0;
					try {
						value = sc.nextInt();
					} catch (Exception e) {
						System.out.println("Kļūda: jāievada Integer tipa vērtība");
						sc.nextLine();
						break;
					}
					tree.insert(value);
					break;
				
				case 2:
					System.out.println("Koka virsotnes:");
					System.out.println();
					tree.printPreorder();
					System.out.println();
					System.out.println();
					break;
					
				case 3:
					 System.out.println();
	                 System.out.println("Lapu skaits: " + tree.countLeaves(root));
	                 System.out.println();
	                 break;
	             
				case 4:
					System.out.println();
					System.out.println("Elementi, kas pieder intervālā, [-10;10]: " + tree.countInterval(root));
					System.out.println();
					break;
				
				case 0:
					running = false;
					System.out.println("Programma aizvērta!");
					break;
					
				default:
					break;
				}
			}	
		}
	}
}
