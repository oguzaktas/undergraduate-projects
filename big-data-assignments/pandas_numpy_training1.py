"""
@author: Oguz Aktas
"""

import numpy as np
import pandas as pd

def header(msg):
	print('-' * 50)
	print('[ ' + msg + ' ]')


# 1. load hard-coded data into a dataframe
header("1. load hard-coded data into a df")
df = pd.DataFrame(
   	[['Jan',58,42,74,22,2.95],
	['Feb',61,45,78,26,3.02],
	['Mar',65,48,84,25,2.34],
	['Apr',67,50,92,28,1.02],
	['May',71,53,98,35,0.48],
	['Jun',75,56,107,41,0.11],
	['Jul',77,58,105,44,0.0],
	['Aug',77,59,102,43,0.03],
	['Sep',77,57,103,40,0.17],
	['Oct',73,54,96,34,0.81],
	['Nov',64,48,84,30,1.7],
	['Dec',58,42,73,21,2.56]],
    index = [0,1,2,3,4,5,6,7,8,9,10,11],
    columns = ['month','avg_high', 'avg_low', 'record_high', 'record_low', 'avg_precipitation'])
print(df)

print()

# 2. read text file into a dataframe
header("2. read text file into a dataframe")
filename = "grades.csv"
df = pd.read_csv(filename)
print(df)

print()

# 3. print first 5 or last 3 rows of df
header("3. df.head()")
print(df.head())
header("3. df.tail(3)")
print(df.tail(3))

print()

# 4. get data types, index, columns, values
header("4. df.dtypes")
print(df.dtypes)

header("4. df.index")
print(df.index)

header("4. df.columns")
print(df.columns)

header("4. df.values")
print(df.values)

# 5. statistical summary of each column
header("5. df.describe()")
print(df.describe())

# 6. sort records by any column
header("6. df.sort_values('course', ascending=True)")
print(df.sort_values('course', ascending=True))

# 7. slicing records
header("7. slicing -- df.avg_low")
print(df.avg_low) # index with single column
