package Processing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class mergeAll {
	
	public static void main(String[] args) throws Exception{
		File file = new File("E:/wifidata/test1");
		//File file = new File("/data/wifidata/zjdata");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/wifidata/test2")));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/data/wifidata/1")));
        File[] listFile = file.listFiles();
        
        int m = 1;
        for (File line : listFile){
        	System.out.println(line.getName() + m++);
        	BufferedReader bfr = new BufferedReader( new InputStreamReader(new FileInputStream(line)));
        	String str1 = null;  
            String last = bfr.readLine();
            while((str1 = bfr.readLine()) != null)  
            {  
            	
            	bw.write(str1);
            	
            	bw.newLine();
            	
            }
            bw.write(last);
            bfr.close();
        }
        bw.close();
        
	}
}
