package com.nps.controller;

import com.nps.AppNps.service.IBPulseService;
import com.nps.AppNps.service.INPSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BpulseController {
    private final IBPulseService service ;

    public BpulseController(IBPulseService service) {
        this.service = service;
    }

    @GetMapping("/BPulseDigitalInline")
    public String getLoad_BPulse_digital_inline_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_digital_inline_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_digital_inline_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_BPulse_digital_inline_export(inputFilePath, outputFilePath);

        return "cPulse_digital_inline_export";
    }


    @GetMapping("/bPulseCallback")
    public String getLoad_bPulse_digital_inline_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_callback_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_callback_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_scotiabank_b2b_callback(inputFilePath, outputFilePath);

        return "scotiabank_b2b_callback";
    }

    @GetMapping("/bPulseInvitation")
    public String getLoad_bPulse_Invitation_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_bPulse_Invitation_Export(inputFilePath, outputFilePath);

        return "bPulse_Invitation_Export";
    }


    @GetMapping("/bPulseResponse")
    public String getLoad_cPulse_response_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_responses_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_responses_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_bPulseResponseExport(inputFilePath, outputFilePath);

        return "bPulse_response_export";
    }

}
