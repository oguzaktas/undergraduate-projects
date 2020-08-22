150201170 - Mehmet Oðuz Aktaþ
150201245 - Ebubekir Þit

Para Bozma Makinesi

* Proje Sistem Programlama dersinde bize öðretilen sanal makine üzerindeki Eclipse IDE üzerinden çalýþmaktadýr. Eclipse IDE üzerinden aþaðýdaki ayarlarýn yapýlmasý gerekmektedir.

## Target Processor ##

ARM family : cortex-m4
Float ABI : Library with FP (softfp)
FPU Type : fpv4-sp-d16

## Cross ARM C Compiler -> Includes ##

Include paths (-I) : proje içindeki SW-EK-TM4C123GXL-2.1.4.178 klasörü

## Cross ARM C Compiler -> Preprocessor ##

Defined symbols (-D) : PART_TM4C123GH6PM

## Cross ARM C Linker -> General ##

Script files (-T) : Proje içindeki src/TM4C.ld dosyasý

## Cross ARM C Linker -> Miscellaneous ##

Other objects : Proje içindeki SW-TM4C-2.1.2.111/driverlib/gcc/libdriver.a dosyasý