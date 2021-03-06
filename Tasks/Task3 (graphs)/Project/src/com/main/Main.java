package com.main;
import java.util.*;

class Pair<T extends Comparable<T>>{
	Student ref;
	T data;
	Pair(Student s,T data){
		this.ref = s;
		this.data = data;
	}
}

public class Main{
	public static void main(String[] args) throws Exception{
	  College daiict = new College();
	  LinkedList<Student> studentList =  daiict.fillData("/home/vishwam/E/college/DAIICT/Summer Internship (Under Lavneet sir)/SummerInternship_DAIICT/Tasks/Task3 (graphs)/Project/src/data.txt");
	  //daiict.printStudentData(studentList); 

	  
	  RedBlackTree2<Integer> indexTree = daiict.getTreeBasedOnIndex(studentList);
	  RedBlackTree2<Long> idTree = daiict.getTreeBasedOnStudentId(studentList);
	  RedBlackTree2<String> nameTree = daiict.getTreeBasedOnName(studentList);

	  Main obj = new Main();
	  obj.welcomeMessage("Dhirubhai Ambani Institute of Information and Communication Technology(DAIICT)");	  
	  obj.driver(indexTree,idTree,nameTree);
	  
	  
	  
	  //trying for graphs
	  /*
	  ArrayList<ArrayList<Pair<Integer>>> graph = new ArrayList<ArrayList<Pair<Integer>>>();
	  for(Student s : studentList){
		 graph.add(new ArrayList<Pair<Integer>>());
		 
	  }
	  */
	  
	}
	public void welcomeMessage(String collegeName){
		System.out.println("Welcome to "+collegeName);
		System.out.println("\nHere we are having list of our students .We have there index,Student id,name and their cpi");
	}
	public void driver(RedBlackTree2<Integer> indexTree,RedBlackTree2<Long> idTree,RedBlackTree2<String> nameTree){
		System.out.println("By which criteria do you want to search");
		System.out.println("1. By Index");
		System.out.println("2. By Student id");
		System.out.println("3. By Name");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		switch(choice){
		case 1 :
			System.out.println("Enter Index to search");
			int index = input.nextInt();
			if(indexTree.searchTree(index).data!=null){
				System.out.println("found");
				Student s = indexTree.searchTree(0).ref;
				System.out.println("name : "+s.getName()+" id : "+s.getId()+" cpi"+s.getCpi());
			}
			else{
			    System.out.println("not found");
			}
			break;
		case 2:
			System.out.println("Enter Student id to search");
			long id = input.nextLong();
			if(idTree.searchTree(id).data!=null){
				System.out.println("found");
				Student s = idTree.searchTree(id).ref;
				System.out.println("name : "+s.getName()+" id : "+s.getId()+" cpi"+s.getCpi());
			}
			else{
			    System.out.println("not found");
			}
			break;
		case 3:
			System.out.println("Enter name to search");
			
			input.nextLine();
			String name = input.nextLine();
			
			if(nameTree.searchTree(name).data!=null){
				System.out.println("found");
				Student s = nameTree.searchTree(name).ref;
				System.out.println("name : "+s.getName()+" id : "+s.getId()+" cpi"+s.getCpi());
			}
			else{
			    System.out.println("not found");
			    System.out.println("asdfadf "+name);
			}
			break;
		default:
			System.out.println("Please enter a valid input!");
			break;
		}
		input.close();
	}
}
