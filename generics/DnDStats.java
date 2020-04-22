import java.util.HashMap;
import java.util.ArrayList;

public class DnDStats {
    // create HashMap without type inference
    // private HashMap<String, ArrayList<String>> database = new HashMap<String, ArrayList<String>>();

    // create HashMap with type inference
    private HashMap<String, ArrayList<String>> database = new HashMap<>();

    public void showStats(String character){
        if (!database.containsKey(character)){
            System.out.println("Character not found in database");
            return;
        }

        ArrayList<String> stats = database.get(character);
        for (String stat : stats)
            System.out.println(stat);
    }

    public static void main(String[] args){

        DnDStats stats = new DnDStats();

        stats.database.put("Shamash", new ArrayList<>());
        ArrayList<String> s = stats.database.get("Shamash");
        s.add("Class:       Warlock");
        s.add("Race:        Dragonborn");
        s.add("Armor Class: 14");
        s.add("Weapons:     Simple Weapons");

        stats.showStats("Shamash");
    }
}
