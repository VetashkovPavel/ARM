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
                BufferedWriter bwrtr = new BufferedWriter(new FileWriter("C:\\ARM\\list.txt", true));
                bwrtr.write(date.toString() + " " + entry + "\r\n");
                bwrtr.close();
                text=entry;
                client.close();
                out.flush();
                out.close();

                try (Socket first = new Socket("OIT1", 3030);
                DataOutputStream dos1 = new DataOutputStream(first.getOutputStream())){

                if (first.isConnected()| !first.isClosed()) {
                    System.out.println("started");
                    dos1.writeUTF(text);
                    dos1.flush();
                    dos1.close();
                    System.out.println("передано _ " + text);
                    first.close();
                }
                else
                {
                    continue;
                }}
                catch (Exception q){
                    q.printStackTrace();}

                try (Socket second = new Socket("oit17", 3030);
                DataOutputStream dos = new DataOutputStream(second.getOutputStream())){

                if (second.isConnected()| !second.isClosed() ) {
                    System.out.println("started");
                    dos.writeUTF(text);
                    dos.flush();
                    dos.close();
                    System.out.println("передано _ " + text);
                    second.close();
                }
                else{
                    continue;
                }}
                catch (Exception w){w.printStackTrace();}

                try (Socket third = new Socket("oit13", 3030);
                DataOutputStream dos2 = new DataOutputStream(third.getOutputStream())){

                if (third.isConnected()| !third.isClosed()) {
                    System.out.println("started");
                    dos2.writeUTF(text);
                    dos2.flush();
                    dos2.close();
                    System.out.println("передано _ " + text);
                    third.close();
                }
                else {
                    continue;
                }
            }
            catch (Exception r){r.printStackTrace();}


            try (Socket fourth = new Socket("OASUP20", 3030);
                 DataOutputStream dos = new DataOutputStream(fourth.getOutputStream())){

                if (fourth.isConnected()| !fourth.isClosed() ) {
                    System.out.println("started");
                    text = entry;
                    dos.writeUTF(text);
                    dos.flush();
                    dos.close();
                    System.out.println("передано _ " + text);
                    fourth.close();
                }
                else{
                    continue;
                }}
            catch (Exception w){w.printStackTrace();}

                try (Socket fifth = new Socket("OASUP2", 3030);
                     DataOutputStream dos = new DataOutputStream(fifth.getOutputStream())){

                    if (fifth.isConnected()| !fifth.isClosed() ) {
                        System.out.println("started");
                        dos.writeUTF(text);
                        dos.flush();
                        dos.close();
                        System.out.println("передано _ " + text);
                        fifth.close();
                    }
                    else{
                        continue;
                    }}
                catch (Exception w){w.printStackTrace();}

                try (Socket sixs = new Socket("ADMIN", 3030);
                     DataOutputStream dos = new DataOutputStream(sixs.getOutputStream())){

                    if (sixs.isConnected()| !sixs.isClosed() ) {
                        System.out.println("started");
                        dos.writeUTF(text);
                        dos.flush();
                        dos.close();
                        System.out.println("передано _ " + text);
                        sixs.close();
                    }
                    else{
                        continue;
                    }}
                catch (Exception w){w.printStackTrace();}

                try (Socket seventh = new Socket("oit9", 3030);
                     DataOutputStream dos = new DataOutputStream(seventh.getOutputStream())){

                    if (seventh.isConnected()| !seventh.isClosed() ) {
                        System.out.println("started");
                        dos.writeUTF(text);
                        dos.flush();
                        dos.close();
                        System.out.println("передано _ " + text);
                        seventh.close();
                    }
                    else{
                        continue;
                    }}
                catch (Exception w){w.printStackTrace();}

            }

        } catch (
                Exception g) {
            g.printStackTrace();
        }
    }
}