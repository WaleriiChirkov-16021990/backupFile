package org.example;

import org.example.Models.Backup;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			Backup backup = new Backup();
			Backup.backupFileInFolder(".", "./Backup/");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.getStackTrace();
		}
		
	}
}