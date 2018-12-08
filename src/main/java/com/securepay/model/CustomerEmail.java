package com.securepay.model;

import java.util.List;

public class CustomerEmail extends Email {
  private int parentId;
  private String emailType;
  private List<PayableItem> payableItems;

  public int getParentId() { return parentId; }
  public void setParentId(int parentId) { this.parentId = parentId; }

  public String getEmailType() { return emailType; }
  public void setEmailType(String emailType) { this.emailType = emailType; }

  public List<PayableItem> getPayableItems() { return payableItems; }
  public void setPayableItems(List<PayableItem> payableItems) { this.payableItems = payableItems; }
}
