package org.fage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
/**
 * 
 * <p>Title: </p> 
 * <p>Description: 测试alibaba的festjson与热部署</p>
 * @author Caizhf
 * @date 2017年4月5日下午1:55:28
 *
 */
@SpringBootApplication(scanBasePackages="org.fage")
public class App {

	//自动注入的方式使用fastJson,如果不使用fastjson，就会默认使用SpringBoot自带的
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//先定义一个convert转换消息对象
		FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
		//添加fastJson的配置信息，比如是否需要格式化返回的json数据
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//在convert中添加配置信息
		fastConvert.setFastJsonConfig(config);
		HttpMessageConverter<?> converter = fastConvert;
		return new HttpMessageConverters(converter);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
