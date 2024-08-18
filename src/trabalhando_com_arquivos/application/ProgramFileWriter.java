package trabalhando_com_arquivos.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramFileWriter {
    public static void main (String []args){
        String [] lines = new String[]{ "Good Morning", "Good uh", "Good Night", "hello hello"};
        String path = "/home/nathy/Documentos/out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
            for (String line:lines){
                bw.write(line);
                bw.newLine();

            }
        }

    catch (IOException e){
            e.printStackTrace();
    }

    }
}
