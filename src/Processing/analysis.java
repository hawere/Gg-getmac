package Processing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.json.JSONArray;

import org.json.JSONObject;





public class analysis {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("../offlinedata/wifi.log")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../get/data.csv",true)));
		 	  
        StringBuffer sb = new StringBuffer(); 
        
        String str = null;  
        while((str = br.readLine()) != null) {  
                sb.append(str);  
        }  
        br.close(); 
               
        String jsdata = new String(sb);	        
        //System.out.println(jsdata);	        
        //JSONObject job = new JSONObject().fromObject(jsdata);
        JSONObject job = new JSONObject(jsdata);
        
        	String wifidata = job.getString("wifidata");       
        	//JSONObject wd = new JSONObject().fromObject(wifidata);
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
        			String strg = apmac+" "+time+" "+mac+" "+rssi;
        			System.out.println(strg);
        			
					bw.write(strg+"\r\n");
					bw.flush();
        			bw.close();        			
        		}
              
			br.close();
	}
}
