import java.util.Stack;

public class Bipartite {

    private int[] edgeTo;
    private boolean[] marked;
    private boolean[] color;
    private Stack<Integer> stk;
    private boolean isBipartite;

    public Bipartite(UndirectedGraph G) {
        edgeTo = new int[G.V()];
        color = new boolean[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
        assert check(G);
    }

    public void dfs(UndirectedGraph G, int v) {
        marked[v] = true;

        for (int w : G.adj(v)) {

            if (stk != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(G, w);
            }

            if (color[v] == color[w]) {
                isBipartite = false;
                stk = new Stack<>();
                stk.push(w);
                for (int i = v; i != w; i = edgeTo[i]) {
                    stk.push(i);
                }
                stk.push(w);
            }
        }
    }
    
    public boolean check(UndirectedGraph G) {
        // graph is bipartite
        if (isBipartite) {
            for (int i = 0; i < G.V(); i++) {
                for (int w : G.adj(i)) {
                    if (color[i] == color[w]) {
                        System.out.printf("\nedge %d-%d with %d and %d are on the same side of the partition\n", i ,w, i, w);
                        return false;
                    }
                }
            }
        } else {
            int first = -1, last = -1;
            for (int v : stk) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.out.printf("\ncycle begins with %d and ends on %d\n", first, last);
                return false;
            }
        }

        return true;
    }
}