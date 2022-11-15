package com.mindex.challenge.controller;

import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingStructureController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    @GetMapping("/ReportingStructureService/{empID}")
    public String getTotalReports(@PathVariable String empID) {
        LOG.debug("Received Reporting Structure read request for empID [{}]", empID);

        return reportingStructureService.getTotalReports(empID);
    }
}

