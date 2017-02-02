package controller;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Controller  {

	private BlockingQueue<Command> queue;
	private boolean stop=false;
	
	public Controller() {
		queue = new ArrayBlockingQueue<Command>(10);
	}
	
	public void start()
	{
		Thread thread = new Thread(new Runnable(){
			
			@Override
			public void run(){
				while(!stop) {
					try {

						Command cmd = queue.poll(1, TimeUnit.SECONDS);
						if(cmd != null)
								cmd.execute();
							} catch (InterruptedException | ClassNotFoundException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

				}
			}
		});
		thread.start();
	}
	
	public void stop()
	{
		stop = true;
	}

}
