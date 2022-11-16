package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation){

        LOG.debug("Received Compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    @GetMapping("/CompensationService/{empID}")
    public Compensation read(@PathVariable String empID){

        LOG.debug("Received Compensation create request for id [{}]", empID);

        return compensationService.read(empID);
    }
}
