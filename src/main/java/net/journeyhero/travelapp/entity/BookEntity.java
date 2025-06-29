package net.journeyhero.travelapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="book")
public class BookEntity {
	
	@Id
	private String title;
	private Integer pageCount;
	
	public BookEntity() {
	}
	
	public BookEntity(String title, Integer pageCount) {
		this.title = title;
		this.pageCount = pageCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
}
