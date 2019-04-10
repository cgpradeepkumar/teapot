gradle clean build

java -jar build/libs/libraryRestApi.jar

application url - http://localhost:8080/library/listAll

API - http://localhost:8080/swagger-ui.html

MongoDB

Steps for Ubuntu

start Db -

sudo service mongodb start

mongo

show dbs

use libraryDb

show collections

db.items.find()
