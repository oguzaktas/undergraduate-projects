150201170 - Mehmet Oğuz Aktaş
150201245 - Ebubekir Şit

Araç Yönetim Sistemi

Programı çalıştırmak için Java SE ve JDK yüklü olması gerekmektedir. Program konsol üzerinden çalışmaktadır ve konsol üzerinden program akışı içinde kullanıcı tarafından sonlandırılmadığı sürece devam etmektedir. Program akışı içinde değil de dışarıdan müdahele ile program sonlandırıldığında, AracKayit.txt dosyasının içeriği silinmemektedir ve tekrar çalıştırıldığında oluşturulacak yeni araçlar için aynı seri numarası ile txt dosyasına kayıtlar eklenebilir. Bu yüzden programın dışarıdan müdahele ile sonlandırılmaması gerekiyor.

1) Uygulamayı IDE üzerinden veya işletim sisteminin konsol ekranından gerekli komutları yazarak çalıştırın.
2) İlk olarak ana menü ekranından yapmak istediğiniz işlemi (Veri girişinde bulun, veri listele, veri güncelle) seçmeniz beklenir.
3) Veri girişinde bulun menüsünde hangi aracın (otomobil, bisiklet, gemi, uçak veya uçan gemi) oluşturulacağını seçmeniz beklenir.
4) Veri listele menüsünde hangi taşıtların  (kara taşıtları, deniz taşıtları veya hava taşıtları) listeleneceğini seçmeniz beklenir. Seçime göre daha önceden oluşturulan kayıtlar listelenir.
5) Veri güncelle menüsünde güncellemek istediğiniz aracın seri numarasını girmeniz beklenir. Girilen seri numarasına göre aracın özelliklerinin bulunduğu yeni bir menü gelir, buradan aracın hangi özelliğini güncellemek istediğinizi seçmeniz beklenir.
6) Tüm işlemlerden sonra program ana menüye döner. Ayrıca her menüde programı sonlandır seçeneği bulunmaktadır, bu seçenek seçildiğinde oluşturulan tüm kayıtlar txt dosyasından silinerek program sonlandırılır.

------------------------------------------------------------------------

Vehicle Management System

Java SE and JDK are required to run the program. The program is console application and continues as long as the user does not terminate the program flow through the console. If the program is terminated by intervention, the contents of AracKayit.txt file will not be deleted and records can be added to the txt file with the same serial key for new vehicles to be created when it is restarted. This means that the program should not be terminated by external intervention.

1) Run the application either through the IDE or by typing the necessary commands on the console screen of your operating system.
2) First you will be asked to which operation you want to perform (add data, list data, update data) from the main menu screen.
3) On the data insertion menu, you are expected to choose which vehicle (car, bicycle, ship, airplane or flying vessel) will be created.
4) On the list data menu, you are expected to choose which vehicle type (land vehicles, sea vehicles or air vehicles) will be listed.
5) On the update data menu, you are expected to enter the serial key of the vehicle you wish to update. Depending on the serial key entered, a new menu appears with the properties of the vehicle, from here you are expected to choose which feature you want to update.
6) After all operations, the program returns to the main menu. Also, in each menu, there is a program termination option. When this option selected, all the records created are deleted from the txt file and the program is terminated.