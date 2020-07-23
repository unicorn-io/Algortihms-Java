public class UndirectedDFS {
    private int[] edgeTo;
    private boolean[] marked;

    public UndirectedDFS(UndirectedGraph G, int s) {
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(UndirectedGraph G, int s) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                edgeTo[w] = s;
                dfs(G, w);
            }
        }
    }

    public boolean isMarked(int v) {
        return marked[v];
    }

    public int edgeTo(int v) {
        return edgeTo[v];
    }
}