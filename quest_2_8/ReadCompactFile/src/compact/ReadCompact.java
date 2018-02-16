package compact;


import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;



public class ReadCompact {

	public static void main(String[] args) throws IOException {
		
		String file = args[0];
		
		//Open the file
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		
		int current_line = 0;
		int start_line = 22;
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// read line by line
			String line = br.readLine();
			System.out.println(line);

			while(current_line < start_line){
				// Go to the next line & add 1 to current_line
				current_line += 1;
				line = br.readLine();
			}
			
			while(line != null){
				String USAF = line.substring(0, 6);
				String name = line.substring(13, 42);
				String country = line.substring(43, 45);
				String elevation = line.substring(74, 81);
				
				System.out.println("History : ");
				System.out.println("USAF : "+USAF+"; Name : "+name+"; Country : "+country+"; Elevation : "+elevation);
			
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
