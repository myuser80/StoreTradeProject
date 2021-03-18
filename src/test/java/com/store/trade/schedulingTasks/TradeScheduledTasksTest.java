package com.store.trade.schedulingTasks;


import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.store.trade.StoreTradeAndValidateService;
import com.store.trade.updateTradeState.TradeUpdateTasksUponMaturityDate;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig(StoreTradeAndValidateService.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeScheduledTasksTest {

    @SpyBean
    private TradeUpdateTasksUponMaturityDate TradeScheduledTasks;

    @Test
    public void whenWaitOneSecond_thenScheduledIsCalledAtLeastTenTimes() {
        await() .atMost(Duration.ONE_MINUTE)
                .untilAsserted(() -> verify(TradeScheduledTasks,atLeast(2)).reportCurrentTime());
    }

}