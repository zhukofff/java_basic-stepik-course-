package com.company;

import java.util.logging.Logger;

public class Main {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String BANNED_SUBSTANCE = "banned substance";
    public static final String WEAPONS = "weapons";

    public static void main(String[] args) {

        MailMessage austinMsg = new MailMessage(AUSTIN_POWERS, AUSTIN_POWERS, "Hello, dear friend! _____");
        MailMessage kirillMsg = new MailMessage("Kirill", "Daniil", "Hello! How are you?");
        final Logger logger = Logger.getLogger(Main.class.getName());

        Spy phillip = new Spy(logger);
        // phillip.processMail(austinMsg);
        // phillip.processMail(kirillMsg);

        Package packageWithBannedSubstance = new Package(BANNED_SUBSTANCE + WEAPONS + "stones", 120);
        Package packageWithStones = new Package("stones stones stones", 120);
        Package packageWithLove = new Package("love", 1000);
        MailPackage testPackage = new MailPackage(AUSTIN_POWERS, "Daniil", packageWithStones);
        MailPackage testPackage1 = new MailPackage("Kirill", "Daniil", packageWithBannedSubstance);
        MailPackage testPackage2 = new MailPackage("Daniil", "Alyona", packageWithLove);


        Inspector gadget = new Inspector();
        //gadget.processMail(testPackage);
        //gadget.processMail(testPackage1);

        MailService[] postalOfRussia = {phillip,
                                        new Thief(0),
                                        gadget};

        UntrustworthyMailWorker fedor = new UntrustworthyMailWorker(postalOfRussia);

        fedor.processMail(testPackage2);
    }


}
