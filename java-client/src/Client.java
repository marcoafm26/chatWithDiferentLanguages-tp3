package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    String ip = "127.0.0.1";
    int port = 6345;
    private PrintWriter output;
    private BufferedReader input;
    public void startConnection() throws IOException {
        socket = new Socket(this.ip,this.port);
        input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        output = new PrintWriter(this.socket.getOutputStream(),true);
        System.out.println("Conexao iniciada com sucesso! \n");
    }

    public String communicate(String message){
        try{
          output.println(message);
          return input.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
