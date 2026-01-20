package SystemDesign.Patterns.AdapterAndFacade;

// Subsystem 1
class Lighting {
    public void on() {
        System.out.println("Lights are ON");
    }

    public void off() {
        System.out.println("Lights are OFF");
    }
}

// Subsystem 2
class MusicSystem {
    public void playMusic() {
        System.out.println("Music is PLAYING");
    }

    public void stopMusic() {
        System.out.println("Music is STOPPED");
    }
}

// Subsystem 3
class ClimateControl {
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp + " degrees");
    }
}

// Facade
class SmartHomeFacade {
    private Lighting lighting;
    private MusicSystem musicSystem;
    private ClimateControl climateControl;

    public SmartHomeFacade(Lighting lighting, MusicSystem musicSystem, ClimateControl climateControl) {
        this.lighting = lighting;
        this.musicSystem = musicSystem;
        this.climateControl = climateControl;
    }

    public void startEveningRoutine() {
        lighting.on();
        musicSystem.playMusic();
        climateControl.setTemperature(22);
        System.out.println("Evening routine started ✅");
    }

    public void endEveningRoutine() {
        musicSystem.stopMusic();
        lighting.off();
        System.out.println("Evening routine ended ✅");
    }
}

// Client
public class Facade {
    public static void main(String[] args) {

        Lighting lighting = new Lighting();
        MusicSystem musicSystem = new MusicSystem();
        ClimateControl climateControl = new ClimateControl();

        SmartHomeFacade smartHome = new SmartHomeFacade(lighting, musicSystem, climateControl);

        smartHome.startEveningRoutine();
        System.out.println("------------------------------------------------");
        smartHome.endEveningRoutine();
    }
}


