#include <dummy.h>

#define BLYNK_PRINT Serial
 
#include <ESP8266WiFi.h>
 
#include <BlynkSimpleEsp8266.h>
 
 
char auth[] = " --sOxRibvkawIMZyONG7bHyR8T3_81fE"; // blynk token
 
 
char ssid[] = "vivo 1901";   //ssid//password
 
 
char pass[] = "sneha123";    //password
 
int moisture;
 
int data;
 
void setup() { 
 
  Serial.begin(9600);
 
  pinMode(A0,INPUT);
 
  Blynk.begin(auth, ssid, pass);
 
  
 
}
 
 
void loop()
 
 
{
 
  Blynk.run();
 
moisture = analogRead(0);       //Read Analog value of first sensor
 
  delay(100);   
 
  data = map(moisture,500,1023,100,0);                
 
  Serial.print("moisture = ");     //to the serial monitor
 
  Serial.print(data );
 
  Blynk.virtualWrite(V5, data );  // to Blynk server
 
 
    }
