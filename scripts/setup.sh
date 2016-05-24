#!/bin/bash

filename="prod.env"
while IFS='' read -r line || [[ -n "$line" ]]; do
    export "$line"
done < $filename
