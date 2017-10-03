package com.neenu.exception;

public class AppException  extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1074429183657040192L;
	private String customMessage;
	 private String errorCode;
	 
	 public AppException(String errorCode, String customMessage, Throwable cause) {
	        super(customMessage, cause);
	        this.errorCode = errorCode;
	        this.customMessage = customMessage;
	    }

	    public AppException(String errorCode, String customMessage) {
	        super(customMessage);
	        this.errorCode = errorCode != null ? errorCode : null;
	        this.customMessage = customMessage;
	    }

	    public AppException() {
	    }

		public String getCustomMessage() {
			return customMessage;
		}

		public void setCustomMessage(String customMessage) {
			this.customMessage = customMessage;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
	    
	    
}
