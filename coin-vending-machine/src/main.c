// Mehmet Oguz Aktas (150201170) & Ebubekir Sit (150201245)

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include "time.h"
#include "stdbool.h"
#include "inc/hw_ints.h"
#include "inc/hw_types.h"
#include "inc/hw_memmap.h"
#include "driverlib/sysctl.h"
#include "driverlib/gpio.h"
#include "inc/tm4c123gh6pm.h"

#define LCDPORT GPIO_PORTB_BASE
#define LCDPORTENABLE SYSCTL_PERIPH_GPIOB
#define RS GPIO_PIN_0
#define E GPIO_PIN_1
#define D4 GPIO_PIN_4
#define D5 GPIO_PIN_5
#define D6 GPIO_PIN_6
#define D7 GPIO_PIN_7
#define ON LOW
#define OFF HIGH
#define second1 1600000
#define second2 3200000
#define second3 8000000

/**
 * Pin connections:
 * RS -> PB0 OUTPUT
 * EN -> PB1 OUTPUT
 * D4 -> PB4 OUTPUT
 * D5 -> PB5 OUTPUT
 * D6 -> PB6 OUTPUT
 * D7 -> PB7 OUTPUT
 * Button1 -> PA2 OUTPUT // Onlar basamagi
 * Button2 -> PA3 OUTPUT // Birler basamagi
 * Button3 -> PA4 OUTPUT // Nokta
 * Button4 -> PA5 OUTPUT // Ondabirler basamagi
 * Button5 -> PA6 OUTPUT // Yuzdebirler basamagi
 * Button6 -> PA7 OUTPUT // Resetle butonu
 * Button7 -> PD7 OUTPUT // Enter
 *
 */

void printLCD(char*); // Print string to LCD
void commandLCD(unsigned char); // Send command to LCD
void clearLCD(void); // Clean screen
void setCursorLCD(char, char); // Set LCD cursor
void initLCD(void); // Initial settings for LCD
void putchLCD(unsigned char); // Print single character
void init_port_B(); // Activate B port
void init_port_A(); // Activate A port
void init_port_C(); // Activate C port
void Delay_sn(int);
void kalanYaz(float);

int main(void) {
	volatile unsigned long delay;
                                                                                                                                                                    init_port_B();
	init_port_A();
	init_port_C();
	initLCD();
	SysCtlClockSet(SYSCTL_SYSDIV_2_5 | SYSCTL_USE_PLL | SYSCTL_OSC_MAIN | SYSCTL_XTAL_16MHZ);

    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;
    int counter5 = 0;

    while (1) {
        int button1 = GPIO_PORTA_DATA_R & 0b100;
        int button2 = GPIO_PORTA_DATA_R & 0b1000;
        int button3 = GPIO_PORTA_DATA_R & 0b10000;
        int button4 = GPIO_PORTA_DATA_R & 0b100000;
        int button5 = GPIO_PORTA_DATA_R & 0b1000000;
        int button6 = GPIO_PORTA_DATA_R & 0b10000000;
        int button7 = GPIO_PORTC_DATA_R & 0b10000;

        if (button1 == 0) { // Onlar basamagi
            counter1++;
            Delay_sn(second1);
            if (counter1 == 1) {
                setCursorLCD(0, 11);
                printLCD("1");
            } else if (counter1 == 2) {
                setCursorLCD(0, 11);
                printLCD("2");
            } else if (counter1 == 3) {
                setCursorLCD(0, 11);
                printLCD("3");
            } else if (counter1 == 4) {
                setCursorLCD(0, 11);
                printLCD("4");
            } else if (counter1 == 5) {
                setCursorLCD(0, 11);
                printLCD("5");
            } else if (counter1 == 6) {
                setCursorLCD(0, 11);
                printLCD("6");
            } else if (counter1 == 7) {
                setCursorLCD(0, 11);
                printLCD("7");
            } else if (counter1 == 8) {
                setCursorLCD(0, 11);
                printLCD("8");
            } else if (counter1 == 9) {
                setCursorLCD(0, 11);
                printLCD("9");
            } else if (counter1 == 10) {
                setCursorLCD(0, 11);
                printLCD("0");
                counter1 = 0;
            }
        }

        if (button2 == 0) { // Birler basamagi
            counter2++;
            Delay_sn(second1);
            if (counter2 == 1) {
                setCursorLCD(0, 12);
                printLCD("1");
            } else if (counter2 == 2) {
                setCursorLCD(0, 12);
                printLCD("2");
            } else if (counter2 == 3) {
                setCursorLCD(0, 12);
                printLCD("3");
            } else if (counter2 == 4) {
                setCursorLCD(0, 12);
                printLCD("4");
            } else if (counter2 == 5) {
                setCursorLCD(0, 12);
                printLCD("5");
            } else if (counter2 == 6) {
                setCursorLCD(0, 12);
                printLCD("6");
            } else if (counter2 == 7) {
                setCursorLCD(0, 12);
                printLCD("7");
            } else if (counter2 == 8) {
                setCursorLCD(0, 12);
                printLCD("8");
            } else if (counter2 == 9) {
                setCursorLCD(0, 12);
                printLCD("9");
            } else if (counter2 == 10) {
                setCursorLCD(0, 12);
                printLCD("0");
                counter2 = 0;
            }
        }

        if (button3 == 0) { // Nokta
            counter3++;
            Delay_sn(second1);
            setCursorLCD(0, 13);
            printLCD(".");
        }

        if (button4 == 0) { // Ondabirler basamagi
            counter4++;
            Delay_sn(second1);
            if (counter4 == 1) {
                setCursorLCD(0, 14);
                printLCD("1");
            } else if (counter4 == 2) {
                setCursorLCD(0, 14);
                printLCD("2");
            } else if (counter4 == 3) {
                setCursorLCD(0, 14);
                printLCD("3");
            } else if (counter4 == 4) {
                setCursorLCD(0, 14);
                printLCD("4");
            } else if (counter4 == 5) {
                setCursorLCD(0, 14);
                printLCD("5");
            } else if (counter4 == 6) {
                setCursorLCD(0, 14);
                printLCD("6");
            } else if (counter4 == 7) {
                setCursorLCD(0, 14);
                printLCD("7");
            } else if (counter4 == 8) {
                setCursorLCD(0, 14);
                printLCD("8");
            } else if (counter4 == 9) {
                setCursorLCD(0, 14);
                printLCD("9");
            } else if (counter4 == 10) {
                setCursorLCD(0, 14);
                printLCD("0");
                counter4 = 0;
            }
        }

        if (button5 == 0) { // Yuzdebirler basamagi
            counter5++;
            Delay_sn(second1);
            if (counter5 == 1) {
                setCursorLCD(0, 15);
                printLCD("1");
            } else if (counter5 == 2) {
                setCursorLCD(0, 15);
                printLCD("2");
            } else if (counter5 == 3) {
                setCursorLCD(0, 15);
                printLCD("3");
            } else if (counter5 == 4) {
                setCursorLCD(0, 15);
                printLCD("4");
            } else if (counter5 == 5) {
                setCursorLCD(0, 15);
                printLCD("5");
            } else if (counter5 == 6) {
                setCursorLCD(0, 15);
                printLCD("6");
            } else if (counter5 == 7) {
                setCursorLCD(0, 15);
                printLCD("7");
            } else if (counter5 == 8) {
                setCursorLCD(0, 15);
                printLCD("8");
            } else if (counter5 == 9) {
                setCursorLCD(0, 15);
                printLCD("9");
            } else if (counter5 == 10) {
                setCursorLCD(0, 15);
                printLCD("0");
                counter5 = 0;
            }
        }

        if (button6 == 0) { // Resetleme islemi
            Delay_sn(second1);
            clearLCD();
            counter1 = 0;
            counter2 = 0;
            counter3 = 0;
            counter4 = 0;
            counter5 = 0;
        }

        if (button7 == 0) { // Enter
            Delay_sn(second1);
            float para = (counter1 * 10 + counter2 + counter4 * 0.1 + counter5 * 0.01);
            int yirmilik = (int)(para / 20);
            setCursorLCD(1, 0);
            if (yirmilik == 4) {
            	printLCD("4");
            } else if (yirmilik == 3) {
            	printLCD("3");
            } else if (yirmilik == 2) {
            	printLCD("2");
            } else if (yirmilik == 1) {
            	printLCD("1");
            } else if (yirmilik == 0) {
            	printLCD("0");
            }
            printLCD(" - yirmilik ");
            float kalan = para - (yirmilik * 20);
            kalanYaz(kalan);
            Delay_sn(second3);
            int onluk = (int)((para - (yirmilik * 20)) / 10);
            setCursorLCD(1, 0);
            if (onluk == 0) {
                printLCD("0");
            } else if (onluk == 1) {
                printLCD("1");
            }
            printLCD(" - onluk    ");
            kalan = para - (yirmilik * 20) - (onluk * 10);
            kalanYaz(kalan);
            Delay_sn(second3);
            int beslik = (int)((para - (yirmilik * 20) - (onluk * 10)) / 5);
            setCursorLCD(1, 0);
            if (beslik == 0) {
                printLCD("0");
            } else if (beslik == 1) {
                printLCD("1");
            }
            printLCD(" - beslik   ");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5);
            kalanYaz(kalan);
            Delay_sn(second3);
            int birlik = (int)((para - (yirmilik * 20) - (onluk * 10) - (beslik * 5)) / 1);
            setCursorLCD(1, 0);
            if (birlik == 0) {
                printLCD("0");
            } else if (birlik == 1) {
                printLCD("1");
            } else if (birlik == 2) {
                printLCD("2");
            } else if (birlik == 3) {
                printLCD("3");
            } else if (birlik == 4) {
                printLCD("4");
            }
            printLCD(" - birlik   ");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1);
            kalanYaz(kalan);
            Delay_sn(second3);
            int yarimlik = (int)((para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1)) / 0.5);
            setCursorLCD(1, 0);
            if (yarimlik == 0) {
                printLCD("0");
            } else if (yarimlik == 1) {
                printLCD("1");
            }
            printLCD(" - yarimlik ");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5);
            kalanYaz(kalan);
            Delay_sn(second3);
            int ceyreklik = (int)((para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5)) / 0.25);
            setCursorLCD(1, 0);
            if (ceyreklik == 0) {
                printLCD("0");
            } else if (ceyreklik == 1) {
                printLCD("1");
            }
            printLCD(" - ceyreklik");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25);
            kalanYaz(kalan);
            Delay_sn(second3);
            int metelik = (int)((para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25)) / 0.1);
            setCursorLCD(1, 0);
            if (metelik == 0) {
                printLCD("0");
            } else if (metelik == 1) {
                printLCD("1");
            } else if (metelik == 2) {
                printLCD("2");
            }
            printLCD(" - metelik  ");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25) - (metelik * 0.1);
            kalanYaz(kalan);
            Delay_sn(second3);
            int delik = (int)((para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25) - (metelik * 0.1)) / 0.05);
            setCursorLCD(1, 0);
            if (delik == 0) {
                printLCD("0");
            } else if (delik == 1) {
                printLCD("1");
            }
            printLCD(" - delik    ");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25) - (metelik * 0.1) - (delik * 0.05);
            kalanYaz(kalan);
            Delay_sn(second3);
            int kurusluk = (int)((para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25) - (metelik * 0.1) - (delik * 0.05)) / 0.01);
            setCursorLCD(1, 0);
            if (kurusluk == 0) {
                printLCD("0");
            } else if (kurusluk == 1) {
                printLCD("1");
            } else if (kurusluk == 2) {
                printLCD("2");
            } else if (kurusluk == 3) {
                printLCD("3");
            } else if (kurusluk == 4) {
                printLCD("4");
            }
            printLCD(" - kurusluk ");
            kalan = para - (yirmilik * 20) - (onluk * 10) - (beslik * 5) - (birlik * 1) - (yarimlik * 0.5) - (ceyreklik * 0.25) - (metelik * 0.1) - (delik * 0.05) - (kurusluk * 0.01);
            kalanYaz(kalan);
            Delay_sn(second3);
            setCursorLCD(1, 0);

            /*
            setCursorLCD(0, 11);
            char buf[5];
            double kalan = para - (yirmilik * 20);
            gcvt(kalan, 5, buf);
            printLCD(buf);*/

            /*
            atoi(), itoa(), sprintf() fonksiyonlari da gcc hatasindan dolayi calismiyor. eclipse uzerinde gcc guncellenmiyor.
            */
        }
    }
}


void initLCD() {
    SysCtlPeripheralEnable(LCDPORTENABLE);
    GPIOPinTypeGPIOOutput(LCDPORT, 0xFF);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, RS, 0x00);
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, 0x30);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, 0x30);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, 0x30);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, 0x20);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
    commandLCD(0x28);
    commandLCD(0xC0);
    commandLCD(0x06);
    commandLCD(0x80);
    commandLCD(0x28);
    commandLCD(0x0f);
    clearLCD();
}

void commandLCD(unsigned char c) {
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, (c & 0xf0));
    GPIOPinWrite(LCDPORT, RS, 0x00);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, (c & 0x0f) << 4);
    GPIOPinWrite(LCDPORT, RS, 0x00);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
}

void putchLCD(unsigned char d) {
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, (d & 0xf0));
    GPIOPinWrite(LCDPORT, RS, 0x01);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
    GPIOPinWrite(LCDPORT, D4 | D5 | D6 | D7, (d & 0x0f) << 4);
    GPIOPinWrite(LCDPORT, RS, 0x01);
    GPIOPinWrite(LCDPORT, E, 0x02);
    SysCtlDelay(10);
    GPIOPinWrite(LCDPORT, E, 0x00);
    SysCtlDelay(50000);
}

void setCursorLCD(char row, char column) {
    if (row == 0) {
        commandLCD(0x80 + ((column) % 16));
    } else {
        commandLCD(0xC0 + ((column) % 16));
    }
}

void clearLCD(void) {
    commandLCD(0x01);
    SysCtlDelay(10);
}

void printLCD( char* s) {
    while (*s) {
        putchLCD(*s++);
    }
}

void init_port_B() {
	volatile unsigned long delay;
	SYSCTL_RCGC2_R |= SYSCTL_RCGC2_GPIOB; // Port B'yi aktiflestir.
	delay = SYSCTL_RCGC2_R; // Zaman gecirmek icin
	GPIO_PORTB_DIR_R |= 0b00001100;	// PB3 ve PB2 pinlerini cikis yap.
	GPIO_PORTB_AFSEL_R &= ~0b00001100; // PB3 ve PB2 pinlerini alternatif fonksinunu 0 yap.
	GPIO_PORTB_DEN_R |= 0b00001100;	// PB3 ve PB2 pinlerini aktiflestir.
}

void init_port_A() {
	volatile unsigned long delay;
	SYSCTL_RCGC2_R |= SYSCTL_RCGC2_GPIOA; // Port A'yi aktiflestir.
    delay = SYSCTL_RCGC2_R; // Zaman gecirmek icin
    GPIO_PORTA_DIR_R |= 0x00; // Tum pinleri giris yap.
    GPIO_PORTA_AFSEL_R &= ~0xFF; // Alternatif fonksinunu 0 yap.
    GPIO_PORTA_DEN_R |= 0xFF; // Tum pinleri aktiflestir.
}

void init_port_C() {
	volatile unsigned long delay;
	SYSCTL_RCGC2_R |= SYSCTL_RCGC2_GPIOC; // Port C'yi aktiflestir.
    delay = SYSCTL_RCGC2_R; // Zaman gecirmek icin
    GPIO_PORTC_DIR_R |= 0x00; // Tum pinleri giris yap.
    GPIO_PORTC_AFSEL_R &= ~0xFF; // Alternatif fonksinunu 0 yap.
    GPIO_PORTC_DEN_R |= 0xFF; // Tum pinleri aktiflestir.
}

void Delay_sn(int second) {
    int i;
    for (i=0; i<second; i++);
}

void kalanYaz(float kalan)
{
    setCursorLCD(0, 11);
    int k1 = (int)(kalan / 10);
    if (k1 == 0) {
        printLCD("0");
    } else if (k1 == 1) {
        printLCD("1");
    }
    setCursorLCD(0, 12);
    int k2 = (int)kalan;
    k2 = k2%10;
    if (k2 == 0) {
        printLCD("0");
    } else if (k2 == 1) {
        printLCD("1");
    } else if (k2 == 2) {
        printLCD("2");
    } else if (k2 == 3) {
        printLCD("3");
    } else if (k2 == 4) {
        printLCD("4");
    } else if (k2 == 5) {
        printLCD("5");
    } else if (k2 == 6) {
        printLCD("6");
    } else if (k2 == 7) {
        printLCD("7");
    } else if (k2 == 8) {
        printLCD("8");
    } else if (k2 == 9) {
        printLCD("9");
    }
    setCursorLCD(0, 13);
    printLCD(".");
    setCursorLCD(0, 14);
    kalan = (kalan - (int)kalan);
    int k3 = kalan/0.1;
    if (k3 == 0) {
        printLCD("0");
    } else if (k3 == 1) {
        printLCD("1");
    } else if (k3 == 2) {
        printLCD("2");
    } else if (k3 == 3) {
        printLCD("3");
    } else if (k3 == 4) {
        printLCD("4");
    } else if (k3 == 5) {
        printLCD("5");
    } else if (k3 == 6) {
        printLCD("6");
    } else if (k3 == 7) {
        printLCD("7");
    } else if (k3 == 8) {
        printLCD("8");
    } else if (k3 == 9) {
        printLCD("9");
    }
    setCursorLCD(0, 15);
    int k4 = (kalan-0.1)*100;
    if (k4 == 0) {
        printLCD("0");
    } else if (k4 == 1) {
        printLCD("1");
    } else if (k4 == 2) {
        printLCD("2");
    } else if (k4 == 3) {
        printLCD("3");
    } else if (k4 == 4) {
        printLCD("4");
    } else if (k4 == 5) {
        printLCD("5");
    } else if (k4 == 6) {
        printLCD("6");
    } else if (k4 == 7) {
        printLCD("7");
    } else if (k4 == 8) {
        printLCD("8");
    } else if (k4 == 9) {
        printLCD("9");
    }
}
