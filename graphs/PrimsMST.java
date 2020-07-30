import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsMST {

    private double wt;  
    private Queue<Edge> mst;
    private boolean[] marked;
    private PriorityQueue<Edge> pq;

    public PrimsMST(EdgeWeightedUGraph G) {
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new LinkedList<>();
        visit(G, 0);

        while (!pq.isEmpty() && mst.size() != G.V()-1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.offer(e);
            wt += e.weight();
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }

    }

    private void visit(EdgeWeightedUGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return wt;
    }
    
}