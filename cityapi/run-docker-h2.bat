copy target\cityapi.jar docker\artifact
cd docker
docker compose -p cityh2 up -d