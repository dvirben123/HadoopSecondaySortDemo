import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class SimilarSitesPartitioner extends Partitioner<SimilarSitesPair, Text> {

	@Override
	public int getPartition(SimilarSitesPair arg0, Text arg1, int arg2) {
		// TODO Auto-generated method stub
		return Math.abs( arg0.getTagName().hashCode() % arg2);
	}

}
