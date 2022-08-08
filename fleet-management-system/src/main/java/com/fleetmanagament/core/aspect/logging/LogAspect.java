package com.fleetmanagament.core.aspect.logging;

import com.fleetmanagament.core.logging.Log;
import com.fleetmanagament.core.logging.LogRepository;
import com.fleetmanagament.entity.domain.Shipment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final LogRepository logRepository;

    @Autowired
    public LogAspect(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    //Annotation ile yakalamak daha şık olurdu.
    @Around(value = "execution(* com.fleetmanagament.business.shipmentacceptor.*.acceptDelivery* (..)) && args(shipment,deliveryPoint)", argNames = "pjp,shipment,deliveryPoint")
    public Object afterThrowingAdvice(ProceedingJoinPoint pjp, Shipment shipment, Integer deliveryPoint) {
        try {
            pjp.proceed();
        } catch (Throwable e) {
            Log log = new Log();
            log.setBarcode(shipment.getBarcode());
            log.setMessage(e.getMessage());
            this.logRepository.save(log);
        }
        return new Object();
    }
}
