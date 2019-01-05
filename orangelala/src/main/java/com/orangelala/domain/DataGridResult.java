package com.orangelala.domain;

import java.util.List;

/**  
* <p>Title: DataGridResult.java</p>  
* <p>Description:分页结果集,存储分页后的结果 </p>  
* @author QEcode  
* @date 2019年1月5日  
* @version 1.0  
*/ 
public class DataGridResult {
    	//总记录数
	private long total;
	//结果集
	private List<?> rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}	
}
