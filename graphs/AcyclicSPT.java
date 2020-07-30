import java.util.Stack;

public class AcyclicSPT { 
    
    private Stack<Integer> postOrd;
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] marked;

    public AcyclicSPT(EdgeWeightedDGraph G, int s) {
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
        initializeDist(distTo, s);
        for (int k : postOrd) {
            for (DirectedEdge e : G.adj(k)) {
                relax(e);
            }
        }
    }

    private void dfs(EdgeWeightedDGraph G, int v) {
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            if (!marked[e.to()]) dfs(G, e.to());
        }
        postOrd.push(v);
    }

    private void initializeDist(double[] arr, int s) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.POSITIVE_INFINITY;
        }
        arr[s] = 0;
    }

    private void relax(DirectedEdge e) {
        int v = e.from(); int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

}