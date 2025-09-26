#!/bin/bash

# Run Certbot to renew certificates
echo "Attempting to renew certificates..."
docker compose run --rm certbot renew

# Check if renewal was successful
if [ $? -ne 0 ]; then
    echo "Certbot renewal failed."
else
    echo "Certbot renewal successful. Reloading Nginx..."
    docker compose kill -s HUP nginx
    echo "Nginx reloaded."
fi

