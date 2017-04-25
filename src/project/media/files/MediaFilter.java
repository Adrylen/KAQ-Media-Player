/*
 *   Java Project
 *   Project
 *   Package : project.media.files
 *   Created by adrylen on 25/04/17.
*/

package project.media.files;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class MediaFilter extends FileFilter {
	private final String description;
	private final String extension;

	public MediaFilter(String description, String extension) {
		this.description = description;
		this.extension = extension;
	}

	@Override
	public boolean accept(File file) {
		if(file.isDirectory()) {
			return true;
		}
		return file.getName().toLowerCase().endsWith(extension);
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
