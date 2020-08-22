# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

data = pd.read_csv("datasets/hw_25000.csv")

boy = data.Height.values.reshape(-1,1)
kilo = data.Weight.values.reshape(-1,1)

regression = LinearRegression()
regression.fit(boy, kilo)
print(regression.predict([[71]]))

print(data.columns)

plt.scatter(data.Height, data.Weight) # gorsellestirme
plt.xlabel("Boy")
plt.ylabel("Kilo")
plt.show()

# 25 bin kaydi line fit etmek