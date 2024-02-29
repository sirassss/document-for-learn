package design.pattern.behavior.state;

public class Example {
    public static void main(String[] args) {
        DocumentContext context = new DocumentContext();

        context.setState(new NewState());
        context.applyState();

        context.setState(new SubmittedState());
        context.applyState();

        context.setState(new ApprovedState());
        context.applyState();
    }
}

interface State {

    void handleRequest();
}

class NewState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Create a new document");
    }
}

class SubmittedState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Submitted");
    }
}

class ApprovedState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Approved");
    }
}

class RejectedState implements State {

    @Override
    public void handleRequest() {
        System.out.println("Rejected");
    }
}

class DocumentContext {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void applyState() {
        this.state.handleRequest();
    }
}