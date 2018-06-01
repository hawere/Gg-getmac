package forGonge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Quchong {

	public static void main(String[] args) throws Exception{
		BufferedReader bfr = new BufferedReader( new InputStreamReader(new FileInputStream("E:/wifidata/get/Gonges.csv")));
		//BufferedReader bfr = new BufferedReader( new InputStreamReader(new FileInputStream("E:/wifidata/offlinedata/tdwifi.csv")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/wifidata/get/Gonge.csv",true)));
		
		String line = null;
		
		ArrayList<String> list = new ArrayList<String>();
		int x = 0;
		int y = 0;
		int z = 0;
		while((line=bfr.readLine()) != null){
			if(!list.contains(line)){
				list.add(line);
				bw.write(line+"\r\n");
				System.out.print(line+"\r\n");
				y++;
			}
			
			x++;
		}
		
		/*List<String> newList = new  ArrayList<String>(); 
        for (String quchong:list) {
           if(!newList.contains(quchong)){
               newList.add(quchong);
               bw.write(quchong+"\r\n");
               System.out.print(quchong+"\r\n");
               y++;
           }
        }*/
		
		bfr.close();
        bw.close();
        z = x - y;
        System.out.print("去重前为：【" + x +"】条");
        System.out.print("去重后为：【" + y +"】条");
        System.out.print("重复的为：【" + z +"】条");
        
	}

}
