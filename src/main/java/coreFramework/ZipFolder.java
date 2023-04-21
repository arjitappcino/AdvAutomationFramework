package coreFramework;

import java.io.*;
import java.util.zip.*;

public class ZipFolder {
	
    public static String zipIt(String inputFilePath, String outputFolderPath) throws IOException {
        // Create a file object for the input file
        File inputFile = new File(inputFilePath);

        // Create a file object for the output folder
        File outputFolder = new File(outputFolderPath);

        // Create a ZIP file with the same name as the input file in the output folder
        String outputFilePath = outputFolderPath + "/" + inputFile.getName() + ".zip";
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        ZipOutputStream zos = new ZipOutputStream(fos);

        // Add the input file to the ZIP file
        ZipEntry zipEntry = new ZipEntry(inputFile.getName());
        zos.putNextEntry(zipEntry);
        FileInputStream fis = new FileInputStream(inputFile);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        zos.closeEntry();
        fis.close();

        // Close the ZIP output stream
        zos.close();
        fos.close();

        // Return the path of the created ZIP file
        return outputFilePath;
    }
}
