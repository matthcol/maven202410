copy target\cityapi.jar docker\artifact
cd docker
docker compose -p citypg -f docker-compose.yml -f docker-compose.pg.yml up -d