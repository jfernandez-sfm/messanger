package org.samfm.jaxrs.messanger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
public class Message {

	private long id;
	private String message;
	private String author;
	private Date messageDate;
	private Map<Long, Comment> comments = new HashMap<>(); 
	private List<Link> links = new ArrayList<Link>();

	public Message() {
	}	
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.messageDate = new Date();
	}


	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}


	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMessage() {
		return this.message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getAuthor() {
		return this.author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Date getMessageDate() {
		return this.messageDate;
	}


	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}


	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String rel, String uri) {
		Link link = new Link(rel, uri);
		links.add(link);
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", author=" + author + ", messageDate=" + messageDate
				+ ", comments=" + comments + "]";
	}
	
	

}
