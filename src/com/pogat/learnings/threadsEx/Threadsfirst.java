package com.pogat.learnings.threadsEx;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Threadsfirst {
	public static void main1(String[] args) throws InterruptedException {
		// << output: Hello pool-1-thread-1
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		});// >>
		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted" + e);
			throw new InterruptedException();
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}
	}

	// passing Callable to the ExecutorService
	public static void main2(String[] args) throws Exception {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = future.get();

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);
	}

	// for scheduling threads
	public static void main3(String[] args) throws Exception {

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
		ScheduledFuture<?> future = executor.schedule(task, 7, TimeUnit.SECONDS);

		TimeUnit.MILLISECONDS.sleep(1337);

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms", remainingDelay);
	}

	// example for scheduleAtFixedRate delay scheduling the treads
	public static void main4(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

		int initialDelay = 0;
		int period = 3;
		executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

	}

	public static void main5(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Scheduling: " + System.nanoTime());
			} catch (InterruptedException e) {
				System.err.println("task interrupted");
			}
		};

		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
	}

	public static void main6(String[] args) {
		AtomicInteger atomicInt = new AtomicInteger(0);

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 999).forEach(i -> executor.submit(atomicInt::incrementAndGet));

		stop(executor);

		System.out.println(atomicInt.get());
	}

	public static void main(String[] args) {
		Threadsfirst tf = new Threadsfirst();
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// IntStream.range(0, 10000).forEach(i -> executor.submit(tf::increment));
		// //creates race condition
		IntStream.range(0, 10000).forEach(i -> executor.submit(tf::incrementSync));

		stop(executor);

		System.out.println(tf.count); // 9965 The reason is that we share a mutable variable upon different threads
										// without synchronizing the access to this variable which results in a race
										// condition.
	}

	// **********************************privated methods****************
	private static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	private static void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	private int count;

	private void increment() {
		count = count + 1;
	}

	synchronized void incrementSync() {
		count = count + 1;
	}
}