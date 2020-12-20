/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.modelo;

import java.util.Date;

/**
 *
 * @author conta
 */
public class Boleto {
 private String our_number;
 private String document_number;
 private String expiration_date;
 private String instruction;
 private String provider;

    public String getOur_number() {
        return our_number;
    }

    public void setOur_number(String our_number) {
        this.our_number = our_number;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

  
 
}
