/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ertu.proje4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ergul
 */
public class AdminManagement extends javax.swing.JDialog {

    /**
     * Creates new form AdminManagement
     */
    public AdminManagement(java.awt.Frame parent, boolean modal, String uuid) {
        super(parent, modal);
        initComponents();
        // Initializing the fields
        this.admin_uuid = uuid;
        date_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        model = (DefaultTableModel)adminsTable.getModel();
    }
    
    private void updateTable() {
        // Table is emptied
        model.setRowCount(0);
        try (Connection conn = DriverManager.getConnection(DBCredentials.db_url, DBCredentials.db_username, 
                DBCredentials.db_password)) {
            // All admin accounts from the database are retrieved
            String query = "SELECT * from members WHERE admin = 1";
            
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                ResultSet result_set = statement.executeQuery();
                
                // Iterate through all admin accounts
                while (result_set.next()) {
                    // Column values are retrieved
                    String admin_fullname = result_set.getString("fullname");
                    String admin_uuid = result_set.getString("uuid");
                    String admin_email = result_set.getString("email");
                    
                    // Password string is obfuscated while hinting the length
                    String admin_password = result_set.getString("password");
                    String admin_password_str = "*".repeat(admin_password.length());
                    
                    // SQL date is again converted to day/month/year string
                    java.sql.Date sql_date = result_set.getDate("birthday");
                    LocalDate admin_birthday = sql_date.toLocalDate();
                    String admin_birthday_str = admin_birthday.format(date_formatter);
                    // Values are added to table
                    model.addRow(new Object[]{admin_fullname, admin_birthday_str, admin_email, admin_password_str, admin_uuid});
                }
                result_set.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Database error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        adminsTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        adminsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Birthday", "Email", "Password", "UUID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adminsTable);

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Register frame for an admin account is opened
        Register admin_register = new Register((JFrame)this.getOwner(), true, true);
        admin_register.setLocationRelativeTo(this);
        admin_register.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // Refresh the table every time the window gains focus eg. returning from Register frame
        updateTable();
    }//GEN-LAST:event_formWindowGainedFocus

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int selected_row = adminsTable.getSelectedRow();
        // If the admin indeed selected a row from the table...
        if (selected_row != -1) {
            // Get the selected admin's uuid and check it, if the selected one is the original admin AND the logged admin isn't,
            // inform the logged admin about the lack of this privilege and return
            String selected_uuid = (String)adminsTable.getValueAt(selected_row, 4);
            if (selected_uuid.equals(supreme_admin_uuid) && !admin_uuid.equals(supreme_admin_uuid)) {
                JOptionPane.showMessageDialog(this, "You can't modify original admin's credentials.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Otherwise, get the rest of values except UUID which is not to be edited anyway
            // and spawn the AccountUpdate frame with initial texts
            String selected_name = (String)adminsTable.getValueAt(selected_row, 0);
            String selected_birthday = (String)adminsTable.getValueAt(selected_row, 1);
            String selected_email = (String)adminsTable.getValueAt(selected_row, 2);
            String selected_password = (String)adminsTable.getValueAt(selected_row, 3);

            AccountUpdate adm_info_upd = new AccountUpdate((JFrame) this.getOwner(), true, selected_uuid, selected_name,
                    selected_birthday, selected_password, selected_email);
            adm_info_upd.setLocationRelativeTo(this);
            adm_info_upd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "You have to select an admin first.",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selected_row = adminsTable.getSelectedRow();
        if (selected_row != -1) {
            // Again, check if the logged admin is the original one in case the selected account is the original admin
            String selected_uuid = (String)adminsTable.getValueAt(selected_row, 4);
            if (selected_uuid.equals(supreme_admin_uuid) && !admin_uuid.equals(supreme_admin_uuid)) {
                JOptionPane.showMessageDialog(this, "You can't delete original admin's account.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection conn = DriverManager.getConnection(DBCredentials.db_url, DBCredentials.db_username, 
                DBCredentials.db_password)) {
                // uuid is the primary key of the table and stays persistent through the use of program.
                // So it is used to select the account to be deleted
                String query = "DELETE FROM members where uuid = ?";
                
                try (PreparedStatement statement = conn.prepareStatement(query)) {
                    statement.setString(1, selected_uuid);
                    
                    int result = statement.executeUpdate();
                    if (result > 0) {
                        // If the update succeeds, return the account from the table too and inform the user.
                        model.removeRow(selected_row);
                        JOptionPane.showMessageDialog(this, "Deleted account successfully");
                    } else {
                        // Inform the user about failure
                        JOptionPane.showMessageDialog(this, "Failed to delete account",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Database error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have to select an admin first.",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private String admin_uuid;
    private String supreme_admin_uuid = "a8f16508-cddd-492b-8fe4-2515d119833d"; //UUID of original admin. This is the one
                                                                                // the functions check against
    private DefaultTableModel model;
    private DateTimeFormatter date_formatter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable adminsTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
