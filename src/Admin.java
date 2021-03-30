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

public class Admin extends JFrame {
    private static final long serialVersionUID = 1L;
    public JPanel panelRadio2, panelRadio3, panelCheck;
public static JComboBox<String>box1, box2;
    public JTextField field1, field2, field3, field4;
    private  String ping, stat, check, trial, broke;
    public File pingfile;
    private static JTextArea broketext;
    private static String entry;

    public Admin() throws IOException {
        super("arm admin AGAT by PVetashkow");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contain = getContentPane();
        contain.setLayout(new FlowLayout(FlowLayout.CENTER));

        //JTabbedPane panel=new JTabbedPane(JTabbedPane.TOP);
        JPanel pane1 = new JPanel();

        BorderLayout border = new BorderLayout();
        pane1.setLayout(border);

        JPanel pane3 = new JPanel();

        pane1.setVisible(true);

        pane1.add("North", pane3); //почему name??????

        JPanel pane4 = new JPanel();

        JButton butt1 = new JButton("Ping host");
        butt1.addActionListener(new Admin.ActListenerping());
        butt1.addChangeListener(new Admin.ChngListener());
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

        JButton butt2 = new JButton("Установить IP динамически");
        butt2.addActionListener(new Admin.ActListenerstat());
        butt2.addChangeListener(new Admin.ChngListener());
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
        pane4.add(field2);

        JButton butt3 = new JButton("Просмотр настроек LAN");
        butt3.addActionListener(new Admin.ActListenercheck());
        butt3.addChangeListener(new Admin.ChngListener());
        butt3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("default lan");
            }
        });
        pane4.add(butt3);
        butt3.setBorderPainted(true);
        butt3.setFocusPainted(false);
        butt3.setContentAreaFilled(true);

        field3 = new JTextField(16);
        JLabel lab3 = new JLabel("IP, имя MAC хоста");
        pane4.add(lab3);
        pane4.add(field3);

        JButton butt41 = new JButton("Trial reset RViewer");
        butt41.addActionListener(new Admin.ActListener41());
        butt41.addChangeListener(new Admin.ChngListener());
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
        pane4.add(field4);


       /* String[] names = {"Active Directory", "KSC server", "Bolid server", "1С database server"};
        JComboBox box1 = new JComboBox<String>(names);
        pane4.add(box1);

        JButton butt5 = new JButton("Удал.раб.столы");
        butt5.addActionListener(new Admin.ActListRemote());
        butt5.addChangeListener(new Admin.ChngListener());
        butt5.addItemListener(new ItemListener() { //...............нужен change listener
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt5);
        butt5.setBorderPainted(true);
        butt5.setFocusPainted(false);
        butt5.setContentAreaFilled(true);

        String[] names2 = {"Kerio Control Center", "MFU interface", "Switch interface", "запасная кнопка"};
        JComboBox box2 = new JComboBox<String>(names2);
        pane4.add(box2);
        JButton butt6 = new JButton("WEB-Interfaces");
        butt6.addActionListener(new Admin.ActListWeb());
        butt6.addChangeListener(new Admin.ChngListener());
        butt6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt6);
        butt6.setBorderPainted(true);
        butt6.setFocusPainted(false);
        butt6.setContentAreaFilled(true);*/

        JButton butt4 = new JButton("Remote Viewer");
        butt4.addActionListener(new Admin.ActListener());
        butt4.addChangeListener(new Admin.ChngListener());
        butt4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        pane4.add(butt4);
        butt4.setBorderPainted(true);
        butt4.setFocusPainted(false);
        butt4.setContentAreaFilled(true);



        /*JButton buttfinal = new JButton("EXECUTE!");
        buttfinal.addActionListener(new Admin.ActListadmin());

        pane4.add(buttfinal);
        buttfinal.setBorderPainted(true);
        buttfinal.setFocusPainted(false);
        buttfinal.setContentAreaFilled(true);
        buttfinal.setHorizontalAlignment(SwingConstants.CENTER);
        buttfinal.setPreferredSize(new Dimension(350, 45));*/

        pane1.add(pane4);

        setSize(510, 550);
        setVisible(true);

        contain.add(pane1, "Admin only");
        setVisible(true);
        getContentPane().setLayout(new GridLayout());
        broketext = new JTextArea(20, 35);
        broketext.setEditable(false);

        pane4.add(new JScrollPane(broketext));


    }

    class ActListener implements ActionListener {
        public void actionPerformed(ActionEvent e) throws RuntimeException {
            JOptionPane.showMessageDialog(Admin.this,
                    "Запускаем Remote Admin");
            try {
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Radmin.exe");
            } catch (RuntimeException | IOException c) {
                c.printStackTrace();
            }
        }
    }

   /* class ActListRemote implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try {
            if (box1.getSelectedItem().equals("Active Directory")){ JOptionPane.showMessageDialog(Admin.this,
                    "Login srv Pass");}
            else if (box1.getSelectedItem().equals("KSC server")){ JOptionPane.showMessageDialog(Admin.this,
                    "Login srv19 Pass");}
            else if (box1.getSelectedItem().equals("Bolid server")){ JOptionPane.showMessageDialog(Admin.this,
                    "Login  Pass srv19INV");}
            else if (box1.getSelectedItem().equals("1С database server")){ JOptionPane.showMessageDialog(Admin.this,
                    "Звони 4548");}
            }
            catch (NullPointerException c) {
                c.printStackTrace();
            }

               // Process proc = Runtime.getRuntime().exec("cmd /C start C:\\555.exe");

        }
    }

    class ActListWeb implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try{
              //  box2=(JComboBox)e.getSource();

            String web=(String)box2.getSelectedItem();
                if (web.equals("Kerio Control Center")){ JOptionPane.showMessageDialog(Admin.this,
                        "проработать");}
                else if (web.equals("MFU interface")){ JOptionPane.showMessageDialog(Admin.this,
                        "проработать");}
                else if (web.equals("Switch interface")){ JOptionPane.showMessageDialog(Admin.this,
                        "проработать");}
                else if (web.equals("запасная кнопка")){ JOptionPane.showMessageDialog(Admin.this,
                        "проработать");}
            }
            catch (NullPointerException c) {
                c.printStackTrace();
            }

               // Process proc = Runtime.getRuntime().exec("cmd /C start C:\\555.exe");

        }
    }*/

  /*  class ActListadmin implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(Admin.this,
                    "ВЫПОЛНЕНО, сохранено."); //executing button
        }
    }*/

    class ActListenerping implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {

            try {
                //if (ping == null) {
                    ping = "ping "+field1.getText();
                //}

                BufferedWriter bwrtr = new BufferedWriter(new FileWriter("D:\\pingfile.bat", false));// файл создает, но
                //if (pingfile.exists()) {
                //    System.out.println("File will be rewrited");// не записывает в него
               // } else {
                //    pingfile.createNewFile();
               // }
               // String str = "ping ";
                bwrtr.write( ping);

                JOptionPane.showMessageDialog(Admin.this, " Пингуем хост " + field1.getText());
                Process proc = Runtime.getRuntime().exec("cmd /C start D:\\pingfile.bat");
               bwrtr.flush();
               bwrtr.close();

            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }

    class ActListenerstat implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try {
                if (stat == null) {
                    stat = field2.getText();
                }

                JOptionPane.showMessageDialog(Admin.this,
                        "Настройки установлены " + stat);
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }

    class ActListenercheck implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            try {
                if (check == null) {
                    check = field3.getText();
                }

                JOptionPane.showMessageDialog(Admin.this,
                        "Подключаемся к " + check);
            } catch (Exception b) {
                b.printStackTrace();
            }
        }
    }

    class ActListener41 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (trial == null) {
                    trial = field4.getText();
                }
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Users\\oit17\\Desktop\\batping.bat");
            } catch (Exception a) {
                a.printStackTrace();
            }
            JOptionPane.showMessageDialog(Admin.this,
                    "Демонстрационный период у " + trial + " будет сброшен. Подключайтесь через минуту");
        }
    }

    class ChngListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Object src = e.getSource();
        }
    }



    public static void main(String[] args) throws Exception {
        new Admin();
        while (true) {
            try (ServerSocket srv = new ServerSocket(3030)) {
                Socket second = srv.accept();
                System.out.println("Соединение разрешено");
                DataOutputStream out = new DataOutputStream(second.getOutputStream());
                System.out.println("Поток записи создан");
                DataInputStream input = new DataInputStream(second.getInputStream());
                System.out.println("поток чтения создан");

                while (true) {
                    System.out.println("сервер считывает");
                    String entry = input.readUTF();
                    System.out.println("прочитано: " + entry);
                    input.close();
                    out.flush();
                    out.close();
                    second.close();
                    //JOptionPane.showMessageDialog(null, entry);
                    broketext.setText(broketext.getText()+"\r\n"+entry);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}