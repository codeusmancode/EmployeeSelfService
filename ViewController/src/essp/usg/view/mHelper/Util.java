package essp.usg.view.mHelper;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class Util {
    
    public static void showMessage(String message){
        FacesMessage Message = new FacesMessage(message);   
        Message.setSeverity(FacesMessage.SEVERITY_ERROR);   
        FacesContext fc = FacesContext.getCurrentInstance();   
        fc.addMessage(null, Message);    
        
    }
    public static void setSession(String key,String value){
        ADFContext.getCurrent().getSessionScope().put(key, value);
    }
    public static Object getSession(String key){
        return ADFContext.getCurrent().getSessionScope().get(key);
    }
    
    public static Object callOperation(BindingContainer bindings ,String actionName, Map params) {
       
        OperationBinding operationBinding = bindings.getOperationBinding(actionName);
        if (params != null) {
            System.out.println(" params is not null");
            operationBinding.getParamsMap().putAll(params);
        }
        Object result = operationBinding.execute();
        return result;
    }
}
