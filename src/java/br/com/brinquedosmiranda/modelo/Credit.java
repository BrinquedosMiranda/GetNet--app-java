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
public class Credit {
  private boolean delayed;  
 // private boolean authenticated;  
 // private boolean pre_authorization;  
  private boolean save_card_data;  
  private String transaction_type;  
  private int number_installments;  
  private String soft_descriptor; 
  
 // private int dynamic_mcc;  
  private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
  
  

    public boolean isDelayed() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
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

    public String getSoft_descriptor() {
        return soft_descriptor;
    }

    public void setSoft_descriptor(String soft_descriptor) {
        this.soft_descriptor = soft_descriptor;
    }

     

}
