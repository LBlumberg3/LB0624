# LB0624 - "KewlTewls"
Example backend API for a POS-esque app for renting larger tools (e.g, a chainsaw or jackhammer). Includes features to establish daily rental charges, employee-authorized discounts, and tracking of various types of tools. See the README for a more complete description

# Explicit Requirements
The tool-rental system `KewlTewls` will follow the below high-level requirements. Other functional / non-functional requirements will be listed in sub-headings, and must align with the entries listed here:

- Customers rent a tool for a specified number of days.
- When a customer checks out a tool, a Rental Agreement is produced.
- The store charges a daily rental fee, whose amount is different for each tool type.
- Some tools are free of charge on weekends or holidays.
- Clerks may give customers a discount that is applied to the total daily charges to reduce the final
charge.
- Tools in the system will have 3 attributes, `Tool Code`, `Tool Type`, and `Brand`. All can be represented by strings
## Holidays
Below are the holidays the system must support
- Independence Day, July 4th - If falls on weekend, it is observed on the closest weekday (if Sat,
then Friday before, if Sunday, then Monday after)
- Labor Day - First Monday in September
## Checkout Process
The process of checking out shall require the below data points
- Tool code
- Rental day count - The number of days for which the customer wants to rent the tool. (e.g. 4
days)
- Discount percent - As a whole number, 0-100 (e.g. 20 = 20%)
- Check out date
### Checkout constraints
- Rental day count is not 1 or greater
- Discount percent is not in the range 0-100

## Rental Agreement
- Tool code - Specified at checkout
- Tool type - From tool info
- Tool brand - From tool info
- Rental days - Specified at checkout
- Check out date - Specified at checkout
- Due date - Calculated from checkout date and rental days.
- Daily rental charge - Amount per day, specified by the tool type.
- Charge days - Count of chargeable days, from day after checkout through and including due
date, excluding “no charge” days as specified by the tool type.
- Pre-discount charge - Calculated as charge days X daily charge. Resulting total rounded half up
to cents.
- Discount percent - Specified at checkout.
- Discount amount - calculated from discount % and pre-discount charge. Resulting amount
rounded half up to cents.
- Final charge - Calculated as pre-discount charge - discount amount.

# Implicit / Added Requirements
The requirements in the earlier section were fetched from an example document; the requirements below are added by the code author to provide further detail for the implementation
- All config items / secrets should be kept in a dedicated `/secrets` folder that **IS NOT** added to the repository history
- All DB queries shall be prepared statements or the equivalent
- All endpoints in the application shall use `application/json` as the content type
- All API endpoints for renting tools or fetching data on tool rentals shall be authenticated by a JWT in the `Authorization` header
- All API endpoints for observability / health-checking shall not require an `Authorization` header
- 
- A new rental shall be created via a `POST` request
- 