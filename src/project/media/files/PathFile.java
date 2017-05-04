package project.media.files;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

public class PathFile {
	private URL url;

	public PathFile(String path, boolean relative) throws IOException {
		this(new URL("file://" + (relative ? new File(".").getCanonicalPath()+path : path)));
	}

	public PathFile(URL url) {
		this.url = url;
	}

	public PathFile setURL(String path) throws MalformedURLException {
		this.url = new URL(path);
		return this;
	}

	public PathFile setURL(URL url) {
		this.url = url;
		return this;
	}

	public URL getURL() {
		return this.url;
	}

	public String getPath() {
		return this.url.getAuthority() + this.url.getPath();
	}
}
