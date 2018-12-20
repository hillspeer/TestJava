import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class WorkStealingPool {

	static ExecutorService pool = Executors.newWorkStealingPool(4);
	
	public static void main(String[] args)throws Exception {

		int i=0;
		List<Integer> l = new ArrayList<Integer>();
		
		IntStream.range(0, 1).forEach(action -> System.out.println(action));
		
/*		IntStream.range(1, 100).forEach(action->{
			pool.submit(
					()->{
						System.out.println(action);
					}
					);
		});*/
		Thread.sleep(10000);

	}

}
