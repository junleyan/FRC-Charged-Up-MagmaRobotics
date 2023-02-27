#include <EEPROM.h>
#include <Wire.h>
#include <LedControl.h>

int DIN = 11; 
int CS =  13;
int CLK = 12; 

#define CLK 2
#define DT 3
#define SW 4

int eepromModeAddress = 0;
bool selected = true;
int currentMode = 0; 
int currentStateCLK;
int lastStateCLK;
unsigned long lastButtonPress = 0;

LedControl lc = LedControl(11, 12, 13, 1);
byte letterL[8] = {
  B10000000,
  B10000000,
  B10000000,
  B10000000,
  B10000000,
  B10000000,
  B10000000,
  B11111111
};

byte letterSmallerL[8] = {
  B00000000,
  B01000000,
  B01000000,
  B01000000,
  B01000000,
  B01000000,
  B01111110,
  B00000000
};

byte letterR[8] = {
  B11111111,
  B10000001,
  B10000001,
  B11111111,
  B10010000,
  B10001000,
  B10000100,
  B10000010
};

byte letterSmallerR[8] = {
  B00000000,
  B01111100,
  B01000010,
  B01111100,
  B01100000,
  B01011000,
  B01000100,
  B00000000
};

byte letterM[8] = {
  B10000001,
  B11000011,
  B10100101,
  B10011001,
  B10000001,
  B10000001,
  B10000001,
  B10000001
};

byte letterSmallerM[8] = {
  B00000000,
  B01000010,
  B01100110,
  B01011010,
  B01000010,
  B01000010,
  B01000010,
  B00000000
};

void setup() {
        
	// Set encoder pins as inputs
	pinMode(CLK,INPUT);
	pinMode(DT,INPUT);
	pinMode(SW, INPUT_PULLUP);

	// Setup Serial Monitor
	Serial.begin(9600);
  currentMode = EEPROM.read(eepromModeAddress);

	// Read the initial state of CLK
	lastStateCLK = digitalRead(CLK);

  lc.shutdown(0,false);
  lc.setIntensity(0,8);
  lc.clearDisplay(0);
}

void loop() {

	// Read the current state of CLK
	currentStateCLK = digitalRead(CLK);

	// If last and current state of CLK are different, then pulse occurred
	// React to only 1 state change to avoid double count
	if (currentStateCLK != lastStateCLK  && currentStateCLK == 1){
    lc.clearDisplay(0);

		// If the DT state is different than the CLK state then
		// the encoder is rotating CCW so decrement
    if (selected) {
      if (digitalRead(DT) != currentStateCLK) {
        if (currentMode == 1 || currentMode == 2) {
          currentMode ++;
        }
        else {
          currentMode = 1;
        }
      } else {
        // Encoder is rotating CW so increment
        if (currentMode == 1 || currentMode == 2) {
          currentMode ++;
        }
        else {
          currentMode = 1;
        }
      }
    }
		
	}

  Serial.println(currentMode);

	// Remember last CLK state
	lastStateCLK = currentStateCLK;
  EEPROM.write(eepromModeAddress, currentMode);

  // Read the button state
	int btnState = digitalRead(SW);

	//If we detect LOW signal, button is pressed
	if (btnState == LOW) {
		//if 50ms have passed since last LOW pulse, it means that the
		//button has been pressed, released and pressed again
		if (millis() - lastButtonPress > 50) {
			selected = !selected;
		}

		// Remember last button press event
		lastButtonPress = millis();
	}

  if (selected) {
    if (currentMode == 1) {
      for (int row = 0; row < 8; row++) {
        lc.setRow(0, row, letterSmallerL[row]);
      }
    }
    if (currentMode == 2) {
      for (int row = 0; row < 8; row++) {
        lc.setRow(0, row, letterSmallerM[row]);
      }
    }
    if (currentMode == 3) {
      for (int row = 0; row < 8; row++) {
        lc.setRow(0, row, letterSmallerR[row]);
      }
    }
  } else {
    if (currentMode == 1) {
      for (int row = 0; row < 8; row++) {
        lc.setRow(0, row, letterL[row]);
      }
    }
    if (currentMode == 2) {
      for (int row = 0; row < 8; row++) {
        lc.setRow(0, row, letterM[row]);
      }
    }
    if (currentMode == 3) {
      for (int row = 0; row < 8; row++) {
        lc.setRow(0, row, letterR[row]);
      }
    }
  }
  

	// Put in a slight delay to help debounce the reading
	delay(1);
}