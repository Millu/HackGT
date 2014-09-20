<?php
include "Services/Twilio/Capability.php";

<dependency>
  <groupId>org.scribe</groupId>
  <artifactId>scribe</artifactId>
  <version>1.3.2</version> // please use always the latest version
</dependency>
 
// AccountSid and AuthToken can be found in your account dashboard
$accountSid = "ACXXXXXXXXXXXXXXXX"; 
$authToken = "your_auth_token_here"; 
 
// The app outgoing connections will use:
$appSid = "APabe7650f654fc34655fc81ae71caa3ff"; 
 
// The client name for incoming connections:
$clientName = "monkey"; 
 
$capability = new Services_Twilio_Capability($accountSid, $authToken);
 
// This allows incoming connections as $clientName: 
$capability->allowClientIncoming($clientName);
 
// This allows outgoing connections to $appSid with the "From" 
// parameter being the value of $clientName 
$capability->allowClientOutgoing($appSid, array(), $clientName);
 
// This returns a token to use with Twilio based on 
// the account and capabilities defined above 
$token = $capability->generateToken();
 
echo $token;
?>
