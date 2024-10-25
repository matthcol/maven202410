

## Specific target/goal for maven springboot plugin
https://docs.spring.io/spring-boot/maven-plugin/goals.html

```
mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.profiles=dev,local

mvn spring-boot:start
# do something between
mvn spring-boot:stop

# with custom properties + skipTests
mvn clean package -DskipTests -Dmyapp.artifact.tag=main-2.0
mvn clean package -DskipTests -Dmyapp.jdbcdriver.groupid=org.mariadb.jdbc \
    -Dmyapp.jdbcdriver.artifactid=mariadb-java-client
```

## Deployment Springboot app with Postgresql
Powershell CLI:
```
mvn clean package -DskipTests '-Dmyapp.artifact.tag=pg'

# checkup
jar tvf .\target\cityapi-pg.jar | Select-String -Pattern maria
jar tvf .\target\cityapi-pg.jar | Select-String -Pattern postgres

mvn spring-boot:run '-Dspring-boot.run.profiles=pg'
```

## Deployment Springboot app with Mariadb
Powershell CLI:
```
mvn clean package -DskipTests '-Dmyapp.artifact.tag=maria' `
     -DskipTests '-Dmyapp.jdbcdriver.groupid=org.mariadb.jdbc' `
    '-Dmyapp.jdbcdriver.artifactid=mariadb-java-client'
    
# checkup
jar tvf .\target\cityapi-maria.jar | Select-String -Pattern maria
jar tvf .\target\cityapi-maria.jar | Select-String -Pattern postgres

mvn spring-boot:run '-Dspring-boot.run.profiles=maria'
```


## Docker
In sub-directory docker:
```
docker compose -p cityh2 up -d
docker compose -p citypg -f .\docker-compose.yml -f .\docker.compose.pg.yml up -d
```

## Install
```
mvn install:install-file  -Dfile=.\target\cityapi.jar `
                          -DgroupId=org.example `
                          -DartifactId=cityapi `
                          -Dversion=2.0 `
                          -Dpackaging=jar `
                          -DlocalRepositoryPath=.\docker\artifact
```
