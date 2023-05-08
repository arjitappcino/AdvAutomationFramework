package coreFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

	private List<String> fileList;

	private static String fileSeperator = System.getProperty("file.separator");

	private static String OUTPUT_ZIP_FILE;

	private static String SOURCE_FOLDER;

	private static final Logger LOGGER = Logger.getLogger(ZipFolder.class.getName());

	public ZipFolder() {
		fileList = new ArrayList<String>();
	}

	public void zipIt() {
		byte[] buffer = new byte[1024];
		String source = new File(SOURCE_FOLDER).getName();
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(OUTPUT_ZIP_FILE);
			zos = new ZipOutputStream(fos);

			FileInputStream in = null;

			for (String file : this.fileList) {
				LOGGER.info("File Added : " + file);
				ZipEntry ze = new ZipEntry(source + fileSeperator + file);
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(SOURCE_FOLDER + fileSeperator + file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					in.close();
				}
			}

			zos.closeEntry();
			LOGGER.info("Folder successfully compressed");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void generateFileList(File node) {
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.toString()));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}
	}

	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}

	public void setSourceFolder(String sourceFolder) {
		SOURCE_FOLDER = sourceFolder;
	}

	public void setOutputFolder(String outputFolder) {
		OUTPUT_ZIP_FILE = outputFolder;
	}
}
