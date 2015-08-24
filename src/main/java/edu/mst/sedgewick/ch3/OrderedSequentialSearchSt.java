package edu.mst.sedgewick.ch3;

import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.collect.Lists;

public class OrderedSequentialSearchSt<K extends Comparable<K>, V> implements SymbolTable<K, V> {

	private Node<K, V> head;

	class Node<K, V> {
		
		private K key;
		private V value;
		private Node<K, V> next;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public V get(K key) {
		Node<K, V> node = head;
		while (node != null) {
			if (node.key.equals(key)) {
				return node.value;
			}
			if (node.key.compareTo(key) > 0) {
				return null;
			}
			node = node.next;
		}
		return null;
	}

	public void put(K key, V val) {
		Node<K, V> insert = new Node(key, val);
		if (head == null) {
			head = insert;
			return;
		}
		Node<K, V> prev = null;
		Node<K, V> next = head;
		while (next.key.compareTo(key) < 0) {
			prev = next;
			next = next.next;
		}
		insert.next = next;
		prev.next = insert;
	}

	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}

	public boolean contains(K key) {
		Node<K, V> node = head;
		while (node != null) {
			if (node.key.equals(key)) {
				return true;
			}
			if (node.key.compareTo(key) > 0) {
				return false;
			}
			node = node.next;
		}
		return false;
	}

	public int size() {
		int count = 0;
		Node<K, V> node = head;
		while (node != null) {
			count ++;
			node = node.next;
		}
		return count;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Iterable<K> keys() {
		LinkedList<K> keys = Lists.newLinkedList();
		Node<K, V> node = head;
		while (node != null) {
			keys.add(node.key);
			node = node.next;
		}
		return keys;
	}

	public Iterator<K> iterator() {
		return keys().iterator();
	}

	public K min() {
		return head.key;
	}

	public K max() {
		// TODO Auto-generated method stub
		return null;
	}

	public K ceiling(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public K floor(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
