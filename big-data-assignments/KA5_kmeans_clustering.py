# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

f = open('datasets/Players.csv','rU')
players = pd.read_csv(f)

from sklearn.cluster import KMeans

x = players.iloc[:,4:6].values # Pas sayisi

kmeans = KMeans(n_clusters=3, init='k-means++')
kmeans.fit(x)

print(kmeans.cluster_centers_)