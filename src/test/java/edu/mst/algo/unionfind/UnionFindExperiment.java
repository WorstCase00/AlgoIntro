package edu.mst.algo.unionfind;

import java.util.SplittableRandom;

public class UnionFindExperiment {

	private static final int N = 10000000;
	private static final int OPS = N * 2 * 2;

	private final static SplittableRandom RANDOM = new SplittableRandom(123456789L);
	private final static int[] OPERANDS = createOperands();
	private static final int RUNS = 5;

	private static int[] createOperands() {
		System.out.println("generate test data");
		int[] ops = new int[OPS];
		for (int i = 0; i < OPS; i++)
			ops[i] = RANDOM.nextInt(N);
		return ops;
	}

	public static void main(String... args) {
		System.out.println("start fast union finds");
		for (int i = 0; i < RUNS; i++)
			run(FastUnionFind.create(N));
		System.out.println("start trove4j impls");
		for (int i = 0; i < RUNS; i++)
			run(PathCompressionUnionFindTroveImpl.create(N));
		System.out.println("start JDK collection impls");
		for (int i = 0; i < RUNS; i++)
			run(PathCompressionUnionFindJdkCollectionImpl.create(N));
//		run(NaiveArrayUnionFind.create(N));
	}

	private static void run(UnionFind subject) {
		long runStartInstant = System.currentTimeMillis();
		for (int i = 0; i < OPS /2; i++) {
			int item1 = OPERANDS[2 * i];
			int c1 = subject.find(item1);
			int item2 = OPERANDS[2 * i + 1];
			int c2 = subject.find(item2);
			if (c1 != c2)
				subject.union(item1, item2);
		}
		System.out.println(System.currentTimeMillis() - runStartInstant);
	}
}
