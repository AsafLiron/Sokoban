package controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class Controller implements Observer  {

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
						{
								try {
									cmd.execute();
								} catch (URISyntaxException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
						}
							} catch (InterruptedException | ClassNotFoundException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

				}
			}
		});
		thread.start();
	}
	
	public void update(Observable o, Object arg) {;}
	
	public void stop()
	{
		stop = true;
	}
	
	public BlockingQueue<Command> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<Command> queue) {
		this.queue = queue;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void addToQueue(Command c) throws InterruptedException
	{
		this.queue.put(c);
	}

}
