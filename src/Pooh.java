import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pooh extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel panelRadio;
    public JTextField field1p, field2p, field3p, field4p;
    String surname, place, phone, broke, other;
    ButtonGroup butgrp;

    Socket socket;
    public Pooh() {
        super("Client AGAT by P.A.Vetashkow");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contain = getContentPane();
        contain.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JPanel pane2 = new JPanel();

        field1p = new JTextField(25);
        JLabel lab1p = new JLabel("Ваша Фамилия:");
        pane2.add(lab1p);
        pane2.add(field1p);


        /*panelRadio = new JPanel(new GridLayout(0, 2, 6, 4)); //табличное расположение
        panelRadio.setBorder(BorderFactory.createTitledBorder("Выберите неисправность"));
        // ButtonGroup butgrp=new ButtonGroup();// не понадобился, но пусть пока будет. потом удалю
        JRadioButton inet = new JRadioButton("Нет интернета", false);
        panelRadio.add(inet);
        if (inet.isSelected()) {
          //  if (broke == null) {
                broke = inet.getText();
          //  }
        }
        JRadioButton c = new JRadioButton("1C не работает", false);
        panelRadio.add(c);
        JRadioButton pk = new JRadioButton("Не включается ПК", false);
        panelRadio.add(pk);
        JRadioButton tlf = new JRadioButton("Не исправен телефон", false);
        panelRadio.add(tlf);
        JRadioButton soft = new JRadioButton("Установить ПО", false);
        panelRadio.add(soft);
        JRadioButton mfu = new JRadioButton("Заменить картридж в МФУ", false);
        panelRadio.add(mfu);
        JRadioButton printer = new JRadioButton("Проблемы с принтером", false);
        panelRadio.add(printer);
        JRadioButton technic = new JRadioButton("ТО системного блока", false);
        panelRadio.add(technic);
        JRadioButton remote = new JRadioButton("Помощь ч/з удаленный доступ", false);
        panelRadio.add(remote);


        pane2.add(panelRadio);*/

        panelRadio=new JPanel(new GridLayout(0,2,6,4)); //табличное расположение
        panelRadio.setBorder(BorderFactory.createTitledBorder("Выберите неисправность"));
        String[] brokens={" Нет Интернета или сети","1C не работает","Не включается ПК","Не работает телефон",
                "Установить программы", "Принтеры, сканеры, МФУ", "ТО системного блока", "Помощь ч/з удаленный доступ"};
        butgrp=new ButtonGroup();
        for (int i=0;i<brokens.length;i++){
            JRadioButton radio=new JRadioButton (brokens[i]);
            radio.setActionCommand(brokens[i]);
            panelRadio.add(radio);
            butgrp.add(radio);
        }
        pane2.add(panelRadio);

        field2p = new JTextField(30);
        JLabel lab2p = new JLabel("Ваше расположение:");
        pane2.add(lab2p);
        pane2.add(field2p);

        field3p = new JTextField(10);
        JLabel lab3p = new JLabel("Контактный телефон:");
        pane2.add(lab3p);
        pane2.add(field3p);

        field4p = new JTextField(35);
        JLabel lab4p = new JLabel("Примечание/комментарий/степень срочности:");
        pane2.add(lab4p);
        pane2.add(field4p);

        JButton butt1p = new JButton("ОТПРАВИТЬ заявку");
        butt1p.addActionListener(new ActListener());

        pane2.add(butt1p);
        butt1p.setPreferredSize(new Dimension(350, 85));
        butt1p.setBorderPainted(true);
        butt1p.setFocusPainted(false);
        butt1p.setContentAreaFilled(true);
        butt1p.setHorizontalAlignment(SwingConstants.CENTER);
        butt1p.setVerticalAlignment(SwingConstants.CENTER);

        JButton butt2p = new JButton("Показать телефоны ОИТ");
        butt2p.addActionListener(new ActListenertlf());
        pane2.add(butt2p);



        pane2.add(butt2p);
        butt2p.setPreferredSize(new Dimension(320, 25));
        butt2p.setBorderPainted(true);
        butt2p.setFocusPainted(false);
        butt2p.setContentAreaFilled(true);
        butt2p.setHorizontalAlignment(SwingConstants.CENTER);
        butt2p.setVerticalAlignment(SwingConstants.CENTER);

        JLabel lab5p = new JLabel("ОБРАТИТЕ ВНИМАНИЕ: в связи со стихийной");
        JLabel lab6p = new JLabel("загрузкой отдела (резкий всплеск возникших неисправностей), ");
        JLabel lab7p = new JLabel("Ваши заявки могут быть обработаны спустя некоторое время.");
        JLabel lab8p = new JLabel("Всплывающее окошко является подтверждением отправки заявки и");
        JLabel lab9p = new JLabel("дополнительной проверкой правильности указанной в ней информации");
        pane2.add(lab5p);
        pane2.add(lab6p);
        pane2.add(lab7p);
        pane2.add(lab8p);
        pane2.add(lab9p);

        getContentPane().setLayout(new GridLayout());
        contain.add(pane2, BorderLayout.CENTER);
        setSize(510, 535);
        setVisible(true);


        /*JOptionPane.showMessageDialog(Pooh.this,
                new String[]{"Телефоны Отдела Информационных Технологий:",
                        "4861 - Леонид, Алексей, Павел;",
                        "4548 - Алексей (1С:Предприятие);",
                        "4933 - Елена (1С:Предприятие, ЕСЭВМ);",
                        "4945 - Александр Антонович, Андрей - связь;",
                        "4457 - Владимир Борисович, руководитель подразделения."});*/
    }

    class ActListener implements ActionListener {
        public void actionPerformed(ActionEvent e) throws NullPointerException {
            surname = field1p.getText();
            place = field2p.getText();
            phone = field3p.getText();
            other = field4p.getText();
            broke = butgrp.getSelection().getActionCommand();
            try {
                socket = new Socket("PavelBook", 3345);                 //перевести на постоянный сервер
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());

               while (!socket.isOutputShutdown()) {

                    System.out.println("Started");
                    String text = broke+" у "+surname + " в " + place + ". Контактный тел. " + phone+", примечание: "+other;
                  dos.writeUTF(text);
                  dos.flush();
                    System.out.println("Передано: " + text);
                    socket.close();
                   break;
                }

            }
            catch(UnknownHostException g) {
                g.printStackTrace();
            }
            catch (IOException c) {
                c.printStackTrace();
            }
            catch (Exception a) {
                a.printStackTrace();
            }
            JOptionPane.showMessageDialog(Pooh.this,
                    new String[]{"Заявка отправлена, проверьте, пожалуйста, всё ли верно указано: ",
                            ""+broke +", пользователь "+ surname + ", отдел: " + place + ", тлф " + phone +". "+other+" ",
                            " Благодарим за обращение в ОИТ!"});

        }
    }

    class ActListenertlf implements ActionListener {
        public void actionPerformed(ActionEvent e) throws RuntimeException {
            JOptionPane.showMessageDialog(Pooh.this,
                    new String[]{"Телефоны Отдела Информационных Технологий:",
                            "4861 - Леонид, Алексей, Павел;",
                            "4548 - Алексей (1С:Предприятие);",
                            "4933 - Елена (1С:Предприятие, ЕСЭВМ);",
                            "4945 - Александр Антонович, Андрей - связь;",
                            "4457 - Владимир Борисович, руководитель подразделения."});


        }
    }

    public static void main(String[] args) {
        new Pooh();
    }
}

