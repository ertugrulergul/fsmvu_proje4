/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ertu.proje4;

import java.nio.CharBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ergul
 */
public class AccountUpdate extends javax.swing.JDialog {

    /**
     * Creates new form AdminInfoUpdate
     */
    public AccountUpdate(java.awt.Frame parent, boolean modal, String uuid, String name, String birthday, String password, String email) {
        super(parent, modal);
        // Initialize the fields with arguments(admin_*) and default values(date_formatter)
        try {
            date_formatter = new MaskFormatter("##/##/####");
            date_formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.admin_uuid = uuid;
        this.admin_birthday = birthday;
        this.admin_email = email;
        this.admin_fullname = name;
        this.admin_password = password;
        initComponents();
        // Set the initial texts with account credentials
        birthdayTF.setText(birthday);
        emailTF.setText(email);
        nameTF.setText(name);
        passwordPF.setText(password);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        passwordPF = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        birthdayTF = new javax.swing.JFormattedTextField(date_formatter);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Full Name");

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Email");

        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });

        passwordPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordPFActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        jLabel4.setText("Birthday(DD/MM/YYYY)");

        updateButton.setText("Update");
        updateButton.setEnabled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        birthdayTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(birthdayTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(nameTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(passwordPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(birthdayTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // This function is pretty much inline with Register::registerButtonActionPerformed
        // The only difference is the SQL query is an UPDATE with account's UUID used as primary key instead of a
        // INSERT query where the UUID is generated for the first time
        
        // NOTE: This button is disabled if there isn't a change in any fields
        boolean name_filled = !nameTF.getText().isBlank();
        boolean email_filled = !emailTF.getText().isBlank();
        boolean password_filled = !Register.isCharArrayEmpty(passwordPF.getPassword());

        boolean has_error = false;
        String error_message = "";
        if (!name_filled) {
            if (!has_error) has_error = true;
            error_message += "Fill your name in.\n";
        } else if (!nameTF.getText().matches("(?:\\p{Lu}\\p{Ll}+\\s)+\\p{Lu}\\p{Ll}+")) {
            if (!has_error) has_error = true;
            error_message += "Name is in an invalid format(All names should be capitalized).\n";
        }

        if (!email_filled) {
            if (!has_error) has_error = true;
            error_message += "Fill your email in.\n";
        } else if (!emailTF.getText().matches("[a-zA-Z0-9_]+@[a-zA-Z]+(\\.com(\\.tr)?|\\.edu\\.tr|\\.fsm\\.edu\\.tr)")) {
            if (!has_error) has_error = true;
            error_message += "Email is in an invalid format.\n";
        }

        LocalDate user_birthday = null;
        if (birthdayTF.getText().equals("__/__/____")) {
            if (!has_error) has_error = true;
            error_message += "Fill your birthday in.\n";
        } else {
            String user_birthday_str = birthdayTF.getText();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            user_birthday = LocalDate.parse(user_birthday_str, dateFormatter);
            LocalDate today = LocalDate.now(ZoneId.of("Asia/Istanbul"));
            int age = today.getYear() - user_birthday.getYear();
            if (age < 18) {
                if (!has_error) has_error = true;
                error_message += "You have to be at least 18 years old.\n";
            }
        }

        if (!password_filled) {
            if (!has_error) has_error = true;
            error_message += "Enter a password.\n";
        } else if (!Pattern.matches("^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{7,})\\S$",
            CharBuffer.wrap(passwordPF.getPassword()))) {
        if (!has_error) has_error = true;
        error_message += "Password is invalid.(It should be have at least 8 characters and contain at least an uppercase letter, a lowercase letter and a digit.\n";
        }

        if (has_error) {
            JOptionPane.showMessageDialog(this, error_message, "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            String user_full_name = nameTF.getText();
            String user_email = emailTF.getText();
            char[] user_password = passwordPF.getPassword();

            try (Connection conn = DriverManager.getConnection(DBCredentials.db_url, DBCredentials.db_username, 
                DBCredentials.db_password)) {
                String insert_query = "UPDATE members SET email = ?, password = ?, fullname = ?, birthday = ? WHERE uuid = ?";

                try (PreparedStatement statement = conn.prepareStatement(insert_query)) {
                    statement.setString(1, user_email);
                    statement.setString(2, String.valueOf(user_password));
                    statement.setString(3, user_full_name);
                    statement.setObject(4, user_birthday);
                    statement.setString(5, admin_uuid);
                    
                    int result = statement.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Updated information successfully!");
                        this.dispose();
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Database error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // If there's a change in name value, set the variable to true and enable the button.
        if (!nameTF.getText().equals(admin_fullname)) {
            if (!name_changed) name_changed = true;
            if (!updateButton.isEnabled()) updateButton.setEnabled(true);
        } else {
        // If the change is reverted, then set the variable to false and check if there are any other changes.
        // If there isn't any, then disable the button.
            if (name_changed) name_changed = false;
            if (updateButton.isEnabled() && !name_changed && !password_changed && !email_changed && !birthday_changed) 
                updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_nameTFActionPerformed

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // Same as nameTFActionPerformed but for email
        if (!emailTF.getText().equals(admin_email)) {
            if (!email_changed) email_changed = true;
            if (!updateButton.isEnabled()) updateButton.setEnabled(true);
        } else {
            if (email_changed) email_changed = false;
            if (updateButton.isEnabled() && !name_changed && !password_changed && !email_changed && !birthday_changed) 
                updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_emailTFActionPerformed

    private void passwordPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordPFActionPerformed
        // Same as nameTFActionPerformed but for password
        if (!admin_password.equals(String.valueOf(passwordPF.getPassword()))) {
            if (!password_changed) password_changed = true;
            if (!updateButton.isEnabled()) updateButton.setEnabled(true);
        } else {
            if (password_changed) password_changed = false;
            if (updateButton.isEnabled() && !name_changed && !password_changed && !email_changed && !birthday_changed) 
                updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_passwordPFActionPerformed

    private void birthdayTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayTFActionPerformed
        // Same as nameTFActionPerformed but for birthday
        // One tiny difference is that a JFormattedField returns the base string with placeholders and constant characters
        // instead of a blank string
        if (!birthdayTF.getText().equals("__/__/____") && !birthdayTF.getText().equals(admin_birthday)) {
            if (!birthday_changed) birthday_changed = true;
            if (!updateButton.isEnabled()) updateButton.setEnabled(true);
        } else {
            if (birthday_changed) birthday_changed = false;
            if (updateButton.isEnabled() && !name_changed && !password_changed && !email_changed && !birthday_changed) 
                updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_birthdayTFActionPerformed
    
    private MaskFormatter date_formatter;
    
    private String admin_uuid;
    private String admin_fullname;
    private String admin_password;
    private String admin_birthday;
    private String admin_email;
    
    private boolean name_changed = false;
    private boolean email_changed = false;
    private boolean password_changed = false;
    private boolean birthday_changed = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField birthdayTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameTF;
    private javax.swing.JPasswordField passwordPF;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
