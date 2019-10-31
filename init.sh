#!/bin/bash

echo "-------------------------------------------"
echo "STEP 1/2: Downloading ChromeDriver ..."
echo "-------------------------------------------"

curl -O https://chromedriver.storage.googleapis.com/78.0.3904.70/chromedriver_mac64.zip

echo "-------------------------------------------"
echo "STEP 2/2: Installing ChromeDriver ..."
echo "-------------------------------------------"

unzip -o chromedriver_mac64.zip -d ./src/test/drivers/
rm chromedriver_mac64.zip

echo
echo "-------------------------------------------"
echo "Finished!"
echo "-------------------------------------------"
