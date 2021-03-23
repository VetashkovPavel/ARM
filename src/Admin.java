import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Admin extends JFrame {
    private static final long serialVersionUID=1L;
    public JPanel panelRadio2, panelRadio3, panelCheck;
    public JToggleButton butt5;
    public JTextField field1, field2,field3, field4;
    public String ping, stat, check, trial, broke;
    public File pingfile;
    public Admin () throws IOException {
        super("arm admin AGAT by PVetashkow");
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        Container contain =getContentPane();
        contain.setLayout (new FlowLayout(FlowLayout.CENTER));

       //JTabbedPane panel=new JTabbedPane(JTabbedPane.TOP);
        JPanel pane1=new JPanel();

        BorderLayout border=new BorderLayout();
        pane1.setLayout(border);

        JPanel pane3=new JPanel();

        pane1.setVisible(true);

        pane1.add("North", pane3); //почему name??????

        JPanel pane4=new JPanel();

        JButton butt1=new JButton("Ping host");
        butt1.addActionListener(new Admin.ActListenerping());
        butt1.addChangeListener(new Admin.ChngListener());
        butt1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
            }});
        pane4.add(butt1);
        butt1.setBorderPainted(true); //очертания кнопки
        butt1.setFocusPainted(false);//очертание названия
        butt1.setContentAreaFilled(true);//блики на кнопке

         field1=new JTextField (16);
        JLabel lab1=new JLabel("IP или имя хоста");
        pane4.add(lab1);
        pane4.add(field1);

        JButton butt2=new JButton("Установить   статику");
        butt2.addActionListener(new Admin.ActListenerstat());
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

        field2=new JTextField (16);
        JLabel lab2=new JLabel("IP или имя хоста");
        pane4.add(lab2);
        pane4.add(field2);

        JButton butt3=new JButton("Просмотр настроек LAN");
        butt3.addActionListener(new Admin.ActListenercheck());
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

        field3=new JTextField (16);
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

        field4=new JTextField (16);
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

        contain.add(pane1, "Admin only");
        setVisible(true);
        getContentPane().setLayout(new GridLayout());

        JTextArea broketext= new JTextArea (8,32); // запилить в ActionListener, иначе считывает дефизы
        broketext.setEditable(false);
        broketext.setText(broke);
        pane4.add(broketext);


    }


    class ActListener implements ActionListener{
        public void actionPerformed(ActionEvent e) throws RuntimeException{
            JOptionPane.showMessageDialog(Admin.this,
                    "Запускаем Remote Admin" );
            try{
            Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Users\\oit17\\Desktop\\Radmin.exe");}
            catch (RuntimeException | IOException c){c.printStackTrace();}
        }
    }

   class ActListadmin implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Admin.this,
                    "ВЫПОЛНЕНО, сохранено." ); //executing button
        }
    }

    class ActListenerping implements ActionListener {
        public void actionPerformed(ActionEvent e)throws NullPointerException{

            try{
                if (ping==null) {
                    ping=field1.getText();}

                BufferedWriter bwrtr =new BufferedWriter (new FileWriter("D:\\pingfile.bat"));// файл создает, но
                if (pingfile.exists()) {
                    System.out.println("File will be rewrited");// не записывает в него
                }
                else {
                    pingfile.createNewFile();
                }
                String str="ping ";
                    bwrtr.write(str+ping);
                    bwrtr.close();
                JOptionPane.showMessageDialog( Admin.this, " Пингуем хост "+ping);
                Process proc = Runtime.getRuntime().exec("cmd /C start D:\\pingfile.bat");
            }
            catch (Exception a){
                a.printStackTrace();
            }
        }
    }

    class ActListenerstat implements ActionListener{
        public void actionPerformed(ActionEvent e) throws NullPointerException{
            try {
                if (stat==null){stat=field2.getText();}

            JOptionPane.showMessageDialog(Admin.this,
                    "Настройки установлены "+stat );}
            catch (Exception a){a.printStackTrace();}
        }
    }

    class ActListenercheck implements ActionListener{
        public void actionPerformed(ActionEvent e) throws NullPointerException{
            try {
                if (check==null){check=field3.getText();}

            JOptionPane.showMessageDialog(Admin.this,
                    "Подключаемся к "+check);}
            catch(Exception b){b.printStackTrace();}
        }
    }

    class ActListener41 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                if (trial==null){trial=field4.getText();}
                Process proc = Runtime.getRuntime().exec("cmd /C start C:\\Users\\oit17\\Desktop\\batping.bat");
            }
            catch (Exception a){
                a.printStackTrace();
            }
            JOptionPane.showMessageDialog(Admin.this,
                    "Демонстрационный период у "+trial+" будет сброшен. Подключайтесь через минуту" );
        }
    }

   class ChngListener implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            Object src=e.getSource();
        }
    }
    public static void main (String[] args) throws Exception{
        new Admin();
    }
}
