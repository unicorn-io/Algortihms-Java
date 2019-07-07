/**
 * Naive approach to dynamic connectivity problem.
 */
public class QuickFindUF_slow {
    
    private int[] id; //initialized an array for N id's
	
    /**
     *             Contructor: Allots Initial Individual Values.
     *             To All the nodes.
     * 
     * @param N    The Number of Nodes.
     */
	public QuickFindUF_slow_(int N) {
        id = new int[N];
        //Set id of each object to itself(N array access)
		for (int i = 0; i < N; i++) {
			id[i] = i;
		} 
	
	}

    /**
     *             Checks If Two Given nodes are connected to EachOther.
     * 
     * @param p    The first node to be checked with the second.
     * @param q    The Secong node to be checked with the first. 
     * @return     True if first node is connected to second else false.
     */
	public boolean connected(int p, q) {
        return id[p] == id[q];
    }

    /**
     *             Unites/Connects Two Given Nodes.
     * 
     * @param p    The First Node.
     * @param q    The Second Node.
     */
	public void union(int p, int q) {
		int pid = id[p];
        int qid = id[q];
        // change all the entries form id[p] to id[q](almost 2N+2 array access)
		for (int i = 0; i < id.length; i++) {
			id[i] = id[i] == pid ? qid;
		}
	}
	
	//The time complexity in this scratch sheet sums up to a N^2 approach as there is (N,constant,N)
}	