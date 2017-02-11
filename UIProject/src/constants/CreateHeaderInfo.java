package constants;

import java.util.ArrayList;
import java.util.List;

public class CreateHeaderInfo {
	
	List<String> textHeaderInfo;
	List<String> codeHeaderInfo;
	List<String> textMappingHeaderInfo;
	
	public CreateHeaderInfo(){
		//Here we can initialize header data from DB
		List<String> initiateTextHeaderInfo = new ArrayList<String>();
		initiateTextHeaderInfo.add(Constants.CREATE_TEXT_ID);
		initiateTextHeaderInfo.add(Constants.CREATE_TEXT_LABEL);
		initiateTextHeaderInfo.add(Constants.CREATE_TEXT_DESCRIPTION);
		initiateTextHeaderInfo.add(Constants.CREATE_TEXT_FLANGUAGE);
		this.textHeaderInfo=initiateTextHeaderInfo;
		
		List<String> initiateCodeHeaderInfo = new ArrayList<String>();
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_CODE);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_NAME);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_TYPE);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_DESCRIPTION);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_SELECT);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_INSERT);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_UPDATE);
		initiateCodeHeaderInfo.add(Constants.CREATE_SCREEN_DELETE);
		this.codeHeaderInfo=initiateCodeHeaderInfo;
		
		List<String> initiateTextMappingHeaderInfo = new ArrayList<String>();
		initiateTextMappingHeaderInfo.add(Constants.TEXT_MAPPING_SCREENCODE);
		initiateTextMappingHeaderInfo.add(Constants.TEXT_MAPPING_SCREENNAME);
		initiateTextMappingHeaderInfo.add(Constants.TEXT_MAPPING_SCREENTEXTCODE);
		initiateTextMappingHeaderInfo.add(Constants.TEXT_MAPPING_TEXTCODE);
		initiateTextMappingHeaderInfo.add(Constants.TEXT_MAPPING_TEXTTYPE);
		this.textMappingHeaderInfo = initiateTextMappingHeaderInfo;
		
	}

	public List<String> getTextHeaderInfo() {
		return textHeaderInfo;
	}

	public void setTextHeaderInfo(List<String> textHeaderInfo) {
		this.textHeaderInfo = textHeaderInfo;
	}

	public List<String> getCodeHeaderInfo() {
		return codeHeaderInfo;
	}

	public void setCodeHeaderInfo(List<String> codeHeaderInfo) {
		this.codeHeaderInfo = codeHeaderInfo;
	}

	public List<String> getTextMappingHeaderInfo() {
		return textMappingHeaderInfo;
	}

	public void setTextMappingHeaderInfo(List<String> textMappingHeaderInfo) {
		this.textMappingHeaderInfo = textMappingHeaderInfo;
	}
}
