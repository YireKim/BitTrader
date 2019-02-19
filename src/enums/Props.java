package enums;


public enum Props {
	ORA_DRIVER("oracle.jdbc.OracleDriver"), 
	ORA_URL("jdbc:oracle:thin:@localhost:59162:xe"), 
	ORA_USER("eli"),
	ORA_PASS("2213"),
	IMAGE("/Users/yireeli/eclipse/java/BitTrader/WebContent/resources/img/");
	
	private String value;
	
	public String getValue() {
		return this.value;
	}
	private Props (String value) {
		this.value = value;
	}
	
	
	
	
		
}

