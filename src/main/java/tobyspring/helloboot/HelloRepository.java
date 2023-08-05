package tobyspring.helloboot;

public interface HelloRepository {
    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) {
        System.out.println("name = " + name);
        Hello hello = findHello(name);
        System.out.println("hello = " + hello);;
        return hello == null ? 0 : hello.getCount();
    }
}
