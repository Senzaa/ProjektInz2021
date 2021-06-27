/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azv.commons;

/**
 *
 * @author Arthur
 */
public class PatientData implements IPatientData {
    private String name;
    private String forename;
    private int age;
    private String address;
    private String phoneNumber;
    
    public PatientData(
            String name,
            String forename,
            int age,
            String address,
            String phoneNumber
            ) {
        this.name = name;
        this.forename = forename;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String GetPatientName() {
        return this.name;
    }

    @Override
    public void SetPatientName(String name) {
        this.name = name;
    }

    @Override
    public String GetPatientForename() {
        return this.forename;
    }

    @Override
    public void SetPatientForename(String forename) {
        this.forename = forename;
    }

    @Override
    public int GetPatientAge() {
        return this.age;
    }

    @Override
    public void SetPatientAge(int age) {
        this.age = age;
    }

    @Override
    public String GetPatientAddress() {
        return this.address;
    }

    @Override
    public void SetPatientAddress(String address) {
        this.address = address;
    }

    @Override
    public String GetPatientPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void SetPatientPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return String.format("Imię: %s \t Nazwisko: %s",
                this.name,
                this.forename);
    }
}
