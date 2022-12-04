package io.github.zodh.email;

import io.github.zodh.email.message.validator.MailMessageValidator;
import io.github.zodh.evaluation.ObjectEvaluator;
import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

  private JavaMailSender javaMailSender;

  private List<MailMessageValidator> mailMessageValidators;

  public EmailServiceImpl(JavaMailSender javaMailSender,
      List<MailMessageValidator> mailMessageValidators) {
    this.javaMailSender = javaMailSender;
    this.mailMessageValidators = mailMessageValidators;
  }

  @Override
  public void send(SimpleMailMessage simpleMailMessage) {
    checkSimpleMailEssentialFields(simpleMailMessage);
    javaMailSender.send(simpleMailMessage);
  }

  @Override
  public void sendSimpleMail(String from, String to, String subject, String text) {
    var simpleMessage = new SimpleMail().buildDefaultMessage(
        from, to, subject, text
    );
    this.send(simpleMessage);
  }

  private void checkSimpleMailEssentialFields(SimpleMailMessage simpleMailMessage) {
    if (Boolean.TRUE.equals(ObjectEvaluator.isNull(simpleMailMessage))) {
      throw new NullPointerException("The object 'Simple Mail Message' can not to be null!");
    }
    this.mailMessageValidators.forEach(
        mailMessageValidator -> mailMessageValidator.validate(simpleMailMessage));
  }

}
