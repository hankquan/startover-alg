package com.github.howaric.alg.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

//加强堆，增加反向索引表
public class EnhancedHeap<T> {

    private int size;
    private ArrayList<T> heapList;
    private HashMap<T, Integer> elementIndexMap;
    private Comparator<T> comparator;

    public EnhancedHeap(Comparator<T> comparator) {
        heapList = new ArrayList<>();
        elementIndexMap = new HashMap<>();
        this.comparator = comparator;
    }

    //查看堆顶元素
    public T peek() {
        return heapList.get(0);
    }

    //返回堆顶元素
    public T pop() {
        if (size == 0) {
            return null;
        }
        T top = heapList.get(0);
        swap(size - 1, 0);
        heapify(0);
        heapList.remove(--size);
        elementIndexMap.remove(top);
        return top;
    }

    //添加元素到堆中
    public void push(T t) {
        //入堆
        heapList.add(t);
        elementIndexMap.put(t, size);
        heapInsert(size++);
    }

    //向下看
    private void heapify(int index) {
        //左子节点
        int leftChildIndex = 2 * index + 1;
        while (leftChildIndex < size) {
            int betterChild = leftChildIndex + 1 < size && comparator.compare(heapList.get(leftChildIndex + 1), heapList.get(leftChildIndex)) < 0 ? leftChildIndex + 1 : leftChildIndex;
            if (comparator.compare(heapList.get(index), heapList.get(betterChild)) < 0) {
                break;
            }
            swap(index, betterChild);
            index = betterChild;
            leftChildIndex = 2 * index + 1;
        }
    }

    private void swap(int i, int j) {
        T t1 = heapList.get(i);
        T t2 = heapList.get(j);
        heapList.set(i, t2);
        heapList.set(j, t1);
        elementIndexMap.put(t1, j);
        elementIndexMap.put(t2, i);
    }

    //向上看
    private void heapInsert(int index) {
        int parentIndex = (index - 1) / 2;
        while (comparator.compare(heapList.get(index), heapList.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    //t元素内容变动，重新组织堆结构
    public void resign(T t) {
        heapify(elementIndexMap.get(t));
        heapInsert(elementIndexMap.get(t));
    }

    //移除元素t
    public void remove(T t) {
        Integer index = elementIndexMap.get(t);
        elementIndexMap.remove(t);
        T last = heapList.get(size - 1);
        heapList.remove(--size);
        if (last != t) {
            heapList.set(index, last);
            elementIndexMap.put(last, index);
            resign(last);
        }
    }

    public List<T> getAll() {
        ArrayList<T> result = new ArrayList<>();
        heapList.forEach(result::add);
        return result;
    }

}

class Student {
    String name;
    Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class Main {
    public static void main(String[] args) {
        EnhancedHeap<Student> heap = new EnhancedHeap<>(new StudentComparator());
        Student xiaoming1 = new Student("xiaoming1", 12);
        heap.push(xiaoming1);
        Student xiaoming2 = new Student("xiaoming2", 11);
        heap.push(xiaoming2);
        Student xiaoming3 = new Student("xiaoming3", 8);
        heap.push(xiaoming3);
        System.out.println(heap.getAll());
//        System.out.println(heap.pop());
//        System.out.println(heap.pop());
        heap.remove(xiaoming3);
        System.out.println(heap.getAll());
    }
}