import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

	private static final long serialVersionUID = 1L;

	private int size;
	
	private LRUCache(int size)
	{
		this.size=size;
	}
	
	public static <K,V> LRUCache<K,V> newInstance(int size)
	{
		return new LRUCache<K,V>(size);
		
	}
	
	public static void shutdown(LRUCache<String, ArrayList<String>> lruCache)
	{
		lruCache.clear();
	}
	

	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
	{
		return size()>size;
		
	}
	
	public static void main(String[] args) throws IOException {
		LRUCache<String,ArrayList<String>> lruCache=LRUCache.newInstance(20); 
		Map<String,ArrayList<String>> linkedHashMap=new LinkedHashMap<>();
		ReadFileData readFileData = new ReadFileData();
		
		System.out.println("Enter the file location");
		Scanner sc=new Scanner(System.in);
		
		
		String filename=sc.nextLine();
		
		readFileData.openFile(filename);
		
		linkedHashMap=readFileData.readFile();
		
		for(Map.Entry<String, ArrayList<String>> map:linkedHashMap.entrySet())
		{
			lruCache.put(map.getKey(),map.getValue());
		}
	
		
	
	
	readFileData.openFile(filename);
	readFileData.writeFile(lruCache, filename);
	readFileData.closeFile();
	
	
	shutdown(lruCache);
	
	System.out.print(lruCache);
	}

}
