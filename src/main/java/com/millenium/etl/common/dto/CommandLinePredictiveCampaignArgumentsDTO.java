package com.millenium.etl.common.dto;

public class CommandLinePredictiveCampaignArgumentsDTO extends CommandLineArgumentsDTO{
	
	private String targetTable;
	private long listId;
	
	public long getListId() {
		return listId;
	}
	public void setListId(long listId) {
		this.listId = listId;
	}
	public String getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}
}
