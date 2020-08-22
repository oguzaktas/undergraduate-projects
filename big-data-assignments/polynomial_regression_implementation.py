# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

data = pd.read_csv("datasets/positions.csv")
print(data.columns)

level = data.iloc[:,1].values.reshape(-1,1) # calisilan pozisyona gore maaslar
salary = data.iloc[:,2].values.reshape(-1,1)

regression = LinearRegression()
regression.fit(level,salary)

tahmin = regression.predict([[8.3]]) # Level 8 (vice president) ortalama ne kadar maas alir (linear regression)
# Linear regression yanlis sonuc verir bu datada, polynomial regression kullanmak gerek.


regressionPoly = PolynomialFeatures(degree = 4) # MSE
levelPoly = regressionPoly.fit_transform(level)
regression2 = LinearRegression()
regression2.fit(levelPoly, salary)

tahmin2 = regression2.predict(regressionPoly.fit_transform([[8.3]]))

plt.scatter(level, salary, color="red")
plt.plot(level, regression.predict(level), color="blue")
plt.plot(level, regression2.predict(levelPoly))
plt.show()

a = np.array([1, 3, 5, 7, 9]) # List kullanarak
ll = [[1,2,3], [4,5,6], [7,8,9]]
aa = np.array(ll)