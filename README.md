# Babysitter_Kata

Kata taken from https://github.com/PillarTechnology/kata-babysitter

## Requirements

The babysitter:

- Starts no earlier than 5:00PM
- Leaves no later than 4:00AM
- Only babysits for one family per night
- Gets paid for full hours

The job:

- Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night
- Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night
- Family C pays $21 per hour before 9pm, then $15 the rest of the night

## Walkthrough of solution

- The solution will take 3 inputs
	1. Babysitter start time
	2. Babysitter end time 
	3. Family the babysitter is working for (A, B, C)
- The solution will convert the input time into 24 hour format (i.e. military time)
- The solution will validate times and family input prior to executing any calculation.
- The solution will then calculate the hours worked for the selected family. Each family has different rates:
	1. Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night
	2. Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night
	3. Family C pays $21 per hour before 9pm, then $15 the rest of the night
- The solution will then return the total amount owed to the babysitter.
# THIS-IS-A-SECOND-TEST
