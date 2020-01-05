package reusingclasses;

import java.util.ArrayList;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement(){
        int random = (int) (Math.random() * super.size());
        return super.remove(random);
    }
}
