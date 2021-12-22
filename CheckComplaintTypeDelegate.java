package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.dto.SupportIssueProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckComplaintTypeDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        SupportIssueProcessDTO supportIssueProcess = (SupportIssueProcessDTO) delegateExecution.getVariable("processInstance");
        Boolean boolean_isGuideComplaint = false;
        if(supportIssueProcess.getSupportIssue().getIssueInfo().contains("guide ") ||
        		supportIssueProcess.getSupportIssue().getIssueInfo().contains("Guide ")) {
        	boolean_isGuideComplaint = true;
        }
        delegateExecution.setVariable("boolean_isGuideComplaint",boolean_isGuideComplaint);
    }
}