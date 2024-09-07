gradle clean build

java -jar build/libs/libraryRestApi.jar

application url - http://localhost:8080/library/listAll

API - http://localhost:8080/swagger-ui.html

MongoDB

#Steps for Ubuntu

start Db -

sudo service mongodb start

mongo

show dbs

use libraryDb

show collections

db.items.find()

#Steps for Windows

mongod.exe --dbpath "E:\Projects\mongodb\data"

mongo.exe

#Create Mongo Db collections and Documents

use libraryDb

show collections

db.items.find()

#Save

example:
curl -X POST --header 'Content-Type: application/json' --header 'Accept: text/plain' -d '{ \ 
   "author": "Yuval Noah Harari", \ 
   "category": "Popular Science", \ 
   "id": "01", \ 
   "isbn": "ISBN 978-0-099-59008-8", \ 
   "language": "English", \ 
   "price": 499.00, \ 
   "publisher": "Vintage Books", \ 
   "title": "Sapiens", \ 
   "type": "Book" \ 
 }' 'http://localhost:8080/library/save'
