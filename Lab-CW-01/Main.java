/**
 * ES234317 - Algorithms and Data Structures
 * Computing Lab. Work
 * Coursework No.   : 01
 * Student ID       : 5026231107
 * Student Name     : Naufal Maula Nabil
 * Class            : C
 */
 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        // task3();
        
    }
    
    public static void task1() {
        SocialNetworkGraph network = new SocialNetworkGraph();
    
        // Add users
        network.addUser("A");
        network.addUser("B");
        network.addUser("C");
        network.addUser("D");
        network.addUser("E");
        network.addUser("F");
        network.addUser("G");
        network.addUser("H");
        network.addUser("I");
    
        // Add friendships
        network.addFriendship("A", "B");
        network.addFriendship("A", "C");
        network.addFriendship("B", "D");
        network.addFriendship("B", "E");
        network.addFriendship("C", "F");
        network.addFriendship("D", "G");
        network.addFriendship("E", "H");
        network.addFriendship("F", "I");
    
        // Perform BFS and DFS starting from user A
        network.bfs("A");
        network.dfs("A");
    }
    
    public static void task2() {
        EmployeeTree hierarchy = new EmployeeTree();
        hierarchy.add("CEO");
        hierarchy.setLeftChild("CEO","Manager1");
        hierarchy.setLeftChild("Manager1","Emp1");
        hierarchy.setRightChild("Manager1","Emp2");
        hierarchy.setRightChild("CEO","Manager2");
        hierarchy.setRightChild("Manager2","Emp4");
        hierarchy.setLeftChild("Manager2","Emp3");

        // Task 1: Find Maximum Depth
        System.out.println("Maximum Depth: " + hierarchy.findMaxDepth("CEO"));

        // Task 2: List Employees by Level
        System.out.println("Employees by Level:");
        hierarchy.listEmployeesByLevel();

        // Task 3: Find a Specific Employee
        String searchName = "Emp3";
        System.out.println("Is " + searchName + " in the hierarchy? " + hierarchy.findEmployee("CEO", searchName));
    }
    
    public static void task3() {
        // your code goes here
        
    }
}
