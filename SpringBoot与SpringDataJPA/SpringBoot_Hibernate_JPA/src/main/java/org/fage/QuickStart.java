package org.fage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
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
 * @author Fapha
 * @date 2017年4月5日下午9:39:34
 * <p>快速启动入口</p>
 * <a href="http://blog.csdn.net/catoop/article/details/50595702">事务管理器选择</a>
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableWebMvc
@SpringBootApplication(scanBasePackages="org.fage")
@EnableJpaRepositories
@EnableCaching
public class QuickStart {
	
	public static void main(String[] args) {
		SpringApplication.run(QuickStart.class, args);
	}
	
	/**
	 * <p>Description:使用fastjson<p/>
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
