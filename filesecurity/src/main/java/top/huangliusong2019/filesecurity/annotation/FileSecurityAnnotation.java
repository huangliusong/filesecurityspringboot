package top.huangliusong2019.filesecurity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Adding this annotation to a method intercepts the method
 *
 * @author huangliusong
 * @version 1.0.0
 * {@link Retention}
 * @since 2019/7/4
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileSecurityAnnotation {

}
