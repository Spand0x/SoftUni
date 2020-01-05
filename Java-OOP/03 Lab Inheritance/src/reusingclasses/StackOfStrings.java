package reusingclasses;

import java.util.ArrayList;

public class StackOfStrings{
    private ArrayList<String> data;

    StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if(data.isEmpty()){
            return null;
        }
        return this.data.remove(this.data.size()-1);
    }

    public String peek(){
        return this.data.get(this.data.size()-1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
