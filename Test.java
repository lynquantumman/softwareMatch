
public class Test {
	public static void main(String[] args){
		int n = 5;
		int m = 3;
		StatusSpace statusSpace = new StatusSpace(n, m);
		int total = statusSpace.size();
//		statusSpace.statusGenerate(n, m);
		System.out.println(total);
		System.out.println(statusSpace.statusGenerate(n, m));
	}
}
