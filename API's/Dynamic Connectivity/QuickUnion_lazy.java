/**
 * Next Better Approach of Solving Dynamic Connectivity after Naive Solution.
 */
public class QuickUnion_lazy {

	public int[] id;

    /**
     *             Constructor: Initializes Individual values to all Nodes.
     * 
     * @param N    The number of nodes in the dataSet.
     */
	public QuickUnion_lazy(int N) {
        id = new int[N];
        // set id  of each object to itself(N array access)
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	} 
 
    /**
     *             Returns the parent of an key.
     *       
     * @param A    The Daughter Key.
     * @return     The parent key of the given daughter key.
     */
	private int root(int A) {
        // chase parent pointers untill each root(depth of i array access)
		while (A != id[A]) A = id[A];
		return A; 
	} 

    /**
     *             Checks if nodes two nodes are connected by checking thier parents.
     * 
     * @param p    The first Node.
     * @param q    The Second Node.
     * @return     True if the given nodes are connected else False.
     */
	public boolean connected(int p, int q) {
        //check if p and q same root(depth of p and q array access)
		return root(p) == root(q);
	} 

    /**
     *             Connects two given nodes by connecting thier parents.
     * 
     * @param p    The First Node.
     * @param q    The Second Node.
     */
	public void union(int p, int q) {
		int i = root(p);
        int j = root(q);
        // change root of p to point to root of q(depth of p and q array access).
		id[i] = j;
	} 

    /**
    *Trees can get too tall
    *the worst case could be a N array access
    *This quick-Union method is not good for large dynamic connectivity problems
    *We use the weighted method to solve this issue demostrated in quickUnion.java
    *And other methods are also adpted with the weighted method to attain efficiency.
    */
}