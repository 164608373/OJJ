package com.sise.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompareFile {

		/**
			 * <p>
			 * compare two file's content. if not equal then return false; else return true;
			 * </p>
			 * @param oldFilePath
			 * @param newFilePath
			 * @return
			 */
			public static boolean isFileContentEqual(String oldFilePath, String newFilePath) {
				//check does the two file exist.
					File oldFile = new File(oldFilePath);
					File newFile = new File(newFilePath);
					FileInputStream oldInStream = null;
					FileInputStream newInStream = null;
					try {
						oldInStream = new FileInputStream(oldFile);
						newInStream = new FileInputStream(newFile);

						int oldStreamLen = oldInStream.available();
						int newStreamLen = newInStream.available();
						//check the file size first.
						if (oldStreamLen > 0 && oldStreamLen == newStreamLen) {
							//read file data with a buffer.
							int cacheSize = 128;
							byte[] data1 = new byte[cacheSize];
							byte[] data2 = new byte[cacheSize];
							do {
								int readSize = oldInStream.read(data1);
								newInStream.read(data2);

								for (int i = 0; i < cacheSize; i++) {
									if (data1[i] != data2[i]) {
										return false;
									}
								}
								if (readSize == -1) {
									break;
								}
							} while (true);
							return true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
		                                //release the stream resource.
						try {
							if (oldInStream != null)
								oldInStream.close();
							if (newInStream != null)
								newInStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				return false;
			}


}

