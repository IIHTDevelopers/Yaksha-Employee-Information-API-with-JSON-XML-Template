package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.controller.EmployeeController;
import com.yaksha.assignment.dto.Employee;
import com.yaksha.assignment.utils.JavaParserUtils;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetEmployee() throws Exception {
		// Perform GET request to /employee endpoint and capture the response
		String response = mockMvc.perform(get("/employee").contentType(MediaType.APPLICATION_XML))
				.andExpect(status().isOk()) // Expect HTTP status 200 OK
				.andReturn().getResponse().getContentAsString(); // Get the response body as a string

		// Assert using YakshaAssert that the response contains expected values
		boolean result = response.contains("<id>1</id>") && response.contains("<name>Alice Johnson</name>")
				&& response.contains("<position>Software Engineer</position>");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testRestControllerAnnotation() throws Exception {
		// Specify the file path to the EmployeeController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/EmployeeController.java"; // Update path to
																									// your controller

		// Check if the class is annotated with @RestController
		boolean result = JavaParserUtils.checkClassAnnotation(filePath, "RestController");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testGetMappingOnGetEmployee() throws Exception {
		// Specify the file path to the EmployeeController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/EmployeeController.java"; // Update path to
																									// your controller

		// Check if the getEmployee method has @GetMapping("/employee") annotation
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getEmployee", "GetMapping");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testReturnTypeOfGetEmployee() throws Exception {
		// Specify the file path to the EmployeeController class
		String filePath = "src/main/java/com/yaksha/assignment/controller/EmployeeController.java"; // Update path to
																									// your controller

		// Check if the getEmployee method has the correct return type (Employee)
		boolean result = JavaParserUtils.checkMethodReturnType(filePath, "getEmployee", "Employee");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testEmployeeClassAnnotations() throws Exception {
		// Specify the file path to the Employee class
		String filePath = "src/main/java/com/yaksha/assignment/dto/Employee.java"; // Update path to your DTO

		// Check if the class is annotated with @XmlRootElement
		boolean result = JavaParserUtils.checkClassAnnotation(filePath, "XmlRootElement");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testXmlElementAnnotationsOnEmployee() throws Exception {
		// Specify the file path to the Employee class
		String filePath = "src/main/java/com/yaksha/assignment/dto/Employee.java"; // Update path to your DTO

		// Check if the getter methods are annotated with @XmlElement
		boolean result = JavaParserUtils.checkMethodAnnotation(filePath, "getId", "XmlElement")
				&& JavaParserUtils.checkMethodAnnotation(filePath, "getName", "XmlElement")
				&& JavaParserUtils.checkMethodAnnotation(filePath, "getPosition", "XmlElement");

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}

	@Test
	public void testEmployeeConstructor() throws IOException {
		// Test if the Employee class constructor works correctly
		Employee employee = new Employee(1, "Alice Johnson", "Software Engineer");

		// Check if the Employee object is created and has the expected values
		boolean result = employee.getId() == 1 && "Alice Johnson".equals(employee.getName())
				&& "Software Engineer".equals(employee.getPosition());

		// Assert the result using YakshaAssert
		yakshaAssert(currentTest(), result, businessTestFile);
	}
}
