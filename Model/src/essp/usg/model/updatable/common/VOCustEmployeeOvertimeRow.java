package essp.usg.model.updatable.common;

import java.sql.Date;

import oracle.jbo.Row;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Apr 23 11:17:26 PKT 2018
// ---------------------------------------------------------------------
public interface VOCustEmployeeOvertimeRow extends Row {
    int overtimeExists(int employeeID, Date date);
}

