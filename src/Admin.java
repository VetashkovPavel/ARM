import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Admin extends JFrame {
    private static final long serialVersionUID=1L;
    public JPanel panelRadio, panelRadio2, panelRadio3, panelCheck;
    public JToggleButton butt5;
    public Admin () throws IOException {
        super("arm admin AGAT by PVetashkow");
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        Container contain =getContentPane();
        contain.setLayout (new FlowLayout(FlowLayout.CENTER));

        JTabbedPane panel=new JTabbedPane(JTabbedPane.TOP);
        JPanel pane1=new JPanel();

        BorderLayout border=new BorderLayout();
        pane1.setLayout(border);

        JPanel pane3=new JPanel();
        JPasswordField pass =new JPasswordField(40);
        pass.setEchoChar('*');
        pane3.add(pass);
        pane3.setVisible(true);

        pane1.add("North", pane3); //почему name??????

        JPanel pane4=new JPanel();

        JButton butt1=new JButton("Ping host");
        butt1.addActionListener(new Admin.ActListener1());
        butt1.addChangeListener(new Admin.ChngListener());
        butt1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
            }});
        pane4.add(butt1);
        butt1.setBorderPainted(true); //очертания кнопки
        butt1.setFocusPainted(false);//очертание названия
        butt1.setContentAreaFilled(true);//блики на кнопке

        JTextField field1=new JTextField (16);
        JLabel lab1=new JLabel("IP или имя хоста");
        pane4.add(lab1);
        pane4.add(field1);

        JButton butt2=new JButton("Установить   статику");
        butt2.addActionListener(new Admin.ActListener2());
        butt2.addChangeListener(new Admin.ChngListener());
        butt2.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("Static");
            }
        });
        pane4.add(butt2);
        butt2.setBorderPainted(true);
        butt2.setFocusPainted(false);
        butt2.setContentAreaFilled(true);

        JTextField field2=new JTextField (16);
        JLabel lab2=new JLabel("IP или имя хоста");
        pane4.add(lab2);
        pane4.add(field2);

        JButton butt3=new JButton("Просмотр настроек LAN");
        butt3.addActionListener(new Admin.ActListener3());
        butt3.addChangeListener(new Admin.ChngListener());
        butt3.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("default lan");
            }
        });
        pane4.add(butt3);
        butt3.setBorderPainted(true);
        butt3.setFocusPainted(false);
        butt3.setContentAreaFilled(true);

        JTextField field3=new JTextField (16);
        JLabel lab3=new JLabel("IP, имя MAC хоста");
        pane4.add(lab3);
        pane4.add(field3);

        JButton butt41=new JButton("Trial reset RViewer");
        butt41.addActionListener(new Admin.ActListener41());
        butt41.addChangeListener(new Admin.ChngListener());
        butt41.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("default lan");  // Лёхин батник
            }
        });
        pane4.add(butt41);
        butt41.setBorderPainted(true);
        butt41.setFocusPainted(false);
        butt41.setContentAreaFilled(true);

        JTextField field4=new JTextField (16);
        JLabel lab4=new JLabel("IP, имя MAC хоста");
        pane4.add(lab4);
        pane4.add(field4);

        panelRadio3=new JPanel(new GridLayout(0,1,0,5));
        panelRadio3.setBorder(BorderFactory.createTitledBorder("Remote Desktop"));
        String[] names={" Active Directory","KSC server","Bolid server","1С database server"};
        ButtonGroup butgrp2=new ButtonGroup();
        for (int i=0;i<names.length;i++){
            JRadioButton radio=new JRadioButton (names[i]);
            panelRadio3.add(radio);
            butgrp2.add(radio);
        }
        pane4.add(panelRadio3);

        panelRadio2=new JPanel(new GridLayout(0,1,0,5));
        panelRadio2.setBorder(BorderFactory.createTitledBorder("Web-interface"));
        String[] names2={" Kerio Control Center","MFU interface","Switch interface", "запасная кнопка"};
        ButtonGroup butgr2=new ButtonGroup();
        for (int i=0;i<names2.length;i++){
            JRadioButton radio=new JRadioButton (names2[i]);
            panelRadio2.add(radio);
            butgr2.add(radio);
        }
        pane4.add(panelRadio2);

        JButton butt4=new JButton("Remote Viewer"); //сделать выпадающее меню адреса
        butt4.addActionListener(new Admin.ActListener());
        butt4.addChangeListener(new Admin.ChngListener());
        butt4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
            }});
        pane4.add(butt4);
        butt4.setBorderPainted(true);
        butt4.setFocusPainted(false);
        butt4.setContentAreaFilled(true);

        butt5=new JToggleButton ("Принимаем заявку?", false);
        butt5.addActionListener(new Admin.ActListener());
        butt5.addChangeListener(new Admin.ChngListener());
        butt5.addItemListener(new ItemListener (){ //...............нужен change listener
            public void itemStateChanged(ItemEvent e){
                String text=(butt5.isSelected())?"Да, принимаю  ":"Нет, отказываюсь";
                butt5.setText(text);
                panelCheck.setVisible(butt5.isSelected());
            }});
        pane4.add(butt5);
        butt5.setBorderPainted(true);
        butt5.setFocusPainted(false);
        butt5.setContentAreaFilled(true);

        JButton buttfinal=new JButton("EXECUTE!");
        buttfinal.addActionListener(new Admin.ActListadmin());

        pane4.add(buttfinal);
        buttfinal.setBorderPainted(true);
        buttfinal.setFocusPainted(false);
        buttfinal.setContentAreaFilled(true);
        buttfinal.setHorizontalAlignment(SwingConstants.CENTER);
        buttfinal.setPreferredSize(new Dimension (350, 45));

        pane1.add(pane4);

        setSize(510,550);
        setVisible(true);

        JPanel pane2=new JPanel(); //  -------------------POOH ONE WINDOW ---------------------------

        /*JTextField field1p=new JTextField (25);
        JLabel lab1p=new JLabel("Фамилия");
        pane2.add(lab1p);
        pane2.add(field1p);


        panelRadio=new JPanel(new GridLayout(0,2,6,4)); //табличное расположение
        panelRadio.setBorder(BorderFactory.createTitledBorder("Выберите неисправность"));
        String[] brokens={" Нет Интернета или сети","1C не работает","Не включается ПК","не работает телефон",
                "Установить ПО", "Заменить картридж в МФУ", "ТО системного блока", "Помощь ч/з удаленный доступ"};
        ButtonGroup butgrp=new ButtonGroup();
        for (int i=0;i<brokens.length;i++){
            JRadioButton radio=new JRadioButton (brokens[i]);
            panelRadio.add(radio);
            butgrp.add(radio);
        }
        pane2.add(panelRadio);

        JTextField field2p=new JTextField (30);
        JLabel lab2p=new JLabel("Ваше расположение");
        pane2.add(lab2p);
        pane2.add(field2p);

        JTextField field3p=new JTextField(10);
        JLabel lab3p=new JLabel("Внутренний телефон");
        pane2.add(lab3p);
        pane2.add(field3p);*/

       // JButton butt1p=new JButton("ОТПРАВИТЬ заявку");
       // butt1p.addActionListener(new Button.ActListener());


        //pane2.add(butt1p);
       // butt1p.setPreferredSize(new Dimension (170,85));
       // butt1p.setBorderPainted(true);
       // butt1p.setFocusPainted(false);
      //  butt1p.setContentAreaFilled(true);
      //  butt1p.setHorizontalAlignment(SwingConstants.CENTER); //выравнивание не обязательно
      //  butt1p.setVerticalAlignment(SwingConstants.CENTER); //оно в пределах кнопки

        /*panel.add(pane2, "Client's  window");
        panel.add(pane1, "Admin only");
        setVisible(true);
        getContentPane().setLayout(new GridLayout());
        contain.add( panel, BorderLayout.CENTER);

        JTextArea broketext= new JTextArea (8,32); // запилить в ActionListener, иначе считывает дефизы
        broketext.setEditable(false);
        broketext.setText(field1p.getText()+" _ "+field2p.getText()+" _ "+field3p.getText());
        pane4.add(broketext);

        JOptionPane.showMessageDialog(Button.this,
                new String[] {"Телефоны Отдела Информационных Технологий:",
                        "4861 - Леонид, Алексей, Павел", "4548 - Алексей",
                        "4457 - Владимир Борисович, руководитель подразделения"});
    }*/

    /*class ActListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Admin.this,
                    "Заявка отправлена" );
        }
    }*/

  /*  class ActListadmin implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Admin.this,
                    "Отправлено, сохранено." );
        }
    }*/

    class ActListener1 implements ActionListener{// на кнопке PING висит
        public void actionPerformed(ActionEvent e){
            try{
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Users\\Pavel\\Desktop\\labafilesA33.bat");
            }
            catch (Exception a){
                a.printStackTrace();
            }
        }
    }

    class ActListener2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Admin.this,
                    "Настройки установлены" );
        }
    }

    class ActListener3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Admin.this,
                    "Просмотр недоступен" );
        }
    }

    class ActListener41 implements ActionListener{// на кнопке PING висит
        public void actionPerformed(ActionEvent e){
            try{
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Users\\oit17\\Desktop\\batping.bat");
            }
            catch (Exception a){
                a.printStackTrace();
            }
            JOptionPane.showMessageDialog(Admin.this,
                    "Демонстрационный период сброшен. Подключайтесь через минуту" );
        }
    }

    class ChngListener implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            Object src=e.getSource();
        }
    }
    public static void main (String[] args) throws IOException{
        new Admin();
    }
}
}
