import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijstraAlgorithm extends GraphTraversalAlgorithm {
    public DijstraAlgorithm(Graph graph) {
        super(graph);
    }

    @Override
    public List<Edge> solve(Node from, Node to) {
        Graph graph = getGraph();

        List<Node> unvisited = new ArrayList<>();
        Map<Node, Double> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        for (Node node : graph.getNodes()) {
            unvisited.add(node);
            distances.put(node, Double.POSITIVE_INFINITY);
        }

        distances.put(from, 0.0);

        while (unvisited.size() > 0) {
            Node current = null;
            for (Node node : unvisited) {
                if ((current == null) || (distances.get(node) < distances.get(current))) {
                    current = node;
                }
            }

            unvisited.remove(current);

            for (Edge edge : graph.getEdges(current)) {
                double distance = distances.get(current) + edge.getDistance();
                Node next = edge.getTo();

                if (distance < distances.get(next)) {
                    distances.put(next, distance);
                    previous.put(next, current);
                }
            }
        }

        List<Edge> path = new ArrayList<>();
        Node current = to;
        while (current != from) {
            Node prev = previous.get(current);
            path.add(graph.getEdge(prev, current));
            current = prev;
        }

        Collections.reverse(path);

        return path;
    }
}
