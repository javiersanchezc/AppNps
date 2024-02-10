package com.nps.controller;

import com.nps.AppNps.service.ICPulseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CpulseController {
    private final ICPulseService service ;

    public CpulseController(ICPulseService service) {
        this.service = service;
    }


    /*******************************Cpulse*********************************************/





    @GetMapping("/cPulseInvitation")
    public String getLoad_cPulse_Invitation_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_cpulse_invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_cpulse_invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Invitation_Export(inputFilePath, outputFilePath);

        return "cPulse_Invitation_Export";
    }


    @GetMapping("/cPulseResponse")
    public String getLoad_cPulse_Response_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_cpulse_response_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_cpulse_response_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Response_Export(inputFilePath, outputFilePath);

        return "cPulse_Response_Export";
    }

    @GetMapping("/cPulseCallback")
    public String getLoad_cPulseCallbacks_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_cpulse_callback_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_cpulse_callback_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Callback_Export(inputFilePath, outputFilePath);

        return "cPulse_Response_Export";
    }

    /*******************************Cpulse*********************************************/



}
