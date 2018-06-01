package forGonge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Gonge {

	public static void main(String[] args) throws Exception {

		
		
		BufferedReader bfr = new BufferedReader( new InputStreamReader(new FileInputStream("E:/wifidata/offlinedata/td.csv")));
		//BufferedReader bfr = new BufferedReader( new InputStreamReader(new FileInputStream("E:/wifidata/offlinedata/tdwifi.csv")));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/wifidata/get/Gonge.csv",true)));
		
		String str = null; 
		int i = 1 ;
		int n = 1 ;
		String apmac = "apmac=>";
		String tssend = "tssend=>";
		String rssi = "rssi=>";
		String mac = "mac=>";
		String dstmac = "dstmac";
		String apmac1 = "";
		String tssend1 = "";
		String rssi1 = "";
		String mac1 = "";
		
		
        while((str = bfr.readLine()) != null) {  
        	
        		String[] slist = str.split(",");
        		int j = slist.length;
        		//System.out.print(j+"\n");
        	
        		for(int a=0; a<j; a++){
        			
        			String str1 = new String(slist[a]);
        			if(str1.indexOf(apmac)!=-1){
        				final int first = str1.indexOf("\"\"");
        				final int last = str1.lastIndexOf("\"\"");
        				int fl = last - first-2;
        				if(fl>0){
        					apmac1 = str1.substring(first+2,last);
        				}else{
        					apmac1 = " ";
        				}
        				//System.out.print("apmac:"+apmac1+"\n");
        			}
        			
        			if(str1.indexOf(tssend)!=-1){
        				final int first = str1.indexOf("\"\"");
        				final int last = str1.lastIndexOf("\"\"");
        				int fl = last - first-2;
        				if(fl>0){
        					tssend1 = str1.substring(first+2,last);
        				}else{
        					tssend1 = " ";
        				}
        				//System.out.print("tssend:"+tssend1+"\n");
        			}
        			
        			if(str1.indexOf(rssi)!=-1){
        				final int first = str1.indexOf("\"\"");
        				final int last = str1.lastIndexOf("\"\"");
        				int fl = last - first-2;
        				if(fl>0){
        					rssi1 = str1.substring(first+2,last);
        				}else{
        					rssi1 = " ";
        				}
        				//System.out.print("rssi:"+rssi1+"\n");
        			}
        			
        			if(str1.indexOf(mac)!=-1 && str1.indexOf(dstmac) == -1 && str1.indexOf(apmac) == -1){
        				final int first = str1.indexOf("\"\"");
        				final int last = str1.lastIndexOf("\"\"");
        				int fl = last - first-2;
        				if(fl>0){
        					mac1 = str1.substring(first+2,last);
        				}else{
        					mac1 = " ";
        				}   
        				
        				if(mac1.length()==12 && apmac1.length()==12){
            				//System.out.print("mac:"+mac1+"\n");
            			System.out.print(tssend1+","+apmac1+","+mac1+","+rssi1+"\n");
            			bw.write(tssend1+","+apmac1+","+mac1+","+rssi1+"\r\n");
            			
            			n++;
            			
            			}
        				        			
        			}
        			        			
        		}        	
        	
        	i++;
        }  
               
        bfr.close();
        bw.close();
        
        System.out.print(i+"\n"+n);
		
	}

}
