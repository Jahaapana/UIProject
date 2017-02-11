package services;

import java.util.Date;
import java.util.List;

import web.CreateText;

public class Text_T_Services {
	
	public CreateText addCreatedInfo( CreateText obj){
		
		CreateText cText= (CreateText)obj;
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

	public CreateText addToObject(List<CreateText> list) {
		
		
		String label=list.get(0).getLabel();
		String description=list.get(0).getDescription();
		int id=list.get(0).getId();
		String language=list.get(0).getLanguage();
		Date createdDate=list.get(0).getCreatedDate();
		String createdBy=list.get(0).getCreatedBy();
		Date updatedDate=list.get(0).getUpdatedDate();
		String updatedBy=list.get(0).getUpdatedBy();
		
		CreateText ctr = new CreateText();
		ctr .setId(id);
		ctr.setLabel(label);
		ctr.setDescription(description);
		ctr.setLanguage(language);
		ctr.setCreatedBy(createdBy);
		ctr.setCreatedDate(createdDate);
		ctr.setUpdatedDate(updatedDate);
		ctr.setUpdatedBy(updatedBy);
		
		return ctr;
	}

}
