package com.securepay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.securepay.model.SmsMessage;

@Repository
public interface SmsMessageRepository extends JpaRepository<SmsMessage, Integer>, SmsMessageRepositoryEx {
  @Query("from SmsMessage sms where "
      + "sms.status=4 and sms.cost is null and "
      + "(sms.email.id in (select he.id from HotelEmail he where he.hotel.id=:hotelId) or "
      + "sms.email.id in (select ce.id from CustomerEmail ce inner join ce.payableItems p where p.hotel.id=:hotelId))")
  List<SmsMessage> getDeliveredSmsMessagesWithNoCost(@Param("hotelId") int hotelId);

  @Query("from SmsMessage sms where "
      + "sms.status=4 and sms.cost is null and "
      + "(sms.email.id in (select he.id from HotelEmail he where he.hotel.id=:hotelId) or "
      + "sms.email.id in (select ce.parentId from PayableItem p join p.emails ce where p.hotel.id=:hotelId))")
  List<SmsMessage> getDeliveredSmsMessagesWithNoCost2(@Param("hotelId") int hotelId);
  
  @Query("select distinct sms from SmsMessage as sms "
      + "left outer join CustomerEmail as ce on sms.email.id = ce.id "
      + "inner join ce.payableItems as p "
      + "left outer join HotelEmail as he on sms.email.id = he.id "
      + "where "
      + "  sms.status=4 "
      + "  and sms.cost is null "
      + "  and (p.hotel.id=:hotelId or he.hotel.id=:hotelId)")
  List<SmsMessage> getDeliveredSmsMessagesWithNoCost3(@Param("hotelId") int hotelId);

}
