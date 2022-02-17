package pdf;

import java.io.IOException;
import java.util.*;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.io.font.FontConstants; 
import com.itextpdf.kernel.color.Color; 
import com.itextpdf.kernel.font.PdfFontFactory; 
import com.itextpdf.kernel.font.PdfFont; 
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class specifies the formatting style for the PDF resume
 */
public abstract class PDFFormat {	
	
	/**
	 * Desc: Method adds divider between sections
	 * Param:
	 * Return: Line separator
	*/
	public static LineSeparator addSeparator() {
		LineSeparator line = new LineSeparator(new SolidLine());
		return line;
	}
	
	/**
	 * Desc: Method formats heading styles
	 * Param: String heading type, string heading 
	 * Return: Formatted Text heading
	*/
	public static Text formatHeading(String type, String heading) {
		
		PdfFont font;
		Text value = new Text(heading);
		try {
			if(type.equals("heading")) {
				font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
				value.setFont(font);
				value.setFontSize(18);
			}
			
			else if(type.equals("subheading1")) {
				font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
				value.setFont(font);
				value.setFontSize(14);
				value.setFontColor(Color.DARK_GRAY);
			}
			
			else if(type.equals("subheading2")) {
				font = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
				value.setFont(font);
				value.setFontSize(12);
				value.setFontColor(Color.DARK_GRAY);
			}
		}		
		catch (IOException e) {
			e.printStackTrace();
		}  		
		return value;	
	}
	
	/**
	 * Desc: Method formats the content arr into a bullet PDF list
	 * Param: Arr List of content
	 * Return: Formatted List of content
	*/
	public static List formatList(ArrayList<String> content) {
		List list = new List();
		list.setListSymbol("\u2022");
		try {
			PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);		
			// Using lambda expression and functional operations
			content.forEach((item) -> 
				{
					ListItem listItem = new ListItem(item);
					listItem.setFont(font);
					listItem.setFontSize(10);
					listItem.setFontColor(Color.DARK_GRAY);
					listItem.setMarginLeft(5);
					list.add(listItem);
				});
				
		}
		catch (IOException e) {
			e.printStackTrace();
		}  
		return list;
	}

}

			
			

		