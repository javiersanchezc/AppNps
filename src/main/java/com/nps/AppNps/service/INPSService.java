package com.nps.AppNps.service;




public interface INPSService {
    public void  Load_wPulse_Invitation_Export();
    public void Load_wPulse_Callbacks_Export();
    public void Load_wPulse_Response_Export();


    void Load_wPulse_Callbacks_Export(String inputFilePath, String outputFilePath);

    void Load_wPulse_Response_Export(String inputFilePath, String outputFilePath);

    void Load_wPulse_Invitation_Export(String inputFilePath, String outputFilePath);

    void Load_bPulse_digital_inline_export(String inputFilePath, String outputFilePath);

    void Load_scotiabank_enps_responses_team_level(String inputFilePath, String outputFilePath);

    void Load_scotiabank_enps_responses_cx_level(String inputFilePath, String outputFilePath);

    void Load_huddles_export(String inputFilePath, String outputFilePath);

    void Load_cPulse_response_export(String inputFilePath, String outputFilePath);

    void Load_cPulse_Invitation_Export(String inputFilePath, String outputFilePath);

    void Load_cPulse_Insurance_Cardif_Responses_Export(String inputFilePath, String outputFilePath);

    void Load_BPulse_digital_inline_export(String inputFilePath, String outputFilePath);

    void Load_bPulse_Invitation_Export(String inputFilePath, String outputFilePath);

    void Load_scotiabank_b2b_callback(String inputFilePath, String outputFilePath);

    void Load_bPulseResponseExport(String inputFilePath, String outputFilePath);

    void Load_cPulse_Response_Export(String inputFilePath, String outputFilePath);
    void LoadScotiabankOutExport(String inputFilePath, String outputFilePath) ;

    void Load_cPulse_Insurance_Cardif_OptOut_Export(String inputFilePath, String outputFilePath);

    void Load_cPulse_Insurance_Cardif_Invitations_Export(String inputFilePath, String outputFilePath);

    void Load_cPulse_Insurance_Cardif_Callback_Export(String inputFilePath, String outputFilePath);
}
