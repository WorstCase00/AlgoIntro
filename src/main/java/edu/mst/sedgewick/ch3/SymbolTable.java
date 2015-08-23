package edu.mst.sedgewick.ch3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface SymbolTable<Key extends Comparable<Key>, Value> {

	/**
	 * Returns the value associated with the given key.
	 * @param key the key
	 * @return the value associated with the given key if the key is in the symbol table
	 *     and <tt>null</tt> if the key is not in the symbol table
	 * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	 */
	Value get(Key key);

	/**
	 * Inserts the key-value pair into the symbol table, overwriting the old value
	 * with the new value if the key is already in the symbol table.
	 * If the value is <tt>null</tt>, this effectively deletes the key from the symbol table.
	 * @param key the key
	 * @param val the value
	 * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	 */
	void put(Key key, Value val);

	/**
	 * Removes the key and associated value from the symbol table
	 * (if the key is in the symbol table).
	 * @param key the key
	 * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	 */
	void delete(Key key);

	/**
	 * Does this symbol table contain the given key?
	 * @param key the key
	 * @return <tt>true</tt> if this symbol table contains <tt>key</tt> and
	 *     <tt>false</tt> otherwise
	 * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	 */
	boolean contains(Key key);

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 * @return the number of key-value pairs in this symbol table
	 */
	int size();

	/**
	 * Is this symbol table empty?
	 * @return <tt>true</tt> if this symbol table is empty and <tt>false</tt> otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns all keys in the symbol table as an <tt>Iterable</tt>.
	 * To iterate over all of the keys in the symbol table named <tt>st</tt>,
	 * use the foreach notation: <tt>for (Key key : st.keys())</tt>.
	 * @return all keys in the sybol table as an <tt>Iterable</tt>
	 */
	Iterable<Key> keys();

	/**
	 * Returns all of the keys in the symbol table as an iterator.
	 * To iterate over all of the keys in a symbol table named <tt>st</tt>, use the
	 * foreach notation: <tt>for (Key key : st)</tt>.
	 * @deprecated Use {@link #keys} instead.
	 * This method is provided for backward compatibility with the version from
	 * <em>Introduction to Programming in Java: An Interdisciplinary Approach.</em>
	 * @return an iterator to all of the keys in the symbol table
	 */
	Iterator<Key> iterator();

	/**
	 * Returns the smallest key in the symbol table.
	 * @return the smallest key in the symbol table
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	Key min();

	/**
	 * Returns the largest key in the symbol table.
	 * @return the largest key in the symbol table
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	Key max();

	/**
	 * Returns the smallest key in the symbol table greater than or equal to <tt>key</tt>.
	 * @return the smallest key in the symbol table greater than or equal to <tt>key</tt>
	 * @param key the key
	 * @throws NoSuchElementException if there is no such key
	 * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	 */
	Key ceiling(Key key);

	/**
	 * Returns the largest key in the symbol table less than or equal to <tt>key</tt>.
	 * @return the largest key in the symbol table less than or equal to <tt>key</tt>
	 * @param key the key
	 * @throws NoSuchElementException if there is no such key
	 * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	 */
	Key floor(Key key);

}