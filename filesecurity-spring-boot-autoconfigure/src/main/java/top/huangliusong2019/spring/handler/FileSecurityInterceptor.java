package top.huangliusong2019.spring.handler;

import top.huangliusong2019.filesecurity.annotation.FileSecurityAnnotation;
import top.huangliusong2019.filesecurity.base.UploadFileBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import top.huangliusong2019.spring.autoconfigure.FileSecurityProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private final FileSecurityProperties fileSecurityProperties;
    private Logger logger = LoggerFactory.getLogger(FileSecurityInterceptor.class);

    /**
     * Init properties
     *
     * @param fileSecurityProperties properties,FileSecurityProperties
     */
    public FileSecurityInterceptor(FileSecurityProperties fileSecurityProperties) {
        this.fileSecurityProperties = fileSecurityProperties;
    }

    /**
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return boolean
     * @throws Exception e
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //Gets the specified annotation on the current method
        FileSecurityAnnotation loggerHLSAnnotation = method.getAnnotation(FileSecurityAnnotation.class);
        //if the current annotation exists
        if (loggerHLSAnnotation != null) {
            MultipartHttpServletRequest multipartHttpServletRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            logger.info("fileSecurityProperties={}", fileSecurityProperties);
            MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
            String filename = multipartFile.getOriginalFilename();
            //TODO Hashcode Unfinished
            checkingFile(multipartFile, "");
            logger.info("Filename={}", filename);
            long startTime = System.currentTimeMillis();
            request.setAttribute("StartTime", startTime);
            logger.info("Enter the method of name={},Enter the time={}ms", method.getName(), +startTime);
        }

        return true;
    }

    /**
     * Post handle
     *
     * @param request      request
     * @param response     response
     * @param handler      handler
     * @param modelAndView modelAndView
     * @throws Exception e
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //Gets the specified annotation on the current method
        FileSecurityAnnotation loggerHLSAnnotation = method.getAnnotation(FileSecurityAnnotation.class);
        //if the current annotation exists
        if (loggerHLSAnnotation != null) {
            long endTime = System.currentTimeMillis();
            long startTime = (Long) request.getAttribute("StartTime");
            long periodTime = endTime - startTime;
            logger.info("Leave the method of name={},Leave the time={}", method.getName(), endTime);
            logger.info(" In method ={},Time consuming={}", method.getName(), periodTime);
        }

    }

    /**
     * Call UploadFileBase to check MultipartFile
     *
     * @param multipartFile file
     * @param hashCode      Hash value
     */
    private void checkingFile(MultipartFile multipartFile, String hashCode) {
        String suffix = multipartFile.getOriginalFilename().
                substring(multipartFile.getOriginalFilename().
                        lastIndexOf(".") + 1);
        logger.info("[MultipartFile]>>>suffix", suffix);
        UploadFileBase uploadFileBase = new UploadFileBase(
                fileSecurityProperties.getUploadSuffixWhiteList(),
                fileSecurityProperties.getUploadSuffixBlackList(),
                fileSecurityProperties.getUploadMIMEWhiteList(),
                fileSecurityProperties.getUploadMimeBlackList(),
                fileSecurityProperties.getHashCodeValidate());
        try {
            uploadFileBase.checkFile(multipartFile.getContentType(), suffix, hashCode, multipartFile.getBytes());
        } catch (IOException e) {
            logger.error("[Check file error,IO Exception]>>e.message={}", e.getMessage());
            e.printStackTrace();
        }

    }
}
