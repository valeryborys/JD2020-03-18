package by.it.verbitsky.calc;

class CalcEventType {
    String operationType;
    String errorType;
    String systemType;

    CalcEventType() {
    }

    public CalcEventType setErrorEventType(Exception ex) {
        errorType = ex.getClass().getSimpleName();
        operationType = null;
        systemType = null;
        return this;
    }

    public CalcEventType setCalcEventType(String type) {
        operationType = type;
        errorType = null;
        systemType = null;
        return this;
    }

    public CalcEventType setSystemEventType(String type) {
        systemType = type;
        errorType = null;
        operationType = null;
        return this;
    }


    public String getOperationType() {
        return operationType;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getSystemType() {
        return systemType;
    }

    @Override
    public String toString() {
        StringBuilder type = new StringBuilder();
        if (this.errorType != null) {
            //значит тип ивента - ошибка
            type
                    .append("<Event type: ERROR> <class: ")
                    .append(errorType)
                    .append("> ");
        }
        if (operationType != null) {
            //значит тип ивента - операция
            type
                    .append("<Event type: Operation> <operation type: ")
                    .append(operationType)
                    .append("> ");

        }
        if (systemType != null) {
            type
                    .append("<Event type: SYSTEM> <operation : ")
                    .append(systemType)
                    .append("> ");
        }

        if (type.length() > 0) {
            return type.toString();
        } else {
            return "Unknown event";
        }

    }
}
