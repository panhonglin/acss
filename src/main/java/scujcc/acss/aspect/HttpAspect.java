package scujcc.acss.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 负责拦截请求并做检验，如验证登录
 * @author CZM
 * @create 2018-10-20 上午 12:33
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(("execution(public * scujcc.acss.controller.MainController.*(..))"))
    public void log(){ }

    //TODO

    //记录请求信息
    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //id
        logger.info("ip={}",request.getRemoteAddr());
        //class method
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //arguments
        logger.info("args={}",joinPoint.getArgs());

    }

    //记录返回的值
    @AfterReturning(returning = "object",pointcut = "log()")
    public void logReturn(Object object){
        logger.info("response={}",object.toString());
    }
}
