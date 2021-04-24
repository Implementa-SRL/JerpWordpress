import Networking.NetworkInterface;

public class JerpWordpressCore {

    public static void main(String[] args) {

        var host = "http://localhost:8888";
        var path = "/necrologi/wp-json/wc/v3/products/categories";
        var consumerKey = "ck_7ff824c9dbc17e089d1f8dac73e92188d8e5b5d1";
        var consumerSecret = "cs_bd1c7b5a3ba8a4ece12edeca134119a45de5d10e";

        //init networking layer
        NetworkInterface networkInterface = new NetworkInterface(host,path,consumerKey,consumerSecret);

        var response = networkInterface.getProduct();

        System.out.println(response);


    }


}
