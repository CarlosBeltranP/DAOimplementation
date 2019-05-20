package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping ("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/ask", method = RequestMethod.POST)
	public ModelAndView initMain2
	(@RequestParam(value="cod") Integer cod){
		
		ModelAndView mav = new ModelAndView();
		Student students = null;
		
		try {
		 //log.info("Hola khe hace");
		 students = studentDao.findOne(cod);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("editar");
		return mav;
	}
	
@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav;
	}

	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		Student students =null;
		try {
			studentDao.save(s, 1);
		}catch(Exception e) {
			log.info("Error: "+e.toString());
		}
		students=studentDao.findOne(s.getcStudent());
		mav.addObject("students",students);
		mav.setViewName("result");
		return mav;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView editar(@ModelAttribute Student s){
		ModelAndView mav = new ModelAndView();
		Student user = s;
		try {
			studentDao.save(s, 0);
		}catch(Exception e) {
			log.info("Error: "+e.toString());
		}
		user=studentDao.findOne(s.getcStudent());
		mav.addObject("students",user);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping(value="/ask", params="elim", method = RequestMethod.POST)
	public ModelAndView delete
	(@RequestParam(value="cod") Integer cod){
		
		ModelAndView mav = new ModelAndView();
		Student students = null;
		
		try {
		 students = studentDao.findOne(cod);
		 studentDao.delete(students);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("main");
		return mav;
	}
	
}