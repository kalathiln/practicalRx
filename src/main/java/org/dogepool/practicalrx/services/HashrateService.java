package org.dogepool.practicalrx.services;

import org.dogepool.practicalrx.domain.User;
import org.springframework.stereotype.Service;

import rx.Observable;

/**
 * Service to retrieve hashrate information of users.
 */
@Service
public class HashrateService {

    /**
     * @param user
     * @return the last known gigahash/sec hashrate for the given user
     */
//    public double hashrateFor(User user) {
//        if (user.equals(User.USER)) {
//            return 1.234;
//        }
//        return user.displayName.length() / 100d;
//    }
	public Observable<Double> hashrateFor(User user) {
		return Observable.create(s -> {
			if(user.equals(User.USER)) {
				s.onNext(1.234);
			}else {
				s.onNext(user.displayName.length()/100d);
			}
		});  
	}
}
