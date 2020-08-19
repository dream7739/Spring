package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	//@Around인 메소드 안에서 jointPoint를 받을 수 있음 -> 여기서 jointPoint는 annotation(LogExecutionTime)이 붙어있는 메소드
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint jointPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		//jointPoint 함수 실행
		Object proceed = jointPoint.proceed();

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		//리턴
		return proceed;
	}
}
