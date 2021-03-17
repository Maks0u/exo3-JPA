#!/bin/sh

main_url="http://localhost:8080/exo3-JPA/rest/personnes"

echo init
curl -X GET $main_url
echo
echo insert {id:1,nom:"Maxime"}
curl -d '{id:1,nom:"Maxime"}' -X POST $main_url
echo
echo insert {id:4,nom:"Phil"}
curl -d '{id:4,nom:"Phil"}' -X POST $main_url
echo
echo insert {id:13,nom:"Karim"}
curl -d '{id:13,nom:"Karim"}' -X POST $main_url
echo
echo GET all
curl -X GET $main_url
echo
echo PUT {id:1,nom:"Max"}
curl -d '{id:1,nom:"Max"}' -X PUT $main_url
echo
echo GET id:1
curl -X GET "${main_url}/1"
echo
echo DELETE id:13
curl -X DELETE "${main_url}/13"
echo
echo GET all
curl -X GET $main_url
echo
