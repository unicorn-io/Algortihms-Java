import java.util.Stack;

public class DijkstrasSPT {
    
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    

    public DijkstrasSPT(EdgeWeightedDGraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while(!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }


    }   

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
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

        public int delMin() {
            int min = pq[1];
            exch(1, n--);
            sink(1);
            qp[min] = -1;
            pq[n+1] = -1;
            keys[min] = null;
            return min;
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