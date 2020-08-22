150201170 - Mehmet O�uz Akta�
150201245 - Ebubekir �it

Ara� Al��veri� Veritaban� Program�

* Uygulaman�n �al��abilmesi i�in �ncelikle arac_alisveris isminde veritaban�n�n, MySQL Workbench (veya farkl� bir MySQL veritaban� y�netim uygulamas�) ile create-db-tables.sql dosyas� kullan�larak olu�turulmas� ve insert-records.sql dosyas� ile veritaban�na kay�tlar�n eklenmesi gerekmektedir. Bu dosyalar olu�turulmak istenen veritaban�n �zelliklerine g�re editlenebilir.

* MySQL ile Java ba�lant�s� sa�layabilmek i�in MySQL JDBC Driver k�t�phanesinin (veya ayr� olarak indirilip MySQL Connector J'nin) projeye dahil edilmi� olmas� gerekmektedir. Projeye dahil etmek i�in yap�lmas� gereken ad�mlar �unlard�r;

- NetBeans IDE veya kullan�lan farkl� IDE �zerinden proje �zellikleri a��l�r.
- Libraries b�l�m�nden "Add Library" se�ene�i ile NetBeans IDE 8.2'de default olarak bulunan ve i�inde MySQL Connector J 5.1.23'� bulunduran MySQL JDBC Driver API'si eklenir.

* Swing GUI'deki tarih k�s�mlar�n�n do�ru �al��abilmesi i�in projeye JCalendar k�t�phanesi eklenmelidir. Bu k�t�phaneyi indirdikten sonra projeye dahil etmek i�in yap�lmas� gereken ad�mlar �unlard�r;

- jcalendar-1.4.zip i�inde lib klas�r�nde bulunan jcalendar-1.4.jar dosyas� ��kar�l�r.
- Proje �zelliklerinden Libraries b�l�m�nden "Add Library" se�ene�i ile jcalendar-1.4.jar dosyas� eklenir.
E�er daha sonra kullan�lmak isteniyorsa;
- NetBeans'te Design k�sm�nda ve IDE ayarlar�ndan ula��labilen Swing Palette Manager a��larak "Add from Library" se�ene�i ile JCalendar se�ilir.
- Daha sonra Palette Categories b�l�m�nden istenen kategoriye eklenir. (Ben Swing Controls'e ekledim.) Bu ad�mdan sonra GUI'de tarih inputlar�n� al�rken kulland���m�z JDateChooser componenti Swing Controls k�sm�ndan se�ilebilir hale gelir.

* MySQL ayarlar� yap�ld�ktan sonra t�m GUI classlar�nda veritaban� ile ba�lant� kurulmas�n� sa�layan getConnection() metodu i�erisinde yaz�lan veritaban� ismi, MySQL kullan�c� ad� ve �ifresi duruma g�re de�i�tirilmelidir.

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arac_alisveris", "root", "123456");

�stteki kodda, veritaban� ismi arac_alisveris, MySQL kullan�c�s� root ve MySQL �ifresi olarak da 123456 kullan�lm��t�r. Bunlar farkl�ysa de�i�tirilmelidir.
