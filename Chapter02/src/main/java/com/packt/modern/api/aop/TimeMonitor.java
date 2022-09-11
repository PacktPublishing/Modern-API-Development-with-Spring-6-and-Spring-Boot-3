package com.packt.modern.api.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author  : github.com/sharmasourabh
 * @project : Chapter02 - Modern API Development with Spring and Spring Boot
 * @created : 09/04/2022
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeMonitor {

}
