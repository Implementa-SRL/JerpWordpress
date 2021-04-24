package Networking;

import OAuth.OAuth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Collections;

public class NetworkInterface {

    String host = "";
    String path = "";
    String consumerKey = "";
    String consumerSecret = "";
    OkHttpClient client;

    public NetworkInterface(String host, String path, String consumerKey, String consumerSecret){

        //init data
        this.host = host;
        this.path = path;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;

        //init client engine
        client = new OkHttpClient();
    }


    public String getProduct(){
        // generate oauth header
        OAuth auth = new OAuth(consumerKey, consumerSecret, "", "");

        String header = auth.generateHeader("GET", host+path, Collections.emptyMap());

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", header)
                .url(host+path)
                .get()
                .build();


        Response response = null;

        try {
            response = client.newCall(request).execute();

            var body = response.body().string();

            return body;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
