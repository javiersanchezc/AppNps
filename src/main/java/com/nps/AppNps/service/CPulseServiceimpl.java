package com.nps.AppNps.service;

import com.nps.AppNps.loadProcess.CSV;
import com.nps.AppNps.loadProcess.CsvToSqlServerCPulseCallBacksExport;
import com.nps.AppNps.loadProcess.CsvToSqlServerCPulseInvitationsExport;
import com.nps.AppNps.loadProcess.CsvToSqlServerCPulseResponseExport;
import org.springframework.stereotype.Service;

@Service
public class CPulseServiceimpl implements ICPulseService{
    @Override
    public void Load_cPulse_Response_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "First_name,Last_name,Property_name,Property_identifier,Email,Gender,Account_Type,Activity_Description,Activity_ID,Agent_ID,Employee,Business_Phone,Category,Channel_Code,Contact_Method,Country,Customer_ID,Survey_viewed_mobile_device,Customer_Platform,Segment,All_Segments,Home_Phone,Interaction_Date,Mobile_Phone,Customer_Preferred_Language,Product_Code,Product_Description,Product_Feature_Description,Product_Feature_ID,Product_ID,Reference_ID,Salutation,Status_Description,Status_ID,Survey_Method,Channel,Transit_ID,Transit_Name,Response_Date_EST,Response_Date_Peru_Time,Invitation_Date_EST,Invitation_Date_Peru_Time,Likelihood_Recommend,Impact_Recent_Interaction,Why n,Translations_Why n,Serve_better,Translations_Serve_better,Agent_OSAT,Times_Interacted,needs_resolved,Contact_Status,Permission_Share,Permission_Survey,Permission_Survey_Reason,Closure_Status,Outcome,Outcome_Note n,Resolution,Resolution_Note,Customer_Experience_Triggers,Customer_Experience_Triggers_Note n,Customer_Reached,Customer_Issue_Escalated,Customer_Issue_Pending,Customer_Suggestions,Coaching_Comments n,Additional_Comments,Followup_Actions,Current_status_alert,All_log_notes_combined n,Alert_close_time,Alert_closed_by,Alert_description,Alert_reopened,Interaction_Date_Timestamp,Number_callbacks_attempted,Team_Member,Team_Owner_CCC,Team_Owner_Digital,Callback_Form_Updated,Rapid_Response_Sent,Region_Name,Region_ID,District_Name,District_ID,Site_Name,Site_ID,Team_Name,Team_ID,Customer_Country,Customer_Integration,Fraud_Type,Fraud_Activity_ID,Fraud_Activity_Description,Insurance_Flag,Advisor_Name,Advisor_Id,cNPS_Survey_Program,Survey_Type,Surveyid,Insurance_Activity_Description,Insurance_Activity_ID,Insurance_Claim_Status,Insurance_PostSale_Claim,Insurance_Sales_Team,Insurance_Type,Insurances_offer_Tailor_customer_needs,Insurance_Keep_customer_informed,Insurance_Provide_clear_answers,Insurance_Inform_expected_response_times,Product_Reason_Rating,Insurance_Level_effort_answer,Simplicity_process,Information_received,Process_deadlines,Assistance_received_throughout_process,Clarity_final_answer,Empathy,Effort,Claim_report,Advisor_OSAT,OSAT_Comment n,Financial_Advisor,Flexible_Survey_Length_Chosen,Tailored_Advice,Easy_understand_advice,Ease_Contact,Contact_Frequency,Fulfilled_Commitments,Good_Listener,Valued_customer,Empathic_Interaction,Preparation,Knowledge,Relationship_Drivers_Comment n,BBVA,BCP,Interbank,BanBif,Others,Other_Bank,BBVA_LTR,BCP_LTR,Interbank_LTR,BanBif_LTR,Other_Banks_LTR,Other_Financial_Institutions_Comment n,Contact_Frequency_1,Expected_Business,Other_Comments n,Advisor_Comment n,Santander,Santander_LTR,BCI,BCI_LTR,BICE,BICE_LTR,Itau,Itau_LTR,Security,Security_LTR,Banco_Chile,Banco_Chile_LTR,Scotiabank_Primary_Bank,Banco_Bogota,Banco_Bogota_LTR,Bancolombia,Bancolombia_LTR,Banco_Itau,Banco_Itau_LTR,Davivienda,Davivienda_LTR,Banco_Popular,Banco_Popular_LTR,Banco_BHD_Leon,Banco_BHD_Leon_LTR,Banco_Reservas,Banco_Reservas_LTR,Banco_Santa_Cruz,Banco_Santa_Cruz_LTR,Banco_Promerica,Banco_Promerica_LTR,Republic_Bank,Republic_Bank_LTR,RBC,RBC_LTR,First_Citizens,First_Citizens_LTR,JMMB,JMMB_LTR,NCB,NCB_LTR,Sagicor,Sagicor_LTR,CIBC,CIBC_LTR,JN,JN_LTR,Level_Confidence,Confidence_Level_Comment n,Age_Group,Retail_Journey,Retail_New_Product_Signup_Journey_Step,Retail_Everyday_Banking_Journey_Step,Retail_Help_Advice_Journey_Step,Retail_Product_Renewal_Journey_Step";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerCPulseResponseExport CPulse_Response_Export =new CsvToSqlServerCPulseResponseExport();
        CPulse_Response_Export.convertCsvToSqlServer();
    }

    @Override
    public void Load_cPulse_Invitation_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "First_name,Last_name,Name,Salutation,Property_name,Property_identifier,Email,Gender,Account_Type,Activity_Description,Activity_ID,Agent_ID,Employee,Business_Phone,Category,Category_Code_Description,Channel_Code,Contact_Method,Country,Customer_ID,Customer_Platform,Survey_viewed_mobile_device,Segment,All_Segments,Home_Phone,Interaction_Date,Mobile_Phone,Customer_Preferred_Language,Product_Code,Product_Description n,Product_Feature_Description,Product_Feature_ID,Product_ID,Reference_ID,Status_Description,Status_ID,Survey_Method,Contact_Method_Description,Channel,Channel_Description,Transit_ID,Transit_Name,Agent_Team,Brand,Survey_Type,Response_Date_EST,Invitation_Date_EST,Survey_completed_after_reminder,Survey_Status,Survey_opted_out,Region_Name,District_Name,Region_ID,District_ID,Site_Name,Site_ID,Team_Name,Team_ID,Customer_Country,Customer_Integration,Fraud_Type,Fraud_Activity_ID,Fraud_Activity_Description,Advisor_Name,Advisor_Id,cNPS_Survey_Program,Surveyid,Insurance_Activity_Description,Insurance_Activity_ID,Insurance_Claim_Status,Insurance_Flag,Insurance_PostSale_Claim,Insurance_Sales_Team,Insurance_Type,Age_Group,Retail_Journey,Retail_New_Product_SignUp_Journey_Step,Retail_Everyday_Banking_Journey_Step,Retail_Help_Advice_Journey_Step,Retail_Product_Renewal_Journey_Step";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();

        CsvToSqlServerCPulseInvitationsExport CPulseInvitationsExport = new CsvToSqlServerCPulseInvitationsExport();
        CPulseInvitationsExport.convertCsvToSqlServer();
    }
    @Override
    public void Load_cPulse_Callback_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "";
        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerCPulseCallBacksExport CPulseCallBacksExport = new CsvToSqlServerCPulseCallBacksExport();
        CPulseCallBacksExport.convertCsvToSqlServer();

    }

}
