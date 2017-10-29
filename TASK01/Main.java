package TASK01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Роман on 26.10.2017.
 */
public class Main
{
    static String infolderName = ".";
    static String outfolderName = ".\\outFolder";

    static String[] arr = {"txt", "doc"};

    public static void main(String[] args)
    {
        MyFileFilter mFF = new MyFileFilter(arr);
        File infolder = new File(infolderName);
        File outfolder = new File(outfolderName);
        File[] fileList = infolder.listFiles(mFF);
        if (fileList == null || fileList.length == 0)
        {
            return;
        }
        Main main = new Main();
        if (!outfolder.exists())
        {
            outfolder.mkdir();
        }
        for (File file : fileList)
        {
            File outfile = new File(outfolder + "\\" + file.getName());
            main.copyFile(file.toString(), outfile.toString());
        }
    }


    private void copyFile (String input, String output)
    {
        try (FileInputStream fis = new FileInputStream(input); FileOutputStream fos = new FileOutputStream(output))
        {
            byte[] buffer = new byte[1024];
            int byteread = 0;
            for (; (byteread = fis.read(buffer)) > 0;)
            {
                fos.write(buffer,0, byteread);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
