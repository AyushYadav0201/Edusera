/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edusera.ui.student;

import com.itextpdf.text.DocumentException;
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
import java.io.FileNotFoundException;
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
import edusera.ui.misc.BaseJPanel;
import utility.PDFExporter;
import utility.Utility;


/**
 *
 * @author ingale.r
 */
public class StudentGradesJPanel extends BaseJPanel {

    public StudentGradesJPanel(Business business) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        lblViewTranscript = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Courses Grades");

        tblCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Offering", "Grades"
            }
        ));
        jScrollPane1.setViewportView(tblCourses);
        if (tblCourses.getColumnModel().getColumnCount() > 0) {
            tblCourses.getColumnModel().getColumn(0).setResizable(false);
            tblCourses.getColumnModel().getColumn(1).setResizable(false);
        }

        lblViewTranscript.setText("View Transcript");
        lblViewTranscript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewTranscriptMouseClicked(evt);
            }
        });
        lblViewTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblViewTranscriptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(lblViewTranscript))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel1)))
                .addContainerGap(14109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblViewTranscript)
                .addContainerGap(717, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblViewTranscriptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewTranscriptMouseClicked
        // TODO add your handling code here:
        Student student = (Student)business.getLoggedInUser().getPerson();
        try {
            PDFExporter.export(student.getTranscript());
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentGradesJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(StudentGradesJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblViewTranscriptMouseClicked

    private void lblViewTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblViewTranscriptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewTranscriptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lblViewTranscript;
    private javax.swing.JTable tblCourses;
    // End of variables declaration//GEN-END:variables

    private void initSetup() {
            populateTable();
    
    }
    
       private void populateTable() {
    
        DefaultTableModel model = (DefaultTableModel) tblCourses.getModel();
        model.setRowCount(0);
   
        List<Business.MyGrades> ls = business.showGrades();
        for (Business.MyGrades grade : ls){
            Object[] row = new Object[5];
            row[0] = grade.courseOffer;
            row[1] = grade.grade;
            model.addRow(row);
        }
    }
}
