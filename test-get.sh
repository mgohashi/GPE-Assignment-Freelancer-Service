#!/bin/sh

http $(oc get route/freelancer-service -o jsonpath='{.spec.host}')/freelancers/$1