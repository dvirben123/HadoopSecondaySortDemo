import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class SimilarSitesGroupingComparator extends WritableComparator {
	
	public SimilarSitesGroupingComparator() {
		         super(SimilarSitesPair.class, true);
		}

	@Override
	
	    public int compare(WritableComparable wc1, WritableComparable wc2) {
		SimilarSitesPair pair = (SimilarSitesPair) wc1;
		SimilarSitesPair pair2 = (SimilarSitesPair) wc2;
	         return pair.getTagName().compareTo(pair2.getTagName());
	     }
	
}
