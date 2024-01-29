package garbagecollection;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

class ObjectReference {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector in action! Deleted one object!");
    }

    String reference;

    ObjectReference(String reference) {
        this.reference = reference;
    }
}

public class GarbageCollectionDemo {

    public static void main(String[] args) {
        ObjectReference reference1 = new ObjectReference("string");
        ObjectReference reference2 = new ObjectReference("object");
        reference1.reference = reference2.reference;
        reference2.reference = reference1.reference;

        reference1 = null;//Nullifying the first object

        reference2 = null;//nullifying the second object.


        System.gc();//calling the garbage collector.

    }

}
