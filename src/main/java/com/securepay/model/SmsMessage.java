package com.securepay.model;

public class SmsMessage {
  private int id = -1;
  private Email email;
  private int status;
  private Double cost;
  private String messageContent;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public Email getEmail() { return email; }
  public void setEmail(Email email) { this.email = email; }

  public int getStatus() { return status; }
  public void setStatus(int status) { this.status = status; }

  public Double getCost() { return cost; }
  public void setCost(Double cost) { this.cost = cost; }

  public String getMessageContent() { return messageContent; }
  public void setMessageContent(String messageContent) { this.messageContent = messageContent; }
}
