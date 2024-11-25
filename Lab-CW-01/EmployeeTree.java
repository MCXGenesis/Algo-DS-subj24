import java.util.*;

class EmployeeTree {
    Map<String, EmployeeNode> nodeMap;
    String rootName; 

    public EmployeeTree() {
        nodeMap = new HashMap<>();
        rootName = null;//CEO
    }

    public void add(String name) {
        EmployeeNode node = new EmployeeNode(name);
        nodeMap.put(name, node);
        if(rootName == null){
            rootName = name; 
        }
    }

    public void setLeftChild(String parentName, String childName) {
        EmployeeNode parent = nodeMap.get(parentName); 
        parent.left = childName; 
        nodeMap.put(childName, new EmployeeNode(childName));
    }

    public void setRightChild(String parentName, String childName) {
        EmployeeNode parent = nodeMap.get(parentName); 
        parent.right = childName; 
        nodeMap.put(childName, new EmployeeNode(childName));
    }

    public int findMaxDepth(String nodeName) {
        if(nodeName == null || !nodeMap.containsKey(nodeName)) return 0; 
        
        EmployeeNode node = nodeMap.get(nodeName);
        int leftDepth = findMaxDepth(node.left); 
        int rightDepth = findMaxDepth(node.right); 
        
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void listEmployeesByLevel() {
        if(rootName == null) return; 
        
        Queue<String> antrian = new LinkedList<>();
        antrian.add(rootName);
        
        int level = 1;
        while(!antrian.isEmpty()){
            int levelSize = antrian.size(); 
            System.out.println("Level " + level + ":");
            for(int i = 0; i < levelSize; i++){
                String currentName = antrian.poll(); 
                EmployeeNode current = nodeMap.get(currentName); 
                System.out.print(current.name + " ");
                if (current.left != null) antrian.add(current.left); 
                if (current.right != null) antrian.add(current.right); 
            }
            System.out.println();
            level++;
        }
    }

    public boolean findEmployee(String nodeName, String name) { 
        if(nodeName == null || !nodeMap.containsKey(nodeName)) return false;
    
        EmployeeNode node = nodeMap.get(nodeName);
        if(node.getName().equalsIgnoreCase(name)) return true;
        
        return findEmployee(node.left, name) || findEmployee(node.right, name);
    }
}