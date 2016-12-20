package com.kiuwan.client.model.violatedrule;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.model.HrefBean;
import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileWithDefectsBean {

	private String file;
	private Long defectsCount;
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
	public Long getDefectsCount() {
		return defectsCount;
	}
	
	/**
	 * @param defectsCount the defectsCount to set
	 */
	public void setDefectsCount(Long defectsCount) {
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
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ClassToStringConverter.toString("File with Defects", this);
	}
	
}