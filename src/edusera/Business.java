/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edusera;

import edusera.business.degree.Authority;
import edusera.business.professor.Course;
import edusera.business.professor.CourseCatalog;
import edusera.business.professor.CourseOffering;
import edusera.business.schedule.CourseSchedule;
import edusera.business.degree.DegreeRegistry;
import edusera.business.directory.EmployerDirectory;
import edusera.business.professor.Professor;
import edusera.business.directory.ProfessorDirectory;
import edusera.business.professor.Seat;
import edusera.business.students.SeatAssignment;
import edusera.business.schedule.Semester;
import edusera.business.students.Student;
import edusera.business.directory.StudentDirectory;
import edusera.business.profiles.User;
import edusera.business.directory.UserDirectory;
import edusera.ui.professor.GradeStudentJPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ayush
 */
public class Business {
    
    private UserDirectory userDir;
    private StudentDirectory studentDir;
    private ProfessorDirectory profDir;
    private CourseCatalog catalog;
    private EmployerDirectory empDir;

    public EmployerDirectory getEmpDir() {
        return empDir;
    }

    public void setEmpDir(EmployerDirectory empDir) {
        this.empDir = empDir;
    }
    private User loggedInUser;
    private CourseSchedule courseSchedule;
    private Semester current;
    private Seat seat;
    private SeatAssignment seatAssignment;
    private double grade;
    private DegreeRegistry degreeRegistry;

    public Authority getAuth() {
        return auth;
    }
    private Authority auth;

    public DegreeRegistry getDegreeRegistry() {
        return degreeRegistry;
    }

    public void setDegreeRegistry(DegreeRegistry degreeRegistry) {
        this.degreeRegistry = degreeRegistry;
    }
 
    
 
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    boolean isThisSeatOurs(Seat seat) {
        return this.seat == seat;
    }

   
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Semester getCurrent() {
        return current;
    }

    public void setCurrent(Semester current) {
        this.current = current;
    }

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JPanel getMainWorkArea() {
        return mainWorkArea;
    }

    public void setMainWorkArea(JPanel mainWorkArea) {
        this.mainWorkArea = mainWorkArea;
    }

    public JPanel getWorkArea() {
        return workArea;
    }

    public void setWorkArea(JPanel workArea) {
        this.workArea = workArea;
    }
    private JPanel header;
    private JPanel mainWorkArea;
    private JPanel workArea;

    public UserDirectory getUserDir() {
        return userDir;
    }

    public void setUserDir(UserDirectory userDir) {
        this.userDir = userDir;
    }

    public StudentDirectory getStudentDir() {
        return studentDir;
    }

    public void setStudentDir(StudentDirectory studentDir) {
        this.studentDir = studentDir;
    }

    public ProfessorDirectory getProfDir() {
        return profDir;
    }

    public void setProfDir(ProfessorDirectory profDir) {
        this.profDir = profDir;
    }

    public CourseCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(CourseCatalog catalog) {
        this.catalog = catalog;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    public Course addCourse(String title, String description, int credit, double price){
        return this.catalog.createCourse(title, description, credit, price);
    }
   
    public List<Semester> getSemesterList(){
        return this.courseSchedule.getSemesters();
    }

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }
    
    public List<Course> getCourseList(){
        return this.catalog.getCourses();
    }

    public Semester startSemester(Date startsAt, Date endsAt) throws Exception{
        this.current = this.courseSchedule.startSemester(startsAt, endsAt);
        return this.current;
    }
    
    public Semester endSemester() throws Exception{
       
        current = this.courseSchedule.endSemester(this.current); 
        return current;
    }
    
    public CourseOffering createOffering(Course courseToBeOffered, String crn, int numOfSeats, Semester sem, String language, String region){
        Professor prof = (Professor)this.loggedInUser.getPerson();
        return prof.offer(courseToBeOffered, crn, numOfSeats, sem, language, region);
    }
    
    public void enrollFor(CourseOffering offering){
        Student student = (Student)this.loggedInUser.getPerson();
        student.enrollFor(offering, this.current);
    }
    
     public void gradeStudent(CourseOffering offering, Student ayush, double grade, Semester current) {
        offering.gradeStudent(ayush,grade, current);
    }
     
  
     private List<Seat> seats;
    public double getRating(Semester current){
        double rating = 0;
        for(Seat seat: seats)
            rating += seat.getRating();
        return rating/seats.size();
    }
        
     
        public Course getCourseByName(String name ){
        for(Course course: this.catalog.getCourses())
            if(course.getTitle().equals(name))
                return course;
        return null;
    }

    public List<CourseOffering> fetchCourseOfferingsBySearch(String searchText) {
        List<CourseOffering> returnList = new ArrayList<>();
                
        for(Professor prof: this.getProfDir().getUsers())
            // Check if searchCriteria asks for Prof
            returnList.add(prof.fetchCourseOfferingsBySearch(searchText));
        
        return null;
            
    }
    
    public CourseOffering getOfferingByCrn(String crn){
        for(ProfCourseOffer pco: this.getAllOfferrings()){
            if(pco.offer.getCrn().equals(crn))
                return pco.offer;
        }
        return null;
    }

    public List<ProfCourseOffer> getAllOfferrings() {
        List<ProfCourseOffer> returnList = new ArrayList<>();
        for(Professor prof: this.getProfDir().getUsers())
            for(CourseOffering offer: prof.getOfferings())
                returnList.add(new ProfCourseOffer(offer,prof));
        return returnList;
    }
    
    public List<ProfCourseOffer> getAllOfferringsForCurrentSem() {
        List<ProfCourseOffer> returnList = new ArrayList<>();
        for(Professor prof: this.getProfDir().getUsers())
            for(CourseOffering offer: prof.getOfferingsBySemester(this.current))
                returnList.add(new ProfCourseOffer(offer,prof));
        return returnList;
    }

    public List getOfferingsByProfessor() {
        return ((Professor)this.loggedInUser.getPerson()).getOfferings();
    }
    
    public List<ProfCourseOffer> getProfCourseOfferingsByProfessor() {
        List<ProfCourseOffer> returnList = new ArrayList<>();
        for(CourseOffering offer: ((Professor)this.loggedInUser.getPerson()).getOfferings())
                returnList.add(new ProfCourseOffer(offer,null));
        return returnList;
    }

    public Semester getPreviousSemester() {
        String currentSemTitle = this.current.getTitle();
        String previousSemTitle = this.courseSchedule.getPreviousSemTitle(currentSemTitle);
        return this.courseSchedule.getSemesterByTitle(previousSemTitle);
    }

    public void setAuthority(Authority auth) {
        this.auth = auth;
    }

    public boolean isNuId(String text) {
        return this.userDir.isNuIdValid(text);
    }

    public List<Course> getCourseListFromStrings(List<String> core) {
        List<Course> ret = new ArrayList<>();
        for(String name: core)
            for(Course course: this.getCourseList())
                if(course.getTitle().equals(name))
                    ret.add(course);
        return ret;
    }
    
    
    public class ProfCourseOffer{
        public CourseOffering offer;
        public Professor prof;
        public ProfCourseOffer(CourseOffering offer, Professor prof){
            this.offer = offer;
            this.prof = prof;
        }
    }
    
    public List <StudentsAssignments> getAllStudentsByOfferings(CourseOffering offer, Semester current){
        List<StudentsAssignments> returnList = new ArrayList<>();
        for(Student student:this.studentDir.getUsers()){
            SeatAssignment seatAssignment = student.getSeatAssignment(offer, current);
            if(seatAssignment == null)
                continue;
            returnList.add(new StudentsAssignments(student, seatAssignment));
        }
        return returnList;
    }
            
   
    public class StudentsAssignments{
     public Student student;
     public SeatAssignment assignment;
     public StudentsAssignments(Student student, SeatAssignment assignment){
         this.student = student;
         this.assignment = assignment;
     }
     public String toString(){
         return this.student+"";
     }
    }
  
    public List <CourseRating> getRatingBySemester(Semester current){
        List<CourseRating> returnList = new ArrayList<>();
        List<ProfCourseOffer> profCourseOffers = this.getAllOfferrings();
        for(ProfCourseOffer profCourseOffer : profCourseOffers){
            Student thisStudent = ((Student)this.loggedInUser.getPerson());
            if(thisStudent.isEnrolledForThisSem(profCourseOffer.offer, current)){
                Seat thisSeat = thisStudent.getSeatAssignment(profCourseOffer.offer, current).getSeat();
                returnList.add(new CourseRating(thisSeat,profCourseOffer.offer));
            }
        }
        return returnList;
    }
            
            
    public class CourseRating{
        public Seat seat;
        public CourseOffering courseOffer;
        public CourseRating (Seat seat, CourseOffering courseOffer){
            this.seat = seat;
            this.courseOffer = courseOffer;
            
        }
        public String toString(){
            return this.courseOffer + "";
        }
    }
 
    
   public double calculateMyRatingBySemester(Semester current){
        Professor prof = (Professor)this.loggedInUser.getPerson();
        return prof.calculateMyRatingBySemester(current);
    }
   
   
   public List <CompleteTeachingHistory> getHistoryByOffering(){
        
        List<CompleteTeachingHistory> returnList = new ArrayList<>();        
        for(ProfCourseOffer profCourseOffer : this.getProfCourseOfferingsByProfessor()){ 
            double rating = profCourseOffer.offer.getRating();
            System.out.println("Rating : "+rating);
            returnList.add(new CompleteTeachingHistory(profCourseOffer.offer.getSemester(),profCourseOffer.offer, rating));
        }
        
        return returnList;
    }  
   
   
     public class CompleteTeachingHistory{
        public Semester semester;
        public CourseOffering courseOffer;
        public double rating;
        public CompleteTeachingHistory(Semester semester,CourseOffering courseOffer, double rating){
            this.rating = rating;
            this.courseOffer = courseOffer;
            this.semester = semester;
            
        }
     }
     public List<MyGrades> showGrades(){
        List<MyGrades> returnList = new ArrayList<>();   
        for(ProfCourseOffer profCourseOffer : this.getAllOfferringsForCurrentSem()){
            Student student = (Student)this.loggedInUser.getPerson();
            if(student.isEnrolledForThisSem(profCourseOffer.offer, current)){
               double grade = student.getSeatAssignment(profCourseOffer.offer, current).getGrade();
               returnList.add(new MyGrades(profCourseOffer.offer, grade));

            }
        }
        return returnList;
       
     }
     
     public class MyGrades{
       public CourseOffering courseOffer;
       public double grade;
       public MyGrades(CourseOffering courseOffer, double grade){
           this.courseOffer = courseOffer;
           this.grade = grade;
       }

     }
     
    public List<ProfessorRating> topProfessors() {
    List<ProfessorRating> returnList = new ArrayList<>();
    List<Professor> professors = profDir.getUsers();
    for (Professor professor : professors) {
        double rating = professor.calculateMyRatingBySemester(current);
        returnList.add(new ProfessorRating(rating, professor));
    }

    // Sort the list of ProfessorRating objects in descending order by rating
    Collections.sort(returnList, new Comparator<ProfessorRating>() {
        @Override
        public int compare(ProfessorRating p1, ProfessorRating p2) {
            return Double.compare(p2.rating, p1.rating);
        }
    });

    // Get the top 3 professors
    List<ProfessorRating> top3Professors = new ArrayList<>(returnList.subList(0, Math.min(3, returnList.size())));

    return top3Professors;
}

    public class ProfessorRating {
    public double rating;
    public Professor professor;

    public ProfessorRating(double rating, Professor professor) {
        this.rating = rating;
        this.professor = professor;
    }
}
    
    // Returns top 3 student in current semester
    public List<StudentsRating> topStudents() {
        List<StudentsRating> returnList = new ArrayList<>();
        List<Student> students = studentDir.getUsers();
   
         for (Student student : students){
             double grade = student.calculateMyGradeBySem(current);
             returnList.add(new StudentsRating(grade, student));
         }
         
           // Sort the list of ProfessorRating objects in descending order by rating
        Collections.sort(returnList, new Comparator<StudentsRating>() {
        @Override
        public int compare(StudentsRating p1, StudentsRating p2) {
            return Double.compare(p2.grade, p1.grade);
        }
    });

    List<StudentsRating> top3Students = new ArrayList<>(returnList.subList(0, Math.min(3, returnList.size())));

    return top3Students;
 
    }

    public class StudentsRating {
        public double grade;
        public Student student;

        public StudentsRating(double grade, Student student) {
            this.grade = grade;
            this.student = student;
        }
    }
    
    public List<TopCourseRating> topCourses(){
        List <TopCourseRating> returnList = new ArrayList<>();

        for(ProfCourseOffer profCourseOffer : this.getAllOfferringsForCurrentSem()){
            double rating = profCourseOffer.offer.getRating();
            returnList.add(new TopCourseRating(profCourseOffer.offer,rating));
        }
        
            Collections.sort(returnList, new Comparator<TopCourseRating>() {
            @Override
            public int compare(TopCourseRating p1, TopCourseRating p2) {
                return Double.compare(p2.rating, p1.rating);
            }
        });

        List<TopCourseRating> top3Courses = new ArrayList<>(returnList.subList(0, Math.min(3, returnList.size())));

        return top3Courses;
    }
    
    public class TopCourseRating{
        public CourseOffering courseOffer;
        public double rating;
        
        public TopCourseRating(CourseOffering courseOffer,double rating){
            this.courseOffer = courseOffer;
            this.rating = rating;
        }
    }
    
    public List<StudentGraduateDetails> studentGraduate(){
        List<StudentGraduateDetails> returnList = new ArrayList<>();
        Authority authority = (Authority)this.getLoggedInUser().getPerson();
        for(Student student : authority.getApplicant()){
            returnList.add(new StudentGraduateDetails(student,student.getCompletedCredits(),student.getDegree().canStudentGraduate(student)));
        }
        return returnList;
    }
    
    public class StudentGraduateDetails{
        public Student student;
        public int credit;
        public boolean eligible;

        public StudentGraduateDetails(Student student, int credit, boolean eligible) {
            this.student = student;
            this.credit = credit;
            this.eligible = eligible;
        }

        @Override
        public String toString() {
            return student + "";
        }
        
        
        
    }

    
    public List<StudentsRating> top5Students() {
        List<StudentsRating> returnList = new ArrayList<>();
        List<Student> students = studentDir.getUsers();
   
         for (Student student : students){
             double grade = student.calculateMyGradeBySem(current);
             returnList.add(new StudentsRating(grade, student));
         }
         
           // Sort the list of ProfessorRating objects in descending order by rating
        Collections.sort(returnList, new Comparator<StudentsRating>() {
        @Override
        public int compare(StudentsRating p1, StudentsRating p2) {
            return Double.compare(p2.grade, p1.grade);
        }
    });

    List<StudentsRating> top3Students = new ArrayList<>(returnList.subList(0, Math.min(5, returnList.size())));

    return top3Students;
 
    }
    
}
