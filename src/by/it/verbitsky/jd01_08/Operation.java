package by.it.verbitsky.jd01_08;

import by.it.verbitsky.jd01_07.Var;

public interface Operation {
    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}
