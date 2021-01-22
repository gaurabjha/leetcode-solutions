


import tabula
import os
import pandas as pd
import csv


# read PDF file ̰
file = "FF.pdf"
#tables = tabula.read_pdf(file, pages="all")
tables = tabula.read_pdf(file, pages = "all", multiple_tables = True)
# save them in a folder
folder_name = "tables"
if not os.path.isdir(folder_name):
    os.mkdir(folder_name)


tables = tabula.read_pdf(file, pages = "all", multiple_tables = True)
tabula.convert_into(file, "iris_all.csv", pages = "all")

data = pd.read_csv("iris_all.csv")
#print(data)
with open('iris_all.csv', 'rb') as f:
    reader = csv.reader(f)
    for row in reader:
        print(row)
# iterate over extracted tables and process It
# for i, table in enumerate(tables, start=1):
#     #table = table.drop(["Unnamed: 0"], axis=1)
#     for row in table:
#         print(row)

# tables = tabula.read_pdf(file, pages = "all", multiple_tables = True)
# tabula.convert_into(file, "iris_all.csv", pages = "all")