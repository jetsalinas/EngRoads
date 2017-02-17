package Map;

import java.util.*;

/**
 * Created by Jose Salinas on 2/1/2017.
 */
public class RoadQueue<Vehicle> implements Queue {

    ArrayList<Vehicle> queue;
    private int front;
    private int back ;
    private static final int INITIAL_CAPACITY = 80;
    private int capacity = 0;
    private int elements = 0;

    public RoadQueue() {
        this.capacity = INITIAL_CAPACITY;
        this.front = 0;
        this.back = 0;
        queue = new ArrayList<>(INITIAL_CAPACITY);
    }

    public RoadQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.back = 0;
        queue = new ArrayList<>(capacity);

        for(int i=0; i<capacity; i++) {
            queue.add(null);
        }
    }

    @Override
    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.size();
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if(size() == capacity - 1) {
            //resize;
        }
        queue.set(back, (Vehicle) o);
        if (back < capacity - 1) {
            ++back;
        } else {
            back = 0;
        }
        ++elements;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return queue.addAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
        front = 0;
        back = 0;
        elements = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean offer(Object o) {
        if(size() == queue.size() - 1) {
            //resize;
        }
        queue.set(back, (Vehicle) o);
        if (back < capacity - 1) {
            ++back;

        } else {
            back = 0;
        }
        ++elements;
        return true;
    }

    @Override
    public Object remove() {
        if (queue.size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        Vehicle element = queue.get(front);
        queue.set(front, null);
        ++front;
        --elements;
        if(front == back) {
            front = back = 0;
        }
        if(front == capacity) {
            front = 0;
        }
        return element;
    }

    @Override
    public Object poll() {
        if (queue.size() == 0) {
            return null;
        }
        Vehicle element = queue.get(front);
        queue.set(front, null);
        ++front;
        --elements;
        if(front == back) {
            front = back = 0;
        }
        if(front == capacity) {
            front = 0;
        }
        return element;
    }

    @Override
    public Object element() {
        if (queue.size() == 0) {
            throw new NoSuchElementException();
        }
        Vehicle element = queue.get(front);
        if(front == back) {
            front = back = 0;
        }
        if(front == capacity) {
            front = 0;
        }
        return element;
    }

    @Override
    public Object peek() {
        if (queue.size() == 0) {
            return null;
        }
        Vehicle element = queue.get(front);
        if(front == back) {
            front = back = 0;
        }
        if(front == capacity) {
            front = 0;
        }
        return element;
    }

    public boolean isFull() {
        return front == queue.size() - 1;
    }

    public int getElements() {
        return elements;
    }

    @Deprecated
    private void resize() {

    }
}
