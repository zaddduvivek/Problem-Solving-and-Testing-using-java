import java.util.*;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {

        // Descending score
        if (a.score != b.score) {
            return b.score - a.score;
        }

        // Ascending name
        return a.name.compareTo(b.name);
    }
}
