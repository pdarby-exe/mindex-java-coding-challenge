package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureImpl.class);

    @Autowired
    EmployeeService employeeService;

    @Override
    public String getTotalReports(String empID) {

        Employee emp = employeeService.read(empID);
        Employee temp;

        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(emp);

        List<Employee> rep1 = emp.getDirectReports();
        List<Employee> tempList;

        int count = 0;
        String structure = "";


        //check if employee has subordinates
        if(emp.getDirectReports() != null){

            //Start of outer loop
            for(int i = 0; i < rep1.size(); i++){
                count++;

                temp = employeeService.read(rep1.get(i).getEmployeeId());
                tempList = temp.getDirectReports();


                if (i == 0)
                    structure = structure.concat("(");

                structure = structure.concat(" " + temp.getFirstName() + " " + temp.getLastName());

                if ((rep1.size() > 0 & i != rep1.size() - 1))
                    structure = structure.concat(",");

                //Check if the subordinate has subordinates
                if(temp.getDirectReports() != null){

                    for(int j = 0; j < tempList.size(); j++){
                        count++;

                        if (j == 0)
                            structure = structure.concat("(");

                        temp = employeeService.read(tempList.get(j).getEmployeeId());
                        structure = structure.concat(" " + temp.getFirstName() + " " + temp.getLastName());

                        if ((tempList.size() > 0 & j != tempList.size() - 1))
                            structure = structure.concat(",");

                        if (j == tempList.size() - 1)
                            structure = structure.concat(" ) ");
                    }
                }

                if (i == rep1.size() - 1)
                    structure = structure.concat(")");

            }

        }

        reportingStructure.setNumberOfReports(count);

        if(count > 0)
            structure = " Here is a list of the hierarchy: " +  emp.getFirstName() +
                    " " + emp.getLastName() + structure;

        return reportingStructure + structure;
    }
}
