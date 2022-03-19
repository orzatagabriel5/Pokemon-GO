import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger{

    public static int x = 1;

    @Override
    public void print(StringBuffer buffer) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("output" + x + ".txt"));
        writer.write(String.valueOf(buffer));
        writer.close();
        x++;
    }
}
