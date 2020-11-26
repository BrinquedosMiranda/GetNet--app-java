/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.teste;

import br.com.brinquedosmiranda.http.AutenticacaoServiceHTTP;
import br.com.brinquedosmiranda.http.PagamentoBoletoHTTP;
import br.com.brinquedosmiranda.http.PagamentoCreditoHTTP;
import br.com.brinquedosmiranda.enuns.AmbienteEnum;
import br.com.brinquedosmiranda.enuns.BrandEnum;
import br.com.brinquedosmiranda.enuns.DocumentEnum;
import br.com.brinquedosmiranda.enuns.TransactionEnum;
import br.com.brinquedosmiranda.util.Credenciar;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author conta
 */
public class TestePagamentoBoleto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
    //--------Requisição contendo os dados para pagamento com boleto
        Credenciar cred = new Credenciar();
     //----------------Requisição contendo os dados para pagamento com cartão de crédito--
      int Amount = 125000;
     //--------Requisição contendo os dados para pagamento com boleto
    
  //--------Requisição boleto order---------------------------------
    String order_id = "1234";
  //--------Requisição boleto order---------------------------------
    
  //--------Requisição boleto --------------------------------------
    String our_number = "2";
    String document_number_boleto = "103111";
   // String instruction =  "1. Imprima em impressora jato de tinta (ink jet) ou laser em qualidade normal ou alta.Não use modo econômico.\n"+
                          // "Por favor, configure a margens esquerda e direita para 17 mm.\n"+
                         //  "2. Gramatura do papel, mínima de 50 g/m2.\n" +
                         //  "3. Utilize folha A4 (210 x 297 mm) ou Carta (216 x 279 mm) e margens mínimas à esquerda e à direita do formulário."; 
   String instruction = "Não receber após o vencimento";
   String provider = "santander";
//--------Requisição boleto -------------------------------------
    
  //--------Requisição boleto customer ----------------------------
     String first_name = "João";
     String name = "João da Silva";
     DocumentEnum documentEnun = DocumentEnum.CPF;
     String document_number = "12345678912";
   //--------Requisição boleto customer ---------------------------
    
   //--------Requisição boleto billing ---------------------------
    String street = "Av. Brasil";
    String number = "1000";
    String complement = "Sala 1";
    String district = "São Geraldo";
    String city = "Porto Alegre";
    String state = "RS";
    String postal_code = "06719040";
    
     //--------Formatacao data ------------------------------------
    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
    Calendar hoje = Calendar.getInstance();
    hoje.add(Calendar.DAY_OF_MONTH, +2);
    Date date = hoje.getTime(); 
   //--------Formatacao data ---------------------------------------
         PagamentoBoletoHTTP pagamentoBoleto = new PagamentoBoletoHTTP();
         String payment_id = pagamentoBoleto.PagamentoBoleto(Credenciar.ambiente, Credenciar.ClientID, Credenciar.ClientSecret,  Credenciar.setSeller_id, Amount, order_id, our_number, document_number_boleto, sd.format(date), instruction, first_name, name, documentEnun, document_number,provider, street, number, complement, district, city, state, postal_code);
         // link do boleto
        // https://api-homologacao.getnet.com.br/v1/payments/boleto/{payment_id}/html
    }

}
