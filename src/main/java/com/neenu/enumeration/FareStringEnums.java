package com.neenu.enumeration;

/**
 * @author Neenu
 * 
 * Enumeration to calculate fare string
 *
 */
public enum FareStringEnums {
	ONE_ZONE("1N",1),TWO_ZONE("2N",2),THREE_ZONE("3N",3);
	private String code;
	private Integer noOfZones;
	
	 private FareStringEnums(String code,Integer noOfZones) {
	        this.code = code;
	        this.noOfZones = noOfZones;
	    }

	 public static FareStringEnums getFareStringByZoneNumber(Integer noOfZones){
		for(FareStringEnums enums: FareStringEnums.values()){
			if(enums.getNoOfZones().equals(noOfZones)){
				return enums;
			}
		}
		return null;
	 }
	    public String getCode() {
	        return code;
	    }

		public Integer getNoOfZones() {
			return noOfZones;
		}
	    
}
