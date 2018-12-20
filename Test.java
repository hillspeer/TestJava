import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Test {

	public static enum Phase {START,END,PARSE,SERIES,EVENT,SYNCHRO};

	ExecutorService executor = Executors.newSingleThreadExecutor();
	
	static List<String> s = new ArrayList<String>();
	
	static String _ = new String();
	int a= 1,b=2;
	Main m = (a, b) -> 
		System.out.println(a);
	
	
	public static void main(String[] args) {


	Test t = new Test();
	try {
		Runnable one = ()->{
			s.add("one");
			System.out.println("one");
		};
		
		Runnable two = ()->{
			s.add("two");
			System.out.println("two");
		};
		
		for(int i=0;i<100000;i++) {
			t.getLogExecutorPool().submit(one);
			t.getLogExecutorPool().submit(two);
		}

		//t.registerShutdownhook();
		
		Object o = new String[] {};
		
		System.out.println(Phase.START.toString());
		
		Map<String,List<Integer>> NewCRIDMIList = new HashMap<String,List<Integer>>();

		NewCRIDMIList.put("a", new ArrayList<Integer>());
		
		NewCRIDMIList.get("a").add(1);
		
		System.out.println(NewCRIDMIList.get("a").size());
		NewCRIDMIList.put("b", new ArrayList<Integer>());
		NewCRIDMIList.get("b").add(4);
		NewCRIDMIList.get("b").add(5);
	
		System.gc();
		System.out.println(NewCRIDMIList.keySet().stream().mapToInt(seriesId->
				NewCRIDMIList.get(seriesId).size()).sum());
	}
	finally {
		//t.getLogExecutorPool().shutdown();
	}
	}
	
	private ExecutorService getLogExecutorPool() {

		if(executor.isShutdown()) {
			return Executors.newSingleThreadExecutor();
		}
		return executor;
	}
	
	 void registerShutdownhook(){
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				if(!executor.isShutdown())
					executor.shutdown();
			}
		});
	}
	 
	 interface Main{
		 void main(int i,int j);
	 }
}