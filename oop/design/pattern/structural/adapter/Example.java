package design.pattern.structural.adapter;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<IFood> foods = List.of(new RiceAdapter(new Rice()), new NoodleAdapter(new Noodle()));
        foods.forEach(IFood::cook);
    }
}

interface IFood {
    void cook();
}

class NoodleAdapter implements IFood{
    private Noodle noodle;

    public NoodleAdapter(Noodle noodle) {
        this.noodle = noodle;
    }

    @Override
    public void cook() {
        this.noodle.handle();
    }
}

class RiceAdapter implements IFood{
    private Rice rice;

    public RiceAdapter(Rice rice) {
        this.rice = rice;
    }

    @Override
    public void cook() {
        this.rice.doCook();
    }
}

class Noodle {
    void handle() {
        System.out.println("Noodle is cooked");
    }
}

class Rice {
    void doCook() {
        System.out.println("Rice is cooked");
    }
}
