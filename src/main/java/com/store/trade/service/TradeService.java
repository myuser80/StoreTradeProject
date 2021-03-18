package com.store.trade.service;

import com.store.trade.dao.StoreTradeDao;
import com.store.trade.dao.TradeRepository;
import com.store.trade.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TradeService {

    private static final Logger log = LoggerFactory.getLogger(TradeService.class);

    @Autowired
    StoreTradeDao tradeDao;

    @Autowired
    TradeRepository tradeRepository;

    public boolean isTradeValid(Trade trade){
        if(validateTrdeMaturityDate(trade)) {
            // Trade exsitingTrade = tradeDao.findTrade(trade.getTradeId());
            Optional<Trade> exsitingTrade = tradeRepository.findById(trade.getTradeId());
             if (exsitingTrade.isPresent()) {
                 return validateTradeVersion(trade, exsitingTrade.get());
             }else{
                 return true;
             }
         }
         return false;
    }

    private boolean validateTradeVersion(Trade trade,Trade oldTrade) {
        //validation 1  During transmission if the
        // lower version is being received by the store it will reject the trade and throw an exception.
        if(trade.getVersion() >= oldTrade.getVersion()){
            return true;
        }
        return false;
    }

    //2.	Store should not allow the trade which has less maturity date then today date
    private boolean validateTrdeMaturityDate(Trade trade ){
    	return trade.getMaturityDate().isBefore(LocalDate.now())  ? false:true;
        
    }

    public void  persist(Trade trade){
       // tradeDao.save(trade);
        trade.setCreatedDate(LocalDate.now());
        tradeRepository.save(trade);
    }

    public List<Trade> findAll(){
       return  tradeRepository.findAll();
        //return tradeDao.findAll();
    }

    public void updateExpiryFlagOfTrade(){
      /* tradeDao.tradeMap.forEach(
               (k,v) -> {
                   if(!validateMaturityDate(v)){
                       v.setExpiredFlag("N");
                       log.info("Trade which needs to updated {}",v);
                   }
               }
       );*/
    	
        tradeRepository.findAll().stream().forEach(t -> {
        	
        	if (!validateTrdeMaturityDate(t)) {        		
                    t.setExpiredFlag("Y");                   
                             log.info("Trade which needs to updated {}", t);
                             tradeRepository.save(t);
                   
                }
            });
        }


}
