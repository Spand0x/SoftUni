package collectionhierarchy.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Collection {
    private int maxSize = 100;
    private List<String> items;

    protected Collection() {
        this.items = new ArrayList<>();
    }

    protected List<String> getItems() {
        return this.items;
    }
}
