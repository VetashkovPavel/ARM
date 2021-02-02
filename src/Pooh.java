import javafx.scene.input.InputMethodTextRun;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Pooh extends JFrame{

    private static final long serialVersionUID=1L;
    public JPanel panelRadio;
    public Pooh(){
    super("PoohOne job AGAT by PVetashkow");
    setDefaultCloseOperation (EXIT_ON_CLOSE);
    Container contain =getContentPane();
    contain.setLayout (new FlowLayout(FlowLayout.LEFT, 20,20));

        JPanel pane2=new JPanel();

        JTextField field1p=new JTextField (25);
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
        pane2.add(field3p);

        JButton butt1p=new JButton("ОТПРАВИТЬ заявку");
        butt1p.addActionListener(new Pooh.ActListener());


        pane2.add(butt1p);
        butt1p.setPreferredSize(new Dimension (170,85));
        butt1p.setBorderPainted(true);
        butt1p.setFocusPainted(false);
        butt1p.setContentAreaFilled(true);
        butt1p.setHorizontalAlignment(SwingConstants.CENTER);
        butt1p.setVerticalAlignment(SwingConstants.CENTER);

        getContentPane().setLayout(new GridLayout());
        contain.add( pane2, BorderLayout.CENTER);
        setSize(510,550);
        setVisible(true);


        JOptionPane.showMessageDialog(Pooh.this,
                new String[] {"Телефоны Отдела Информационных Технологий:",
                        "4861 - Леонид, Алексей, Павел", "4548 - Алексей",
                        "4457 - Владимир Борисович, руководитель подразделения"});
    }

    class ActListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String surname=new String(field1p.getText());
            String place=field2p.getText();
            String phone=field3p.getText();

            JOptionPane.showMessageDialog(Pooh.this,
                    "Заявка отправлена" );
        }
    }

   /* class ActListadmin implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Pooh.this,
                    "Отправлено, сохранено." );
        }
    }


    class ActListener2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Pooh.this,
                    "Настройки установлены" );
        }
    }

    class ActListener3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Pooh.this,
                    "Просмотр недоступен" );
        }
    }*/




    class ChngListener implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            Object src=e.getSource();
        }
    }
       public static void main (String[] args){
        new Pooh();
    }
}

