package by.it.verbitsky.calc;

import java.io.*;
import java.util.Map;

abstract class CalcMemoryManager {
    private static ResourceManager rm = ConsoleRunner.getRm();

    public static void writeMemoryToFile(String fName) {
        //Если не пустая память - пишем в файл содержимое
        if (Var.getCalcMemory().size() > 0) {
            try (PrintWriter writer = new PrintWriter(fName)) {
                for (Map.Entry<String, Var> entry : Var.getCalcMemory().entrySet()) {
                    writer.printf("%s=%s\n", entry.getKey(), entry.getValue());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            //если память была очищена - очищаем файл
            try (PrintWriter writer = new PrintWriter(fName)) {
                writer.flush();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void readMemoryFromFile(String fName, CalcLogger logger) throws CalcException {
        //читаем если файл не пустой
        Parser parser = new Parser();
        if (new File(fName).length() > 1) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fName))) {
                while (reader.ready()) {
                    parser.calc(reader.readLine(), logger);
                }
            } catch (CalcException e) {
                throw new CalcException(rm.getMessage(CalcMessages.SYSTEM_ERROR_READ_MEMORY_FILE));
            } catch (IOException e) {
                logger.writeLog(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    //не работает с ветором и матрицей, почему-то не может создать вектор или матрицу из строки
    //хотя если эту же строку вставить в консоль - все работает и вектор создается
    //возможно что-то с парсингом
    private static void memoryAdd(String line) throws CalcException {
        String[] parts = line.replace("\n", "").split("=");
        try {
            Var.memoryAdd(parts[0].trim(), new VariableCreator().createVar(parts[1].trim()));
        } catch (CalcException e) {
            throw new CalcException(rm.getMessage(CalcMessages.SYSTEM_ERROR_WRONG_OP_MEMORY_ADD));
        }
    }

    public static String getFullPath(Class<?> aClass, String name) {
        StringBuilder fullPath = new StringBuilder();
        fullPath.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(aClass.getName()
                        .replace('.', File.separatorChar)
                        .replace(aClass.getSimpleName(), ""))
                .append(name);
        return fullPath.toString();
    }


}
