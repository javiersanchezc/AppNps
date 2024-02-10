package com.nps.AppNps.service;

import com.nps.AppNps.loadProcess.CSV;
import com.nps.AppNps.loadProcess.CsvToSqlServerWPulseCallbacksExport;
import com.nps.AppNps.loadProcess.CsvToSqlServerWPulseInvitationsExport;
import com.nps.AppNps.loadProcess.CsvToSqlServerWPulse_Response_Export;
import org.springframework.stereotype.Service;

@Service
public class WPulseServiceimpl  implements IWPulseService{

    @Override
    public void Load_wPulse_Invitation_Export() {
        String inputFilePath = "C:/data/scotiabank_wm_invitations_to_vm_historical_2022_to_2023_2023-12-08.csv";
        String outputFilePath = "C:/data/scotiabank_wm_invitations_to_vm_historical_2022_to_2023_2023-12-08_modified.csv";
        String headerFileout= "Surveyid,Name,Client_Id,Client_Open_Date,Email,Investment_Specialist,Invitation_date,Reference_ID,Invitation_Date_EST,All_Segments,Assests_Under_Administration_Integer,Assets_Under_Administration_Bucket,Business_Phone,Client_City,Client_Street_Address,Client_Postal_Code,Client_Province,Country,Country_Description,Customer_Country,Investable_Asset_Tier,Risk_Tolerance,Share_of_Wallet_Bucket,Share_of_Wallet_Fraction,Age_Group,Customer_Branch,Customer_Branch_District_Id,Customer_Branch_District_Name,Customer_Branch_Id,Customer_Branch_Region_Id,Customer_Branch_Region_Name,Customer_ID,Customer_Preferred_Language,Development_Cycle,First_Name,Last_Name,Survey_Method,Survey_Type,Tenure,Branch_Banking_Region,Branch_Banking_Territory,Head,Head_ID,Investment_Specialist_Branch,Investment_Specialist_ID,Region,Region_ID,Survey_Status,Territory,Territory_ID";//  CSV csvTransformer = new CSV(inputFilePath, outputFilePath);

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();


        CsvToSqlServerWPulseInvitationsExport load_wPulse = new CsvToSqlServerWPulseInvitationsExport();
        load_wPulse.convertCsvToSqlServer();
    }

    @Override
    public void Load_wPulse_Callbacks_Export() {
        String inputFilePath = "C:/data/scotiabank_wm_callback_to_vm_11012021_10312022_2024-01-05.csv";
        String outputFilePath = "C:/data/scotiabank_wm_callback_to_vm_11012021_10312022_2024-01-05_modified.csv";
        String headerFileout= " Name,Surveyid, Email, Invitation_date, Responsedate, All_Segments, Number_of_callbacks_attempted, Closure_Status,    Customer_Issue_Pending, Customer_Issue_Raised, Customer_Suggestions_Follow,    Outcome, Outcome_Note, Customer_Experience_Triggers_Note,     Customer_Experience_Triggers, Select_feedback_for_Huddles_, Investment_Specialist, Age_Group, Assests_Under_Administration_Integer,   Assets_Under_Administration_Bucket, Customer_Branch_Region_Name,Callback_Role, Client_City, Client_Id, Client_Open_Date, Client_Province, Client_Street_Address, Customer_Branch_District_Id, Customer_Branch_District_Name, Customer_Branch_Id, Customer_Branch, Customer_Branch_Region_Id, Investable_Asset_Tier, Client_Postal_Code, Reference_ID, Risk_Tolerance, Share_of_Wallet_Bucket, Share_of_Wallet_Fraction, Tenure, Development_Cycle, Survey_Type, Country_Description, Country, Customer_Country, Customer_ID, First_Name, Last_Name, Business_Phone, Customer_Preferred_Language, Survey_Method, Investment_Specialist_ID, Survey_Status, Investment_Specialist_Branch, Branch_Banking_Territory, Branch_Banking_Region, Head_ID, Head, Region_ID, Region, Territory_ID, Territory, Invitation_Date_EST, Response_Date_EST, Additional_Feedback, Investment_Advisor_OSAT, Why_WM_Other_Banks, Consolidating_accounts, BanBif_LTR, BanBif, Banco_de_Chile_LTR, Banco_de_Chile, BBVA_LTR, BBVA, BCI_LTR, BCI, BCP_LTR, BCP, BICE_LTR, BICE, BMO_LTR, BMO, Expected_Business, CIBC_LTR, CIBC, Client_Value, Fulfilled_Commitments, Relationship_Drivers_Comment, Ease_of_Contact, Effectiveness, Partner_Engagement, Investment_Specialist_OSAT_Comment, None, Flexible_survey_length_chosen, Intelligo_LTR, Intelligo, Itau_LTR, Itau, Do_you_know_your_Scotiabank_Investment_Banker, Know_My_Business, LTR_Comment, Relationship_LTR, None2, OpsOpsOther_Financial_Institution_Name, Other_Financial_Institution, Other_Financial_Institutions_Comment, Other_LTR, Other_Financial_Institution2, Other, Financial_plan_review, Portfolio_Performance_Investment_Solutions, Is_Scotiabank_your_Primary_Banking_Partner, Timely_Advice, RBC_LTR, RBC, Investment_Specialists_Contact_Frequency, Retirement, Santander_LTR, Santander, Education_savings, Security_LTR, Security, Investment_Specialist_OSAT, TD_LTR, TD, Relationship_Trust, Understanding_Needs, Advice_and_Solutions, Callback_Updated_EST, Callback_by, Accival_Citibanamex, Citibanamex_(Banca_Patrimonial_Privada), BBVA_Banca_Patrimonial_Privada, Banorte_IXE_(Banca_Patrimonial_Privada), HSBC_Banca_Patrimonial_Privada, Inbursa_(Banca_Patrimonial_Privada), Santander_(Banca_Patrimonial_Privada), UBS, Bank_Of_America, JP_Morgan, Credit_Suisse, Goldman_Sachs, Accival_Citibanamex_LTR, Citibanamex_Banca_Patrimonial_Privada_LTR, BBVA_Banca_Patrimonial_Privada_LTR, Banorte_IXE_Banca_Patrimonial_Privada, HSBC_Banca_Patrimonial_Privada_LTR, Inbursa_Banca_Patrimonial_Privada, Santander_Banca_Patrimonial_Privada_LTR, UBS_LTR, Bank_Of_America_LTR, JP_Morgan_LTR, Credit_Suisse_LTR, Goldman_Sachs_LTR, _MEXICO_Secondary_Is_Scotiabank_your_Primary_Banking_Partner";//  CSV csvTransformer = new CSV(inputFilePath, outputFilePath);

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerWPulseCallbacksExport csvToSqlServerwPulseCallbacksExport = new CsvToSqlServerWPulseCallbacksExport();
        csvToSqlServerwPulseCallbacksExport.convertCsvToSqlServer();
    }

    @Override
    public void Load_wPulse_Response_Export() {
        String inputFilePath = "C:/data/scotiabank_wm_invitations_to_vm_historical_2022_to_2023_2023-12-08.csv";
        String outputFilePath = "C:/data/scotiabank_wm_invitations_to_vm_historical_2022_to_2023_2023-12-08_modified.csv";
        String headerFileout= "Name,SurveyID,AgeGroup,AllSegments,AssetsUnderAdministrationInteger,AssetsUnderAdministrationBucket,BusinessPhone,ClientCity,ClientId,ClientStreetAddress,ClientOpenDate,ClientPostalCode,ClientProvince,Country,CountryDescription,CustomerCountry,CustomerID,Email,InvestableAssetTier,InvestmentSpecialist,InvitationDate,ReferenceID,RiskTolerance,ShareOfWalletBucket,ShareOfWalletFraction,Tenure,InvitationDateEST,CustomerBranch,CustomerBranchDistrictId,CustomerBranchDistrictName,CustomerBranchId,CustomerBranchRegionId,CustomerBranchRegionName,CustomerPreferredLanguage,DevelopmentCycle,FirstName,LastName,SurveyMethod,SurveyType,Head,HeadID,InvestmentSpecialistID,Region,RegionID,Territory,TerritoryID,ResponseDate,BranchBankingRegion,Branch,BranchBankingTerritory,InvestmentSpecialistBranch,ResponseDateEST,SurveyStatus,KnowYourScotiabankInvestmentBanker,InvestmentAdvisorOSAT,LTRComment,RelationshipLTR,AdviceAndSolutions,ClientValue,EaseOfContact,FlexibleSurveyLengthChosen,FulfilledCommitments,nvestmentSpecialistOSAT,InvestmentSpecialistOSATComment,InvestmentSpecialistsContactFrequency,IsScotiabankYourPrimaryBankingPartner,KnowMyBusiness,PartnerEngagement,PortfolioPerformanceInvestmentSolutions,UnderstandingNeeds,BanBif,BBVA,BCP,BMO,CIBC,Intelligo,OtherFinancialInstitution,RBC,TD,BanBifLTR,BBVALTR,BCPLTR,BMOLTR,CIBCLTR,ConsolidatingAccounts,EducationSavings,FinancialPlanReview,IntelligoLTR,None,Other,OtherFinancialInstitution2,OpsOpsOtherFinancialInstitutionName,OtherFinancialInstitutionsComment,OtherLTR,RBC_LTR,RelationshipDriversComment,Retirement,TD_LTR,AdditionalFeedback,BancoDeChile,BancoDeChileLTR,BCI,BCILTR,BICE,BICELTR,Effectiveness,ExpectedBusiness,Itau,ItauLTR,RelationshipTrust,Santander,SantanderLTR,Security,SecurityLTR,TimelyAdvice,Why_WM_OtherBanks,AccivalCitibanamex,CitibanamexBancaPatrimonialPrivada,BBVABancaPatrimonialPrivada,BanorteIXEBancaPatrimonialPrivada,HSBCBancaPatrimonialPrivada,InbursaBancaPatrimonialPrivada,SantanderBancaPatrimonialPrivada,UBS,BankOfAmerica,JPMorgan,CreditSuisse,GoldmanSachs,AccivalCitibanamexLTR,CitibanamexBancaPatrimonialPrivadaLTR,BBVABancaPatrimonialPrivadaLTR,BanorteIXEBancaPatrimonialPrivadaLTR,HSBCBancaPatrimonialPrivadaLTR,InbursaBancaPatrimonialPrivadaLTR,SantanderBancaPatrimonialPrivadaLTR,UBSLTR,BankOfAmericaLTR,JPMorganLTR,CreditSuisseLTR,GoldmanSachsLTR,MexicoSecondaryIsScotiabankYourPrimaryBankingPartner";//  CSV csvTransformer = new CSV(inputFilePath, outputFilePath);

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerWPulse_Response_Export csvToSqlServerWPulse_Response_Export = new CsvToSqlServerWPulse_Response_Export();
        csvToSqlServerWPulse_Response_Export.convertCsvToSqlServer();

    }

    @Override
    public void Load_wPulse_Callbacks_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Name,Surveyid,Email,Invitation_date,Responsedate,All_Segments,Number_of_callbacks_attempted,Closure_Status,Customer_Issue_Pending,Customer_Issue_Raised,Customer_Suggestions_Follow,Outcome,Outcome_Note,Customer_Experience_Triggers_Note,Customer_Experience_Triggers,Select_feedback_for_Huddles_,Investment_Specialist,Age_Group,Assests_Under_Administration_Integer,Assets_Under_Administration_Bucket,Customer_Branch_Region_Name,Callback_Role,Client_City,Client_Id,Client_Open_Date,Client_Province,Client_Street_Address,Customer_Branch_District_Id,Customer_Branch_District_Name,Customer_Branch_Id,Customer_Branch,Customer_Branch_Region_Id,Investable_Asset_Tier,Client_Postal_Code,Reference_ID,Risk_Tolerance,Share_of_Wallet_Bucket,Share_of_Wallet_Fraction,Tenure,Development_Cycle,Survey_Type,Country_Description,Country,Customer_Country,Customer_ID,First_Name,Last_Name,Business_Phone,Customer_Preferred_Language,Survey_Method,Investment_Specialist_ID,Survey_Status,Investment_Specialist_Branch,Branch_Banking_Territory,Branch_Banking_Region,Head_ID,Head,Region_ID,Region,Territory_ID,Territory,Invitation_Date_EST varchar(100) NULL,Response_Date_EST,Additional_Feedback,Investment_Advisor_OSAT,Why_WM_Other_Banks,Consolidating_accounts,BanBif_LTR,BanBif,Banco_de_Chile_LTR,Banco_de_Chile,BBVA_LTR,BBVA,BCI_LTR,BCI,BCP_LTR,BCP,BICE_LTR,BICE,BMO_LTR,BMO,Expected_Business,CIBC_LTR,CIBC,Client_Value,Fulfilled_Commitments,Relationship_Drivers_Comment,Ease_of_Contact,Effectiveness,Partner_Engagement,Investment_Specialist_OSAT_Comment,None,Flexible_survey_length_chosen,Intelligo_LTR,Intelligo,Itau_LTR,Itau,Do_you_know_your_Scotiabank_Investment_Banker,Know_My_Business,LTR_Comment,Relationship_LTR,None2,OpsOpsOther_Financial_Institution_Name,Other_Financial_Institution,Other_Financial_Institutions_Comment,Other_LTR,Other_Financial_Institution2,Other,Financial_plan_review,Portfolio_Performance_Investment_Solutions,Is_Scotiabank_your_Primary_Banking_Partner,Timely_Advice,RBC_LTR,RBC,Investment_Specialists_Contact_Frequency,Retirement,Santander_LTR,Santander,Education_savings,Security_LTR,Security,Investment_Specialist_OSAT,TD_LTR,TD,Relationship_Trust,Understanding_Needs,Advice_and_Solutions,Callback_Updated_EST,Callback_by,Accival_Citibanamex,Citibanamex_(Banca_Patrimonial_Privada),BBVA_Banca_Patrimonial_Privada,Banorte_IXE_(Banca_Patrimonial_Privada),HSBC_Banca_Patrimonial_Privada,Inbursa_(Banca_Patrimonial_Privada),Santander_(Banca_Patrimonial_Privada),UBS,Bank_Of_America,JP_Morgan,Credit_Suisse,Goldman_Sachs,Accival_Citibanamex_LTR,Citibanamex_Banca_Patrimonial_Privada,BBVA_Banca_Patrimonial_Privada_LTR,Banorte_IXE_Banca_Patrimonial_Privada,HSBC_Banca_Patrimonial_Privada_LTR,Inbursa_Banca_Patrimonial_Privada,Santander_Banca_Patrimonial_Privada,UBS_LTR,Bank_Of_America_LTR,JP_Morgan_LTR,Credit_Suisse_LTR,Goldman_Sachs_LTR,MEXICO_Secondary_Is_Scotiabank_your_Primary_Banking_Partner";
        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerWPulseCallbacksExport callbacksExport = new CsvToSqlServerWPulseCallbacksExport();
        callbacksExport.convertCsvToSqlServer();
    }

    @Override
    public void Load_wPulse_Response_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Name,SurveyID,AgeGroup,AllSegments,AssetsUnderAdministrationInteger,AssetsUnderAdministrationBucket,BusinessPhone,ClientCity,ClientId,ClientStreetAddress,ClientOpenDate,ClientPostalCode,ClientProvince,Country,CountryDescription,CustomerCountry,CustomerID,Email,InvestableAssetTier,InvestmentSpecialist,InvitationDate,ReferenceID,RiskTolerance,ShareOfWalletBucket,ShareOfWalletFraction,Tenure,InvitationDateEST,CustomerBranch,CustomerBranchDistrictId,CustomerBranchDistrictName,CustomerBranchId,CustomerBranchRegionId,CustomerBranchRegionName,CustomerPreferredLanguage,DevelopmentCycle,FirstName,LastName,SurveyMethod,SurveyType,Head,HeadID,InvestmentSpecialistID,Region,RegionID,Territory,TerritoryID,ResponseDate,BranchBankingRegion,Branch,BranchBankingTerritory,InvestmentSpecialistBranch,ResponseDateEST,SurveyStatus,KnowYourScotiabankInvestmentBanker,InvestmentAdvisorOSAT,LTRComment,RelationshipLTR,AdviceAndSolutions,ClientValue,EaseOfContact,FlexibleSurveyLengthChosen,FulfilledCommitments,nvestmentSpecialistOSAT,InvestmentSpecialistOSATComment,InvestmentSpecialistsContactFrequency,IsScotiabankYourPrimaryBankingPartner,KnowMyBusiness,PartnerEngagement,PortfolioPerformanceInvestmentSolutions,UnderstandingNeeds,BanBif,BBVA,BCP,BMO,CIBC,Intelligo,OtherFinancialInstitution,RBC,TD,BanBifLTR,BBVALTR,BCPLTR,BMOLTR,CIBCLTR,ConsolidatingAccounts,EducationSavings,FinancialPlanReview,IntelligoLTR,None,Other,OtherFinancialInstitution2,OpsOpsOtherFinancialInstitutionName,OtherFinancialInstitutionsComment,OtherLTR,RBC_LTR,RelationshipDriversComment,Retirement,TD_LTR,AdditionalFeedback,BancoDeChile,BancoDeChileLTR,BCI,BCILTR,BICE,BICELTR,Effectiveness,ExpectedBusiness,Itau,ItauLTR,RelationshipTrust,Santander,SantanderLTR,Security,SecurityLTR,TimelyAdvice,Why_WM_OtherBanks,AccivalCitibanamex,CitibanamexBancaPatrimonialPrivada,BBVABancaPatrimonialPrivada,BanorteIXEBancaPatrimonialPrivada,HSBCBancaPatrimonialPrivada,InbursaBancaPatrimonialPrivada,SantanderBancaPatrimonialPrivada,UBS,BankOfAmerica,JPMorgan,CreditSuisse,GoldmanSachs,AccivalCitibanamexLTR,CitibanamexBancaPatrimonialPrivadaLTR,BBVABancaPatrimonialPrivadaLTR,BanorteIXEBancaPatrimonialPrivadaLTR,HSBCBancaPatrimonialPrivadaLTR,InbursaBancaPatrimonialPrivadaLTR,SantanderBancaPatrimonialPrivadaLTR,UBSLTR,BankOfAmericaLTR,JPMorganLTR,CreditSuisseLTR,GoldmanSachsLTR,MexicoSecondaryIsScotiabankYourPrimaryBankingPartner";//  CSV csvTransformer = new CSV(inputFilePath, outputFilePath);

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();
        CsvToSqlServerWPulse_Response_Export csvToSqlServerWPulse_Response_Export = new CsvToSqlServerWPulse_Response_Export();
        csvToSqlServerWPulse_Response_Export.convertCsvToSqlServer();

    }

    @Override
    public void Load_wPulse_Invitation_Export(String inputFilePath, String outputFilePath) {
        String headerFileout= "Surveyid,Name,Client_Id,Client_Open_Date,Email,Investment_Specialist,Invitation_date,Reference_ID,Invitation_Date_EST,All_Segments,Assests_Under_Administration_Integer,Assets_Under_Administration_Bucket,Business_Phone,Client_City,Client_Street_Address,Client_Postal_Code,Client_Province,Country,Country_Description,Customer_Country,Investable_Asset_Tier,Risk_Tolerance,Share_of_Wallet_Bucket,Share_of_Wallet_Fraction,Age_Group,Customer_Branch,Customer_Branch_District_Id,Customer_Branch_District_Name,Customer_Branch_Id,Customer_Branch_Region_Id,Customer_Branch_Region_Name,Customer_ID,Customer_Preferred_Language,Development_Cycle,First_Name,Last_Name,Survey_Method,Survey_Type,Tenure,Branch_Banking_Region,Branch_Banking_Territory,Head,Head_ID,Investment_Specialist_Branch,Investment_Specialist_ID,Region,Region_ID,Survey_Status,Territory,Territory_ID";//  CSV csvTransformer = new CSV(inputFilePath, outputFilePath);

        CSV csvTransformer = new CSV(inputFilePath, outputFilePath, headerFileout);
        csvTransformer.transformCsv();


        CsvToSqlServerWPulseInvitationsExport load_wPulse = new CsvToSqlServerWPulseInvitationsExport();
        load_wPulse.convertCsvToSqlServer();
    }

}
