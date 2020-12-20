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
public enum TransactionEnum {
    FULL("FULL"),
    INSTALL_NO_INTEREST("INSTALL_NO_INTEREST"),
    INSTALL_WITH_INTEREST("INSTALL_WITH_INTEREST");
   

    private final String transaction;

    TransactionEnum(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }

    public static TransactionEnum getByTransaction(String transaction) {
        for (TransactionEnum e : values()) {
            if (e.transaction.equals(transaction)) return e;
        }
        throw new IllegalArgumentException();
    }
}

