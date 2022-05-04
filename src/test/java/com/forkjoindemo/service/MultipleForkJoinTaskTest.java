package com.forkjoindemo.service;

import com.forkjoindemo.model.ComplicatedObject;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;

public class MultipleForkJoinTaskTest {

	private static final ForkJoinPool POOL = new ForkJoinPool();

	@Test
	public void parallelTest() {
		POOL.execute(getCustomRecursiveAction());

		MyRecursiveTask customRecursiveTask = new MyRecursiveTask(
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10000000, 2, 3, 4, 5, 6, 7, 8, 9, 10, });
		int result = POOL.invoke(customRecursiveTask);
		System.out.println(result);
	}

	private MyRecursiveAction getCustomRecursiveAction() {
		ComplicatedObject obj1 = new ComplicatedObject("1mississippi");
		ComplicatedObject obj2 = new ComplicatedObject("2mississippi");
		ComplicatedObject obj3 = new ComplicatedObject("3mississippi");
		ComplicatedObject obj4 = new ComplicatedObject("4mississippi");
		MyRecursiveAction action = new MyRecursiveAction(new ComplicatedObject[] { obj1, obj2, obj3, obj4 });
		return action;
	}

}
