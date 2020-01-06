## Local - UT
```bash
mvn verify
```

## Local - feature test
```bash
docker run --rm --name postgres121 -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
mvn spring-boot:run
curl http://localhost:8080/
```

## Commit to git repo
```bash
git push origin
```

## check Stage - recreate

## Promote by Cloud Run
 
## check Prod - Blue Green
