import matplotlib.pyplot as plt
import seaborn
import os, glob
import pandas
import sqlite3




filename = r'C:\Users\Ciaran\Documents\JavaProjects\Simulator\src\text.db'

assert os.path.isfile(filename)
conn = sqlite3.Connection(filename)

df = pandas.read_sql("SELECT * FROM test", conn)

print df











