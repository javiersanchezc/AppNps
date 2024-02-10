package com.nps.AppNps.service;

import com.nps.AppNps.loadProcess.CSV;
import com.nps.AppNps.loadProcess.CsvToSqlServerHuddlesExport;
import org.springframework.stereotype.Service;

@Service
public class HuddlesServiceimpl implements IHuddlesService{
    @Override
    public void Load_huddles_export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Creation_Date_EST,Channel,Huddle_Type,Country,Property_name,Property_identifier,Huddle_Date,Progress_Recap_from_Last_Session,Positive_Customer_Comments_to_Review_as_a_Team,Constructive_Customer_Comments_to_Review_as_a_Team,Pre-Huddle_Notes,Brainstorm_Solutions,Other_Topics,Huddle_Complete,Surveyid,Alert_Status,Case_Edited_By,Employee_Spotlight,Action_Plan_Measurements_of_Success,Deliver_Better_Customer_Experience,Constructive_Customer_Comments_Root_Causes,Action_Item1,Action_Item2,Customer_Issues_to_be_Raised,Escalated_Issues_Details_(If_applicable),Positive_Employee_Comments_to_Review_as_a_Team,Constructive_Employee_Comments_to_Review_as_a_Team,Constructive_Employee_Comments_Root_Causes,Employee_Issues_to_be_Raised,Action_Plan_Issues,Action_Plan_Actions,Items_to_Raise,Huddle_by_Role,Huddle_Updated,Huddle_by,Huddle_Completed,Survey_Type,Line_of_Business,Line_of_Business_1";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerHuddlesExport CsvToSqlServerHuddlesExport = new   CsvToSqlServerHuddlesExport();
        CsvToSqlServerHuddlesExport.convertCsvToSqlServer();
    }
}
