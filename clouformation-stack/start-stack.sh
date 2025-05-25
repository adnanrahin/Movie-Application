#!/bin/bash
aws cloudformation deploy --template-file nlb-cf-stack.yaml --stack-name auto-scale-spring-nlb-stack
