/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azv.rejestrpacjentow;

import azv.commons.PatientData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arthur
 */
public class RegisterPatientJFrameTest {
    
    public RegisterPatientJFrameTest() {
    }

    /**
     * Test of SavePatientDataToFile method, of class RegisterPatientJFrame.
     */
    @Test
    public void testSavePatientDataToFile() {
        System.out.println("SavePatientDataToFile");
        PatientData pd = new PatientData("dummy", "dummy", 1, "dummy_address", "dummy_phone");
        RegisterPatientJFrame instance = new RegisterPatientJFrame();
        boolean result = instance.SavePatientDataToFile(pd);
        assertTrue(result);
    }

    /**
     * Test of RegisterPatient method, of class RegisterPatientJFrame.
     */
    @Test
    public void testRegisterPatient() {
        System.out.println("RegisterPatient");
        RegisterPatientJFrame instance = new RegisterPatientJFrame();
        instance.nameField.setText("dummyName");
        instance.forenameField.setText("dummyForename");
        instance.ageField.setValue(1);
        instance.addressField.setText("dummy_address");
        instance.phoneNumberField.setText("dummy_phoneNumber");
        boolean result = instance.RegisterPatient();
        assertTrue(result);
    }
    
}
