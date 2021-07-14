package TestCase;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;
import com.main.*;
public class ListCheck {

	@Test
	public void test() throws Exception{
		College daiict = new College();
		LinkedList<Student> studentList =  daiict.fillData("/home/vishwam/E/college/DAIICT/Summer Internship (Under Lavneet sir)/SummerInternship_DAIICT/Tasks/Task3 (graphs)/Project/src/data.txt");
		
		
	}

}
