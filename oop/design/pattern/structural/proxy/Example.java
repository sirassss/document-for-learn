package design.pattern.structural.proxy;

import java.util.Objects;

public class Example {

    public static void main(String[] args) {
        Resource resource1 = new SecurityProxy("Resource 1", "admin", "password123");
        Resource resource2 = new SecurityProxy("Resource 2", "user", "password456");

        // the real resource will be accessed only if the user is authenticated
        resource1.access();
        resource2.access();
    }

}

// Resource interface
interface Resource {
    void access();
}

// RealResource class
class RealResource implements Resource {
    private String name;

    public RealResource(String name) {
        this.name = name;
    }

    @Override
    public void access() {
        System.out.println("Accessing " + name);
    }
}

// SecurityProxy class
class SecurityProxy implements Resource {
    private RealResource realResource;
    private String name;
    private String username;
    private String password;

    public SecurityProxy(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Override
    public void access() {
        if (Objects.isNull(realResource)) {
            authenticate();
            realResource = new RealResource(name);
        }
        realResource.access();
    }

    private void authenticate() {
        // perform authentication logic here
        System.out.println("Authenticating user " + username);
    }
}