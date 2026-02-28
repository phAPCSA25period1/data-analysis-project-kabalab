import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        File file = new File("Data.csv");

        ArrayList<StateData> dataList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String stateName = parts[1];
                double firearmDeaths = Double.parseDouble(parts[4]);
                double overdoseDeaths = Double.parseDouble(parts[6]);

                StateData state = new StateData(stateName, overdoseDeaths, firearmDeaths);
                dataList.add(state);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        System.out.println("States Loaded: " + dataList.size());

        System.out.println("Max Firearm Rate: " + findMaxFirearm(dataList));
        System.out.println("Min Firearm Rate: " + findMinFirearm(dataList));
        System.out.println("Average Firearm Rate: " + averageFirearm(dataList));

        System.out.println("Max Overdose Rate: " + findMaxOverdose(dataList));
        System.out.println("Min Overdose Rate: " + findMinOverdose(dataList));
        System.out.println("Average Overdose Rate: " + averageOverdose(dataList));

        System.out.println("\nStates where overdose rate is higher than firearm rate:");
        compareRates(dataList);
    }

    public static double findMaxFirearm(ArrayList<StateData> list) {
        double max = list.get(0).getFirearmDeaths();
        for (StateData s : list) {
            if (s.getFirearmDeaths() > max) {
                max = s.getFirearmDeaths();
            }
        }
        return max;
    }

    public static double findMinFirearm(ArrayList<StateData> list) {
        double min = list.get(0).getFirearmDeaths();
        for (StateData s : list) {
            if (s.getFirearmDeaths() < min) {
                min = s.getFirearmDeaths();
            }
        }
        return min;
    }

    public static double averageFirearm(ArrayList<StateData> list) {
        double total = 0;
        for (StateData s : list) {
            total += s.getFirearmDeaths();
        }
        return total / list.size();
    }

    public static double findMaxOverdose(ArrayList<StateData> list) {
        double max = list.get(0).getOverdoseDeaths();
        for (StateData s : list) {
            if (s.getOverdoseDeaths() > max) {
                max = s.getOverdoseDeaths();
            }
        }
        return max;
    }

    public static double findMinOverdose(ArrayList<StateData> list) {
        double min = list.get(0).getOverdoseDeaths();
        for (StateData s : list) {
            if (s.getOverdoseDeaths() < min) {
                min = s.getOverdoseDeaths();
            }
        }
        return min;
    }

    public static double averageOverdose(ArrayList<StateData> list) {
        double total = 0;
        for (StateData s : list) {
            total += s.getOverdoseDeaths();
        }
        return total / list.size();
    }

    public static void compareRates(ArrayList<StateData> list) {
        for (StateData s : list) {
            if (s.getOverdoseDeaths() > s.getFirearmDeaths()) {
                System.out.println(s.getStateName());
            }
        }
    }
}