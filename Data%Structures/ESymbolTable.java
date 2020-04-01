import java.util.Iterator;

/**
 * Elementary Symbol Table Implementation
 * It uses Associative Array Abstraction
 * Implies Associate one value with each key.
 * Best Practices: Use immutable types for Key.
 *
 * @param <Key> The generic Key datatype
 * @param <Value> The generic Value datatype and are "not null"
 */
public class ESymbolTable<Key extends Comparable<Key>, Value> {


    private int N; // size of the table
    private Key[] keys;
    private Value[] vals;

    public ESymbolTable(int N) {
        this.N = N;
        this.keys = new Key[N];
        this.vals = new Value[N];
    }

    /**
     *
     * Overwrites the old values if contains(key)
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        try {
            if (get(key) != null) vals[rank(key)] = value;
            else {
                for (int i = rank(key); i < size()-1; i++){
                    vals[i+1] = vals[i];
                }
                vals[rank(key)] = value;
            }
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Illegeal add! use Dynamic Array Implementations");
        }
    }

    /***
     *
     * @param key
     * @return Value at the key or null lest to prevent chaos
     */
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;

    }

    /**
     *
     * @param key
     */
    public void delete(Key key) {
        if (get(key) == null) System.out.println("Bad Element: Not Found");
        else {
            int rank = rank(key);
            for (int i = rank; i < size()-1; i++) {
                keys[i] = keys[i+1];
                vals[i] = vals[i+1];
                N--;
            }
        }
    }

    /**
     * Checks if there is a value corresponding to a key.
     *
     * @param key The key to be checked with.
     * @return True if there is a value else false.
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *
     * @return true if table is empty.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * @return the size of the table.
     */
    public int size() {
        return N;
    }

    /**
     *
     * @return
     */
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                int i = 0;
                return new Iterator<Key>() {
                    @Override
                    public boolean hasNext() {
                        return vals[i+1] == null;
                    }

                    @Override
                    public Key next() {
                        return keys[i];
                    }
                };
            }
        };
    }

    /**
     * Uses Binary search to return a key index or rank.
     *
     * @param key rank to be found for this.
     * @return The rank of the key
     */
    private int rank(Key key) {
        int lo = 0;
        int hi = N-1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0) return mid;
            else if (cmp < 0) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }


