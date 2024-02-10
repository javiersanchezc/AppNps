package com.nps.AppNps.service;

public interface IWPulseService {
    public void  Load_wPulse_Invitation_Export();
    public void Load_wPulse_Callbacks_Export();
    public void Load_wPulse_Response_Export();
    void Load_wPulse_Callbacks_Export(String inputFilePath, String outputFilePath);

    void Load_wPulse_Response_Export(String inputFilePath, String outputFilePath);

    void Load_wPulse_Invitation_Export(String inputFilePath, String outputFilePath);
}
