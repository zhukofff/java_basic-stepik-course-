package com.company;

public class Inspector implements MailService {

    private static final String WEAPONS = "weapons";
    private static final String BANNED_SUBSTANCE = "banned substance";

    private static final String[] ILLEGAL_CONTENT = new String[]{WEAPONS, BANNED_SUBSTANCE};

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            String content = mailPackage.getContent().getContent();

            for (String illegalString : ILLEGAL_CONTENT) {
                if (content.contains(illegalString)) {
                    throw new IllegalPackageException();
                } else if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
        }
        return mail;
    }

}
