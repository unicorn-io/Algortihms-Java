public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(UndirectedGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(UndirectedGraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int getId(int v) {
        return id[v];
    }

}