package org.prk.domain;

public class SearchForm {

	
	private String heading;
	private String content;
	
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "SearchForm [heading=" + heading + ", content=" + content + "]";
	}
}
