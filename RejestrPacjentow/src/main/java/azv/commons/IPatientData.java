/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azv.commons;

import java.io.Serializable;

/**
 *
 * @author Arthur
 */
public interface IPatientData extends Serializable {
    public String GetPatientName();
    public void SetPatientName(String name);
    
    public String GetPatientForename();
    public void SetPatientForename(String forename);
    
    public int GetPatientAge();
    public void SetPatientAge(int age);
    
    public String GetPatientAddress();
    public void SetPatientAddress(String address);
    
    public String GetPatientPhoneNumber();
    public void SetPatientPhoneNumber(String phoneNumber);
}
