import java.util.ArrayList;
import java.util.List;

public class Type {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num = new ArrayList<>();
		Integer n = new Integer(1);
		num.add(n);
		addToList(num, n);

	}


	static void addToList(List<? extends Number> l, Integer n){
		System.out.println(l);		
	}
}
