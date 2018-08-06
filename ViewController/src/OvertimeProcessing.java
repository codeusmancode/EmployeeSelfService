import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;

public class OvertimeProcessing {
    public OvertimeProcessing() {
    }

    public void process() {
        System.out.println("process");
        if (getBindings() != null){
            System.out.println(" bindings found");
        }else{
            System.out.println(" bindings null");
        }
        //        Row currentRow = (Row) ADFUtil.evaluateEL("#{bindings.EmployeeOvertimeDetail1Iterator.currentRow}");
        //        if (currentRow != null){
        //            System.out.println("row is not null: "+currentRow.getAttribute("OvertimeId").toString());
        //        }else{
        //            System.out.println("row isnull");
        //        }
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
