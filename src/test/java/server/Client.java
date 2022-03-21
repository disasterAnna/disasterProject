package server;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446/dif"))
                .header("Type", "Hello")
                .header("a","2")
                .header("b", "140")
                .build();

        HttpResponse<String> response=null;

        try{
            response=client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(response.body());

        getSone();

    }


    public static void getSone(){
        try {
            com.mashape.unirest.http.HttpResponse<String> response = Unirest
                    .get("http://localhost:4446/")
                    .header("Tylpe", "Hello")
                    .asString();
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
