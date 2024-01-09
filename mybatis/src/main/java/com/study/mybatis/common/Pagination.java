package com.study.mybatis.common;

import com.study.mybatis.common.vo.PageInfo;

public class Pagination {

	 public static PageInfo getPageInfo(int totalRecord, int nowPage, int numPerPage, int pagePerBlock) {
		 int totalPage = (int)Math.ceil((double)totalRecord / numPerPage);	// 소수점 처리 double
		 int startPage = (nowPage - 1) / pagePerBlock * pagePerBlock + 1;	// 첫페이지가 1이 되게
		 int endPage = startPage + pagePerBlock - 1;
		 
		 if(endPage > totalPage) {
			 endPage = totalPage;
		 }
		 
//		 PageInfo pi = new PageInfo(totalRecord, nowPage, numPerPage, pagePerBlock, totalPage, startPage, endPage);
//		 return pi;
		 return new PageInfo(totalRecord, nowPage, numPerPage, pagePerBlock, totalPage, startPage, endPage);
		 
	 }
	
	
}
