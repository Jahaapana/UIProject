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
public List<TextTypeOptions> getTextType(){
	
	List<TextTypeOptions> list=new ArrayList<TextTypeOptions>();
	
	TextTypeOptions tTypeOpt1=new TextTypeOptions();
	tTypeOpt1.setName(Constants.TEXT_TYPE_FIELD);
	tTypeOpt1.setValue("FL");
	list.add(tTypeOpt1);
	TextTypeOptions tTypeOpt2=new TextTypeOptions();
	tTypeOpt2.setName(Constants.TEXT_TYPE_HEADER);
	tTypeOpt2.setValue("HL");
	list.add(tTypeOpt2);
	TextTypeOptions tTypeOpt3=new TextTypeOptions();
	tTypeOpt3.setName(Constants.TEXT_TYPE_BUTTON);
	tTypeOpt3.setValue("BL");
	list.add(tTypeOpt3);
	TextTypeOptions tTypeOpt4=new TextTypeOptions();
	tTypeOpt4.setName(Constants.TEXT_TYPE_PAGE);
	tTypeOpt4.setValue("PL");
	list.add(tTypeOpt4);
	
	return list;
	
}
public class TextTypeOptions{
	
	public String name;
	public String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
public ScreenTextMapping modifyScreenCode(ScreenTextMapping mScreenTextMapping) {
	
	String screenCodeName = mScreenTextMapping.getScreenCode();
	String code = screenCodeName;
	if(screenCodeName.indexOf("..") !=-1){
	 code = screenCodeName.substring(0, screenCodeName.indexOf(".."));
	}
	
	mScreenTextMapping.setScreenCode(code);
	
	return mScreenTextMapping;
}
public ScreenTextMapping addCreatedInfo( ScreenTextMapping obj){
	
	ScreenTextMapping cText= (ScreenTextMapping)obj;
	Date cd = cText.getCreatedDate(), ud = cText.getUpdatedDate();

	if(null != cText.getCreatedDate()){
		cd =cText.getCreatedDate();
	}
	else{
		cd = new Date();
	}
	ud = new Date();
	
	cText.setCreatedDate(cd);
	cText.setUpdatedDate(ud);

	// take login info and add it to createdBy and updatedBy columns
	cText.setCreatedBy("jahangir");
	cText.setUpdatedBy("jahaa");

	return cText;
	
}

}
