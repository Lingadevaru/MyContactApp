# MyContactApp 
                                                                                                     - by Lingadevaru C

__Note***:__ After installing the application in mobile device/Emulator, go to settings->permission->contacts. 
In Contacts give permission to MyContactApp to access it. This is really important don't forget.

__Introduction:__<br/>
MyContactApp access the contact details from the contact application and displays the contact details in it. In first UI page the list of contacts are displayed and in next page the contact details of each individual is displayed on whomever the user clicks in the first UI page.

__List of files:__<br/>
Application contanis mainly four files: two activity files and two xml layout files.<br/>
Two Activity files are: Main Activity and Second Activity<br/>
Two XML Layout files are: activity main and activity second

__Main Activty:__ This is the java file of first android Activity page. It mainly contains the functionality to display the list of contacts.<br/>
__Second Activity:__ This is also a java file of Second android Activity page. It contains the functionality to display the Contact details of particular person about whom the user as clicked on the first activity page.<br/>

__Deployment:__<br/>
Mainly following components of android are used in implementing the application:<br/>
* Content Resolver
* Contacts Contract
* Cursor
* Intent
* ArrayAdapter

__Testing:__<br/>
It works fine for most of the cases.<br/>
When new contact is added in the contact app, it gets updated in our app also automatically with full contact details.<br/>
In Contact details, Name, Phone number, ID and Image ID is displayed in the second UI page of the application.



