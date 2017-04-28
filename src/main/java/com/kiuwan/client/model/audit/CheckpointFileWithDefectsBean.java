package com.kiuwan.client.model.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kiuwan.client.model.HrefBean;
import com.kiuwan.client.utils.ClassToStringConverter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckpointFileWithDefectsBean {

	private String file;
	private Integer defectsCount;
	private HrefBean defects;
	
	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the defectsCount
	 */
	public Integer getDefectsCount() {
		return defectsCount;
	}

	/**
	 * @param defectsCount the defectsCount to set
	 */
	public void setDefectsCount(Integer defectsCount) {
		this.defectsCount = defectsCount;
	}

	/**
	 * @return the defects
	 */
	public HrefBean getDefects() {
		return defects;
	}

	/**
	 * @param defects the defects to set
	 */
	public void setDefects(HrefBean defects) {
		this.defects = defects;
	}

	@Override
	public String toString() {
		return  ClassToStringConverter.toString("Checkpoint file with defects", this);
	}
	
}