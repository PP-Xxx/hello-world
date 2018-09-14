package cn.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 读取配置文件的工具类--懒汉模式（采用延迟加载的方式，在运行调用时创建实例）
public class ConfigManager2 {

	private static ConfigManager2 configManager = new ConfigManager2();
	private static Properties properties;

	// 私有构造器-- 读取数据库配置文件
	private ConfigManager2(){
		
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = ConfigManager2.class.getClassLoader()
						.getResourceAsStream(configFile);
		
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 全局访问点（外部获取实例）----饿汉模式（类加载较慢，但是获取对象的速度很快  ）
	public static ConfigManager2 getInstance(){
		return configManager;
	}
	
	// 从属性文件中查询相关的键（如果没查询到返回null）
	public String getValue(String key){
		return properties.getProperty(key);
	}
	
}
