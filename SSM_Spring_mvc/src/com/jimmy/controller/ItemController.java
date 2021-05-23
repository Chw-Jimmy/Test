package com.jimmy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jimmy.bean.ItemInfo;


//������խ������·��(����ͬ��·����ȡ������������ֱ������ע��)
@RequestMapping(value = "/item/")
@Controller
public class ItemController {

	
	/* @RequestMapping(value = {"/item/list.do","mylist.do"},method = RequestMethod.GET)
	����������value��һ�����飬����ͨ�������ַ�ʽ���ʵ�ҳ��
	method = RequestMethod.GET  �������޶����󷽷� ��ǰ���� post�����ǻᱨ��� ;��(form.jsp)*/
	
	
	@RequestMapping(value = {"list.do","mylist.do"},method = RequestMethod.GET)	
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView();
		
		//�ù��캯������ʼ��ֵ
		ItemInfo item1=new ItemInfo("1", "������ҫ", "ǹս", "100");
		ItemInfo item2=new ItemInfo("2", "�Լ�", "ǹս", "0");
		ItemInfo item3=new ItemInfo("3", "��ս��ʬ", "�ֲ�", "897");
		ItemInfo item4=new ItemInfo("4", "ħ������", "�ֲ�", "200");
		ItemInfo item5=new ItemInfo("5", "������", "����", "100");
		
		//����һ�����齫ֵ�洢��ȥ
		List<ItemInfo> itemList=new ArrayList<ItemInfo>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		
		//����Ϸ�б��ظ�ǰ̨
		mav.addObject("itemList", itemList);

		mav.setViewName("item_list");
		return mav;
	}
	
	//void
	@RequestMapping(value="")
	public void voidTest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		request.getParameter("");
		//ת��
		request.getRequestDispatcher("").forward(request, response);
		//�ض���
		response.sendRedirect(request.getContextPath()+"/xxx.jsp");
				
	}
	
	//String ת��	
	@RequestMapping(value="forwardString.do")
	public String forwardString() {
		
		return "forward:list.do";
	}
	
	//String  �ض���	 
	@RequestMapping(value="redirectString.do")
	public String redirectString() {
			
		return "redirect:/form.jsp";
	}
	
	
	
	//������ͼ��
	@RequestMapping(value="testlist.do")
	public String testlist(Model model) {
		
		//�ù��캯������ʼ��ֵ
		ItemInfo item1=new ItemInfo("1", "������ҫ", "ǹս", "100");
		ItemInfo item2=new ItemInfo("2", "�Լ�", "ǹս", "0");
		ItemInfo item3=new ItemInfo("3", "��ս��ʬ", "�ֲ�", "897");
		ItemInfo item4=new ItemInfo("4", "ħ������", "�ֲ�", "200");
		ItemInfo item5=new ItemInfo("5", "������", "����", "100");
		
		//����һ�����齫ֵ�洢��ȥ
		List<ItemInfo> itemList=new ArrayList<ItemInfo>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		
		//����Ϸ�б��ظ�ǰ̨
		//mav.addObject("itemList", itemList);

		//mav.setViewName("item_list");
		model.addAttribute("itemList", itemList);
		
		return "item_list";  //ֱ�ӷ���ҳ��
	}
	
}
