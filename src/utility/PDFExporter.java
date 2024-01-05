package utility;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import edusera.business.students.Transcript;
import edusera.business.students.CourseLoad;
import edusera.business.schedule.Semester;
import edusera.business.professor.CourseOffering;
import edusera.business.students.SeatAssignment;
import edusera.business.students.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFExporter {
    public static void export(Transcript transcript) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("./transcript.pdf"));
        document.open();

        // Add a title to the PDF
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Student Transcript\n", titleFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        // Add the transcript data
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        // Add column headers
        PdfPCell cell1 = new PdfPCell(new Phrase("Course"));
        PdfPCell cell2 = new PdfPCell(new Phrase("Grade"));
        PdfPCell cell3 = new PdfPCell(new Phrase("Semester"));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        for (CourseLoad courseLoad : transcript.getLoads()) {
            for (SeatAssignment assignment : courseLoad.getSeatAssignments()) {
                Semester semester = courseLoad.getSemester();
                String courseName = assignment.getSeat().getCourseName();
                double grade = assignment.getGrade();
                String semesterTitle = semester.getTitle();

                PdfPCell courseCell = new PdfPCell(new Phrase(courseName));
                PdfPCell gradeCell = new PdfPCell(new Phrase(String.valueOf(grade)));
                PdfPCell semesterCell = new PdfPCell(new Phrase(semesterTitle));

                table.addCell(courseCell);
                table.addCell(gradeCell);
                table.addCell(semesterCell);
            }
        }

        document.add(table);
        document.close();
    }
    
    
    public static void certficateExport(Student student) throws FileNotFoundException, DocumentException {
         Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("./certificate.pdf"));
        document.open();

        // Certificate content
        Paragraph title = new Paragraph("Certificate of Graduation");
        title.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph studentInfo = new Paragraph("This is to certify that " + student.getName() + " (ID: " + student.getNuId() + ") has successfully graduated from the University.");

        // You can add more information about the degree, date, and any other relevant details here.

        // Add the content to the document
        document.add(title);
        document.add(studentInfo);

        document.close();
    }
}