package com.springboot.utils;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class GeneratorStart {

	public static void main(String[] args) throws Exception {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
//获得正在执行当前线程的引用，然后获取此Thread的上下文AppClassLoader类加载器	
		//每个Thread都有一个相关联的ClassLoader，默认是AppClassLoader。
		//并且子线程默认使用父线程的ClassLoader除非子线程特别设置。
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		System.out.println(classloader);
		//获取classpach下配置文件,因为AppClassLoader加载的路径就是本项目classpach下的所有文件，
		InputStream is = classloader.getResourceAsStream("generator-config.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		
	
		
	}
	

}
