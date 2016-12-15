package com.kiuwan.client.model.audit;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kiuwan.client.utils.ClassToStringConverter;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckpointResultBean {

	private String name;
	private String checkpoint;
    private String result;
    private String description;
    private Double weight;
    private Boolean mandatory;
    private String type;
    private Double score;
    private List<ViolatedRuleBean> violatedRules;
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the checkpoint
	 */
	public String getCheckpoint() {
		return checkpoint;
	}
	/**
	 * @param checkpoint the checkpoint to set
	 */
	public void setCheckpoint(String checkpoint) {
		this.checkpoint = checkpoint;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * @return the mandatory
	 */
	public Boolean getMandatory() {
		return mandatory;
	}
	/**
	 * @param mandatory the mandatory to set
	 */
	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	/**
	 * @return the violatedRules
	 */
	public List<ViolatedRuleBean> getViolatedRules() {
		return violatedRules;
	}
	/**
	 * @param violatedRules the violatedRules to set
	 */
	public void setViolatedRules(List<ViolatedRuleBean> violatedRules) {
		this.violatedRules = violatedRules;
	}
	
	@Override
	public String toString() {
		return  ClassToStringConverter.toString("Checkpoint result", this);
	}
	
}