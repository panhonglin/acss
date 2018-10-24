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
    //日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    /**
     * @Author CZM
     * @Description //TODO 
     * @Date 下午 01:02 2018/10/20
     * @Param []
     * @return void
     **/
    @Pointcut(("execution(public * scujcc.acss.controller.MainController.*(..))"))
    public void log(){ }


    /**
     * @Author CZM
     * @Description 记录请求的情况
     * @Date 下午 01:02 2018/10/20
     * @Param [joinPoint]
     * @return void
     **/
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

    /**
     * @Author CZM
     * @Description 记录返回的值
     * @Date 下午 01:06 2018/10/20
     * @Param [object]
     * @return void
     **/
    @AfterReturning(returning = "object",pointcut = "log()")
    public void logReturn(Object object){
        if (object!=null) {
            logger.info("response={}", object.toString());
        }
    }
}
