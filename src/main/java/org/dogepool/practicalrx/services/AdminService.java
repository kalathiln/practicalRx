package org.dogepool.practicalrx.services;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import io.reactivex.Observable;



import org.springframework.stereotype.Service;

/**
 * Service for administrative purpose like tracking operational costs.
 */
@Service
public class AdminService {

//    public BigInteger costForMonth(int year, Month month) {
//        LocalDate now = LocalDate.now();
//
//        if (year == now.getYear() && month == now.getMonth()) {
//            return BigInteger.ZERO;
//        }
//        if (year > now.getYear()
//            || year == now.getYear() && month.getValue() > now.getMonthValue()) {
//            return BigInteger.ZERO;
//        }
//        return BigInteger.valueOf(
//                year +
//                month.getValue() * 100);
//    }
	
	/* Converting the above Spring code into RxJava
	 * Using factory method Observable.just() and the map operator.
	 * 
	 */
    
	public Observable<BigInteger> costForMonth(int year, Month month) {
        LocalDate now = LocalDate.now();

        if (year == now.getYear() && month == now.getMonth()) {
            return Observable.just(BigInteger.ZERO);
        }
        if (year > now.getYear()
            || year == now.getYear() && month.getValue() > now.getMonthValue()) {
            return Observable.just(BigInteger.ZERO);
        }
        return Observable.just(month.getValue())
        		.map(v -> year + v * 100)
        		.map(integer -> BigInteger.valueOf(integer));
    }
}
