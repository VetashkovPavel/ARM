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
    public JTextField field1p, field2p, field3p;
    String surname, place, phone;
    public Pooh(){
    super("PoohOne job AGAT by PVetashkow");
    setDefaultCloseOperation (EXIT_ON_CLOSE);
    Container contain =getContentPane();
    contain.setLayout (new FlowLayout(FlowLayout.LEFT, 20,20));

        JPanel pane2=new JPanel();

        field1p=new JTextField (25);
        JLabel lab1p=new JLabel("Ваша Фамилия");
        pane2.add(lab1p);
        pane2.add(field1p);



        panelRadio=new JPanel(new GridLayout(0,2,6,4)); //табличное расположение
        panelRadio.setBorder(BorderFactory.createTitledBorder("Выберите неисправность"));
       // ButtonGroup butgrp=new ButtonGroup();// не понадобился, но пусть пока будет. потом удалю
        JRadioButton inet=new JRadioButton("Нет интернета", false);
        panelRadio.add(inet);
        JRadioButton c=new JRadioButton("1C не работает", false);
        panelRadio.add(c);
        JRadioButton pk=new JRadioButton("Не включается ПК", false);
        panelRadio.add(pk);
        JRadioButton tlf=new JRadioButton("Не исправен телефон", false);
        panelRadio.add(tlf);
        JRadioButton soft=new JRadioButton("Установить ПО", false);
        panelRadio.add(soft);
        JRadioButton mfu=new JRadioButton("Заменить картридж в МФУ", false);
        panelRadio.add(mfu);
        JRadioButton printer=new JRadioButton("Проблемы с принтером",false);
        panelRadio.add(printer);
        JRadioButton technic=new JRadioButton("ТО системного блока", false);
        panelRadio.add(technic);
        JRadioButton remote=new JRadioButton("Помощь ч/з удаленный доступ", false);
        panelRadio.add(remote);


        pane2.add(panelRadio);

        field2p=new JTextField (30);
        JLabel lab2p=new JLabel("Ваше расположение");
        pane2.add(lab2p);
        pane2.add(field2p);

        field3p=new JTextField(10);
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

    class ActListener implements ActionListener {
        public void actionPerformed(ActionEvent e)throws NullPointerException{
            try {
                if(surname == null){
                    surname=field1p.getText();}
                if (place==null){
                place = field2p.getText();}
                if (phone==null){
                phone = field3p.getText();}
           }
            catch (Exception a){
                a.printStackTrace();
            };

            JOptionPane.showMessageDialog(Pooh.this,
                    "Заявка отправлена ("+surname+", отдел: "+place+", тлф "+phone+")");
            //System.out.println(surname+" "+place+" "+phone);//не считывает
        }
    }

    /*class ChngListener implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            Object src=e.getSource();
        }
    }*/
       public static void main (String[] args) {
        new Pooh();
    }
}

