/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokenMachine;
import AccountPackage.DataManupulation.Datamanupulation;
import AccountPackage.DataManupulation.User;
import GUI.LoginClass;
import Route.JourneyRecord.JourneyRecord;
import Route.JourneyRecord.JourneyRecordClass;
import TokenMachine.Payment;
import TokenMachine.userUI.logedUserUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Shakuni
 */
public class TokenMachineClass {
    
    ArrayList <User> userList= null;
    ArrayList <JourneyRecord> journeyList= null;
    
    private static String UserID ;

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String UserName) {
        TokenMachineClass.UserName = UserName;
    }
    private static String UserName;
    public static String getUserID() {
        return UserID;
    }

    public static void setUserID(String UserID) {
        TokenMachineClass.UserID = UserID;
    }
    
    public static void main(String[] args) {
        
    }
    public boolean login( String Username,String Password){
       boolean value = false;
       LoginClass loginClass = new LoginClass();
       value = loginClass.validateInputs(Username, Password);
       if(value==true){
           return true;
       }
       else{
           return false;
       }   
    }
    public void login (int verification_Code){
        
    }
    public void logout(){
        setUserID(null);
        setUserName(null);
    }
    public ArrayList<JourneyRecord> searchJourneys(String Source, String Location){
        JourneyRecordClass JRClass = new JourneyRecordClass();
        journeyList=JRClass.journeyRecordDeserialization();
        ArrayList<JourneyRecord> recordList=new ArrayList<>();
        int sourceIndex=-1;
        int index=0;
        int destIndex=-1;
        for(JourneyRecord Jr : journeyList){
            for(Object[] row:Jr.getRow()){
                if(sourceIndex==-1){
                    if(row[0].toString().equals(Source)){
                        sourceIndex=index;
                    }
                }else if(destIndex==-1){
                     if(row[0].toString().equals(Location)){
                        destIndex=index;
                    }
                }
                
                ++index;
            }
            if(sourceIndex!=-1 & destIndex!=-1){
                   recordList.add(Jr);
            }
            sourceIndex=-1; 
            destIndex=-1;
        }
        return recordList;
    }
    public String buyToken( Payment Payment,String Source, String Location, String date, String Time){
        return null;
    }
    public String buyToken( Payment Payment,Account Account, String Source, String Location, String date, String Time){
        return null;
    }
    public Token issueToken(){
        return null;
    }
    public void setLoggedInAccount(String userID){
        Datamanupulation dmp =new Datamanupulation();
        userList = dmp.userDeserialization();
        String uname;
        for(User user : userList){
           if(user.getUserId().equals(userID)){
                uname=user.getUserName().toString();
                JOptionPane.showMessageDialog(null, uname);
                setUserID(userID);
                setUserName(uname); 
            }         
        }        
        //JOptionPane.showMessageDialog(null, uID+"gg"+uname);
    }
    public void acceptCash(){
    }
    public boolean validateCashPatment(Payment payment){
        return true;
    }
    public Payment createPaymentObject(){
        return null;
    }
    public void editTokenMachine(){
    }
    
}
