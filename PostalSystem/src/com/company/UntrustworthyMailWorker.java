package com.company;

public class UntrustworthyMailWorker implements MailService {

    private RealMailService realMailService = new RealMailService();
    private final MailService[] mailService;

    public UntrustworthyMailWorker (MailService[] mailService){
        this.mailService = mailService;
    }

    @Override
    public Sendable processMail(Sendable mail){
        for (MailService mailService : mailService)
            mail = mailService.processMail(mail);
        return realMailService.processMail(mail);
    }

    public RealMailService getRealMailService () {
        return realMailService;
    }
}
