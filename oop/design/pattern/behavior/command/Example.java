package design.pattern.behavior.command;

public class Example {
    public static void main(String[] args) {
        Account account = new Account("alsenpai");

        Command open = new OpenAccount(account);
        Command close = new CloseAccount(account);
        BankApp bankApp = new BankApp();

        bankApp.click(open);
        bankApp.click(close);
    }
}

class Account {
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Account [" + name + "] Opened\n");
    }

    public void close() {
        System.out.println("Account [" + name + "] Closed\n");
    }
}

interface Command {

    void execute();
}

class OpenAccount implements Command {

    private Account account;

    public OpenAccount(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.open();
    }
}

class CloseAccount implements Command {

    private Account account;

    public CloseAccount(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.close();
    }
}

class BankApp {

    public void click(Command command) {
        command.execute();
    }
}