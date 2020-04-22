
public class Pair<T>{

    private T first;
    private T second;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T firstItem, T secondItem){
        first = firstItem;
        second = secondItem;
    }

    public void setFirst(T newFirst){
        first = newFirst;
    }

    public void setSecond(T newSecond){
        second = newSecond;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public String toString(){
        return  "first: " + first.toString() +
                "\nsecond: " + second.toString();
    }
}
