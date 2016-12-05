import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class MaxTemperatureMapper
	extends Mapper<LongWritable, Text, Text, IntWritable>{
	// the instance of Context may throw IOException and InterruptedException
	@Override
	public void map(LongWritable key, Text value, Context context)
	throws IOException, InterruptedException	
	{	
		final int MISSING = 9999;
		String line = value.toString();
		String year = line.substring(15,19);
		int airTemperature = 0;
		if(line.charAt(87)=='+'){//parseInt doesn't like leading with plus signs
			airTemperature = Integer.parseInt(line.substring(88,92));
		}
		else{
			airTemperature = Integer.parseInt(line.substring(87,92));
		}
		String quality = line.substring(92,93);
		if(airTemperature!=MISSING && quality.matches("[01459]")){
			context.write(new Text(year), new IntWritable(airTemperature));
		}
	}
}
