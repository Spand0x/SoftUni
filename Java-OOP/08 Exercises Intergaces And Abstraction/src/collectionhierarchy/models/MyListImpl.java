package collectionhierarchy.models;

import collectionhierarchy.interfaces.AddRemovable;
import collectionhierarchy.interfaces.Addable;
import collectionhierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size()-1);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0,item);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
