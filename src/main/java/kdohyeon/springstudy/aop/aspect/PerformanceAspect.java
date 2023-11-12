package kdohyeon.springstudy.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {
    @Pointcut("execution(* *..UserService.getUserByName(..))")
    private void cut() {}

    @Pointcut("@annotation(Timer)")
    private void enableTimer() {}

    @Around("cut() || enableTimer()")
    public Object performance(ProceedingJoinPoint jp) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start();

        Object proceed = jp.proceed();

        sw.stop();

        log.info("수행 시간={}ms", sw.getTotalTimeMillis());

        return proceed;
    }
}
