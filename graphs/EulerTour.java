import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class EulerTour {
    private Stack<Integer> cycle;

    private class Edge {

        private int v;
        private int w;
        public boolean isUsed;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;    
            isUsed = false;
        }

        public int other(int vertex) {
            if (vertex == v) return w;
            else if (vertex == w) return v;
            return -1;
        }
    }

    @SuppressWarnings("unchecked")
    public EulerTour(UndirectedGraph G) {
        if (G.E() == 0) return;

        for (int v = 0; v < G.V(); v++) {
            if (G.degree(v) % 2 != 0) {
                return;
            }
        }

        Queue<Edge>[] adj = (Queue<Edge>[]) new LinkedList[G.V()];
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                Edge edge = new Edge(v, w);
                adj[v].offer(edge);
                adj[w].offer(edge);
            }
        }

        int s = -1;
        for (int v = 0; v < G.V(); v++) {
            if (G.degree(v) > 0) {
                s = v;
                return;
            }
        }
        
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(s);

        cycle = new Stack<Integer>();
        while (!stk.isEmpty()) {
            int v = stk.pop();
            while (!adj[v].isEmpty()) {
                Edge edge = adj[v].poll();
                if (edge.isUsed) continue;
                edge.isUsed = true;
                stk.push(v);
                v = edge.other(v);
            }
            cycle.push(v);
        }
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
    
}   