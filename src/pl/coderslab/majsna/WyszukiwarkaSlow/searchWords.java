package pl.coderslab.majsna.WyszukiwarkaSlow;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class searchWords {

	public static void main(String[] args) {
		
		String titles = "";
		
		Connection connect = Jsoup.connect("http://www.onet.pl/");
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    StringBuffer sb = new StringBuffer();
		    for (Element elem : links) {
		        String tmpText = elem.text()+" ";
		        sb.append(tmpText);
		    }
		    titles = sb.toString();
		    
			StringTokenizer tok = new StringTokenizer(titles, " .,?/\"'()*&^%$#@!~`;:");
			PrintWriter writer = new PrintWriter("popular_words.txt");
			while(tok.hasMoreTokens()) {
				String tmpWord = tok.nextToken();
				if(tmpWord.length()>3) {
					writer.write(tmpWord+"\n");
				}			
			}
			writer.close();
			
			Path path1 = Paths.get("popular_words.txt");
			Map<String, Integer> words	= new	HashMap<>();
			
			for(String line : Files.readAllLines(path1)) {				
				if(words.containsKey(line)) {
					words.put(line, words.get(line)+1);
				}else {
					words.put(line, 1);
				}
			}
			
			List<Word> wordsArr = new ArrayList<>();
			Iterator it = words.entrySet().iterator();
			
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        wordsArr.add(new Word( (Integer)pair.getValue(), pair.getKey().toString() ));
		        it.remove(); // avoids a ConcurrentModificationException
		    }
		    
		    Collections.sort(wordsArr);
		    
		    System.out.println("The top 10 most popular words are:\n");
		    
		    if(wordsArr.size()>=10) {
		    	for(int i=0; i<10; i++) {
		    		System.out.println( (i+1)+" "+wordsArr.get(i).toString());
		    	}
		    }else {
		    	for(int i=0; i<wordsArr.size(); i++) {
		    		System.out.println( (i+1)+" "+wordsArr.get(i).toString());
		    	}
		    }
		   
		    		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	

}
