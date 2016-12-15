package com.kiuwan.client.model.delivery;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryDefectsBean {

	private Integer newDefects;
	private Integer removedDefects;
	private Integer defects;
	
	/**
	 * @return the newDefects
	 */
	public Integer getNewDefects() {
		return newDefects;
	}
	
	/**
	 * @param newDefects the newDefects to set
	 */
	public void setNewDefects(Integer newDefects) {
		this.newDefects = newDefects;
	}
	
	/**
	 * @return the removedDefects
	 */
	public Integer getRemovedDefects() {
		return removedDefects;
	}
	
	/**
	 * @param removedDefects the removedDefects to set
	 */
	public void setRemovedDefects(Integer removedDefects) {
		this.removedDefects = removedDefects;
	}
	
	/**
	 * @return the defects
	 */
	public Integer getDefects() {
		return defects;
	}
	
	/**
	 * @param defects the defects to set
	 */
	public void setDefects(Integer defects) {
		this.defects = defects;
	}
	
	@Override
	public String toString() {
		return  ClassToStringConverter.toString("Delivery defects", this);
	}
	
}

