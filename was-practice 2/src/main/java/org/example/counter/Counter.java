package org.example.counter;

//싱글톤 객체는 상태를 유지하게 설계하면 안된다!!
public class Counter implements Runnable{
    private int count = 0; // 상태값

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    public int getValue(){
        return count;
    }

    @Override
    public void run(){
        synchronized (this) {
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getValue());
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());

        }
    }

}
