import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;


public class SimilarSitesPair implements Writable, WritableComparable<SimilarSitesPair> {

	public SimilarSitesPair()
	{
		
	}
	
	public SimilarSitesPair(String website, String tagName) { 
		this.website.set(website);
		this.tagName.set(tagName);
		
	}
	
	private Text website = new Text();
	private Text website2 = new Text();
	
	private Text tagName = new Text();
	
	@Override
	public String toString(){
		return this.website + " " + this.website2 + " " + this.tagName;
	}
	
	@Override
	public int compareTo(SimilarSitesPair o) {
		return o.tagName.compareTo(this.tagName);		
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		tagName.readFields(arg0);
		website.readFields(arg0);
		
	}
	
	public Text getTagName() { 
		return tagName;
	}
	
	public Text getWebsite() { 
		return website;
	}
	
	public void setWebsite2(Text website) {
		this.website2 =website;
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		tagName.write(arg0);
		website.write(arg0);
		
	}

}
