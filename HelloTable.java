/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasP6;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;


/**
 *
 * @author imam
 */

public class HelloTable extends JFrame {
    public HelloTable() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk Nama
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 40, 350, 10);

        // TextField untuk Nama
        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        // Label untuk Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 100, 350, 10);

        // RadioButton untuk Jenis Kelamin Laki-Laki dan di bawahnya ada Perempuan
        JRadioButton radioButtonMale = new JRadioButton("Laki-Laki", true);
        radioButtonMale.setBounds(15, 115, 100, 30);

        JRadioButton radioButtonFemale = new JRadioButton("Perempuan");
        radioButtonFemale.setBounds(120, 115, 100, 30);

        // Grupkan RadioButton Jenis Kelamin
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioButtonMale);
        genderGroup.add(radioButtonFemale);

        // Label untuk Nomor HP
        JLabel labelPhoneNumber = new JLabel("Nomor HP:");
        labelPhoneNumber.setBounds(15, 160, 350, 10);

        // TextField untuk Nomor HP
        JTextField phoneTextField = new JTextField();
        phoneTextField.setBounds(15, 180, 350, 30);

        // CheckBox untuk Warga Negara Asing
        JCheckBox foreignCitizenCheckBox = new JCheckBox("Warga Negara Asing");
        foreignCitizenCheckBox.setBounds(15, 225, 200, 30);

        // tombol simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 280, 100, 40);

        // tabel yang menampilkan data
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);

        scrollableTable.setBounds(15, 350, 350, 200);
        // Model Tabel untuk data
        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

        // ActionListener untuk tombol Simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = "";
                if (radioButtonMale.isSelected()) {
                    gender = radioButtonMale.getText();
                } else if (radioButtonFemale.isSelected()) {
                    gender = radioButtonFemale.getText();
                }

                String nama = textField.getText();
                String phoneNumber = phoneTextField.getText();
                boolean isForeignCitizen = foreignCitizenCheckBox.isSelected();

                // Tambahkan data ke tabel
                ArrayList<String> rowData = new ArrayList<>();
                rowData.add(nama);
                rowData.add(gender);
                rowData.add(phoneNumber);
                rowData.add(isForeignCitizen ? "WNA" : "WNI");

                tableModel.add(rowData);
            }
        });

        // menambahkan komponen-komponen ke frame
        this.add(button);
        this.add(textField);
        this.add(labelGender);
        this.add(radioButtonMale);
        this.add(radioButtonFemale);
        this.add(labelInput);
        this.add(scrollableTable);
        this.add(labelPhoneNumber);
        this.add(phoneTextField);
        this.add(foreignCitizenCheckBox);
        
        // dibawah adalah untuk tata letak frame
        this.setSize(400, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTable h = new HelloTable();
                h.setVisible(true);
            }
        });
    }
}
