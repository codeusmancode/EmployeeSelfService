package essp.usg.model.entity_objects;

import java.math.BigDecimal;

import java.math.BigInteger;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Apr 30 15:11:17 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XxItAccessReqLinesImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        ReqLineId,
        ReqHeaderId,
        AccessType,
        AccessObject,
        OtherAccessObject,
        CreationDate,
        CreatedBy,
        UpdationDate,
        UpdatedBy,
        VersionNumber,
        Justification,
        XxItAccessReqHeader;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int REQLINEID = AttributesEnum.ReqLineId.index();
    public static final int REQHEADERID = AttributesEnum.ReqHeaderId.index();
    public static final int ACCESSTYPE = AttributesEnum.AccessType.index();
    public static final int ACCESSOBJECT = AttributesEnum.AccessObject.index();
    public static final int OTHERACCESSOBJECT = AttributesEnum.OtherAccessObject.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();
    public static final int JUSTIFICATION = AttributesEnum.Justification.index();
    public static final int XXITACCESSREQHEADER = AttributesEnum.XxItAccessReqHeader.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XxItAccessReqLinesImpl() {
    }

    /**
     * Gets the attribute value for ReqLineId, using the alias name ReqLineId.
     * @return the value of ReqLineId
     */
    public BigDecimal getReqLineId() {
        return (BigDecimal) getAttributeInternal(REQLINEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReqLineId.
     * @param value value to set the ReqLineId
     */
    public void setReqLineId(BigDecimal value) {
        setAttributeInternal(REQLINEID, value);
    }

    /**
     * Gets the attribute value for ReqHeaderId, using the alias name ReqHeaderId.
     * @return the value of ReqHeaderId
     */
    public BigDecimal getReqHeaderId() {
        return (BigDecimal) getAttributeInternal(REQHEADERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReqHeaderId.
     * @param value value to set the ReqHeaderId
     */
    public void setReqHeaderId(BigDecimal value) {
        setAttributeInternal(REQHEADERID, value);
    }

    /**
     * Gets the attribute value for AccessType, using the alias name AccessType.
     * @return the value of AccessType
     */
    public BigDecimal getAccessType() {
        return (BigDecimal) getAttributeInternal(ACCESSTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for AccessType.
     * @param value value to set the AccessType
     */
    public void setAccessType(BigDecimal value) {
        setAttributeInternal(ACCESSTYPE, value);
    }

    /**
     * Gets the attribute value for AccessObject, using the alias name AccessObject.
     * @return the value of AccessObject
     */
    public BigDecimal getAccessObject() {
        return (BigDecimal) getAttributeInternal(ACCESSOBJECT);
    }

    /**
     * Sets <code>value</code> as the attribute value for AccessObject.
     * @param value value to set the AccessObject
     */
    public void setAccessObject(BigDecimal value) {
        setAttributeInternal(ACCESSOBJECT, value);
    }

    /**
     * Gets the attribute value for OtherAccessObject, using the alias name OtherAccessObject.
     * @return the value of OtherAccessObject
     */
    public String getOtherAccessObject() {
        return (String) getAttributeInternal(OTHERACCESSOBJECT);
    }

    /**
     * Sets <code>value</code> as the attribute value for OtherAccessObject.
     * @param value value to set the OtherAccessObject
     */
    public void setOtherAccessObject(String value) {
        setAttributeInternal(OTHERACCESSOBJECT, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the value of CreationDate
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public BigDecimal getCreatedBy() {
        return (BigDecimal) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(BigDecimal value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for UpdationDate, using the alias name UpdationDate.
     * @return the value of UpdationDate
     */
    public Timestamp getUpdationDate() {
        return (Timestamp) getAttributeInternal(UPDATIONDATE);
    }

    /**
     * Gets the attribute value for UpdatedBy, using the alias name UpdatedBy.
     * @return the value of UpdatedBy
     */
    public BigDecimal getUpdatedBy() {
        return (BigDecimal) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for UpdatedBy.
     * @param value value to set the UpdatedBy
     */
    public void setUpdatedBy(BigDecimal value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for VersionNumber, using the alias name VersionNumber.
     * @return the value of VersionNumber
     */
    public BigDecimal getVersionNumber() {
        return (BigDecimal) getAttributeInternal(VERSIONNUMBER);
    }

    /**
     * Gets the attribute value for Justification, using the alias name Justification.
     * @return the value of Justification
     */
    public String getJustification() {
        return (String) getAttributeInternal(JUSTIFICATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Justification.
     * @param value value to set the Justification
     */
    public void setJustification(String value) {
        setAttributeInternal(JUSTIFICATION, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getXxItAccessReqHeader() {
        return (EntityImpl) getAttributeInternal(XXITACCESSREQHEADER);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setXxItAccessReqHeader(EntityImpl value) {
        setAttributeInternal(XXITACCESSREQHEADER, value);
    }

    /**
     * @param reqLineId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal reqLineId) {
        return new Key(new Object[] { reqLineId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("essp.usg.model.entity_objects.XxItAccessReqLines");
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        switch(operation){
        case DML_INSERT:
            setCreatedBy(new BigDecimal(ADFContext.getCurrent().getSessionScope().get("sess_empcode").toString()));
            setUpdatedBy(new BigDecimal(ADFContext.getCurrent().getSessionScope().get("sess_empcode").toString()));
            break;
        case DML_UPDATE:
            setUpdatedBy(new BigDecimal(ADFContext.getCurrent().getSessionScope().get("sess_empcode").toString()));
            break;
        }
        super.doDML(operation, e);
    }
}

