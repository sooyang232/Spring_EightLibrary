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

	//1.��������� �αװ�ü�� ����
		//private Logger log=Logger.getLogger(ListController.class);//�α׸� ó���� Ŭ������
		private Logger log=Logger.getLogger(this.getClass());//this.getClass()->����Ŭ������
		
		@Autowired
		private QnaDAO qnaDAO;//�ڵ����� Setter Method ȣ��X->byType
		
		@RequestMapping("/qna/list.do")
		public ModelAndView process
		          (@RequestParam(value="pageNum",defaultValue="1") int currentPage,
		           @RequestParam(value="keyField",defaultValue="") String keyField,
		           @RequestParam(value="keyWord",defaultValue="") String keyWord) {
			/*@RequestParam(value="�Ű�������",defaultValue="�⺻��") �ڷ��� ��ȭ���� ������
			 * String pageNum=request.getParameter("pageNum");
			 * if (pageNum==null) pageNum="1";
			 * int currentPage=Integer.parseInt(pageNum);//"1"->1
			 */
			if(log.isDebugEnabled()) {//�αװ�ü�� �������������� �ƴ����� üũ
				System.out.println("�ֿܼ��� Ȯ��");
				log.debug("currentPage:"+currentPage);
				log.debug("keyField:"+keyField);
				log.debug("keyWord:"+keyWord);
			}
			//�˻��о�,�˻�� ����=>Map��ü
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("keyField", keyField);//�˻��о�
			map.put("keyWord",keyWord);//�˻���
			//�ѷ��ڵ��
			int count=qnaDAO.getRowCount(map);
			//����¡ ó�� 1.���������� 2.�ѷ��ڵ�� 3.�������� �Խù��� 4.������������ 5.��û��ɾ�
			PagingUtil page=new PagingUtil(currentPage,count,3,3,"list.do");
			//start=>�������� �� ù��° ������ �Խù���ȣ
			map.put("start", page.getStartCount());//<->map.get("start")=>#{start}
			map.put("end", page.getEndCount());
			
			List<QnaCommand> list=null;
			if(count > 0) {
				list=qnaDAO.list(map);
			}else {
				list=Collections.EMPTY_LIST;//0 ����
			}
			
			System.out.println("ListController�� count=>"+count);
			
			ModelAndView mav=new ModelAndView("qnaList");//boardList.jsp
			mav.addObject("count",count);//�ѷ��ڵ��  =>${count}
			mav.addObject("list",list);//�˻��� ���ڵ�� =>${list}
			mav.addObject("pagingHtml",page.getPagingHtml());//��ũ���ڿ� [����] ~<����> >>
			
			return mav;
		}
}
