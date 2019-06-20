import os
import pymysql

print(os.getcwd())

dataList = []
num = 0

with open("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\SPTCC-20160705.csv",encoding='GB2312') as f:
    for line in f:
        if num < 1000000:
            #print(line.split(",")+list(["ST_GeomFromText('(POINT("+line.split(",")[8]+" "+line.split(",")[9]+"))',4326)"]))
            dataList.append(line.split(","))
            print(dataList[num])
            num = num +1
        else:
            break
    conn = pymysql.connect(database="transport", user="root", password="123wyh", host="localhost", port=3306)
    cur = conn.cursor()
    for i in dataList:
        if len(i):
            cur.execute(
                "insert into card_use1(card_id1, use_date1, use_time1, line_station_name1, vehicle1, price1, discount1)  values (%s,%s,%s,%s,%s,%s,%s)",
                i)
            print("success")
        conn.commit()
    conn.close()
