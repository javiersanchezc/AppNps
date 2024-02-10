package com.nps.AppNps.service;

import com.nps.AppNps.loadProcess.*;
import org.springframework.stereotype.Service;

@Service
public class CardifServiceimpl implements ICardifService {

    @Override
    public void Load_cPulse_Insurance_Cardif_OptOut_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Invitation_Date_EST,Country,First_name,Last_name,Email,Channel_Code,Branch,Agent,Digital_Channel,Survey_opted_out,Region_Name,District_Name,Region_ID,District_ID,Site_Name,Site_ID,Team_Name,Team_ID,Customer_Country,Customer_Integration,Fraud_Type,Fraud_Activity_ID,Fraud_Activity_Description,Advisor_Name,Advisor_Id,cNPS_Survey_Program,Survey_Type,Surveyid int NOT NULL,Insurance_Activity_Description,Insurance_Activity_ID,Insurance_Claim_Status,Insurance_Flag,Insurance_Post_Sale_and_Claim,Insurance_Sales_Team,Insurance_Type,Survey_Method";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerCsvToSqlServercPulseCardiffOptOutExport CardiffOptOutExport = new CsvToSqlServerCsvToSqlServercPulseCardiffOptOutExport();
        CardiffOptOutExport.convertCsvToSqlServer();
    }

    @Override
    public void Load_cPulse_Insurance_Cardif_Invitations_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "First_name,Last_name,Property_name,Property_identifier,Gender,Account_Type,Activity_Description,Activity_ID,Agent_ID,Employee,Category,Channel_Code,Contact_Method,Country,Customer_ID,Customer_Platform,Survey_viewed_on_mobile_device_on_any_page,Segment,Interaction_Date,Customer_Preferred_Language,Product_Code,Product_Description,Product_Feature_Description,Product_Feature_ID,Product_ID,Reference_ID,cNPS_Survey_Program,Salutation,Status_Description,Status_ID,Survey_Method,Channel,Transit_ID,Transit_Name,Invitation_Date_EST,Contact_Status,Outcome,Outcome_Note,Current_status_of_alert,Name,Survey_completed_after_reminder,Survey_status,Survey_Status2,Surveyid,Survey_opted_out,Customer_Integration";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();

        CsvToSqlServerCsvToSqlServercPulseCardifInvitationExport CardifInvitationExport = new CsvToSqlServerCsvToSqlServercPulseCardifInvitationExport();
        CardifInvitationExport.convertCsvToSqlServer();
    }

    @Override
    public void Load_cPulse_Insurance_Cardif_Callback_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Property_name,Property_identifier,Activity_Description,Activity_ID,Agent_ID,Category,Channel_Code,Contact_Method,Country,Customer_ID,Survey_viewed_on_mobile_device_on_any_page,All_Segments,Interaction_Date,Product_Code,Product_Description,Product_Feature_Description,Product_Feature_ID,Product_ID,Reference_ID,Status_Description,Status_ID,Survey_Method,Transit_ID,Channel,Transit_Name,Response_Date_EST,Invitation_Date_EST,Likelihood_to_Recommend,Impact_of_Recent_Interaction,Why,Translations_Why,What_could_we_do_to_serve_you_better,Translations_What_could_we_do_to_serve_you_better,Team_Member,Team_Owner_CCC,Site_Name,Team_Name,Customer_Country,Insurances_offer_Tailor_to_customer_needs,Insurance_Keep_customer_informed,Insurance_Provide_clear_answers,Insurance_Inform_expected_response_times,Product_Reason_For_Rating,Translations_Product_Reason_For_Rating,Insurance_Level_of_effort_to_get_an_answer,Simplicity_of_the_process,Information_received,Process_deadlines,Assistance_received_throughout_the_process,Clarity_in_the_final_answer,Empathy,Effort,Claim_report,First_name,Last_name,Email,Gender,Account_Type,Employee,Business_Phone,Customer_ID2,Customer_Platform,Segment,Home_Phone,Mobile_Phone,Customer_Preferred_Language,Salutation,Closure_Status,Outcome,Outcome_Note,Resolution,Resolution_Note,Customer_Experience_Triggers,Customer_Experience_Triggers_Note,Customer_Reached,Customer_Issue_Escalated,Customer_Issue_Pending,Customer_Suggestions,Coaching_Comments,Additional_Comments,Follow_up_Actions,Current_status_of_alert,All_log_notes_combined_if_any,Alert_close_time,Alert_closed_by,Alert_description,Alert_reopened,Interaction_Date_Timestamp,Number_of_callbacks_attempted,Team_Owner_Digital,Callback_Form_Updated,Rapid_Response_Sent,Customer_Issue_Raised,Customer_Suggestions_Follow_up_Actions_Additional_Comments,Branch_Roles,Select_feedback_for_Huddles,Customer_Integration,Customer_At_Risk_Flag,Does_this_customer_seem_at_risk_to_leave_the_Bank,Callback_Updated_EST,Customer_reached_via_callback,Insurance_Flag,Callback_by,Surveyid,First_name2,Customer_Assignment,Insurance_Post_Sale_and_Claim,Insurance_Claim_Status";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerCsvToSqlServercPulseCardifCallbackExport CardifCallbackExport = new CsvToSqlServerCsvToSqlServercPulseCardifCallbackExport();
        CardifCallbackExport.convertCsvToSqlServer();

    }



    @Override
    public void Load_cPulse_Insurance_Cardif_Responses_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Property_name,Property_identifier,Activity_Description,Activity_ID,Agent_ID,Category,Channel_Code,Contact_Method,Country,Customer_ID,Survey_viewed_on_mobile_device_on_any_page,All_Segments,Interaction_Date,Product_Code,Product_Description,Product_Feature_Description,Product_Feature_ID,Product_ID,Reference_ID,Status_Description,Status_ID,Survey_Method,Transit_ID,Channel,Transit_Name,Response_Date_EST,Invitation_Date_EST,Likelihood_to_Recommend,Impact_of_Recent_Interaction,Why,Translations_Why nvarchar,What_could_we_do_to_serve_you_better,Translations_What_could_we_do_to_serve_you_better,Team_Member,Team_Owner_CCC,Site_Name,Team_Name,Customer_Country,Insurances_offer_Tailor_to_customer_needs,Insurance_Keep_customer_informed,Insurance_Provide_clear_answers,Insurance_Inform_expected_response_times,Product_Reason_For_Rating,Translations_Product_Reason_For_Rating,Insurance_Level_of_effort_to_get_an_answer,Simplicity_of_the_process,Information_received,Process_deadlines,Assistance_received_throughout_the_process,Clarity_in_the_final_answer,Empathy,Effort,Claim_report,First_name,Last_name,Email,Gender,Account_Type,Employee,Business_Phone,Customer_ID2,Customer_Platform,Segment,Home_Phone,Mobile_Phone,Customer_Preferred_Language,Salutation,Closure_Status,Outcome,Outcome_Note,Resolution,Resolution_Note,Customer_Experience_Triggers,Customer_Experience_Triggers_Note,Customer_Reached,Customer_Issue_Escalated,Customer_Issue_Pending,Customer_Suggestions,Coaching_Comments,Additional_Comments,Follow_up_Actions,Current_status_of_alert,All_log_notes_combined_if_any,Alert_close_time,Alert_closed_by,Alert_description,Alert_reopened,Interaction_Date_Timestamp,Number_of_callbacks_attempted,Team_Owner_Digital,Callback_Form_Updated,Rapid_Response_Sent,Customer_Issue_Raised,Customer_Suggestions_Follow_up_Actions_Additional_Comments,Branch_Roles,Select_feedback_for_Huddles,Customer_Integration,Customer_At_Risk_Flag,Does_this_customer_seem_at_risk_to_leave_the_Bank,Callback_Updated_EST,Customer_reached_via_callback,Insurance_Flag,Callback_by,Surveyid,First_name2,Customer_Assignment,Insurance_Post_Sale_and_Claim,Insurance_Claim_Status,Age_Group";

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerCsvToSqlServercPulseCardifResponsesExport CardifResponsesExport = new CsvToSqlServerCsvToSqlServercPulseCardifResponsesExport();
        CardifResponsesExport.convertCsvToSqlServer();

    }
}
