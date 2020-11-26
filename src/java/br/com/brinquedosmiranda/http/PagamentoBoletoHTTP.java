/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.http;

import br.com.brinquedosmiranda.enuns.AmbienteEnum;
import br.com.brinquedosmiranda.enuns.BrandEnum;
import br.com.brinquedosmiranda.enuns.DocumentEnum;
import br.com.brinquedosmiranda.enuns.TransactionEnum;
import br.com.brinquedosmiranda.modelo.Address;
import br.com.brinquedosmiranda.modelo.Billing;
import br.com.brinquedosmiranda.modelo.Boleto;
import br.com.brinquedosmiranda.modelo.Card;
import br.com.brinquedosmiranda.modelo.Credit;
import br.com.brinquedosmiranda.modelo.Customer;
import br.com.brinquedosmiranda.modelo.Device;
import br.com.brinquedosmiranda.modelo.GetNet;
import br.com.brinquedosmiranda.modelo.Order;
import br.com.brinquedosmiranda.modelo.Shippings;
import br.com.brinquedosmiranda.modelo.Tokenizacao;
import br.com.brinquedosmiranda.modelo.Verificacao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author conta
 */
public class PagamentoBoletoHTTP {

    //--------Requisição contendo os dados para pagamento com boleto
    private AmbienteEnum ambiente;
    private String clientID;
    private String clientSecret;
    private String setSeller_id;
    private int Amount;
    //--------Requisição contendo os dados para pagamento com boleto

    //--------Requisição boleto order---------------------------------
    private String order_id;
    //--------Requisição boleto order---------------------------------

    //--------Requisição boleto --------------------------------------
    private String our_number;
    private String document_number_boleto;
    private String expiration_date;
    private String instruction;
    //--------Requisição boleto -------------------------------------

    //--------Requisição boleto customer ----------------------------
    private String first_name;
    private String name;
    private DocumentEnum documentEnun;
    private String document_number;
    private String provider;
    //--------Requisição boleto customer ---------------------------

    //--------Requisição boleto billing ---------------------------
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String postal_code;
    //--------Requisição boleto billing ---------------------------

    public String PagamentoBoleto(AmbienteEnum ambiente, String clientID, String clientSecret, String setSeller_id, int Amount, String order_id, String our_number, String document_number_boleto, String expiration_date, String instruction, String first_name, String name, DocumentEnum documentEnun, String document_number,String provider, String street, String number, String complement, String district, String city, String state, String postal_code) {
        String payment_id = null;
        try {
            String urlParameters;
            //------------------------------------------------------------------
            AutenticacaoServiceHTTP AutenticacaoService = new AutenticacaoServiceHTTP();
            String access_token = AutenticacaoService.Autenticacao(ambiente, clientID, clientSecret);
            //------------------------------------------------------------------
            String url = ambiente.getUrl() + "/v1/payments/boleto";
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            con.setRequestProperty("Authorization", "Bearer " + access_token);
            con.setRequestProperty("Accept-Encoding", "gzip");
            //----------------parameters-----------------------
            Gson gson = new Gson();
            GetNet getNetBoleto = new GetNet();
            Type TypePagamentoBoleto = new TypeToken<GetNet>() {
            }.getType();
            //------------------------------------------------------ 
            getNetBoleto.setSeller_id(setSeller_id);
            getNetBoleto.setAmount(Amount);
            getNetBoleto.setCurrency("BRL");
            Order order = new Order();
            order.setOrder_id(order_id);
            getNetBoleto.setOrder(order);
            //------------------------------------------------------ 
            Boleto boleto = new Boleto();
            boleto.setOur_number(our_number);
            boleto.setDocument_number(document_number_boleto);
            boleto.setExpiration_date(expiration_date);
            getNetBoleto.setBoleto(boleto);
            //------------------------------------------------------  
            Customer cus = new Customer();
            cus.setFirst_name(first_name);//Antifraude
            cus.setName(name);//Antifraude
            cus.setDocument_type(documentEnun.getDocument());//Antifraude
            cus.setDocument_number(document_number);//Antifraude
            Billing bil = new Billing();
            bil.setStreet(street);//Antifraude
            bil.setNumber(number);//Antifraude
            bil.setComplement(complement);//Antifraude
            bil.setDistrict(district);
            bil.setCity(city);//Antifraude
            bil.setState(state);//Antifraude
            bil.setPostal_code(postal_code);//Antifraude
            cus.setBilling_address(bil);
            getNetBoleto.setCustomer(cus);
            //------------------------------------------------------       
            urlParameters = gson.toJson(getNetBoleto, TypePagamentoBoleto);
            //----------------parameters-----------------------
            //----------------parameters-----------------------
            System.out.println("verificar" + urlParameters);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            //System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);
            InputStream inStream = new GZIPInputStream(con.getInputStream());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inStream));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            try {
                JSONObject jsonobject = new JSONObject(response.toString());
                payment_id = jsonobject.getString("payment_id");

            } catch (JSONException err) {
                err.getMessage();
            }
            //print result
            System.out.println(response.toString());

        } catch (Exception erro) {

        }
        return payment_id;

    }

}
