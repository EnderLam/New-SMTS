package Memento;

public class Memento{
    private MyClass myClass;
    private int mState;

public Memento(MyClass myClass){
    this.myClass = myClass;
    this.mState = myClass.state;
}

public void restore(){
    myClass.state = mState;
}

public MyClass getMyClass(){
    return this.myClass;
}
}