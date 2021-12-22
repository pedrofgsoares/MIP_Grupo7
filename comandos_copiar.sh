##############################
##############################
#### Copying needed files ####
##############################
##############################

a='/home/jhipster/app/'
cd $a/myapp

# DOMAIN Entity
cp -vi $a/bck_MIP/SupportIssue.json $a/myapp/.jhipster/
jhipster entity SupportIssue --regenerate

# Process-Bind Entity
cp -vi $a/bck_MIP/SupportIssueProcess.json $a/myapp/.jhipster/
jhipster entity SupportIssueProcess --regenerate

# Start-Form Entity
cp -vi $a/bck_MIP/SupportIssueProcessStartForm.json $a/myapp/.jhipster/
jhipster entity SupportIssueProcessStartForm --regenerate

# Task Entity
cp -vi $a/bck_MIP/TaskFillComplaint.json $a/myapp/.jhipster/
jhipster entity TaskFillComplaint --regenerate

# Create Dir and Copy Delegate File
mkdir $a/myapp/src/main/java/com/mycompany/myapp/delegate/
cp -vi $a/bck_MIP/CheckComplaintTypeDelegate.java $a/myapp/src/main/java/com/mycompany/myapp/delegate/

# Task Entity
cp -vi $a/bck_MIP/TaskCheckGuideComplaint.json $a/myapp/.jhipster/
jhipster entity TaskCheckGuideComplaint --regenerate

# Create Dir and Copy Delegate File and HTML
cp -vi $a/bck_MIP/SendApologiesToClientDelegate.java $a/myapp/src/main/java/com/mycompany/myapp/delegate/ 

mkdir $a/myapp/src/main/resources/templates/supportIssueProcess/
cp -vi $a/bck_MIP/supportIssueProcessApologiesEmail.html $a/myapp/src/main/resources/templates/supportIssueProcess/

# Task Entity
cp -vi $a/bck_MIP/TaskVerifyComplaintInfo.json $a/myapp/.jhipster/
jhipster entity TaskVerifyComplaintInfo --regenerate

# Create Dir and Copy Delegate File
cp -vi $a/bck_MIP/CheckIfShortInfoDelegate.java $a/myapp/src/main/java/com/mycompany/myapp/delegate/

# Copy Delegate File and HTML
cp -vi $a/bck_MIP/AskForMoreInfoDelegate.java $a/myapp/src/main/java/com/mycompany/myapp/delegate/ 
cp -vi $a/bck_MIP/AskForMoreInfoEmail.html $a/myapp/src/main/resources/templates/supportIssueProcess/

# Task Entity
cp -vi $a/bck_MIP/TaskSimulateReceiveEmail.json $a/myapp/.jhipster/
jhipster entity TaskSimulateReceiveEmail --regenerate

# Task Entity
cp -vi $a/bck_MIP/TaskFixProblem.json $a/myapp/.jhipster/
jhipster entity TaskFixProblem --regenerate

