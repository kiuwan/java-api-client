package com.kiuwan.client;

public class KiuwanClientException extends Exception {

	public KiuwanClientException(Throwable e) {
        super(e);
    }

    public KiuwanClientException(String mess) {
        super(mess);
    }

    public static KiuwanClientException createResponseStatusException(int status) {
        return new KiuwanClientException("Response status != 200; received: " + status);
    }

    private static final long serialVersionUID = 1L;

}
