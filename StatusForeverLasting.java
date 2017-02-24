import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class StatusForeverLasting {
	StatusSpace statusSpace;
	ObjectOutputStream obOut = null;
	public StatusForeverLasting(int n, int m){
		statusSpace = new StatusSpace(n,m);
		if(statusSpace.isEmpty()){
			statusSpace.statusGenerate();
		}
		else throw new RuntimeException();
			
		try {
			obOut = new ObjectOutputStream(
					new FileOutputStream("C:/Users/Administrator/Documents/softwareMatch/statusSpaceObject"));
			obOut.writeObject(statusSpace);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(null!=obOut){
				try {
					obOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
