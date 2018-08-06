package essp.usg.model.entity_objects;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 21 11:54:01 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CustIncentiveHourlyRateImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        RateId,
        Rate,
        MonthCode,
        CalculationDate,
        Active,
        CreationDate,
        UpdateDate,
        CreatedBy,
        UpdatedBy,
        VersionNumber;
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
    public static final int RATEID = AttributesEnum.RateId.index();
    public static final int RATE = AttributesEnum.Rate.index();
    public static final int MONTHCODE = AttributesEnum.MonthCode.index();
    public static final int CALCULATIONDATE = AttributesEnum.CalculationDate.index();
    public static final int ACTIVE = AttributesEnum.Active.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATEDATE = AttributesEnum.UpdateDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CustIncentiveHourlyRateImpl() {
    }

    /**
     * Gets the attribute value for RateId, using the alias name RateId.
     * @return the value of RateId
     */
    public BigDecimal getRateId() {
        return (BigDecimal) getAttributeInternal(RATEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RateId.
     * @param value value to set the RateId
     */
    public void setRateId(BigDecimal value) {
        setAttributeInternal(RATEID, value);
    }

    /**
     * Gets the attribute value for Rate, using the alias name Rate.
     * @return the value of Rate
     */
    public BigDecimal getRate() {
        return (BigDecimal) getAttributeInternal(RATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Rate.
     * @param value value to set the Rate
     */
    public void setRate(BigDecimal value) {
        setAttributeInternal(RATE, value);
    }

    /**
     * Gets the attribute value for MonthCode, using the alias name MonthCode.
     * @return the value of MonthCode
     */
    public BigDecimal getMonthCode() {
        return (BigDecimal) getAttributeInternal(MONTHCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for MonthCode.
     * @param value value to set the MonthCode
     */
    public void setMonthCode(BigDecimal value) {
        setAttributeInternal(MONTHCODE, value);
    }

    /**
     * Gets the attribute value for CalculationDate, using the alias name CalculationDate.
     * @return the value of CalculationDate
     */
    public Timestamp getCalculationDate() {
        return (Timestamp) getAttributeInternal(CALCULATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CalculationDate.
     * @param value value to set the CalculationDate
     */
    public void setCalculationDate(Timestamp value) {
        setAttributeInternal(CALCULATIONDATE, value);
    }

    /**
     * Gets the attribute value for Active, using the alias name Active.
     * @return the value of Active
     */
    public String getActive() {
        return (String) getAttributeInternal(ACTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Active.
     * @param value value to set the Active
     */
    public void setActive(String value) {
        setAttributeInternal(ACTIVE, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the value of CreationDate
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for UpdateDate, using the alias name UpdateDate.
     * @return the value of UpdateDate
     */
    public Timestamp getUpdateDate() {
        return (Timestamp) getAttributeInternal(UPDATEDATE);
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
     * @param rateId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal rateId) {
        return new Key(new Object[] { rateId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("essp.usg.model.entity_objects.CustIncentiveHourlyRate");
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

