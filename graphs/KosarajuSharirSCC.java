public class KosarajuSharirSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSharirSCC(DirectedGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        TopologicalSort revSort = new TopologicalSort(G.reverse());
        for (int v : revSort.reversePost()) {
            if(!marked[v])  {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(DirectedGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            id[v] = count;
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean StronglyConnected(int v, int w) {
        return id[v] == id[w];
    }
}