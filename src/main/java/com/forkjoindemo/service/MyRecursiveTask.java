package com.forkjoindemo.service;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {

	private int[] arr;

	private static final int THRESHOLD = 4;

	public MyRecursiveTask(int[] arr) {
		this.arr = arr;
	}

	@SneakyThrows @Override
	protected Integer compute() {
		if (arr.length > THRESHOLD) {
			return ForkJoinTask.invokeAll(createSubtasks())
					.stream()
					.mapToInt(ForkJoinTask::join)
					.sum();
		} else {
			return processing(arr);
		}
	}

	private Collection<MyRecursiveTask> createSubtasks() {
		List<MyRecursiveTask> dividedTasks = new ArrayList<>();
		dividedTasks.add(new MyRecursiveTask(
				Arrays.copyOfRange(arr, 0, arr.length / 2)));
		dividedTasks.add(new MyRecursiveTask(
				Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
		return dividedTasks;
	}

	private Integer processing(int[] arr) throws InterruptedException {
		int sum = 0;
		for (int i : arr)
			sum += i;
		Thread.sleep(2000);
		System.out.println("This  was processed by "
				+ Thread.currentThread().getName()+ ". sum: "+sum);
		return sum;
	}
}
