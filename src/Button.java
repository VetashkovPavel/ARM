import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Button extends JFrame {
    private static final long serialVersionUID=1L;
    public JPanel panelRadio, panelRadio2, panelRadio3, panelCheck;
    public JToggleButton butt5;
        public Button () throws IOException {
        super("arm admin AGAT by PVetashkow");
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        Container contain =getContentPane();
        contain.setLayout (new FlowLayout(FlowLayout.CENTER));

       JTabbedPane panel=new JTabbedPane(JTabbedPane.TOP);
        JPanel pane1=new JPanel();

        JPasswordField pass =new JPasswordField(35);
        pass.setEchoChar('*');
        pane1.add(pass);

        JButton butt1=new JButton("Ping host");
        butt1.addActionListener(new ActListener());
        butt1.addChangeListener(new ChngListener());
        butt1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
               }});
        pane1.add(butt1);
        butt1.setBorderPainted(true); //очертания кнопки
        butt1.setFocusPainted(false);//очертание названия
        butt1.setContentAreaFilled(true);//блики на кнопке

        JTextField field1=new JTextField ("ip или имя хоста",20);
        pane1.add(field1);

        JTextField field2=new JTextField ("ip или имя хоста",20);
        pane1.add(field2);

        JButton butt2=new JButton("Установить статику");
        butt2.addActionListener(new ActListener());
        butt2.addChangeListener(new ChngListener());
        butt2.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("Static");
            }
        });
        pane1.add(butt2);
        butt2.setBorderPainted(true);
        butt2.setFocusPainted(false);
        butt2.setContentAreaFilled(true);

        JButton butt3=new JButton("Сбросить настройки LAN");
        butt3.addActionListener(new ActListener());
        butt3.addChangeListener(new ChngListener());
        butt3.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("default lan");
            }
        });
        pane1.add(butt3);
        butt3.setBorderPainted(true);
        butt3.setFocusPainted(false);
        butt3.setContentAreaFilled(true);

        JTextField field3=new JTextField ("ip или MAC",20);
        pane1.add(field3);

        panelRadio3=new JPanel(new GridLayout(0,1,0,5));
        panelRadio3.setBorder(BorderFactory.createTitledBorder("Remote Desktop"));
        String[] names={" Active Directory","KSC server","Bolid server","1С database server"};
        ButtonGroup butgrp2=new ButtonGroup();
        for (int i=0;i<names.length;i++){
            JRadioButton radio=new JRadioButton (names[i]);
            panelRadio3.add(radio);
            butgrp2.add(radio);
        }
        pane1.add(panelRadio3);

        panelRadio2=new JPanel(new GridLayout(0,1,0,5));
        panelRadio2.setBorder(BorderFactory.createTitledBorder("Web-interface"));
        String[] names2={" Kerio Control Center","MFU interface","Switch interface", "запасная кнопка"};
        ButtonGroup butgr2=new ButtonGroup();
        for (int i=0;i<names2.length;i++){
            JRadioButton radio=new JRadioButton (names2[i]);
            panelRadio2.add(radio);
            butgr2.add(radio);
        }
        pane1.add(panelRadio2);

        JButton butt4=new JButton("Remote Viewer");
        butt4.addActionListener(new ActListener());
        butt4.addChangeListener(new ChngListener());
        butt4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                //System.out.println("something ");
            }});
        pane1.add(butt4);
        butt4.setBorderPainted(true);
        butt4.setFocusPainted(false);
        butt4.setContentAreaFilled(true);

        butt5=new JToggleButton ("Принимаем заявку?", false);
        butt5.addActionListener(new ActListener());
        butt5.addChangeListener(new ChngListener());
        butt5.addItemListener(new ItemListener (){
            public void itemStateChanged(ItemEvent e){
                String text=(butt5.isSelected())?"Да, принимаю":"Нет, отказываюсь";
                butt5.setText(text);
                panelCheck.setVisible(butt5.isSelected());
            }});
        pane1.add(butt5);
        butt5.setBorderPainted(true);
        butt5.setFocusPainted(false);
        butt5.setContentAreaFilled(true);

        JButton buttfinal=new JButton("EXECUTE!");
        buttfinal.addActionListener(new ActListadmin());
        buttfinal.addChangeListener(new ChngListener());
        buttfinal.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("ok, working!");
            }
        });
        pane1.add(buttfinal);
        buttfinal.setBorderPainted(true);
        buttfinal.setFocusPainted(false);
        buttfinal.setContentAreaFilled(true);
        buttfinal.setHorizontalAlignment(SwingConstants.CENTER);
        buttfinal.setPreferredSize(new Dimension (350, 45));

        setSize(450,550);
        setVisible(true);

        JPanel pane2=new JPanel(); //  -------------------POOH ONE WINDOW ---------------------------

        JTextField field1p=new JTextField ("Ваша Фамилия",30);
        pane2.add(field1p);

        panelRadio=new JPanel(new GridLayout(0,1,0,5));
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

        JTextField field2p=new JTextField ("Ваше расположение",30);

        pane2.add(field2p);

        JTextField field3p=new JTextField("Внутренний телефон");
        pane2.add(field3p);

        JButton butt1p=new JButton("ОТПРАВИТЬ заявку");
        butt1p.addActionListener(new Button.ActListener());
        butt1p.addChangeListener(new Button.ChngListener());
        butt1p.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){

            }});
        pane2.add(butt1p);
        butt1p.setPreferredSize(new Dimension (170,85));
        butt1p.setBorderPainted(true);
        butt1p.setFocusPainted(false);
        butt1p.setContentAreaFilled(true);
        butt1p.setHorizontalAlignment(SwingConstants.CENTER); //выравнивание не обязательно
        butt1p.setVerticalAlignment(SwingConstants.CENTER); //оно в пределах кнопки

        panel.add(pane2, "Client's  window");
        panel.add(pane1, "Admin only");
        setVisible(true);
        getContentPane().setLayout(new GridLayout());
        contain.add( panel, BorderLayout.CENTER);

        JTextArea broketext= new JTextArea (8,32);
        broketext.setEditable(false);
        broketext.setText(field1p.getText()+" _ "+field2p.getText()+" _ "+field3p.getText());
        pane1.add(broketext);

        JOptionPane.showMessageDialog(Button.this,
                new String[] {"Телефоны Отдела Информационных Технологий:",
                        "4861 - Леонид, Алексей, Павел", "4548 - Алексей",
                        "4457 - Владимир Борисович, руководитель подразделения"});
    }

    class ActListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Button.this,
                    "Заявка отправлена" );
        }
    }

    class ActListadmin implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Button.this,
                    "Отправлено, сохранено." );
        }
    }

    class ChngListener implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            Object src=e.getSource();
              }
    }
    public static void main (String[] args) throws IOException{
    new Button();
    }
}