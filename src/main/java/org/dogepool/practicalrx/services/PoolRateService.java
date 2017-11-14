package org.dogepool.practicalrx.services;

import org.dogepool.practicalrx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rx.Observable;

/**
 * Service to retrieve the current global hashrate for the pool.
 */
@Service
public class PoolRateService {

    @Autowired
    private PoolService poolService;

    @Autowired
    private HashrateService hashrateService;

//    public double poolGigaHashrate() {
//        double hashrate = 0d;
////        for (User u : poolService.miningUsers()) {
//        	for (User u : poolService.miningUsers().toList().toBlocking().single()) {
////            double userRate = hashrateService.hashrateFor(u);
//        		double userRate = hashrateService.hashrateFor(u).toBlocking().single();
//            hashrate += userRate;
//        }
//        return hashrate;
//    } 
    /*
     * Transforming the method by using flatmap and reduce operators
     */
    public Observable<Double> poolGigaHashrate() {
    	 	return poolService.miningUsers()
    	 			.flatMap(u -> hashrateService.hashrateFor(u))
    	 			.reduce(0d,(pools,users)->pools+users);
    }
    	

}
