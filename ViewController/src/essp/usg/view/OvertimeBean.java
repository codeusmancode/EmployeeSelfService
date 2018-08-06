package essp.usg.view;

import essp.usg.view.mHelper.Util;

import essp.usg.view.pageDefs.ADFUtil;

import java.sql.Date;

import java.util.HashMap;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class OvertimeBean {
    private RichTable overtimeTable;

    public OvertimeBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String commitOvertime() {

        Map params = new HashMap<String, Object>();
        params.put("employeeID", ADFContext.getCurrent()
                                           .getPageFlowScope()
                                           .get("employee_id"));
        params.put("date", ADFContext.getCurrent()
                                     .getPageFlowScope()
                                     .get("overtime_date"));

        int exists = Integer.parseInt(Util.callOperation(getBindings(), "overtimeExists", params).toString());
        if (exists > 0) {
            Util.showMessage("This Employee's overtime is already entered.");
            return null;
        }
        BindingContainer bindings = getBindings();

        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }

        Util.callOperation(bindings, "CreateInsert", null);
        FacesContext context = FacesContext.getCurrentInstance();

        RichTable r = getOvertimeTable();
    
        for (Object selectedRowKey : r.getSelectedRowKeys()) {
            this.getOvertimeTable().setActiveRowKey(selectedRowKey);
            
            String rowId = r.getClientRowKeyManager().getClientRowKey(context, r, selectedRowKey);
            //System.out.println(rowId);
            AdfFacesContext.getCurrentInstance().addPartialTarget(getOvertimeTable());
            ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
            erks.addScript(context, "setFocusByComponentId('" + "pt1:r1:0:t1:"+rowId+":employeeIdId" + "')");

        }

      

        return null;
    }

    public void autoOvertimeRecValues() {
        System.out.println(" debug:");
        //Util.callOperation(getBindings(), "CreateInsert", null);

        //Row currentLeave = (Row) ADFUtil.evaluateEL("#{bindings.VOCustEmployeeOvertime1Iterator.currentRow}");
        //currentLeave.setAttribute("EmployeeId", "1234");

    }

    public void overtimeDateChanged(ValueChangeEvent valueChangeEvent) {

        //        java.util.Date date = (java.util.Date) valueChangeEvent.getNewValue();
        //        System.out.println("previous set date:"+ADFContext.getCurrent().getSessionScope().get("overtime_date"));
        //        if (date != null){
        //            ADFContext.getCurrent()
        //                      .getSessionScope()
        //                      .put("overtime_date", date);
        //            System.out.println("setting date"+date);
        //        }
    }

    public void payMonthChanged(ValueChangeEvent valueChangeEvent) {
        //        RichSelectOneChoice lov = (RichSelectOneChoice) valueChangeEvent.getSource();
        //
        //
        //        if (lov.getValue() != null)
        //            ADFContext.getCurrent().getSessionScope().put("pay_month", Integer.parseInt(String.valueOf(lov.getValue())));
    }

    public void process() {
        System.out.println("process");
        if (getBindings() != null) {
            System.out.println(" bindings found");
        } else {
            System.out.println(" bindings null");
        }
        //        Row currentRow = (Row) ADFUtil.evaluateEL("#{bindings.EmployeeOvertimeDetail1Iterator.currentRow}");
        //        if (currentRow != null){
        //            System.out.println("row is not null: "+currentRow.getAttribute("OvertimeId").toString());
        //        }else{
        //            System.out.println("row isnull");
        //        }
    }

    private ViewObject getViewObject(String iterator) {
        BindingContainer bindings = getBindings();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding it = bc.findIteratorBinding(iterator);
        return it.getViewObject();
    }


    public String updateRec() {
        BindingContainer bindings = getBindings();

        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public void setOvertimeTable(RichTable overtimeTable) {
        this.overtimeTable = overtimeTable;
    }

    public RichTable getOvertimeTable() {
        return overtimeTable;
    }

    private RichTable getRichTableBinding(UIComponent comp) {
        while (comp.getParent() != null) {
            comp = comp.getParent();
            if (RichPanelCollection.class.isInstance(comp)) {
                comp = comp.getChildren().get(0);
                if (RichTable.class.isInstance(comp)) {
                    return (RichTable) comp;
                }

                break;
            }
        }

        return null;
    }

    public void saveActionListener(ActionEvent actionEvent) {
        UIComponent comp = actionEvent.getComponent();
        Map params = new HashMap<String, Object>();
        params.put("employeeID", ADFContext.getCurrent()
                                           .getPageFlowScope()
                                           .get("employee_id"));
        params.put("date", ADFContext.getCurrent()
                                     .getPageFlowScope()
                                     .get("overtime_date"));

        int exists = Integer.parseInt(Util.callOperation(getBindings(), "overtimeExists", params).toString());
        if (exists > 0) {
            Util.showMessage("This Employee's overtime is already entered.");
            return;
        }
        BindingContainer bindings = getBindings();

        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return;
        }

        Util.callOperation(bindings, "CreateInsert", null);
        FacesContext context = FacesContext.getCurrentInstance();
        RichTable r = getRichTableBinding(comp);
        //for (Object selectedRowKey : r.getSelectedRowKeys()) {
        //           String rowId = r.getClientRowKeyManager().getClientRowKey(context, r, selectedRowKey);
        //           System.out.println(rowId);

        //}
        //        String rowId = table.getClientRowKeyManager().getClientRowKey(context, table, selectedRowKey);
        //        String tableClientId = table.getClientId(context);
        //        String focusId = tableClientId + ":" + rowId + ":" + focusComponentTarget;
        ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
        erks.addScript(context, "setFocusByComponentId('" + "pt1:r1:0:t1:11:employeeIdId" + "')");
        /*RichTable table = this.getOvertimeTable();
        if (table != null) {
            RowKeySet selection = table.getSelectedRowKeys();
            for (Object selectedRowKey : selection) {
                String focusComponentTarget = "it2";

                FacesContext context = FacesContext.getCurrentInstance();
                String rowId = table.getClientRowKeyManager().getClientRowKey(context, table, selectedRowKey);
                String tableClientId = table.getClientId(context);
                String focusId = tableClientId + ":" + rowId + ":" + focusComponentTarget;

                System.out.println(focusId);

                ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
                erks.addScript(context, "setFocusByComponentId('" + focusId + "')");
            }
        }*/

    }

    public String initialize() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }

        RichTable r = getOvertimeTable();
        FacesContext context = FacesContext.getCurrentInstance();

        for (Object selectedRowKey : r.getSelectedRowKeys()) {


            String rowId = r.getClientRowKeyManager().getClientRowKey(context, r, selectedRowKey);
            System.out.println(rowId);

        }


        ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
        erks.addScript(context, "setFocusByComponentId('" + "pt1:r1:0:t1:11:employeeIdId" + "')");


        return null;
    }

    public void initActionListener(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return;
        }


    }
}
