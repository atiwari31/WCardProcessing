package com.card.processing.utility;

public enum FeatureEnum {
	SCANNING,
    OCR,
    VOICE,
    ALL;
	  int  featureValue(String value) {
	        switch (this) {
	        
	            case SCANNING:
	                return 1;
	            case OCR:
	                return 2;
	            case VOICE:
	                return 3;
	            case ALL:
	                return 4;
	            default:
	                throw new AssertionError("Unknown Value " + this);
	        }
	    }
}
