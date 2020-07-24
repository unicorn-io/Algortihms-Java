import java.util.ArrayList;
import java.util.Scanner;

public class DirectedGraph {
    
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;
    private int[] inDegree;
    private int[] outDegree;
    
    @SuppressWarnings("unchecked")
    public DirectedGraph(int V) {
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public DirectedGraph(Scanner scn) {
        V = scn.nextInt();
        E = scn.nextInt();
        
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int v = scn.nextInt();
            int w = scn.nextInt();
            addEdge(v, w);
            outDegree[v]++;
            inDegree[w]++;
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public int inDegree(int v) {
        return inDegree[v];
    }

    public int outDegree(int v) {
        return outDegree[v];
    }

    public int degree(int v) {
        return inDegree(v) + outDegree(v);
    }

    public DirectedGraph reverse() {
        DirectedGraph G = new DirectedGraph(this.V);
        for (int i = 0; i < V; i++) {
            for (int w : adj[i]) {
                G.addEdge(w, i);
            }
        }
        return G;
    }

}