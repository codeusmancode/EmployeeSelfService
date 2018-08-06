package essp.usg.view;

import essp.usg.view.mHelper.DBConnection;
import essp.usg.view.mHelper.Util;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

public class AppAction {
    private RichInputText itPassword;
    private RichInputText itUsername;

    public AppAction() {
    }

    public String doLogin() {
        String _username = this.getItUsername()
                               .getValue()
                               .toString();
        String _password = this.getItPassword()
                               .getValue()
                               .toString();
        System.out.println(" login " + _username);
        if (_username == null || _username.length() <= 0 || _password == null || _password.length() <= 0) {
            Util.showMessage("Please Provide Valid Username and Password.");
            return null;
        }

        Connection connection =
            DBConnection.getInstance("jdbc:oracle:thin:@193.168.0.7:1521:orcl", "USPR", "HTCDESIRE").getConnection();
        if (connection != null) {
            PreparedStatement pst = null;
            ResultSet rs = null;
            try {
                String query = "select us.u_eid," + 
                "                           emp.designation," + 
                "                           emp.department," + 
                "                           emp.name," + 
                "                           emp.dept_id," + 
                "                           nvl(to_char(ea.hod),'none') hod " + 
                "                      from csys.us_users us,  employees_information_v emp," + 
                "                                uspr.employees_all ea " + 
                "                      where upper(us.login) = upper(?)   and us.password = ?   and us.app_id = 2 " + 
                "                      and emp.emp_code= us.u_eid " + 
                "                      and us.u_eid = ea.emp_id";
                
                pst = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pst.setString(1, _username);
                pst.setString(2, _password);
                rs = pst.executeQuery();
                rs.last();
                int total = rs.getRow();
                rs.beforeFirst();
                System.out.println("total: " + total);
                if (total == 1) {
                    rs.next();
                    Util.setSession("sess_username", _username);
                    Util.setSession("sess_empcode", rs.getString("u_eid"));
                    Util.setSession("sess_empdesg", rs.getString("DESIGNATION"));
                    Util.setSession("sess_empdept", rs.getString("DEPARTMENT"));
                    Util.setSession("sess_empname", rs.getString("NAME"));
                    Util.setSession("sess_deptid", rs.getString("DEPT_ID"));
                    Util.setSession("sess_hod", rs.getString("hod"));
                    
                    //Util.setSession("month_code", String.valueOf((Calendar.getInstance().get(Calendar.MONTH)+2)));
                    Util.setSession("month_code", "7");
                    System.out.println("month_code:"+String.valueOf((Calendar.getInstance().get(Calendar.MONTH)+2)));
                    
                    // load responsibility
                    query =
                        "select rd.userid,resp_code " + "from ustms.XX_ESSP_USER_RESP_DIRECT rd, " + " ustms.xx_essp_resp er " +
                        " where rd.userid = ? " + " and rd.resp_id = er.resp_id ";//XX_ESSP_RESP
                    
                    pst = connection.prepareStatement(query);
                    pst.setString(1, rs.getString("u_eid"));
                    rs = pst.executeQuery();
                    while (rs.next()){
                        Util.setSession(rs.getString("resp_code"),_username);
                    } 
                    
                } else {
                    System.out.println("login failure");
                    Util.showMessage("Error Login:Invalid Username or Password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Util.showMessage("Error login: " + ex.getMessage());
            } finally {
                try {
                    rs.close();
                    pst.close();
                    DBConnection.closeConnection();
                } catch (Exception ex) {
                    Util.showMessage("Error Closing Connection after login: " + ex.getMessage());
                }
            }
        } else {
            System.out.println(" connection is null");
            Util.showMessage("Unable to Connect to database while loging in.");
        }
        return null;
    }


    public String doLogout() {
        System.out.println("Logout");
        FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .invalidateSession();
        //        ADFContext.getCurrent().getSessionScope().put("sess_username",null);
        //        Util.setSession("sess_username",null);
        //        Util.setSession("sess_empcode", null);
        //        Util.setSession("sess_empdesg", null);
        //        Util.setSession("sess_empdept",null);
        //        Util.setSession("sess_empname", null);
        return null;
    }

    public void setItPassword(RichInputText itPassword) {
        this.itPassword = itPassword;
    }

    public RichInputText getItPassword() {
        return itPassword;
    }

    public void setItUsername(RichInputText itUsername) {
        this.itUsername = itUsername;
    }

    public RichInputText getItUsername() {
        return itUsername;
    }

    public String logout_link_template() {
        FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .invalidateSession();
        try {
            FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .redirect("login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
