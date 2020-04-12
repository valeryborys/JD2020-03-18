package by.it.verbitsky.calc;

interface MemoryCalc {
    void memoryAdd(String key, Var value);

    Var getFromMemory(String key);

    void printvar();

    void sortvar();

    void clearMemory();
}
