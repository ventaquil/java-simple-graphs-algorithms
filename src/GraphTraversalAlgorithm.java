import java.util.List;

public abstract class GraphTraversalAlgorithm {
    private Graph graph;

    public GraphTraversalAlgorithm(Graph graph)
    {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public abstract List<Edge> solve(Node from, Node to);
}
