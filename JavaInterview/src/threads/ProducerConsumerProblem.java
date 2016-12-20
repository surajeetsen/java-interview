package threads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a simple implementation of the Producer Consumer Problem.
 * 
 * @author Surajeet Sen
 */
public class ProducerConsumerProblem {
	public static void main(String[] args) {
		final Queue<Integer> sharedQ = new LinkedList<Integer>();
		new MyProducer(sharedQ).start();
		new MyConsumer(sharedQ).start();
	}
}

class MyProducer extends Thread {
	final Queue<Integer> sharedQ;

	public MyProducer(Queue<Integer> sharedQ) {
		this.sharedQ = sharedQ;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized (sharedQ) {
				if (sharedQ.size() >= 1) {
					try {
						sharedQ.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Producing..." + i);
				sharedQ.add(i);
				sharedQ.notify();
			}
		}
	}
}

class MyConsumer extends Thread {
	final Queue<Integer> sharedQ;

	public MyConsumer(Queue<Integer> sharedQ) {
		this.sharedQ = sharedQ;
	}

	public void run() {
		while (true) {
			synchronized (sharedQ) {
				if (sharedQ.size() == 0) {
					try {
						sharedQ.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				int number = sharedQ.poll();
				System.out.println("Consuming..." + number);
				sharedQ.notify();

				if (number == 4) {
					break;
				}
			}
		}
	}
}
