package GUIPROMPT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIAIPROMPT extends JFrame {
	
	 // Declare globally so buttons can access them
    JTextField txtName, txtAddress, txtType;

     GUIAIPROMPT() {

        // ===== LABEL WITH IMAGE =====
        ImageIcon img = new ImageIcon("barknee.png");// make sure image is in project folder
        JLabel lblImage = new JLabel(img);
        add(lblImage).setBounds(200, 50, 150, 150);
        JLabel lblTitle = new JLabel("Vehicle Booking System", img, JLabel.LEFT);
        lblTitle.setBounds(200, 10, 300, 50);
        lblTitle.setHorizontalTextPosition(JLabel.RIGHT); // text beside image
        add(lblTitle);

        // ===== FULLNAME =====
        JLabel lblName = new JLabel("Fullname");
        add(lblName).setBounds(30, 80, 100, 30);

        txtName = new JTextField();
        add(txtName).setBounds(30, 110, 160, 30);

        // ===== ADDRESS =====
        JLabel lblAddress = new JLabel("Address");
        add(lblAddress).setBounds(30, 150, 100, 30);

        txtAddress = new JTextField();
        add(txtAddress).setBounds(30, 180, 160, 30);

        // ===== TYPE =====
        JLabel lblType = new JLabel("Type");
        add(lblType).setBounds(30, 220, 100, 30);

        txtType = new JTextField();
        add(txtType).setBounds(30, 250, 160, 30);

        // ===== BUTTON ICON =====
        ImageIcon addIcon = new ImageIcon("add.png");

        // ===== ADD BUTTON =====
        JButton btnAdd = new JButton("Add", addIcon);
        add(btnAdd).setBounds(30, 300, 100, 40);
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setHorizontalTextPosition(JButton.RIGHT);

        // ===== UPDATE BUTTON =====
        JButton btnUpdate = new JButton("Update");
        add(btnUpdate).setBounds(140, 300, 100, 40);

        // ===== DELETE BUTTON =====
        JButton btnDelete = new JButton("Delete");
        add(btnDelete).setBounds(250, 300, 100, 40);

        // ===== BUTTON FUNCTIONS =====

        // ADD
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Added:\nName: " + txtName.getText() +
                        "\nAddress: " + txtAddress.getText() +
                        "\nType: " + txtType.getText());
            }
        });

        // UPDATE
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Updated Successfully!");
            }
        });

        // DELETE
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtAddress.setText("");
                txtType.setText("");
                JOptionPane.showMessageDialog(null, "Deleted!");
            }
        });

        // ===== FRAME SETTINGS =====
        setSize(700, 500);
        setLayout(null);
        setTitle("Vehicle Booking System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUIAIPROMPT();
    }
}
