package Filtermac;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadConf {
	
	
	
	public static ArrayList<String> Realmac() throws IOException{
		ArrayList<String> list = new ArrayList<String>();
		BufferedReader br=new BufferedReader(new FileReader(new File("../conf/filtermac")));
		//BufferedReader br=new BufferedReader(new FileReader(new File("E:/wifidata/conf/filtermac")));
		String line = null;
		while((line=br.readLine()) != null){
			String replaceAll = line.replaceAll(":", "");
			String lowerCase = replaceAll.toLowerCase();
			list.add(lowerCase);
		}
		br.close();
		return list;
	}
	
	

}
