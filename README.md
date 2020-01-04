# Deploy postgresql

```shell
$ oc new-app postgresql-ephemeral -p POSTGRESQL_DATABASE=freelancerdb \
                                  -p DATABASE_SERVICE_NAME=freelancer-postgresql \
                                  -p POSTGRESQL_USER=postgres \
                                  -p POSTGRESQL_PASSWORD=postgres
```

# Deploy Project Service

```shell
$ mvn clean fabric8:deploy -Popenshift
```

# Tests on openshift

To use the following scripts you should have installed the [httpie](https://httpie.org/).

* Get freelancers
  ```shell
  $ ./test-get.sh
  ```
* Get freelancer
  ```shell
  $ ./test-get.sh 1
  ```
* Insert freelancer
  ```shell
  $ ./test-insert.sh
  ```
* Update freelancer
  ```shell
  $ ./test-update.sh 1
  ```
* Delete freelancer
  ```shell
  $ ./test-delete.sh 1
  ```

# Execute Unit Tests

```shell
$ mvn clean test
```