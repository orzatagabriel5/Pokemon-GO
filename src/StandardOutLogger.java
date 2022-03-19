public class StandardOutLogger implements Logger{

    @Override
    public void print(StringBuffer buffer) {
        System.out.println(buffer);
    }
}
