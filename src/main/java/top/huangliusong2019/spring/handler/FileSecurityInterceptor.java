package top.huangliusong2019.spring.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import top.huangliusong2019.spring.annotation.FileSecurityAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Intercept specific requests or all requests
 * When the annotation FileSecurityAnnotation is used, it intercepts the annotation method
 *
 * @author huangliusong
 * @version 1.0.0
 * @since 2019/7/5
 * {@link HandlerInterceptorAdapter}
 * {@link FileSecurityAnnotation}
 */
public class FileSecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(FileSecurityInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //Gets the specified annotation on the current method
        FileSecurityAnnotation loggerHLSAnnotation = method.getAnnotation(FileSecurityAnnotation.class);
        //if the current annotation exists
        if (loggerHLSAnnotation != null) {
            long startTime = System.currentTimeMillis();
            request.setAttribute("startTime", startTime);
            logger.info("Enter the method of name " + method.getName() + " Enter the time ：" + startTime);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //Gets the specified annotation on the current method
        FileSecurityAnnotation loggerHLSAnnotation = method.getAnnotation(FileSecurityAnnotation.class);
        //if the current annotation exists
        if (loggerHLSAnnotation != null) {
            long endTime = System.currentTimeMillis();
            long startTime = (Long) request.getAttribute("startTime");
            long periodTime = endTime - startTime;
            logger.info("Leave the method of name " + method.getName() + " Leave the time：" + endTime);
            logger.info(" In method " + method.getName() + " Time consuming：" + periodTime);
        }

    }
}
