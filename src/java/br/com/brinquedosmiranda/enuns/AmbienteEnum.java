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
public enum AmbienteEnum {
    SANDBOX("https://api-sandbox.getnet.com.br/"),
    HOMOLOGACAO("https://api-homologacao.getnet.com.br/"),
    PRODUCAO("1");

    private final String url;

    AmbienteEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public static AmbienteEnum getByUrl(String url) {
        for (AmbienteEnum e : values()) {
            if (e.url.equals(url)) return e;
        }
        throw new IllegalArgumentException();
    }
}

