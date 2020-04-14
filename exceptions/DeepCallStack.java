
public class DeepCallStack {

    public void methodA(){
        methodB();
    }

    public void methodB(){
        methodC();
    }

    public void methodC(){
        methodD();
    }

    public void methodD(){
        //Calculator.divide(1, 2);
        return;
    }

}
