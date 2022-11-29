import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		//	Check arguments
		if(args[0].equals(Constants.showAll)) {
			System.out.println(Constants.loading);		
			
			String studentNames[] = readFile().split(Constants.split);			
			for(String name : studentNames) { 
				System.out.println(name); 
			}

			System.out.println(Constants.loaded);
		} 
		else if(args[0].equals(Constants.random)) {
			System.out.println(Constants.loading);

			String studentNames[] = readFile().split(Constants.split);
			int randomInt = new Random().nextInt(studentNames.length);
			System.out.println(studentNames[randomInt]);

			System.out.println(Constants.loaded);	
		} 
		else if(args[0].contains(Constants.add)){
			System.out.println(Constants.loading);

			String formate = new SimpleDateFormat(Constants.dateFormat).format(new Date());
			write(args[0].substring(1) , formate);

			System.out.println(Constants.loaded);	
		} 
		else if(args[0].contains(Constants.search)) {
			System.out.println(Constants.loading);			
			
			String studentNames[] = readFile().split(Constants.split);
			boolean notFound = true;
			for(String name : studentNames) {
				if(name.equals(args[0].substring(1))) {
					System.out.println(Constants.foundText);
					notFound = false;
					break;
				}
			}
			if(notFound){
				System.out.println(Constants.notFound + args[0].substring(1));
			}

			System.out.println(Constants.loaded);				
		}
		else if(args[0].contains(Constants.count)) {
			System.out.println(Constants.loading);

			String studentNames[] = readFile().split(Constants.split);			
			System.out.println(studentNames.length +" word(s) found ");
			
			System.out.println(Constants.loaded);				
		} else{
			System.out.println("Wrong Argument passed\n");
		}
	}

	private static String readFile(){
		try{
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(Constants.fileName))); 
		return reader.readLine();
		}catch(Exception e){
			
		}
		return "error";
	}

	private static void write(String name , String date){
		try{
			BufferedWriter writer = new BufferedWriter(
				new FileWriter(Constants.fileName, true));
			writer.write(", "+name+"\nList last updated on "+date);
			writer.close();
		} catch (Exception e){

		}
	}
}
