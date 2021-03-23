import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        try (Socket socket = new Socket("localhost", 3345)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            while (!socket.isOutputShutdown()) {
                if (br.ready()) {
                    System.out.println("started");
                    String text = br.readLine();
                    dos.writeUTF(text);
                    dos.flush();
                    System.out.println("text is _ " + text);

                    if (dis.read() > -1) {
                        System.out.println("nothing");
                        String in = dis.readUTF();
                        System.out.println("or " + in);
                    }
                   break;
                    }
            //catch(UnknownHostException e){
              //          e.printStackTrace();
                  // }

                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
