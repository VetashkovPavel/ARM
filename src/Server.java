import jdk.nashorn.internal.objects.Global;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.UnknownHostException;
import java.util.Date;

public class Server {

    public static String entry, text;

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
                entry = input.readUTF();
                System.out.println("прочитано: " + entry);
                Date date = new Date();
                BufferedWriter bwrtr = new BufferedWriter(new FileWriter("D:\\list.txt", true));
                bwrtr.write(date.toString() + " " + entry + "\r\n");
                bwrtr.close();
                client.close();
                out.flush();
                out.close();

                Socket second = new Socket("oit17", 3030);
                DataOutputStream dos = new DataOutputStream(second.getOutputStream());
                Socket first = new Socket("PavelBook", 3030);
                DataOutputStream dos1 = new DataOutputStream(first.getOutputStream());
                Socket third = new Socket("oit13", 3030);
                DataOutputStream dos2 = new DataOutputStream(third.getOutputStream());

                while (!second.isOutputShutdown()) {
                    System.out.println("started");
                    text = entry;
                    dos.writeUTF(text);
                    dos.flush();
                    dos.close();
                    System.out.println("передано _ " + text);
                    // break;
                    second.close();
                }

                while (!first.isOutputShutdown()) {
                    System.out.println("started");
                    //text = entry;
                    dos1.writeUTF(text);
                    dos1.flush();
                    dos1.close();
                    System.out.println("передано _ " + text);
                    //break;
                    first.close();
                }

                while (!third.isOutputShutdown()) {
                    System.out.println("started");
                    //String text = entry;
                    dos2.writeUTF(text);
                    dos2.flush();
                    dos2.close();
                    System.out.println("передано _ " + text);
                    //break;
                    third.close();
                }

            }

        } catch (
                Exception g) {
            g.printStackTrace();
        }
    }
}