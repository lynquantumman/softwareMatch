import java.util.ArrayList;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

/**
*@author Cradle Lee
*@describe This is the Map part of the map reduce structure
*/
public class SoftwareMatchMapper 
	extends Mapper<LongWritable, ArrayList<ArrayList<ArrayList<Integer>>>, LongWritable, LongWritable>{
	//the generic types describes the input key, input value
	// output key, output value type
	@Override
	public void map(LongWritable number, ArrayList<ArrayList<ArrayList<Integer>>> matchSite,Context context){

	}
//	the write function needs a key and a value
//	the context is an object of org.apache.hadoop.mapreduce.Mapper.Context
	context.write();
}