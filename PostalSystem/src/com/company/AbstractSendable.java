package com.company;

import javax.swing.text.AbstractDocument;

public abstract class AbstractSendable implements Sendable {

    protected final String from;
    protected final String to;

    public AbstractSendable (String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        // something create that describe getFrom()
        // for Example: Syktyvkar.
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        AbstractSendable that = (AbstractSendable) o;
        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;
        return true;
    }


}
