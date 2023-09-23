package deque;

import java.lang.reflect.Type;
import java.util.Comparator;

public class MaxArrayDeque<Type> extends ArrayDeque<Type> {
    private Comparator<Type> comp;
    public MaxArrayDeque(Comparator<Type> c) {
        comp = c;
    }

    public Type max() {
        Type tmp = get(0);
        for (Type t : this) {
            if(comp.compare(t, tmp) > 0)
                tmp = t;
        }
        return tmp;
    }

    public Type max(Comparator<Type> c) {
        Type tmp = get(0);
        for (Type t : this) {
            if(c.compare(t, tmp) > 0)
                tmp = t;
        }
        return tmp;
    }
}
