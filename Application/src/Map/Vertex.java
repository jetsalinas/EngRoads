package Map;

/**
 * Created by Jose Salinas on 2/12/2017.
 */
public class Vertex {

    Vehicle vehicle;
    Edge edge;
    Vertex nextVertex;
    Vertex back;
    int distance;

    public Vertex(Vehicle vehicle, Edge edge, Vertex nextVertex, Vertex back, int distance) {
        this.vehicle = vehicle;
        this.edge = edge;
        this.nextVertex = nextVertex;
        this.back = back;
        this.distance = distance;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Vertex getNextVertex() {
        return nextVertex;
    }

    public void setNextVertex(Vertex nextVertex) {
        this.nextVertex = nextVertex;
    }

    public Vertex getBack() {
        return back;
    }

    public void setBack(Vertex back) {
        this.back = back;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
