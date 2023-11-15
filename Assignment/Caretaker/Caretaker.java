package Caretaker;
import Memento.*;
import java.util.*;
public class Caretaker {
    Stack undoList;
    Stack redoList;

public Caretaker(){
        undoList = new Stack();
        redoList = new Stack();
    }

public void saveMyClass(MyClass mc){
    //create a Memento object
    undoList.push(new Memento(mc));
    }

public void saveRedoMyClass(MyClass mc){
    //create a Memento object
    redoList.push(new Memento(mc));
    }

public void undo(){
    Memento m = (Memento) undoList.pop();
    m.restore();
 }

 public int getUndoListSize(){
    return undoList.size();
 }

 public void redo(){
    Memento m = (Memento) redoList.pop();
    m.restore();
 }

 public int getRedoListSize(){
    return redoList.size();
 }

 public void cleanRedoList(){
    redoList.clear();
 }
}
