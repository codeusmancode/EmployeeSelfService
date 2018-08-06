import essp.usg.view.mHelper.Util;

import essp.usg.view.pageDefs.ADFUtil;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class LandingPage {
    public LandingPage() {
    }

    public void exit() {
        System.out.println("exitint");
    }


    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    private Object callAction(String action) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding(action);
        Object result = operationBinding.execute();
        return result;
    }

    private ViewObject getViewObject(String iterator) {
        BindingContainer bindings = getBindings();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding it = bc.findIteratorBinding(iterator);
        return it.getViewObject();
    }


    private void saveToHR() {
        Row currentLeave = (Row) ADFUtil.evaluateEL("#{bindings.VOEOLeavesPortal1Iterator.currentRow}");

        ViewObject voHR = getViewObject("VOLeavesPortalHr1Iterator");

        Row row = voHR.createRow();

        row.setAttribute("EmpId", currentLeave.getAttribute("EmpId"));
        System.out.println(currentLeave.getAttribute("EmpId") + "<<");
        row.setAttribute("EmpCode", currentLeave.getAttribute("EmpCode"));
        System.out.println(currentLeave.getAttribute("Leavetype") + "<<");
        row.setAttribute("Leavetype", currentLeave.getAttribute("Leavetype"));
        System.out.println(currentLeave.getAttribute("FromDate") + "<<");
        row.setAttribute("FromDate", currentLeave.getAttribute("FromDate"));
        System.out.println(currentLeave.getAttribute("ToDate") + "<<");
        row.setAttribute("ToDate", currentLeave.getAttribute("ToDate"));
        System.out.println(currentLeave.getAttribute("CreatedBy") + "<<");
        row.setAttribute("CreatedBy", currentLeave.getAttribute("CreatedBy"));
        System.out.println(currentLeave.getAttribute("TotLvs") + "<<");
        row.setAttribute("TotLvs", currentLeave.getAttribute("TotLvs"));
        System.out.println(currentLeave.getAttribute("Approved") + "<<");
        row.setAttribute("Approved", currentLeave.getAttribute("Approved"));
        System.out.println(currentLeave.getAttribute("Remarks") + "<<");
        row.setAttribute("Remarks", currentLeave.getAttribute("Remarks"));
        System.out.println(currentLeave.getAttribute("DeptId") + "<<");
        row.setAttribute("DeptId", currentLeave.getAttribute("DeptId"));

        row.setAttribute("Cancel", "N");
        row.setAttribute("Posted", "N");
    }

    public String saveToDb() {
        int returnCode = new Integer(callAction("submitLeaveAction").toString());
        switch (returnCode) {
        case 1:

            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding("Commit");
            Object result = operationBinding.execute();


            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }
            //if user does not have hod then by default approve his leave
            if (ADFContext.getCurrent()
                          .getSessionScope()
                          .get("sess_hod")
                          .equals("none")) {
                saveToHR();
                result = operationBinding.execute();
            }

            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }

            Util.showMessage("Leave Applied.");
            callAction("CreateInsert");
            break;
        case 9:
            Util.showMessage("Low Leave Balance");
            break;
        case 10:
            Util.showMessage("'ToDate cannot be earlier then 'FromDate'");
        case 2:
            Util.showMessage("Enter 'To Date'");
            break;
        case 8:
            Util.showMessage("You cannot Apply leave after 48 hours, Contact HR Time Office.");
            break;
        case 6:
            Util.showMessage("You were present on this day,can't apply leave.");
            break;
        case 7:
            Util.showMessage("You have already availd 2 short leaves in this month");
            break;
        case 5:
            Util.showMessage("Time of absence is greater then short leave period, you may apply half leave instead");
            break;
        case 4:
            Util.showMessage("You need to select a 'Leave Type' from list of values");
            break;
        case 3:
            Util.showMessage("'FromDate' can't be empty");
            break;
        case 20:
            Util.showMessage("You must enter the  Time with Date");
            break;
        case 22:
            Util.showMessage("You must enter the  Time with Date");
            break;
        case 23:
            Util.showMessage("You must enter time with date for half casual leave.");
            break;
        case 26:
            Util.showMessage("You have already applied leave on this date");
            break;
        case 27:
            Util.showMessage("To apply Compensatory Leave Kindly contact HR Time Office.");
            break;
        }

        return null;
    }
}
