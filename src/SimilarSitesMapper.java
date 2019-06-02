import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class SimilarSitesMapper extends Mapper<LongWritable, Text, SimilarSitesPair, Text>  {
	

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String inputLine = value.toString();		

		if (inputLine.contains(" ")) {
			
			String[] line = inputLine.split(" ");
			String websiteUrl = line[0].toLowerCase();
			String tagName = line[1].toLowerCase();
			
			SimilarSitesPair pair = new SimilarSitesPair(websiteUrl, tagName);
			Text website = new Text();
			website.set(websiteUrl);
			System.out.print("Website: " + website.toString() + " " + tagName);
			context.write(pair,website);
		}
	}
	

}
