package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import functionalLib.BusinessActions;
import io.restassured.response.Response;
import utilities.CommonUtilities;
import utilities.ExcelOps;
import utilities.Global;
import utilities.Report;
import utilities.RestServices;

public class PostPet extends Global {

	ExcelOps excelOps = new ExcelOps();
	BusinessActions businessActions = new BusinessActions();
	RestServices restServices = new RestServices();
	CommonUtilities commonUtils = new CommonUtilities();
	// DataBaseOps dbOps = new DataBaseOps();
	Report report = new Report();
	ResultSet rs = null;
	Date systemDate = new Date();

	public PostPet() throws FileNotFoundException, IOException, ParseException {
		logger.info("Entered in to " + serviceName + " method.");
		String id = null;
		Response response = null;
		String baseURI, contentType, userName, password, inputPayload;
		String executionFlag = null, actResponseCode = "", excelFileName="", sheetName="", testCaseNum="";
		String dbErrorCode = null, dbErrorMessage = null;
		String[] resultSheetHeaders = null;
		long responseTime = 0;
		int rowNum, rn, cn;
		HashMap<String, Object> jsonResultMap;

		workbook = excelOps.excelFileRead(inputTestDataFolder + environment + "/" + testScriptFile);
		baseURI = commonUtils.getProperties(environment + ".endpointUrl");
		contentType = commonUtils.getProperties(environment + ".contentType");
		userName = commonUtils.getProperties(environment + ".ddi_username");
		password = commonUtils.getProperties(environment + ".ddi_password");
		
		

		try {
			resultSheetHeaders = commonUtils.getProperties("ddiHeaders").split(",");
			resultSheetHeaders = commonUtils.appendStringToStringArray(resultSheetHeaders,
					"teleWCDDIHIST Response Time (sec)");
			resultSheetHeaders = commonUtils.appendStringToStringArray(resultSheetHeaders,
					"teleServiceUsageDataService Response Time (sec)");

			excelOps.createRow(resultFile, serviceName, 0, resultSheetHeaders);
		} catch (Exception e1) {
			logger.error("Error in " + serviceName + " method: " + e1.getMessage());
			logger.error("Trace: " + e1);
		}

		for (rowNum = 1; rowNum <= tdSheet.getLastRowNum(); rowNum++) {
			logger.info("Execution started for TestCase No:" + rowNum);
			executionFlag = excelOps.getCellData(tdSheet, rowNum, "ExecutionFlag");

			if ("Yes".equalsIgnoreCase(executionFlag)) {
				try {

					inputPayloadElementsMap = excelOps.getTestData(tdSheet, rowNum, inputPayloadElementsMap);
					inputPayload = businessActions.generateInputPayload(rowNum, templateName);
					System.out.println(inputPayload);

//					resourcePath = resourcePath + "?key=" + inputPayloadElementsMap.get("payload_key");

							
					response = restServices.postMethod(baseURI, resourcePath, contentType, userName, password,
							null,inputPayload);

					responseTime = restServices.responseTime(response);

					String resp = response.asString();
					actResponseCode = String.valueOf(response.getStatusCode());
					restServices.responseCodeValidation(response);
					
					jsonResultMap = commonUtils.jsonTOMap(resp);
					id = jsonResultMap.get("id").toString();
					String petId = id.substring(0,2);
					System.out.println(petId);
					
					if ("Yes".equalsIgnoreCase(inputPayloadElementsMap.get("IsPostFDRequired?"))) 
						testCaseNum = inputPayloadElementsMap.get("GET_TC");
						excelFileName=inputPayloadElementsMap.get("GET_File_Name")+".xlsx";
						sheetName=inputPayloadElementsMap.get("GET_File_Name")+"_TestData";
						//excelOps.excelFileRead(inputTestDataFolder + environment + "/" + excelFileName);
						cn = excelOps.getColNumByColName(excelFileName, sheetName, "payload_petId");
						rn = excelOps.getRowNumByCelVal(excelFileName, sheetName, testCaseNum);
						excelOps.setCellValue(excelFileName, sheetName, rn, cn, petId);
						
					if ("Yes".equalsIgnoreCase(inputPayloadElementsMap.get("IsGetRequired?"))) 
						testCaseNum = inputPayloadElementsMap.get("GET_TC");
						excelFileName=inputPayloadElementsMap.get("GET_File_Name")+".xlsx";
						sheetName=inputPayloadElementsMap.get("GET_File_Name")+"_TestData";
						//excelOps.excelFileRead(inputTestDataFolder + environment + "/" + excelFileName);
						cn = excelOps.getColNumByColName(excelFileName, sheetName, "payload_petId");
						rn = excelOps.getRowNumByCelVal(excelFileName, sheetName, testCaseNum);
						excelOps.setCellValue(excelFileName, sheetName, rn, cn, petId);
					
					if ("Yes".equalsIgnoreCase(inputPayloadElementsMap.get("IsUpdateRequired?"))) 
						testCaseNum = inputPayloadElementsMap.get("Update_TC");
						excelFileName=inputPayloadElementsMap.get("Update_File_Name")+".xlsx";
						sheetName=inputPayloadElementsMap.get("Update_File_Name")+"_TestData";
						cn = excelOps.getColNumByColName(excelFileName, sheetName, "payload_id");
						rn = excelOps.getRowNumByCelVal(excelFileName, sheetName, testCaseNum);
						excelOps.setCellValue(excelFileName, sheetName, rn, cn, petId);
						
					if ("Yes".equalsIgnoreCase(inputPayloadElementsMap.get("IsDeleteRequired?"))) 
						testCaseNum = inputPayloadElementsMap.get("Delete_TC");
						excelFileName=inputPayloadElementsMap.get("Delete_File_Name")+".xlsx";
						sheetName=inputPayloadElementsMap.get("Delete_File_Name")+"_TestData";
						cn = excelOps.getColNumByColName(excelFileName, sheetName, "payload_petId");
						rn = excelOps.getRowNumByCelVal(excelFileName, sheetName, testCaseNum);
						excelOps.setCellValue(excelFileName, sheetName, rn, cn, petId);
					
				} catch (Exception e) {
					failureReason += "Exception in " + serviceName + " service. Reason:- " + e.getMessage();
					logger.error("Exception in " + serviceName + " service. Reason:- " + e);
				}
				if (!failureReason.isEmpty()) {
					resultSheetHeaders = new String[] { String.valueOf(rowNum), inputPayloadElementsMap.get("TestCase"),
							inputPayloadElementsMap.get(expectedHttpResponseCode), actResponseCode,
							String.valueOf(responseTime), dbErrorCode, dbErrorMessage, "FAIL", failureReason };
					excelOps.createRow(resultFile, serviceName, rowNum, resultSheetHeaders);
					report.failTest(inputPayloadElementsMap.get("TestCase"), failureReason);
					logger.info("Execution status of Test Case number: '" + rowNum + "' is : FAIL. Failure reason is: "
							+ failureReason);
					failureReason = "";
				} else {
					resultSheetHeaders = new String[] { String.valueOf(rowNum), inputPayloadElementsMap.get("TestCase"),
							inputPayloadElementsMap.get(expectedHttpResponseCode), actResponseCode,
							String.valueOf(responseTime), dbErrorCode, dbErrorMessage, "PASS", failureReason };
					excelOps.createRow(resultFile, serviceName, rowNum, resultSheetHeaders);
					report.passTest(inputPayloadElementsMap.get("TestCase"));
					logger.info("Execution status of Test Case number: '" + rowNum + "' is : PASS ");
				}

			} else {
				resultSheetHeaders = new String[] { String.valueOf(rowNum),
						excelOps.getCellData(tdSheet, rowNum, "TestCase"), "", "", "", dbErrorCode, dbErrorMessage,
						"Not Executed", failureReason };
				excelOps.createRow(resultFile, serviceName, rowNum, resultSheetHeaders);
				// report.skipTest(excelOps.getCellData(rowNum, "TestCase"));
				logger.info("Execution status of Test Case number: '" + rowNum + "' is : Execution Not required ");
			}
		}

		logger.info("Exit from " + serviceName + " method.");
  
	}
}