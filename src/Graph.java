import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Node, List<Edge>> edges;

    private Node[] nodes;

    public Graph(Node[] nodes, Edge[] edges) {
        this.nodes = createNodesArray(nodes, edges);

        this.edges = mapEdges(edges);
    }

    private Map<Node, List<Edge>> mapEdges(Edge[] edges) {
        Map<Node, List<Edge>> edgesMap = new HashMap<>(nodes.length);

        for (Edge edge : edges) {
            Node from = edge.getFrom();

            List<Edge> list = edgesMap.getOrDefault(from, new ArrayList<>());
            list.add(edge);

            edgesMap.put(from, list);
        }

        return edgesMap;
    }

    private Node[] createNodesArray(Node[] nodes, Edge[] edges) {
        List<Node> nodesList = Arrays.asList(nodes);

        for (Edge edge : edges) {
            if (!nodesList.contains(edge.getFrom())) {
                nodesList.add(edge.getFrom());
            }

            if (!nodesList.contains(edge.getTo())) {
                nodesList.add(edge.getTo());
            }
        }

        return nodesList.toArray(new Node[0]);
    }

    public Edge[] getEdges(Node from) {
        return edges.getOrDefault(from, new ArrayList<>()).toArray(new Edge[0]);
    }

    public Edge getEdge(Node from, Node to) {
        for (Edge edge : getEdges(from)) {
            if (edge.getTo() == to) {
                return edge;
            }
        }

        return null;
    }

    public Node getNode(int i) {
        return nodes[i];
    }

    public Node[] getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        int edgesLength = 0;

        String[] nodes = new String[this.nodes.length];
        for (int i = 0; i < this.nodes.length; ++i) {
            nodes[i] = this.nodes[i].toString();

            edgesLength += getEdges(this.nodes[i]).length;
        }

        String[] edges = new String[edgesLength];
        for (int i = 0, j = 0; i < this.nodes.length; ++i) {
            for (Edge anEdgesArray : getEdges(this.nodes[i])) {
                edges[j++] = anEdgesArray.toString();
            }
        }

        return String.format("Graph[nodes=%s,edges=%s]", String.join(", ", nodes), String.join(", ", edges));
    }
}
