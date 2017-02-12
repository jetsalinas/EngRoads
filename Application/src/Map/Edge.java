package Map;

/**
 * Created by Jose Salinas on 2/12/2017.
 */
public class Edge {
    Vertex to;
    int weight;
    Edge nextEdge;

    public Edge(Vertex to, int weight, Edge nextEdge) {
        this.to = to;
        this.weight = weight;
        this.nextEdge = nextEdge;
    }

    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Edge getNextEdge() {
        return nextEdge;
    }

    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }
}
