package org.fage.cfg;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Fapha
 * @date 2017年4月7日下午7:16:16
 * <p>Title:pointcut </p> 
 * <p>Description:测试切面是否能使用 </p>
 *
 */
@Component
@Aspect
public class TestPointCut {
	@Around("execution(public * org.fage.service.UserService.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
		System.out.println("切面切入成功！！");
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}
