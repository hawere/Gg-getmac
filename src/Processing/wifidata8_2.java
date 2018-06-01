package Processing;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class wifidata8_2 {

	public static void main(String[] args) throws Exception{
		
		  
		//File file = new File("E:/wifidata/offlinedata");
		File file = new File("/data/wifidata/offlinedata");
        File[] listFile = file.listFiles();
        
        //BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:/wifidata/get/data.csv")));
        
        
        for (File line : listFile){
        	
        	System.out.println(line.getName());
        	String name = line.getName().substring(5, 7);
        	BufferedReader bfr = new BufferedReader( new InputStreamReader(new FileInputStream(line)));
        	//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/wifidata/zjdata/"+name+".csv",true)));
        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/data/wifidata/zjdata/"+name+".csv",true)));
        String str1 = null;  
        
        while((str1 = bfr.readLine()) != null)  
        {  
            //System.out.println(str1); 
            String[] slist = str1.split(",");
            
            int c = slist[0].length();
          if (c >= 10){
            String str3 = str1.substring(c,str1.length()).trim();
            
            String str4 = new String(slist[0]).trim();
            
            String time = null;
            
           
            if (str4.length() >= 13){
            	String str5 = str4.substring(0, 13).trim();
            	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss:SSS");  
            	Long lg = new Long(str5);
            	Date date = new Date(lg);
            	time = sdf.format(date);
            	
            }else{
            	String str5 = str4.substring(0, 10).trim();
            	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");  
            	Long lg = new Long(str5);
            	Date date = new Date(lg);
            	time = sdf.format(date);
            	
            }
            String str6 = time+str3;
            //System.out.println(str6);
            bw.write(str6+"\r\n");
            
			
          }else{
        	  System.out.println("呵呵！");
          } 
        }  
              
        //close  
        bw.close();
        bfr.close();
        
	}
  }
}
