// IMPROVED METHOD DESCRIPTION AFTER THE SOURCE CODE;
//following is the implementation of the WQUPC METHOD
//For detailed information please check the slides provided.

public class WeightedQuickUnionUF{
	private int[] id;
	public int[] sz;

	public WeightedQuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
		for(int i = 0; i<N; i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	//same as QuickUnion_lazy.java..but here sz array is extra that will
	//count the size of the tree at that particular node.

	public root(int i){
		while(i != id[i]){
			id[i] = id[id[i]];    //this extra piece of code enables path compression for more see, page 38 in the slides.
			i = id[i];
		}
	}
	//key to find the root of a given integer in the array.

	public boolean connected(int p, int q){
		return root(p)==root(q);
	}
	//same as QuinkUnion_lazy.java

	public void union(int p, int q){
		int a = root(p);
		int b = root(q);
		if(sz[a]>sz[b]){     //This line checks the size of the tree
			id[b] = a;       //it ensures that small tree is added to the bigger.
			sz[a] += sz[b];
		}
		else{
			id[a] = b;
			sz[b] += sz[a];
		}
		//Union method here follow that weighted method


	}


}

/**
IMPROVEMENT_1{
	*-------------WEIGHTED QUICK UNION-------------------
*Modify Quick union to avoid tall trees
*keep track of size of each tree(number of objects)
*Balance by linking to root of smaller tree to the larger tree
*In literal sense consider two roots 'a' and 'b' being a < b 
 we link a to b "but not" b to a as a is small.


IDEA:

DATA STRUCTURE: Same as quick-Union, but maintaion exra array sz[i] to count
number of objects in the tree rooted at i.

Find: Identical to QuickUnion_lazy.java

Union: Modify quick-union to
	*Link root of smaller tree to root of larger tree
	*Updte the sz[] array.


WEIGHTED QUICK UNION analysis 
Running Time,
	*Find: takes time propostional to depth of p and q.
	*Union: takes constant time, given roots.

Proposition: Depth of any node x is at most Lg(N)
Proof: When does depth of x Increase?
A: Increases by 1 when tree T1 containing x is merged into another tree T2.
	*The size of the tree containing x at least doubles since |T2| >= |T1|.
	*Size if tree containing x can double at most Lg(n) times.	
}

Improvement_2{--Path Compression--

QUICK UNION with Path Compression: Just after computing the root of p,
set the id of each examined node to point to that root.

Proposition.  [Hopcroft-Ulman, Tarjan]  Starting from an empty data structure, 
any sequence of M union-find ops on N objects makes ≤  c ( N + M lg* N ) array 
accesses. ・Analysis can be improved to N + M α(M, N). ・Simple algorithm with 
ascinating mathematics.

O(n) in this case is lg*(n) which is called iterative logarithm.

Iterative logarithm: In computer science, the iterated logarithm of n, written log* n (usually read "log star"), is the number of times the logarithm function must be iteratively applied before the result is less than or equal to 1.
} 
*/
