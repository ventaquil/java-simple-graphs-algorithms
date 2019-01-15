import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SmallerFirstAlgorithm extends GraphTraversalAlgorithm {
    public SmallerFirstAlgorithm(Graph graph) {
        super(graph);
    }

    @Override
    public List<Edge> solve(Node from, Node to) {
        Graph graph = getGraph();

        List<Node> visited = new ArrayList<>();

        Edge solution = null;

        Node current = from;

        List<Edge> path = new ArrayList<>();

        while ((solution == null) && (current != null)) {
            visited.add(current);

            Edge[] edges = graph.getEdges(current);

            List<Edge> candidates = new ArrayList<>();
            for (Edge edge : edges) {
                if (edge.getTo() == to) {
                    candidates.add(edge);
                }
            }

            if (candidates.size() > 0) {
                for (Edge candidate : candidates) {
                    if ((solution == null) || (solution.getDistance() > candidate.getDistance())) {
                        solution = candidate;
                    }
                }

                path.add(solution);
            } else {
                Edge next = null;

                for (Edge candidate : edges) {
                    if ((next == null) || ((next.getDistance() > candidate.getDistance()) && !visited.contains(candidate.getTo()))) {
                        next = candidate;
                    }
                }

                if (next == null) {
                    current = null;
                } else {
                    path.add(next);

                    current = Objects.requireNonNull(next).getTo();
                }
            }
        }

        if (solution == null) {
            path = new ArrayList<>();
        }

        return path;
    }
}
