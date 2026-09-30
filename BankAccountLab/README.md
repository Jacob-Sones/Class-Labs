Java group project from Programming II (Spring 2026). Models a bank with savings, checking, and CD savings accounts that support deposits, withdrawals, transfers, and interest calculations.

My contributions (Jacob Sones):
- CDSavingsAccount: fixed interest rate, term length, automatic maturity date using LocalDate, and an early withdrawal penalty
- SavingAccount: interest rate, monthly withdrawal limit, transfer limit, and money transfers
- MainDriver: creates every account type, groups them in an AccountPortfolio, and tests valid and invalid inputs with try-catch

Teammate contributions:
- Quinton Hardman: BankAccount base class, BankActions and CalculateAnnualInterest interfaces
- Elijah Jones: CheckingAccount (overdraft protection and transaction limits) and AccountPortfolio (Composite pattern)
