package com.nps.AppNps.service;

public interface IBPulseService {
    void Load_BPulse_digital_inline_export(String inputFilePath, String outputFilePath);

    void Load_bPulse_Invitation_Export(String inputFilePath, String outputFilePath);

    void Load_scotiabank_b2b_callback(String inputFilePath, String outputFilePath);

    void Load_bPulseResponseExport(String inputFilePath, String outputFilePath);
}
