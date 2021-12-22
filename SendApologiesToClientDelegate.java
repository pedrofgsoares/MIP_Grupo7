package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.MailService;
import com.mycompany.myapp.service.dto.SupportIssueDTO;
import com.mycompany.myapp.service.dto.SupportIssueProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Locale;

@Component
public class SendApologiesToClientDelegate implements JavaDelegate {

	@Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
    	SupportIssueProcessDTO supporIssueProcess = (SupportIssueProcessDTO) delegateExecution.getVariable("processInstance");
    	SupportIssueDTO supportIssue = supporIssueProcess.getSupportIssue();
        String to = supportIssue.getClientContact();
        String subject = "[GetAGuide] Apologies for the bad experience " + supportIssue.getClientId();
        Context context = new Context(Locale.getDefault());
        context.setVariable("supportIssue", supportIssue);
        String content = templateEngine.process("supportIssueProcess/supportIssueProcessApologiesEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}
