import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedDGraph {

    private int V;
    private int E;
    private ArrayList<DirectedEdge>[] adj;
    private ArrayList<DirectedEdge> edgeLis;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDGraph(int V) {
        this.V = V;
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public EdgeWeightedDGraph(Scanner scn) {
        this.V = scn.nextInt();
        this.E = scn.nextInt();
        adj = (ArrayList<DirectedEdge>[]) new ArrayList[V];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < this.E; i++) {
            addEdge(scn.nextInt(), scn.nextInt(), scn.nextDouble());
        }
    }

    public void addEdge(int v, int w, double weight) {
        DirectedEdge d = new DirectedEdge(v, w, weight);
        adj[v].add(d);
        edgeLis.add(d);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        return edgeLis;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
    
}