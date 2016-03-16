package org.prk.controller;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.prk.dao.FilterService;
import org.prk.domain.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilterController {

	@Autowired
	private FilterService filterService;
	
	@RequestMapping("/saveFilter")
	@ResponseBody
	public String welcome(SearchForm filterValue) {
		//populate your user filter object with below values
		
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(SearchForm.class);
		
		for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
			// filed name 
		    String propertyName = propertyDesc.getName();
		    //  user selected value for that filed
		    Object value = propertyDesc.getReadMethod().invoke(filterValue);
		    // id for that filed from db
		    System.out.println(	filterService.getMasterTableMap().get(propertyName));
		}

		filterService.getMasterTableMap().get(filterValue.getContent());
		System.out.println(filterValue);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fitlerName";
	}
}
