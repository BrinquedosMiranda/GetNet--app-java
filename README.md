# getnet-java
Veja a Wiki :https://github.com/BrinquedosMiranda/getnet-skd-java/wiki
#
**Como começar**

Criando a sua conta no Sandbox

https://developers.getnet.com.br/login

Obtenção de chaves de autenticação

Suas chaves de autenticação para o ambiente do Sandbox são disponibilizadas na aba de configurações em Identificação da API.

Na classe Credenciar
você vai colocar o seu "setSeller_id","ClientID","ClientSecret"

#
**Verificação de cartão**
```java
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
```
#
**Pagamento Cartão**
```java
    Credenciar cred = new Credenciar();
        //----------------Requisição contendo os dados para pagamento com cartão de crédito--
        int amount = 125000303;//79 900 30 3
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
        
        //----------------credit------------------------------------
        TransactionEnum transaction = TransactionEnum.INSTALL_NO_INTEREST;
        int Number_installments = 3;
        String soft_descriptor = "BRINQUEDOSMIRANDA";
         //----------------credit------------------------------------
                
         //----------------dados do cartao----------------------------
        String cardNumber = "5155901222280001";
        BrandEnum brand = BrandEnum.MASTERCARD;
        String cardholder_name = "JOAO DA SILVA";
         String expiration_month = "12";
        String expiration_year = "20";
        String security_code = "123";
        double valor = Double.parseDouble(""+amount);
        //----------------dados do cartao----------------------------
      //BigDecimal valor12 = new BigDecimal(amount).setScale(2, BigDecimal.ROUND_UP);
      
        PagamentoCreditoHTTP pagamentoCredito = new PagamentoCreditoHTTP(Credenciar.ambiente, Credenciar.ClientID, Credenciar.ClientSecret,  Credenciar.setSeller_id, amount,
                order_id, customer_id, first_name, last_name, email, documentEnun, document_number, phone_number, street, number, 
                complement, district, city, state, postal_code, session, phone_number_shipping, street_address, number_address,
                complement_address, districtt_address, city_address, state_address, postal_code_address, transaction, Number_installments, 
                soft_descriptor, cardNumber, brand, cardholder_name, expiration_month, expiration_year, security_code);
       
    }
```
#

**Pagamento Boleto**
```java
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
```
#
