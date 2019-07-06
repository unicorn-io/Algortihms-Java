public class QuickFindUF_slow_{
	private int[] id;
	//initialized an array for N id's

	public QuickFindUF_slow_(int N){
		id = new int[N];
		for(int i = 0; i<N; i++){
			id[i] = i;
		} 
	//Set id of each object to itself(N array access)
	}

	public boolean connected(int p, q)
	{return id[p]==id[q];}
    //check wheather p and q are in the same component(2 array access) 

	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i<id.length; i++){
			id[i] = id[i]==pid?qid;
		}
	}
	// change all the entries form id[p] to id[q](almost 2N+2 array access)

	//The time complexity in this scratch sheet sums up to a N^2 approach as there is (N,constant,N)
}	