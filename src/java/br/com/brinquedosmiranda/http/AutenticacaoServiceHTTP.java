/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brinquedosmiranda.http;

import br.com.brinquedosmiranda.enuns.AmbienteEnum;
import br.com.brinquedosmiranda.modelo.Tokenizacao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author conta
 */
public class AutenticacaoServiceHTTP {
 
    
    public String criarAutenticacao(AmbienteEnum ambiente,String ClientID,String ClientSecret,String cardNumber){
        return Tokenizacao(ambiente, ClientID, ClientSecret,cardNumber);
    }
    
   public String Autenticacao(AmbienteEnum ambiente,String ClientID,String ClientSecret){
       String access_token = null; 
       try{
            //configuracao para pegar o Authorization: Basic
            StringBuffer response = null;
            String url = ambiente.getUrl()+"/auth/oauth/v2/token";
            String userCredentials = ClientID+":"+ClientSecret;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();  
             //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Authorization", basicAuth);
            String urlParameters = "scope=oob&grant_type=client_credentials";
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);

            }
            in.close();
            try {
                JSONObject jsonobject = new JSONObject(response.toString());
                access_token = jsonobject.getString("access_token");

            } catch (JSONException err) {
                err.getMessage();
            }
       }
       catch(Exception erro){
        System.out.println("erro : " + erro.getMessage());   
       }
        return access_token;  
   }
   
     private String Tokenizacao(AmbienteEnum ambiente,String ClientID,String ClientSecret,String cardNumero){
         String number_token = null ;
         try{
            String urlParameters;
            String access_token = Autenticacao(ambiente, ClientID, ClientSecret);
             
            String url = ambiente.getUrl()+"/v1/tokens/card";
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            con.setRequestProperty("Authorization", "Bearer " + access_token);
            con.setRequestProperty("Accept-Encoding", "gzip");
             // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());

            //----------------parameters-----------------------
            Gson gson = new Gson();
            Tokenizacao tokenizacao = new Tokenizacao();
            Type TypeTokenizacao = new TypeToken<Tokenizacao>(){
            }.getType();
            tokenizacao.setCard_number(cardNumero);
            tokenizacao.setCustomer_id("customer_21081826");
            urlParameters = gson.toJson(tokenizacao,TypeTokenizacao);
            //----------------parameters-----------------------
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
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
                number_token = jsonobject.getString("number_token");

            } catch (JSONException err) {
                err.getMessage();
            }
            System.err.println("#########################################################");
            System.out.println("Resul Json"+response.toString());
            return number_token;
         }
         catch(Exception erro){
             
         }
      return number_token;
    }

  
}

