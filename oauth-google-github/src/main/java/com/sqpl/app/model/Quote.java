package com.sqpl.app.model;

import java.util.ArrayList;

public class Quote {
	
	public String _id;
    public String content;
    public String author;
    public ArrayList<String> tags;
    public String authorSlug;
    public int length;
    public String dateAdded;
    public String dateModified;

    public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getAuthorSlug() {
		return authorSlug;
	}
	public void setAuthorSlug(String authorSlug) {
		this.authorSlug = authorSlug;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	@Override
	public String toString() {
		return content + " - " + author;
	}
	
}
