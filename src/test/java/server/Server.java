package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {

        //Задаём порт
        //int portNum = 4446;

        int portNum = Integer.parseInt(System.getProperty("ServerPort"));

        //System.out.println(portNum);
        //Объявляем переменную server
        HttpServer server = null;

        //Создаём сервак, оборачиваем в try-catch
        try {
            server = HttpServer.create();
            server.bind(new InetSocketAddress(portNum), 0); //bind - привязать
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Создаём контекст для сервака
        HttpContext context = server.createContext("/", new Server.EchoHandler());
        HttpContext context2 = server.createContext("/help", new Server.EchoHandler2());

        //Контекст для домашнего задания
        HttpContext context3 = server.createContext("/sum", new Server.EchoHandler3());
        server.createContext("/dif", new Server.EchoHandler4());


        server.setExecutor(null);
        server.start();
    }

    static class EchoHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            StringBuilder builder = new StringBuilder();

            ArrayList<String> headers = new ArrayList<>();

            exchange.getRequestHeaders().values().forEach(s-> headers.add(s.toString()));
            exchange.getRequestHeaders().values().forEach(o-> System.out.println("header = " + o));

            for (String a : headers){
                if (a.contains("Hello")){
                    builder.append("Hello too, my friends!"); //append - присобачивает к строке ещё кусок
                }
            }

            builder.append("GoGoGo!!!!!!!!!!!!!!");
            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
            exchange.close();
        }
    }


    static class EchoHandler2 implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            StringBuilder builder = new StringBuilder();

            ArrayList<String> headers = new ArrayList<>();
            exchange.getRequestHeaders().values().forEach(s-> headers.add(s.toString()));
            exchange.getRequestHeaders().values().forEach(o-> System.out.println("header = " + o));

            for (String a : headers){
                if (a.contains("Hello")){
                    builder.append("Hello too, my friends!");
                }
            }

            builder.append("Help?..");
            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
            exchange.close();
        }
    }

    static class EchoHandler3 implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            List<String> a = exchange.getRequestHeaders().get("a");
            List<String> b = exchange.getRequestHeaders().get("b");

            Integer aHeader = Integer.parseInt(a.get(0));
            Integer bHeader = Integer.parseInt(b.get(0));
            Integer sum = aHeader + bHeader;


            byte[] bytes = sum.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
            exchange.close();
        }
    }

    static class EchoHandler4 implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            List<String> a = exchange.getRequestHeaders().get("a");
            List<String> b = exchange.getRequestHeaders().get("b");

            Integer aHeader = Integer.parseInt(a.get(0));
            Integer bHeader = Integer.parseInt(b.get(0));
            Integer dif = aHeader - bHeader;


            byte[] bytes = dif.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
            exchange.close();
        }
    }
}
