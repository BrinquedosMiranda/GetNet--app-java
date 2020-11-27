/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.util;

import br.com.brinquedosmiranda.enuns.AmbienteEnum;

/**
 *
 * @author conta
 */
public class Credenciar {
  
   
   public static final String setSeller_id = "";
   public static final String ClientID = "";
   public static final String ClientSecret = "";
   public static final AmbienteEnum ambiente = AmbienteEnum.SANDBOX;
 

    public String getClientID() {
        return ClientID;
    }

    public String getClientSecret() {
        return ClientSecret;
    }

    public String getSetSeller_id() {
        return setSeller_id;
    }
   
}
