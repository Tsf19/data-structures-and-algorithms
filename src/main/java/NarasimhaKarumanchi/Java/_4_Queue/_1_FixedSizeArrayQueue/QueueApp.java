package NarasimhaKarumanchi.Java._4_Queue._1_FixedSizeArrayQueue;

public class QueueApp {

	public static void main(String[] args) {
		
		QueueServiceImpl queue = new QueueServiceImpl(5);
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		System.out.println(queue.toString());
		queue.deQueue();
		queue.deQueue();
		System.out.println(queue.toString());
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		queue.enQueue(70);
		System.out.println(queue.toString());
		queue.deQueue();
		queue.deQueue();
		System.out.println(queue.toString());
		queue.enQueue(80);
		System.out.println(queue.toString());
		queue.enQueue(90);
		System.out.println(queue.toString());
	}

}
