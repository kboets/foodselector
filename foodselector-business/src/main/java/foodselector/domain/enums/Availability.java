package foodselector.domain.enums;

import java.util.List;

public enum Availability {

	WINTER("vegetables.availability.winter"), SUMMER("vegetables.availability.summer"), ALWAYS("vegetables.availability.always");
	
	private String code;
	
	private Availability(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}	
	
	public String valueOf(Availability availability) {
		return availability.code;
	}
	
}
