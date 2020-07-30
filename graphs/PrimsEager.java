import java.util.Queue;
import java.util.LinkedList;

public class PrimsEager {

    private Queue<Edge> mst;
    private IndexMinPQ<Edge> pq;
    private boolean[] marked;
    private double[] distTo;

    public PrimsEager(EdgeWeightedUGraph G) {
        pq = new IndexMinPQ<>(G.V());
        mst = new LinkedList<>();
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY; 
        }
        visit(G, 0);
        
        while (!pq.isEmpty() && mst.size() != G.V()-1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.offer(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);

        }


    }

    private void visit(EdgeWeightedUGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                if (distTo[e.other(v)] < distTo[v]) {
                    if (!pq.contains(e.other(v))) pq.insert(e.other(v), e);
                    else pq.decreaseKey(e.other(v), e);
                } 
                
            }
        }
    }



    private class IndexMinPQ<Key extends Comparable<Key>> {

        private Key[] keys;
        private int[] pq;
        private int[] qp;
        private int n;

        @SuppressWarnings("unchecked")
        public IndexMinPQ(int N) {
            keys = (Key[]) new Comparable[N+1];
            pq = new int[N+1];
            qp = new int[N+1];
            for (int i = 0; i < N; i++) {
                qp[i] = -1;
            }
        }

        public void insert(int i, Key key) {
            n++;
            qp[i] = n;
            pq[n] = i;
            keys[n] = key;
            swim(n); 
        }

        private void swim(int k) {
            while(k > 1 && greater(k/2, k)) {
                exch(k, k/2);
                k /= 2;
            }
        }

        private void sink(int i) {
            while (i*2 <= n) {
                int j = 2*i;
                if (j < n && greater(i, j)) j++;
                if (!greater(i, j)) break;
                exch(i, j);
                i = j;
            }
        }

        private void exch(int i, int j) {
             int tmp = pq[i];
             pq[i] = pq[j];
             pq[j] = tmp;
             qp[pq[i]] = i;
             qp[pq[j]] = j;
        }

        public Key delMin() {
            int min = pq[1];
            Key kMin = keys[min];
            exch(1, n--);
            sink(1);
            qp[min] = -1;
            pq[n+1] = -1;
            keys[min] = null;
            return kMin;
        }

        private boolean greater(int i, int j) {
            return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
        }

        public boolean contains(int i) {
            return  qp[i] != -1;
        }

        public void decreaseKey(int i, Key key) {
            keys[i] = key;
            swim(qp[i]);
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
}