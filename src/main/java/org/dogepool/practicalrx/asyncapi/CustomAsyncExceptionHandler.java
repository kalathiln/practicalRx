package org.dogepool.practicalrx.asyncapi;

import java.lang.reflect.Method;

/**
 * @author nikhil / Grzegorz Piwowarek
 * https://github.com/eugenp/tutorials/tree/master/spring-all/src/main/java/org/baeldung/async
 */

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(final Throwable throwable, final Method method, final Object... obj) {
        System.out.println("Exception message - " + throwable.getMessage());
        System.out.println("Method name - " + method.getName());
        for (final Object param : obj) {
            System.out.println("Param - " + param);
        }
    }

}