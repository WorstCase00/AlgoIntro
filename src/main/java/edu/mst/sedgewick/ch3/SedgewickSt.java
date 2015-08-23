package edu.mst.sedgewick.ch3;

/*************************************************************************
 *  Compilation:  javac ST.java
 *  Execution:    java ST
 *  
 *  Sorted symbol table implementation using a java.util.TreeMap.
 *  Does not allow duplicates.
 *
 *  % java ST
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 *  The <tt>ST</tt> class represents an ordered symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides ordered methods for finding the <em>minimum</em>,
 *  <em>maximum</em>, <em>floor</em>, and <em>ceiling</em>.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be <tt>null</tt>&mdash;setting the
 *  value associated with a key to <tt>null</tt> is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses a balanced binary search tree. It requires that
 *  the key type implements the <tt>Comparable</tt> interface and calls the
 *  <tt>compareTo()</tt> and method to compare two keys. It does not call either
 *  <tt>equals()</tt> or <tt>hashCode()</tt>.
 *  The <em>put</em>, <em>contains</em>, <em>remove</em>, <em>minimum</em>,
 *  <em>maximum</em>, <em>ceiling</em>, and <em>floor</em> operations each take
 *  logarithmic time in the worst case.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/35applications">Section 3.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class SedgewickSt<Key extends Comparable<Key>, Value> implements Iterable<Key>, SymbolTable<Key, Value> {

    private TreeMap<Key, Value> st;

    /**
     * Initializes an empty symbol table.
     */
    public SedgewickSt() {
        st = new TreeMap<Key, Value>();
    }


    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#get(Key)
	 */
    public Value get(Key key) {
        if (key == null) throw new NullPointerException("called get() with null key");
        return st.get(key);
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#put(Key, Value)
	 */
    public void put(Key key, Value val) {
        if (key == null) throw new NullPointerException("called put() with null key");
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#delete(Key)
	 */
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("called delete() with null key");
        st.remove(key);
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#contains(Key)
	 */
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("called contains() with null key");
        return st.containsKey(key);
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#size()
	 */
    public int size() {
        return st.size();
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#isEmpty()
	 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#keys()
	 */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#iterator()
	 */
    @Deprecated
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#min()
	 */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return st.firstKey();
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#max()
	 */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return st.lastKey();
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#ceiling(Key)
	 */
    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("called ceiling() with null key");
        Key k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /* (non-Javadoc)
	 * @see edu.mst.sedgewick.ch3.SymbolTable#floor(Key)
	 */
    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("called floor() with null key");
        Key k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }

    /**
     * Unit tests the <tt>ST</tt> data type.
     */
    public static void main(String[] args) {
    	SymbolTable<String, Integer> st = new SedgewickSt<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
