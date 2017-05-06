package com.glut.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author Caizhif
 * @date 2017年4月19日下午10:38:18
 * @version v.0.1
 * <p>Description: 统一处理web层请求日志</p>
 *
 */
@Aspect
@Component
public class WebLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	// controller层切面
	@Pointcut("execution(public * com.glut.*.controller.*.*(..))")
	public void webLog() {
	}

	
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		logger.info("WebLogAspect.doBefore()");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求url
		logger.info("URL : " + request.getRequestURL().toString());
		// 记录请求方法
		logger.info("HTTP_METHOD : " + request.getMethod());
		// 记录访客ip
		logger.info("IP : " + request.getRemoteAddr());
		// 访问哪个类哪个方法
		logger.info("CLASS_METHOD : "
				+ joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		// 访问所带参数
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

		/*
		 * 获取所有参数方法一： Enumeration<String> enu = request.getParameterNames();
		 * while (enu.hasMoreElements()) { StringparaName = (String)
		 * enu.nextElement(); System.out .println(paraName + ": " +
		 * request.getParameter(paraName)); }
		 */
	}

	@AfterReturning("webLog()")
	public void doAfterReturning(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		logger.info("WebLogAspect.doAfterReturning()");
		logger.info("耗时（毫秒） : "
				+ (System.currentTimeMillis() - startTime.get()));
	}

	/*
	@AfterThrowing("webLog()")
	public void doAfterThrowing() {}*/
}
