#!/bin/bash

# build backend
cd backend
mvn clean package -Dmaven.test.skip=true

# build frontend
cd ../frontend
npm run build

# build images
cd ..

docker-compose pull
docker-compose build