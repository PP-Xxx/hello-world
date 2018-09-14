package cn.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Singleton {

	private static Singleton singleton;
	private static Properties properties;
	private Singleton(){
		// 整个应用运行期间，只执行一次的业务代码操作（入读取配置文件的操作）
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = ConfigManager.class.getClassLoader()
						.getResourceAsStream(configFile);
		
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance(){
		singleton = SingletonHelper.INSTANCE;
		return singleton;
	}
	
	public static Singleton test(){
		return singleton;
	}
	
}
