package week_3.homework;

import java.util.ArrayList;
import java.util.List;

class Patient {
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
    private String contactInfo;
    private List<String> medicalHistory = new ArrayList<>();
    private List<String> currentTreatments = new ArrayList<>();

    public static int totalPatients = 0;
    public Patient(String id, String name, int age, String gender, String contact) {
        this.patientId = id; this.patientName = name; this.age = age; this.gender = gender; this.contactInfo = contact;
        totalPatients++;
    }

    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public void addTreatment(String t) { currentTreatments.add(t); }
}

class Doctor {
    private String doctorId;
    private String doctorName;
    private String specialization;
    private List<String> availableSlots = new ArrayList<>();
    private int patientsHandled;
    double consultationFee;

    public Doctor(String id, String name, String spec, double fee) {
        this.doctorId = id; this.doctorName = name; this.specialization = spec; this.consultationFee = fee;
    }

    public void addSlot(String slot) { availableSlots.add(slot); }
    public boolean hasSlot(String slot) { return availableSlots.contains(slot); }
}

class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    public Appointment(String id, Patient p, Doctor d, String date, String time) {
        this.appointmentId = id; this.patient = p; this.doctor = d; this.appointmentDate = date; this.appointmentTime = time; this.status = "Scheduled";
    }
    public void cancel() { status = "Cancelled"; }
}

public class HospitalManagementSystem {
    private static List<Appointment> appointments = new ArrayList<>();
    private static int totalAppointments = 0;
    private static String hospitalName = "City Hospital";
    private static double totalRevenue = 0.0;

    public static Appointment scheduleAppointment(Patient p, Doctor d, String date, String time) {
        totalAppointments++;
        Appointment ap = new Appointment("A" + String.format("%04d", totalAppointments), p, d, date, time);
        appointments.add(ap);
        totalRevenue += d.consultationFee;
        return ap;
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("P001","Alice",30,"F","9999999999");
        Doctor d1 = new Doctor("D001","Dr. Smith","General",500.0);
        Appointment ap = scheduleAppointment(p1, d1, "2025-09-01","10:00");
        System.out.println("Scheduled appointment. Total appointments: " + totalAppointments);
        System.out.println("Total revenue: " + totalRevenue);
    }
}
