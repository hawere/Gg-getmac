package Filtermac;

import java.util.ArrayList;

public class Mainclean {
	public static void main(String[] args) throws Exception {
		
		GetAllmac.getallmac();
		ArrayList<String> realmac = ReadConf.Realmac(); //读入filtermac文件数据到list中赋予realmac
		CleanByApmac.givefiled(realmac); //将根据filtermac规则清洗数据写出到/get/clean.csv文件中
		
		
		System.out.println("【执行成功】");
		Thread.sleep(5000);
		
	}
}
