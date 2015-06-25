package foodselector.domain.enums;

public enum PotatoType {

	POTATO("potato.normal"), FRENCH_FRIES("potato.frites"), CROQUETTE("potato.kroket"), ROSTI("potato.rosti"); 
	
	private String code;
	
	private PotatoType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static PotatoType findByCode(String code) {
		for(PotatoType potatoType : values()) {
			if(potatoType.getCode().equals(code)) {
				return potatoType;
			}
		}
		return null;
	}
}
