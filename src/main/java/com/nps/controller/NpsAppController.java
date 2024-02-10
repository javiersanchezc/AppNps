package com.nps.controller;

import com.nps.AppNps.service.INPSService;
import com.nps.AppNps.service.IWPulseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NpsAppController {
    private final INPSService service ;
    private final IWPulseService servicew ;



    public NpsAppController(INPSService service, IWPulseService servicew) {
        this.service = service;
        this.servicew = servicew;
    }

    @GetMapping("/load")
    public String getLoadnps() {
        servicew .Load_wPulse_Invitation_Export();
        servicew.Load_wPulse_Callbacks_Export();
        servicew.Load_wPulse_Response_Export();
        return "Load_wPulse_Invitation_Export";
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











}
