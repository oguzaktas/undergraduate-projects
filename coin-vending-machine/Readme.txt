150201170 - Mehmet O�uz Akta�
150201245 - Ebubekir �it

Para Bozma Makinesi

* Proje Sistem Programlama dersinde bize ��retilen sanal makine �zerindeki Eclipse IDE �zerinden �al��maktad�r. Eclipse IDE �zerinden a�a��daki ayarlar�n yap�lmas� gerekmektedir.

## Target Processor ##

ARM family : cortex-m4
Float ABI : Library with FP (softfp)
FPU Type : fpv4-sp-d16

## Cross ARM C Compiler -> Includes ##

Include paths (-I) : proje i�indeki SW-EK-TM4C123GXL-2.1.4.178 klas�r�

## Cross ARM C Compiler -> Preprocessor ##

Defined symbols (-D) : PART_TM4C123GH6PM

## Cross ARM C Linker -> General ##

Script files (-T) : Proje i�indeki src/TM4C.ld dosyas�

## Cross ARM C Linker -> Miscellaneous ##

Other objects : Proje i�indeki SW-TM4C-2.1.2.111/driverlib/gcc/libdriver.a dosyas�