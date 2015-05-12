package foodselector.domain.enums;

public enum FishType {

	OILY("fish_type_fat"), HALF_OILY("fish_type_half"), WHITE("fish_type_white"), SEAFOOD("fish_type_seafood");
	
	private String code;
	
	private FishType(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}
