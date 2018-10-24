package com.qa.cleartrip.loadproperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	public static Properties prop;

	public static Properties loadProperties(){
		if (prop == null) {
			prop = new Properties();
			File file = new File(System.getProperty("user.dir") + "/src/test/resources/propertiesFiles/");
			File[] f = file.listFiles();
			for (int i = 0; i < f.length; i++) {
				try {
					FileInputStream fis = new FileInputStream(f[i]);
					prop.load(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return prop;
		
	}
	public static String getdesiredProperty(String key){
		prop=loadProperties();
		return prop.getProperty(key);
		
	}

}
