package com.app.habilitation.controller.dtos;

public class EmploiMenuDto {

	private Integer EmploiId;
	
	private Integer MenuId;

	public Integer getEmploiId() {
		return EmploiId;
	}

	public void setEmploiId(Integer emploiId) {
		EmploiId = emploiId;
	}

	public Integer getMenuId() {
		return MenuId;
	}

	public void setMenuId(Integer menuId) {
		MenuId = menuId;
	}

	public EmploiMenuDto(Integer emploiId, Integer menuId) {
		EmploiId = emploiId;
		MenuId = menuId;
	}

	public EmploiMenuDto() {
	}

	@Override
	public String toString() {
		return "EmploiMenuDto [EmploiId=" + EmploiId + ", MenuId=" + MenuId + "]";
	}
	
	
}
