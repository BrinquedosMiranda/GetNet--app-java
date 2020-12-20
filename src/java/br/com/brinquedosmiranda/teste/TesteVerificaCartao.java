/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.teste;

import br.com.brinquedosmiranda.http.AutenticacaoServiceHTTP;
import br.com.brinquedosmiranda.http.VerificacaoDeCartaoHTTP;
import br.com.brinquedosmiranda.enuns.AmbienteEnum;
import br.com.brinquedosmiranda.enuns.BrandEnum;
import br.com.brinquedosmiranda.util.Credenciar;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;


/**
 *
 * @author conta
 */
public class TesteVerificaCartao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Credenciar cred = new Credenciar();
        //-------------------------------------------------------
        String cardNumber = "5155901222280001";
        BrandEnum brand = BrandEnum.MASTERCARD;
        String cardholder_name = "JOAO DA SILVA";
        String expiration_month = "12";
        String expiration_year = "20";
        String security_code = "123";
       
      
       VerificacaoDeCartaoHTTP  v = new VerificacaoDeCartaoHTTP(Credenciar.ambiente, Credenciar.ClientID, Credenciar.ClientSecret, cardNumber, brand, cardholder_name, expiration_month, expiration_year, security_code);
    }
    
}
