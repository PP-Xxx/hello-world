package cn.smbms.test;

import cn.smbms.tools.Singleton;

public class TestSingleton {

	public static void main(String[] args) {
		System.out.println("Singleton.test()---->"+Singleton.test());
		System.out.println("Singleton.getInstance---->"+Singleton.getInstance());
	}
}
