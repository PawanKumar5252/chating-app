package watapp2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class Watapp2 extends JFrame {

    JLabel l1, l2, keyl3;
    JTextField f1, f2, key;
    // ImageIcon i1;
    static JTextArea a1, a2, a3, f1dec;
    JFileChooser fi;
    String fname;
    JButton b1, b2;
    JPanel p1;

    static DataInputStream Din;
    static DataOutputStream Dout;

    public void hai() {
        if (f1.equals("a")) {
            f2.setText("b");
        }

    }

    Watapp2() {

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(45, 76, 78));
        p1.setBounds(0, 0, 350, 40);
        add(p1);

// l1=profile image;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("watapp2/icon/download" + ".jpg")); //profile video Icon.
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(5, 5, 30, 30);
        p1.add(l1);

        mymouse m = new mymouse();
        l1.addMouseListener(m);
        p1.add(l1);

        f1dec = new JTextArea();
        f1dec.setBounds(5, 360, 260, 30);
        f1dec.setEditable(false);
        add(f1dec);

//        f1 = new JTextField();
//        f1.setBounds(5, 360, 260, 30);
//        add(f1);
//        f2=new JTextField();
//        f2.setBounds(5,360,260,30);
//        add(f2);
        a3 = new JTextArea();
        a3.setBounds(5, 395, 260, 30);
        add(a3);

        key = new JTextField();
        key.setBounds(5, 425, 260, 30);
        add(key);

        keyl3 = new JLabel("key");
        keyl3.setBounds(270, 425, 70, 30);
        add(keyl3);

        a1 = new JTextArea();
        a1.setBounds(5, 45, 330, 300);
        a1.setBackground(Color.green);
        a1.setEditable(false);
        add(a1);

//        a2 = new JTextArea();
//        a2.setBounds(170, 45, 165, 300);
//        a2.setBackground(Color.red);
//        a2.setEditable(false);
//        add(a2);
        b1 = new JButton("SAND");
        b1.setBounds(270, 390, 70, 30);
        add(b1);
        b1.addActionListener(new my());

        b2 = new JButton("dec");
        b2.setBounds(270, 360, 70, 30);
        add(b2);
        b2.addActionListener(new my());

        setLayout(null);
        setSize(350, 500);
    }

    class mymouse extends MouseAdapter {

        public void mouseClicked(MouseEvent ee) {
            try {
                //w2icon w2 = new w2icon();
                // w2.setVisible(true);
                fi = new JFileChooser();
                fi.showOpenDialog(null);
                File f = fi.getSelectedFile();
                fname = f.getAbsolutePath();

                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(fname));
                Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                l1 = new JLabel(i3);
                l1.setBounds(5, 5, 30, 30);
                p1.add(l1);

            } catch (Exception a) {
            }
        }

    }

    class my implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int j;
            int i, k = 0;
            String st = key.getText();
            byte data1[] = st.getBytes();
            int ai1[] = new int[data1.length];
            for (i = 0; i < data1.length; i++) {
                ai1[i] = data1[i];
                ai1[i] = data1[i];
                k = k + (ai1[i] * i);
            }
            String STR = e.getActionCommand();
            String str4;
            str4 = "";
            try {
                if (STR == "SAND") {
                    String str = a3.getText();
                    byte data[] = str.getBytes();
                    a1.setText(a1.getText() + "\t\n" + str);
                    int a[] = new int[data.length];
                    String s2[] = new String[data.length];
                    for (j = 0; j < data.length; j++) {
                        a[j] = data[j];
                        String s1 = Integer.toString(a[j] ^ k);
                        s2[j] = s1 + ",";
                        str4 = str4 + s2[j];
                    }

                    String str6 = str4;
                    char ca[] = str6.toCharArray();
                    String c = "";
                    String str5[] = new String[ca.length];
                    String str7 = "";
                    int j1, j3;
                    //System.out.print(str4);
                    for (j1 = 0; j1 < ca.length; j1++) {

                        if (ca[j1] == '0') {
                            c = "a";
                        }
                        if (ca[j1] == '1') {
                            c = "b";
                        }
                        if (ca[j1] == '2') {
                            c = "c";
                        }
                        if (ca[j1] == '3') {
                            c = "d";
                        }
                        if (ca[j1] == '4') {
                            c = "e";
                        }
                        if (ca[j1] == '5') {
                            c = "f";
                        }
                        if (ca[j1] == '6') {
                            c = "g";
                        }
                        if (ca[j1] == '7') {
                            c = "h";
                        }
                        if (ca[j1] == '8') {
                            c = "i";
                        }
                        if (ca[j1] == '9') {
                            c = "j";
                        }
                        if (ca[j1] == ',') {
                            c = "k";
                        }
                        str7 = str7 + c;
                    }               
                    //System.out.print(str7);
                    Dout.writeUTF(str7);
                    a3.setText(null);
                }   
                   
                ///////////////////////////

                if (STR == "dec") {
                    String z = f1dec.getText();
                    String st6 = z;
                    char[] ca1 = st6.toCharArray();
                    String c1 = "";
                    String st7 = "";
                    String sy="";
                    int d1;
                    for (d1 = 0; d1 < ca1.length; d1++) {

                        if (ca1[d1] == 'a') {
                            c1 = "0";
                        }
                        if (ca1[d1] == 'b') {
                            c1 = "1";
                        }
                        if (ca1[d1] == 'c') {
                            c1 = "2";
                        }
                        if (ca1[d1] == 'd') {
                            c1 = "3";
                        }
                        if (ca1[d1] == 'e') {
                            c1 = "4";
                        }
                        if (ca1[d1] == 'f') {
                            c1 = "5";
                        }
                        if (ca1[d1] == 'g') {
                            c1 = "6";
                        }
                        if (ca1[d1] == 'h') {
                            c1 = "7";
                        }
                        if (ca1[d1] == 'i') {
                            c1 = "8";
                        }
                        if (ca1[d1] == 'j') {
                            c1 = "9";
                        }
                        if (ca1[d1] == 'k') {
                            c1 = ",";
                        }
                        st7 = st7 + c1;
                       sy=st7;
                    }
                   
                      System.out.print("dec=" + st7);  
                    char ci[] = sy.toCharArray();
                    int l1;
                    //int b[] = new int[ci.length];
                    for (l1= 0; l1 < ci.length; l1++) {
                         
                        String stri = "";
                        while (l1 < ci.length && ci[l1] != ',') {
                            stri = stri + ci[l1];
                            l1++;
                        }
                        if (stri.length() > 0) {
                            int b3 = Integer.parseInt(stri);
                            int bi1 = b3 ^ k;
                            char ch = (char) bi1;
                            // System.out.print(" hari oim" );
                            a1.setText(a1.getText() + "" + ch);
                            f1dec.setText(null);
                            // a3.r
                            stri = null;
                        }
                    }
                }
              } catch (Exception ae) {}
        }
    }

    public static void main(String[] args) {
        Watapp2 w = new Watapp2();
        w.setVisible(true);

        try {
            Socket ss = new Socket("LocalHost", 234);

            InputStream is = ss.getInputStream();
            OutputStream os = ss.getOutputStream();

            Din = new DataInputStream(is);
            Dout = new DataOutputStream(os);

            String msg = " ";

            while (msg != null) {

                msg = Din.readUTF();
                String stri = new String(msg);
                f1dec.setText(f1dec.getText() + "" + stri);

            }

            ss.close();
        } catch (IOException xe) {
        }
    }

}
