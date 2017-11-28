/**
 * 
 */
package org.dogepool.practicalrx.asyncapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.dogepool.practicalrx.asyncapi.CustomAsyncExceptionHandler;
import java.util.concurrent.Executor;
import org.springframework.scheduling.annotation.AsyncConfigurer;



/**
 * @author nikhil / Grzegorz Piwowarek
 * https://github.com/eugenp/tutorials/tree/master/spring-all/src/main/java/org/baeldung/async
 */

@Configuration
@EnableAsync
@ComponentScan("org.dogepool.practicalrx")
public class SpringAsyncConfig implements AsyncConfigurer {
    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    @Override
    public Executor getAsyncExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
    
    
	
}
