package com.psl.pages;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.psl.employee.Employee;

public class PageOutput {
	private Pageable prevPage;
	private Pageable nextPage;
	
	private List<Employee> pageData;
	
	private long pageNumber;
	private long pageSize;
	
	private long totalPages;
	private long totalElements;

	public Pageable getPrevPage() {
		return prevPage;
	}
	
	public void setPrevPage(Pageable prevPage) {
		this.prevPage = prevPage;
	}
	
	public Pageable getNextPage() {
		return nextPage;
	}
	
	public void setNextPage(Pageable nextPage) {
		this.nextPage = nextPage;
	}
	
	public List<Employee> getPageData() {
		return pageData;
	}
	
	public void setPageData(List<Employee> pageData) {
		this.pageData = pageData;
	}
	
	public long getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public long getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	
	public long getTotalElements() {
		return totalElements;
	}
	
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
}
