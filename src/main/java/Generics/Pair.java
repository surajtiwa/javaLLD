package Generics;

public class Pair<K, V> {
    K first;//if no data types are passed then K is of defalut Object type;
    V second;


    void setFirst(K x){
        first = x;
    }

    V getSecond(){
        return second;
    }

    public static<A,B> void doSomethingStatic(A a, B b){

    }
    public void doSomethingNonStatic(V x){

    }

    public <Prateek> Prateek doSomethingForLearning(Prateek p1){//will not be able to detect the data type
        return p1;
    }

}
