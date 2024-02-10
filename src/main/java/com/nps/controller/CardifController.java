package com.nps.controller;

import com.nps.AppNps.service.ICardifService;
import com.nps.AppNps.service.INPSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardifController {
    private final ICardifService service ;

    public CardifController(ICardifService service) {
        this.service = service;
    }


    /******************************CARDIF*********************************************/

    @GetMapping("/CardifCallbackExport")
    public String getLoad_cPulseInsuranceCardifCallbackExport(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/sb_insurance_cardif_callback_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sb_insurance_cardif_callback_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Insurance_Cardif_Callback_Export(inputFilePath, outputFilePath);

        return "cPulseInsuranceCardifCallbackExport";
    }

    @GetMapping("/CardifInvitationExport")
    public String getLoad_cPulseInsuranceCardifInvitationExport(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/sb_insurance_cardif_Invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sb_insurance_cardif_Invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Insurance_Cardif_Invitations_Export(inputFilePath, outputFilePath);


        return "cPulseInsuranceCardifInvitationExport";
    }
    @GetMapping("/CardifResponsesExport")
    public String getLoad_cPulse_Insurance_Cardif_Responses_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/sb_insurance_cardif_responses_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sb_insurance_cardif_responses_to_vm_modified.csv") String outputFilePath) {
        // Llamada al método del servicio con los valores proporcionados

        service.Load_cPulse_Insurance_Cardif_Responses_Export(inputFilePath, outputFilePath);
        return "cPulse_Insurance_Cardif_Responses_Export";
    }
    @GetMapping("/cPulseInsuranceCardiffOptOutExport")
    public String getLoad_cPulseInsuranceCardiffOptOutExport(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/sb_insurance_cardif_optout_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sb_insurance_cardif_optout_to_vm_modified.csv") String outputFilePath) {
        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Insurance_Cardif_OptOut_Export(inputFilePath, outputFilePath);

        return "cPulseInsuranceCardiffOptOutExport";
    }

}
