import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BloodBankFrame extends JFrame {
    
    private Color c1, c2;
    private Font f1, f2;
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5,label6, label7, label8, label9, label10,
        label11,label12;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6 ,tf7,tf8;
    private JComboBox<String> cb1;
    private JRadioButton rb1, rb2;
    private ButtonGroup bg;
    private JButton bt1;
    private ImageIcon img;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scroll;

    public BloodBankFrame() {
        super("Blood-Bank Donor Management");
        setBounds(200, 100, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        c2 = new Color(139, 0, 0);     
        panel.setBackground(c2);
        panel.setLayout(null);

        f1 = new Font("Cambria", Font.BOLD, 28);
        f2 = new Font("Cambria", Font.PLAIN, 16);

        label1 = new JLabel("Blood-Bank Donor Management");
        c1 = Color.WHITE;                
        label1.setForeground(c1);
        label1.setFont(f1);
        label1.setBounds(200, 10, 600, 40);
        panel.add(label1);

        // Donor ID
        label2 = new JLabel("Donor ID");
        label2.setFont(f2);
        label2.setForeground(c1);
        label2.setBounds(20, 70, 150, 25);
        panel.add(label2);
        tf1 = new JTextField();
        tf1.setFont(f2);
        tf1.setBounds(230, 70, 200, 25);
        panel.add(tf1);

        // Name
        label3 = new JLabel("Name");
        label3.setFont(f2);
        label3.setForeground(c1);
        label3.setBounds(20, 110, 150, 25);
        panel.add(label3);
        tf2 = new JTextField();
        tf2.setFont(f2);
        tf2.setBounds(230, 110, 200, 25);
        panel.add(tf2);

        // Age
        label4 = new JLabel("Age");
        label4.setFont(f2);
        label4.setForeground(c1);
        label4.setBounds(20, 150, 150, 25);
        panel.add(label4);
        tf3 = new JTextField();
        tf3.setFont(f2);
        tf3.setBounds(230, 150, 60, 25);
        panel.add(tf3);

        // DOB
        label5 = new JLabel("DOB (YYYY-MM-DD)");
        label5.setFont(f2);
        label5.setForeground(c1);
        label5.setBounds(20, 190, 180, 25);
        panel.add(label5);
        tf4 = new JTextField();
        tf4.setFont(f2);
        tf4   .setBounds(230,190,200,25);
        panel.add(tf4);

        // Gender
        label9 = new JLabel("Gender");
        label9.setFont(f2);
        label9.setForeground(c1);
        label9.setBounds(20, 230, 150,25);;
        panel.add(label9);
        rb1 = new JRadioButton("Male");
        rb1.setFont(f2);
        rb1.setBackground(c2);
        rb1.setForeground(c1);
        rb1.setBounds(230, 230, 80, 25);
        panel.add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setFont(f2);
        rb2.setBackground(c2);
        rb2.setForeground(c1);
        rb2.setBounds(310, 230, 100, 25);
        panel.add(rb2);
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        // Blood Group
        label6 = new JLabel("Blood Group");
        label6.setFont(f2);
        label6.setForeground(c1);
        label6.setBounds(20, 270, 150, 25);
        panel.add(label6);
        cb1 = new JComboBox<>(new String[]{
            "A+","A-","B+","B-","AB+","AB-","O+","O-"
        });
        cb1.setFont(f2);
        cb1.setBounds(230, 270, 100, 25);
        panel.add(cb1);

        //Height
        label7 = new JLabel("Height (cm)");
        label7.setFont(f2);
        label7.setForeground(c1);
        label7.setBounds(20, 310, 150, 25);
        panel.add(label7);
        tf5 = new JTextField();
        tf5.setFont(f2);
        tf5.setBounds(230,310, 100, 25);
        panel.add(tf5);
		
		//Weight
        label8 = new JLabel("Weight (kg)");
        label8.setFont(f2);
        label8.setForeground(c1);
        label8.setBounds(20, 350, 150, 25);
        panel.add(label8);
        tf6 = new JTextField();
        tf6.setFont(f2);
        tf6.setBounds(230, 350, 100, 25);
        panel.add(tf6);

        // Last Donation
        label9 = new JLabel("Last Donation (YYYY-MM-DD)");
        label9.setFont(f2);
        label9.setForeground(c1);
        label9.setBounds(20, 390, 300, 25);
        panel.add(label9);
        tf7 = new JTextField();
        tf7.setFont(f2);
        tf7.setBounds(230,390,200,25);
        panel.add(tf7);

        // Contact
        label10 = new JLabel("Contact Number");
        label10.setFont(f2);
        label10.setForeground(c1);
        label10.setBounds(20, 430, 150, 25);
        panel.add(label10);
        tf8 = new JTextField();
        tf8.setFont(f2);
        tf8.setBounds(230, 430, 200, 25);
        panel.add(tf8);
        
        bt1 = new JButton("Add Donor");
        bt1.setFont(f2);
        bt1.setBackground(new Color(255, 255, 255));
        bt1.setBounds(280, 470, 150, 30);
        panel.add(bt1);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "ID", "Name", "Age", "Gender", "DOB",
            "Blood Group","Height", "Weight" ,"Last Donation", "Contact"
        });
        table = new JTable(model);
        scroll = new JScrollPane(table);
        scroll.setBounds(20, 520, 900, 260);
        panel.add(scroll);


        // Image 
        img = new ImageIcon("Blood.png"); 
        Image scaledImg = img.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        label10 = new JLabel(scaledIcon);
        label10.setBounds(550, 70, 320, 320);
        panel.add(label10);


       setContentPane(panel);

        bt1.addActionListener(e -> {
            try {
                String id = tf1.getText().trim();
                String name = tf2.getText().trim();
                int age = Integer.parseInt(tf3.getText().trim());
                LocalDate dob = LocalDate.parse(tf4.getText().trim());
                String gender = rb1.isSelected() ? "Male" : rb2.isSelected() ? "Female" : "";
                String blood = (String)cb1.getSelectedItem();
				double height  = Double.parseDouble(tf5.getText().trim());
                double weight  = Double.parseDouble(tf6.getText().trim());
                LocalDate last = LocalDate.parse(tf7.getText().trim());
                String contact = tf8.getText().trim();

                if (id.isEmpty() || name.isEmpty() || gender.isEmpty() || contact.isEmpty())
                    throw new IllegalArgumentException("ID, Name, Gender & Contact are required.");

                model.addRow(new Object[]{id, name, age, gender, dob, blood, height, weight, last, contact});

                tf1.setText(""); tf2.setText(""); tf3.setText(""); tf4.setText("");
                bg.clearSelection(); cb1.setSelectedIndex(0);
                tf5.setText(""); tf6.setText("");tf7.setText(""); tf8.setText("");
;
              }
                catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age, Height & Weight must be numeric.","Input Error", JOptionPane.ERROR_MESSAGE);
              }
                catch (DateTimeParseException ex) {
				JOptionPane.showMessageDialog(this, "Date must be YYYY-MM-DD.","Input Error", JOptionPane.ERROR_MESSAGE);
              }
                catch (IllegalArgumentException ex) {
			    JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
             }

         });
    }

}