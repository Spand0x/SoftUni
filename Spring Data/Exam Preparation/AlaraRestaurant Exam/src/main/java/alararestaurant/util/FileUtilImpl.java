package alararestaurant.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileUtilImpl implements FileUtil {
    @Override
    public String readFile(String filePath) {
        String file = null;
        try {
            file = Files.readAllLines(Paths.get(filePath))
                    .stream()
                    .filter(x -> !x.isEmpty())
                    .collect(Collectors.joining(System.lineSeparator()));
        }catch (IOException e){
            e.printStackTrace();
        }
        return file;
    }
}
