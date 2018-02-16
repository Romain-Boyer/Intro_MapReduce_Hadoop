package cs.bigdata.Tutorial2;

public class Tree {
	
	public Tree(String line){
		String[] splitted_line = line.split(";");
		
		String year = splitted_line[16];
		String height = splitted_line[12];
		
		if(year.length()>0){
			//this.year = Integer.parseInt(year_);
			System.out.println("Year : "+year);
		}
		else{
			System.out.println("Year : N/A");
		}
		
		if(height.length()>0){
			System.out.println("Height : "+height);
		}
		else{
			System.out.println("Height : N/A");
		}
	}	
}
