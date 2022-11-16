package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating Compensation [{}]", compensation);

        compensation.setDate(LocalDate.now());
        //compensationRepository.insert(compensation);

        return compensation;
    }

    @Override
    public Compensation read(String empID){
        LOG.debug("Creating Compensation with id [{}]", empID);

        Compensation compensation = null;//compensationRepository.findByEmployeeId(empID);

        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + empID);
        }

        return compensation;
    }


}
