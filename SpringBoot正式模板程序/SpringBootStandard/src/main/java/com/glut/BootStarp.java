package com.glut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
 * @author Caizhf
 * @date 2017年4月17日下午6:24:24
 * @version v.0.1
 * <p>Description: 快速启动入口,配置SpringBoot、使用SpringMVC、自动使用AOP、启用事务</p>
 *
 */
@SpringBootApplication(scanBasePackages={"com.glut"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableJpaRepositories
public class BootStarp {
	
	public static void main(String[] args) {
		SpringApplication.run(BootStarp.class, args);
	}
	
	/**
	 * @return
	 * <p>Description:注入fastJsonConverters<p/>
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConvert.setFastJsonConfig(config);
		HttpMessageConverter<?> converter = fastConvert;
		return new HttpMessageConverters(converter);
	}
}
