
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class PdfDocument {
   public PdfDocument(Booking bk,String time) {
        Rectangle pageSize = new Rectangle(700, 720);
        pageSize.setBackgroundColor(new BaseColor(0, 0, 0));
        Document document = new Document( pageSize );
        //pageSize.setBackgroundColor(new BaseColor(0xFF,0xFF,0xFF));
        Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.WHITE);
        Font farefont = new Font(Font.FontFamily.TIMES_ROMAN,15,Font.BOLD,new BaseColor(230, 0, 0));
        Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 15,Font.NORMAL,BaseColor.WHITE);
        String s= String.valueOf(bk.getBook_id());
        String file_name = "C:\\java_pdf\\reciept_"+s+".pdf";
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(new File(file_name)));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
            document.open();
            
            Image signature;
        try {
            signature = Image.getInstance("C:\\java_pdf\\pic1.png");
            signature.setAlignment(Element.ALIGN_CENTER);
            document.add(Image.getInstance(signature));
        } catch (BadElementException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }   
            Paragraph p =new Paragraph();
            p.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(220, 0, 0)));
            p.setAlignment(Element.ALIGN_CENTER);
            p.add("34- Huma Block Moon Market Allama Iqbal Town");
           
        try {
            document.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            Paragraph p2 = new Paragraph();
            p2.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(220, 0, 0)));
            p2.setAlignment(Element.ALIGN_CENTER);
            p2.add("near Gulshan Park,Lahore.   Phone no.0306-4416475");
        try {
            document.add(p2);
        } catch (DocumentException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
            Font f= new Font();
            f.setColor(new BaseColor(220,0,0));
            f.setStyle(Font.BOLD);
            f.setSize(20);
            
        try {
            document.add(new Paragraph("                         ", f));
            document.add(new Paragraph("Booking Details:", f));
            document.add(new Paragraph("                         ", f));
                 
        float[] columnWidths = {3f, 3f};
        //create PDF table with the given widths
        PdfPTable table = new PdfPTable(columnWidths);
        table.getDefaultCell().setMinimumHeight(500f);
        // set table width a percentage of the page width
        table.setWidthPercentage(50f);
   
        //insert column headings
       insertHeaderCell(table, "Booking ID", Element.ALIGN_CENTER, 1, bfBold12);
       insertCell(table, s, Element.ALIGN_CENTER, 1, bf12);
       table.setHeaderRows(1);
 
       //insert an empty row
       insertHeaderCell(table, "Username", Element.ALIGN_CENTER, 1, bfBold12);
       insertCell(table, bk.getUsername(), Element.ALIGN_CENTER, 1, bf12);
   
       insertHeaderCell(table, "Uesr CNIC", Element.ALIGN_CENTER, 1, bfBold12);
       insertCell(table, bk.getUser_Cnic(), Element.ALIGN_CENTER, 1, bf12);
   
       insertHeaderCell(table, "Vehichle ID", Element.ALIGN_CENTER, 1, bfBold12);
       insertCell(table, bk.getVehicleID(), Element.ALIGN_CENTER, 1, bf12);
   
       insertHeaderCell(table, "Booking Start Date", Element.ALIGN_CENTER, 1, bfBold12);
       insertCell(table, bk.getSched_StartDate(), Element.ALIGN_CENTER, 1, bf12);
   
       insertHeaderCell(table, "Booking End Date", Element.ALIGN_CENTER, 1, bfBold12);
       insertCell(table, bk.getSched_EndDate(), Element.ALIGN_CENTER, 1, bf12);
   
       insertHeaderCell(table, "Total Rent", Element.ALIGN_CENTER, 1,bfBold12);
       insertCell(table, bk.getFare()+" Rs.", Element.ALIGN_CENTER, 1, farefont);
   
      document.add(table);
      document.add(new Paragraph("             ",new Font(Font.FontFamily.TIMES_ROMAN, 12)));
      Paragraph p4 = new Paragraph();
      p4.setFont(new Font(Font.FontFamily.COURIER, 12, Font.BOLD, new BaseColor(220, 0, 0)));
      p4.setAlignment(Element.ALIGN_LEFT);
      p4.add("- Reciept Generated on "+time);
      document.add(p4);
      document.close();
            
        } catch (DocumentException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("done");
    } 
    private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {
         
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
       cell.setHorizontalAlignment(align);
       cell.setColspan(colspan);
       cell.setFixedHeight(40);
       if(text.trim().equalsIgnoreCase("")){
         cell.setMinimumHeight(50f);
       }
       cell.setUseVariableBorders(true);
       cell.setBorderColorTop(BaseColor.RED);
       cell.setBorderColorBottom(BaseColor.RED);
       cell.setBorderColorRight(BaseColor.RED);
       table.addCell(cell);
  
    }
    private static void insertHeaderCell(PdfPTable table, String text, int align, int colspan, Font font) {
         
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
       cell.setHorizontalAlignment(align);
       cell.setColspan(colspan);
       cell.setFixedHeight(40);
       cell.setBackgroundColor(new BaseColor(230,0,0));
       if(text.trim().equalsIgnoreCase("")){
         cell.setMinimumHeight(50f);
       }
       table.addCell(cell);
  
    }    
}
