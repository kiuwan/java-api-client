package com.kiuwan.client.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class File {

	protected String name;
	protected Long metricsCount;
	protected List<MetricValue> metrics = new ArrayList<MetricValue>();
	protected Long defectsCount;
	protected List<Defect> defects = new ArrayList<Defect>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("metrics_count")
	public Long getMetricsCount() {
		return metricsCount;
	}
	public void setMetricsCount(Long metricsCount) {
		this.metricsCount = metricsCount;
	}
	public List<MetricValue> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<MetricValue> metrics) {
		this.metrics = metrics;
	}
	@JsonProperty("defects_count")
	public Long getDefectsCount() {
		return defectsCount;
	}
	public void setDefectsCount(Long defectsCount) {
		this.defectsCount = defectsCount;
	}
	public List<Defect> getDefects() {
		return defects;
	}
	public void setDefects(List<Defect> defects) {
		this.defects = defects;
	}
	@Override
	public String toString() {
		return "File [name=" + name + ", metricsCount=" + metricsCount
				+ ", metrics=" + metrics + ", defectsCount=" + defectsCount
				+ ", defects=" + defects + "]";
	}
	
}
