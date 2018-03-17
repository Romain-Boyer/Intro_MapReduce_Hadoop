package cs.Lab2.WordCount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class job2_mapper extends Mapper<LongWritable, Text, Text, Text> {
	public job2_mapper(){
		
	}
	
	/*
	 * @param key is the byte offset of the current line in the file
	 * @param value is the line from the file
	 * @param context
	 * 
	 * 		pre condition : aa@text1.txt 14
	 * 						ab@text2 42
	 * 		post condiction : output <"text1", "aa=14"> pairs
	 */
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] wordAndDocCounter = value.toString().split("\\t");
		String[] wordAndDoc = wordAndDocCounter[0].split("@");
		context.write(new Text(wordAndDoc[1]), new Text(wordAndDoc[0] + "=" + wordAndDocCounter[1]));
	}
	
}
