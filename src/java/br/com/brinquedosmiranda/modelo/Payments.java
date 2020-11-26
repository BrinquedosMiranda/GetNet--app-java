/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.modelo;

/**
 *
 * @author conta
 */
public class Payments {
   private String type; 
   private int amount;
   private String currency;
   private boolean save_card_data;
   private String transaction_type;
   private int number_installments;
   private String payment_tag;
   private String soft_descriptor;
   private Card card;
   private Credit credit;
 

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
   
   

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
   
   

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isSave_card_data() {
        return save_card_data;
    }

    public void setSave_card_data(boolean save_card_data) {
        this.save_card_data = save_card_data;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getNumber_installments() {
        return number_installments;
    }

    public void setNumber_installments(int number_installments) {
        this.number_installments = number_installments;
    }

    public String getPayment_tag() {
        return payment_tag;
    }

    public void setPayment_tag(String payment_tag) {
        this.payment_tag = payment_tag;
    }

    public String getSoft_descriptor() {
        return soft_descriptor;
    }

    public void setSoft_descriptor(String soft_descriptor) {
        this.soft_descriptor = soft_descriptor;
    }
   
   
}
