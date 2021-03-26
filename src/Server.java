import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.UnknownHostException;

public class Server {
   // Socket second;

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(3345)) {
            while (true) {
            Socket client = server.accept();
            System.out.println("Соединение разрешено");
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("Поток записи создан");
            DataInputStream input = new DataInputStream(client.getInputStream());
            System.out.println("поток чтения создан");
            System.out.println("сервер считывает");
            String entry = input.readUTF();
            System.out.println("прочитано: " + entry);
            BufferedWriter bwrtr = new BufferedWriter(new FileWriter("D:\\list.txt", true));
            bwrtr.write(" " + entry + "\r\n");
            bwrtr.close();
            client.close();

                if (entry.equalsIgnoreCase(" name")) {
                    out.writeUTF("something " + entry);
                    out.flush();
                    input.close();
                    out.close();
                    client.close();
                     //break;
                      //}
                    //  }
        /*} catch (IOException e) {
            e.printStackTrace();
        } */ //проба

                    Socket second = new Socket("localhost", 3030);
                    // }
                    DataOutputStream dos = new DataOutputStream(second.getOutputStream());

                    while (!second.isOutputShutdown()) {

                        System.out.println("started");
                        String text = entry;
                        dos.writeUTF(text);
                        dos.flush();
                        System.out.println("text is _ " + text);
                        break;
                    }
                }}
    }
        catch(
    UnknownHostException g)

    {
        g.printStackTrace();
    }
}
}