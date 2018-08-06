package essp.usg.view;

import essp.usg.view.mHelper.Util;
import essp.usg.view.pageDefs.ADFUtil;

import java.util.HashMap;
import java.util.Map;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class LoginAccessApproval {
    public LoginAccessApproval() {
    }

    public String approveRequest() {
        Row currentReq = (Row) ADFUtil.evaluateEL("#{bindings.VOLoginAccessApprovalHeader1Iterator.currentRow}");
        System.out.println(currentReq.getAttribute("ReqHeaderId").toString());
        Map params = new HashMap<String, Object>();
        params.put("reqHeaderID", Integer.parseInt(currentReq.getAttribute("ReqHeaderId").toString()));
        
        Util.callOperation(getBindings(), "approveRequest", params);
        
        ViewObject vo = getViewObject("VOLoginAccessApprovalHeader1Iterator");
        vo.executeQuery();
        return null;
    }
    private ViewObject getViewObject(String iterator) {
        BindingContainer bindings = getBindings();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding it = bc.findIteratorBinding(iterator);
        return it.getViewObject();
    }
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
