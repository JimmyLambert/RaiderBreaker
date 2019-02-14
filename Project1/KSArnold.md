SalutationError (Katrina) KSArnold S Arnold

I chose Issue #16 (https://github.com/gzdwsu/RaiderPlanner/issues/16) which pertained to the program throwing an error when a user tries to submit the initial login form without having chosen a salutation.

Commit 107d58d212059e8c994fab15abc733e132485a30
Author: KSArnold <kdglidergirl8@gmail.com>
Date: Mon Feb 11 12:37:32
    Added a check for null value in the salutation box.
    Login no longer throws exception when no salutation is chosen.

Commit 22d7072c6665c835f702545486acd6240b6f441d
Author: KSArnold <kdglidergirl8@gmail.com>
Date: Mon Feb 11 16:36:47
    Added functionality that allows users to opt out of choosing a salutation.
    When a salutation is not chosen and the login button is submitted, an
    alert pops up and asks the user if they really do not want to add a salutation.
    If the user hits the "ok" button, the form is submitted and the account
    is created. If the user hits the cancel button, the alert goes away and the
    form stays open.

Most of the issues I had with git were on the local side. For the first commit, I had initially made the changes and tried to commit them the day before I actually managed to do it. I think the first error came down to the fact that I had initialized a new local branch before trying to clone my branch from github. I then accidentally deleted the entire file on my computer and had to re-download it. From there I was able to set up the clone of the branch from github correctly, so I started to make changes. However, when it came time to push the changes back to github I ran into issues where I was getting an error message that said that I was not authorized to make changes. After some research, I learned that the credentials for an old github account were still attached to git, so I had to go in and delete them so that I could use my current github account. After that I was able to push all of the rest of my commits and successfully create a pull request.
