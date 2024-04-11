# Customer Relationship Management (CRM)
## Introduction
Welcome to our Customer Relationship Management (CRM) application with integrated security features! This application is designed to help businesses manage their customer relationships effectively while ensuring data security and user authentication.

## Features
- **User Registration:** New users can register for an account.
- **User Authentication:** Secure authentication mechanisms including Basic Auth, JWT, and OAuth2.
- **Role-based Access Control:** Different levels of access based on user roles.
- **Contact Management:** Users can add, update, and delete contacts individually or in bulk.
- **Bulk Upload:** Users can upload a pre-defined format Excel file to save multiple contacts at once.
- **Send SMS:** Users can send SMS messages to individual contacts or groups.
- **Twilio Subaccounts:** Implementation of Twilio subaccounts for each user.

## Technologies Used
- **Spring Boot:** The application is built using the Spring Boot framework.
- **Spring Security:** Provides authentication and authorization features.
- **Twilio API:** Integration for sending SMS messages and managing subaccounts.

## Getting Started
To run the CRM Application and Security Implementation locally, follow these steps:

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/singhkunal30/customer-relationship-management.git
    ```

2. **Configure Database and Twilio API:**
    - Configure the database settings and Twilio API credentials in the respective configuration files.

3. **Build and Run the Application:**
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Access the Application:**
    Open a web browser and navigate to `http://localhost:2002` to access the CRM application.

## Usage
- **User Registration and Authentication:** Register for an account and login securely.
- **Contact Management:** Manage your contacts by adding, updating, or deleting them individually or in bulk.
- **Bulk Upload:** Upload a pre-defined format Excel file to save multiple contacts at once.
- **Send SMS:** Send SMS messages to individual contacts or groups.

## Contributions
Contributions to the development and improvement of this application are welcome! Please feel free to open issues or submit pull requests.

## Contact
For any inquiries or questions about this repository, please feel free to contact us at singhkunal2030@gmail.com.
