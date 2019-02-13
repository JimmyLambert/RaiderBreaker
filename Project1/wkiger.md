Branch: AddMitLicense  (Dave) William Kiger username wkiger
Link to issue #5: https://github.com/JimmyLambert/RaiderBreaker/issues/5

I addressed issue #5, which was adding an MIT license document (pdf) to the Help tab.  The features that I added to the RaiderPlanner project include:
	1. Inserted a generic MIT license into the Final Documents directory.
	2. Made a dropdown button labeled MIT License (This step and the following are all inside of the MainController.java file.   
	3. Inserted instructions “Follow this to view our MIT license"
	4. Inserted a button named “MIT License” (a TiledPane with a Vbox to stay consistent with the page) with a trigger that launches the pdf in a new window to view. 
 
commit d08e0074da80f925dc1e478fa861f82ae133ae49 (HEAD -> local_develop)
Author: William Kiger <kiger82@gmail.com>
Date:   Wed Feb 6 15:39:28 2019 -0500

    Committing changes to add MIT license to Help tab using a new drop down description and button to display the pdf

    
commit 410eaa9b9ac450ecd1cd66037efea1d196485a91
Author: William Kiger <kiger82@gmail.com>
Date:   Mon Feb 4 20:44:09 2019 -0500

    first commit-added MITLICENSE.pdf under Final Documents.  

The MITLICENSE.pdf can be found in the Final Documents Directory.  I was able to add the drop down and button with the trigger to the pdf inside the MainController.java file.  I maintained the current look of the Help window as it was with the additions I made.  


This was a learning experience for me.  I worked with Jimmy and pushed my branch into the master before doing a pull request.  We were still trying to define how to manage/create different branches for the issues.  If I had to do this again, I would do more than 2 commits on my local git repository for the feature I was working on.   Second, I would wait until we clearly defined which github branch I should be working under.  Lastly, I would create a pull request before merging my branch with the master (working with Jimmy).  Anyway, what I/we did worked and I count this as a learning experience.  I count this a success that I learned what I should have done, and didn’t destroy the project.  
