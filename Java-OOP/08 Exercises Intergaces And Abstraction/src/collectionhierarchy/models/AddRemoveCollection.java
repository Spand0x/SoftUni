package collectionhierarchy.models;

import collectionhierarchy.interfaces.AddRemovable;
import collectionhierarchy.interfaces.Addable;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size()-1);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }

}
