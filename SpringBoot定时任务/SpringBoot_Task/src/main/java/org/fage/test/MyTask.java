package org.fage.test;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
/**
 * 
 * @author Fapha
 * @date 2017年4月11日下午1:59:47
 * @version v.0.1
 * <p>Description: </p>
 *
 */
@Configuration
@EnableScheduling
public class MyTask {
	/**
	 *这个方法每两到服务器5秒打印一次,从服务器开始的时间为准
	 *cron:定时任务表达式
	 *分别表示:秒，分钟，小时，日期，月份，星期，年（可选） 
	 * 
	 */
	@Scheduled(cron="0/5 * * * * ?")
	public void task1(){
		System.out.println("MyTask.tast1(),"+new Date());
	}
	
	
	/**
	 * 我们希望这个方法每1分钟打印一次.
	 */
	@Scheduled(cron="0 0/1 * * * *")
	public void tast2(){
		System.out.println("MyTask.tast2(),"+new Date());
	}
}
