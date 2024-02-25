package eights.hometask.resourceserver.SemEightsHomeTask.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class TrackUserActionAspect {
    /**
     * Аспект отслеживает все методы где будет указана аннотация @TrackUserActionAnnotation
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(eights.hometask.resourceserver.SemEightsHomeTask.aspects.TrackUserActionAnnotation)")
    public Object trackUserAction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Вызван метод :" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("Метод завершил свою работу.");
        return object;
    }


}
