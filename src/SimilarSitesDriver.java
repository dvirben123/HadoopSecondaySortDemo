import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class SimilarSitesDriver extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {
		
		String input, output;
		if (arg0.length == 2) {
			input = arg0[0];
			output = arg0[1];
		} else {
			System.err.println("Incorrect number of arguments.  Expected: input output");
			return -1;
		}
		
		Job job = new Job(getConf());
		job.setJarByClass(SimilarSitesDriver.class);
		job.setJobName(this.getClass().getName());
		
		FileInputFormat.setInputPaths(job, new Path(input));
		FileOutputFormat.setOutputPath(job, new Path(output));
		
		 job.setOutputKeyClass(SimilarSitesPair.class);		 
		
		job.setMapperClass(SimilarSitesMapper.class);
		job.setReducerClass(SimilarSitesReducer.class);
		
		 job.setPartitionerClass(SimilarSitesPartitioner.class);
		 job.setGroupingComparatorClass(SimilarSitesGroupingComparator.class);
		
		
		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		SimilarSitesDriver driver = new SimilarSitesDriver();
		int exitCode = ToolRunner.run(driver, args);
		System.exit(exitCode);
	}

}
