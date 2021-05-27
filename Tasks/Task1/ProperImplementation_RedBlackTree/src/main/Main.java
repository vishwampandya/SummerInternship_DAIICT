package main;

import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

public static void menu(int menuType){
	if(menuType==1){
		System.out.println("Menu 1");
		System.out.println("Choose data type of your red black tree");
		System.out.println("1. Integer");
		System.out.println("2. String");
		System.out.println("3. Double");
	}
	else if(menuType==2){
		System.out.println("Menu 2");
		System.out.println("Choose a task that you want to perform");
		System.out.println("1. Find");
		System.out.println("2. Insert");
		System.out.println("3. Delete");
		System.out.println("0. exit");
	}
}
//public static void flow(int type){
//	int choice;
//	int Idata;
//	double Ddata;
//	String Sdata;
//	switch(type){
//	case 1 : 
//		//Integer
//		RedBlackTree<Integer>.Node Iroot = null;
//        RedBlackTree<Integer> redBlackTreeI = new RedBlackTree<Integer>();
//        do{
//			menu(2);
//			choice = input.nextInt();
//			switch(choice){
//			case 1 : 
//				//find
//				System.out.print("Enter the Integer you want to find : ");
//				Idata = input.nextInt();
//				if(redBlackTreeI.find(Iroot, Idata)){
//					System.out.println("element found");
//				}
//				else{
//					System.out.println("element not found");
//				}
//				break;
//			case 2 :  
//				//insert				
//				System.out.print("Enter the Integer you want to insert : ");
//				Idata = input.nextInt();
//				if(redBlackTreeI.find(Iroot, Idata)){
//					System.out.println("element already exits!!!");
//				}
//				else{
//					Iroot = redBlackTreeI.insert(Iroot, Idata);
//					System.out.println("element inserted!!");
//				}
//				
//				
//				break;
//			case 3 :
//				//delete
//				System.out.print("Enter the Integer you want to delete : ");
//				Idata = input.nextInt();
//				if(redBlackTreeI.find(Iroot, Idata)){
//					Iroot = redBlackTreeI.delete(Iroot, Idata);
//					System.out.println("element deteted!!");
//				}
//				else{
//					
//					System.out.println("element doesnot exits!!!");
//				}
//				
//				break;
//			case 0 : 
//				break;
//			default :
//				System.out.println("Please enter a valid input");
//				break;
//			}
//			
//			
//		}while(choice!=0);
//        
//        break;
//	case 2 :  
//		//String
//		RedBlackTree<String>.Node Sroot = null;
//        RedBlackTree<String> redBlackTreeS = new RedBlackTree<String>();
//        do{
//			menu(2);
//			choice = input.nextInt();
//			switch(choice){
//			case 1 : 
//				//find
//				System.out.print("Enter the String you want to find : ");
//				Sdata = input.next();
//				if(redBlackTreeS.find(Sroot, Sdata)){
//					System.out.println("element found");
//				}
//				else{
//					System.out.println("element not found ");
//				}
//				break;
//			case 2 :  
//				//insert				
//				System.out.print("Enter the String you want to insert : ");
//				Sdata = input.next();
//				if(redBlackTreeS.find(Sroot, Sdata)){
//					System.out.println("element already exits!!!");
//				}
//				else{
//					Sroot = redBlackTreeS.insert(Sroot, Sdata);
//					System.out.println("element inserted!! "+Sroot.data);
//				}
//				
//				
//				break;
//			case 3 :
//				//delete
//				System.out.print("Enter the String you want to delete : ");
//				Sdata = input.next();
//				if(redBlackTreeS.find(Sroot, Sdata)){
//					Sroot = redBlackTreeS.delete(Sroot, Sdata);
//					System.out.println("element deteted!!");
//				}
//				else{
//					
//					System.out.println("element doesnot exits!!!");
//				}
//				
//				break;
//			case 0 : 
//				break;
//			default :
//				System.out.println("Please enter a valid input");
//				break;
//			}
//			
//			
//		}while(choice!=0);
//        
//        break;
//	case 3 :
//		//Double
//		RedBlackTree<Double>.Node Droot = null;
//        RedBlackTree<Double> redBlackTreeD = new RedBlackTree<Double>();
//        do{
//			menu(2);
//			choice = input.nextInt();
//			switch(choice){
//			case 1 : 
//				//find
//				System.out.print("Enter the Double you want to find : ");
//				Ddata = input.nextDouble();
//				if(redBlackTreeD.find(Droot, Ddata)){
//					System.out.println("element found");
//				}
//				else{
//					System.out.println("element not found");
//				}
//				break;
//			case 2 :  
//				//insert				
//				System.out.print("Enter the Double you want to insert : ");
//				Ddata = input.nextDouble();
//				if(redBlackTreeD.find(Droot, Ddata)){
//					System.out.println("element already exits!!!");
//				}
//				else{
//					Droot = redBlackTreeD.insert(Droot, Ddata);
//					System.out.println("element inserted!!");
//				}
//				
//				
//				break;
//			case 3 :
//				//delete
//				System.out.print("Enter the Double you want to delete : ");
//				Ddata = input.nextDouble();
//				if(redBlackTreeD.find(Droot, Ddata)){
//					Droot = redBlackTreeD.delete(Droot, Ddata);
//					System.out.println("element deteted!!");
//				}
//				else{
//					
//					System.out.println("element doesnot exits!!!");
//				}
//				
//				break;
//			case 0 : 
//				break;
//			default :
//				System.out.println("Please enter a valid input");
//				break;
//			}
//			
//			
//		}while(choice!=0);
//        
//        break;
//	case 0 : 
//		break;
//	default :
//		System.out.println("Please enter a valid input");
//		break;
//	}
//	
//}

//through if else
public static void flow(int type){
	int choice;
	int Idata;
	double Ddata;
	String Sdata;
	if(type==1){
	
		//Integer
		RedBlackTree<Integer>.Node root = null;
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
        do{
			menu(2);
			choice = input.nextInt();
			switch(choice){
			case 1 : 
				//find
				System.out.print("Enter the Integer you want to find : ");
				Idata = input.nextInt();
				if(redBlackTree.find(root, Idata)){
					System.out.println("element found");
				}
				else{
					System.out.println("element not found");
				}
				break;
			case 2 :  
				//insert				
				System.out.print("Enter the Integer you want to insert : ");
				Idata = input.nextInt();
				if(redBlackTree.find(root, Idata)){
					System.out.println("element already exits!!!");
				}
				else{
					root = redBlackTree.insert(root, Idata);
					System.out.println("element inserted!!");
				}
				
				
				break;
			case 3 :
				//delete
				System.out.print("Enter the Integer you want to delete : ");
				Idata = input.nextInt();
				if(redBlackTree.find(root, Idata)){
					root = redBlackTree.delete(root, Idata);
					System.out.println("element deteted!!");
				}
				else{
					
					System.out.println("element doesnot exits!!!");
				}
				
				break;
			case 0 : 
				break;
			default :
				System.out.println("Please enter a valid input");
				break;
			}
			
			
		}while(choice!=0);
        
	}
	else if(type==2){
		//String
		RedBlackTree<String>.Node root = null;
        RedBlackTree<String> redBlackTree = new RedBlackTree<String>();
        do{
			menu(2);
			choice = input.nextInt();
			switch(choice){
			case 1 : 
				//find
				System.out.print("Enter the String you want to find : ");
				Sdata = input.next();
				if(redBlackTree.find(root, Sdata)){
					System.out.println("element found");
				}
				else{
					System.out.println("element not found ");
				}
				break;
			case 2 :  
				//insert				
				System.out.print("Enter the String you want to insert : ");
				Sdata = input.next();
				if(redBlackTree.find(root, Sdata)){
					System.out.println("element already exits!!!");
				}
				else{
					root = redBlackTree.insert(root, Sdata);
					System.out.println("element inserted!! ");
				}
				
				
				break;
			case 3 :
				//delete
				System.out.print("Enter the String you want to delete : ");
				Sdata = input.next();
				if(redBlackTree.find(root, Sdata)){
					root = redBlackTree.delete(root, Sdata);
					System.out.println("element deteted!!");
				}
				else{
					
					System.out.println("element doesnot exits!!!");
				}
				
				break;
			case 0 : 
				break;
			default :
				System.out.println("Please enter a valid input");
				break;
			}
			
			
		}while(choice!=0);
        
	}
	else if(type==3){
	
		//Double
		RedBlackTree<Double>.Node root = null;
        RedBlackTree<Double> redBlackTree = new RedBlackTree<Double>();
        do{
			menu(2);
			choice = input.nextInt();
			switch(choice){
			case 1 : 
				//find
				System.out.print("Enter the Double you want to find : ");
				Ddata = input.nextDouble();
				if(redBlackTree.find(root, Ddata)){
					System.out.println("element found");
				}
				else{
					System.out.println("element not found");
				}
				break;
			case 2 :  
				//insert				
				System.out.print("Enter the Double you want to insert : ");
				Ddata = input.nextDouble();
				if(redBlackTree.find(root, Ddata)){
					System.out.println("element already exits!!!");
				}
				else{
					root = redBlackTree.insert(root, Ddata);
					System.out.println("element inserted!!");
				}
				
				
				break;
			case 3 :
				//delete
				System.out.print("Enter the Double you want to delete : ");
				Ddata = input.nextDouble();
				if(redBlackTree.find(root, Ddata)){
					root = redBlackTree.delete(root, Ddata);
					System.out.println("element deteted!!");
				}
				else{
					
					System.out.println("element doesnot exits!!!");
				}
				
				break;
			case 0 : 
				break;
			default :
				System.out.println("Please enter a valid input");
				break;
			}
			
			
		}while(choice!=0);
        
	}
	else if(type==0){}
	else{
		System.out.println("Please enter a valid input");
	}
	
}

public static void main(String args[]) {
    	
    	/*RedBlackTree<Integer>.Node root = null;
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<Integer>();
        

        root = redBlackTree.insert(root, 10);
        root = redBlackTree.insert(root, 15);
        root = redBlackTree.insert(root, -10);
        root = redBlackTree.insert(root, 20);
        root = redBlackTree.insert(root, 30);
        root = redBlackTree.insert(root, 40);
        root = redBlackTree.insert(root, 50);
        
        //redBlackTree.printRedBlackTree(root);

        root = redBlackTree.delete(root, 50);
        if(redBlackTree.validateRedBlackTree(root)){
        	System.out.println("This is a red black tree");
        }
        else{
        	System.out.println("Some rules are voilated , this is not a red black tree");
        }*/
    	
    	
    	
    	
    	/*RedBlackTree<String>.Node root = null;
        RedBlackTree<String> redBlackTree = new RedBlackTree<String>();
        

        root = redBlackTree.insert(root, "Vishwam");
        root = redBlackTree.insert(root, "pandya");
        root = redBlackTree.insert(root, "hat");
        root = redBlackTree.insert(root, "cat");
        
        
        //redBlackTree.printRedBlackTree(root);

        root = redBlackTree.delete(root, "cat");
        if(redBlackTree.validateRedBlackTree(root)){
        	System.out.println("This is a red black tree");
        }
        else{
        	System.out.println("Some rules are voilated , this is not a red black tree");
        }
        if(redBlackTree.find(root,"hat")){
        	System.out.println("found");
        }
        else{
        	System.out.println("not found");
        }*/
		
	
		char ans = 'Y';
		do{
			menu(1);
			int type = input.nextInt();
			flow(type);	
		
			
			System.out.println("do you want to make another tree?(y/n)");
			ans = input.next().charAt(0);
		}while(ans=='y'||ans=='Y');
		
		
		
		
		
		input.close();
    }
}
