package com.billy.bob.client.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserAlreadyExistsException extends Exception implements IsSerializable {
	  private String symbol;

	  public UserAlreadyExistsException() {
	  }

	  public UserAlreadyExistsException(String symbol) {
	    this.symbol = symbol;
	  }

	  public String getSymbol() {
	    return this.symbol;
	  }

}
