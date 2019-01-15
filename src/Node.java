public class Node {
    private static int counter = 0;

    private int id;

    public Node()
    {
        id = counter++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Node[id=%d]", getId());
    }
}
