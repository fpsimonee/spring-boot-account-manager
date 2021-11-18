#!/usr/bin/env bash

echo "creating database data...."

mongo admin --host localhost -u root -p root --eval "

db = db.getSiblingDB('billing-app')

db.createCollection('billings')

db.billings.insert([{createdAt:'2021-11-16T11:04:22.408Z',description:'Beauty',value:'382.00',id:'1'},{createdAt:'2021-11-16T04:30:23.928Z',description:'Clothing',value:'16.00',id:'2'},{createdAt:'2021-11-15T19:16:25.329Z',description:'Movies',value:'119.00',id:'3'},{createdAt:'2021-11-16T01:39:07.122Z',description:'Home',value:'928.00',id:'4'},{createdAt:'2021-11-16T01:14:57.914Z',description:'Sports',value:'625.00',id:'5'},{createdAt:'2021-11-15T16:39:17.282Z',description:'Automotive',value:'548.00',id:'6'},{createdAt:'2021-11-15T22:45:29.587Z',description:'Clothing',value:'463.00',id:'7'},{createdAt:'2021-11-16T07:57:37.900Z',description:'Movies',value:'88.00',id:'8'}])

"

echo "database data create...."