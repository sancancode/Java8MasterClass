package streams.textfile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Lines {


    public static void main(String[] args) throws  Exception{

        Path path = Path.of("text.txt");

        try(Stream<String> lines = Files.lines(path);){
            System.out.println(lines.count());
        }

        catch (Exception e){



        }
    }
}
