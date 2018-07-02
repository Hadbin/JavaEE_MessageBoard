package domain;

import java.util.Date;

public class Message {
	private String id;
	private String theme;
	private String writer;
	private String date;
	private String content;
	private String reply;
	private int edit;
	public int getEdit() {
		return edit;
	}
	
	public void setEdit(int edit) {
		this.edit = edit;
	}

	private int userId;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", theme=" + theme + ", writer=" + writer + ", date=" + date + ", content="
				+ content + ", reply=" + reply + ", edit=" + edit + ", userId=" + userId + "]";
	}

}
