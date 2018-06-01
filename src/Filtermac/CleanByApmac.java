package Filtermac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CleanByApmac {
			
	public static void givefiled(ArrayList<String> arrayList) throws Exception{
	
	File file = new File("../get/Beforeclean.csv");
	//File file = new File("E:/wifidata/get/Beforeclean.csv");
	BufferedReader br = new BufferedReader(new FileReader(file));
	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("../get/Cleanover.csv")));
	//BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:/wifidata/get/cleanover.csv")));
	
	String line = null;
	int i = 1;
	int n = 1;
	
	while((line=br.readLine())!=null){
		System.out.print(line+"\n");
		String[] split = line.split(",");
		if (split.length!=4) {
			continue;
		}
		String apmac = split[1];
		String mac = split[2];
		
		
		String substring = mac.substring(0, 6);
		if (arrayList.contains(substring)) {
			
			String addmac = addmac(apmac);
			String addmac2 = addmac(mac);
			
			bw.write(split[0]+","+addmac+","+addmac2+","+split[3]);
			bw.newLine();
			
			n++;
		}
		i++;
	}
	br.close();
	bw.flush();
	bw.close();
	
	int x = i - n;
		
	System.out.print("清洗前： "+(i-1)+"\n");
	System.out.print("假mac： "+x+"\n");
	System.out.print("清洗后： "+(n-1)+"\n");
	}

public static StringBuffer sb = new StringBuffer();
public static String addmac(String mac){
	for (int i = 0; i < 12; i+=2) {
		String substring = mac.substring(i, i+2);
		sb.append(substring);
		if (i!=10) {
			sb.append(":");
		}
	}
	String newmac = sb.toString();
	sb.delete(0, sb.length());
	return newmac;
}

}
