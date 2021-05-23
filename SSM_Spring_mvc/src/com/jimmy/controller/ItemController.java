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


//这里是窄化请求路径(将共同的路径抽取出来在类上面直接配置注解)
@RequestMapping(value = "/item/")
@Controller
public class ItemController {

	
	/* @RequestMapping(value = {"/item/list.do","mylist.do"},method = RequestMethod.GET)
	多请求，这里value是一个数组，可以通过这两种方式访问到页面
	method = RequestMethod.GET  这里是限定请求方法 当前若以 post请求是会报错的 ;见(form.jsp)*/
	
	
	@RequestMapping(value = {"list.do","mylist.do"},method = RequestMethod.GET)	
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView();
		
		//用构造函数来初始化值
		ItemInfo item1=new ItemInfo("1", "王者荣耀", "枪战", "100");
		ItemInfo item2=new ItemInfo("2", "吃鸡", "枪战", "0");
		ItemInfo item3=new ItemInfo("3", "大战僵尸", "恐怖", "897");
		ItemInfo item4=new ItemInfo("4", "魔兽世界", "恐怖", "200");
		ItemInfo item5=new ItemInfo("5", "斗地主", "休闲", "100");
		
		//声明一个数组将值存储进去
		List<ItemInfo> itemList=new ArrayList<ItemInfo>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		
		//将游戏列表返回给前台
		mav.addObject("itemList", itemList);

		mav.setViewName("item_list");
		return mav;
	}
	
	//void
	@RequestMapping(value="")
	public void voidTest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//获取参数
		request.getParameter("");
		//转发
		request.getRequestDispatcher("").forward(request, response);
		//重定向
		response.sendRedirect(request.getContextPath()+"/xxx.jsp");
				
	}
	
	//String 转发	
	@RequestMapping(value="forwardString.do")
	public String forwardString() {
		
		return "forward:list.do";
	}
	
	//String  重定向	 
	@RequestMapping(value="redirectString.do")
	public String redirectString() {
			
		return "redirect:/form.jsp";
	}
	
	
	
	//返回视图名
	@RequestMapping(value="testlist.do")
	public String testlist(Model model) {
		
		//用构造函数来初始化值
		ItemInfo item1=new ItemInfo("1", "王者荣耀", "枪战", "100");
		ItemInfo item2=new ItemInfo("2", "吃鸡", "枪战", "0");
		ItemInfo item3=new ItemInfo("3", "大战僵尸", "恐怖", "897");
		ItemInfo item4=new ItemInfo("4", "魔兽世界", "恐怖", "200");
		ItemInfo item5=new ItemInfo("5", "斗地主", "休闲", "100");
		
		//声明一个数组将值存储进去
		List<ItemInfo> itemList=new ArrayList<ItemInfo>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		
		//将游戏列表返回给前台
		//mav.addObject("itemList", itemList);

		//mav.setViewName("item_list");
		model.addAttribute("itemList", itemList);
		
		return "item_list";  //直接返回页面
	}
	
}
