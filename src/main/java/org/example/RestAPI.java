package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import java.net.ResponseCache;
import static io.restassured.RestAssured.given;
public class RestAPI {
//  getting the real USD Value
    public double USDRealValue(){
        double USDValue;
        Response response = given()
                .baseUri("https://api.apilayer.com/")
                .header("apikey", "CRZe7J86FE7s8LasExyGSe6115Cz5Yur")
                .get("/fixer/latest?base=USD&symbols=ILS");
        if(response.getStatusCode() != 200){
            System.out.println("Could not get rate from API using default rate");
            USDValue = 3.52;
        }
        else{
            JSONObject obj = new JSONObject(response.asString());
            USDValue = obj.getJSONObject("rates").getDouble("ILS");
        }
        return USDValue;
    }
//  getting the real ILS Value
    public double ILSRealValue(){
        double ILSValue;
        Response response = given()
                .baseUri("https://api.apilayer.com/")
                .header("apikey", "CRZe7J86FE7s8LasExyGSe6115Cz5Yur")
                .get("/fixer/latest?base=ILS&symbols=USD");
        if (response.getStatusCode() != 200){
            System.out.println("Could not get rate from API using default rate");
            ILSValue = 0.28;
        }
        else {
            JSONObject obj = new JSONObject(response.asString());
            ILSValue = obj.getJSONObject("rates").getDouble("USD");
        }
        return ILSValue;

       // keep them for correct syntax
//        System.out.println( response.getStatusCode());
//        System.out.println( response.asString());
//        System.out.println( response.getBody().asString());
    }
}
