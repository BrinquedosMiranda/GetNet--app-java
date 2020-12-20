/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.teste;

import br.com.brinquedosmiranda.http.AutenticacaoServiceHTTP;
import br.com.brinquedosmiranda.http.PagamentoCombinadoHTTP;
import br.com.brinquedosmiranda.http.PagamentoCreditoHTTP;
import br.com.brinquedosmiranda.enuns.AmbienteEnum;
import br.com.brinquedosmiranda.enuns.BrandEnum;
import br.com.brinquedosmiranda.enuns.DocumentEnum;
import br.com.brinquedosmiranda.enuns.TransactionEnum;
import br.com.brinquedosmiranda.util.Credenciar;
import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author conta
 */
public class TestePagamentoCombinado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Credenciar cred = new Credenciar();
        //----------------Requisição contendo os dados para pagamento com cartão de crédito--
      
        int amount = 100;
        //----------------Requisição contendo os dados para pagamento com cartão de crédito--
         
        //----------------order----------------------------
         String order_id = "1234";
        //----------------order----------------------------
        
        //----------------customer------------------
        String customer_id = "123456";
        String first_name = "João";
        String last_name = "da Silva";
        String email = "customer@email.com.br";
        DocumentEnum documentEnun = DocumentEnum.CPF;
        String document_number = "12345678912";
        String phone_number = "5551999887766";
        //----------------identificador do comprador------------------
                
        //----------------billing_address---------------------------
        String street = "Av. Brasil";
        String number = "1000";
        String complement = "Sala 1";
        String district = "São Geraldo";
        String city = "Porto Alegre";
        String state = "RS";
        String postal_code = "90230060";
        //----------------billing_address---------------------------
        
        //----------------device------------------------------------
          String session = "eermmeifsfsefsf";
       //----------------device-------------------------------------
       
       //----------------shippings----------------------------------
        String phone_number_shipping = "5551999887766";
       //----------------shippings----------------------------------
       
        //----------------addres------------------------------------
        String street_address = "Av. Brasil";
        String number_address = "1000";
        String complement_address = "Sala 1";
        String districtt_address = "São Geraldo";
        String city_address = "Porto Alegre";
        String state_address = "RS";
        String postal_code_address = "90230060";
        //----------------addres------------------------------------
        
        //----------------payments----------------------------------
         String type = "CREDIT"; 
         int amountTodas = 100;
         TransactionEnum transaction = TransactionEnum.FULL;
         int number_installments = 1;
         String payment_tag = "pay-1";
         String soft_descriptor = "BRINQUEDOSMIRANDA";
        //----------------payments----------------------------------
            
        //----------------card--------------------------------------
         String cardNumber = "5155901222280001";
         String cardholder_name = "JOAO DA SILVA";
         String security_code = "123";
         BrandEnum brand = BrandEnum.MASTERCARD;
         String expiration_month = "12";
         String expiration_year = "20";
         //----------------card--------------------------------------
        PagamentoCombinadoHTTP pagamentoCombinado = new PagamentoCombinadoHTTP(Credenciar.ambiente, Credenciar.ClientID, Credenciar.ClientSecret, Credenciar.setSeller_id, amount, order_id,
                customer_id, first_name, last_name, email, documentEnun, document_number, phone_number, street, number, complement, district,
                city, state, postal_code, session, phone_number_shipping, street_address, number_address, complement_address, districtt_address, 
                city_address, state_address, postal_code_address, type, amountTodas, transaction, number_installments, payment_tag, soft_descriptor, 
                cardNumber, cardholder_name, security_code, brand, expiration_month, expiration_year);
       
       
    }

}
