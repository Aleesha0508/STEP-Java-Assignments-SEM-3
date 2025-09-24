package week_7.homework;

public class HomeAutomation {
    public static void main(String[] args) {
        SmartDevice[] devices = {new SmartTV(), new SmartThermostat(), new SmartSecurity()};
        for (SmartDevice d : devices) {
            d.powerOn();
            if (d instanceof SmartTV) ((SmartTV)d).changeChannel();
            else if (d instanceof SmartThermostat) ((SmartThermostat)d).setTemperature();
            else if (d instanceof SmartSecurity) ((SmartSecurity)d).activateAlarm();
        }
    }
}
class SmartDevice {
    void powerOn() {
        System.out.println("Device powered on");
    }
}
class SmartTV extends SmartDevice {
    void changeChannel() {
        System.out.println("Changing TV channel");
    }
}
class SmartThermostat extends SmartDevice {
    void setTemperature() {
        System.out.println("Setting temperature");
    }
}
class SmartSecurity extends SmartDevice {
    void activateAlarm() {
        System.out.println("Activating security alarm");
    }
}

