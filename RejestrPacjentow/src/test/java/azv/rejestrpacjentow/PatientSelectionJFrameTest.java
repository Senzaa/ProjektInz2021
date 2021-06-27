/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azv.rejestrpacjentow;

import azv.commons.PatientData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Arthur
 */
public class PatientSelectionJFrameTest {
    
    
    @Test
    public void testGetPatientData() {
        System.out.println("GetPatientData");
        
        File fl = new File("patients/dummy_dummy");
        if (fl.exists())
            fl.delete();
        
        PatientData pd = new PatientData("dummy", "dummy", 1, "dummy_address", "dummy_phone");
        
        if (!Files.isDirectory(Paths.get("patients")))
            try {
                Files.createDirectory(Paths.get("patients"));
            } catch (IOException ex) {
                fail("Could not continue test due to IOException (cannot create patients directory)");
                return;
            }
        
        try {
            FileOutputStream fo = new FileOutputStream(new File("patients/dummy_dummy"));
            ObjectOutputStream o = new ObjectOutputStream(fo);
            
            o.writeObject(pd);
            
            o.close();
            fo.close();
        } catch (IOException ex) {
            fail("Could not complete test due to IOException (cannot save dummy PatientData object)");
            return;
        }
        
        File dummy = new File("patients/dummy_dummy");
        
        assertTrue("Dummy PatientData object file should exist.", dummy.exists());
        
        PatientSelectionJFrame instance = new PatientSelectionJFrame();
        
        ArrayList<PatientData> pdList = new ArrayList<>();
        boolean result = instance.GetPatientData(pdList);
        assertTrue("GetPatientData should succeed in getting at least 1 PatientData object.", result);
        assertTrue("GetPatientData should succeed in getting at least 1 PatientData object.", pdList.size() > 0);
        
        dummy.delete();
    }
    
    @Test
    public void testEditButtonActionPerformed() {
        System.out.println("editButtonActionPerformed");
        
        PatientSelectionJFrame instance = new PatientSelectionJFrame();
        
        PatientData pd = new PatientData("dummy", "dummy", 1, "dummy_address", "dummy_phone");
        
        instance.pdList.add(pd);
        
        DefaultListModel dlm = (DefaultListModel)instance.patientList.getModel();
        
        dlm.addElement(pd);
        
        instance.patientList.setSelectedIndex(dlm.indexOf(pd));
        
        ActionListener[] actionListeners = instance.editButton.getActionListeners();
        assertTrue("Edit Button should have an assigned action.", actionListeners.length > 0);
        
        for (ActionListener al: actionListeners) {
            al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {});
        }
        
        assertFalse("The PatientSelectionJFrame instance window should be disposed.", instance.isDisplayable());
    }
    
    @Test
    public void testDeleteButtonActionPerformed() {
        System.out.println("deleteButtonActionPerformed");
        
        File fl = new File("patients/dummy_dummy");
        if (fl.exists())
            fl.delete();
        
        PatientData pd = new PatientData("dummy", "dummy", 1, "dummy_address", "dummy_phone");
        
        if (!Files.isDirectory(Paths.get("patients")))
            try {
                Files.createDirectory(Paths.get("patients"));
            } catch (IOException ex) {
                fail("Could not continue test due to IOException (cannot create patients directory)");
                return;
            }
        
        try {
            FileOutputStream fo = new FileOutputStream(new File("patients/dummy_dummy"));
            ObjectOutputStream o = new ObjectOutputStream(fo);
            
            o.writeObject(pd);
            
            o.close();
            fo.close();
        } catch (IOException ex) {
            fail("Could not complete test due to IOException (cannot save dummy PatientData object)");
            return;
        }
        
        assertTrue("Dummy PatientData object file should exist.", fl.exists());
        
        PatientSelectionJFrame instance = new PatientSelectionJFrame();
        
        DefaultListModel dlm = (DefaultListModel)instance.patientList.getModel();
        
        int indexOfPatientData = -1;
        
        for (Object pdObj: dlm.toArray()) {
            PatientData pData = (PatientData)pdObj;
            if (pData.toString().equals(pd.toString())){
                indexOfPatientData = dlm.indexOf(pdObj);
                break;
            }
        }
        
        assertTrue("Index of dummy PatientData should be equal or higher than zero.", indexOfPatientData >= 0);
        
        instance.patientList.setSelectedIndex(
                indexOfPatientData
        );
        
        ActionListener[] actionListeners = instance.deleteButton.getActionListeners();
        assertTrue("Edit Button should have an assigned action.", actionListeners.length > 0);
        
        for (ActionListener al: actionListeners) {
            al.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {});
        }
        
        assertFalse("Dummy PatientData object file should not exist.", fl.exists());
    }
}
