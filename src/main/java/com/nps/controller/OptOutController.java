package com.nps.controller;

import com.nps.AppNps.service.INPSService;
import com.nps.AppNps.service.IOptOutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OptOutController {
    private final IOptOutService service ;

    public OptOutController(IOptOutService service) {
        this.service = service;
    }
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
}
