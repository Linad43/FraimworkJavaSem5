package linad.FraimworkHWLes5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {
    @Around("execution(* linad.FraimworkHWLes5.service.*.addTask(..))")
    public Object logAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnedByMethod = proceedingJoinPoint.proceed();
        System.out.println("Calling a method addTask()");
        return returnedByMethod;
    }
    @Around("execution(* linad.FraimworkHWLes5.service.*.changeStatus(..))")
    public Object logChange(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnedByMethod = proceedingJoinPoint.proceed();
        System.out.println("Calling a method changeStatus()");
        return returnedByMethod;
    }
    @Around("execution(* linad.FraimworkHWLes5.service.*.deleteTask(..))")
    public Object logDelete(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnedByMethod = proceedingJoinPoint.proceed();
        System.out.println("Calling a method deleteTask()");
        return returnedByMethod;
    }
}
