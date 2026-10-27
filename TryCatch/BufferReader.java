import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReader {
    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(inputFile));

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(outputFile));

            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
