#!/bin/sh

echo '{
        "emailAddress": "jarmstrong@gmail.com",
        "firstName": "John",
        "lastName": "Armstrong",
        "skills": [
            {
                "name": "Python"
            },
            {
                "name": "Golang"
            }
        ]
}' |  http -v POST $(oc get route/freelancer-service -o jsonpath='{.spec.host}')/freelancers