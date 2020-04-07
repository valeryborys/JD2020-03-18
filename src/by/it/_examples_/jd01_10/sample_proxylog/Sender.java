package by.it._examples_.jd01_10.sample_proxylog;

public interface Sender {
    void createConnect(String uri);

    void openTransaction();

    void sendMoney(double count);

    double getAmount();

    void closeTransaction();

    void rollbackTransaction();

}
