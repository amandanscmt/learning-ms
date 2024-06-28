package com.apmns.hr_payroll.services;

import com.apmns.hr_payroll.entities.Payment;
import com.apmns.hr_payroll.entities.Worker;
import com.apmns.hr_payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

   @Autowired
   private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

       Worker worker = workerFeignClient.findById(workerId).getBody();
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
