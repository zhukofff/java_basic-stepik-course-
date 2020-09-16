package com.company;

public class Thief implements MailService {

    private final int minValue;
    private int stolenValue = 0;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {

            Package content = ((MailPackage) mail).getContent();
            if (content.getPrice() < minValue)
                return mail;

            Package thiefPackage = new Package(String.format("stones instead of %s", content.getContent()), 0);
            MailPackage stolenMailPackage = new MailPackage(mail.getFrom(), mail.getTo(), thiefPackage);
            stolenValue += content.getPrice();
            return stolenMailPackage;
        }
        return mail;
    }

    public int getStolenValue() {
        return stolenValue;
    }
}
