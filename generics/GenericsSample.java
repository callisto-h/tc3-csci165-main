
public class GenericsSample<T> {

    private T data;

    public GenericsSample(T data){
        if ( data != null )
            this.data = data;
    }

    public void setData(T data){
        if ( data == null ) return;
        this.data = data;
    }

    public T getData(){
        return data;
    }
}
