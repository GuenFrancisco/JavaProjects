package pakedz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HotelReservationSystemGUI extends JFrame {

	JTextField txtName, txtRoom , txtCheckIn, txtCheckOut;
	JButton btnAdd, btnUpdate, btnDelete, btnExit;
	
	JTable table;
	DefaultTableModel model;
	
	HotelReservationSystemGUI () {
		
		setTitle("Hotel Reservation System");
		setLayout(null);
		setSize(800,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		loadFromFile();
		
		JLabel lblTitle = new JLabel("== HOTEL RESERVATION ==");
		add(lblTitle).setBounds(240,30, 400, 30);
		lblTitle.setFont(new Font("Arial", Font.BOLD,20 ));
		add(lblTitle);
		
		JLabel lblName = new JLabel("Guest Name");
		add(lblName).setBounds(30,490, 100, 30);
		txtName = new JTextField();
		add(txtName).setBounds(30, 520, 130, 25);
		
		JLabel lblRoom = new JLabel("Room Type");
		add(lblRoom).setBounds(190 ,490, 100, 30);
		txtRoom = new JTextField();
		add(txtRoom).setBounds(190, 520, 130, 25);
		
		JLabel lblCheckIn = new JLabel("Check In Date");
		add(lblCheckIn).setBounds(350 ,490, 100, 30);
		txtCheckIn = new JTextField();
		add(txtCheckIn).setBounds(350, 520, 130, 25);
		
		JLabel lblCheckOut = new JLabel("Check Out Date");
		add(lblCheckOut).setBounds(510 ,490, 100, 30);
		txtCheckOut = new JTextField();
		add(txtCheckOut).setBounds(510, 520, 130, 25);

		
		btnAdd = new JButton("Add");
		add(btnAdd).setBounds(650, 550, 115 ,25);
		
		btnUpdate = new JButton("Update");
		add(btnUpdate).setBounds(650,580, 115 ,25);
		
		btnDelete = new JButton("Delete");
		add(btnDelete).setBounds(650, 610, 115 ,25);
		
		btnExit = new JButton("Exit");
		add(btnExit).setBounds(650, 640, 115 ,25);
		
		
		String [] columns = {"Guest Name", "Room Type","Check In Date", "Check Out Date" };
		
		model = new DefaultTableModel(columns,0);
		table = new JTable(model);
		
		JScrollPane sp = new JScrollPane(table);
		add(sp).setBounds(25, 80, 735, 380);
		
		btnAdd.addActionListener(e -> {
		    if (validateFields()) {
		        model.addRow(new Object[]{
		                txtName.getText(),
		                txtRoom.getText(),
		                txtCheckIn.getText(),
		                txtCheckOut.getText()
		                
		        });
		        
		        saveToFile();
		        clearFields();
		        
		    }
		});
		
		btnUpdate.addActionListener(e -> {
		    int row = table.getSelectedRow();

		    if (row == -1) {
		        JOptionPane.showMessageDialog(this, "Select a row first!");
		    } else if (validateFields()) {
		        model.setValueAt(txtName.getText(), row, 0);
		        model.setValueAt(txtRoom.getText(), row, 1);
		        model.setValueAt(txtCheckIn.getText(), row, 2);
		        model.setValueAt(txtCheckOut.getText(), row, 3);
		        saveToFile();
		        clearFields();
		    }
		});
		
		btnDelete.addActionListener(e -> {
		    int row = table.getSelectedRow();

		    if (row == -1) {
		        JOptionPane.showMessageDialog(this, "Select a row first!");
		    } else {
		        model.removeRow(row);
		        saveToFile();
		    }
		});
		
		btnExit.addActionListener(e -> System.exit(0));
		
		
		
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int row = table.getSelectedRow();

		        txtName.setText(model.getValueAt(row, 0).toString());
		        txtRoom.setText(model.getValueAt(row, 1).toString());
		        txtCheckIn.setText(model.getValueAt(row, 2).toString());
		        txtCheckOut.setText(model.getValueAt(row, 3).toString());
		    }
		});
	
		
		
	}
	public boolean validateFields() {
		 if (txtName.getText().isEmpty() ||
			        txtRoom.getText().isEmpty() ||
			        txtCheckIn.getText().isEmpty() ||
			        txtCheckOut.getText().isEmpty()) {

			        JOptionPane.showMessageDialog(this, "All fields are required!");
			        return false;
		
	}
		 
		 return true;
	
	
	}
	
	public void clearFields() {
	    txtName.setText("");
	    txtRoom.setText("");
	    txtCheckIn.setText("");
	    txtCheckOut.setText("");
	}
	
	public void saveToFile() {
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("reservations.txt"));

	        for (int i = 0; i < model.getRowCount(); i++) {
	            bw.write(
	                model.getValueAt(i, 0) + "," +
	                model.getValueAt(i, 1) + "," +
	                model.getValueAt(i, 2) + "," +
	                model.getValueAt(i, 3)
	            );
	            bw.newLine();
	        }

	        bw.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void loadFromFile() {
	    try {
	        BufferedReader br = new BufferedReader(new FileReader("reservations.txt"));
	        String line;

	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");
	            model.addRow(data);
	        }

	        br.close();

	    } catch (IOException e) {
	       
	    }
	}
	
	
	
	
	public static void main (String [] args) {
		
		
		new HotelReservationSystemGUI ();
	}
}
