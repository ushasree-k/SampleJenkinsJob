package utilities;

public class AutomationException extends RuntimeException {
	public String errorMsg;

	public AutomationException(String paramString) {
		BaseClass b=new BaseClass();
		b.logger.error("Error Message : " + paramString);
	//	System.err.println("Error Message : " + paramString);
		this.errorMsg = paramString;
	}
}
