import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskelsMST {
    
    private Queue<Edge> mst = new LinkedList<>();
    private double wt;

    public KruskelsMST(EdgeWeightedUGraph G) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (Edge e : G.edges()) {
            pq.add(e);
        }

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() != G.V()-1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.offer(e);
                wt += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return wt;
    }

    private class UF {

        private int[] id;
        private int[] sz;

        public UF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;
        }

        public int root(int i) {
            while (id[i] != i) {
                id[i] = id[id[i]];
                 i = id[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (sz[i] > sz[j]) {
                id[j] = i;
                sz[i] += sz[j];
            } else {
                id[i] = j;
                sz[j] += sz[i];
            }
        }
    }

}