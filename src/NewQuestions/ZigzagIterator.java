package NewQuestions;

/*
Suppose you have a Iterator class with has_next() and get_next() methods.

Please design and implement a ZigzagIterator class as a wrapper of two iterators.

For example, given two iterators:
i0 = [1,2,3,4]
i1 = [5,6]

ZigzagIterator it(i0, i1);

while(it.has_next()) {
    print(it.get_next());
}
The output of the above pseudocode would be [1,5,2,6,3,4].
*/


public class ZigzagIterator {
    Iterator i0, i1;
    Iterator it;
    public ZigzagIterator(Iterator i0, Iterator i1) {
        this.i0 = i0; this.i1 = i1;
        this.it = i0.hasNext()? i0:i1;
    }
    
    public boolean has_next() {
        return it.hasNext();
    }
    
    public int get_next() {
        int val = (Integer)it.next();
        if(it == i0 && i1.hasNext())
            it = i1;
        else if(it == i1 && i0.hasNext())
            it = i0;
        return val;
    }
}