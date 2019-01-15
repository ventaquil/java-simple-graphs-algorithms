public class Edge {
    private double distance;

    private Node from;

    private Node to;

    public Edge(Node from, Node to, double distance) {
        this.from = from;

        this.to = to;

        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    @Override
    public String toString() {
        return String.format("Edge[from=%s,to=%s,distance=%f]", getFrom().toString(), getTo().toString(), getDistance());
    }
}
