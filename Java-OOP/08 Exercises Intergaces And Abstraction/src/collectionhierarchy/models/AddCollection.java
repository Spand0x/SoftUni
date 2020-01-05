package collectionhierarchy.models;

import collectionhierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item){
        super.getItems().add(0,item);
        return 0;
    }
}
