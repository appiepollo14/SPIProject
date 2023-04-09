docker run --hostname=7fb8e2090794 --mac-address=02:42:ac:11:00:02 --env=POSTGRES_PASSWORD=postgrespw
--env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/postgresql/15/bin
--env=GOSU_VERSION=1.16 --env=LANG=en_US.utf8 --env=PG_MAJOR=15 --env=PG_VERSION=15.2-1.pgdg110+1
--env=PGDATA=/var/lib/postgresql/data --volume=/var/lib/postgresql/data -p 5432
--label='com.docker/featured-image=postgres:latest' --runtime=runc -d postgres:latest