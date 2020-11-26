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
public enum BrandEnum {
    MASTERCARD("Mastercard"),
    VISA("Visa"),
    AMEX("Amex"),
    ELO("Elo"),
    HIPERCARD("Hipercard");

    private final String brand;

    BrandEnum(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public static BrandEnum getByBrand(String brand) {
        for (BrandEnum e : values()) {
            if (e.brand.equals(brand)) return e;
        }
        throw new IllegalArgumentException();
    }
}

