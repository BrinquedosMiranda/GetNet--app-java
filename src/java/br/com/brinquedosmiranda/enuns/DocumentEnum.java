/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.enuns;

/**
 *
 * @author conta
 */
public enum DocumentEnum {
    CPF("CPF"),
    CNPJ("CNPJ");
  
    private final String document;

    DocumentEnum(String document) {
        this.document = document;
    }

    public String getDocument() {
        return document;
    }

    public static DocumentEnum getByDocument(String document) {
        for (DocumentEnum e : values()) {
            if (e.document.equals(document)) return e;
        }
        throw new IllegalArgumentException();
    }
}

