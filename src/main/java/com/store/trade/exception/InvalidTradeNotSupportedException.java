package com.store.trade.exception;

public class InvalidTradeNotSupportedException extends RuntimeException {

    private final String id;

    public InvalidTradeNotSupportedException(final String id) {
        super("Trade Captured is Invalid :   Please check if \"Lower version of Trade\" \n"
        		+ " 		\"Trade has less Maturity date then Today's Date\"\n"
        		+ "		\"Trade has crossed its maturity date\"" + id);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
