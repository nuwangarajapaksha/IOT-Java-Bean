@Stateless
public class ExampleBean implements ExampleRemote {
    public String hello() {
        return "Hello, world!";
    }
}

@Remote
public interface ExampleRemote {
    public String hello();
}
