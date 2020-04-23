package by.it.szamostyanin.Practice.Threads;

class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name){
        this.name = name; //суперклассом будет Object а не Thread, поэтому делаем свое поле для имени
    }

    @Override
    public void run(){
        for (int i = 0; i <10 ; i++) {
            System.out.println(name+"is run loop:"+i);
            try{
                Thread.sleep(7);    //методи sleep и yield у запускаемого экземлпляра отсутствуют и их нельзя вызвать по имени, но они статические в классе Thread, поэтому их можно вызвать
                //Thread.yield();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable one = new MyRunnable("one"); //создаем объекты, готовый к запуску в потоке
        MyRunnable two = new MyRunnable("two");

        Thread firstStream = new Thread(one); //создаем поток (на базе интрфейсов)
        Thread secondStream = new Thread(two);
        System.out.println("one: "+firstStream.getState()+"\t"+"two: "+secondStream.getState());

        firstStream.start();    //запускаем поток
        secondStream.start();
        System.out.println("one: "+firstStream.getState()+"\t"+"two: "+secondStream.getState());

        firstStream.join(); //приостановка потока, пока не завершаться два созданных
        secondStream.join();
        System.out.println("one: "+firstStream.getState()+"\t"+"two: "+secondStream.getState());
        System.out.println("All streams ended");
        firstStream.join(); //метод join доступны даже после завершения потока, так как экземляры завершенных объектов еще есть в памяти, но они мгновенно отдают управление
        secondStream.join();
        System.out.println("End");
    }
}