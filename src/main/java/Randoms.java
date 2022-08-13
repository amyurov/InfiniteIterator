import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private static final int initialCapacity = 5;

    protected List<Integer> randomIntegers = new ArrayList<>();
    protected Random random = new Random();
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        max++;
        this.max=max;
        this.min=min;
        for (int i = 0; i < initialCapacity; i++) {
            randomIntegers.add(random.nextInt(max-min)+min);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int nextItem = 0;

            @Override
            public boolean hasNext() {
                if (nextItem >= randomIntegers.size()) {
                    randomIntegers.add(random.nextInt(max - min) + min);
                }
                return true;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    int randomInteger = randomIntegers.get(nextItem);
                    nextItem++;
                    return randomInteger;
                } else {
                    return randomIntegers.get(nextItem);
                }
            }
        };
    }
}
