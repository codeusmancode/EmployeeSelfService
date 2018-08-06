package essp.usg.view;

import essp.usg.view.mHelper.DBConnection;
import essp.usg.view.mHelper.Util;
import essp.usg.view.pageDefs.ADFUtil;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Timestamp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class HODApprovals {
    public HODApprovals() {
    }

    public String approveLeave() {

        Row currentLeave = (Row) ADFUtil.evaluateEL("#{bindings.VOHODLeavesPortal1Iterator.currentRow}");
        currentLeave.setAttribute("Approved", "Y");
        ViewObject voHR = getViewObject("VOLeavesPortalHr1Iterator");
        
        Row row = voHR.createRow();

        row.setAttribute("EmpId", currentLeave.getAttribute("EmpId"));

        row.setAttribute("EmpCode", currentLeave.getAttribute("EmpCode"));
        row.setAttribute("Leavetype", currentLeave.getAttribute("LvTypeCode"));
        row.setAttribute("FromDate", currentLeave.getAttribute("FromDate"));
        row.setAttribute("ToDate", currentLeave.getAttribute("ToDate"));
        row.setAttribute("CreatedBy", currentLeave.getAttribute("CreatedBy"));
        row.setAttribute("TotLvs", currentLeave.getAttribute("TotLvs"));
        row.setAttribute("Approved", currentLeave.getAttribute("Approved"));
        row.setAttribute("Remarks", currentLeave.getAttribute("Remarks"));
        row.setAttribute("DeptId", currentLeave.getAttribute("DeptId"));
        row.setAttribute("Cancel", "N");
        row.setAttribute("Posted", "N");

        //get the current row attribute for notification
        String empCode = currentLeave.getAttribute("EmpCode").toString();
        String emailID = (currentLeave.getAttribute("MailId")==null ? "usmanria2z@usaparel.com":currentLeave.getAttribute("MailId").toString());
        Date fromDate = new Date(System.currentTimeMillis());
        String name = currentLeave.getAttribute("Name").toString();
        String attDate = currentLeave.getAttribute("FromDate").toString();
        String seq = row.getAttribute("SrNo")==null?"000":currentLeave.getAttribute("SrNo").toString();

        System.out.println(seq+" , "+empCode + " , " + emailID + " , " + fromDate + " , " + name);


        String clientIpAddress = ((HttpServletRequest) FacesContext.getCurrentInstance()
                                                                   .getExternalContext()
                                                                   .getRequest()).getRemoteAddr();
        row.setAttribute("UserIp", clientIpAddress);
        saveToDB();
        //notification parameters
        Map params = new HashMap<Object, Object>();

        params.put("action", "ACCEPT");
        params.put("empCode", empCode);
        params.put("emailID", emailID);
        params.put("fromDate", fromDate);
        params.put("name", name);
        callOperation("sendNotification", params);
        
        String currentTime = new java.util.Date(System.currentTimeMillis()).toString();
        String action = "Approve";
        String empID= empCode;
        String email = emailID;
        String fDate = fromDate.toString();
        String client = clientIpAddress;
        
        try{
            logAction(currentTime+"----SEQ:"+seq+", Action:"+action+",Emp Code:"+empID+",Email:"+email+",From Date:"+fDate+",client:"+client);    
        }catch(Exception ex){
            System.out.println("HODApprovals.java: "+ex.getMessage());
        }
        


        ViewObject vo = getViewObject("VOHODLeavesPortal1Iterator");
        vo.executeQuery();


        return null;
    }

    public void logAction(String log)throws Exception {
        Calendar c = Calendar.getInstance();
        File file =
            new File("//home//oracle//essp_logs//" + Util.getSession("sess_username").toString()+c.get(Calendar.YEAR) + "_" + c.get(Calendar.MONTH) + "_" +
                     (c.get(Calendar.DAY_OF_MONTH) + 1) + ".log");
        
        if (!file.exists()) {
                file.createNewFile();
            
        }
        
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(log);
        fileWriter.write(System.getProperty("line.separator"));
        
        fileWriter.write("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        fileWriter.write(System.getProperty("line.separator"));
        fileWriter.close();
      

        


    }

    public void saveToDB() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
    }

    /**
     *unifiy below 2 methods
     * @param action
     * @return
     */
    private Object callAction(String action) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding(action);

        Object result = operationBinding.execute();
        return result;
    }

    private Object reject(String action) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding(action);
        operationBinding.getParamsMap().put("action", "REJECT");
        Object result = operationBinding.execute();
        return result;
    }

    private Object callOperation(String actionName, Map params) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding(actionName);
        if (params != null) {
            System.out.println(" params is not null");
            operationBinding.getParamsMap().putAll(params);
        }
        Object result = operationBinding.execute();
        return result;
    }


    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    private ViewObject getViewObject(String iterator) {
        BindingContainer bindings = getBindings();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding it = bc.findIteratorBinding(iterator);
        return it.getViewObject();
    }

    public String rejectLeave() {
        Row currentLeave = (Row) ADFUtil.evaluateEL("#{bindings.VOHODLeavesPortal1Iterator.currentRow}");
        String empCode = currentLeave.getAttribute("EmpCode").toString();
        String emailID = currentLeave.getAttribute("MailId").toString();
        String name = currentLeave.getAttribute("Name").toString();
        Date fromDate = new Date(System.currentTimeMillis());


        currentLeave.setAttribute("Approved", "N");
        currentLeave.setAttribute("Cancel", "Y");

        saveToDB();
        
        Map params = new HashMap<Object, Object>();
        params.put("action", "REJECT");
        params.put("empCode", empCode);
        params.put("emailID", emailID);
        params.put("fromDate", fromDate);
        params.put("name", name);
        
        callOperation("sendNotification", params);


        String currentTime = new java.util.Date(System.currentTimeMillis()).toString();
        String action = "Reject";
        String empID= empCode;
        String email = emailID;
        String fDate = fromDate.toString();
        String client = ((HttpServletRequest) FacesContext.getCurrentInstance()
                                                                   .getExternalContext()
                                                                   .getRequest()).getRemoteAddr();
        
        try{
            logAction(currentTime+" --- Action:"+action+",Emp Code:"+empID+",Email:"+email+",From Date:"+fDate+",client:"+client);    
        }catch(Exception ex){
            System.out.println("HODApprovals.java: "+ex.getMessage());
        }
        
        
        ViewObject vo = getViewObject("VOHODLeavesPortal1Iterator");
        vo.executeQuery();


        return null;
    }

    public String b3_action() {

        try {
            logAction("action approved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
