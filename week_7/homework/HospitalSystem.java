package week_7.homework;

public class HospitalSystem {
    public static void main(String[] args) {
        MedicalStaff staff;
        staff = new Doctor();
        staff.scheduleShift();
        ((Doctor)staff).diagnose();
        staff = new Nurse();
        staff.scheduleShift();
        ((Nurse)staff).assist();
        staff = new Technician();
        staff.scheduleShift();
        ((Technician)staff).operateEquipment();
    }
}
class MedicalStaff {
    void scheduleShift() {
        System.out.println("Scheduling shift for medical staff");
    }
}
class Doctor extends MedicalStaff {
    void diagnose() {
        System.out.println("Doctor diagnosing patient");
    }
}
class Nurse extends MedicalStaff {
    void assist() {
        System.out.println("Nurse assisting procedures");
    }
}
class Technician extends MedicalStaff {
    void operateEquipment() {
        System.out.println("Technician running tests");
    }
}
class Administrator extends MedicalStaff {
    void manage() {
        System.out.println("Administrator managing records");
    }
}
