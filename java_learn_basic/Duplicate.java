
import java.util.ArrayList;
import java.util.List;

public class Duplicate {
	
	static int dupli(List<Integer> s) {
		int k=s.size()-1;System.out.println(k);
		int d=0;
		int total=sum(s);System.out.println(total);
		d=-total-k*(k+1/2);
		return d;
	}
	static int sum(List<Integer> ss) {
		int t=0;
		for(Integer i:ss) {
			t=t+i;
			
		}return t;
	}

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		l.add(1);
		l.add(2);l.add(3);l.add(4);l.add(5);l.add(5);
		System.out.println(dupli(l));
		
	}

}
