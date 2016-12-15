package com.kiuwan.client.model.audit;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.model.HrefBean;
import com.kiuwan.client.utils.ClassToStringConverter;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
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