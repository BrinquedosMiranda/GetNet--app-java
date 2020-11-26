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
  
   
   public static final String setSeller_id = "38cf0db3-a30a-47ec-824d-2ef3b71c6605";
   public static final String ClientID = "c6ff3601-0812-40cd-a987-1c17fb138923";
   public static final String ClientSecret = "8d37f63c-4196-4513-ab4e-a93f45b55b1d";
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
