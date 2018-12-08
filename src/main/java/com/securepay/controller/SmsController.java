package com.securepay.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.securepay.model.SmsMessage;
import com.securepay.repository.SmsMessageRepository;

@RestController
@RequestMapping(path = "/api/sms", method = { RequestMethod.GET })
public class SmsController {
  @Autowired
  private SmsMessageRepository smsRepo;

  @RequestMapping("/{hotelId}")
  public List<SmsMessage> getDeliveredSmsMessagesWithNoCost(@PathVariable("hotelId") int hotelId) {
    smsRepo.getDeliveredSmsMessagesWithNoCost(hotelId);
    smsRepo.getDeliveredSmsMessagesWithNoCost2(hotelId);
    smsRepo.getDeliveredSmsMessagesWithNoCost3(hotelId);
    return Collections.emptyList();
  }
}
