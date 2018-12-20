import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class BlockingQueue {

	static java.util.concurrent.BlockingQueue l = new LinkedBlockingQueue(5);
	
	public static void main(String[] args) {

		
		Runnable r = ()-> {
			try{
				while(true) {
					
					System.out.println("take->"+l.take());
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		};
		
		Thread t = new Thread(r);
		
		t.start();
		
		IntStream it = IntStream.range(0, 100);
		
		it.forEach(action -> {
			try{
				long a =0l;
				System.out.println("put-start"+(a=System.currentTimeMillis()));
				l.put(action);
				System.out.println("put-end"+(System.currentTimeMillis()-a));
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		
	}
	
	

}
