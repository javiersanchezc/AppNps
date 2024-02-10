package com.nps.AppNps.service;

public interface ICPulseService {
    void Load_cPulse_Callback_Export(String inputFilePath, String outputFilePath);
    void Load_cPulse_Response_Export(String inputFilePath, String outputFilePath);

    void Load_cPulse_Invitation_Export(String inputFilePath, String outputFilePath);
}
