package org.samfm.jaxrs.messanger.model;


public class Link {

	private String rel;
	private String uri;
	
	public Link() {
		
	}
	
	public Link(String rel, String uri) {
		super();
		this.rel = rel;
		this.uri = uri;
	}
	
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
