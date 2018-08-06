package essp.usg.model.updatable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.AttributeList;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Apr 28 11:36:14 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VOXxItAccessReqHeaderRowImpl extends ViewRowImpl {


    public static final int ENTITY_XXITACCESSREQHEADER = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        ReqHeaderId,
        UserId,
        DesireLogin,
        DesireEmail,
        ReqDate,
        CreationDate,
        CreatedBy,
        UpdationDate,
        UpdatedBy,
        VersionNumber,
        Status,
        Name,
        Designation,
        Department,
        HodName,
        VOXxItAccessReqLines,
        usgesspappmodule_EmployeesMgt1_1;
        private static AttributesEnum[] vals = null;
        ;
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


    public static final int REQHEADERID = AttributesEnum.ReqHeaderId.index();
    public static final int USERID = AttributesEnum.UserId.index();
    public static final int DESIRELOGIN = AttributesEnum.DesireLogin.index();
    public static final int DESIREEMAIL = AttributesEnum.DesireEmail.index();
    public static final int REQDATE = AttributesEnum.ReqDate.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int DESIGNATION = AttributesEnum.Designation.index();
    public static final int DEPARTMENT = AttributesEnum.Department.index();
    public static final int HODNAME = AttributesEnum.HodName.index();
    public static final int VOXXITACCESSREQLINES = AttributesEnum.VOXxItAccessReqLines.index();
    public static final int USGESSPAPPMODULE_EMPLOYEESMGT1_1 = AttributesEnum.usgesspappmodule_EmployeesMgt1_1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VOXxItAccessReqHeaderRowImpl() {
    }

    /**
     * Gets XxItAccessReqHeader entity object.
     * @return the XxItAccessReqHeader
     */
    public EntityImpl getXxItAccessReqHeader() {
        return (EntityImpl) getEntity(ENTITY_XXITACCESSREQHEADER);
    }

    /**
     * Gets the attribute value for REQ_HEADER_ID using the alias name ReqHeaderId.
     * @return the REQ_HEADER_ID
     */
    public BigDecimal getReqHeaderId() {
        return (BigDecimal) getAttributeInternal(REQHEADERID);
    }

    /**
     * Sets <code>value</code> as attribute value for REQ_HEADER_ID using the alias name ReqHeaderId.
     * @param value value to set the REQ_HEADER_ID
     */
    public void setReqHeaderId(BigDecimal value) {
        setAttributeInternal(REQHEADERID, value);
    }

    /**
     * Gets the attribute value for USER_ID using the alias name UserId.
     * @return the USER_ID
     */
    public BigDecimal getUserId() {
        return (BigDecimal) getAttributeInternal(USERID);
    }

    /**
     * Sets <code>value</code> as attribute value for USER_ID using the alias name UserId.
     * @param value value to set the USER_ID
     */
    public void setUserId(BigDecimal value) {
        setAttributeInternal(USERID, value);
    }

    /**
     * Gets the attribute value for DESIRE_LOGIN using the alias name DesireLogin.
     * @return the DESIRE_LOGIN
     */
    public String getDesireLogin() {
        return (String) getAttributeInternal(DESIRELOGIN);
    }

    /**
     * Sets <code>value</code> as attribute value for DESIRE_LOGIN using the alias name DesireLogin.
     * @param value value to set the DESIRE_LOGIN
     */
    public void setDesireLogin(String value) {
        setAttributeInternal(DESIRELOGIN, value);
    }

    /**
     * Gets the attribute value for DESIRE_EMAIL using the alias name DesireEmail.
     * @return the DESIRE_EMAIL
     */
    public String getDesireEmail() {
        return (String) getAttributeInternal(DESIREEMAIL);
    }

    /**
     * Sets <code>value</code> as attribute value for DESIRE_EMAIL using the alias name DesireEmail.
     * @param value value to set the DESIRE_EMAIL
     */
    public void setDesireEmail(String value) {
        setAttributeInternal(DESIREEMAIL, value);
    }

    /**
     * Gets the attribute value for REQ_DATE using the alias name ReqDate.
     * @return the REQ_DATE
     */
    public Timestamp getReqDate() {
        return (Timestamp) getAttributeInternal(REQDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for REQ_DATE using the alias name ReqDate.
     * @param value value to set the REQ_DATE
     */
    public void setReqDate(Timestamp value) {
        setAttributeInternal(REQDATE, value);
    }

    /**
     * Gets the attribute value for CREATION_DATE using the alias name CreationDate.
     * @return the CREATION_DATE
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
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
     * Gets the attribute value for UPDATION_DATE using the alias name UpdationDate.
     * @return the UPDATION_DATE
     */
    public Timestamp getUpdationDate() {
        return (Timestamp) getAttributeInternal(UPDATIONDATE);
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

    /**
     * Gets the attribute value for the calculated attribute Name.
     * @return the Name
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Name.
     * @param value value to set the  Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Designation.
     * @return the Designation
     */
    public String getDesignation() {
        return (String) getAttributeInternal(DESIGNATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Designation.
     * @param value value to set the  Designation
     */
    public void setDesignation(String value) {
        setAttributeInternal(DESIGNATION, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Department.
     * @return the Department
     */
    public String getDepartment() {
        return (String) getAttributeInternal(DEPARTMENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Department.
     * @param value value to set the  Department
     */
    public void setDepartment(String value) {
        setAttributeInternal(DEPARTMENT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute HodName.
     * @return the HodName
     */
    public String getHodName() {
        return (String) getAttributeInternal(HODNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute HodName.
     * @param value value to set the  HodName
     */
    public void setHodName(String value) {
        setAttributeInternal(HODNAME, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link VOXxItAccessReqLines.
     */
    public RowIterator getVOXxItAccessReqLines() {
        return (RowIterator) getAttributeInternal(VOXXITACCESSREQLINES);
    }


    /**
     * Gets the view accessor <code>RowSet</code> usgesspappmodule_EmployeesMgt1_1.
     */
    public RowSet getusgesspappmodule_EmployeesMgt1_1() {
        return (RowSet) getAttributeInternal(USGESSPAPPMODULE_EMPLOYEESMGT1_1);
    }

    @Override
    protected void create(AttributeList attributeList) {
        setReqDate(new Timestamp(System.currentTimeMillis()));
        setUserId(new BigDecimal(ADFContext.getCurrent().getSessionScope().get("sess_empcode").toString()));
        setStatus("ACTIVE");
        super.create(attributeList);
    }
}

