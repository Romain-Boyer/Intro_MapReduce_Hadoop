package cs.Lab2.WordCount;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;


public class job1_mapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	public job1_mapper(){
	}

	/*
	 * @param key : is the byte offset of the current line in the file
	 * @param value value : is the line from the file
	 * @param output : has the method collect() to output the key, value pair
	 * @param reporter : allows us to retrieve some information about the job (like the current filename)
	 */

	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{

		
			String line = value.toString();
			String[] words = line.split(" ");
			
			// Get the name of the file from inputsplit in the context
			String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
			
			for(String word: words)
			{
				
				if (word.length()<2){
					continue;
				}

				word = word.replaceAll("[,?;.:!()]", "");
				
				if (word.length()<2){
					continue;
				}
				
				String wordDoc = word.toLowerCase().trim()+"@"+fileName ;
				Text outputKey = new Text(wordDoc);
				IntWritable outputValue = new IntWritable(1);
				context.write(outputKey, outputValue);
				
			}	
	}
}
