# -*- coding: utf-8 -*-

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LogisticRegression
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures
from sklearn.metrics import confusion_matrix

data = pd.read_csv('datasets/Data_for_UCI_named.csv')

x = data.iloc[:,0:4].values # bagimsiz degiskenler
y = data.iloc[:,13:].values # bagimli degisken
print(y)

# verilerin egitim ve test icin bolunmesi
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.33, random_state=0)

# verilerin olceklenmesi
from sklearn.preprocessing import StandardScaler

sc = StandardScaler()
X_train = sc.fit_transform(x_train)
X_test = sc.transform(x_test)

# logistic regression
logr = LogisticRegression(random_state=0)
logr.fit(X_train, y_train)

y_pred = logr.predict(X_test)
print(y_pred) # prediction'larin cikarilmasi
print()
print(y_test) # gercek degerler
print()

confusionmatrix = confusion_matrix(y_test, y_pred)
print(confusionmatrix)