package edu.mst.sedgewick.ch3;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.math.IntMath;

import sun.reflect.generics.tree.IntSignature;

public class ArraySt<K extends Comparable<K>, V> implements SymbolTable<K, V> {

	private K[] keys;
	private V[] values;
	private int currentSize;
	
	public static void main(String[] args) {
		
	}
	
	public ArraySt() {
		this.keys = (K[]) new Object[0];
		this.values = (V[]) new Object[0];
		this.currentSize = 0;
	}
	
	public V get(K key) {
		for (int i = 0; i < currentSize; i++) {
			if (keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}

	public void put(K key, V val) {
		if (currentSize == keys.length) {
			K[] newKeys = (K[]) new Object[IntMath.pow(2, currentSize)];
			System.arraycopy(keys, 0, newKeys, 0, keys.length);
			keys = newKeys;
			V[] newValues = (V[]) new Object[keys.length];
			System.arraycopy(values, 0, newValues, 0, values.length);
			values = newValues;
		}
		keys[currentSize] = key;
		values[currentSize] = val;
		currentSize ++;
	}

	public void delete(K key) {
		boolean found = false;
		for (int i = 0; i < currentSize; i++) {
			found = found || keys[i].equals(key);
			if (found) {
				keys[i] = null;
				values[i] = null;
				if (i < currentSize - 1) {
					keys[i] = keys[i + 1];
					values[i] = values[i + 1];
				}
			}
		}
	}

	public boolean contains(K key) {
		for (int i = 0; i < currentSize; i++) {
			if (keys[i].equals(key)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return currentSize;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public Iterable<K> keys() {
		return toIterable(keys);
	}

	private <T> Iterable<T> toIterable(T[] values) {
		List<T> list = Lists.newArrayListWithCapacity(currentSize);
		for (int i = 0; i < currentSize; i++) {
			list.add(values[i]);
		}		
		return list;
	}

	public Iterator<K> iterator() {
		return toIterable(keys).iterator();
	}

	public K min() {
		throw new UnsupportedOperationException();
	}

	public K max() {
		throw new UnsupportedOperationException();
	}

	public K ceiling(K key) {
		throw new UnsupportedOperationException();
	}

	public K floor(K key) {
		throw new UnsupportedOperationException();
	}

}
