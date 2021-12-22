package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.dto.SupportIssueProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckIfShortInfoDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        SupportIssueProcessDTO supportIssueProcess = (SupportIssueProcessDTO) delegateExecution.getVariable("processInstance");
        Boolean boolean_isInfoEnough = false;
        if(supportIssueProcess.getSupportIssue().getIssueAditionalInfo().contains("Yes")) {
        	boolean_isInfoEnough = true;
        }
        delegateExecution.setVariable("boolean_isInfoEnough",boolean_isInfoEnough);
    }
}