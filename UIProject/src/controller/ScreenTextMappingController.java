package controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.Function_T_Services;
import services.Text_Mapping_Services;
import services.Text_Mapping_Services.TextTypeOptions;
import services.Text_T_Services;
import constants.CreateHeaderInfo;
import dao.Function_T_Intract;
import dao.Text_Mapping_Intract;
import dao.Text_T_Intract;
import web.CreateScreenCode;
import web.CreateText;
import web.ScreenTextMapping;

@Controller
public class ScreenTextMappingController {
	
	//@ModelAttribute("screenCodeOptions")
	@ModelAttribute
    public void populateScreenDropDowns( Model model){
		Function_T_Intract intract1=Function_T_Intract.getModel();
		Text_T_Intract intract2=Text_T_Intract.getModel();
		Text_Mapping_Services tServices=new Text_Mapping_Services();
		//Map<Integer, String> screenCodeMap = tServices.getScreenCodesNames(intract);
		List<CreateScreenCode> screenCodeList = tServices.getScreenCodesNames(intract1);
		List<CreateText> textCodeList = tServices.getTextCode(intract2);
		List<TextTypeOptions> textType=tServices.getTextType();
		model.addAttribute("screenCodeOptions", screenCodeList);
		model.addAttribute("textCodeOptions", textCodeList);
		model.addAttribute("textTypeOptions", textType);
      //  return screenCodeList;
    }
	
	@RequestMapping(value="/loadScreenTextMapping", method = RequestMethod.GET)
	public ModelAndView loadCreateScreenCode(){
		return new ModelAndView("ScreenTextMapping","command", new ScreenTextMapping());
	}
	//Request to save from Create Text Screen
			@RequestMapping(value ="/fromScreenTextMapping", params = "Save", method = RequestMethod.POST)  
		    public ModelAndView saveCreateScreenCode(@ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) {  

				//Text_T_Intract intract=Text_T_Intract.getModel();
				//Text_T_Services tServices=new Text_T_Services();
				//Function_T_Intract intract=Function_T_Intract.getModel();
				//Function_T_Services tServices=new Function_T_Services();
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				ScreenTextMapping mScreenTextMapping = screenTextMapping;
				
				
				CreateHeaderInfo header=new CreateHeaderInfo();
		        
				//ScreenTextMapping cCode=tServices.addCreatedInfo(createScreenCode);
				mScreenTextMapping = tServices.modifyScreenCode(screenTextMapping);
				mScreenTextMapping = tServices.addCreatedInfo(mScreenTextMapping);
				
		        intract.saveOrUpdateScreen(mScreenTextMapping);
		        List<ScreenTextMapping> list=intract.loadScreenTextRecords();
		        ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", new ScreenTextMapping());
		        
		        mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
		        mnv.addObject("lists", list);
		        
		        intract.sf.close();
		        return mnv;
		    }
			
			@RequestMapping(value ="/fromScreenTextMapping", params = "Search", method = RequestMethod.POST)  
		    public ModelAndView searchCreateScreenCode(@ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) {
				
				ScreenTextMapping ctr = null;
				String msg="";
				
				//Text_T_Services tServices=new Text_T_Services();
				/*Function_T_Services tServices=new Function_T_Services();*/
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				CreateHeaderInfo header=new CreateHeaderInfo();
				
				//Text_T_Intract intract=Text_T_Intract.getModel();
				/*Function_T_Intract intract=Function_T_Intract.getModel();*/
				
				
				List<ScreenTextMapping> list=intract.searchScreenTextRecords(screenTextMapping.getScreenCode());
				
				if(list.size()>0 && list.size() == 1){
					ctr = tServices.addToObject(list);
				}
				else{
					ctr = new ScreenTextMapping();
					msg="your search returns no result";
				}
				
				List<ScreenTextMapping> list2=intract.loadScreenTextRecords();
				
				ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", ctr);
				
				model.addAttribute("msg", msg);
				mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
				mnv.addObject("lists", list2);
				
				intract.sf.close();
				
				return mnv;
			}
			@RequestMapping(value ="/fromScreenTextMapping", params = "Delete", method = RequestMethod.POST)  
		    public ModelAndView DeleteCreateScreenCode(@ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) {
				
				ScreenTextMapping ctr = null;
				String msg="";
				
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				CreateHeaderInfo header=new CreateHeaderInfo();
				
				
				List<ScreenTextMapping> list=intract.searchScreenTextRecords(screenTextMapping.getScreenCode());
				
				if(list.size() > 0 && list.size() == 1){
					ctr = tServices.addToObject(list);
					intract.deleteFunctionTRecord(ctr);
				}
				else{
					msg="No Record to delete";
				}
				ctr = new ScreenTextMapping();
				List<ScreenTextMapping> list2=intract.loadScreenTextRecords();
				
				ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", ctr);
				
				model.addAttribute("msg", msg);
				mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
				mnv.addObject("lists", list2);
				
				intract.sf.close();
				
				return mnv;
			}
			@RequestMapping(value ="/updateScreenTextMapping/{cScreenText}", method = RequestMethod.GET)  
		    public ModelAndView loadUpdateCreateScreenCode(@PathVariable("cScreenText")String cScreenText,@ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) { 
				
				//Text_T_Intract intract=Text_T_Intract.getModel();
				//Function_T_Intract intract=Function_T_Intract.getModel();
				//Text_T_Services tServices=new Text_T_Services();
				//Function_T_Services tServices=new Function_T_Services();
				
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				CreateHeaderInfo header=new CreateHeaderInfo();
				
				List<ScreenTextMapping> list1=intract.searchScreenTextRecords(cScreenText);
				
				ScreenTextMapping ctr=tServices.addToObject(list1);
				
				List<ScreenTextMapping> list2=intract.loadScreenTextRecords();
				
				//CreateHeaderInfo header=new CreateHeaderInfo();
				
				ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", ctr);
				mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
				mnv.addObject("lists", list2);
				
				intract.sf.close();
				
				return mnv;
			}
			@RequestMapping(value ="/updateScreenTextMapping/{cScreenText}",params = "Search", method = RequestMethod.POST)  
		    public ModelAndView searchUpdateCreateScreenCode(@PathVariable("cScreenText")String cScreenText, @ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) { 
				
				ScreenTextMapping ctr;
				String msg = null;
				CreateHeaderInfo header=new CreateHeaderInfo();
				//Text_T_Services tServices=new Text_T_Services();
				//Function_T_Services tServices=new Function_T_Services();
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				//CreateHeaderInfo header=new CreateHeaderInfo();
				//Text_T_Intract intract=Text_T_Intract.getModel();
				//Function_T_Intract intract=Function_T_Intract.getModel();
				List<ScreenTextMapping> list=intract.searchScreenTextRecords(screenTextMapping.getScreenCode());
				
				if(list.size()>0 && list.size() == 1){
					ctr = tServices.addToObject(list);
				}
				else{
					ctr = new ScreenTextMapping();
					msg="your search returns no result";
				}
				
				List<ScreenTextMapping> list2=intract.loadScreenTextRecords();
				
				model.addAttribute("msg", msg);
				ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", ctr);
				mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
				mnv.addObject("lists", list2);
				
				intract.sf.close();
				
				return mnv;
			}
			@RequestMapping(value ="/updateScreenTextMapping/{cScreenText}",params = "Save", method = RequestMethod.POST)  
		    public ModelAndView saveUpdateCreateScreenCode(@PathVariable("cScreenText")String cScreenText, @ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) { 
				
				CreateHeaderInfo header=new CreateHeaderInfo();
				//Text_T_Services tServices=new Text_T_Services();
				//Function_T_Services tServices=new Function_T_Services();
				//Text_T_Intract intract=Text_T_Intract.getModel();
				//Function_T_Intract intract=Function_T_Intract.getModel();
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				
				//ScreenTextMapping cText=tServices.addCreatedInfo(screenTextMapping);
		        
		        intract.saveOrUpdateScreen(screenTextMapping);
		       
		        List<ScreenTextMapping> list=intract.loadScreenTextRecords();
		       
		        
		        ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", new ScreenTextMapping());
		        
		        mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
		        mnv.addObject("lists", list);
		        
		        intract.sf.close();
		        
		        return mnv;
		        
			}
			@RequestMapping(value ="/updateScreenTextMapping/{cScreenText}",params = "Delete", method = RequestMethod.POST)  
		    public ModelAndView deleteUpdateCreateScreenCode(@PathVariable("cScreenText")String cScreenText, @ModelAttribute("SpringWeb")ScreenTextMapping screenTextMapping, ModelMap model) { 
				
				ScreenTextMapping ctr;
				String msg = null;
				CreateHeaderInfo header=new CreateHeaderInfo();
				//Text_T_Services tServices=new Text_T_Services();
				//Function_T_Services tServices=new Function_T_Services();
				Text_Mapping_Intract intract=Text_Mapping_Intract.getModel();
				Text_Mapping_Services tServices=new Text_Mapping_Services();
				//CreateHeaderInfo header=new CreateHeaderInfo();
				//Text_T_Intract intract=Text_T_Intract.getModel();
				//Function_T_Intract intract=Function_T_Intract.getModel();
				List<ScreenTextMapping> list=intract.searchScreenTextRecords(screenTextMapping.getScreenCode());
				
				if(list.size()>0 && list.size() == 1){
					ctr = tServices.addToObject(list);
					intract.deleteFunctionTRecord(ctr);
				}
				else{
					msg="No Record to delete";
				}
				ctr = new ScreenTextMapping();
				List<ScreenTextMapping> list2=intract.loadScreenTextRecords();
				
				model.addAttribute("msg", msg);
				ModelAndView mnv = new ModelAndView("ScreenTextMapping", "command", ctr);
				mnv.addObject("headerinfo",header.getTextMappingHeaderInfo());
				mnv.addObject("lists", list2);
				
				intract.sf.close();
				
				return mnv;
			}
}
