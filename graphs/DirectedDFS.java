import java.util.Stack;

public class DirectedDFS {

    private int[] edgeTo;
    private boolean[] marked;
    
    public DirectedDFS(DirectedGraph G, int s) {
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(DirectedGraph G, int v) {
        Stack<Integer> stk = new Stack<>();
        stk.push(v);

        while (!stk.isEmpty()) {
            int tmp = stk.pop();
            for (int w : G.adj(tmp)) {
                if (!marked[w]) {
                    marked[w] = true;
                    stk.push(w);
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean isMarked(int v) {
        return marked[v];
    }

    public int edgeTo(int v) {
        return edgeTo(v);
    }
    
}