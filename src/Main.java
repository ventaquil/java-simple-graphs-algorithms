public class Main {
    public static void main(String[] args) {
        // Demo graph
        //
        //       (0)
        //       / \
        //  2.0 /   \ 1.0
        //     / 3.0 \
        //    (1)---(2)
        //     |
        // 1.0 |
        //     |
        //    (3)

        Node[] nodes = new Node[] { // Prepare nodes array
            new Node(),
            new Node(),
            new Node(),
            new Node()
        };

        Edge[] edges = new Edge[] { // Prepare edges array
            new Edge(nodes[0], nodes[1], 2.0),
            new Edge(nodes[0], nodes[2], 1.0),
            new Edge(nodes[2], nodes[1], 3.0),
            new Edge(nodes[1], nodes[3], 1.0)
        };

        Graph graph = new Graph(nodes, edges); // Create graph from nodes and edges

        System.out.println(graph.toString()); // Display graph

        {
            GraphTraversalAlgorithm algorithm = new SmallerFirstAlgorithm(graph);
            System.out.println(algorithm.solve(nodes[0], nodes[1]));
            System.out.println(algorithm.solve(nodes[0], nodes[3]));
        }

        {
            GraphTraversalAlgorithm algorithm = new DijstraAlgorithm(graph);
            System.out.println(algorithm.solve(nodes[0], nodes[1]));
            System.out.println(algorithm.solve(nodes[0], nodes[3]));
        }
    }
}
