-- EXERCISE2

-- Accounts table for interest and fund transfer
CREATE TABLE Accounts (
    account_id NUMBER PRIMARY KEY,
    account_type VARCHAR2(20),
    customer_id NUMBER,
    balance NUMBER(10, 2)
);

-- Employees table for bonus
CREATE TABLE Employees (
    emp_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER(10, 2)
);


-- Sample Data for Accounts
INSERT INTO Accounts VALUES (1001, 'savings', 1, 15000);  -- Shanika
INSERT INTO Accounts VALUES (1002, 'current', 2, 20000);  -- Subendiran
INSERT INTO Accounts VALUES (1003, 'savings', 3, 12000);  -- Arun
INSERT INTO Accounts VALUES (1004, 'current', 4, 18000);  -- Priya
INSERT INTO Accounts VALUES (1005, 'savings', 5, 9000);   -- Kiran

-- Sample Data for Employees
INSERT INTO Employees VALUES (1, 'Shanika', 'HR', 50000);
INSERT INTO Employees VALUES (2, 'Subendiran', 'IT', 65000);
INSERT INTO Employees VALUES (3, 'Arun', 'HR', 55000);
INSERT INTO Employees VALUES (4, 'Priya', 'Finance', 60000);
INSERT INTO Employees VALUES (5, 'Kiran', 'IT', 70000);


-- scenario1

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc IN (
        SELECT account_id, balance
        FROM Accounts
        WHERE LOWER(account_type) = 'savings'
    ) LOOP
        UPDATE Accounts
        SET balance = acc.balance * 1.01
        WHERE account_id = acc.account_id;

        DBMS_OUTPUT.PUT_LINE('Interest added for Account ID: ' || acc.account_id);
    END LOOP;
END;
/


-- scenario2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) IS
BEGIN
    FOR emp IN (
        SELECT emp_id, salary FROM Employees WHERE department = dept_name
    ) LOOP
        UPDATE Employees
        SET salary = emp.salary + (emp.salary * bonus_percent / 100)
        WHERE emp_id = emp.emp_id;

        DBMS_OUTPUT.PUT_LINE('Bonus added to Employee ID: ' || emp.emp_id);
    END LOOP;
END;
/


-- scenario3


CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc IN NUMBER,
    to_acc IN NUMBER,
    amount IN NUMBER
) IS
    from_balance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT balance INTO from_balance
    FROM Accounts
    WHERE account_id = from_acc;

    IF from_balance < amount THEN
        DBMS_OUTPUT.PUT_LINE('❌ Insufficient balance in Account ID: ' || from_acc);
    ELSE
        -- Deduct from source
        UPDATE Accounts
        SET balance = balance - amount
        WHERE account_id = from_acc;

        -- Add to destination
        UPDATE Accounts
        SET balance = balance + amount
        WHERE account_id = to_acc;

        DBMS_OUTPUT.PUT_LINE('✅ ₹' || amount || ' transferred from ' || from_acc || ' to ' || to_acc);
    END IF;
END;
/

-- to call scenario1

BEGIN
    ProcessMonthlyInterest;
END;
/
--to call scenario2

BEGIN
    UpdateEmployeeBonus('HR', 10);
END;
/
--to call scenario3

BEGIN
    TransferFunds(1001, 1002, 2000);
END;
/