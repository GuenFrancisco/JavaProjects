package GUIEmpManagSyst;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class EmployeeManagementSystem extends JFrame {

	JTextField txtID, txtName, txtAge, txtBirth, txtNationality,
    txtContact, txtEmail, txtDepartment, txtJob;
	
	JComboBox<String> cmbStatus;
	
	 JRadioButton rbMale, rbFemale;
	    ButtonGroup bgGender;
	    JButton btnDelete, btnUpdate;
	    JTable table;
	    DefaultTableModel model;
	    
	   
	    File file = new File("employees.txt");
	    int selectedRow = -1;
	    boolean isUpdating = false;
	EmployeeManagementSystem () {
		
		setVisible(true);
		
		setTitle("Employee Management System");
		setLayout(null);
		setSize(850,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("EMS Inc.");
		add(lblTitle).setBounds(40, 30, 100, 30);
		
		JLabel lblID = new JLabel("Employee ID");
		add(lblID).setBounds(40,60, 100, 30);
		txtID = new JTextField();
		add(txtID).setBounds(40,90, 150, 25);
		
		JLabel lblName = new JLabel ("Full Name");
		add(lblName).setBounds(40, 120, 100, 30);
		txtName = new JTextField();
		add(txtName).setBounds(40, 150, 150, 25);
		
		JLabel lblBirth = new JLabel ("Date of Birth");
		add(lblBirth).setBounds(40, 180, 100, 30);
		txtBirth = new JTextField();
		add(txtBirth).setBounds(40, 210, 150, 25);
		
		JLabel lblAge = new JLabel ("Age");
		add(lblAge).setBounds(240, 60, 100, 30);
		txtAge = new JTextField();
		add(txtAge).setBounds(240, 90, 150, 25);
		
		JLabel lblCivil = new JLabel("Civil Status");
		add(lblCivil).setBounds(240, 120, 100, 30);
		
		String[] status = {"Single", "Married", "Widowed", "Separated", "Divorced"};
        cmbStatus = new JComboBox<>(status);
        add(cmbStatus).setBounds(240, 150, 150, 25);
        
        JLabel lblNationality = new JLabel("Nationality");
        add(lblNationality).setBounds(240, 180, 100, 30);
        txtNationality = new JTextField();
        add(txtNationality).setBounds(240, 210, 150, 25);
        
        JLabel lblGender = new JLabel("Gender");
        add(lblGender).setBounds(440,60,100,30);
        
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        rbMale.setBounds(440, 90, 60, 25);
        rbFemale.setBounds(500, 90, 70, 25);

        add(rbMale);
        add(rbFemale);

        bgGender = new ButtonGroup();
        bgGender.add(rbMale);
        bgGender.add(rbFemale);
        
        
        JLabel lblContact = new JLabel ("Contacts");
        add(lblContact).setBounds(440,120, 100, 30);
        txtContact = new JTextField();
        add(txtContact).setBounds(440, 150, 150, 25);
        
        JLabel lblEmail = new JLabel("Email");
        add(lblEmail).setBounds(440,180, 100, 30);
        txtEmail = new JTextField();
        add(txtEmail).setBounds(440, 210, 150, 25);
        
		
        JLabel lblDepartment = new JLabel("Department");
        add(lblDepartment).setBounds(640,120, 100, 30);
        txtDepartment = new JTextField();
        add(txtDepartment).setBounds(640, 150, 150, 25);
        
        
        JLabel lblJob = new JLabel("Job Title/Position");
        add(lblJob).setBounds(640,180, 100, 30);
        txtJob = new JTextField();
        add(txtJob).setBounds(640, 210, 150, 25);
        
        
        JButton btnAdd = new JButton("Add Employee");
        add(btnAdd).setBounds(248,250,135, 25);
        
        
        JButton btnUpdate = new JButton("Update Employee");
        add(btnUpdate).setBounds(448,250,135, 25);
        
        JButton btnDelete = new JButton("Delete Employee");
        add(btnDelete).setBounds(648,250,135, 25);
        
        String[] columns = {
                "Employee ID", "Full Name", "Birth", "Age", "Civil Status",
                "Nationality", "Gender", "Contact", "Email", "Department", "Job Title"
        };
		
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30, 300, 740, 200);
        add(sp);
		
        
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                
                String id = txtID.getText();
                String name = txtName.getText();
                String age = txtAge.getText();
                String birth = txtBirth.getText();
                String nationality = txtNationality.getText();
                String contact = txtContact.getText();
                String email = txtEmail.getText();
                String dept = txtDepartment.getText();
                String job = txtJob.getText();
                String status = cmbStatus.getSelectedItem().toString();
                
                String gender = "";
                if (rbMale.isSelected()) gender = "Male";
                if (rbFemale.isSelected()) gender = "Female";

              
                model.addRow(new Object[]{
                        id, name, birth, age, status,
                        nationality, gender, contact, email, dept, job
                });
                
                
                try {
                    FileWriter fw = new FileWriter(file, true);
                    fw.write(id + "#" + name + "#" + birth + "#" + age + "#" + status + "#" +
                            nationality + "#" + gender + "#" + contact + "#" + email + "#" +
                            dept + "#" + job + "\n");
                    fw.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                clearFields();
            }
        });
        
        btnDelete.addActionListener(e->{
        	int selectedRow = table.getSelectedRow();
        	if (selectedRow ==  - 1) {
        		
        		JOptionPane.showMessageDialog(null, "Select a record to delete");
        		return;
        	}
        	int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want top delete this record? ",  "Confirm Delete ", JOptionPane.YES_NO_OPTION);
        	if (confirm != JOptionPane.YES_OPTION)return;
        	model.removeRow(selectedRow);
        	
        	 saveAllDataToFile();
        	 
        	 clearFields();
        	
        	
        });
        
        btnUpdate.addActionListener(e->{
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow == -1) {
        		
        		JOptionPane.showMessageDialog(null, "Select a record to Update");
        		return;
        		
        	}
        	
        	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want Update this record?", "Confirm Update", JOptionPane.YES_NO_OPTION);
        	if (confirm != JOptionPane.YES_OPTION) return;
        	
        	if(!isUpdating) {
        		txtID.setText(model.getValueAt(selectedRow, 0).toString());
                txtName.setText(model.getValueAt(selectedRow, 1).toString());
                txtBirth.setText(model.getValueAt(selectedRow, 2).toString());
                txtAge.setText(model.getValueAt(selectedRow, 3).toString());
                cmbStatus.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
                txtNationality.setText(model.getValueAt(selectedRow, 5).toString());

                String gender = model.getValueAt(selectedRow, 6).toString();
                if (gender.equals("Male")) rbMale.setSelected(true);
                else if (gender.equals("Female")) rbFemale.setSelected(true);

                txtContact.setText(model.getValueAt(selectedRow, 7).toString());
                txtEmail.setText(model.getValueAt(selectedRow, 8).toString());
                txtDepartment.setText(model.getValueAt(selectedRow, 9).toString());
                txtJob.setText(model.getValueAt(selectedRow, 10).toString());
                
                isUpdating = true;
                
                JOptionPane.showMessageDialog(null, "Edit the fields, then click Update again.");
                
                
        		
        	}else {
        		
        		String gender = "";
                if (rbMale.isSelected()) gender = "Male";
                if (rbFemale.isSelected()) gender = "Female";

                model.setValueAt(txtID.getText(), selectedRow, 0);
                model.setValueAt(txtName.getText(), selectedRow, 1);
                model.setValueAt(txtBirth.getText(), selectedRow, 2);
                model.setValueAt(txtAge.getText(), selectedRow, 3);
                model.setValueAt(cmbStatus.getSelectedItem().toString(), selectedRow, 4);
                model.setValueAt(txtNationality.getText(), selectedRow, 5);
                model.setValueAt(gender, selectedRow, 6);
                model.setValueAt(txtContact.getText(), selectedRow, 7);
                model.setValueAt(txtEmail.getText(), selectedRow, 8);
                model.setValueAt(txtDepartment.getText(), selectedRow, 9);
                model.setValueAt(txtJob.getText(), selectedRow, 10);
                
                saveAllDataToFile();
                
                isUpdating = false;

                JOptionPane.showMessageDialog(null, "Employee updated successfully!");
                
                clearFields();
        	}
        	
        	
        });

      
        loadData(); 
	}
	
	void clearFields() {
	    txtID.setText("");
	    txtName.setText("");
	    txtBirth.setText("");
	    txtAge.setText("");
	    txtNationality.setText("");
	    txtContact.setText("");
	    txtEmail.setText("");
	    txtDepartment.setText("");
	    txtJob.setText("");
	    cmbStatus.setSelectedIndex(0);
	    bgGender.clearSelection();
	}
        
        
	
        void saveAllDataToFile() {
            try {
                FileWriter fw = new FileWriter(file);

                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        fw.write(model.getValueAt(i, j).toString());

                        if (j < model.getColumnCount() - 1) {
                            fw.write("#");
                        }
                    }
                    fw.write("\n");
                }

                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
       
        
    }

    void loadData() {
        try {
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("#");
                model.addRow(data);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    
	
	
		public static void main (String [] args) {
			
			
			
			new EmployeeManagementSystem ();
			
		}
}
