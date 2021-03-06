import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
*@author Cradle Lee
*@describe this class is to generate all situation of seperate
*n software in m sets, where the set can be empty;
*@version 1.0
*/
class StatusSpace implements Serializable{
	/**
	 * Serializable date 21:48 2016/12/6
	 */
	private static final long serialVersionUID = 3936478554325703379L;
	int n = 0;
	int m = 0;
	int[][] dpstir2;
	ArrayList<ArrayList<ArrayList<Integer>>> statusspace = null;
	// initial
	public  StatusSpace(int n, int m){
		this.n = n;
		this.m = m;
		dpstir2 = new int[n+1][m+1];
	}
	
	public boolean isEmpty(){
		return this.statusspace==null;
	}
	
	public void statusGenerate(){
		this.statusspace = statusGenerateRecursive(n,m);
	}
	
	public int size(){
		// dpstir2[i][j] is to save the value of 
		// 2 second number of stirling at(i,j)
		if(this.n<=0||this.m<=0){
			System.out.println("This class has not been initialled rightly");
			return -1;
		}
		
		//===set 0 to dpstir2
		for(int i = 0;i<n+1;i++){
			Arrays.fill(dpstir2[i],0);
		}
		//===this part means the box can be empty
//		int ans = 0;
//		for(int j = 1;j<=m;j++){
//			if(0==dpstir2[n][j]){
//				dpstir2[n][j] = nstir2k(n,j);
//			}	
//			ans+=dpstir2[n][j];
//			
//		}
//		return ans;
		//=======================================
		
		//===this part means the box can not be empty
		return nstir2k(n, m);
				
	}
	//2 second number of stirling at[n][k]
	public int nstir2k(int n, int k){

		if(n==k||k==1)
			return 1;
		else if (n<k) {
			return 0;
		}
		else{

			if(0==dpstir2[n-1][k-1]){
				dpstir2[n-1][k-1] = nstir2k(n-1,k-1);
			}
			if(0==dpstir2[n-1][k]){
				dpstir2[n-1][k] = nstir2k(n-1, k);
			}

			return  dpstir2[n-1][k-1]+k*dpstir2[n-1][k];
			
		}
	}

	private ArrayList<ArrayList<ArrayList<Integer>>> statusGenerateRecursive(int n,int k){
		ArrayList<ArrayList<ArrayList<Integer>>> statusSpaceLocal
			= new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		if(n==k){
			ArrayList<ArrayList<Integer>> status = new ArrayList<ArrayList<Integer>>();
			for(int i = 1;i<=k;i++){
				ArrayList<Integer> box = new ArrayList<Integer>();
				box.add(i);
				status.add(box);
			}
			statusSpaceLocal.add(status);
			return statusSpaceLocal;
		}
		else if(1==k){
			ArrayList<ArrayList<Integer>> status = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> box = new ArrayList<Integer>();
			for(int i = 1;i<=n;i++){
				box.add(i);
			}
			status.add(box);
			statusSpaceLocal.add(status);
			return statusSpaceLocal;
		}
		else if (n<k) {
			return statusSpaceLocal;
		}
		else{
			//===This part is to perform s(n-1,k-1)
			statusSpaceLocal .addAll(statusGenerateRecursive(n-1,k-1));
			for(ArrayList<ArrayList<Integer>> status:statusSpaceLocal){
				ArrayList<Integer> n_th = new ArrayList<Integer>();
				n_th.add(n);
				status.add(n_th);
			}
			//===
			//this part is to perform k*s(n-1,k)===	
			//===this is to generate a super space containing k status spaces				
			ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> superStatusSpace 
				= new ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>();
			for(int i = 0;i<k;i++){
				superStatusSpace.add(statusGenerateRecursive(n-1,k));
			}
			//===
			//===this is to add n into every status of different status space
			int i = 0;
			for(ArrayList<ArrayList<ArrayList<Integer>>> statusSpc:superStatusSpace){
				for(ArrayList<ArrayList<Integer>> i_status:statusSpc){
					i_status.get(i).add(n);
				}
				i++;
			}
			//===
			
			//the combination part
			ArrayList<ArrayList<ArrayList<Integer>>> statusSpcPart2 = new ArrayList<ArrayList<ArrayList<Integer>>>();
			for(ArrayList<ArrayList<ArrayList<Integer>>> statusSpc:superStatusSpace){
				
				statusSpcPart2.addAll(statusSpc);
				
			}
			statusSpaceLocal.addAll(statusSpcPart2);
			return statusSpaceLocal;
			
			
		}
		
//		对象的持久化存储
		
		
	}

	public static boolean writeObjectOfThis(StatusSpace objectOfThisClass, String addr){

		ObjectOutputStream out = null;
		try {
			 out = new ObjectOutputStream(
					new FileOutputStream(addr));
			out.writeObject(objectOfThisClass);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static StatusSpace readObjectOfThis(String addr){

		ObjectInputStream in = null;
		StatusSpace ObjectOfThis = null;
		try {
			in = new ObjectInputStream(new FileInputStream(addr));
			
			ObjectOfThis =  (StatusSpace)in.readObject();
			return ObjectOfThis;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			return null;
		} catch(ClassCastException cce){
			cce.printStackTrace();
			return null;
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public void deadLoop(){
		int i = 0;
		for(;;){
			i = i+1;
			i = i-1;
		}
	}
}