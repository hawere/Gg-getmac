package Processing;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProcessAll {
	public static void main(String[] args) throws Exception{
		
		File file = new File("E:/wifidata/offlinedata");
        File[] listFile = file.listFiles();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:/wifidata/get/data.csv")));
        
        int m = 1;
        for (File line : listFile){
        	System.out.println(line.getName() + m++);
        	GZIPInputStream gins = new GZIPInputStream(new FileInputStream(line));
        	BufferedInputStream bins = new BufferedInputStream(gins);
        	ByteArrayOutputStream bous = new ByteArrayOutputStream(1000);
        	byte[] b = new byte[1000];
        	int n;
        	
        	while ((n = bins.read(b))!= -1){
        		bous.write(b, 0, n);
        	}
        	
        	bins.close();
        	bous.close();
        	
        	byte[] byteArrary = bous.toByteArray();
        	String jsonString = new String(byteArrary,"utf8"); 
        	
        	JSONObject job = new JSONObject(jsonString);
        	String wifidata = job.getString("wifidata");       
        	JSONObject wd = new JSONObject(wifidata);
        	String apmac = wd.getString("apmac");
        	String tssend = wd.getString("tssend");
        	SimpleDateFormat sdf =  new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss:SSS");  
            Long lg = new Long(tssend);
            Date date = new Date(lg);
            String time = sdf.format(date);
            
            JSONArray wtl = wd.getJSONArray("wifitalist");	
    		for (int i=0;i<wtl.length();i++){
    			String mac = wtl.getJSONObject(i).getString("mac");
    			String rssi = wtl.getJSONObject(i).getString("rssi");
    			String str = apmac+","+time+","+mac+","+rssi;
    			//System.out.println(str);
    			
 				bw.write(str);
 				//bw.flush();
				bw.newLine();
    		}
    		bw.flush();
        }
        bw.close();
	}
}
