-- Tbl_VitesTuru (3 kayit);
INSERT INTO Tbl_VitesTuru VALUES (1, 'Manuel');
INSERT INTO Tbl_VitesTuru VALUES (2, 'Yari Otomatik');
INSERT INTO Tbl_VitesTuru VALUES (3, 'Otomatik');


-- Tbl_YakitTuru (4 kayit);
INSERT INTO Tbl_YakitTuru VALUES (1, 'Benzin');
INSERT INTO Tbl_YakitTuru VALUES (2, 'LPG');
INSERT INTO Tbl_YakitTuru VALUES (3, 'Dizel');
INSERT INTO Tbl_YakitTuru VALUES (4, 'Elektrik');


-- Tbl_Renk (11 kayit);
INSERT INTO Tbl_Renk VALUES (1, 'Beyaz');
INSERT INTO Tbl_Renk VALUES (2, 'Siyah');
INSERT INTO Tbl_Renk VALUES (3, 'Kirmizi');
INSERT INTO Tbl_Renk VALUES (4, 'Yesil');
INSERT INTO Tbl_Renk VALUES (5, 'Mavi');
INSERT INTO Tbl_Renk VALUES (6, 'Gri');
INSERT INTO Tbl_Renk VALUES (7, 'Turuncu');
INSERT INTO Tbl_Renk VALUES (8, 'Lacivert');
INSERT INTO Tbl_Renk VALUES (9, 'Fume');
INSERT INTO Tbl_Renk VALUES (10, 'Bordo');
INSERT INTO Tbl_Renk VALUES (11, 'Turkuaz');


-- Tbl_Sehir (11 kayit);
INSERT INTO Tbl_Sehir VALUES (1, 'Istanbul');
INSERT INTO Tbl_Sehir VALUES (2, 'Ankara');
INSERT INTO Tbl_Sehir VALUES (3, 'Izmir');
INSERT INTO Tbl_Sehir VALUES (4, 'Antalya');
INSERT INTO Tbl_Sehir VALUES (5, 'Bursa');
INSERT INTO Tbl_Sehir VALUES (6, 'Adana');
INSERT INTO Tbl_Sehir VALUES (7, 'Kocaeli');
INSERT INTO Tbl_Sehir VALUES (8, 'Sakarya');
INSERT INTO Tbl_Sehir VALUES (9, 'Gaziantep');
INSERT INTO Tbl_Sehir VALUES (10, 'Isparta');
INSERT INTO Tbl_Sehir VALUES (11, 'Eskisehir');


-- Tbl_Araba (34 kayit);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (1, 'Audi', 'A4', 1, 2, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (2, 'Alfa Romeo', 'JTD Distinctive Plus', 3, 3, 3);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (3, 'Audi', 'A5', 2, 3, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (4, 'Renault', 'Megane', 3, 3, 2);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (5, 'Ferrari', 'California', 2, 1, 3);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (6, 'Ford', 'Fiesta', 3, 1, 9);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (7, 'Tesla', 'Model X 100D', 3, 4, 2);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (8, 'Mercedes-Benz', 'S 400 Sport', 2, 1, 6);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (9, 'Volkswagen', 'Jetta', 2, 1, 11);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (10, 'Volkswagen', 'Polo', 1, 2, 8);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (11, 'Fiat', 'Punto', 1, 2, 4);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (12, 'Ford', 'Fiesta', 2, 3, 5);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (13, 'Audi', 'A4', 3, 3, 3);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (14, 'Fiat', 'Punto', 3, 3, 10);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (15, 'Audi', 'A5', 1, 1, 6);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (16, 'Toyota', 'Corolla', 3, 2, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (17, 'Fiat', 'Punto', 2, 1, 7);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (18, 'BMW', 'i3', 2, 4, 9);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (19, 'Audi', 'A4', 2, 1, 2);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (20, 'Ford', 'Fiesta', 1, 2, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (21, 'Hyundai', 'Accent Blue', 2, 3, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (22, 'Opel', 'Astra', 1, 1, 2);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (23, 'Porsche', 'Carrera S', 1, 1, 6);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (24, 'Volkswagen', 'Jetta', 3, 3, 9);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (25, 'Opel', 'Astra', 3, 2, 8);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (26, 'Mercedes-Benz', 'C 180', 1, 2, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (27, 'Lamborghini', 'Gallardo', 2, 1, 2);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (28, 'Opel', 'Astra', 2, 3, 10);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (29, 'Ford', 'Fiesta', 3, 1, 2);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (30, 'Peugeot', '301', 1, 3, 11);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (31, 'Volkswagen', 'Jetta', 1, 2, 5);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (32, 'Opel', 'Insignia', 3, 3, 1);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (33, 'Renault', 'Megane', 3, 3, 6);
INSERT INTO Tbl_Araba (ArabaID, Araba_Marka, Araba_Model, Araba_VitesTuruID, Araba_YakitTuruID, Araba_RenkID) VALUES (34, 'BMW', '630Ci', 2, 2, 2);


-- Tbl_Ilan (34 kayit);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (1, '2008 Audi A4 170000 Km Sahibinden', '62.750', '170.000', '2018-05-01', 1, 2);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (2, 'Alfa Romeo 159 JTD Otomatik Vites Dizel Hasarsiz', '49.750', '124.000', '2018-04-30', 2, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (3, 'Sahibinden Acil A5 Sportback 2.0 TDI Multitronic Bayi Cikisli', '192.000', '82.600', '2018-05-19', 3, 3);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (4, 'Sifir Dizel Otomatik Renault Megane', '120.000', '900', '2018-05-05', 4, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (5, 'Ata Car 2010 Ferrari California Corsa Fer Mas', '850.000', '31.920', '2018-05-04', 5, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (6, '2017 Fiesta 1.6 Otomatik Boyasiz', '68.500', '10.000', '2018-05-02', 6, 6);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (7, '0 Km Tesla Model X Satilik', '630.000', '0', '2018-04-17', 7, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (8, 'Acil Sahibinden Mercedes S400', '710.000', '19.200', '2018-04-29', 8, 11);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (9, 'Sahibinden Yeni Jetta 1.2TSI DSG', '77.350', '90.500', '2018-05-02', 9, 7);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (10, 'Sahibinden Acil 25000 km 2016 LPG Polo', '71.500', '25.000', '2018-05-04', 10, 5);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (11, 'Fiat Punto 2011 1.3 Multijet Grande Active Satilik', '29.250', '187.000', '2018-05-05', 11, 4);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (12, 'Masrafsiz Tertemiz 2006 Ford Fiesta Hatchback', '27.900', '175.000', '2018-05-01', 12, 11);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (13, '2011 Model Titanium Fiesta Full Servis Bakimli', '40.500', '198.000', '2018-05-02', 20, 9);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (14, 'Acil Satilik Fiat Punto 2012 Dizel', '33.150', '92.000', '2018-05-20', 14, 8);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (15, '2012 Temiz 1.4 TDCi Ford Fiesta Otomatik Benzinli', '35.750', '181.000', '2018-04-29', 29, 3);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (16, '2016 Model Audi A4 Quattro', '227.500', '38.500', '2018-05-01', 13, 2);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (17, '42.000 km Fiat Punto 1.4 Multijet Benzinli', '32.000', '42.000', '2018-05-03', 17, 10);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (18, '2012 Bayi Porsche 911 Carrera S', '970.000', '55.000', '2018-04-20', 23, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (19, '2012 Astra 1.6 Dizel Essentia Comfort Boyasiz', '53.500', '92.250', '2018-04-29', 28, 6);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (20, 'Sifir Gibi Dizel Otomatik Renault Yeni Sedan Megane', '114.000', '900', '2018-05-21', 33, 7);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (21, 'Boyasiz Ilk Sahibinden Satilik Audi A4 Benzinli', '154.000', '78.000', '2018-05-05', 19, 7);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (22, 'Hatasiz Ilk Sahibinden Satilik Toyota Corolla', '102.000', '500', '2018-05-05', 16, 2);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (23, 'Ozel Plakali 2013 Model Sahibinden C180 Acil', '113.500', '113.000', '2018-05-20', 26, 4);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (24, 'Sahibinden Orjinal Opel Insignia Dizel', '69.500', '142.000', '2018-05-05', 32, 2);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (25, '2014 BMW i3 Elektrikli Boyasiz Hatasiz 19 Jant', '158.500', '30.000', '2018-04-23', 18, 11);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (26, 'Audi A5 2.0 2015 Model TDI S Quattro Manuel', '217.000', '105.969', '2018-05-03', 15, 3);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (27, 'Acil 2018 Cikisli Sedefli Beyaz Hyundai DCT 7', '81.000', '11.500', '2018-05-05', 21, 4);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (28, 'Opel Astra Acil 1.6 Enjoy Otomatik Vites LPG', '43.000', '124.000', '2018-05-02', 25, 5);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (29, 'Opel Astra K Boyasiz Hasarsiz Navigasyon Garantili', '73.000', '9.500', '2018-05-06', 22, 3);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (30, 'Hatasiz Boyasiz 2013 Jetta Manuel LPG Conford Servis Bakim', '76.500', '131.000', '2018-05-17', 31, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (31, 'Giray Motors Kazasiz Boyasiz Lamborghini Gallardo Ozel Seri', '750.000', '35.000', '2018-05-05', 27, 1);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (32, '2014 Cikisli Peugeot 301 Dizel Tekno Paket', '39.500', '152.402', '2018-05-21', 30, 2);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (33, 'Boyasiz 2014 Volkswagen Jetta TDi Highline DSG Yeni Kasa', '96.750', '82.800', '2018-05-01', 24, 3);
INSERT INTO Tbl_Ilan (IlanID, Ilan_Adi, Ilan_Fiyat, Ilan_Km, Ilan_Tarih, Ilan_ArabaID, Ilan_SehirID) VALUES (34, 'BMW 6 Serisi 630Ci Yari Otomatik Benzinli Acil Satilik', '149.000', '163.000', '2018-05-05', 33, 1);


