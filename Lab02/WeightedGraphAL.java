import java.util.*;

public class WeightedGraphAL {
    Map<String, List<Edge>> adjacencyList;
    List<String> path;
    Map<String, Integer> distance;

    WeightedGraphAL(){
        this.adjacencyList = new HashMap<>();
        this.path = new ArrayList<>();
        this.distance = new HashMap<>();
    }

    void addEdge(String node1, String node2, int weight){
        this.adjacencyList.putIfAbsent(node1, new ArrayList<>());
        this.adjacencyList.putIfAbsent(node2, new ArrayList<>());
        this.adjacencyList.get(node1).add(new Edge(node2, weight));
        this.adjacencyList.get(node2).add(new Edge(node1, weight));
    }

    void djikstra(String start, String end){
        LinkedList<Node> visited = new LinkedList<>();
        PriorityQueue<Node> waiting = new PriorityQueue<>();


        // Initialize distances
        for (String node : adjacencyList.keySet()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(start, 0);
        waiting.add(new Node(start, 0));
        path.add(start);

        // Start loop
        while (!waiting.isEmpty()) {
            Node current = waiting.poll();
            String currentNode = current.node;
                        
            // If the node is already visited, skip it
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            // If reached end
            // if (currentNode.equals(end)){
            //     String pathString = pathToString(path, end);
            //     System.out.println("Shortest Path: " + pathString);
            //     System.out.println("Total Distance: " + distance.get(end));
            //     return;
            // }

            // Explore
            for (Edge edge : this.adjacencyList.get(currentNode)) {
                String neighbor = edge.targetNode;
                int newDist =  distance.get(current) + edge.weight;

                if (newDist < distance.get(current)) {
                    distance.put(neighbor, newDist);
                    waiting.add(new Node(neighbor, newDist));
                    path.add(currentNode);
                }
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (String node : adjacencyList.keySet()) {
            output += node + " ---> ";
            for (Edge edge : adjacencyList.get(node)) {
                output += edge.targetNode + "(" + edge.weight + ") ";
            }
            output += "\n";
        }

        return output;
    }
}

