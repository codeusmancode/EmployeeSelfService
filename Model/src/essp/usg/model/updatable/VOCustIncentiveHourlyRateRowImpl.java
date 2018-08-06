package essp.usg.model.updatable;

import essp.usg.model.entity_objects.CustIncentiveHourlyRateImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 21 11:55:00 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VOCustIncentiveHourlyRateRowImpl extends ViewRowImpl {
    public static final int ENTITY_CUSTINCENTIVEHOURLYRATE = 0;

    @Override
    protected void create(AttributeList attributeList) {
        // TODO Implement this method
        setActive("Y");
        super.create(attributeList);
    }

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
    public VOCustIncentiveHourlyRateRowImpl() {
    }

    /**
     * Gets CustIncentiveHourlyRate entity object.
     * @return the CustIncentiveHourlyRate
     */
    public CustIncentiveHourlyRateImpl getCustIncentiveHourlyRate() {
        return (CustIncentiveHourlyRateImpl) getEntity(ENTITY_CUSTINCENTIVEHOURLYRATE);
    }

    /**
     * Gets the attribute value for RATE_ID using the alias name RateId.
     * @return the RATE_ID
     */
    public BigDecimal getRateId() {
        return (BigDecimal) getAttributeInternal(RATEID);
    }

    /**
     * Sets <code>value</code> as attribute value for RATE_ID using the alias name RateId.
     * @param value value to set the RATE_ID
     */
    public void setRateId(BigDecimal value) {
        setAttributeInternal(RATEID, value);
    }

    /**
     * Gets the attribute value for RATE using the alias name Rate.
     * @return the RATE
     */
    public BigDecimal getRate() {
        return (BigDecimal) getAttributeInternal(RATE);
    }

    /**
     * Sets <code>value</code> as attribute value for RATE using the alias name Rate.
     * @param value value to set the RATE
     */
    public void setRate(BigDecimal value) {
        setAttributeInternal(RATE, value);
    }

    /**
     * Gets the attribute value for MONTH_CODE using the alias name MonthCode.
     * @return the MONTH_CODE
     */
    public BigDecimal getMonthCode() {
        return (BigDecimal) getAttributeInternal(MONTHCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for MONTH_CODE using the alias name MonthCode.
     * @param value value to set the MONTH_CODE
     */
    public void setMonthCode(BigDecimal value) {
        setAttributeInternal(MONTHCODE, value);
    }

    /**
     * Gets the attribute value for CALCULATION_DATE using the alias name CalculationDate.
     * @return the CALCULATION_DATE
     */
    public Timestamp getCalculationDate() {
        return (Timestamp) getAttributeInternal(CALCULATIONDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CALCULATION_DATE using the alias name CalculationDate.
     * @param value value to set the CALCULATION_DATE
     */
    public void setCalculationDate(Timestamp value) {
        setAttributeInternal(CALCULATIONDATE, value);
    }

    /**
     * Gets the attribute value for ACTIVE using the alias name Active.
     * @return the ACTIVE
     */
    public String getActive() {
        return (String) getAttributeInternal(ACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for ACTIVE using the alias name Active.
     * @param value value to set the ACTIVE
     */
    public void setActive(String value) {
        setAttributeInternal(ACTIVE, value);
    }

    /**
     * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
     * @return the CREATION_DATE
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for UPDATE_DATE using the alias name UpdateDate.
     * @return the UPDATE_DATE
     */
    public Timestamp getUpdateDate() {
        return (Timestamp) getAttributeInternal(UPDATEDATE);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public BigDecimal getCreatedBy() {
        return (BigDecimal) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
     * @param value value to set the CREATED_BY
     */
    public void setCreatedBy(BigDecimal value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for UPDATED_BY using the alias name UpdatedBy.
     * @return the UPDATED_BY
     */
    public BigDecimal getUpdatedBy() {
        return (BigDecimal) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for UPDATED_BY using the alias name UpdatedBy.
     * @param value value to set the UPDATED_BY
     */
    public void setUpdatedBy(BigDecimal value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for VERSION_NUMBER using the alias name VersionNumber.
     * @return the VERSION_NUMBER
     */
    public BigDecimal getVersionNumber() {
        return (BigDecimal) getAttributeInternal(VERSIONNUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for VERSION_NUMBER using the alias name VersionNumber.
     * @param value value to set the VERSION_NUMBER
     */
    public void setVersionNumber(BigDecimal value) {
        setAttributeInternal(VERSIONNUMBER, value);
    }
    
}

