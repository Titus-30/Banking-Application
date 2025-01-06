# Banking Application

## Introduction

This project is a Java-based Banking Application that allows users to interact with different types of accounts, including Savings Accounts, Checking Accounts, and Fixed Deposits. The program showcases various banking operations, such as deposits, withdrawals, balance checks, and loan applications. It emphasizes object-oriented programming principles like inheritance, interfaces, and abstraction.

## Features

### Account Types
- **Savings Account**:
  - Supports deposits and withdrawals.
  - Allows loan applications and provides an interest rate.
- **Checking Account**:
  - Supports deposits and withdrawals with an overdraft limit.
- **Fixed Deposit**:
  - Does not allow deposits or withdrawals before maturity.

### Banking Operations
- Deposit funds into accounts.
- Withdraw funds from accounts (with overdraft support for Checking Accounts).
- Check account balance.
- Apply for loans (Savings Accounts only).
- Check loan application status.

### Extensible Design
- Abstract classes and interfaces enable easy addition of new account types and features.

## Code Structure

### Interfaces
- **`BankingOperations`**: Defines core banking operations (deposit, withdraw, check balance).
- **`LoanEligible`**: Defines methods for loan application and status checks.

### Abstract Class
- **`Account`**:
  - Serves as a base class for all account types.
  - Provides shared properties like account number, holder name, and balance.

### Concrete Account Classes
- **`SavingsAccount1`**: Implements `BankingOperations` and `LoanEligible`.
- **`CheckingAccount1`**: Implements `BankingOperations` and adds overdraft support.
- **`FixedDeposit`**: Implements `BankingOperations` with restrictions on deposits and withdrawals.

### Main Class
- **`BankingApplication`**: Manages user interactions and executes operations based on user input.

## How to Run

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/banking-application.git
   ```

2. Navigate to the project directory:
   ```bash
   cd banking-application
   ```

3. Compile the program:
   ```bash
   javac BankingApplication.java
   ```

4. Run the program:
   ```bash
   java BankingApplication
   ```

5. Follow the on-screen prompts to interact with the accounts.

## Example Usage

1. Select an account type (e.g., Savings Account).
2. Display account details.
3. Perform operations like depositing or withdrawing funds, or checking the balance.
4. If applicable, apply for a loan and check its status.

## Key Concepts Demonstrated

### Object-Oriented Programming
- Inheritance and polymorphism through abstract classes and interfaces.

### Encapsulation
- Secure and organized management of account data.

### Interfaces
- Extensible design for implementing specific functionalities like loans.

### User Interaction
- Console-based inputs to simulate real-world banking scenarios.

## Future Enhancements

### Planned Features
- Add support for recurring deposits and term deposits.
- Implement account statement generation.
- Introduce secure authentication for account access.
- Develop a graphical user interface (GUI) for enhanced user experience.
- Integrate a database for persistent account management.

## Contribution

Contributions are welcome! Fork this repository and submit pull requests with new features or enhancements.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

