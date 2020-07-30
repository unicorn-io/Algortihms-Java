import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedUGraph {
    
    private ArrayList<Edge>[] G;
    private ArrayList<Edge> edgeLis = new ArrayList<>();
    private int V;
    private int E;

    @SuppressWarnings("unchecked")
    public EdgeWeightedUGraph(int V) {
        G = (ArrayList<Edge>[]) new ArrayList[V];
        this.V = V;
    }

    @SuppressWarnings("unchecked")
    public EdgeWeightedUGraph(Scanner scn) {
        this.V = scn.nextInt();
        this.E = scn.nextInt();
        G = new ArrayList[this.V];
        for (int i = 0; i < E; i++) {
            int v = scn.nextInt();
            int w = scn.nextInt();
            double weight = scn.nextDouble();
            addEdge(v, w, weight);
            edgeLis.add(new Edge(v, w, weight));
        }
    }

    public void addEdge(int v, int w, double weight) {
        Edge e = new Edge(v-1, w-1, weight);
        G[v-1].add(e);
        G[w-1].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return G[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Edge> edges() {
        return edgeLis;
    }

}