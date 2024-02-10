package com.nps.controller;

import com.nps.AppNps.service.INPSService;
import com.nps.AppNps.service.IWPulseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WpulseController {
    private final IWPulseService service ;

    public WpulseController(IWPulseService service) {
        this.service = service;
    }


    /*******************************Wpulse*********************************************/

    @GetMapping("/WResponse")
    public String getLoad_wPulse_Response_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_wm_response_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_wm_response_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_wPulse_Response_Export(inputFilePath, outputFilePath);

        return "Load_wPulse_Response_Export";
    }


    @GetMapping("/WCallback")
    public String getLoad_wPulse_Callbacks_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_wm_callback_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_wm_callback_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_wPulse_Callbacks_Export(inputFilePath, outputFilePath);

        return "Load_wPulse_Callbacks_Exportsss";
    }

    @GetMapping("/WInvitation")
    public String getLoad_wPulse_Invitation_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_wm_invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_wm_invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_wPulse_Invitation_Export(inputFilePath, outputFilePath);

        return "Load_wPulse_Invitation_Export";
    }

    /*******************************Wpulse*********************************************/

}
