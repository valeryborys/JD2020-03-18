package by.it.okatov.calc.temp.logsystem;

public interface ILogSystem {
    void readConsole();

    void writeLog(byte[] buffer, int offset, int length);
}
