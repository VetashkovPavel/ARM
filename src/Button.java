import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Button extends JFrame{
    private static final long serialVersionUID=1L;
    public JPanel panelRadio, panelRadio2, panelCheck;
    public JToggleButton butt2;
    public Button (){
        super("arm admin AGAT by PVetashkow");
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        Container contain =getContentPane();
        contain.setLayout (new FlowLayout(FlowLayout.LEFT, 20,20));

        JTabbedPane panel=new JTabbedPane();// почему не в заголовке?
        contain.add( panel, BorderLayout.CENTER);
        JPanel pane1=new JPanel();
        panel.add(pane1, "admin");
        JPanel pane2=new JPanel();
        panel.add(pane2, "client");
        setVisible(true);

        JPasswordField pass =new JPasswordField(20);
        pass.setEchoChar('*');
        contain.add(pass);

        JButton butt1=new JButton("ping host");
        butt1.addActionListener(new ActListener());
        butt1.addChangeListener(new ChngListener());
        butt1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                System.out.println("something ununderstandable");
            }});
        contain.add(butt1);
        butt1.setBorderPainted(true); //очертания кнопки
        butt1.setFocusPainted(false);//очертание названия
        butt1.setContentAreaFilled(true);//блики на кнопке

        JTextField field1=new JTextField ("ip or host name",20);
        contain.add(field1);



        JButton butt3=new JButton("set manual");
        butt3.addActionListener(new ActListener());
        butt3.addChangeListener(new ChngListener());
        butt3.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("abracadabra");
            }
        });
        contain.add(butt3);
        butt3.setBorderPainted(true);
        butt3.setFocusPainted(false);
        butt3.setContentAreaFilled(true);

        panelRadio=new JPanel(new GridLayout(0,1,0,5));
        panelRadio.setBorder(BorderFactory.createTitledBorder("Remote Desktop"));
        String[] names={" Active Directory","KSC server","Bolid server","something else"};
        ButtonGroup butgr=new ButtonGroup();
        for (int i=0;i<names.length;i++){
            JRadioButton radio=new JRadioButton (names[i]);
            panelRadio.add(radio);
            butgr.add(radio);
        }
        contain.add(panelRadio);

        panelRadio2=new JPanel(new GridLayout(0,1,0,5));
        panelRadio2.setBorder(BorderFactory.createTitledBorder("Web-interface"));
        String[] names2={" Kerio Control","MFU interface","Switch"};
        ButtonGroup butgr2=new ButtonGroup();
        for (int i=0;i<names2.length;i++){
            JRadioButton radio=new JRadioButton (names2[i]);
            panelRadio2.add(radio);
            butgr2.add(radio);
        }
        contain.add(panelRadio2);
        JButton butt4=new JButton("Remote Viewer");

        butt4.addActionListener(new ActListener());
        butt4.addChangeListener(new ChngListener());
        butt4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                //System.out.println("something ununderstandable");
            }});
        contain.add(butt4);
        butt4.setBorderPainted(true);
        butt4.setFocusPainted(false);
        butt4.setContentAreaFilled(true);

        butt2=new JToggleButton ("start to fix?", false);
        butt2.addActionListener(new ActListener());
        butt2.addChangeListener(new ChngListener());
        butt2.addItemListener(new ItemListener (){
            public void itemStateChanged(ItemEvent e){
                String text=(butt2.isSelected())?"accept (yes)":"refuse (no)";
                butt2.setText(text);
                panelCheck.setVisible(butt2.isSelected());
            }});
        contain.add(butt2);
        butt2.setBorderPainted(true);
        butt2.setFocusPainted(false);
        butt2.setContentAreaFilled(true);

        JButton buttfinal=new JButton("EXECUTE!");
        buttfinal.addActionListener(new ActListener());
        buttfinal.addChangeListener(new ChngListener());
        buttfinal.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent e){
                System.out.println("ok, working!");
            }
        });
        contain.add(buttfinal);
        buttfinal.setBorderPainted(true);
        buttfinal.setFocusPainted(false);
        buttfinal.setContentAreaFilled(true);
        buttfinal.setHorizontalAlignment(SwingConstants.LEFT); //выравнивание не пошло
        buttfinal.setVerticalAlignment(SwingConstants.BOTTOM); //не пошло

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
        new Button();
    }
}