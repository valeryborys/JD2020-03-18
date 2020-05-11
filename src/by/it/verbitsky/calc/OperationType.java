package by.it.verbitsky.calc;

enum OperationType {
    SUM, SUB, MUL, DIV, MEMORY;

    @Override
    public String toString() {
        switch (OperationType.this) {
            case SUM:
                return "Sum";
            case DIV:
                return "Division";
            case MUL:
                return "Multiplication";
            case SUB:
                return "Subtraction";
            case MEMORY:
                return "Memory operation";
        }
        return "OperationType";
    }
}
