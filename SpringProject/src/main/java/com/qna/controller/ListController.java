package com.qna.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qna.dao.QnaDAO;
import com.qna.domain.QnaCommand;
import com.qna.util.PagingUtil;

@Controller
public class ListController {

	//1.멤버변수로 로그객체를 선언
		//private Logger log=Logger.getLogger(ListController.class);//로그를 처리할 클래스명
		private Logger log=Logger.getLogger(this.getClass());//this.getClass()->현재클래스명
		
		@Autowired
		private QnaDAO qnaDAO;//자동으로 Setter Method 호출X->byType
		
		@RequestMapping("/qna/list.do")
		public ModelAndView process
		          (@RequestParam(value="pageNum",defaultValue="1") int currentPage,
		           @RequestParam(value="keyField",defaultValue="") String keyField,
		           @RequestParam(value="keyWord",defaultValue="") String keyWord) {
			/*@RequestParam(value="매개변수명",defaultValue="기본값") 자료형 반화받을 변수명
			 * String pageNum=request.getParameter("pageNum");
			 * if (pageNum==null) pageNum="1";
			 * int currentPage=Integer.parseInt(pageNum);//"1"->1
			 */
			if(log.isDebugEnabled()) {//로그객체가 디버깅모드상태인지 아닌지를 체크
				System.out.println("콘솔에서 확인");
				log.debug("currentPage:"+currentPage);
				log.debug("keyField:"+keyField);
				log.debug("keyWord:"+keyWord);
			}
			//검색분야,검색어를 전달=>Map객체
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("keyField", keyField);//검색분야
			map.put("keyWord",keyWord);//검색어
			//총레코드수
			int count=qnaDAO.getRowCount(map);
			//페이징 처리 1.현재페이지 2.총레코드수 3.페이지당 게시물수 4.블럭당페이지수 5.요청명령어
			PagingUtil page=new PagingUtil(currentPage,count,3,3,"list.do");
			//start=>페이지당 맨 첫번째 나오는 게시물번호
			map.put("start", page.getStartCount());//<->map.get("start")=>#{start}
			map.put("end", page.getEndCount());
			
			List<QnaCommand> list=null;
			if(count > 0) {
				list=qnaDAO.list(map);
			}else {
				list=Collections.EMPTY_LIST;//0 적용
			}
			
			System.out.println("ListController의 count=>"+count);
			
			ModelAndView mav=new ModelAndView("qnaList");//boardList.jsp
			mav.addObject("count",count);//총레코드수  =>${count}
			mav.addObject("list",list);//검색된 레코드들 =>${list}
			mav.addObject("pagingHtml",page.getPagingHtml());//링크문자열 [이전] ~<다음> >>
			
			return mav;
		}
}
