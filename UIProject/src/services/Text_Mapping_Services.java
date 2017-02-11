package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.Constants;
import dao.Function_T_Intract;
import dao.Text_T_Intract;
import web.CreateScreenCode;
import web.CreateText;
import web.ScreenTextMapping;

public class Text_Mapping_Services {
	
	public ScreenTextMapping addToObject(List<ScreenTextMapping> list) {
		
		//int id=list.get(0).getId();
		String screenCode=list.get(0).getScreenCode();
		String screenName=list.get(0).getScreenName();
		String screenTextCode = list.get(0).getScreenTextCode();
		String textCode=list.get(0).getTextCode();
		String textType=list.get(0).getTextType();
		
		ScreenTextMapping ctr = new ScreenTextMapping();
		
		//ctr .setId(id);
		ctr .setScreenCode(screenCode);
		ctr.setScreenName(screenName);
		ctr.setScreenTextCode(screenTextCode);
		ctr.setTextCode(textCode);
		ctr.setTextType(textType);
		
		return ctr;
	}
public List<CreateScreenCode> getScreenCodesNames(Function_T_Intract intract){
	
	List<CreateScreenCode> list=intract.loadFunctionTActiveRecords();
		return list;
}
public List<CreateText> getTextCode(Text_T_Intract intract){
	
	List<CreateText> list=intract.loadTextTRecords();
		return list;
}
public List<String> getTextType(){
	
	List<String> list=new ArrayList<String>();
	list.add(Constants.TEXT_TYPE_FIELD);
	list.add(Constants.TEXT_TYPE_HEADER);
	list.add(Constants.TEXT_TYPE_BUTTON);
	list.add(Constants.TEXT_TYPE_PAGE);
	return list;
	
}
}
