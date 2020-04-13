package by.it.tolstik.jd01_08.oop;

class Runner {
    public static void main(String[] args) {
        Videoplayer videoplayer = new Videoplayer("Sony",true);
        System.out.println(videoplayer);
        videoplayer.isWork();
        videoplayer.destroy(true);
        videoplayer.isWork();
        videoplayer.isOpenDrive();
        videoplayer.destroy(false);
        videoplayer.isWork();
        videoplayer.isOpenDrive();

    }
}
