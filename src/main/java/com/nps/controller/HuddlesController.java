package com.nps.controller;

import com.nps.AppNps.service.IHuddlesService;
import com.nps.AppNps.service.INPSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HuddlesController {
    private final IHuddlesService service ;

    public HuddlesController(IHuddlesService service) {
        this.service = service;
    }
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
}
