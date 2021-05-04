import os
import webbrowser

username = input('What is your mysql username? ')
input_file = 'final_db_schema/tables.sql'
mysql_login = 'mysql -u' + username + ' -p' + ' < ' + input_file
os.system(mysql_login)
os.system('mvn spring-boot:run')

time.sleep(2)
webbrowser.open('http://localhost:8080/')
