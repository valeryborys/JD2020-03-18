package by.it.szamostyanin.Practice.Threads;

public class MyThread extends Thread {

    @Override
    public void run() { //должен быть у каждого потока
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + "Cycle №" + i);
            try {
                sleep((int) (Math.random() * 1000));    //поток останавливается на 0..999 миллисекунд
                //yield();    //поток отдает кванты времени другому потоку, если процессору делать нечего, он вернет их обратно этому потоку
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
    }

    public MyThread(String name) {   //конструктор передает имя суперклассу
        super(name);
    }

    public static void main(String[] args) {
        new MyThread("First stream ").start();  //запускает первый поток
        new MyThread("Second stream ").start();
        new MyThread("Third stream ").start();
    }
}