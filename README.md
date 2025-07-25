# 🚀 CI/CD Integration for Appium Test Automation

This README explains how to integrate **Continuous Integration and Deployment (CI/CD)** into an **Appium test automation project** using **GitHub Actions**. It includes pipeline setup, configuration steps, test execution, and reporting.

---

## 📦 What This Covers

- CI/CD workflow using GitHub Actions
- Installing dependencies
- Running Appium tests
- Generating and uploading Allure reports
- Integration with GitHub repository

---

## ⚙️ CI/CD Workflow Overview

Every time code is pushed or a pull request is created on the `main` branch:

- The CI server installs dependencies
- Appium tests are executed
- Results are visible directly in the Actions tab of the repo

## 📁 Project Structure

├── src/test/java 				# Test files
├── pom.xml 					# Maven configuration
├── .github/workflows/ 			# GitHub Actions workflows
│ └── appium-ci.yml 			# CI pipeline definition
├── testng.xml 					# TestNG suite configuration
└── README.md 					# Project documentation	

## 🔧 Prerequisites for CI/CD

Ensure your repo contains:

- A working Appium project (`Java`, `Maven`, `TestNG`)
- Test cases and `testng.xml` defined
- Proper mobile app file (`.apk` or `.ipa`) in place or downloaded during runtime
- GitHub repository with Actions enabled
- Optional: Connected to cloud device platform (e.g., BrowserStack)

---

## 🔁 CI/CD Pipeline Configuration  
[`appium-ci.yml`](https://github.com/NeethuV199/Appium---CI-CD-Integration/blob/main/.github/workflows/appium-ci.yml)


```yaml
name: Appium CI Pipeline

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v3

      - name: Set up Java
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '11'

      - name: Install Node.js and Appium
        run: |
          curl -sL https://deb.nodesource.com/setup_14.x | sudo -E bash -
          sudo apt-get install -y nodejs
          npm install -g appium

      - name: Install Maven Dependencies
        run: mvn install -DskipTests

      - name: Build and run tests
        run: |
          mvn clean install
          mvn test

      - name: Archive test reports
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: surefire-reports
          path: target/surefire-reports/

```
## 🛠️ Troubleshooting

| Issue | Possible Fix |
|-------|--------------|
| Appium not found                 | Ensure Appium is installed globally via `npm install -g appium` |
| Emulator/device not available    | Use a cloud platform (e.g., BrowserStack) or set up a self-hosted runner |
| Allure report not generating     | Make sure Allure plugin is correctly added to `pom.xml` and `mvn test` runs successfully |

```
