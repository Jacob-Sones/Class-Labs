Java project from Programming II (Spring 2026). Simulates an IT help desk where support tickets are routed to the right level of support based on priority.

- Chain of Responsibility pattern: tickets pass through BasicSupport, TechnicalSupport, and ManagerialSupport until one can handle them
- SupportHandler interface defines handleRequest() and setNextHandler() for every support level
- Priority enum (LOW, MEDIUM, HIGH) decides which handler takes each ticket
- SupportTicket validates its data, rejecting empty descriptions and missing priority levels
- SupportSystemDemo builds the chain and runs three sample tickets through it
