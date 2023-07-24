package org.example.Models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {
	public void showFolder(String pathFolderBackup) throws NullPointerException, SecurityException, IllegalArgumentException {
		File folder = new File(pathFolderBackup);
		if (!folder.isDirectory()) {
			throw new IllegalArgumentException("Указанный путь не является директорией");
		}
		if (folder.listFiles() == null) {
			throw new NullPointerException("В директории нет файлов");
		}
		System.out.println("Ниже представлены все файлы и папки в указанной директории: ");
		for (File file :
				folder.listFiles()) {
			System.out.println(file.getName());
		}
	}
	
	public static void backupFileInFolder(String pathFolderToBackup, String backupFolderPath) throws IOException, IllegalArgumentException, NullPointerException, SecurityException {
		File sourceFolder = new File(pathFolderToBackup);
		File backupFolder = new File(backupFolderPath);
		if (!sourceFolder.isDirectory()) {
			throw new IllegalArgumentException("Указанный путь не является директорией");
		}
		
		if (sourceFolder.listFiles() == null) {
			throw new NullPointerException("В директории нет файлов");
		}
		
		if (!backupFolder.exists()) {
			backupFolder.mkdirs();
		}
		
		for (File file :
				sourceFolder.listFiles()) {
			if (file.isFile()) {
				File newBackup = new File(backupFolderPath + "/" + file.getName());
				copyFile(file, newBackup);
			}
		}
		System.out.println("Резервное копирование завершено");
	}
	
	private static void copyFile(File sourceFile, File destinationFile) throws IOException {
		try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
		     FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
			int length;
			while ((length = fileInputStream.read()) > 0) {
				fileOutputStream.write(length);
			}
		}
	}
}
