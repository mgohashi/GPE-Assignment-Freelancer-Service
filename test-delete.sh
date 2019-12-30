if [ "" == "$1" ]; then
    echo "Error you need to inform an ID. E.g. ./test-delete.sh 2"
    exit 1
fi

http DELETE $(oc get route/freelancer-service -o jsonpath='{.spec.host}')/freelancers/$1