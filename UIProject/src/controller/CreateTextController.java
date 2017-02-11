package controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.Text_T_Services;
import web.CreateText;
import constants.CreateHeaderInfo;
import dao.Text_T_Intract;

@Controller 
public class CreateTextController {
	
	//Request to load the search screen
	@RequestMapping(value = "/loadCreateText", method = RequestMethod.GET)  
    public ModelAndView loadCreateText() {  
        return new ModelAndView("CreateText", "command", new CreateText());  
    }  
	
	//Request to save from Create Text Screen
	@RequestMapping(value ="/FromCreateText", params = "Save", method = RequestMethod.POST)  
    public ModelAndView saveCreateText(@ModelAttribute("SpringWeb")CreateText createText, ModelMap model) {  

		Text_T_Intract intract=Text_T_Intract.getModel();
		Text_T_Services tServices=new Text_T_Services();
		CreateHeaderInfo header=new CreateHeaderInfo();
        
		CreateText cText=tServices.addCreatedInfo(createText);
        
        intract.saveOrUpdateTxt(cText);
        
        List<CreateText> list=intract.loadTextTRecords();
        
        ModelAndView mnv = new ModelAndView("CreateText", "command", new CreateText());
        
        mnv.addObject("headerinfo",header.getTextHeaderInfo());
        mnv.addObject("lists", list);
        
        intract.sf.close();
        return mnv;
    }  
	@RequestMapping(value ="/FromCreateText", params = "Search", method = RequestMethod.POST)  
    public ModelAndView searchCreateText(@ModelAttribute("SpringWeb")CreateText createText, ModelMap model) {
		
		CreateText ctr = null;
		String msg="";
		
		Text_T_Services tServices=new Text_T_Services();
		CreateHeaderInfo header=new CreateHeaderInfo();
		
		Text_T_Intract intract=Text_T_Intract.getModel();
		
		
		List<CreateText> list=intract.searchTextTRecords(createText.getLabel());
		
		if(list.size()>0 && list.size() == 1){
			ctr = tServices.addToObject(list);
		}
		else{
			ctr = new CreateText();
			msg="your search returns no result";
		}
		
		List<CreateText> list2=intract.loadTextTRecords();
		
		ModelAndView mnv = new ModelAndView("CreateText", "command", ctr);
		
		model.addAttribute("msg", msg);
		mnv.addObject("headerinfo",header.getTextHeaderInfo());
		mnv.addObject("lists", list2);
		
		intract.sf.close();
		
		return mnv;
	}
	
	@RequestMapping(value ="/updateCreateText/{cLabel}", method = RequestMethod.GET)  
    public ModelAndView loadUpdateCreateText(@PathVariable("cLabel")String cLabel,@ModelAttribute("SpringWeb")CreateText createText, ModelMap model) { 
		
		Text_T_Intract intract=Text_T_Intract.getModel();
		Text_T_Services tServices=new Text_T_Services();
		
		List<CreateText> list1=intract.searchTextTRecords(cLabel);
		
		CreateText ctr=tServices.addToObject(list1);
		
		List<CreateText> list2=intract.loadTextTRecords();
		
		CreateHeaderInfo header=new CreateHeaderInfo();
		
		ModelAndView mnv = new ModelAndView("CreateText", "command", ctr);
		mnv.addObject("headerinfo",header.getTextHeaderInfo());
		mnv.addObject("lists", list2);
		
		intract.sf.close();
		
		return mnv;
	}
	@RequestMapping(value ="/updateCreateText/{cLabel}",params = "Search", method = RequestMethod.POST)  
    public ModelAndView searchUpdateCreateText(@PathVariable("cLabel")String cLabel, @ModelAttribute("SpringWeb")CreateText createText, ModelMap model) { 
		
		CreateText ctr;
		String msg = null;
		
		CreateHeaderInfo header=new CreateHeaderInfo();
		Text_T_Services tServices=new Text_T_Services();
		
		Text_T_Intract intract=Text_T_Intract.getModel();
		List<CreateText> list=intract.searchTextTRecords(createText.getLabel());
		
		if(list.size()>0 && list.size() == 1){
			ctr = tServices.addToObject(list);
		}
		else{
			ctr = new CreateText();
			msg="your search returns no result";
		}
		
		List<CreateText> list2=intract.loadTextTRecords();
		
		model.addAttribute("msg", msg);
		ModelAndView mnv = new ModelAndView("CreateText", "command", ctr);
		mnv.addObject("headerinfo",header.getTextHeaderInfo());
		mnv.addObject("lists", list2);
		
		intract.sf.close();
		
		return mnv;
	}
	@RequestMapping(value ="/updateCreateText/{cLabel}",params = "Save", method = RequestMethod.POST)  
    public ModelAndView saveUpdateCreateText(@PathVariable("cLabel")String cLabel, @ModelAttribute("SpringWeb")CreateText createText, ModelMap model) { 
		
		CreateHeaderInfo header=new CreateHeaderInfo();
		Text_T_Services tServices=new Text_T_Services();
		Text_T_Intract intract=Text_T_Intract.getModel();
		
		CreateText cText=tServices.addCreatedInfo(createText);
        
        intract.saveOrUpdateTxt(cText);
       
        List<CreateText> list=intract.loadTextTRecords();
       
        
        ModelAndView mnv = new ModelAndView("CreateText", "command", new CreateText());
        
        mnv.addObject("headerinfo",header.getTextHeaderInfo());
        mnv.addObject("lists", list);
        
        intract.sf.close();
        
        return mnv;
        
	}
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		//binder.addValidators(userValidator, emailValidator);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "createdDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "updatedDate", new CustomDateEditor(dateFormat, true));
	}

}
