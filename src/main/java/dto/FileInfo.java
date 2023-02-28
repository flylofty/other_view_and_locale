package dto;

import java.io.File;

public class FileInfo {
	private String no;
	private String name;
	private String type;
	private String size;

	public FileInfo(File file, int number) {
		this.no = Integer.toString(number);
		this.name = file.getName().split("\\.")[0];
		this.type = file.getName().split("\\.")[1];
		this.size = file.length() + " bytes";
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getSize() {
		return size;
	}
	@Override
	public String toString() {
		return "FileInfo [no=" + no + ", name=" + name + ", type=" + type + ", size=" + size + "]";
	}
}
