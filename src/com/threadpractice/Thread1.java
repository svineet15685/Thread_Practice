package com.threadpractice;

class Thread1 {
	static int a = 10;
	static int b;
	
	public static void main(String []args) {
		
		System.out.println(Thread.currentThread().getName());
		
//		Runnable r1 = new Runnable() {
//		public void run() {
//			try {
//				Thread.sleep(10000L);
//				if(aaa == 10) {
//					aaa = aaa / 2;
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName());
//		}
//	};
		
		Runnable r1 = () -> {
			try {
				if(a == 10) {
					Thread.sleep(1000L);
					b = a / 2;
					System.out.println("b is " + b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		};

		Runnable r2 = new Runnable() {
			public void run() {
				a = 12;
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		Thread thread1 = new Thread(r1);
		synchronized (thread1) {
			thread1.start();
		}
		
		Thread thread2 = new Thread(r2);
		thread2.start();
	}
}