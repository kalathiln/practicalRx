package org.dogepool.practicalrx.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dogepool.practicalrx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Use this import through out
import rx.Observable;
//import io.reactivex.Observable;

/**
 * Service to retrieve information on the current status of the mining pool
 */
@Service
public class PoolService {

    private final Set<User> connectedUsers = new HashSet<>();

    public String poolName() {
        return "Wow Such Pool!";
    }
//    public List<User> miningUsers() {
//        return new ArrayList<>(connectedUsers);
//    }
/*	Manual Conversion done here here
 *  Observable.from is used when one needs to get emitted data in the form of a collection.
 */
    
    public Observable<User> miningUsers() {
        return Observable.from(connectedUsers);
    }

//    public boolean connectUser(User user) {
//        connectedUsers.add(user);
//        System.out.println(user.nickname + " connected");
//        return true;
//    }
    /*
     *	Using Observable.create().
     *  This operator create a Observable. Use the onNext, onCompleted, on Error so that the function
     *  behaves as a Observable. You can pass this operator a function which passes an observer as the parameter.
     */
    public Observable<Boolean> connectUser(User user) {
	    	System.out.println(user.nickname + " connected");
	    	return Observable.create(s -> {
	    		connectedUsers.add(user);
	    		s.onNext(Boolean.TRUE);
	    		s.onCompleted();
	    	});
    }

//    public boolean disconnectUser(User user) {
//        connectedUsers.remove(user);
//        System.out.println(user.nickname + " disconnected");
//        return true;
//    }
    /*
     * Same as above
     */
    public Observable<Boolean> disconnectUser(User user) {
	    	System.out.println(user.nickname + " disconnected");
	    	return Observable.create(
	    		s-> {
	    			connectedUsers.remove(user);
	    			s.onNext(Boolean.TRUE);
	    			s.onCompleted();
    		});
    	}
}
