"""
@author: Oguz Aktas
"""

import pandas as pd

notlar = pd.read_csv("datasets/grades2.csv") # notlar data frame türünde
notlar.columns = ["İsim", "Soyisim", "SSN", "Test1", "Test2", "Test3", "Test4", "Final", "Sonuc"]
print(type(notlar)) # <class 'pandas.core.frame.DataFrame'>
print(notlar.head()) # ilk 5 data
print()
print(notlar.tail()) # son 5 data
# print(notlar["First name"]) # "First name" şeklinde gelmiş csv o yüzden en başta notlar.columns ile düzenlenir.
print(notlar["Final"])
print(notlar.iloc[2])

url = "http://bit.ly/uforeports"
data = pd.read_csv(url)
print(data)
print(data.isnull().head(20))
print(data.notnull().tail(20))
