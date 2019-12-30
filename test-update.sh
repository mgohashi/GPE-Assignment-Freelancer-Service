if [ "" == "$1" ]; then
    echo "Error you need to inform an ID. E.g. ./test-update.sh 2"
    exit 1
fi

echo '{
        "emailAddress": "jarmstrong-2@gmail.com",
        "firstName": "John-2",
        "lastName": "Armstrong-2",
        "skills": [
            {
                "name": "Python"
            },
            {
                "name": "Golang"
            }
        ]
}' |  http -v PUT $(oc get route/freelancer-service -o jsonpath='{.spec.host}')/freelancers/$1