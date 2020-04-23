package by.it.tolstik.jd01.jd01_08.oop;

public class Cdplayer extends Player{


    Cdplayer(String model, boolean exist) {
        super(model, exist);
    }

    @Override
    public void isWork() {
        if (this.getExist()) {
            System.out.println("Работает!");
        }
        else {
            System.out.println("Не работает!");
        }
    }

    @Override
    public void isOpenDrive() {
        if (this.getExist()) {
            System.out.println("Дисковод открыт");
        }
        else {
            System.out.println("Не работает!");
        }

    }

    @Override
    public void play() {
        if (this.getExist()) {
            System.out.println("Старт");
        }
        else {
            System.out.println("Не работает!");
        }
    }

    @Override
    public void pause() {
        if (this.getExist()) {
            System.out.println("Пауза");
        }
        else {
            System.out.println("Не работает!");
        }
    }

    @Override
    public void stop() {
        if (this.getExist()) {
            System.out.println("Стоп");
        }
        else {
            System.out.println("Не работает!");
        }
    }

    @Override
    public void destroy(boolean choose) {
        this.setExist(choose);
    }

    @Override
    public void switchOff() {
        if (this.getExist()) {
            System.out.println("Выключено!");
        }
        else {
            System.out.println("Не работает!");
        }
    }

    @Override
    public String toString() {
        return this.getModel() + " суперсидиплеер.";
    }
}
