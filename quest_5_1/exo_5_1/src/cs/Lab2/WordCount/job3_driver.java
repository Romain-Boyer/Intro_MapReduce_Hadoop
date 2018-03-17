package cs.Lab2.WordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;

public class job3_driver extends Configured implements Tool {
	
	// to put the data in hdfs when we are done
	private static final String OUTPUT_PATH = "3-tf-idf";
	
	// where to read the data from
	private static final String INPUT_PATH = "2-word-counts";
	
	public int run(String[] args) throws Exception{
		
		Configuration conf = getConf();
		Job job = new Job(conf, "Word in Corpus, TF-IDF");
		
		job.setJarByClass(job3_driver.class);
		job.setMapperClass(job3_mapper.class);
		job.setReducerClass(job3_reducer.class);
		
		FileInputFormat.addInputPath(job,  new Path(INPUT_PATH));
		FileOutputFormat.setOutputPath(job,  new Path(OUTPUT_PATH));
		
		// Getting the number of documents from the original input directory
		Path inputPath = new Path("input");
		FileSystem fs = inputPath.getFileSystem(conf);
		FileStatus[] stat = fs.listStatus(inputPath);
		
		job.setJobName(String.valueOf(stat.length));
		
		return job.waitForCompletion(true) ? 0 : 1;
		
	}
	
	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(),  new job3_driver(), args);
		System.exit(res);
	}
	
	
	
}
