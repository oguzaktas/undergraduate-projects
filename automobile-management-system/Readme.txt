150201170 - Mehmet Oðuz Aktaþ
150201245 - Ebubekir Þit

Araç Alýþveriþ Veritabaný Programý

* Uygulamanýn çalýþabilmesi için öncelikle arac_alisveris isminde veritabanýnýn, MySQL Workbench (veya farklý bir MySQL veritabaný yönetim uygulamasý) ile create-db-tables.sql dosyasý kullanýlarak oluþturulmasý ve insert-records.sql dosyasý ile veritabanýna kayýtlarýn eklenmesi gerekmektedir. Bu dosyalar oluþturulmak istenen veritabanýn özelliklerine göre editlenebilir.

* MySQL ile Java baðlantýsý saðlayabilmek için MySQL JDBC Driver kütüphanesinin (veya ayrý olarak indirilip MySQL Connector J'nin) projeye dahil edilmiþ olmasý gerekmektedir. Projeye dahil etmek için yapýlmasý gereken adýmlar þunlardýr;

- NetBeans IDE veya kullanýlan farklý IDE üzerinden proje özellikleri açýlýr.
- Libraries bölümünden "Add Library" seçeneði ile NetBeans IDE 8.2'de default olarak bulunan ve içinde MySQL Connector J 5.1.23'ü bulunduran MySQL JDBC Driver API'si eklenir.

* Swing GUI'deki tarih kýsýmlarýnýn doðru çalýþabilmesi için projeye JCalendar kütüphanesi eklenmelidir. Bu kütüphaneyi indirdikten sonra projeye dahil etmek için yapýlmasý gereken adýmlar þunlardýr;

- jcalendar-1.4.zip içinde lib klasöründe bulunan jcalendar-1.4.jar dosyasý çýkarýlýr.
- Proje özelliklerinden Libraries bölümünden "Add Library" seçeneði ile jcalendar-1.4.jar dosyasý eklenir.
Eðer daha sonra kullanýlmak isteniyorsa;
- NetBeans'te Design kýsmýnda ve IDE ayarlarýndan ulaþýlabilen Swing Palette Manager açýlarak "Add from Library" seçeneði ile JCalendar seçilir.
- Daha sonra Palette Categories bölümünden istenen kategoriye eklenir. (Ben Swing Controls'e ekledim.) Bu adýmdan sonra GUI'de tarih inputlarýný alýrken kullandýðýmýz JDateChooser componenti Swing Controls kýsmýndan seçilebilir hale gelir.

* MySQL ayarlarý yapýldýktan sonra tüm GUI classlarýnda veritabaný ile baðlantý kurulmasýný saðlayan getConnection() metodu içerisinde yazýlan veritabaný ismi, MySQL kullanýcý adý ve þifresi duruma göre deðiþtirilmelidir.

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arac_alisveris", "root", "123456");

Üstteki kodda, veritabaný ismi arac_alisveris, MySQL kullanýcýsý root ve MySQL þifresi olarak da 123456 kullanýlmýþtýr. Bunlar farklýysa deðiþtirilmelidir.
