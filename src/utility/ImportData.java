package utility;

import edusera.Business;
import edusera.business.employer.Employer;
import edusera.business.professor.Course;
import edusera.business.students.CourseLoad;
import edusera.business.professor.CourseOffering;
import edusera.business.profiles.Person;
import edusera.business.professor.Professor;
import edusera.business.profiles.Role;
import edusera.business.students.SeatAssignment;
import edusera.business.schedule.Semester;
import edusera.business.students.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImportData {
    
    public static void read(Business business) throws FileNotFoundException, IOException {
        String filePath = "/Users/ayush/NetBeansProjects/assignment-3-teamaar23/src/data.xlsx";

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            
            // Read Users
            readUsers(business, workbook);
            
            // Read Semester data
            readSemester(business, workbook);
               
            // Read Courses data
            readCourses(business, workbook);
            
            // Read Enrollments data
            readEnrollments(business, workbook);
            
            // Read Grading
            readGrading(business, workbook);
            
            //Rate professor
            readRating(business, workbook);
                
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private static void readCourses(Business business, Workbook workbook){
        Sheet course = workbook.getSheetAt(1);
        Iterator<Row> courseSheet = course.iterator();
        while (courseSheet.hasNext()) {
            Row row = courseSheet.next();

            // Skip the header row
            if (row.getRowNum() == 0) {
                continue;
            }

            String name = row.getCell(0).getStringCellValue();
            String title = row.getCell(1).getStringCellValue();
            String crn = row.getCell(5).getStringCellValue();
            String numOfSeatsStr = row.getCell(6).getStringCellValue();
            String sem = row.getCell(7).getStringCellValue();
            String region = row.getCell(8).getStringCellValue();
            String language = row.getCell(9).getStringCellValue();
            Course newCourse = business.getCatalog().getCourseByName(title);
            Professor newProf = business.getProfDir().getProfByName(name);
            Semester newSem = business.getCourseSchedule().getSemesterByTitle(sem);
            business.setLoggedInUser(business.getUserDir().findUserByPerson(newProf));
          
            //Create Course
            if(newCourse == null)
                newCourse = business.addCourse(title, crn, 4, 7500);

            business.createOffering(newCourse, crn, Integer.parseInt(numOfSeatsStr), newSem, region, language);

        } 
    }
    
    private static void readUsers(Business business, Workbook workbook){
    
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
           

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
            try {
                Row row = rowIterator.next();

                // Skip the header row
                if (row.getRowNum() == 0) {
                    continue;
                }

                String nuid = row.getCell(0).getStringCellValue();
                String name = row.getCell(1).getStringCellValue();
                String email = row.getCell(2).getStringCellValue();
                String type = row.getCell(3).getStringCellValue();
                String username = row.getCell(4).getStringCellValue();
                String password = row.getCell(5).getStringCellValue();
                
                Person person;
                switch(type){
                    case "S":
                        Student student = business.getStudentDir().addStudent(nuid, name, email);
                        business.getUserDir().addUser(nuid, username, password, student, Role.STUDENT, true);
                        break;
                        
                    case "P":
                        Professor prof = business.getProfDir().addProfessor(nuid, name, email);
                        business.getUserDir().addUser(nuid, username, password, prof, Role.PROFESSOR, true);
                        break;
                        
                    case "E":

                        Employer emp = business.getEmpDir().addEmployer(nuid, name, email);
                        business.getUserDir().addUser(nuid, username, password, emp, Role.EMPLOYER, true);
                        break;

                }
            } catch (Exception ex) {
                Logger.getLogger(ImportData.class.getName()).log(Level.SEVERE, null, ex);
            }
     
            }
    }
    
    private static void readSemester(Business business, Workbook workbook){
        Sheet semester = workbook.getSheetAt(2);
        Iterator<Row> semesterSheet = semester.iterator();
        while (semesterSheet.hasNext()) {
            Row row = semesterSheet.next();

            // Skip the header row
            if (row.getRowNum() == 0) {
                continue;
            }

            String startAt = row.getCell(0).getStringCellValue();
            String endAt = row.getCell(1).getStringCellValue();

            try {
                business.getCourseSchedule().startSemester(startAt, endAt);
            } catch (Exception ex) {
                Logger.getLogger(ImportData.class.getName()).log(Level.SEVERE, null, ex );
            }

        }  
    }

    private static void readEnrollments(Business business, Workbook workbook) {
        Sheet enrollments = workbook.getSheetAt(5);
        Iterator<Row> enroll = enrollments.iterator();
        while (enroll.hasNext()) {
            Row row = enroll.next();
            
            // Skip the header row
            if (row.getRowNum() == 0) {
                continue;
            }
            
            String name = row.getCell(0).getStringCellValue();
            String crn = row.getCell(1).getStringCellValue();
            String sem = row.getCell(2).getStringCellValue();
            
            Student newStudent = business.getStudentDir().getStudentByName(name);

            Semester newSem = business.getCourseSchedule().getSemesterByTitle(sem);

            CourseOffering co = business.getOfferingByCrn(crn);
            business.setLoggedInUser(business.getUserDir().findUserByPerson(newStudent));

            newStudent.enrollFor(co, newSem);
        }
        
    }
      private static void readGrading(Business business, Workbook workbook) {
        Sheet grading = workbook.getSheetAt(3);
        Iterator<Row> enroll = grading.iterator();
        while (enroll.hasNext()) {
            Row row = enroll.next();
            
            // Skip the header row
            if (row.getRowNum() == 0) {
                continue;
            }
          
            String name = row.getCell(0).getStringCellValue();
            String crn = row.getCell(2).getStringCellValue();
            String grade = row.getCell(3).getStringCellValue();
            String sem = row.getCell(4).getStringCellValue();
            
            CourseOffering co = business.getOfferingByCrn(crn);
            Semester newSem = business.getCourseSchedule().getSemesterByTitle(sem);
            Student newStudent = business.getStudentDir().getStudentByName(name);
          
            business.gradeStudent(co, newStudent, Double.parseDouble(grade), newSem);
        }
      }
      
      private static void readRating(Business business, Workbook workbook) {
        Sheet rating = workbook.getSheetAt(4);
        Iterator<Row> rate = rating.iterator();
        while (rate.hasNext()) {
            try {
                Row row = rate.next();
                
                // Skip the header row
                if (row.getRowNum() == 0) {
                    continue;
                }
                
                String name = row.getCell(0).getStringCellValue();
                String crn = row.getCell(1).getStringCellValue();
                String rateProf = row.getCell(2).getStringCellValue();
                String sem = row.getCell(3).getStringCellValue();
                
                CourseOffering co = business.getOfferingByCrn(crn);
                Student newStudent = business.getStudentDir().getStudentByName(name);
                Semester semester = business.getCourseSchedule().getSemesterByTitle(sem);
                
                newStudent.rateOffering(co, Double.parseDouble(rateProf), semester);
            } catch (Exception ex) {
                Logger.getLogger(ImportData.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
      }
}
