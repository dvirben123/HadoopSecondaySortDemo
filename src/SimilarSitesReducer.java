import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;


public class SimilarSitesReducer extends Reducer<SimilarSitesPair, Text, SimilarSitesPair, IntWritable> {

	
	@Override
	public void reduce(SimilarSitesPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {		
		
		int count=0;
        
		 for(Text it:values)
	        {
			 	if(key.getWebsite() != it) {
			 		count++;
			 		key.setWebsite2(it);
			 		
			 	}	            	            	          
	        }
		 
		 
		 context.write(key, new IntWritable(count));
		 
		 System.out.print("Reducer " + key.getTagName() + " count:" + count);
		 
		
	}
	
}
