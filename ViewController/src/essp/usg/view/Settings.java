package essp.usg.view;

import essp.usg.view.mHelper.DBConnection;

import essp.usg.view.mHelper.Util;

import java.io.IOException;

import java.sql.Connection;

import java.sql.PreparedStatement;

import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

public class Settings {
    private RichInputText newUsername;
    private RichInputText newPassword;

    public Settings() {
    }

    public void setNewUsername(RichInputText newUsername) {
        this.newUsername = newUsername;
    }

    public RichInputText getNewUsername() {
        return newUsername;
    }

    public void setNewPassword(RichInputText newPassword) {
        this.newPassword = newPassword;
    }

    public RichInputText getNewPassword() {
        return newPassword;
    }

    public String saveSettings() {
        String newUsername = null;
        if (getNewUsername().getValue() != null)
            newUsername = getNewUsername().getValue().toString();
        String newPassword = null;
        if (getNewPassword().getValue() != null)
            newPassword = getNewPassword().getValue().toString();

        Connection connection = null;
        PreparedStatement pst = null;
        try {
            connection = DBConnection.getInstance("jdbc:oracle:thin:@193.168.0.7:1521:orcl","USRP","HTCDESIRE").getConnection();
            String updateQuery =
                "update csys.us_users set login =  " + ((newUsername == null||newUsername.length()<=0) ? "login ," : "'" + newUsername + "' ,") +
                " password = " +
                ((newPassword == null||newPassword.length()<=0) ? " password " : "'" + newPassword + "' ") + " where u_eid='"+Util.getSession("sess_empcode")+"' and app_id = 2";
            pst = connection.prepareStatement(updateQuery);
            
            System.out.println(updateQuery);
            if (pst.executeUpdate() > 0){
                FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                FacesContext.getCurrentInstance().getExternalContext().redirect("login");
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }


        return null;
    }
}
