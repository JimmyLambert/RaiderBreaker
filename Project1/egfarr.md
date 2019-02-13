The issue that I chose to work on was #7 Creating and Removing a New Task Type (https://github.com/gzdwsu/RaiderPlanner/issues/7). I focused on adding a warning message for users who try to remove a task type. I looked into this issue by scanning the TaskController.java document to find locations where a removeTaskType method was created and where it was called. Scanning the document, I skipped over the method a couple of times as the comment above the removeTaskType contained a typo that labeled the method as adding a new task type.

commit dad69a32f4f28387a73489d1d034869b0af5f84f (HEAD -> RemoveTaskTypeWarning,
origin/RemoveTaskTypeWarning)
Author: egfarr <farr.16@wright.edu>
Date:   Mon Feb 11 14:13:47 2019 -0500
    Add Warning Message when User Removes Task Type
    A warning message was added when the remove task type button is
    selected. The Alert and AlertType were not needed for warning message so
    they were removed.
commit 96b8aa3106b6b708c728f4d94de67cb6ed72dc72
Author: egfarr <farr.16@wright.edu>
Date:   Mon Feb 11 11:44:53 2019 -0500
    Import JavaFX Alert and AlertType Class
    JavaFX Alert and AlertType classes were imported to the
    TaskController.java file so that a warning can be added for removing a
    NewTaskType.
commit 26d22521312c24571bb5a6dea9f7c8c5ae297a96
Author: egfarr <farr.16@wright.edu>
Date:   Fri Feb 8 16:33:11 2019 -0500
    Add Comments to removeTaskType
    Comments were added to the removeTaskType method to state what should be done to
    add a warning to the removeTaskType method. A comment above the method
    was also edited to fix a typo.


Pull request: Remove task type warning
