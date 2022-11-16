package src;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {


    public static void manageMessages(Client client) throws IOException {
        Scanner ler = new Scanner(System.in);
        while(true){
            System.out.print("[Cliente]: ");
            String input = ler.nextLine();
            if (!input.equalsIgnoreCase("sair") && !input.equalsIgnoreCase("")){
                System.out.println("[Servidor]: " + client.communicate(input));
            }else{
                System.out.println("Conexao encerrada!");
                break;
            }
        }

    }
    public static void main(String[] args) {
        Client client = new Client();

        try{
            client.startConnection();
            manageMessages(client);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
