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



       JTextField field1b=new JTextField ("your name&surname",30);
        contain.add(field1b);

        panelRadio=new JPanel(new GridLayout(0,1,0,5));
        panelRadio.setBorder(BorderFactory.createTitledBorder("What had happend"));
        String[] names={" No I-net connection","1C is dead","Whole PC is dead","Cup of Coffee"};
        ButtonGroup butgrb=new ButtonGroup();
        for (int i=0;i<names.length;i++){
            JRadioButton radio=new JRadioButton (names[i]);
            panelRadio.add(radio);
            butgrb.add(radio);
        }
        contain.add(panelRadio);

        JTextField field2b=new JTextField ("where are you?");
        contain.add(field2b);

        JTextField field3b=new JTextField("your cell phone");
        contain.add(field3b);

        JButton butt1b=new JButton("send");

        butt1b.addActionListener(new Pooh.ActListener());
        butt1b.addChangeListener(new Pooh.ChngListener());
        butt1b.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                            }});
        contain.add(butt1b);
        butt1b.setBorderPainted(true);
        butt1b.setFocusPainted(false);
        butt1b.setContentAreaFilled(true);
        butt1b.setSize(75,75);
        butt1b.setHorizontalAlignment(SwingConstants.LEFT); //выравнивание не пошло
        butt1b.setVerticalAlignment(SwingConstants.BOTTOM); //не пошло

        setSize(550,400);
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

