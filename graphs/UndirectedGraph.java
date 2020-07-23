import java.util.Scanner;
import java.util.ArrayList;


public class UndirectedGraph {

    private int V;
    private int E;
    private ArrayList<Integer>[] lis;

    @SuppressWarnings("unchecked")
    public UndirectedGraph(int V) {
        lis = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            lis[i] = new ArrayList<>();
        }
    } 

    @SuppressWarnings("unchecked")
    public UndirectedGraph(Scanner scn) {
        V = scn.nextInt();
        E = scn.nextInt();
        lis = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            lis[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int v = scn.nextInt();
            int w = scn.nextInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        lis[v].add(w);
        lis[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return lis[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return 2*E;
    }
}