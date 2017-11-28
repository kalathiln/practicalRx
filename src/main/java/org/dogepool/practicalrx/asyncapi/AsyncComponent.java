package org.dogepool.practicalrx.asyncapi;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/**
 * @author nikhil / Grzegorz Piwowarek
 * https://github.com/eugenp/tutorials/tree/master/spring-all/src/main/java/org/baeldung/async
 */

@Component
public class AsyncComponent {
//	This annotation can be applied only to public  methods
//	Self-invocation - calling the async method from within the same class- won't work
    @Async
    public void asyncMethodWithVoidReturnType() {
        System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
    }
    public static void testAsyncAnnotationForMethodsWithReturnType()
    		  throws InterruptedException, ExecutionException {
    		    System.out.println("Invoking an asynchronous method. "
    		      + Thread.currentThread().getName());
    		    Future<String> future = asyncMethodWithReturnType();
    		 
    		    while (true) {
    		        if (future.isDone()) {
    		            System.out.println("Result from asynchronous process - " + future.get());
    		            break;
    		        }
    		        System.out.println("Continue doing something else. ");
    		        Thread.sleep(1000);
    		    }
    		}
    
    @Async
//    @Async can be applied to method with return type - by wrapping the actual return in the Future: 
    public static Future<String> asyncMethodWithReturnType() {
        System.out.println("Execute method asynchronously " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<>("hello world !!!!");
        } catch (final InterruptedException e) {

        }

        return null;
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() {
        System.out.println("Execute method asynchronously with configured executor" + Thread.currentThread().getName());
    }

    @Async
    public void asyncMethodWithExceptions() throws Exception {
        throw new Exception("Throw message from asynchronous method. ");
    }

}
