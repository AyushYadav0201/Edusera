/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusera.ui.authority;

import edusera.business.professor.Course;
import edusera.business.professor.CourseCatalog;
import edusera.business.professor.CourseOffering;
import edusera.business.directory.ProfessorDirectory;
import edusera.business.schedule.Semester;
import edusera.business.students.Student;
import edusera.business.directory.UserDirectory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import edusera.Business;
import edusera.Business.StudentGraduateDetails;
import edusera.ui.misc.BaseJPanel;
import utility.Utility;


/**
 *
 * @author ingale.r
 */

public class DegreeApprovalJPanel extends BaseJPanel {


    public DegreeApprovalJPanel(Business business) {
        super(business);
        initComponents();
        initSetup();
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
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        chkSearchMode = new javax.swing.JCheckBox();
        txtSearchbox = new javax.swing.JTextField();
        lblEmail3 = new javax.swing.JLabel();
        btnReject = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));

        tblCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student Name", "Credits", "Eligible to Graduate?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCourses);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRegister.setText("Approve");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        chkSearchMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSearchModeActionPerformed(evt);
            }
        });

        txtSearchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchboxActionPerformed(evt);
            }
        });

        lblEmail3.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblEmail3.setText("Degree Approval");

        btnReject.setText("Reject");
        btnReject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRejectMouseClicked(evt);
            }
        });
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(702, 702, 702)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReject)
                                .addGap(644, 644, 644)
                                .addComponent(chkSearchMode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(358, 358, 358)
                                .addComponent(lblEmail3)))))
                .addGap(0, 14055, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(7704, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7705, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(lblEmail3)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(chkSearchMode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegister)
                            .addComponent(btnReject))))
                .addContainerGap(710, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(683, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(683, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
          if (chkSearchMode.isSelected()) {
        populateTableSearch(txtSearchbox.getText());
        JOptionPane.showMessageDialog(this, "Course found!");
    } else {
        JOptionPane.showMessageDialog(this, "Search-checkbox is disabled");
    } 
    }//GEN-LAST:event_btnSearchActionPerformed

    private void chkSearchModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSearchModeActionPerformed
        // TODO add your handling code here:
        if(chkSearchMode.isSelected())
        btnRegister.setEnabled(false);
        else
            btnRegister.setEnabled(true);
    }//GEN-LAST:event_chkSearchModeActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void txtSearchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchboxActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = tblCourses.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Select a student to graduate");
        }
        DefaultTableModel model = (DefaultTableModel) tblCourses.getModel();
        StudentGraduateDetails details = (StudentGraduateDetails) model.getValueAt(selectedRowIndex, 0);
        details.student.setGraduated(true);
        business.getAuth().removeApplicant(details.student);
        JOptionPane.showMessageDialog(this, "This student has now graduated!");
        populateTable();
    }//GEN-LAST:event_btnRegisterMouseClicked

    private void btnRejectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRejectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRejectMouseClicked

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblCourses.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Select a student to reject");
        }
        DefaultTableModel model = (DefaultTableModel) tblCourses.getModel();
        StudentGraduateDetails details = (StudentGraduateDetails) model.getValueAt(selectedRowIndex, 0);
        business.getAuth().removeApplicant(details.student);
        details.student.setSubmitted(false);
        JOptionPane.showMessageDialog(this, "This student is rejected");
        populateTable();
    }//GEN-LAST:event_btnRejectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkSearchMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmail3;
    private javax.swing.JTable tblCourses;
    private javax.swing.JTextField txtSearchbox;
    // End of variables declaration//GEN-END:variables

    private void initSetup() {        
          populateTable();
    }
    
    private List<Course> courses;
       
    private void populateTable() {
    
        DefaultTableModel model = (DefaultTableModel) tblCourses.getModel();
        model.setRowCount(0);

        String searchText = txtSearchbox.getText();
   
        for (StudentGraduateDetails details: business.studentGraduate()){
            
            Object[] row = new Object[5];
            row[0] = details;
            row[1] = details.credit;
            row[2] = details.eligible ? "Yes" : "No";
            
            model.addRow(row);
        }
  }

    
  private void populateTableSearch(String query) {
    DefaultTableModel model = (DefaultTableModel) tblCourses.getModel();
    model.setRowCount(0);
    
    for (StudentGraduateDetails details: business.studentGraduate()){
        if (matchesSearchCriteria(details, query)) {
            Object[] row = new Object[5];
            row[0] = details;
            row[1] = details.credit;
            row[2] = details.eligible ? "Yes" : "No";
            
            model.addRow(row);
        }
    }
}

private boolean matchesSearchCriteria(Business.StudentGraduateDetails details, String query) {
    
    String student = details.student.getName();

    return 
           student.contains(query);
}








}










