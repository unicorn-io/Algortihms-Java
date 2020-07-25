import java.util.Stack;

public class TopologicalSort {
    
    private boolean[] marked;
    private Stack<Integer> reversePostOrder;

    public TopologicalSort(DirectedGraph G) {
        marked = new boolean[G.V()];
        reversePostOrder = new Stack<>();
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i);
        }
    }

    private void dfs(DirectedGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        reversePostOrder.push(v);
    }

    public Iterable<Integer> reversePost() {
        return reversePostOrder;
    }

}