/**
*@author Cradle Lee
*@describe this class is to generate all situation of seperate
*n software in m sets, where the set can be empty;
*@version 1.0
*/
class StatusSpace{
	int n = 0;
	int m = 0;
	// ini
	public  StatusSpace(n,m){
		this.n = n;
		this.m = m;
	}


	public int size(){
		// dpstir2[i][j] is to save the value of 
		// 2 second number of stirling at[i+1][j+1]
		if(this.n<=0||this.k<=0){
			System.out.println("This class has not been initialled rightly");
			return -1;
		}
		int[][] dpstir2 = new int[n+1][m+1];
		//===set 0 to dpstir2
		for(int i = 0;i<n+1;i++){
			Arrays.fill(dpstir2[i],0);
		}
		//===
		int ans = 0;
		for(int j = 1;j<=m;j++){
			if(0==dpstir2[n][j]){
				dpstir2[n][j] = nstir2k(n,j);
			}	
			ans+=dpstir2[n][j];
		}
		return ans;
		
	}
	//2 second number of stirling at[n][k]
	private int nstir2k(int n, int k){

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

			return  dpstir2(n-1,k-1)+k*dpstir2(n-1, k);
			
		}
	}

	public statusGenerate(){
		ArrayList<ArrayList<ArrayList<Integer>>> statusSpace
			= new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		
	}

}