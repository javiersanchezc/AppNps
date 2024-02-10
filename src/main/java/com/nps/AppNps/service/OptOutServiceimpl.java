package com.nps.AppNps.service;

import com.nps.AppNps.loadProcess.CSV;
import com.nps.AppNps.loadProcess.CsvToSqlServerOptOutExport;
import org.springframework.stereotype.Service;

@Service
public class OptOutServiceimpl implements IOptOutService{

    @Override
    public void LoadScotiabankOutExport(String inputFilePath, String outputFilePath) {
        String headerFileout= "Invitation_Date_EST,Country,First_name,Last_name,Email,Channel_Code,Branch,Agent,Digital_Channel,Survey_opted_out,Region_Name,District_Name,Region_ID,District_ID,Site_Name,Site_ID,Team_Name,Team_ID,Customer_Country,Customer_Integration,Fraud_Type,Fraud_Activity_ID,Fraud_Activity_Description,Advisor_Id,Advisor_Name,cNPS_Survey_Program,Survey_Type,Surveyid,Insurance_Activity_Description,Insurance_Activity_ID,Insurance_Claim_Status,Insurance_Flag,Insurance_Post_Sale_and_Claim,Insurance_Sales_Team,Insurance_Type,Survey_Method,Client_Id,All_Segments,Customer_ID,Customer_Branch,Customer_Branch_Id,Customer_Branch_District_Name,Customer_Branch_District_Id,Customer_Branch_Region_Name,Customer_Branch_Region_Id,Territory,Territory_ID,Region,Region_ID2,Head,Head_ID,Branch_Banking_Region,Branch_Banking_Territory,Investment_Specialist_Branch,Survey_Status,BSC_Agent_ID,BSC_Agent_Name,Client_ID2,Client_Name,BSC_Type,Transit_ID,Transit_Name,Coverage_Team_ID,Coverage_Team_Name,BSC_Agent,CSS_Agent,Relationship_Manager,Tier,Relationship_Team_ID,Relationship_Team_Name";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerOptOutExport CsvToSqlServerOptOutExport = new CsvToSqlServerOptOutExport();
        CsvToSqlServerOptOutExport.convertCsvToSqlServer();
    }
}
