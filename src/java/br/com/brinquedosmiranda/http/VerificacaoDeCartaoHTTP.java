/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.http;

import br.com.brinquedosmiranda.enuns.AmbienteEnum;
import br.com.brinquedosmiranda.enuns.BrandEnum;
import br.com.brinquedosmiranda.modelo.Tokenizacao;
import br.com.brinquedosmiranda.modelo.Verificacao;
import br.com.brinquedosmiranda.util.Credenciar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author conta
 */
public class VerificacaoDeCartaoHTTP {

    private AmbienteEnum ambiente;
    private String clientID;
    private String clientSecret;
    private String cardNumber;
    private BrandEnum brand;
    private String cardholder_name;
    private String expiration_month;
    private String expiration_year;
    private String security_code;

    public VerificacaoDeCartaoHTTP(AmbienteEnum ambiente, String clientID, String clientSecret, String cardNumber, BrandEnum brand, String cardholder_name, String expiration_month, String expiration_year, String security_code) {
        //String number_token = null;
       
        try {
            String urlParameters;
            //------------------------------------------------------------------
            AutenticacaoServiceHTTP AutenticacaoService = new AutenticacaoServiceHTTP();
            String numbertoken = AutenticacaoService.criarAutenticacao(Credenciar.ambiente, clientID, clientSecret, cardNumber);
            String access_token = AutenticacaoService.Autenticacao(ambiente, clientID, clientSecret);
            //------------------------------------------------------------------
            String url = ambiente.getUrl() + "/v1/cards/verification";
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            con.setRequestProperty("Authorization", "Bearer " + access_token);
            //----------------parameters-----------------------
            Gson gson = new Gson();
            Verificacao verificacao = new Verificacao();
            Type TypeVerificacao = new TypeToken<Verificacao>() {
            }.getType();
            verificacao.setNumber_token(numbertoken);
            verificacao.setBrand(brand.getBrand());
            verificacao.setCardholder_name(cardholder_name);
            verificacao.setExpiration_month(expiration_month);
            verificacao.setExpiration_year(expiration_year);
            verificacao.setSecurity_code(security_code);
            urlParameters = gson.toJson(verificacao, TypeVerificacao);
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

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

        } catch (Exception erro) {

        }

    }
   

   

}
