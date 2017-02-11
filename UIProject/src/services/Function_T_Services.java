package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constants.Constants;
import web.CreateScreenCode;
import web.CreateText;

public class Function_T_Services {
	
public CreateScreenCode addCreatedInfo( CreateScreenCode obj){
		
	CreateScreenCode cCode= (CreateScreenCode) obj;
		Date cd = cCode.getCreatedDate(), ud = cCode.getUpdatedDate();

		if(null != cCode.getCreatedDate()){
			cd =cCode.getCreatedDate();
		}
		else{
			cd = new Date();
		}
		ud = new Date();
		
		cCode.setCreatedDate(cd);
		cCode.setUpdatedDate(ud);

		// take login info and add it to createdBy and updatedBy columns
		cCode.setCreatedBy(Constants.CREATED_BY);
		cCode.setUpdatedBy(Constants.UPDATED_BY);
		cCode.setIsActive(Constants.ISACTIVE);

		return cCode;
		
	}
public CreateScreenCode addToObject(List<CreateScreenCode> list) {
	
	// int id=list.get(0).getId();
	String screenCode=list.get(0).getScreenCode();
	String screenName=list.get(0).getScreenName();
	String description=list.get(0).getDescription();
	String screenType=list.get(0).getScreenType();
	boolean cTypeSelect = list.get(0).iscTypeSelect();
	boolean cTypeInsert = list.get(0).iscTypeInsert();
	boolean cTypeUpdate = list.get(0).iscTypeUpdate();
	boolean cTypeDelete = list.get(0).iscTypeDelete();
	Date createdDate = list.get(0).getCreatedDate();
	String createdBy = list.get(0).getCreatedBy();
	Date updatedDate = list.get(0).getUpdatedDate();
	String updatedBy = list.get(0).getUpdatedBy();
	String isActive = list.get(0).getIsActive();
	
	CreateScreenCode ctr = new CreateScreenCode();
	
	//ctr .setId(id);
	ctr .setScreenCode(screenCode);
	ctr.setScreenName(screenName);
	ctr.setScreenType(screenType);
	ctr.setDescription(description);
	ctr.setcTypeSelect(cTypeSelect);
	ctr.setcTypeInsert(cTypeInsert);
	ctr.setcTypeUpdate(cTypeUpdate);
	ctr.setcTypeDelete(cTypeDelete);
	ctr.setCreatedBy(createdBy);
	ctr.setCreatedDate(createdDate);
	ctr.setUpdatedBy(updatedBy);
	ctr.setUpdatedDate(updatedDate);
	ctr.setIsActive(isActive);
	
	return ctr;
}
public List<String> getScreenTypeList() {
	
	List<String> list=new ArrayList<String>();
	
	list.add(Constants.SCREEN_TYPE_BACKEND);
	list.add(Constants.SCREEN_TYPE_FRONTEND);
	list.add(Constants.SCREEN_TYPE_POPUP);
	
	return list;
	
}

}
