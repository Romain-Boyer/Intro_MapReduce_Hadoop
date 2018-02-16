package cs.bigdata.Tutorial2;


import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;



public class YearHeightTree {

	public static void main(String[] args) throws IOException {
		
		String localSrc = "/home/cloudera/Desktop/isd-history.txt";
		//Open the file
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// read line by line
			String line = br.readLine();
			int no_line = 0;
			
			while (line !=null){
				// Process of the current line
				if(no_line>0){
					Tree tree = new Tree(line);
				}
				no_line += 1;
				
				// go to the next line
				line = br.readLine();
			}
		}
		finally{
			//close the file
			in.close();
			fs.close();
		}
 
		
		
	}

}
