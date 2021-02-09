import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{
        try (ServerSocket server=new ServerSocket(3345)){
            Socket client=server.accept();
            System.out.println("Соединение разрешено");
            DataOutputStream out =new DataOutputStream(client.getOutputStream());
            System.out.println("Поток записи создан");
            DataInputStream input =new DataInputStream(client.getInputStream());
            System.out.println("поток чтения создан");

            while(/*!client.isClosed()*/1==1){
                System.out.println("сервер считывает");
                String entry=input.readUTF();
                System.out.println("прочитано: "+entry);

                if(entry.equalsIgnoreCase(" name")){
                    out.writeUTF("something "+entry);
                    out.flush();
                    input.close();
                    out.close();
                    client.close();
                    break;
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
