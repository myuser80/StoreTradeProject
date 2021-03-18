
package com.store.trade.updateTradeState;

import com.store.trade.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component

public class TradeUpdateTasksUponMaturityDate {

	private static final Logger log = LoggerFactory.getLogger(TradeUpdateTasksUponMaturityDate.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	TradeService tradeService;

	//@Scheduled(cron = "${trade.expiry.schedule}") //currentlly setup 30 min
	//@Scheduled(cron ="0 1 * * * ?")
	@Scheduled(fixedRate = 50000)
	public void reportCurrentTime() {
		System.out.println(">>>>>>>>>>>>>>The time is now {}" + dateFormat.format(new Date()));
		log.info("The time is now {}", dateFormat.format(new Date()));
		tradeService.updateExpiryFlagOfTrade();
	}
}