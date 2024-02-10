package com.nps.controller;

import com.nps.AppNps.service.INPSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NpsAppController {
    private final INPSService service ;

    public NpsAppController(INPSService service) {
        this.service = service;
    }

    @GetMapping("/load")
    public String getLoadnps() {
        service .Load_wPulse_Invitation_Export();
        service.Load_wPulse_Callbacks_Export();
        service.Load_wPulse_Response_Export();
        return "Load_wPulse_Invitation_Export";
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




    /*******************************Bpulse*********************************************/



    @GetMapping("/BPulse_digital_inline_export")
    public String getLoad_BPulse_digital_inline_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_digital_inline_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_digital_inline_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_BPulse_digital_inline_export(inputFilePath, outputFilePath);

        return "cPulse_digital_inline_export";
    }


    @GetMapping("/scotiabank_b2b_callback")
    public String getLoad_bPulse_digital_inline_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_cPulse_callbacks_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_cPulse_callbacks_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_scotiabank_b2b_callback(inputFilePath, outputFilePath);

        return "scotiabank_b2b_callback";
    }

    @GetMapping("/bPulse_Invitation_Export")
    public String getLoad_bPulse_Invitation_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_bPulse_Invitation_Export(inputFilePath, outputFilePath);

        return "bPulse_Invitation_Export";
    }


    @GetMapping("/bPulse_response_export")
    public String getLoad_cPulse_response_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_b2b_responses_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_b2b_responses_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_bPulseResponseExport(inputFilePath, outputFilePath);

        return "bPulse_response_export";
    }



    /*******************************levels*********************************************/


    @GetMapping("/scotiabank_enps_responses_cx_level")
    public String getLoad_scotiabank_enps_responses_cx_level(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_wm_invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_wm_invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_scotiabank_enps_responses_cx_level(inputFilePath, outputFilePath);

        return "scotiabank_enps_responses_cx_level";
    }
    @GetMapping("/scotiabank_enps_responses_team_level")
    public String getLoad_scotiabank_enps_responses_team_level(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_wm_invitations_to_vm_historical_2022_to_2023_2023-12-08.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_wm_invitations_to_vm_historical_2022_to_2023_2023-12-08_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_scotiabank_enps_responses_team_level(inputFilePath, outputFilePath);

        return "scotiabank_enps_responses_team_level";
    }

    /*******************************levels*********************************************/



    /*******************************Cpulse*********************************************/





    @GetMapping("/cPulse_Invitation_Export")
    public String getLoad_cPulse_Invitation_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_cpulse_invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_cpulse_invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Invitation_Export(inputFilePath, outputFilePath);

        return "cPulse_Invitation_Export";
    }


    @GetMapping("/cPulse_Response_Export")
    public String getLoad_cPulse_Response_Export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_cpulse_response_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_cpulse_response_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Response_Export(inputFilePath, outputFilePath);

        return "cPulse_Response_Export";
    }



    /*******************************Cpulse*********************************************/






    /*******************************OutExport*********************************************/

    @GetMapping("/OutExport")
    public String getLoadOutExport(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_optout_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sscotiabank_optout_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.LoadScotiabankOutExport(inputFilePath, outputFilePath);

        return "OutExport";
    }

    /*******************************OutExport*********************************************/


    /*******************************huddles*********************************************/

    @GetMapping("/huddles_export")
    public String getLoad_huddles_export(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/scotiabank_huddle_callbacks_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/scotiabank_huddle_callbacks_to_vm.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_huddles_export(inputFilePath, outputFilePath);

        return "huddles_export";
    }

    /*******************************huddles*********************************************/

    /******************************CARDIF*********************************************/

    @GetMapping("/cPulseInsuranceCardifCallbackExport")
    public String getLoad_cPulseInsuranceCardifCallbackExport(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/sb_insurance_cardif_callback_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sb_insurance_cardif_callback_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Insurance_Cardif_Callback_Export(inputFilePath, outputFilePath);

        return "cPulseInsuranceCardifCallbackExport";
    }

    @GetMapping("/cPulseInsuranceCardifInvitationExport")
    public String getLoad_cPulseInsuranceCardifInvitationExport(
            @RequestParam(name = "inputFilePath", defaultValue = "C:/data/sb_insurance_cardif_Invitations_to_vm.csv") String inputFilePath,
            @RequestParam(name = "outputFilePath", defaultValue = "C:/data/sb_insurance_cardif_Invitations_to_vm_modified.csv") String outputFilePath) {

        // Llamada al método del servicio con los valores proporcionados
        service.Load_cPulse_Insurance_Cardif_Invitations_Export(inputFilePath, outputFilePath);


        return "cPulseInsuranceCardifInvitationExport";
    }
    @GetMapping("/cPulse_Insurance_Cardif_Responses_Export")
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
    /*******************************CARDIF*********************************************/
}
