import java.util.ArrayList;

public class TestGenerics {
    public static void main(String[] args) {
        MyFirstObject myObj1 = new MyFirstObject();
        MySecondObject myObj2 = new MySecondObject();
        Object we = new Object();
        
        
        MyGenerics mg = new MyGenerics();
        
        
        Character[] array = {'2','4','6','8','3','9','q','2'};

        System.out.println( mg.partOne(array, array.length, 2) );

        System.out.println( mg.partTwo(myObj1, myObj2) );
        
        
        
    }
}