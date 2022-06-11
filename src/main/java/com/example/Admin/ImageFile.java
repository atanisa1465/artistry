package com.example.Admin;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class ImageFile {
	@BsonProperty(value = "_id")
	private String id;
	@BsonProperty(value = "val")
	private byte[] val;
	
	public ImageFile() {
		super();
	}
	
	public ImageFile(String id, byte[] val) {
		super();
		this.id = id;
		this.val = val;
	}
	
	public String getID() {
		return id;
	}

	public byte[] getVal() {
		return val;
	}

}