import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


import java.awt.*;
        import java.awt.event.ItemEvent;
        import java.awt.event.ActionEvent;
        import java.awt.event.ItemListener;
        import java.awt.event.ActionListener;
        import java.io.BufferedWriter;
        import java.io.*;
        import java.io.DataInputStream;
        import java.io.DataOutputStream;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;
        import javax.swing.*;
        import javax.swing.event.ChangeEvent;
        import javax.swing.event.ChangeListener;

public class AdminOit13 extends JFrame {
    private static final long serialVersionUID = 1L;
    public static JComboBox<String>box1, box2;
    public JTextField field1, field2, field3, field4;
    private  String ping, stat, check, trial, broke;
    public File pingfile;
    private static JTextArea broketext;
    private static String entry;

    public AdminOit13() throws IOException {
        super("Admin oit13 AGAT by P.A.Vetashkow");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contain = getContentPane();
        contain.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel pane1 = new JPanel();

        BorderLayout border = new BorderLayout();
        pane1.setLayout(border);

        JPanel pane3 = new JPanel();

        pane1.setVisible(true);

        pane1.add("North", pane3); //почему name??????

        JPanel pane4 = new JPanel();

        JButton butt1 = new JButton("Ping host");
        butt1.addActionListener(new AdminOit13.ActListenerping());
        butt1.addChangeListener(new AdminOit13.ChngListener());
        butt1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt1);
        butt1.setBorderPainted(true); //очертания кнопки
        butt1.setFocusPainted(false);//очертание названия
        butt1.setContentAreaFilled(true);//блики на кнопке

        field1 = new JTextField(16);
        JLabel lab1 = new JLabel("IP или имя хоста");
        pane4.add(lab1);
        pane4.add(field1);

        /*JButton butt2 = new JButton("Установить IP динамически");
        butt2.addActionListener(new AdminOit13.ActListIp());
        butt2.addChangeListener(new AdminOit13.ChngListener());
        butt2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Dynamic");
            }
        });
        pane4.add(butt2);
        butt2.setBorderPainted(true);
        butt2.setFocusPainted(false);
        butt2.setContentAreaFilled(true);

        field2 = new JTextField(16);
        JLabel lab2 = new JLabel("IP или имя хоста");
        pane4.add(lab2);
        pane4.add(field2);*/

        JButton butt3 = new JButton("Директория -Базы ESET Endpoint Antivirus-");
        butt3.addActionListener(new AdminOit13.ActListNod());
        butt3.addChangeListener(new AdminOit13.ChngListener());
        butt3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("default lan");
            }
        });
        pane4.add(butt3);
        butt3.setBorderPainted(true);
        butt3.setFocusPainted(false);
        butt3.setContentAreaFilled(true);/*

        field3 = new JTextField(16);
        JLabel lab3 = new JLabel("IP, имя MAC хоста");
        pane4.add(lab3);
        pane4.add(field3);

        JButton butt41 = new JButton("Trial reset RViewer");
        butt41.addActionListener(new AdminOit13.ActListTrial());
        butt41.addChangeListener(new AdminOit13.ChngListener());
        butt41.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("default lan");  // Лёхин батник
            }
        });
        pane4.add(butt41);
        butt41.setBorderPainted(true);
        butt41.setFocusPainted(false);
        butt41.setContentAreaFilled(true);

        field4 = new JTextField(16);
        JLabel lab4 = new JLabel("IP, имя MAC хоста");
        pane4.add(lab4);
        pane4.add(field4);*/


        JButton butt5 = new JButton("Active Directory");
        butt5.addActionListener(new AdminOit13.ActListAD());
        butt5.addChangeListener(new AdminOit13.ChngListener());
        butt5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt5);
        butt5.setBorderPainted(true);
        butt5.setFocusPainted(false);
        butt5.setContentAreaFilled(true);


        JButton butt6 = new JButton("Kaspersky SecCenter");
        butt6.addActionListener(new AdminOit13.ActListKSC());
        butt6.addChangeListener(new AdminOit13.ChngListener());
        butt6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt6);
        butt6.setBorderPainted(true);
        butt6.setFocusPainted(false);
        butt6.setContentAreaFilled(true);

        JButton butt4 = new JButton("Remote Administrator");
        butt4.addActionListener(new AdminOit13.ActListener());
        butt4.addChangeListener(new AdminOit13.ChngListener());
        butt4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt4);
        butt4.setBorderPainted(true);
        butt4.setFocusPainted(false);
        butt4.setContentAreaFilled(true);


        JButton bolid = new JButton("Bolid Server");
        bolid.addActionListener(new AdminOit13.ActListBolid());
        bolid.addChangeListener(new AdminOit13.ChngListener());
        bolid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(bolid);
        bolid.setBorderPainted(true);
        bolid.setFocusPainted(false);
        bolid.setContentAreaFilled(true);


        JButton kerio = new JButton("Kerio Control Center");
        kerio.addActionListener(new AdminOit13.ActListKerio());

        pane4.add(kerio);
        kerio.setBorderPainted(true);
        kerio.setFocusPainted(false);
        kerio.setContentAreaFilled(true);
        kerio.setHorizontalAlignment(SwingConstants.CENTER);
        kerio.setPreferredSize(new Dimension(450, 45));

        pane1.add(pane4);

        setSize(555, 570);
        setVisible(true);

        contain.add(pane1, "Admin only");
        setVisible(true);
        getContentPane().setLayout(new GridLayout());
        broketext = new JTextArea(22, 48);
        broketext.setEditable(false);

        pane4.add(new JScrollPane(broketext));


    }

    class ActListener implements ActionListener {
        public void actionPerformed(ActionEvent e) throws RuntimeException {
            JOptionPane.showMessageDialog(AdminOit13.this,
                    "Запускаем Remote Admin");
            try {
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Radmin.exe");
            } catch (RuntimeException | IOException c) {
                c.printStackTrace();
            }
        }
    }

    class ActListAD implements ActionListener {
        public void actionPerformed(ActionEvent e) throws RuntimeException {
            try {
                JOptionPane.showMessageDialog(AdminOit13.this,
                        "Подключаемся к удаленному рабочему столу ActiveDirectory");
                Process proc = Runtime.getRuntime().exec("cmd /C start mstsc.exe /v server5");
            }
            catch (RuntimeException | IOException r) {
                r.printStackTrace();
            }
        }
    }

    class ActListKSC implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try{
                JOptionPane.showMessageDialog(AdminOit13.this,
                        "Подключаемся к удаленному рабочему столу Лаборатории Касперского");
                Process proc = Runtime.getRuntime().exec("cmd /C start mstsc.exe /v srvksc");
            }
            catch (RuntimeException | IOException z) {
                z.printStackTrace();
            }
        }
    }

    class ActListKerio implements ActionListener {
        public void actionPerformed(ActionEvent e) throws RuntimeException{

            try{JOptionPane.showMessageDialog(AdminOit13.this,
                    "Открываем web-interface Kerio Control Center");
                Process proc = Runtime.getRuntime().exec("cmd /C start D:\\batkerio.bat");}

            catch (RuntimeException | IOException p){
                p.printStackTrace();}
        }
    }


    class ActListBolid implements ActionListener {
        public void actionPerformed(ActionEvent e) throws RuntimeException{

            try{JOptionPane.showMessageDialog(AdminOit13.this,
                    "Подключаемся к удаленному рабочему столу системы Bolid");
                Process proc = Runtime.getRuntime().exec("cmd /C start mstsc.exe /v srvbolid");}

            catch (RuntimeException | IOException p){
                p.printStackTrace();}
        }
    }


    class ActListenerping implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {

            try {
                ping = "ping "+field1.getText();


                BufferedWriter bwrtr = new BufferedWriter(new FileWriter("D:\\pingfile.bat", false));// файл создает, но

                bwrtr.write( ping);

                JOptionPane.showMessageDialog(AdminOit13.this, " Пингуем хост " + field1.getText());
                Process proc = Runtime.getRuntime().exec("cmd /C start D:\\pingfile.bat");
                bwrtr.flush();
                bwrtr.close();

            } catch (NullPointerException | IOException a) {
                a.printStackTrace();
            }
        }
    }

    /*class ActListIp implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try {
                if (stat == null) {
                    stat = field2.getText();
                }

                JOptionPane.showMessageDialog(AdminOIT1.this,
                        "Настройки установлены " + stat);
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }*/

    class ActListNod implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try {
                Process proc = Runtime.getRuntime().exec("cmd /C start D:nod.bat");


                JOptionPane.showMessageDialog(AdminOit13.this,
                        "Открываю папку баз NOD ");
            } catch (Exception b) {
                b.printStackTrace();
            }
        }
    }

    /*class ActListTrial implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (trial == null) {
                    trial = field4.getText();
                }
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Users\\oit17\\Desktop\\batping.bat");
            } catch (Exception a) {
                a.printStackTrace();
            }
            JOptionPane.showMessageDialog(AdminOit13.this,
                    "Демонстрационный период у " + trial + " будет сброшен. Подключайтесь через минуту");
        }
    }*/

    class ChngListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Object src = e.getSource();
        }
    }

    public static void main(String[] args) throws Exception {
        new AdminOit13();
        while (true) {
            try (ServerSocket srv = new ServerSocket(3030)) {
                Socket third = srv.accept();
                System.out.println("Соединение разрешено");
                DataOutputStream out = new DataOutputStream(third.getOutputStream());
                System.out.println("Поток записи создан");
                DataInputStream input = new DataInputStream(third.getInputStream());
                System.out.println("поток чтения создан");

                while (true) {
                    System.out.println("сервер считывает");
                    String entry = input.readUTF();
                    System.out.println("прочитано: " + entry);
                    input.close();
                    out.flush();
                    out.close();
                    third.close();
                    broketext.setText(broketext.getText()+"\r\n"+"\r\n"+entry);
                    //JOptionPane.showMessageDialog(null, entry);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}