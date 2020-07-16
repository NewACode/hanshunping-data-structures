package com.atguigu.queue;

import java.util.Scanner;

public class CycleArrayQueueDemo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CycleArrayQueue cycleArrayQueue = new CycleArrayQueue(3);

		char key = ' ';
		boolean loop = true;

		while (loop) {
			System.out.println("s(show): ��ʾ����\te(exit): �˳�����\ta(add): ������ݵ�����\tg(get): �Ӷ���ȡ������\th(head): �鿴����ͷ������");

			key = scanner.next().charAt(0);

			switch (key) {
			case 's':
				cycleArrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("����һ����");

				try {
					int res = scanner.nextInt();
					cycleArrayQueue.addQueue(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'g':
				try {
					int res = cycleArrayQueue.getQueue();
					System.out.println(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = cycleArrayQueue.headQueue();
					System.out.println(res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				loop = false;
				break;
			default:
				break;
			}
		}

		scanner.close();
		System.out.println("�����˳�~~");
	}
}

class CycleArrayQueue {

	private int arrSize;

	private int front;

	private int rear;

	private int[] arr;

	public CycleArrayQueue (int queueSize) {
		arrSize = queueSize + 1;
		arr = new int[arrSize];

		front = rear = 0;
	}

	public boolean isFull () {
		return (rear + 1) % arrSize == front;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public void addQueue (int val) {
		if (isFull())
			throw new RuntimeException("queue is full");

		arr[rear] = val;

		rear = (rear + 1) % arrSize;
	}

	public int getQueue () {
		if (isEmpty())
			throw new RuntimeException("queue is empty");

		int value = arr[front];

		front = (front + 1) % arrSize;

		return value;
	}

	public void showQueue () {
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % arrSize, arr[i % arrSize]);
		}
	}

	public int size () {
		return (arrSize - front + rear) % arrSize;
	}

	public int headQueue () {
		if (isEmpty())
			throw new RuntimeException("queue is empty");

		return arr[front];
	}



}






























