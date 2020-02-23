import java.time.Instant;
import java.util.*;


class Data implements Comparable<Data> {
    Integer data;
    Date readTime;

    public Data(Integer data, Date readTime) {
        this.data = data;
        this.readTime = readTime;
    }

    public Data(Data data) {
        this(data.data, new Date());
    }

    @Override
    public int compareTo(Data other) {
        return other.readTime.after(this.readTime)?1:-1;

    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                ", readTime=" + readTime +
                '}';
    }
}

public class CacheTests {


    public static void main(String[] args) {
        Set<Data> set = new TreeSet<Data>();

        set.add(new Data(1, Date.from(Instant.parse("2000-01-01T00:00:00.000Z"))));
        set.add(new Data(3, Date.from(Instant.parse("2000-01-03T00:00:00.000Z"))));
        set.add(new Data(5, Date.from(Instant.parse("2000-01-05T00:00:00.000Z"))));
        set.add(new Data(7, Date.from(Instant.parse("2000-01-07T00:00:00.000Z"))));
        set.add(new Data(8, Date.from(Instant.parse("2000-01-08T00:00:00.000Z"))));
        set.add(new Data(6, Date.from(Instant.parse("2000-01-06T00:00:00.000Z"))));
        set.add(new Data(4, Date.from(Instant.parse("2000-01-04T00:00:00.000Z"))));
        set.add(new Data(2, Date.from(Instant.parse("2000-01-02T00:00:00.000Z"))));

        System.out.println(set);






    }
}

class Cache {

}
