We considered 3 branching methods within the Git/GitHub environments we are working in.

1. https://blogs.technet.microsoft.com/devops/2016/06/21/a-git-workflow-for-continuous-delivery/.This popular branching model, known as git 
flow, uses the master branch as a stable, production-ready implementation of the project. A development branch partitions ongoing
development from the master branch, and accommodates individual feature branches. The master branch produces a release branch, where code 
can be deployed and delivered to customers. Both master and release branches can have a branch for hotfixes. This model is prone to 
integration difficulties, because feature branches are worked on for long periods of time, without merging back into the development branch.
This often leads to time-consuming integration testing in the development branch. In addition, each release from the master branch can 
actually negate prior testing in development, because of updated libraries or packages. For these reasons, this branching model has fallen 
out of favor for more robust models.

2. https://www.nomachetejuggling.com/2017/04/09/a-different-branching-strategy/.  This article details how the author believes that the 
standard “GitFlow” strategy is inadequate and is confusing. A different branching strategy is proposed with three different branches. One 
suggestion in the article is to use Feature Toggles that allows either new code or old code to be run. These Feature Toggles mean that 
there would be less conflicts when branching which happens a lot with a long-running branch. As for the three branches, they are master, 
candidate, and release. Frequent commits are made to master, and candidate and release are branched from master. Relevant features are 
toggled on when a new release is ready and is pushed to the release branch. This strategy is also very similar to “GitFlow”, but is 
simplified to three branches.

3. Shah, V.  “How to adopt a Git branching Strategy” (October, 2018). Adopt-a-git-branching-strategy-ac729ff4f838. This strategy encourages 
a “Keep It Simple” approach, although, our experience, version control has a good amount of upfront investment of time to get everyone on 
the same page and running properly.  This concept encourages bug fixes and feature additions take place in branches off of your master.  
It states that even small changes should take place in their own feature branch.  It also describes some naming conventions like, 
feature/feature-name, feature/feature-area/feature name, bugfix/description, hotfix/description, with the keywords used, feature, bugfix, 
and hotfix.  Further, it calls for the careful reviewing of merges, and that merges should only happen via a pull request.  The branches 
should be reviewed by multiple people.  A “release” branch should be created for multiple people to view before it is merged to master.  
Ultimately, the author encourages good communication so that mistakes are avoided if they can be.
