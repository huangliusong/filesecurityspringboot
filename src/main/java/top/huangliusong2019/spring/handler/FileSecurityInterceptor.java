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
 * @author huangliusong
 * @version 1.0.0
 * @since 2019/7/5
 * {@link HandlerInterceptorAdapter}
 * {@link FileSecurityAnnotation}
 */
public class FileSecurityInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(FileSecurityAnnotation.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //获取当前方法上的指定注解
        FileSecurityAnnotation loggerHLSAnnotation = method.getAnnotation(FileSecurityAnnotation.class);
        //判断当前注解是否存在
        if (loggerHLSAnnotation != null) {
            long startTime = System.currentTimeMillis();
            request.setAttribute("startTime", startTime);
            logger.info("进入" + method.getName() + "方法的时间是：" + startTime);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //获取当前方法上的指定注解
        FileSecurityAnnotation loggerHLSAnnotation = method.getAnnotation(FileSecurityAnnotation.class);
        //判断当前注解是否存在
        if (loggerHLSAnnotation != null) {
            long endTime = System.currentTimeMillis();
            long startTime = (Long) request.getAttribute("startTime");
            long periodTime = endTime - startTime;
            logger.info("离开" + method.getName() + "方法的时间是：" + endTime);
            logger.info("在" + method.getName() + "方法的时长是：" + periodTime);
        }

    }
}
