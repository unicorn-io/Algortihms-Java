public class QuickUnion_lazy{

	public int[] id;

	public QuickUnion_lazy(int N){
		id = new int[N];
		for(int i = 0; i<N; i++){
			id[i] = i;
		}
	} // set id  of each object to itself(N array access)

	private int root(int A){
		while(A != id[A]) A= id[A];
		return A; 
	} // chase parent pointers untill each root(depth of i array access)

	public boolean connected(int p, int q){
		return root(p)==root(q);
	} //check if p and q same root(depth of p and q array access)

	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		id[i] = j;
	} // change root of p to point to root of q(depth of p and q array access)

/**
*Trees can get too tall
*the worst case could be a N array access
*This quick-Union method is not good for large dynamic connectivity problems
*We use the weighted method to solve this issue demostrated in quickUnion.java
*And other methods are also adpted with the weighted method to attain efficiency.
*/

}