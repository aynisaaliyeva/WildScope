import java.util.Comparator;

public class DurationComparator implements Comparator<Documentary> {
    @Override
    public int compare(Documentary a, Documentary b) {
        return Integer.compare(a.getDuration(), b.getDuration());
    }

}