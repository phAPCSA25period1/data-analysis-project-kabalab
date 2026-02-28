public class StateData {

    private String stateName;
    private double overdoseDeaths;
    private double firearmDeaths;

    public StateData(String stateName, double overdoseDeaths, double firearmDeaths) {
        this.stateName = stateName;
        this.overdoseDeaths = overdoseDeaths;
        this.firearmDeaths = firearmDeaths;
    }

    public String getStateName() {
        return stateName;
    }

    public double getOverdoseDeaths() {
        return overdoseDeaths;
    }

    public double getFirearmDeaths() {
        return firearmDeaths;
    }

    @Override
    public String toString() {
        return stateName + 
               " | Overdose Rate: " + overdoseDeaths + 
               " | Firearm Rate: " + firearmDeaths;
    }
}