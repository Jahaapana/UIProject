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

import services.Function_T_Services;
import constants.CreateHeaderInfo;
import dao.Function_T_Intract;
import web.CreateScreenCode;
import web.CreateText;

@Controller 
public class CreateScreenCodeController {
	
	@ModelAttribute("screenTypeList")
    public List<String> populateScreenTypes(){
		Function_T_Services tServices=new Function_T_Services();
		List<String> screenTypeList = tServices.getScreenTypeList();
        return screenTypeList;
    }

	@RequestMapping(value="/loadCreateScreenCode", method = RequestMethod.GET)
	public ModelAndView loadCreateScreenCode(){
		//Function_T_Services tServices=new Function_T_Services();
		
		ModelAndView mnv = new ModelAndView("CreateScreenCode","command", new CreateScreenCode());
		//List<String> screenTypeList = tServices.getScreenTypeList();
		//mnv.addObject("screenTypeList", screenTypeList);
		return mnv;
	}
	
	//Request to save from Create Text Screen
		@RequestMapping(value ="/fromCreateScreenCode", params = "Save", method = RequestMethod.POST)  
	    public ModelAndView saveCreateScreenCode(@ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) {  

			//Text_T_Intract intract=Text_T_Intract.getModel();
			//Text_T_Services tServices=new Text_T_Services();
			Function_T_Intract intract=Function_T_Intract.getModel();
			Function_T_Services tServices=new Function_T_Services();
			
			CreateHeaderInfo header=new CreateHeaderInfo();
	        
			CreateScreenCode cCode=tServices.addCreatedInfo(createScreenCode);
	        System.out.println("Save started");
	        intract.saveOrUpdateCode(cCode);
	        System.out.println("save finished");
	        System.out.println("load started");
	        List<CreateScreenCode> list=intract.loadFunctionTRecords();
	        System.out.println("load Ended");
	        ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", new CreateScreenCode());
	        
	        mnv.addObject("headerinfo",header.getCodeHeaderInfo());
	        mnv.addObject("lists", list);
	        
	        intract.sf.close();
	        return mnv;
	    }
		
		@RequestMapping(value ="/fromCreateScreenCode", params = "Search", method = RequestMethod.POST)  
	    public ModelAndView searchCreateScreenCode(@ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) {
			
			CreateScreenCode ctr = null;
			String msg="";
			
			//Text_T_Services tServices=new Text_T_Services();
			Function_T_Services tServices=new Function_T_Services();
			CreateHeaderInfo header=new CreateHeaderInfo();
			
			//Text_T_Intract intract=Text_T_Intract.getModel();
			Function_T_Intract intract=Function_T_Intract.getModel();
			
			
			List<CreateScreenCode> list=intract.searchFunctionTRecords(createScreenCode.getScreenCode());
			
			if(list.size()>0 && list.size() == 1){
				ctr = tServices.addToObject(list);
			}
			else{
				ctr = new CreateScreenCode();
				msg="your search returns no result";
			}
			
			List<CreateScreenCode> list2=intract.loadFunctionTRecords();
			
			ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", ctr);
			
			model.addAttribute("msg", msg);
			mnv.addObject("headerinfo",header.getCodeHeaderInfo());
			mnv.addObject("lists", list2);
			
			intract.sf.close();
			
			return mnv;
		}
		@RequestMapping(value ="/fromCreateScreenCode", params = "Delete", method = RequestMethod.POST)  
	    public ModelAndView DeleteCreateScreenCode(@ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) {
			
			CreateScreenCode ctr = null;
			String msg="";
			
			Function_T_Services tServices=new Function_T_Services();
			CreateHeaderInfo header=new CreateHeaderInfo();
			
			Function_T_Intract intract=Function_T_Intract.getModel();
			
			
			List<CreateScreenCode> list=intract.searchFunctionTRecords(createScreenCode.getScreenCode());
			
			if(list.size() > 0 && list.size() == 1){
				ctr = tServices.addToObject(list);
				intract.deleteFunctionTRecord(ctr);
			}
			else{
				msg="No Record to delete";
			}
			ctr = new CreateScreenCode();
			List<CreateScreenCode> list2=intract.loadFunctionTRecords();
			
			ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", ctr);
			
			model.addAttribute("msg", msg);
			mnv.addObject("headerinfo",header.getCodeHeaderInfo());
			mnv.addObject("lists", list2);
			
			intract.sf.close();
			
			return mnv;
		}
		@RequestMapping(value ="/updateCreateScreenCode/{cCode}", method = RequestMethod.GET)  
	    public ModelAndView loadUpdateCreateScreenCode(@PathVariable("cCode")String cCode,@ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) { 
			
			//Text_T_Intract intract=Text_T_Intract.getModel();
			Function_T_Intract intract=Function_T_Intract.getModel();
			//Text_T_Services tServices=new Text_T_Services();
			Function_T_Services tServices=new Function_T_Services();
			
			List<CreateScreenCode> list1=intract.searchFunctionTRecords(cCode);
			
			CreateScreenCode ctr=tServices.addToObject(list1);
			
			List<CreateScreenCode> list2=intract.loadFunctionTRecords();
			
			CreateHeaderInfo header=new CreateHeaderInfo();
			
			ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", ctr);
			mnv.addObject("headerinfo",header.getCodeHeaderInfo());
			mnv.addObject("lists", list2);
			
			intract.sf.close();
			
			return mnv;
		}
		@RequestMapping(value ="/updateCreateScreenCode/{cCode}",params = "Search", method = RequestMethod.POST)  
	    public ModelAndView searchUpdateCreateScreenCode(@PathVariable("cCode")String cCode, @ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) { 
			
			CreateScreenCode ctr;
			String msg = null;
			CreateHeaderInfo header=new CreateHeaderInfo();
			//Text_T_Services tServices=new Text_T_Services();
			Function_T_Services tServices=new Function_T_Services();
			
			//Text_T_Intract intract=Text_T_Intract.getModel();
			Function_T_Intract intract=Function_T_Intract.getModel();
			List<CreateScreenCode> list=intract.searchFunctionTRecords(createScreenCode.getScreenCode());
			
			if(list.size()>0 && list.size() == 1){
				ctr = tServices.addToObject(list);
			}
			else{
				ctr = new CreateScreenCode();
				msg="your search returns no result";
			}
			
			List<CreateScreenCode> list2=intract.loadFunctionTRecords();
			
			model.addAttribute("msg", msg);
			ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", ctr);
			mnv.addObject("headerinfo",header.getCodeHeaderInfo());
			mnv.addObject("lists", list2);
			
			intract.sf.close();
			
			return mnv;
		}
		@RequestMapping(value ="/updateCreateScreenCode/{cCode}",params = "Save", method = RequestMethod.POST)  
	    public ModelAndView saveUpdateCreateScreenCode(@PathVariable("cCode")String cLabel, @ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) { 
			
			CreateHeaderInfo header=new CreateHeaderInfo();
			//Text_T_Services tServices=new Text_T_Services();
			Function_T_Services tServices=new Function_T_Services();
			//Text_T_Intract intract=Text_T_Intract.getModel();
			Function_T_Intract intract=Function_T_Intract.getModel();
			
			CreateScreenCode cText=tServices.addCreatedInfo(createScreenCode);
	        
	        intract.saveOrUpdateCode(cText);
	       
	        List<CreateScreenCode> list=intract.loadFunctionTRecords();
	       
	        
	        ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", new CreateScreenCode());
	        
	        mnv.addObject("headerinfo",header.getCodeHeaderInfo());
	        mnv.addObject("lists", list);
	        
	        intract.sf.close();
	        
	        return mnv;
	        
		}
		@RequestMapping(value ="/updateCreateScreenCode/{cCode}",params = "Delete", method = RequestMethod.POST)  
	    public ModelAndView deleteUpdateCreateScreenCode(@PathVariable("cCode")String cLabel, @ModelAttribute("SpringWeb")CreateScreenCode createScreenCode, ModelMap model) { 
			
			CreateHeaderInfo header=new CreateHeaderInfo();
			//Text_T_Services tServices=new Text_T_Services();
			Function_T_Services tServices=new Function_T_Services();
			//Text_T_Intract intract=Text_T_Intract.getModel();
			Function_T_Intract intract=Function_T_Intract.getModel();
			
			CreateScreenCode cText=tServices.addCreatedInfo(createScreenCode);
	        
			intract.deleteFunctionTRecord(cText);
			//intract.saveOrUpdateCode(cText);
	       
	        List<CreateScreenCode> list=intract.loadFunctionTRecords();
	       
	        
	        ModelAndView mnv = new ModelAndView("CreateScreenCode", "command", new CreateScreenCode());
	        
	        mnv.addObject("headerinfo",header.getCodeHeaderInfo());
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
