package edu.mst.algo.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

abstract class BaseUnionFindTest {

	@Test
	public void testInitialization() throws Exception {
		UnionFind subject = createSubject(10);

		for (int i = 0; i < 10; i++) {
			assertEquals(i, subject.find(i));
		}
	}

	@Test
	public void testUnionFind() throws Exception {
		UnionFind subject = createSubject(10);

		for (int i = 0; i < 9; i++) {
			subject.union(i, 9);
			assertEquals(subject.find(i), subject.find(9));
		}
	}

	abstract UnionFind createSubject(int count);

}