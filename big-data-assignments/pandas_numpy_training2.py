"""
@author: Oguz Aktas
notes from Intro to Python course by Engin Demiroğ on Udemy
"""

import pandas as pd
import numpy as np

### 1. Bolum: Serilerle calismak
s = pd.Series()
print(s)
data = np.array(["Oguz", "Engin", "Derin"])
s = pd.Series(data, index=[1, 2, 3])
print(s)
print("s\'in 1. indexi:" + s[1])

data2 = {"matematik":15, "fizik":20, "beden eğitimi":100}
s2 = pd.Series(data2, index=["mat", "fiz", "bed"])  ## NaN verir.
s2 = pd.Series(data2, index=["matematik", "fizik", "beden eğitimi"]) # veri transferi yapmada kullanilir.
# mesela matematik ile fizik'in değerleri değiştirilmek istenirse.
print(s2)
print(s2[0])

s3 = pd.Series(5, index=[1,2,3,4]) # 4 indexe de 5 değerini verir.
print(s3)
print("-" * 50)

### 2. Bolum: DataFrame ile calismak
df = pd.DataFrame()
print(df) # Empty DataFrame, Columns: [], Index: []
data = [10, 20, 30, 40, 50]
df = pd.DataFrame(data)
print(df)

data2 = [["Oguz", 25, "Kocaeli"], ["Engin", 33, "Ankara"], ["Salih", 32, "Istanbul"]]
df2 = pd.DataFrame(data2, columns=["İsim", "Yaş", "Şehir"], index=[1, 2, 3])
print(df2)

print("--- ---")
data3 = {"İsim":["Oguz", "Engin", "Salih"],
         "Yaş":[25, 33, 4],
         "Şehir": ["Kocaeli", "Ankara", "Istanbul"]}
df3 = pd.DataFrame(data3, columns=["İsim", "Yaş", "Şehir"], index=[1, 2, 3])
print(df3)
print()
print(df3["İsim"])
# del df3["Şehir"] ve df3.pop["Şehir"] -> Şehir kolonunu uçurur.
print(df3)
print("-" * 50)

print(df3.loc[2])
print(df3.iloc[2])

df4 = df3.append(df3) # iki data frame'ini birlestirmek
print()
print(df4.head()) # ilk 5 datayı verir.
print()
print(df4.tail()) # sondaki 5 datayı verir.
