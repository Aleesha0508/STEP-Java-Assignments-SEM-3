package week_7.lab;

public class SmartCampusIoTSystem {
    public static void main(String[] args) {
        SmartDevice[] devices = {new SmartClassroom(), new SmartLab(), new SmartLibrary()};
        for (SmartDevice d : devices) {
            d.activateDevice();
            if (d instanceof SmartClassroom) {
                ((SmartClassroom)d).controlLights();
            } else if (d instanceof SmartLab) {
                ((SmartLab)d).manageSafety();
            } else if (d instanceof SmartLibrary) {
                ((SmartLibrary)d).trackBooks();
            }
        }
    }
}
class SmartDevice {
    void activateDevice() {
        System.out.println("Activating device.");
    }
}
class SmartClassroom extends SmartDevice {
    void controlLights() {
        System.out.println("Controlling classroom lights and AC.");
    }
}
class SmartLab extends SmartDevice {
    void manageSafety() {
        System.out.println("Managing lab equipment and safety protocols.");
    }
}
class SmartLibrary extends SmartDevice {
    void trackBooks() {
        System.out.println("Tracking occupancy and book availability.");
    }
}

