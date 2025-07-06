-- EXERCISE1 
-- Table: Customers
CREATE TABLE Customerss (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER,
    balance NUMBER(10, 2),
    IsVIP VARCHAR2(5)
);

-- Table: Loans
CREATE TABLE Loanss (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER REFERENCES Customerss(customer_id),
    interest_rate NUMBER(5, 2),
    due_date DATE
);


-- Insert into Customerss
INSERT INTO Customerss VALUES (1, 'Shanika', 62, 15000, 'FALSE');
INSERT INTO Customerss VALUES (2, 'Subendiran', 25, 9000, 'FALSE');
INSERT INTO Customerss VALUES (3, 'Arun', 70, 20000, 'FALSE');
INSERT INTO Customerss VALUES (4, 'Priya', 30, 10500, 'FALSE');
INSERT INTO Customerss VALUES (5, 'Kiran', 55, 5000, 'FALSE');

-- Insert into Loanss
INSERT INTO Loanss VALUES (101, 1, 9.5, SYSDATE + 15); 
INSERT INTO Loanss VALUES (102, 2, 10.0, SYSDATE + 40); 
INSERT INTO Loanss VALUES (103, 3, 11.0, SYSDATE + 5);  
INSERT INTO Loanss VALUES (104, 4, 8.5, SYSDATE + 60);  
INSERT INTO Loanss VALUES (105, 5, 10.5, SYSDATE + 25); 

-- scenario 1

BEGIN
    FOR cust IN (
        SELECT c.customer_id, c.name, c.age, l.loan_id, l.interest_rate
        FROM Customerss c
        JOIN Loanss l ON c.customer_id = l.customer_id
    ) LOOP
        IF cust.age > 60 THEN
            UPDATE Loanss
            SET interest_rate = interest_rate - 1
            WHERE loan_id = cust.loan_id;

            DBMS_OUTPUT.PUT_LINE('1% discount applied to ' || cust.name);
        END IF;
    END LOOP;
END;
/

--scenario2

BEGIN
    FOR cust IN (
        SELECT customer_id, name, balance FROM Customerss
    ) LOOP
        IF cust.balance > 10000 THEN
            UPDATE Customerss
            SET IsVIP = 'TRUE'
            WHERE customer_id = cust.customer_id;

            DBMS_OUTPUT.PUT_LINE(cust.name || ' marked as VIP');
        END IF;
    END LOOP;
END;
/

--scenario3

BEGIN
    FOR loan IN (
        SELECT l.loan_id, c.name, l.due_date
        FROM Loanss l
        JOIN Customerss c ON l.customer_id = c.customer_id
        WHERE l.due_date <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || loan.name || 
                             ' has a loan due on ' || TO_CHAR(loan.due_date, 'DD-Mon-YYYY'));
    END LOOP;
END;
/