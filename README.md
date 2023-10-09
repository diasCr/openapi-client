# openapi-client

<form method="post" action="/usertasks/100/completions">
    <input type="text" value="${inputData.oldName}" readonly/>
    <input type="text" name="${outputData.acceptedNewName.name}" value="${inputData.newName}"/>
	
	<input type="radio" name="${outputData.evidenceAccepted.name}" value="true"/>
	<input type="radio" name="${outputData.evidenceAccepted.name}" value="false"/>
	
	<input type="text" name="${outputData.comment.name}"/>
	
    <input type="submit" />
</form>

<form method="post" action="/usertasks/100/completions">
    <input type="text" value="${inputData.oldAddressLine1}" readonly/>
    <input type="text" name="${outputData.acceptedAddressLine.name}" value="${inputData.newAddressLine1}"/>
	
	<input type="radio" name="${outputData.acceptedAddress.name}" value="true"/>
	<input type="radio" name="${outputData.acceptedAddress.name}" value="false"/>
	
    <input type="submit" />
</form>

POST /usertasks/100/completions
acceptedNewName=Muster&evidenceAccepted=true&comment=

POST /usertasks/100/completions
acceptedAddressLine=Musterstrasse1&acceptedAddress=true