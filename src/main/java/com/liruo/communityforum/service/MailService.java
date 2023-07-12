package com.liruo.communityforum.service;

import javax.mail.MessagingException;

public interface MailService {
    void sendText(String to, String subject, String content);
    void sendSimpleMail(String to, String subject, String content);
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * @param email
     * @param len 最多7位，8位太长，EmailCode.html会溢出一个到下面
     * @return captcha 数字和字母
     */
    String generateCode(String email, Integer len);
}
