
public class PairDriver {

    public static void main(String[] args){

        Pair<Date> date_span = new Pair<>(new Date(1, 2, 202), new Date(2, 1, 2020));
        Pair<DnDStats> stats = new Pair<>(new DnDStats(), new DnDStats());
        Pair<String> name = new Pair<>("Frank", "Stein");

        Pair[] pairs = {date_span, stats, name};

        for(Pair p : pairs)
            System.out.println(p);
    }

}
