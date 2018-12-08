package com.securepay.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SmsMessageRepositoryImpl implements SmsMessageRepositoryEx {
  @Autowired
  private EntityManager em;
  private SessionFactory sf;
  
  public SmsMessageRepositoryImpl(@Autowired EntityManagerFactory emFactory) {
    final SessionFactory unwrapped = emFactory.unwrap(SessionFactory.class);
    if (unwrapped == null)
      throw new NullPointerException("factory is not a hibernate factory");
    this.sf = unwrapped;
  }
}
