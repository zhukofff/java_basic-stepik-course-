package com.company;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private final Logger logger;
    public Spy (Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage)
            return mail;

        MailMessage mailMessage = (MailMessage) mail;
        String[] logParams = new String[]{mail.getFrom(), mail.getTo(), mailMessage.getMessage()};

        if (!isTargetMail(mail)) {
            logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", logParams);
        } else {
            logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", logParams);
        }
        return mail;

    }

    private boolean isTargetMail(Sendable mail){
        return Main.AUSTIN_POWERS.equals(mail.getFrom()) || Main.AUSTIN_POWERS.equals(mail.getTo());
    }
}
