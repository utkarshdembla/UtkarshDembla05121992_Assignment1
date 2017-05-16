import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ReadFileData {

	private Scanner file;
	
	public void openFile(String filename)
	{
		
		try {
			file=new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Not able to find the file");
			e.printStackTrace();
		}
		
	}
	
	public LinkedHashMap<String,ArrayList<String>> readFile()
	{
		
		LinkedHashMap<String,ArrayList<String>> linkedHashMap=new LinkedHashMap<>() ;
		
		while(file.hasNext())
		{
			String id=file.next();
		
			
			ArrayList<String> arrayList=new ArrayList<>();
			String classEnrolled=file.next();
			String marks=file.next();
			arrayList.add(classEnrolled);
			arrayList.add(marks);
			
			linkedHashMap.put(id,arrayList);
		}
		
		return linkedHashMap;
	}
	
	public void writeFile(LRUCache<String,ArrayList<String>> lruCache,String filename) throws IOException
	{
		
		System.out.println(lruCache);
			try {
				FileOutputStream fout=new FileOutputStream(filename,false);
						
				
			for(Entry<String, ArrayList<String>> cache:lruCache.entrySet())
			{
				
				String str=cache.getKey()+" "+cache.getValue().get(0)+" "+cache.getValue().get(1);
				
				
				fout.write(str.getBytes());
				fout.write("\n".getBytes());
				
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	public void closeFile()
	{
		file.close();
	}
}
