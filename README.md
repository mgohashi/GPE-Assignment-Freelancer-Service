# Deploy postgresql

oc new-app postgresql-ephemeral -p POSTGRESQL_DATABASE=freelancerdb -p DATABASE_SERVICE_NAME=freelancer-postgresql -p POSTGRESQL_USER=postgres -p POSTGRESQL_PASSWORD=postgres

# Deploy Project Service

mvn clean fabric8:deploy -Popenshift

