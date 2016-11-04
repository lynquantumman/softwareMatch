import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer
	extends Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
	throws IOException, InterruptedException{
		int maxValue = Integer.MIN-VALUE;
		for(IntWritable value:values){
			maxValue = Math.max(maxValue,value.get());
		}
		context.write(new Text(key), new IntWritable(maxValue));
	}
}