import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
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

       JTextField field1p=new JTextField ("your name&surname",12);
        contain.add(field1p);

        JTextField field2p=new JTextField ("where are you?");
        contain.add(field2p);

        JTextField field3p=new JTextField("your cell phone");
        contain.add(field3p);

        panelRadio=new JPanel(new GridLayout(0,1,0,5));
        panelRadio.setBorder(BorderFactory.createTitledBorder("What had happend"));
        String[] names={" No i-net connection","1C is dead","Whole PC is dead","Cup of Coffee"};
        ButtonGroup butgrp=new ButtonGroup();
        for (int i=0;i<names.length;i++){
            JRadioButton radio=new JRadioButton (names[i]);
            panelRadio.add(radio);
            butgrp.add(radio);
        }
        contain.add(panelRadio);

        JButton butt1p=new JButton("send");
        butt1p.addActionListener(new Pooh.ActListener());
        butt1p.addChangeListener(new Pooh.ChngListener());
        butt1p.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                            }});
        contain.add(butt1p);
        butt1p.setBorderPainted(true);
        butt1p.setFocusPainted(false);
        butt1p.setContentAreaFilled(true);
        butt1p.setPreferredSize(new Dimension(100,100));
        //butt1p.setBackground(Color.CYAN); //подобрать не "вырвиглаз"
        setSize(400,400);
        setVisible(true);
    }
    class ActListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Pressed => "+e.getActionCommand() );
        }
    }
    class ChngListener implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            Object src=e.getSource();
            System.out.println("object was changed  "+src.getClass()); //зачем это? и вывод, и отсылка.
        }
    }
    public static void main (String[] args){
        new Pooh();
    }
}

