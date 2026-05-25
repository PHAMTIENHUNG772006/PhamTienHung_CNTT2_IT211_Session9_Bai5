package com.re.session9.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.UUID;


@Aspect
@Component
@Order(1)
@Slf4j
public class SystemFailureMonitorAspect {

    @AfterThrowing(pointcut = "execution(* com.re.session9.service.*.*(..))", throwing = "ex")
   public void logSystemFailure(JoinPoint joinPoint, Throwable ex) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);

        log.error("Lỗi hệ thống tại phương thức {}: {}", joinPoint.getSignature().getName(), ex.getMessage());

        MDC.clear();
   }
}
