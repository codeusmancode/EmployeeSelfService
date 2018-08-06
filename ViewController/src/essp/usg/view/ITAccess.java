package essp.usg.view;

import essp.usg.view.mHelper.Util;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class ITAccess {
    public ITAccess() {
    }

    public String submitRequest() {
        
      
        ViewObject voLines = getViewObject("VOXxItAccessReqLines2Iterator");
        
        //access login
        ViewObject vo = getViewObject("AccessObject1Iterator");
        Row[] rows = vo.getFilteredRows("Selected", true);
        for (Row r:rows){
            Row newRow = voLines.createRow();
            newRow.setAttribute("AccessObject", Integer.parseInt(r.getAttribute("AccessObjectId").toString()));
            newRow.setAttribute("AccessType", 1);
            newRow.setAttribute("OtherAccessObject", r.getAttribute("Other")+"");
          
           newRow.setAttribute("ReqHeaderId", evaluateEL("#{bindings.ReqHeaderId.inputValue}"));
        }
        
        //access email
        vo = getViewObject("AccessObjectEmail1Iterator");
        rows = vo.getFilteredRows("Selected", true);
        for (Row r:rows){
            Row newRow = voLines.createRow();
            newRow.setAttribute("AccessObject", Integer.parseInt(r.getAttribute("AccessObjectId").toString()));
            newRow.setAttribute("AccessType", 2);
            
            newRow.setAttribute("ReqHeaderId", evaluateEL("#{bindings.ReqHeaderId.inputValue}"));
        }
        
        //access internet
        vo = getViewObject("AccessObjectInternet1Iterator");
        rows = vo.getFilteredRows("Selected", true);
        for (Row r:rows){
            Row newRow = voLines.createRow();
            newRow.setAttribute("AccessObject", Integer.parseInt(r.getAttribute("AccessObjectId").toString()));
            newRow.setAttribute("AccessType", 3);
            newRow.setAttribute("Justification", r.getAttribute("Justification")+"");
            
            newRow.setAttribute("ReqHeaderId", evaluateEL("#{bindings.ReqHeaderId.inputValue}"));
        }
        
        callOperation("Commit", null);
        
        return null;
    }
    
    public static Object evaluateEL(String el) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);

        return exp.getValue(elContext);
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
    
    
    private ViewObject getViewObject(String iterator) {
        BindingContainer bindings = getBindings();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding it = bc.findIteratorBinding(iterator);
        return it.getViewObject();
    }
    private BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
